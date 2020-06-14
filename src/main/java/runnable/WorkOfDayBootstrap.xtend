package runnable

import org.uqbar.arena.bootstrap.Bootstrap
import domain.Cliente
import domain.Profesional
import domain.Usuario
import repositorio.RepoUsuario

class WorkOfDayBootstrap implements Bootstrap {

	RepoUsuario repoUser = new RepoUsuario()
	
	Usuario usuario
	Usuario usuario1
	Usuario usuario2
	Usuario usuario3
	Usuario usuario4
	Usuario usuario5
	
	
	new() {
		isPending
		run
	}
	
	
	def void startUsuario() {
		usuario = new Cliente() => [
			usuario = "user"
			contrasenia = "user"
			nombreyApellido = "Jose de San Martin"
			dni = 23001144
			telefono = 1500601478
		]
		usuario1 = new Cliente() => [
			usuario = "user1"
			contrasenia = "user1"
			nombreyApellido = "Manuel Belgrano"
			dni = 37200100
			telefono = 1500601473
		]
		usuario2 = new Cliente() => [
			usuario = "user2"
			contrasenia = "user2"
			nombreyApellido = "Julio A Roca"
			dni = 25445566
			telefono = 1500601474
		]
		usuario3 = new Profesional() => [
			usuario = "user3"
			contrasenia = "user3"
			nombreyApellido = "Bartolome Mitre"
			dni = 25778899
			telefono = 1500601473
		]
		usuario4 = new Profesional() => [
			usuario = "user4"
			contrasenia = "user4"
			nombreyApellido = "Carlos Villate"
			dni = 45447788
			telefono = 1500601472
		]
		usuario5 = new Profesional() => [
			usuario = "user5"
			contrasenia = "user5"
			nombreyApellido = "Juan Rosas"
			dni = 32996633
			telefono = 1500601471
		]

		this.createUser(usuario)
		this.createUser(usuario1)
		this.createUser(usuario2)
		this.createUser(usuario3)
		this.createUser(usuario4)
		this.createUser(usuario5)

	}

	def createUser(Usuario user) {
		val listaUsuarios = repoUser.searchByExample(user)
		if (listaUsuarios.isEmpty) {
			repoUser.create(user)
			println("Candidato user:" + user.usuario + " creado")
		} else {
			val vueloBD = listaUsuarios.head
			user.id = vueloBD.id
			repoUser.update(user)
			println("Candidato usuario:" + user.id + " creado")
		}
	}

	


//	override run() {
//		var jose = new Cliente => [
//			usuario = "josep"
//			contrasenia = "12345"
//			nombreyApellido = "Jose Gimenez"
//			dni = "94562345"
//			direccion = "Juan B. Justo 2734"
//			fechaDeNacimiento = LocalDate.of(1990, 06, 15);
//			telefono = "34652817"
//
//		]
//
//		var pepe = new Cliente => [
//			usuario = "pepepe"
//			contrasenia = "54321"
//			nombreyApellido = "Pepe Gonzales"
//			dni = "94346213"
//			direccion = "Condarco 2734"
//			fechaDeNacimiento = LocalDate.of(1985, 03, 25);
//			telefono = "34612356"
//
//		]
//
//		var daniel = new Profesional => [
//			usuario = "dani"
//			contrasenia = "2468"
//			nombreyApellido = "Danel Ruiz"
//			dni = "45621356"
//			fechaDeNacimiento = LocalDate.of(1980, 08, 27);
//			telefono = "45621367"
//
//		]
//
//		// lista de clientes para poder persistir mejor 
//		val listaClientes = #[jose, pepe]
//
//		// lista de profesionales para poder persistir mejor 
//		val listaProfesionales = #[daniel]
//
//		// persistencia de clientes
//		listaClientes.forEach[cli|RepoClientes.instance.create(cli)]
//
//		listaProfesionales.forEach[p|RepoProfesionales.instance.create(p)]
//	}

	override isPending() {
		true
	}
	
	override run() {
		startUsuario
	}
	
}
