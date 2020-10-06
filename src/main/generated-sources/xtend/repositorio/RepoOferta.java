package repositorio;

import domain.Oferta;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.hibernate.HibernateException;
import repositorio.AbstractRepository;
import repositorio.RepoClientes;

@SuppressWarnings("all")
public class RepoOferta extends AbstractRepository<Oferta> {
  private static RepoClientes instances;
  
  public static RepoClientes getInstance() {
    RepoClientes _xblockexpression = null;
    {
      if ((RepoOferta.instances == null)) {
        RepoClientes _repoClientes = new RepoClientes();
        RepoOferta.instances = _repoClientes;
      }
      _xblockexpression = RepoOferta.instances;
    }
    return _xblockexpression;
  }
  
  public Class<Oferta> getTipoEntidad() {
    return Oferta.class;
  }
  
  public Oferta searchById(final Long id) {
    Oferta _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      Oferta _xtrycatchfinallyexpression = null;
      try {
        Oferta _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Oferta> query = criteria.<Oferta>createQuery(this.getTipoEntidad());
          final Root<Oferta> _User = query.<Oferta>from(this.getTipoEntidad());
          query.select(_User);
          query.where(criteria.equal(_User.<Object>get("id"), id));
          _xblockexpression_1 = entityManager.<Oferta>createQuery(query).getSingleResult();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion de la oferta consultada.", e);
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
  
  public Oferta searchByIdUser(final String id) {
    Oferta _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      Oferta _xtrycatchfinallyexpression = null;
      try {
        Oferta _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Oferta> query = criteria.<Oferta>createQuery(this.getTipoEntidad());
          final Root<Oferta> _User = query.<Oferta>from(this.getTipoEntidad());
          query.select(_User);
          query.where(criteria.equal(_User.<Object>get("idUsuario"), id));
          _xblockexpression_1 = entityManager.<Oferta>createQuery(query).getSingleResult();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion de la oferta consultada.", e);
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
  
  public void generateWhere(final CriteriaBuilder criteria, final CriteriaQuery<Oferta> query, final Root<Oferta> camposCandidato, final Oferta user) {
    Long _id = user.getId();
    boolean _tripleEquals = (_id == null);
    if (_tripleEquals) {
      query.where(criteria.equal(camposCandidato.<Object>get("id"), user.getId()));
    }
  }
}
