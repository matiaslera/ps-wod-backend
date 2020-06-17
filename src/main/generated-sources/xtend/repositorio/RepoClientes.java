package repositorio;

import domain.Cliente;
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
  
  public Class<Cliente> getEntityType() {
    return Cliente.class;
  }
  
  public void generateWhere(final CriteriaBuilder criteria, final CriteriaQuery<Cliente> query, final Root<Cliente> camposCandidato, final Cliente user) {
    String _usuario = user.getUsuario();
    boolean _tripleNotEquals = (_usuario != null);
    if (_tripleNotEquals) {
      query.where(criteria.equal(camposCandidato.<Object>get("id"), user.getId()));
    }
  }
  
  public Cliente searchById(final Long id) {
    Cliente _xblockexpression = null;
    {
      final EntityManager entityManager = this.getEntityManager();
      Cliente _xtrycatchfinallyexpression = null;
      try {
        Cliente _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Cliente> query = criteria.<Cliente>createQuery(this.getEntityType());
          final Root<Cliente> _User = query.<Cliente>from(this.getEntityType());
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
      final EntityManager entityManager = this.getEntityManager();
      Cliente _xtrycatchfinallyexpression = null;
      try {
        Cliente _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Cliente> query = criteria.<Cliente>createQuery(this.getEntityType());
          final Root<Cliente> _User = query.<Cliente>from(this.getEntityType());
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
}
