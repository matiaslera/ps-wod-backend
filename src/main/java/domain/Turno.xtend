package domain

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column
import javax.persistence.Embedded
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.format.DateTimeFormatter
import org.eclipse.xtend.lib.annotations.Accessors

@Entity
@Table(name="Turno")
@Accessors
class Turno {

	@Id
	@GeneratedValue
	Long id 
	
	@Column(length=50)
	Long idCliente

	@Column(length=50)
	Long idProfesional
	
	@Column(length=50)
	Double montoFinal
	
	@Column(length=50)
	int calificacion
	
	@Embedded
	Direccion direccion
	
	@Column(length=50)
	LocalDate fechaTrabajo
	
	@Column(length=50)
	String turnoDelDia

	@Column
	Estado estado

	new() {
	}
	
	static String DATE_PATTERN = "yyyy/MM/dd"
	override toString(){
		"este trabajo con id: " + id +" cual es el turno:"+turnoDelDia + " con el profesional id: "+idProfesional +" con el cliente id: "+idCliente
	}
		
	@JsonProperty("fechaTrabajo")
	def String fechaTrabajo() {
		if(this.fechaTrabajo===null){
			return "null"
		}
		formatter.format(this.fechaTrabajo)
	}

	@JsonProperty("fechaTrabajo")
	def void asignarFechaDeTrabajo(String fecha) {
		if(fecha!==null){
		this.fechaTrabajo = LocalDate.parse(fecha, formatter)}
	}

	def formatter() {
		DateTimeFormatter.ofPattern(DATE_PATTERN)
	}


}

