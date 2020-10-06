package domain

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Embeddable
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable
import repositorio.RepoChats

//import serializacion.LocalDateTimePersistenceConverter
//import serializacion.LocalDatePersistenceConverter

@Observable
//@Entity
//@Table(name="Usuario")
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="TIPO_USER", discriminatorType=DiscriminatorType.STRING)
@Embeddable
@Accessors
class Usuario implements Serializable {
	
	@Column(length=50, name="id_user")
	String uid

	@Column(length=50)
	String nombre
	
	@Column(length=50)
	String apellido
	
	@Column(name="correo")
	String email
	
	@Column(length=50)
	int dni

	LocalDate fechaDeNacimiento

	@Column(length=20)
	int telefono
	
	@Column(length=50)
	String fotoUrl
	
	@Column(length=50)
	String proveedor =null
	
	new (){	
	}
	
	def void enviarChat(Chat chat) {
		RepoChats.instance.persistirChat(chat)
	}

	override toString() {
		"id: " + uid + " nombre: " + nombre  + " apellido: " + apellido
	}
}
