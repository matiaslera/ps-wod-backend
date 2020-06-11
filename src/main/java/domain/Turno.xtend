package domain

import java.time.LocalDate
import org.eclipse.xtend.lib.annotations.Accessors
import repositorio.RepoTurnos

@Accessors
class Turno {

	Cliente cliente

	Profesional profesional

	LocalDate fecha

	boolean maniana = false

	boolean tarde = false

	boolean noche = false

	boolean guardia = false

	new(Cliente contratante, Profesional contratado) {
		cliente = contratante
		profesional = contratado
	}

	def void seleccionarTurnoManiana() {
		maniana = true
	}

	def void seleccionarTurnoTarde() {
		tarde = true
	}

	def void seleccionarTurnoNoche() {
		noche = true
	}

	def void seleccionarTurnoGuardia() {
		guardia = true
	}

	def void confirmarTurno() {
		RepoTurnos.instance.persistirTurno(this)
	}

}
