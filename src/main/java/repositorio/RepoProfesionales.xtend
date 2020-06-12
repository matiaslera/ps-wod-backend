package repositorio

import domain.Profesional
import java.util.ArrayList
import java.util.List
import domain.Presupuesto

class RepoProfesionales extends AbstractRepository <Profesional>{

	static RepoProfesionales repoProfesionales

	def static RepoProfesionales getInstance() {
		if (repoProfesionales === null) {
			repoProfesionales = new RepoProfesionales
		}
		repoProfesionales
	}

	List<Profesional> profesionales = new ArrayList

	def enviarNotificacionDePresupuesto(Presupuesto problema) {
		profesionales.forEach [ profesional |
			if (profesional.profesion.equals(problema.especialidad)) {
				profesional.agregarPresupuesto(problema)
			}
		]
	}

	def List<Profesional> busquedaPorProfesion(String profesion) {
		profesionales.filter(profesional|profesional.profesion.equals(profesion)).toList
	}

	def List<Profesional> busquedaPorZona(String zona) {
		profesionales.filter(profesional|profesional.zonaDeTrabajo.equals(zona)).toList
	}

	def List<Profesional> busquedaPorNombreYApellido(String nombre) {
		profesionales.filter(profesional|profesional.nombreyApellido.equals(nombre)).toList
	}
	
	override getEntityType() {
		Profesional
	}

}
