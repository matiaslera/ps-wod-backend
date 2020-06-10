package repositorio

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.ArrayList
import java.util.List
import domain.Presupuesto
import exceptions.BusinessException

@Accessors
class RepoPresupuestos {

	static RepoPresupuestos repoPresupuestos

	def static RepoPresupuestos getInstance() {
		if (repoPresupuestos === null) {
			repoPresupuestos = new RepoPresupuestos
		}
		repoPresupuestos
	}

	List<Presupuesto> presupuestos = new ArrayList

	def void persistirPresupuesto(Presupuesto presupuesto) {
		presupuestos.add(presupuesto)
	}

	def List<Presupuesto> buscarPresupuesto(Presupuesto problema) {
		var filtroProfesional = (this.filtrarPresupuestoPorProfesion(problema))
		var filtro = filtroProfesional.filter([p|p.descripcion.contains(problema.descripcion)])
		if (filtro.isEmpty) {
			throw new BusinessException("No se encontro presupuesto para el problema")
		}
		else{
			return (filtro).toList
		}
	}

	def List<Presupuesto> filtrarPresupuestoPorProfesion(Presupuesto problema) {
		(presupuestos.filter[p|p.especialidad.equals(problema.especialidad)]).toList
	}

}
