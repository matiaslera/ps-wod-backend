package domain

import java.util.ArrayList
import java.util.List
import java.awt.Image
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Presupuesto {

	String direccion

	String descripcion

	List<Image> fotos = new ArrayList

	Cliente cliente
	
	String especialidad

	String contacto

	String notas

	Double presupuesto

}
