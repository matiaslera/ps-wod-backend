package domain

import java.io.Serializable
import java.util.HashSet
import java.util.Set
import javax.persistence.DiscriminatorValue
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.persistence.Transient
import org.eclipse.xtend.lib.annotations.Accessors
import repositorio.RepoProfesionales

@Accessors
@Entity
@Table(name="Cliente")
@DiscriminatorValue("CLI")
class Cliente implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id
	
	@Embedded
	Usuario usuario
	
	@Transient
	Direccion direccion
	
//	@OneToMany(fetch=FetchType.EAGER)
	@Transient
	Set<Presupuesto> ofertasJob =new HashSet<Presupuesto>()
	
	def void addPresupuesto(Presupuesto presupuesto){
		ofertasJob.add(presupuesto)
	}
	
	def void removePresupuesto(Presupuesto presupuesto){
		ofertasJob.remove(presupuesto)
	}
	
	def Presupuesto encontrarPresupuesto(Presupuesto presupuesto){
		return ofertasJob.filter[pre|pre.equals(presupuesto)].head
	}
	
	def void enviarNotificacionPresupuesto(Presupuesto problema) {
		RepoProfesionales.instance.enviarNotificacionDePresupuesto(problema)
	}

}
