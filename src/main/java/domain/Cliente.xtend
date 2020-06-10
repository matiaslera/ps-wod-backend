package domain

import java.awt.Image
import java.time.LocalDate
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import repositorio.RepoChats
import repositorio.RepoPresupuestos
import repositorio.RepoUsuarios

@Accessors
class Cliente {

	String usuario

	String contrasenia

	String nombreyApellido

	String dni

	String direccion

	LocalDate fechaDeNacimiento

	String telefono

	Image foto

	def void enviarChat(Chat chat) {
		RepoChats.instance.persistirChat(chat)
	}

	def List<Presupuesto> obtenerPresupuesto(Presupuesto problema) {
		RepoPresupuestos.instance.buscarPresupuesto(problema)
	}

	def void enviarNotificacionPresupuesto(Presupuesto problema) {
		RepoUsuarios.instance.enviarNotificacionDePresupuesto(problema)
	}
	
}
