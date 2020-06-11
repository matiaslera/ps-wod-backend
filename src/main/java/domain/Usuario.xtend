package domain

import java.awt.Image
import java.time.LocalDate
import org.eclipse.xtend.lib.annotations.Accessors
import repositorio.RepoChats

@Accessors
class Usuario {

	String usuario

	String contrasenia

	String nombreyApellido

	String dni

	LocalDate fechaDeNacimiento

	String telefono

	Image foto

	def void enviarChat(Chat chat) {
		RepoChats.instance.persistirChat(chat)
	}
}
