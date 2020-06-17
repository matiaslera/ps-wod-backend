package repositorio;

import com.google.common.base.Objects;
import domain.Cliente;
import domain.Profesional;
import domain.Usuario;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.hibernate.HibernateException;
import repositorio.AbstractRepository;

@SuppressWarnings("all")
public class RepoUsuario extends AbstractRepository<Usuario> {
  private static RepoUsuario instance = null;
  
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
  
  public Class<Usuario> getEntityType() {
    return Usuario.class;
  }
  
  public void generateWhere(final CriteriaBuilder criteria, final CriteriaQuery<Usuario> query, final Root<Usuario> camposCandidato, final Usuario user) {
    String _usuario = user.getUsuario();
    boolean _tripleNotEquals = (_usuario != null);
    if (_tripleNotEquals) {
      query.where(criteria.equal(camposCandidato.<Object>get("id"), user.getId()));
    }
  }
  
  public Usuario searchUserByLogin(final Usuario login) {
    try {
      Usuario _xblockexpression = null;
      {
        final Function1<Usuario, Boolean> _function = new Function1<Usuario, Boolean>() {
          public Boolean apply(final Usuario user) {
            String _usuario = user.getUsuario();
            String _usuario_1 = login.getUsuario();
            return Boolean.valueOf(Objects.equal(_usuario, _usuario_1));
          }
        };
        final Usuario userALogear = IterableExtensions.<Usuario>findFirst(this.allInstances(), _function);
        if ((userALogear == null)) {
          throw new Exception("No existe ningun User con ese Id, por favor intente de nuevo");
        }
        String _contrasenia = userALogear.getContrasenia();
        String _contrasenia_1 = login.getContrasenia();
        boolean _notEquals = (!Objects.equal(_contrasenia, _contrasenia_1));
        if (_notEquals) {
          throw new Exception("Password incorrecto");
        }
        _xblockexpression = userALogear;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Usuario searchById(final Long id) {
    Usuario _xblockexpression = null;
    {
      final EntityManager entityManager = this.getEntityManager();
      Usuario _xtrycatchfinallyexpression = null;
      try {
        Usuario _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Usuario> query = criteria.<Usuario>createQuery(this.getEntityType());
          final Root<Usuario> _User = query.<Usuario>from(this.getEntityType());
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
      final EntityManager entityManager = this.getEntityManager();
      Usuario _xtrycatchfinallyexpression = null;
      try {
        Usuario _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Usuario> query = criteria.<Usuario>createQuery(this.getEntityType());
          final Root<Usuario> _User = query.<Usuario>from(this.getEntityType());
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
  
  public Set<Cliente> getClientes() {
    return null;
  }
  
  public Set<Profesional> getProfesional() {
    return null;
  }
}
