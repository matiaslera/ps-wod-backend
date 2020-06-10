package repositorio

import domain.Profesional
import java.util.ArrayList
import java.util.List
import domain.Presupuesto

class RepoProfesionales {

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

}
