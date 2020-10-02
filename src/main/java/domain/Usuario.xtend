package domain

import java.util.Calendar
import org.eclipse.xtend.lib.annotations.Accessors
import repositorio.RepoChats
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.GeneratedValue
import org.uqbar.commons.model.annotations.Observable
import javax.persistence.InheritanceType
import javax.persistence.Inheritance
import javax.persistence.DiscriminatorType
import javax.persistence.DiscriminatorColumn
import java.io.Serializable
import javax.persistence.Table
import javax.persistence.GenerationType
import javax.persistence.Temporal
import javax.persistence.TemporalType
import java.util.Date
import javax.persistence.Transient

@Observable
@Entity
@Table(name="Usuario")
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="TIPO_USER", discriminatorType=DiscriminatorType.STRING)
@Accessors
class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id
	
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

	@Temporal(DATE)
	Date fechaDeNacimiento

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
