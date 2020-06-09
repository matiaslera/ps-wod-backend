package repositorio

import domain.Presupuesto
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

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

	def void agregarPresupuesto(Presupuesto presupuesto) {
		presupuestos.add(presupuesto)
	}
	
	
}
