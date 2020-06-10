package domain

import java.awt.Image
import java.time.LocalDate
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Presupuesto {

	String especialidad

	String descripcion

	String direccion

	String notas

	float presupuesto
	
	LocalDate fecha

	List<Image> fotos = new ArrayList
	
}
