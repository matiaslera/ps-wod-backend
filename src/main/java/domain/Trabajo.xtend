package domain

import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column
import javax.persistence.Entity
import org.eclipse.xtend.lib.annotations.Accessors
import javax.persistence.Table
import javax.persistence.Embedded
import java.time.LocalDate
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.format.DateTimeFormatter
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(name="Trabajo")
@Accessors
class Trabajo {
	
	@Id
	@GeneratedValue
	Long id
	
	@Column(length=50)
	Long idProfesional
	
	@Column(length=50)
	Long idCliente
	
	@Embedded
	Presupuesto presupuesto
	
	@Column(length=50)
	Double montoFinal
	
	@Column(length=10)
	int calificacion
	
	@Column(length=10)
	@JsonIgnore
	LocalDate fechaFinalizacion
	
	@Column
	Estado estado
		
	static String DATE_PATTERN = "yyyy/MM/dd"
	override toString(){
		"este trabajo con id: " + id +" cual es el estado:"+estado + " con el profesional id: "+idProfesional +" con el cliente id: "+idCliente
	}
		
	@JsonProperty("fechaFinalizacion")
	def String fechaFinalizacion() {
		if(this.fechaFinalizacion===null){
			return "null"
		}
		formatter.format(this.fechaFinalizacion)
	}

	@JsonProperty("fechaFinalizacion")
	def void asignarFechaDeFinalizacion(String fecha) {
		if(fecha!==null){
		this.fechaFinalizacion = LocalDate.parse(fecha, formatter)}
	}

	def formatter() {
		DateTimeFormatter.ofPattern(DATE_PATTERN)
	}
	}
	
enum Estado{
	PUBLICADO,
	CONTRATADO,
	FINALIZADO,
	CANCELADO
}