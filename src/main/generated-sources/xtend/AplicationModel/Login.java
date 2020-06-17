package AplicationModel;

import domain.Usuario;
import repositorio.RepoClientes;

@SuppressWarnings("all")
public class Login {
  private RepoClientes repoClientes;
  
  private Usuario login;
  
  public Login() {
    this.repoClientes = RepoClientes.getInstance();
  }
  
  public Object autenticar() {
    return null;
  }
}
