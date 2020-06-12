package runnable

import org.uqbar.arena.bootstrap.Bootstrap
import domain.Cliente
import java.time.LocalDate
import domain.Profesional
import repositorio.RepoClientes
import repositorio.RepoProfesionales

class WorkOfDayBootstrap implements Bootstrap {

	override run() {
		var jose = new Cliente => [
			usuario = "josep"
			contrasenia = "12345"
			nombreyApellido = "Jose Gimenez"
			dni = "94562345"
			direccion = "Juan B. Justo 2734"
			fechaDeNacimiento = LocalDate.of(1990, 06, 15);
			telefono = "34652817"

		]

		var pepe = new Cliente => [
			usuario = "pepepe"
			contrasenia = "54321"
			nombreyApellido = "Pepe Gonzales"
			dni = "94346213"
			direccion = "Condarco 2734"
			fechaDeNacimiento = LocalDate.of(1985, 03, 25);
			telefono = "34612356"

		]

		var daniel = new Profesional => [
			usuario = "dani"
			contrasenia = "2468"
			nombreyApellido = "Danel Ruiz"
			dni = "45621356"
			fechaDeNacimiento = LocalDate.of(1980, 08, 27);
			telefono = "45621367"

		]

		// lista de clientes para poder persistir mejor 
		val listaClientes = #[jose, pepe]

		// lista de profesionales para poder persistir mejor 
		val listaProfesionales = #[daniel]

		// persistencia de clientes
		listaClientes.forEach[cli|RepoClientes.instance.create(cli)]

		listaProfesionales.forEach[p|RepoProfesionales.instance.create(p)]
	}

	override isPending() {
		true
	}
}
