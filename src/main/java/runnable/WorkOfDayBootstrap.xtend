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
	Usuario usuario6
	Usuario usuario7
	Usuario usuario8
	Usuario usuario9
	Usuario usuario10
	
	
	
	Presupuesto presupuesto1
	Presupuesto presupuesto2
	Presupuesto presupuesto3
	Presupuesto presupuesto4
	Presupuesto presupuesto5
	Presupuesto presupuesto6
	Presupuesto presupuesto7
	Presupuesto presupuesto8
	Presupuesto presupuesto9
	Presupuesto presupuesto10
	Presupuesto presupuesto11
	Presupuesto presupuesto12
	
						
	
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
		usuario6 = new Cliente() => [
			usuario = "user6"
			contrasenia = "user6"
			nombreyApellido = "Ariana Grande"
			dni = 3720011
			telefono = 1500601445
			
		]
		usuario7 = new Profesional() => [
			usuario = "user7"
			contrasenia = "user7"
			nombreyApellido = "Hanna Baker"
			dni = 37200188
			telefono = 1500601445
		]
		usuario8 = new Cliente() => [
			usuario = "user8"
			contrasenia = "user8"
			nombreyApellido = "Noel steven"
			dni = 37200195
			telefono = 1500601474
		]
		usuario9 = new Profesional() => [
			usuario = "user9"
			contrasenia = "user9"
			nombreyApellido = "Bartolito Finn"
			dni = 37200123
			telefono = 1500601474
		]
		usuario10 = new Cliente() => [
			usuario = "user10"
			contrasenia = "user10"
			nombreyApellido = "Drew jensen"
			dni = 37200185
			telefono = 15006014
		]
		
		this.createUser(usuario)
		this.createUser(usuario1)
		this.createUser(usuario2)
		this.createUser(usuario3)
		this.createUser(usuario4)
		this.createUser(usuario5)
		this.createUser(usuario6)
		this.createUser(usuario7)
		this.createUser(usuario8)
		this.createUser(usuario9)
		this.createUser(usuario10)
		

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
			direccion = "Santa Rosa 2720"
			notas = ""
			monto = 5000
			fecha = LocalDate.of(2017, 02, 10)
		]

		presupuesto4 = new Presupuesto => [
			especialidad = "Electricidad"
			nombre="instalacion de cables "
			descripcion = "instalacion de cables por bandeja desde el 1 hasta 3 el piso"
		    direccion = "Avenina siempre viva 1234"
			notas = ""
			monto = 6000
			fecha = LocalDate.of(2016, 02, 10)
		]
		presupuesto5 = new Presupuesto => [
			especialidad = "Herreria"
			nombre="Soldadura de Rejas "
			descripcion = "Soldadura de rejas para ventanas"
			direccion = "adrogue 6145"
			notas = ""
			monto = 10000
			fecha = LocalDate.of(2016, 03, 10)
		]
		
		presupuesto6 = new Presupuesto => [
			especialidad = "Herreria"
			nombre="soldadura de estructuras "
			descripcion = "soldar una estructura para escaleras de planta baja al primer piso "
			direccion = "cordoba 2773"
			notas = ""
			monto = 16000
			fecha = LocalDate.of(2016, 02, 10)
		]
		presupuesto7 = new Presupuesto => [
			especialidad = "Gasista"
			nombre="cambio de caños "
			descripcion = "se cambian caños por caños fisurados"
			direccion = "cerrito 6969"
			notas = ""
			monto = 12000
			fecha = LocalDate.of(2017, 05, 10)
		]
		presupuesto8 = new Presupuesto => [
			especialidad = "Gasista"
			nombre="instalacion de termotanque "
			descripcion = "instalacion de un termotanque en planta baja"
			direccion = "mendoza 5489"
			notas = ""
			monto = 18000
			fecha = LocalDate.of(2016, 02, 10)
		]
		presupuesto9 = new Presupuesto => [
			especialidad = "Carpinteria"
			nombre="restauracion "
			descripcion = "se restaura una mesa antiguaa , se cambian tornillos y se pinta"
			direccion = "avenida santa fe 4720"
			notas = ""
			monto = 5000
			fecha = LocalDate.of(2018, 12, 10)
		]
		presupuesto10 = new Presupuesto => [
			especialidad = "Carpinteria"
			nombre="respaldar de cama "
			descripcion = "se realiza un respaldar a medida con mesa de luz flotante y estacion de carga de celulares"
			direccion = "bondpland 2720"
			notas = ""
			monto = 10000
			fecha = LocalDate.of(2019, 11, 10)
		]
		presupuesto11 = new Presupuesto => [
			especialidad = "Armado en Seco"
			nombre="colocacion de divisiones "
			descripcion = "se coloca una nueva division entre la sala de estar y el comedor"
				direccion = "avenida rivadavia 8752"
			notas = ""
			monto = 20000
			fecha = LocalDate.of(2019, 08, 10)
		]
		presupuesto12 = new Presupuesto => [
			especialidad = "Pintor"
			nombre="paredes exteriores "
			descripcion = "se pintan las paredes exteriores , con una liquido especial , para que tenga durabilidad en la interperie ya sea calor , lluvia o humedad"
			direccion = "rosedal 6348"
			notas = ""
			monto = 35000
			fecha = LocalDate.of(2017, 03, 11)
		]
		
		
		this.createPresupesto(presupuesto1)
		this.createPresupesto(presupuesto2)
		this.createPresupesto(presupuesto3)
		this.createPresupesto(presupuesto4)
		this.createPresupesto(presupuesto5)
		this.createPresupesto(presupuesto6)
		this.createPresupesto(presupuesto7)
		this.createPresupesto(presupuesto8)
		this.createPresupesto(presupuesto9)
		this.createPresupesto(presupuesto10)
		this.createPresupesto(presupuesto11)
		this.createPresupesto(presupuesto12)
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
