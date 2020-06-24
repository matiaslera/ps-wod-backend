package repositorio;

import domain.Presupuesto;
import exceptions.BusinessException;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.hibernate.HibernateException;
import repositorio.AbstractRepository;

@Accessors
@SuppressWarnings("all")
public class RepoPresupuestos extends AbstractRepository<Presupuesto> {
  private static RepoPresupuestos instance = null;
  
  public RepoPresupuestos() {
  }
  
  public static RepoPresupuestos getInstance() {
    RepoPresupuestos _xblockexpression = null;
    {
      if ((RepoPresupuestos.instance == null)) {
        RepoPresupuestos _repoPresupuestos = new RepoPresupuestos();
        RepoPresupuestos.instance = _repoPresupuestos;
      }
      _xblockexpression = RepoPresupuestos.instance;
    }
    return _xblockexpression;
  }
  
  public List<Presupuesto> filtrarPresupuestoPorProfesion(final String especialidad) {
    final Function1<Presupuesto, Boolean> _function = new Function1<Presupuesto, Boolean>() {
      public Boolean apply(final Presupuesto p) {
        return Boolean.valueOf((p.getEspecialidad().equals(especialidad) && (p.getMonto() == 0)));
      }
    };
    return IterableExtensions.<Presupuesto>toList(IterableExtensions.<Presupuesto>filter(this.trabajosRealizados(), _function));
  }
  
  public Class<Presupuesto> getEntityType() {
    return Presupuesto.class;
  }
  
  public void generateWhere(final CriteriaBuilder criteria, final CriteriaQuery<Presupuesto> query, final Root<Presupuesto> camposCandidato, final Presupuesto pre) {
    Long _id = pre.getId();
    boolean _tripleEquals = (_id == null);
    if (_tripleEquals) {
      query.where(criteria.equal(camposCandidato.<Object>get("id"), pre.getId()));
    }
  }
  
  public List<Presupuesto> listPorProfesion(final String especialidad) {
    final Function1<Presupuesto, Boolean> _function = new Function1<Presupuesto, Boolean>() {
      public Boolean apply(final Presupuesto p) {
        return Boolean.valueOf((p.getEspecialidad().equals(especialidad) && (p.getMonto() == 0)));
      }
    };
    return IterableExtensions.<Presupuesto>toList(IterableExtensions.<Presupuesto>filter(this.allInstances(), _function));
  }
  
  public Set<Presupuesto> search(final String especialidad, final String nombre) {
    try {
      List<Presupuesto> filtroProfesional = this.filtrarPresupuestoPorProfesion(especialidad);
      final Function1<Presupuesto, Boolean> _function = new Function1<Presupuesto, Boolean>() {
        public Boolean apply(final Presupuesto p) {
          return Boolean.valueOf(p.getDescripcion().contains(nombre));
        }
      };
      Iterable<Presupuesto> listBusqueda = IterableExtensions.<Presupuesto>filter(filtroProfesional, _function);
      boolean _isEmpty = IterableExtensions.isEmpty(listBusqueda);
      if (_isEmpty) {
        throw new BusinessException("No se encontro presupuesto para el problema");
      } else {
        return IterableExtensions.<Presupuesto>toSet(listBusqueda);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public List<Presupuesto> trabajosRealizados() {
    final Function1<Presupuesto, Boolean> _function = new Function1<Presupuesto, Boolean>() {
      public Boolean apply(final Presupuesto p) {
        return Boolean.valueOf(p.isRealizado());
      }
    };
    return IterableExtensions.<Presupuesto>toList(IterableExtensions.<Presupuesto>filter(this.allInstances(), _function));
  }
  
  public Presupuesto searchById(final Long id) {
    Presupuesto _xblockexpression = null;
    {
      final EntityManager entityManager = this.getEntityManager();
      Presupuesto _xtrycatchfinallyexpression = null;
      try {
        Presupuesto _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Presupuesto> query = criteria.<Presupuesto>createQuery(this.getEntityType());
          final Root<Presupuesto> _User = query.<Presupuesto>from(this.getEntityType());
          query.select(_User);
          query.where(criteria.equal(_User.<Object>get("id"), id));
          _xblockexpression_1 = entityManager.<Presupuesto>createQuery(query).getSingleResult();
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
  
  public Presupuesto searchByIdUser(final String id) {
    Presupuesto _xblockexpression = null;
    {
      final EntityManager entityManager = this.getEntityManager();
      Presupuesto _xtrycatchfinallyexpression = null;
      try {
        Presupuesto _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Presupuesto> query = criteria.<Presupuesto>createQuery(this.getEntityType());
          final Root<Presupuesto> _User = query.<Presupuesto>from(this.getEntityType());
          query.select(_User);
          query.where(criteria.equal(_User.<Object>get("idUsuario"), id));
          _xblockexpression_1 = entityManager.<Presupuesto>createQuery(query).getSingleResult();
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
}
