package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.entidades.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Cargo;
import persistencia.exceptions.NonexistentEntityException;

public class CargoJpaController implements Serializable {

    public CargoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public CargoJpaController() {
        emf = Persistence.createEntityManagerFactory("TPFinalPU");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cargo cargo) {
        if (cargo.getListaEmpleados() == null) {
            cargo.setListaEmpleados(new ArrayList<Empleado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Empleado> attachedListaEmpleados = new ArrayList<Empleado>();
            for (Empleado listaEmpleadosEmpleadoToAttach : cargo.getListaEmpleados()) {
                listaEmpleadosEmpleadoToAttach = em.getReference(listaEmpleadosEmpleadoToAttach.getClass(), listaEmpleadosEmpleadoToAttach.getIdEmpleado());
                attachedListaEmpleados.add(listaEmpleadosEmpleadoToAttach);
            }
            cargo.setListaEmpleados(attachedListaEmpleados);
            em.persist(cargo);
            for (Empleado listaEmpleadosEmpleado : cargo.getListaEmpleados()) {
                Cargo oldCargoOfListaEmpleadosEmpleado = listaEmpleadosEmpleado.getCargo();
                listaEmpleadosEmpleado.setCargo(cargo);
                listaEmpleadosEmpleado = em.merge(listaEmpleadosEmpleado);
                if (oldCargoOfListaEmpleadosEmpleado != null) {
                    oldCargoOfListaEmpleadosEmpleado.getListaEmpleados().remove(listaEmpleadosEmpleado);
                    oldCargoOfListaEmpleadosEmpleado = em.merge(oldCargoOfListaEmpleadosEmpleado);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cargo cargo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cargo persistentCargo = em.find(Cargo.class, cargo.getIdCargo());
            List<Empleado> listaEmpleadosOld = persistentCargo.getListaEmpleados();
            List<Empleado> listaEmpleadosNew = cargo.getListaEmpleados();
            List<Empleado> attachedListaEmpleadosNew = new ArrayList<Empleado>();
            for (Empleado listaEmpleadosNewEmpleadoToAttach : listaEmpleadosNew) {
                listaEmpleadosNewEmpleadoToAttach = em.getReference(listaEmpleadosNewEmpleadoToAttach.getClass(), listaEmpleadosNewEmpleadoToAttach.getIdEmpleado());
                attachedListaEmpleadosNew.add(listaEmpleadosNewEmpleadoToAttach);
            }
            listaEmpleadosNew = attachedListaEmpleadosNew;
            cargo.setListaEmpleados(listaEmpleadosNew);
            cargo = em.merge(cargo);
            for (Empleado listaEmpleadosOldEmpleado : listaEmpleadosOld) {
                if (!listaEmpleadosNew.contains(listaEmpleadosOldEmpleado)) {
                    listaEmpleadosOldEmpleado.setCargo(null);
                    listaEmpleadosOldEmpleado = em.merge(listaEmpleadosOldEmpleado);
                }
            }
            for (Empleado listaEmpleadosNewEmpleado : listaEmpleadosNew) {
                if (!listaEmpleadosOld.contains(listaEmpleadosNewEmpleado)) {
                    Cargo oldCargoOfListaEmpleadosNewEmpleado = listaEmpleadosNewEmpleado.getCargo();
                    listaEmpleadosNewEmpleado.setCargo(cargo);
                    listaEmpleadosNewEmpleado = em.merge(listaEmpleadosNewEmpleado);
                    if (oldCargoOfListaEmpleadosNewEmpleado != null && !oldCargoOfListaEmpleadosNewEmpleado.equals(cargo)) {
                        oldCargoOfListaEmpleadosNewEmpleado.getListaEmpleados().remove(listaEmpleadosNewEmpleado);
                        oldCargoOfListaEmpleadosNewEmpleado = em.merge(oldCargoOfListaEmpleadosNewEmpleado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cargo.getIdCargo();
                if (findCargo(id) == null) {
                    throw new NonexistentEntityException("The cargo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cargo cargo;
            try {
                cargo = em.getReference(Cargo.class, id);
                cargo.getIdCargo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cargo with id " + id + " no longer exists.", enfe);
            }
            List<Empleado> listaEmpleados = cargo.getListaEmpleados();
            for (Empleado listaEmpleadosEmpleado : listaEmpleados) {
                listaEmpleadosEmpleado.setCargo(null);
                listaEmpleadosEmpleado = em.merge(listaEmpleadosEmpleado);
            }
            em.remove(cargo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cargo> findCargoEntities() {
        return findCargoEntities(true, -1, -1);
    }

    public List<Cargo> findCargoEntities(int maxResults, int firstResult) {
        return findCargoEntities(false, maxResults, firstResult);
    }

    private List<Cargo> findCargoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cargo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cargo findCargo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cargo.class, id);
        } finally {
            em.close();
        }
    }

    public int getCargoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cargo> rt = cq.from(Cargo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
