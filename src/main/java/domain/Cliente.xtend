package domain

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import repositorio.RepoProfesionales
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.Table
import javax.persistence.DiscriminatorValue
import java.util.Set
import javax.persistence.Transient

@Accessors
@Entity
@Table(name="Cliente")
@DiscriminatorValue("CLI")
class Cliente extends Usuario {
	
	@Transient
	RepoProfesionales repoProfesionales = new RepoProfesionales
	
	@Column(length=50)
	String direccion
	
	@Transient
	Set<Presupuesto> consultas =newHashSet
	
	def void addPresupuesto(Presupuesto presupuesto){
		consultas.add(presupuesto)
		this.enviarNotificacionPresupuesto(presupuesto)
	}
	
	def void removePresupuesto(Presupuesto presupuesto){
		consultas.remove(presupuesto)
	}
	
	def Presupuesto encontrarPresupuesto(Presupuesto presupuesto){
		return consultas.filter[pre|pre.equals(presupuesto)].head
	}
	
	def List<Presupuesto> obtenerPresupuesto(Presupuesto problema) {
//		RepoPresupuestos.instance.buscarPresupuesto(problema)
	}

	def void enviarNotificacionPresupuesto(Presupuesto problema) {
		repoProfesionales.enviarNotificacionDePresupuesto(problema)
	}

}
