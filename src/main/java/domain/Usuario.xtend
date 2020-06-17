package domain

import java.awt.Image
import java.time.LocalDate
import org.eclipse.xtend.lib.annotations.Accessors
import repositorio.RepoChats
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Transient
import org.uqbar.commons.model.annotations.Observable
import javax.persistence.InheritanceType
import javax.persistence.Inheritance
import javax.persistence.DiscriminatorType
import javax.persistence.DiscriminatorColumn
import java.io.Serializable

@Observable
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TIPO_USER", discriminatorType=DiscriminatorType.STRING)
@Accessors
abstract class Usuario  implements Serializable {
	
	@Id
	@GeneratedValue
	Long id

	@Column(length=50)
	String usuario

	@Column(length=50)
	String contrasenia

	@Column(length=50)
	String nombreyApellido

	@Column(length=50)
	int dni

	@Column
	LocalDate fechaDeNacimiento

	@Column(length=50)
	int telefono

	@Transient
	Image foto

	def void enviarChat(Chat chat) {
		RepoChats.instance.persistirChat(chat)
	}
	
	override toString(){
		"id: "+ id + "usuario: " + usuario
	}
}
