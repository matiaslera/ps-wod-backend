package domain

import org.eclipse.xtend.lib.annotations.Accessors
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.Table
import javax.persistence.DiscriminatorValue
import java.util.Set
import java.util.HashSet
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.CascadeType
import repositorio.RepoProfesionales

@Accessors
@Entity
@Table(name="Cliente")
@DiscriminatorValue("CLI")
class Cliente extends Usuario {
	
	@Column(length=50)
	String direccion
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	Set<Presupuesto> demandaJob =new HashSet<Presupuesto>()
	
	
	def void addPresupuesto(Presupuesto presupuesto){
		demandaJob.add(presupuesto)
	}
	
	def void removePresupuesto(Presupuesto presupuesto){
		demandaJob.remove(presupuesto)
	}
	
	def Presupuesto encontrarPresupuesto(Presupuesto presupuesto){
		return demandaJob.filter[pre|pre.equals(presupuesto)].head
	}
	

	def void enviarNotificacionPresupuesto(Presupuesto problema) {
		RepoProfesionales.instance.enviarNotificacionDePresupuesto(problema)
	}

}
