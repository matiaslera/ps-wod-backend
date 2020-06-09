package domain

import java.time.LocalDate
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Turno {

	Cliente cliente

	Profesional profesional

	LocalDate fecha

	Boolean maniana = false

	Boolean tarde = false

	Boolean noche = false

	Boolean guardia = false

}
