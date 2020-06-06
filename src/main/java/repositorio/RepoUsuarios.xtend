package repositorio

import domain.Cliente
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

	override getEntityType() {
		Cliente
	}

}
