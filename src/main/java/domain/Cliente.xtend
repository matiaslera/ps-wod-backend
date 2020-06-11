package domain

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import repositorio.RepoPresupuestos
import repositorio.RepoProfesionales

@Accessors
class Cliente extends Usuario {

	String direccion

	def List<Presupuesto> obtenerPresupuesto(Presupuesto problema) {
		RepoPresupuestos.instance.buscarPresupuesto(problema)
	}

	def void enviarNotificacionPresupuesto(Presupuesto problema) {
		RepoProfesionales.instance.enviarNotificacionDePresupuesto(problema)
	}

	def void seleccionarTurno() {
		
	}

}
