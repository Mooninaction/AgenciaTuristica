package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.PaqueteTuristico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Servicio;
import persistencia.exceptions.NonexistentEntityException;

public class ServicioJpaController implements Serializable {

    public ServicioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public ServicioJpaController() {
        emf = Persistence.createEntityManagerFactory("TPFinalPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Servicio servicio) {
        if (servicio.getListaPaquetes() == null)
        {
            servicio.setListaPaquetes(new ArrayList<PaqueteTuristico>());
        }
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PaqueteTuristico> attachedListaPaquetes = new ArrayList<PaqueteTuristico>();
            for (PaqueteTuristico listaPaquetesPaqueteTuristicoToAttach : servicio.getListaPaquetes())
            {
                listaPaquetesPaqueteTuristicoToAttach = em.getReference(listaPaquetesPaqueteTuristicoToAttach.getClass(), listaPaquetesPaqueteTuristicoToAttach.getCodigoPaquete());
                attachedListaPaquetes.add(listaPaquetesPaqueteTuristicoToAttach);
            }
            servicio.setListaPaquetes(attachedListaPaquetes);
            em.persist(servicio);
            for (PaqueteTuristico listaPaquetesPaqueteTuristico : servicio.getListaPaquetes())
            {
                listaPaquetesPaqueteTuristico.getListaServicios().add(servicio);
                listaPaquetesPaqueteTuristico = em.merge(listaPaquetesPaqueteTuristico);
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

    public void edit(Servicio servicio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicio persistentServicio = em.find(Servicio.class, servicio.getCodigoServicio());
            List<PaqueteTuristico> listaPaquetesOld = persistentServicio.getListaPaquetes();
            List<PaqueteTuristico> listaPaquetesNew = servicio.getListaPaquetes();
            List<PaqueteTuristico> attachedListaPaquetesNew = new ArrayList<PaqueteTuristico>();
            for (PaqueteTuristico listaPaquetesNewPaqueteTuristicoToAttach : listaPaquetesNew)
            {
                listaPaquetesNewPaqueteTuristicoToAttach = em.getReference(listaPaquetesNewPaqueteTuristicoToAttach.getClass(), listaPaquetesNewPaqueteTuristicoToAttach.getCodigoPaquete());
                attachedListaPaquetesNew.add(listaPaquetesNewPaqueteTuristicoToAttach);
            }
            listaPaquetesNew = attachedListaPaquetesNew;
            servicio.setListaPaquetes(listaPaquetesNew);
            servicio = em.merge(servicio);
            for (PaqueteTuristico listaPaquetesOldPaqueteTuristico : listaPaquetesOld)
            {
                if (!listaPaquetesNew.contains(listaPaquetesOldPaqueteTuristico))
                {
                    listaPaquetesOldPaqueteTuristico.getListaServicios().remove(servicio);
                    listaPaquetesOldPaqueteTuristico = em.merge(listaPaquetesOldPaqueteTuristico);
                }
            }
            for (PaqueteTuristico listaPaquetesNewPaqueteTuristico : listaPaquetesNew)
            {
                if (!listaPaquetesOld.contains(listaPaquetesNewPaqueteTuristico))
                {
                    listaPaquetesNewPaqueteTuristico.getListaServicios().add(servicio);
                    listaPaquetesNewPaqueteTuristico = em.merge(listaPaquetesNewPaqueteTuristico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex)
        {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0)
            {
                int id = servicio.getCodigoServicio();
                if (findServicio(id) == null)
                {
                    throw new NonexistentEntityException("The servicio with id " + id + " no longer exists.");
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
            Servicio servicio;
            try
            {
                servicio = em.getReference(Servicio.class, id);
                servicio.getCodigoServicio();
            } catch (EntityNotFoundException enfe)
            {
                throw new NonexistentEntityException("The servicio with id " + id + " no longer exists.", enfe);
            }
            List<PaqueteTuristico> listaPaquetes = servicio.getListaPaquetes();
            for (PaqueteTuristico listaPaquetesPaqueteTuristico : listaPaquetes)
            {
                listaPaquetesPaqueteTuristico.getListaServicios().remove(servicio);
                listaPaquetesPaqueteTuristico = em.merge(listaPaquetesPaqueteTuristico);
            }
            em.remove(servicio);
            em.getTransaction().commit();
        } finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public List<Servicio> findServicioEntities() {
        return findServicioEntities(true, -1, -1);
    }

    public List<Servicio> findServicioEntities(int maxResults, int firstResult) {
        return findServicioEntities(false, maxResults, firstResult);
    }

    private List<Servicio> findServicioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try
        {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Servicio.class));
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

    public Servicio findServicio(int id) {
        EntityManager em = getEntityManager();
        try
        {
            return em.find(Servicio.class, id);
        } finally
        {
            em.close();
        }
    }

    public int getServicioCount() {
        EntityManager em = getEntityManager();
        try
        {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Servicio> rt = cq.from(Servicio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally
        {
            em.close();
        }
    }
    
}
