package domain

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import repositorio.RepoPresupuestos
import repositorio.RepoProfesionales
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.Table

@Accessors
@Entity
@Table(name="Cliente")
class Cliente extends Usuario {

	@Column(length=50)
	String direccion

	def List<Presupuesto> obtenerPresupuesto(Presupuesto problema) {
		RepoPresupuestos.instance.buscarPresupuesto(problema)
	}

	def void enviarNotificacionPresupuesto(Presupuesto problema) {
		RepoProfesionales.instance.enviarNotificacionDePresupuesto(problema)
	}

}
