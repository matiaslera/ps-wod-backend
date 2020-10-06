package repositorio;

import domain.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.hibernate.HibernateException;
import repositorio.AbstractRepository;

@SuppressWarnings("all")
public class RepoUsuario extends AbstractRepository<Usuario> {
  private static RepoUsuario instance;
  
  public RepoUsuario() {
  }
  
  public static RepoUsuario getInstance() {
    RepoUsuario _xblockexpression = null;
    {
      if ((RepoUsuario.instance == null)) {
        RepoUsuario _repoUsuario = new RepoUsuario();
        RepoUsuario.instance = _repoUsuario;
      }
      _xblockexpression = RepoUsuario.instance;
    }
    return _xblockexpression;
  }
  
  public Class<Usuario> getTipoEntidad() {
    return Usuario.class;
  }
  
  public void generateWhere(final CriteriaBuilder criterio, final CriteriaQuery<Usuario> consulta, final Root<Usuario> camposCandidato, final Usuario user) {
    String _email = user.getEmail();
    boolean _tripleNotEquals = (_email != null);
    if (_tripleNotEquals) {
      consulta.where(criterio.equal(camposCandidato.<Object>get("email"), user.getEmail()));
    }
  }
  
  public Usuario searchById(final Long id) {
    Usuario _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      Usuario _xtrycatchfinallyexpression = null;
      try {
        Usuario _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Usuario> query = criteria.<Usuario>createQuery(this.getTipoEntidad());
          final Root<Usuario> _User = query.<Usuario>from(this.getTipoEntidad());
          query.select(_User);
          query.where(criteria.equal(_User.<Object>get("id"), id));
          _xblockexpression_1 = entityManager.<Usuario>createQuery(query).getSingleResult();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion del user.", e);
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
  
  public Usuario searchByIdUser(final String id) {
    Usuario _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      Usuario _xtrycatchfinallyexpression = null;
      try {
        Usuario _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Usuario> query = criteria.<Usuario>createQuery(this.getTipoEntidad());
          final Root<Usuario> _User = query.<Usuario>from(this.getTipoEntidad());
          query.select(_User);
          query.where(criteria.equal(_User.<Object>get("idUsuario"), id));
          _xblockexpression_1 = entityManager.<Usuario>createQuery(query).getSingleResult();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion del user.", e);
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
