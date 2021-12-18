package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Servicio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.PaqueteTuristico;
import persistencia.exceptions.NonexistentEntityException;

public class PaqueteTuristicoJpaController implements Serializable {

    public PaqueteTuristicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public PaqueteTuristicoJpaController() {
        emf = Persistence.createEntityManagerFactory("TPFinalPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PaqueteTuristico paqueteTuristico) {
        if (paqueteTuristico.getListaServicios() == null)
        {
            paqueteTuristico.setListaServicios(new ArrayList<Servicio>());
        }
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Servicio> attachedListaServicios = new ArrayList<Servicio>();
            for (Servicio listaServiciosServicioToAttach : paqueteTuristico.getListaServicios())
            {
                listaServiciosServicioToAttach = em.getReference(listaServiciosServicioToAttach.getClass(), listaServiciosServicioToAttach.getCodigoServicio());
                attachedListaServicios.add(listaServiciosServicioToAttach);
            }
            paqueteTuristico.setListaServicios(attachedListaServicios);
            em.persist(paqueteTuristico);
            for (Servicio listaServiciosServicio : paqueteTuristico.getListaServicios())
            {
                listaServiciosServicio.getListaPaquetes().add(paqueteTuristico);
                listaServiciosServicio = em.merge(listaServiciosServicio);
            }
            em.getTransaction().commit();
        } finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void edit(PaqueteTuristico paqueteTuristico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            PaqueteTuristico persistentPaqueteTuristico = em.find(PaqueteTuristico.class, paqueteTuristico.getCodigoPaquete());
            List<Servicio> listaServiciosOld = persistentPaqueteTuristico.getListaServicios();
            List<Servicio> listaServiciosNew = paqueteTuristico.getListaServicios();
            List<Servicio> attachedListaServiciosNew = new ArrayList<Servicio>();
            for (Servicio listaServiciosNewServicioToAttach : listaServiciosNew)
            {
                listaServiciosNewServicioToAttach = em.getReference(listaServiciosNewServicioToAttach.getClass(), listaServiciosNewServicioToAttach.getCodigoServicio());
                attachedListaServiciosNew.add(listaServiciosNewServicioToAttach);
            }
            listaServiciosNew = attachedListaServiciosNew;
            paqueteTuristico.setListaServicios(listaServiciosNew);
            paqueteTuristico = em.merge(paqueteTuristico);
            for (Servicio listaServiciosOldServicio : listaServiciosOld)
            {
                if (!listaServiciosNew.contains(listaServiciosOldServicio))
                {
                    listaServiciosOldServicio.getListaPaquetes().remove(paqueteTuristico);
                    listaServiciosOldServicio = em.merge(listaServiciosOldServicio);
                }
            }
            for (Servicio listaServiciosNewServicio : listaServiciosNew)
            {
                if (!listaServiciosOld.contains(listaServiciosNewServicio))
                {
                    listaServiciosNewServicio.getListaPaquetes().add(paqueteTuristico);
                    listaServiciosNewServicio = em.merge(listaServiciosNewServicio);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex)
        {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0)
            {
                int id = paqueteTuristico.getCodigoPaquete();
                if (findPaqueteTuristico(id) == null)
                {
                    throw new NonexistentEntityException("The paqueteTuristico with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            PaqueteTuristico paqueteTuristico;
            try
            {
                paqueteTuristico = em.getReference(PaqueteTuristico.class, id);
                paqueteTuristico.getCodigoPaquete();
            } catch (EntityNotFoundException enfe)
            {
                throw new NonexistentEntityException("The paqueteTuristico with id " + id + " no longer exists.", enfe);
            }
            List<Servicio> listaServicios = paqueteTuristico.getListaServicios();
            for (Servicio listaServiciosServicio : listaServicios)
            {
                listaServiciosServicio.getListaPaquetes().remove(paqueteTuristico);
                listaServiciosServicio = em.merge(listaServiciosServicio);
            }
            em.remove(paqueteTuristico);
            em.getTransaction().commit();
        } finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public List<PaqueteTuristico> findPaqueteTuristicoEntities() {
        return findPaqueteTuristicoEntities(true, -1, -1);
    }

    public List<PaqueteTuristico> findPaqueteTuristicoEntities(int maxResults, int firstResult) {
        return findPaqueteTuristicoEntities(false, maxResults, firstResult);
    }

    private List<PaqueteTuristico> findPaqueteTuristicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try
        {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PaqueteTuristico.class));
            Query q = em.createQuery(cq);
            if (!all)
            {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally
        {
            em.close();
        }
    }

    public PaqueteTuristico findPaqueteTuristico(int id) {
        EntityManager em = getEntityManager();
        try
        {
            return em.find(PaqueteTuristico.class, id);
        } finally
        {
            em.close();
        }
    }

    public int getPaqueteTuristicoCount() {
        EntityManager em = getEntityManager();
        try
        {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PaqueteTuristico> rt = cq.from(PaqueteTuristico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally
        {
            em.close();
        }
    }
    
}
