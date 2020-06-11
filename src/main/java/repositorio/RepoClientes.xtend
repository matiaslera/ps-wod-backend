package repositorio

import domain.Cliente
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import domain.Usuario

@Accessors
class RepoClientes {

	static RepoClientes repoClientes

	def static RepoClientes getInstance() {
		if (repoClientes === null) {
			repoClientes = new RepoClientes
		}
		repoClientes
	}

	List<Cliente> usuarios = new ArrayList

	def void persistirUsuario(Cliente usuario) {
		usuarios.add(usuario)
	}

	def login(Usuario usuario) {
		usuarios.forEach[usu|usu.usuario.equals(usuario)]
	}

}
