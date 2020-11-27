package domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import java.util.Set
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Embedded
import javax.persistence.FetchType
import javax.persistence.OneToMany
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable
import java.time.format.DateTimeFormatter
import com.fasterxml.jackson.annotation.JsonIgnore

@Observable
@Embeddable
@Accessors
class Presupuesto {
	
	@Column(length=50)
	String nombre
	
	@Column(length=50)
	String especialidad
	
	@Column(length=150)
	String descripcion
	
	@Column(length=150)
	String notas
	
	@Embedded
	Direccion direccion
		
	@Column
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonIgnore
	LocalDate fechaCreacion
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonProperty("ofertas")
	Set<Oferta> ofertas ///=new HashSet<Oferta>() 
	
	static String DATE_PATTERN = "yyyy/MM/dd"
	
	def void addOferta(Oferta presupuesto){
		ofertas.add(presupuesto)
	}
	
	def void removeOferta(Oferta presupuesto){
		ofertas.remove(presupuesto)
	}
	
	def Oferta encontrarOferta(Oferta presupuesto){
		return ofertas.filter[pre|pre.equals(presupuesto)].head
	}
	
	override toString(){
	 " nombre: "+ nombre + " especialidad: "+especialidad + " descripcion:" + descripcion
	}
	
	@JsonProperty("fechaCreacion")
	def String fechaNacimiento() {
		formatter.format(this.fechaCreacion)
	}

	@JsonProperty("fechaCreacion")
	def void asignarFechaDeNacimiento(String fecha) {
		if(fecha!==null){
		this.fechaCreacion = LocalDate.parse(fecha, formatter)}
	}

	def formatter() {
		DateTimeFormatter.ofPattern(DATE_PATTERN)
	}
}

	//@JsonFormat(pattern = "YYYY-MM-dd")
	//@JsonSerialize(using=LocalDateSerializer)
	//@JsonDeserialize(using=LocalDateDeserializer)