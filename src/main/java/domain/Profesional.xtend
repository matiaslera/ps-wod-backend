package domain

import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import javax.persistence.Entity
import javax.persistence.Column

@Accessors
@Entity
class Profesional extends Usuario {

	@Column(length=50)
	String profesion

	@Column(length=50)
	String titulosObtenidos

	@Column(length=50)
	String experienciaLaboral

	@Column(length=50)
	String zonaDeTrabajo

	@Column(length=50)
	boolean guardia = false

	List<Presupuesto> presupuestos = new ArrayList

	def void agregarPresupuesto(Presupuesto problema) {
		presupuestos.add(problema)
	}

}
