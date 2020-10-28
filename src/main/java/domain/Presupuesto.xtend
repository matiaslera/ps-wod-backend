package domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import java.util.Set
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany
import org.eclipse.xtend.lib.annotations.Accessors
import javax.persistence.Embedded
import org.uqbar.commons.model.annotations.Observable
import javax.persistence.Embeddable

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
		
	//@JsonFormat(pattern = "YYYY-MM-dd")
	//@JsonSerialize(using=LocalDateSerializer)
	//@JsonDeserialize(using=LocalDateDeserializer)
	@Column
	@JsonFormat(pattern="yyyy-MM-dd")
	LocalDate fechaCreacion
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonProperty("ofertas")
	Set<Oferta> ofertas ///=new HashSet<Oferta>() 
	
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
}
