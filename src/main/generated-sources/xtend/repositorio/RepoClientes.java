package repositorio;

import domain.Cliente;
import domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RepoClientes {
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
  
  private List<Cliente> usuarios = new ArrayList<Cliente>();
  
  public void persistirUsuario(final Cliente usuario) {
    this.usuarios.add(usuario);
  }
  
  public void login(final Usuario usuario) {
    final Consumer<Cliente> _function = new Consumer<Cliente>() {
      public void accept(final Cliente usu) {
        usu.getUsuario().equals(usuario);
      }
    };
    this.usuarios.forEach(_function);
  }
  
  @Pure
  public List<Cliente> getUsuarios() {
    return this.usuarios;
  }
  
  public void setUsuarios(final List<Cliente> usuarios) {
    this.usuarios = usuarios;
  }
}
