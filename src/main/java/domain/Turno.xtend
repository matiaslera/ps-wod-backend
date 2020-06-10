package domain

import java.time.LocalDate
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Turno {

	Cliente cliente

	Profesional profesional

	LocalDate fecha

	boolean maniana = false

	boolean tarde = false

	boolean noche = false

	boolean guardia = false

}
