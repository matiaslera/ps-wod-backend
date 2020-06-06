package domain

import java.awt.Image
import java.time.LocalDate
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Cliente {
	
	Long id

	String usuario

	String contrasenia

	String nombreyApellido

	String dni

	String direccion

	LocalDate fechaDeNacimiento 

	String telefono

	Image foto

}
