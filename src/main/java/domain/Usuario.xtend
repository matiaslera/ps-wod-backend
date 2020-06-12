package domain

import java.awt.Image
import java.time.LocalDate
import org.eclipse.xtend.lib.annotations.Accessors
import repositorio.RepoChats
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Column

@Accessors
@Entity
class Usuario {
	
	@Id
	Long id

	@Column(length=50)
	String usuario

	@Column(length=50)
	String contrasenia

	@Column(length=50)
	String nombreyApellido

	@Column(length=50)
	String dni

	LocalDate fechaDeNacimiento

	@Column(length=50)
	String telefono

	Image foto

	def void enviarChat(Chat chat) {
		RepoChats.instance.persistirChat(chat)
	}
}
