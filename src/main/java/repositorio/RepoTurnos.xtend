package repositorio

import domain.Turno
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class RepoTurnos {

	static RepoTurnos repoTurnos

	def static RepoTurnos getInstance() {
		if (repoTurnos === null) {
			repoTurnos = new RepoTurnos
		}
		repoTurnos
	}

	List<Turno> turnos = new ArrayList

	def void persistirTurno(Turno turno) {
		turnos.add(turno)
	}

}
