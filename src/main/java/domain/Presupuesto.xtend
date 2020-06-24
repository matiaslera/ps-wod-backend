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

@Entity
@Accessors
class Presupuesto {
	
	@Id
	@GeneratedValue
	Long id
	
	@Column(length=50)
	Long idCreador
	
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
	
	@Column
	LocalDate fecha
	
	//@ManyToOne(fetch=FetchType.EAGER,cascade =CascadeType.ALL)
	//@JoinColumn(name = "PROFESIONAL_ID")
	//Profesional profesional
	
	//@Transient
	//List<Image> fotos = new ArrayList
	
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	Set<Oferta> ofertas =new HashSet<Oferta>()
	
	
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
