package domain

import java.awt.Image
import java.time.LocalDate
import org.eclipse.xtend.lib.annotations.Accessors
import repositorio.RepoChats

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

	def double obtenerPresupuesto() {
	}	
}
