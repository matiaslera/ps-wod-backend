package repositorio

import domain.Cliente
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class RepoUsuarios extends AbstractRepository<Cliente> {

	static RepoUsuarios repoUsuarios

	def static RepoUsuarios getInstance() {
		if (repoUsuarios === null) {
			repoUsuarios = new RepoUsuarios
		}
		repoUsuarios
	}

	List<Cliente> usuarios = new ArrayList

	override getEntityType() {
		Cliente
	}

	def void persistirUsuario(Cliente usuario) {
		usuarios.add(usuario)
	}
	

}
