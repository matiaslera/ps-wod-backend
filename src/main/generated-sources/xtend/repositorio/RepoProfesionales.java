package repositorio;

import domain.Profesional;
import domain.Trabajo;
import java.util.List;
import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.HibernateException;
import repositorio.AbstractRepository;

@SuppressWarnings("all")
public class RepoProfesionales extends AbstractRepository<Profesional> {
  private static RepoProfesionales repoProfesionales;
  
  public static RepoProfesionales getInstance() {
    RepoProfesionales _xblockexpression = null;
    {
      if ((RepoProfesionales.repoProfesionales == null)) {
        RepoProfesionales _repoProfesionales = new RepoProfesionales();
        RepoProfesionales.repoProfesionales = _repoProfesionales;
      }
      _xblockexpression = RepoProfesionales.repoProfesionales;
    }
    return _xblockexpression;
  }
  
  public void enviarNotificacionDePresupuesto(final Trabajo problema) {
    final Consumer<Profesional> _function = new Consumer<Profesional>() {
      public void accept(final Profesional profesional) {
        boolean _equals = profesional.getProfesion().equals(problema.getPresupuesto().getEspecialidad());
        if (_equals) {
          profesional.agregarTrabajo(problema);
          RepoProfesionales.this.update(profesional);
          InputOutput.<String>println(profesional.toString());
        }
      }
    };
    this.allInstances().forEach(_function);
    final Consumer<Profesional> _function_1 = new Consumer<Profesional>() {
      public void accept(final Profesional profesional) {
        RepoProfesionales.this.update(profesional);
      }
    };
    this.allInstances().forEach(_function_1);
  }
  
  public List<Profesional> busquedaPorProfesion(final String profesion) {
    final Function1<Profesional, Boolean> _function = new Function1<Profesional, Boolean>() {
      public Boolean apply(final Profesional profesional) {
        return Boolean.valueOf(profesional.getProfesion().equals(profesion));
      }
    };
    return IterableExtensions.<Profesional>toList(IterableExtensions.<Profesional>filter(this.allInstances(), _function));
  }
  
  public List<Profesional> busquedaPorZona(final String zona) {
    final Function1<Profesional, Boolean> _function = new Function1<Profesional, Boolean>() {
      public Boolean apply(final Profesional profesional) {
        return Boolean.valueOf(profesional.getZonaDeTrabajo().equals(zona));
      }
    };
    return IterableExtensions.<Profesional>toList(IterableExtensions.<Profesional>filter(this.allInstances(), _function));
  }
  
  public List<Profesional> busquedaPorNombreYApellido(final String nombre) {
    final Function1<Profesional, Boolean> _function = new Function1<Profesional, Boolean>() {
      public Boolean apply(final Profesional profesional) {
        return Boolean.valueOf(profesional.getUsuario().equals(nombre));
      }
    };
    return IterableExtensions.<Profesional>toList(IterableExtensions.<Profesional>filter(this.allInstances(), _function));
  }
  
  public Class<Profesional> getTipoEntidad() {
    return Profesional.class;
  }
  
  public void generateWhere(final CriteriaBuilder criteria, final CriteriaQuery<Profesional> query, final Root<Profesional> camposCandidato, final Profesional user) {
    String _nombre = user.getUsuario().getNombre();
    boolean _tripleNotEquals = (_nombre != null);
    if (_tripleNotEquals) {
      query.where(criteria.equal(camposCandidato.<Object>get("id"), user.getId()));
    }
  }
  
  public Profesional searchById(final Long id) {
    Profesional _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      Profesional _xtrycatchfinallyexpression = null;
      try {
        Profesional _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Profesional> query = criteria.<Profesional>createQuery(this.getTipoEntidad());
          final Root<Profesional> _User = query.<Profesional>from(this.getTipoEntidad());
          query.select(_User);
          query.where(criteria.equal(_User.<Object>get("usuario").<Object>get("id"), id));
          _xblockexpression_1 = entityManager.<Profesional>createQuery(query).getSingleResult();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion del profesional.", e);
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
  
  public Profesional searchByEmail(final String email) {
    Profesional _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      Profesional _xtrycatchfinallyexpression = null;
      try {
        Profesional _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Profesional> query = criteria.<Profesional>createQuery(this.getTipoEntidad());
          final Root<Profesional> _User = query.<Profesional>from(this.getTipoEntidad());
          query.select(_User);
          query.where(criteria.equal(_User.<Object>get("usuario").<Object>get("email"), email));
          _xblockexpression_1 = entityManager.<Profesional>createQuery(query).getSingleResult();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof NoResultException) {
          Profesional _profesional = new Profesional();
          final Procedure1<Profesional> _function = new Procedure1<Profesional>() {
            public void apply(final Profesional it) {
              it.setId(Long.valueOf(0));
            }
          };
          return ObjectExtensions.<Profesional>operator_doubleArrow(_profesional, _function);
        } else if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion del profesional.", e);
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
  
  public Profesional searchByIdUser(final String id) {
    Profesional _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      Profesional _xtrycatchfinallyexpression = null;
      try {
        Profesional _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Profesional> query = criteria.<Profesional>createQuery(this.getTipoEntidad());
          final Root<Profesional> _User = query.<Profesional>from(this.getTipoEntidad());
          query.select(_User);
          query.where(criteria.equal(_User.<Object>get("idUsuario"), id));
          _xblockexpression_1 = entityManager.<Profesional>createQuery(query).getSingleResult();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion del profesional.", e);
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
  
  public Profesional ultimoIdProfesional() {
    final EntityManager entityManager = this.getAdministradorEntidad();
    try {
      final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
      final CriteriaQuery<Profesional> query = criteria.<Profesional>createQuery(this.getTipoEntidad());
      final Root<Profesional> _User = query.<Profesional>from(this.getTipoEntidad());
      query.select(_User);
      query.orderBy(criteria.desc(_User.<Object>get("id")));
      final List<Profesional> result = entityManager.<Profesional>createQuery(query).getResultList();
      int _size = result.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        return result.get(0);
      }
    } catch (final Throwable _t) {
      if (_t instanceof HibernateException) {
        final HibernateException e = (HibernateException)_t;
        e.printStackTrace();
        entityManager.getTransaction().rollback();
        throw new RuntimeException("ERROR: La BD no tiene informacion del cliente.", e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      if (entityManager!=null) {
        entityManager.close();
      }
    }
    return null;
  }
}
