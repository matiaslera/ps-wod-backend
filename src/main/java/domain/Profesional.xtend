package domain

import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Profesional extends Usuario {

	String profesion

	String titulosObtenidos

	String experienciaLaboral

	String zonaDeTrabajo

	boolean guardia = false

	List<Presupuesto> presupuestos = new ArrayList

	def void agregarPresupuesto(Presupuesto problema) {
		presupuestos.add(problema)
	}

}
