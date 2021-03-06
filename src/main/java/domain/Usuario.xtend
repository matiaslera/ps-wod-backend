package domain

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Embeddable
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable
import repositorio.RepoChats
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer

//import serializacion.LocalDateTimePersistenceConverter
//import serializacion.LocalDatePersistenceConverter

@Observable
@Embeddable
@Accessors
class Usuario implements Serializable {
	
	@Column
	String uid

	@Column(length=50)
	String nombre
	
	@Column(length=50)
	String apellido
	
	@Column
	String email
	
	@Column
	String nacionalidad
	
	@Column(length=50)
	int dni
	
  //   @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer)
	LocalDate fechaDeNacimiento

	@Column(length=20)
	int telefono
	
	@Column(length=50)
	String fotoUrl
	
	@Column(length=50)
	String proveedor =null
	
	@Column
	Tipo tipo
	
	new (){	}
	
	def void enviarChat(Chat chat) {
		RepoChats.instance.persistirChat(chat)
	}

	override toString() {
		 " nombre: " + nombre  + " apellido: " + apellido +"email: " + email
	}
}

enum Tipo {
	CLIENTE,
	PROFESIONAL
}