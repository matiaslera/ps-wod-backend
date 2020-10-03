package repositorio;

import domain.Cliente;
import domain.Presupuesto;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.hibernate.HibernateException;
import repositorio.AbstractRepository;

@Accessors
@SuppressWarnings("all")
public class RepoClientes extends AbstractRepository<Cliente> {
  private static RepoClientes repoClientes;
  
  public static RepoClientes getInstance() {
    RepoClientes _xblockexpression = null;
    {
      if ((RepoClientes.repoClientes == null)) {
        RepoClientes _repoClientes = new RepoClientes();
        RepoClientes.repoClientes = _repoClientes;
      }
      _xblockexpression = RepoClientes.repoClientes;
    }
    return _xblockexpression;
  }
  
  public Class<Cliente> getTipoEntidad() {
    return Cliente.class;
  }
  
  public void generateWhere(final CriteriaBuilder criteria, final CriteriaQuery<Cliente> query, final Root<Cliente> camposCandidato, final Cliente user) {
    String _nombre = user.getUsuario().getNombre();
    boolean _tripleNotEquals = (_nombre != null);
    if (_tripleNotEquals) {
      query.where(criteria.equal(camposCandidato.<Object>get("id"), user.getUsuario().getUid()));
    }
  }
  
  public Cliente searchById(final Long id) {
    Cliente _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      Cliente _xtrycatchfinallyexpression = null;
      try {
        Cliente _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Cliente> query = criteria.<Cliente>createQuery(this.getTipoEntidad());
          final Root<Cliente> _User = query.<Cliente>from(this.getTipoEntidad());
          query.select(_User);
          query.where(criteria.equal(_User.<Object>get("id"), id));
          _xblockexpression_1 = entityManager.<Cliente>createQuery(query).getSingleResult();
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
  
  public Cliente searchByIdUser(final String id) {
    Cliente _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      Cliente _xtrycatchfinallyexpression = null;
      try {
        Cliente _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Cliente> query = criteria.<Cliente>createQuery(this.getTipoEntidad());
          final Root<Cliente> _User = query.<Cliente>from(this.getTipoEntidad());
          query.select(_User);
          query.where(criteria.equal(_User.<Object>get("idUsuario"), id));
          _xblockexpression_1 = entityManager.<Cliente>createQuery(query).getSingleResult();
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
  
  public Set<Presupuesto> trabajosPendiente(final Long id) {
    final Cliente user = this.searchById(id);
    final Function1<Presupuesto, Boolean> _function = new Function1<Presupuesto, Boolean>() {
      public Boolean apply(final Presupuesto job) {
        return Boolean.valueOf(((job.isContratado() == true) && (job.isRealizado() == false)));
      }
    };
    return IterableExtensions.<Presupuesto>toSet(IterableExtensions.<Presupuesto>filter(user.getDemandaJob(), _function));
  }
  
  public Set<Presupuesto> trabajosFinalizado(final Long id) {
    final Cliente user = this.searchById(id);
    InputOutput.<String>println(user.toString());
    final Function1<Presupuesto, Boolean> _function = new Function1<Presupuesto, Boolean>() {
      public Boolean apply(final Presupuesto job) {
        return Boolean.valueOf(((job.isContratado() == true) && (job.isRealizado() == true)));
      }
    };
    return IterableExtensions.<Presupuesto>toSet(IterableExtensions.<Presupuesto>filter(user.getDemandaJob(), _function));
  }
  
  public Set<Presupuesto> consultasRealizadas(final Long id) {
    final Cliente user = this.searchById(id);
    final Function1<Presupuesto, Boolean> _function = new Function1<Presupuesto, Boolean>() {
      public Boolean apply(final Presupuesto job) {
        return Boolean.valueOf(((job.isContratado() == false) && (job.isRealizado() == false)));
      }
    };
    return IterableExtensions.<Presupuesto>toSet(IterableExtensions.<Presupuesto>filter(user.getDemandaJob(), _function));
  }
}
