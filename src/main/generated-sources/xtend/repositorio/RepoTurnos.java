package repositorio;

import domain.Turno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.hibernate.HibernateException;
import repositorio.AbstractRepository;

@Accessors
@SuppressWarnings("all")
public class RepoTurnos extends AbstractRepository<Turno> {
  private static RepoTurnos instance = null;
  
  public RepoTurnos() {
  }
  
  public static RepoTurnos getInstance() {
    RepoTurnos _xblockexpression = null;
    {
      if ((RepoTurnos.instance == null)) {
        RepoTurnos _repoTurnos = new RepoTurnos();
        RepoTurnos.instance = _repoTurnos;
      }
      _xblockexpression = RepoTurnos.instance;
    }
    return _xblockexpression;
  }
  
  public Class<Turno> getTipoEntidad() {
    return Turno.class;
  }
  
  public void generateWhere(final CriteriaBuilder criterio, final CriteriaQuery<Turno> query, final Root<Turno> camposCandidato, final Turno trabajo) {
    Long _id = trabajo.getId();
    boolean _tripleEquals = (_id == null);
    if (_tripleEquals) {
      query.where(criterio.equal(camposCandidato.<Object>get("id"), trabajo.getId()));
    }
  }
  
  public Turno searchByLongId(final Long id) {
    Turno _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      Turno _xtrycatchfinallyexpression = null;
      try {
        Turno _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Turno> query = criteria.<Turno>createQuery(this.getTipoEntidad());
          final Root<Turno> _User = query.<Turno>from(this.getTipoEntidad());
          query.select(_User);
          query.where(criteria.equal(_User.<Object>get("id"), id));
          _xblockexpression_1 = entityManager.<Turno>createQuery(query).getSingleResult();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion del presupuesto.", e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        if (entityManager!=null) {
          entityManager.close();
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  public Turno searchByStringId(final String id) {
    Turno _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      Turno _xtrycatchfinallyexpression = null;
      try {
        Turno _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Turno> query = criteria.<Turno>createQuery(this.getTipoEntidad());
          final Root<Turno> _User = query.<Turno>from(this.getTipoEntidad());
          query.select(_User);
          query.where(criteria.equal(_User.<Object>get("idUsuario"), id));
          _xblockexpression_1 = entityManager.<Turno>createQuery(query).getSingleResult();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion del presupuesto.", e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        if (entityManager!=null) {
          entityManager.close();
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  public List<Turno> turnosCliente(final Long id) {
    List<Turno> _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      List<Turno> _xtrycatchfinallyexpression = null;
      try {
        List<Turno> _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Turno> query = criteria.<Turno>createQuery(this.getTipoEntidad());
          final Root<Turno> tablaTrabajo = query.<Turno>from(this.getTipoEntidad());
          query.select(tablaTrabajo);
          query.where(criteria.equal(tablaTrabajo.<Object>get("idCliente"), id));
          _xblockexpression_1 = entityManager.<Turno>createQuery(query).getResultList();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion del turno consultado.", e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        if (entityManager!=null) {
          entityManager.close();
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  public List<Turno> turnosProfesional(final Long id) {
    List<Turno> _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      List<Turno> _xtrycatchfinallyexpression = null;
      try {
        List<Turno> _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Turno> query = criteria.<Turno>createQuery(this.getTipoEntidad());
          final Root<Turno> tablaTrabajo = query.<Turno>from(this.getTipoEntidad());
          query.select(tablaTrabajo);
          query.where(criteria.equal(tablaTrabajo.<Object>get("idProfesional"), id));
          _xblockexpression_1 = entityManager.<Turno>createQuery(query).getResultList();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion del turno consultado.", e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        if (entityManager!=null) {
          entityManager.close();
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  public List<Turno> trabajosRealizados() {
    List<Turno> _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      List<Turno> _xtrycatchfinallyexpression = null;
      try {
        List<Turno> _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Turno> query = criteria.<Turno>createQuery(this.getTipoEntidad());
          final Root<Turno> tablaTrabajo = query.<Turno>from(this.getTipoEntidad());
          query.select(tablaTrabajo);
          query.where(criteria.equal(tablaTrabajo.<Object>get("estado"), Integer.valueOf(2)));
          _xblockexpression_1 = entityManager.<Turno>createQuery(query).getResultList();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion del trabajo consultado.", e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        if (entityManager!=null) {
          entityManager.close();
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  public List<Turno> trabajoEspecialidad(final String especialidad) {
    List<Turno> _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      List<Turno> _xtrycatchfinallyexpression = null;
      try {
        List<Turno> _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Turno> query = criteria.<Turno>createQuery(this.getTipoEntidad());
          final Root<Turno> tablaTrabajo = query.<Turno>from(this.getTipoEntidad());
          query.select(tablaTrabajo);
          query.where(criteria.equal(tablaTrabajo.<Object>get("estado"), Integer.valueOf(0)), criteria.and(criteria.equal(tablaTrabajo.<Object>get("presupuesto").<Object>get("especialidad"), especialidad)));
          _xblockexpression_1 = entityManager.<Turno>createQuery(query).getResultList();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion del trabajo consultado.", e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        if (entityManager!=null) {
          entityManager.close();
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  public List<Turno> trabajoContratados(final Long id) {
    List<Turno> _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      List<Turno> _xtrycatchfinallyexpression = null;
      try {
        List<Turno> _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Turno> query = criteria.<Turno>createQuery(this.getTipoEntidad());
          final Root<Turno> tablaTrabajo = query.<Turno>from(this.getTipoEntidad());
          query.select(tablaTrabajo);
          query.where(criteria.equal(tablaTrabajo.<Object>get("estado"), Integer.valueOf(1)), criteria.and(criteria.equal(tablaTrabajo.<Object>get("idCliente"), id)));
          _xblockexpression_1 = entityManager.<Turno>createQuery(query).getResultList();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion del trabajo consultado.", e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        if (entityManager!=null) {
          entityManager.close();
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  public List<Turno> trabajosFinalizados(final Long id) {
    List<Turno> _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      List<Turno> _xtrycatchfinallyexpression = null;
      try {
        List<Turno> _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Turno> query = criteria.<Turno>createQuery(this.getTipoEntidad());
          final Root<Turno> tablaTrabajo = query.<Turno>from(this.getTipoEntidad());
          query.select(tablaTrabajo);
          query.where(criteria.equal(tablaTrabajo.<Object>get("estado"), Integer.valueOf(2)), criteria.and(criteria.equal(tablaTrabajo.<Object>get("idCliente"), id)));
          _xblockexpression_1 = entityManager.<Turno>createQuery(query).getResultList();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion del trabajo consultado.", e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        if (entityManager!=null) {
          entityManager.close();
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
}
