package repositorio

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import domain.Presupuesto
import exceptions.BusinessException
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

@Accessors
class RepoPresupuestos extends AbstractRepository<Presupuesto> {
	
	static RepoPresupuestos instance = null

	 new() {
	}

	static def getInstance() {
		if (instance === null) {
			instance = new RepoPresupuestos
		}
		instance
	}
//	List<Presupuesto> presupuestos = new ArrayList
//
//	def void persistirPresupuesto(Presupuesto presupuesto) {
//		presupuestos.add(presupuesto)
//	}
//
//	def List<Presupuesto> buscarPresupuesto(Presupuesto problema) {
//		var filtroProfesional = (this.filtrarPresupuestoPorProfesion(problema))
//		var filtro = filtroProfesional.filter([p|p.descripcion.contains(problema.descripcion)])
//		if (filtro.isEmpty) {
//			throw new BusinessException("No se encontro presupuesto para el problema")
//		}
//		else{
//			return (filtro).toList
//		}
//	}
//
	def List<Presupuesto> filtrarPresupuestoPorProfesion(String especialidad) {
		(allInstances.filter[p|p.especialidad.equals(especialidad)]).toList
	}
	
	override getEntityType() {
		Presupuesto
	}
	
	override generateWhere(CriteriaBuilder criteria, CriteriaQuery<Presupuesto> query, Root<Presupuesto> camposCandidato, Presupuesto pre) {
		if (pre.id === null) {
			query.where(criteria.equal(camposCandidato.get("id"), pre.id))
			}
	}
	
	def search(String especialidad, String nombre) {
		var filtroProfesional = (this.filtrarPresupuestoPorProfesion(especialidad))
		var listBusqueda = filtroProfesional.filter([p|p.descripcion.contains(nombre)])
		if (listBusqueda.isEmpty) {
			throw new BusinessException("No se encontro presupuesto para el problema")
		}
		else{
			return (listBusqueda).toSet
		}
	}

}
