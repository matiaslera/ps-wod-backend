package repositorio

import domain.Cliente
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import domain.Presupuesto
import domain.Profesional

@Accessors
class RepoUsuarios{

	static RepoUsuarios repoUsuarios

	def static RepoUsuarios getInstance() {
		if (repoUsuarios === null) {
			repoUsuarios = new RepoUsuarios
		}
		repoUsuarios
	}

	List<Cliente> usuarios = new ArrayList

	def void persistirUsuario(Cliente usuario) {
		usuarios.add(usuario)
	}

	def enviarNotificacionDePresupuesto(Presupuesto problema) {
		var filtroDeUsuarios = this.filtrarUsuariosProfesionales
		filtroDeUsuarios.forEach [ usuario |
			if (usuario.profesion.equals(problema.especialidad)) {
				usuario.agregarPresupuesto(problema)
			}
		]
	}

	def List<Profesional> filtrarUsuariosProfesionales() {
		usuarios.map [ usuario |
			if (usuario instanceof Profesional) {
				return usuario
			}
		]
	}

}
