package domain

import java.time.LocalDate
import org.eclipse.xtend.lib.annotations.Accessors
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column
import javax.persistence.Transient
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.FetchType
import javax.persistence.CascadeType
import java.util.HashSet
import java.util.Set
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
//import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.format.DateTimeFormatter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.List

@Entity
@Accessors
class Presupuesto {
	
	@Id
	@GeneratedValue
	Long id
	
	@Column(length=50)
	Long idProfesional
	
	@Column(length=50)
	String problema
	
	@Column(length=50)
	String especialidad
	
	@Column(length=250)
	String descripcion
	
	@Column(length=50)
	String direccion
	
	@Column(length=250)
	String notas
	
	@Column(length=50)
	float monto
	
	@Column
	boolean realizado = false
	
	@Column
	boolean contratado = false
	
	
	//@JsonFormat(pattern = "YYYY-MM-dd")
	@Column
	//@JsonSerialize(using=LocalDateSerializer)
	//@JsonDeserialize(using=LocalDateDeserializer)
	@JsonFormat(pattern="yyyy-MM-dd")
	LocalDate fecha
	
	//@ManyToOne(fetch=FetchType.EAGER,cascade =CascadeType.ALL)
	//@JoinColumn(name = "PROFESIONAL_ID")
	//Profesional profesional
	
	//@Transient @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
	//List<Image> fotos = new ArrayList
	
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonProperty("ofertas")
	Set<Oferta> ofertas ///=new HashSet<Oferta>()
	
	//@Transient
	//@JsonIgnore
	//List<Oferta> X 
	
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
		"id: "+ id + " nombre: "+ problema + " especialidad: "+especialidad
	}
}
