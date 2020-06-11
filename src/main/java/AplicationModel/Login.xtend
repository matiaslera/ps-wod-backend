package AplicationModel

import domain.Usuario
import repositorio.RepoClientes

class Login {
	
	RepoClientes repoClientes

	Usuario login

	new() {
		repoClientes = RepoClientes.instance
		login = new Usuario()
	}

	def autenticar() {
		repoClientes.login(login)
	}
	
}
