package runnable

import org.uqbar.arena.bootstrap.Bootstrap
import domain.Cliente
import domain.Profesional
import domain.Usuario
import repositorio.RepoUsuario
import domain.Presupuesto
import java.time.LocalDate
import repositorio.RepoPresupuestos

class WorkOfDayBootstrap implements Bootstrap {

	RepoUsuario repoUser = new RepoUsuario()
	RepoPresupuestos repoPresupuesto = new RepoPresupuestos()
	
	Usuario usuario
	Usuario usuario1
	Usuario usuario2
	Usuario usuario3
	Usuario usuario4
	Usuario usuario5
	
	Presupuesto presupuesto1
	Presupuesto presupuesto2
	Presupuesto presupuesto3
	Presupuesto presupuesto4
	
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

	def void starPresupuesto(){
			presupuesto1 = new Presupuesto => [
			especialidad = "Electricidad"
			nombre="cambio de tablero"
			descripcion = "cambio de tablero para una sala de rack informatica primer piso"
			direccion = "Santa Rosalia 2720"
			notas = ""
			monto = 3000
			fecha = LocalDate.of(2020, 02, 02)
		]

		presupuesto2 = new Presupuesto => [
			especialidad = "Plomeria"
			nombre="cambio de caños "
			descripcion = "cambio de caños de agua por 2mm en el lugar del estacionamiento"
			direccion = "Belgrano 2720"
			notas = ""
			monto = 5000
			fecha = LocalDate.of(2014, 02, 10)
		]

		presupuesto3 = new Presupuesto => [
			especialidad = "Electricidad"
			nombre="armar tablero "
			descripcion = "armar tablero de comando para bomba trifasica"
		]

		presupuesto4 = new Presupuesto => [
			especialidad = "Electricidad"
			nombre="instalacion de cables "
			descripcion = "instalacion de cables por bandeja desde el 1 hasta 3 el piso"
		]
		
		this.createPresupesto(presupuesto1)
		this.createPresupesto(presupuesto2)
		this.createPresupesto(presupuesto3)
		this.createPresupesto(presupuesto4)
	}

	def createPresupesto(Presupuesto pres){
		val listaUsuarios = repoPresupuesto.searchByExample(pres)
		if (listaUsuarios.isEmpty) {
			repoPresupuesto.create(pres)
			println("Candidato presupuesto nombre:" + pres.nombre + " creado")
		} else {
			val vueloBD = listaUsuarios.head
			pres.id = vueloBD.id
			repoPresupuesto.update(pres)
			println("Candidato presupuesto id:" + pres.id + " creado")
		}
	}

	override isPending() {
		true
	}
	
	override run() {
		startUsuario
		starPresupuesto
	}
	
}
