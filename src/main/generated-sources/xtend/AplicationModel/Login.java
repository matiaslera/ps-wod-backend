package AplicationModel;

import domain.Usuario;
import repositorio.RepoClientes;

@SuppressWarnings("all")
public class Login {
  private RepoClientes repoClientes;
  
  private Usuario login;
  
  public Login() {
    this.repoClientes = RepoClientes.getInstance();
    Usuario _usuario = new Usuario();
    this.login = _usuario;
  }
  
  public void autenticar() {
    this.repoClientes.login(this.login);
  }
}
