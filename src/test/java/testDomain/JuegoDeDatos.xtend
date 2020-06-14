package testDomain

import domain.Cliente
import domain.Profesional
import java.time.LocalDate
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class JuegoDeDatos {

	Cliente jose
	Profesional daniel

	def void inicializarDatos() {
		jose = new Cliente => [
			usuario = "josep"
			contrasenia = "12345"
			nombreyApellido = "Jose Gimenez"
		//	dni = "94562345"
			direccion = "Juan B. Justo 2734"
			fechaDeNacimiento = LocalDate.of(1990, 06, 15)
		//	telefono = "34652817"

		]

		daniel = new Profesional => [
			usuario = "dani"
			contrasenia = "2468"
			nombreyApellido = "Danel Ruiz"
		//	dni = "45621356"
			fechaDeNacimiento = LocalDate.of(1980, 08, 27);
		//	telefono = "45621367"
			profesion = "ElectricistaElectricista"
			titulosObtenidos = "Técnico superior"
			experienciaLaboral = "mantenimiento en UNSAM"
			zonaDeTrabajo = "San Martin"
		]
	}
}
