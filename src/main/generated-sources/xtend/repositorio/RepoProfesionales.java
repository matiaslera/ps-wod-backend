package repositorio;

import domain.Presupuesto;
import domain.Profesional;
import java.util.List;
import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
  
  public void enviarNotificacionDePresupuesto(final Presupuesto problema) {
    final Consumer<Profesional> _function = new Consumer<Profesional>() {
      public void accept(final Profesional profesional) {
        boolean _equals = profesional.getProfesion().equals(problema.getEspecialidad());
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
    Long _id = user.getId();
    boolean _tripleNotEquals = (_id != null);
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
          query.where(criteria.equal(_User.<Object>get("id"), id));
          _xblockexpression_1 = entityManager.<Profesional>createQuery(query).getSingleResult();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
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
          throw new RuntimeException("ERROR: La BD no tiene informacion del cliente.", e);
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
