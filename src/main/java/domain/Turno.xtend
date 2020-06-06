package domain

import java.time.LocalDate
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Turno {
	
	Long id

	Cliente cliente

	Profesional profesional

	LocalDate fecha
}
