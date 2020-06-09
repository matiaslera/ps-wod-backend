package domain

import repositorio.RepoPresupuestos

class Buscador {

	def <Presupuesto> obtenerPresupuesto(Presupuesto problema) {
		this.busquedaPorProfesion(problema.especialidad)
	}

	def <Presupuesto> busquedaPorProfesion(String profesion) {
		RepoPresupuestos.instance.presupuestos.filter[p | p.especialidad.equals(profesion)]
	}
	
	
}
