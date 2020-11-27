package domain

import javax.persistence.Entity
import org.eclipse.xtend.lib.annotations.Accessors
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column
import java.time.LocalDate
//import com.fasterxml.jackson.databind.annotation.JsonSerialize
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.format.DateTimeFormatter
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Accessors
class Oferta {
	
	@Id
	@GeneratedValue
	Long id
	
	@Column(length=50)
	Long idProfesional
	
	@Column(length=150)
	String comentario
	
	@Column(length=100)
	String especialidad
	
	@Column(length=50)
	String nombreProf
	
	@Column(length=50)
	String apellidoProf
	//@JsonSerialize(using=LocalDateSerializer)
	//@JsonDeserialize(using=LocalDateDeserializer)
	@Column(length=250)
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonIgnore
	LocalDate fechaCreacion
	
	@Column(length=50)
	float montoAprox
	
	static String DATE_PATTERN = "yyyy/MM/dd"
	
	override toString(){
		"este es la oferta con id: "+id+ "id del profesional: " + idProfesional +"COMEntario del profe: "+ comentario
	}
	
	@JsonProperty("fechaCreacion")
	def String fechaNacimiento() {
		formatter.format(this.fechaCreacion)
	}

	@JsonProperty("fechaCreacion")
	def void asignarFechaDeNacimiento(String fecha) {
		this.fechaCreacion = LocalDate.parse(fecha, formatter)
	}

	def formatter() {
		DateTimeFormatter.ofPattern(DATE_PATTERN)
	}
	
}
