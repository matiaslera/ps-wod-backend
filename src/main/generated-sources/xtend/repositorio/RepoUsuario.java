package repositorio;

import com.google.common.base.Objects;
import domain.Cliente;
import domain.Profesional;
import domain.Usuario;
import java.util.Set;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
    String _nombre = user.getNombre();
    boolean _tripleNotEquals = (_nombre != null);
    if (_tripleNotEquals) {
      query.where(criteria.equal(camposCandidato.<Object>get("id"), user.getUid()));
    }
  }
  
  public Usuario searchUserByLogin(final Usuario login) {
    try {
      Usuario _xblockexpression = null;
      {
        final Function1<Usuario, Boolean> _function = new Function1<Usuario, Boolean>() {
          public Boolean apply(final Usuario user) {
            String _nombre = user.getNombre();
            String _nombre_1 = login.getNombre();
            return Boolean.valueOf(Objects.equal(_nombre, _nombre_1));
          }
        };
        final Usuario userALogear = IterableExtensions.<Usuario>findFirst(this.allInstances(), _function);
        if ((userALogear == null)) {
          throw new Exception("No existe ningun User con ese Id, por favor intente de nuevo");
        }
        String _apellido = userALogear.getApellido();
        String _apellido_1 = login.getApellido();
        boolean _notEquals = (!Objects.equal(_apellido, _apellido_1));
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field entityManager is undefined"
      + "\ncriteriaBuilder cannot be resolved"
      + "\ncreateQuery cannot be resolved"
      + "\nfrom cannot be resolved"
      + "\nselect cannot be resolved"
      + "\nwhere cannot be resolved"
      + "\nequal cannot be resolved"
      + "\nget cannot be resolved"
      + "\ncreateQuery cannot be resolved"
      + "\nsingleResult cannot be resolved"
      + "\ntransaction cannot be resolved"
      + "\nrollback cannot be resolved"
      + "\nclose cannot be resolved");
  }
  
  public Usuario searchByIdUser(final String id) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field entityManager is undefined"
      + "\ncriteriaBuilder cannot be resolved"
      + "\ncreateQuery cannot be resolved"
      + "\nfrom cannot be resolved"
      + "\nselect cannot be resolved"
      + "\nwhere cannot be resolved"
      + "\nequal cannot be resolved"
      + "\nget cannot be resolved"
      + "\ncreateQuery cannot be resolved"
      + "\nsingleResult cannot be resolved"
      + "\ntransaction cannot be resolved"
      + "\nrollback cannot be resolved"
      + "\nclose cannot be resolved");
  }
  
  public Set<Cliente> getClientes() {
    return null;
  }
  
  public Set<Profesional> getProfesional() {
    return null;
  }
}
