package runnable

import domain.Cliente
import domain.Direccion
import domain.Presupuesto
import domain.Profesional
import domain.Trabajo
import domain.Usuario
import java.time.LocalDate
import org.uqbar.arena.bootstrap.Bootstrap
import repositorio.RepoClientes
import repositorio.RepoPresupuestos
import repositorio.RepoProfesionales
import repositorio.RepoTrabajo
import repositorio.RepoUsuario
import domain.Estado

class WorkOfDayBootstrap implements Bootstrap {

	RepoUsuario repoUser = new RepoUsuario()
	RepoClientes repoCliente = new RepoClientes()
	RepoProfesionales repoProfesional = new RepoProfesionales()
	RepoPresupuestos repoPresupuesto = new RepoPresupuestos()
	RepoTrabajo repoTrabajo = new RepoTrabajo()

	Usuario usuario1
	Usuario usuario2
	Usuario usuario3
	Usuario usuario4
	Usuario usuario5
	Usuario usuario6
	Cliente cliente1
	Cliente cliente2
	Cliente cliente3
	Profesional profesional1
	Profesional profesional2
	Profesional profesional3

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

	Presupuesto finalizado01
	Presupuesto finalizado02

	Direccion domicilio1
	Direccion domicilio2
	Direccion domicilio3
	Direccion domicilio4

	Trabajo trabajo1
	Trabajo trabajo2
	Trabajo trabajo3
	Trabajo trabajo4
	Trabajo trabajo5
	Trabajo trabajo6
	Trabajo trabajo7
	Trabajo trabajo8
	Trabajo trabajo9
	Trabajo trabajo10

	new() {
		isPending
		run
	}

	def void startUsuario() {

		usuario1 = new Usuario() => [
			apellido = "user1"
			nombre = "Manuel Belgrano"
			email = "manuelBelgrano@hotmail.com"
			fechaDeNacimiento = LocalDate.of(1995, 02, 15)
			dni = 37200100
			telefono = 1500601473
		]
		usuario2 = new Usuario() => [
			apellido = "user2"
			nombre = "Julio A Roca"
			email = "julioRoca@hotmail.com"
			fechaDeNacimiento = LocalDate.of(1994, 02, 15)
			dni = 25445566
			telefono = 1500601474
		]
		usuario3 = new Usuario() => [
			apellido = "user3"
			nombre = "Bartolome Mitre"
			email = "bartoloMitre@hotmail.com"
			fechaDeNacimiento = LocalDate.of(1993, 02, 15)
			dni = 25778899
			telefono = 1500601473
		]
		usuario4 = new Usuario() => [
			apellido = "user4"
			nombre = "Carlos Villate"
			email = "carlosVillate@hotmail.com"
			fechaDeNacimiento = LocalDate.of(1992, 02, 15)
			dni = 45447788
			telefono = 1500601472
		]
		usuario5 = new Usuario() => [
			apellido = "user5"
			nombre = "Juan Rosas"
			email = "juanRosas@hotmail.com"
			fechaDeNacimiento = LocalDate.of(1991, 02, 15)
			dni = 32996633
			telefono = 1500601471
		]
		usuario6 = new Usuario() => [
			apellido = "user6"
			nombre = "Ariana Grande"
			email = "arianaGrande@hotmail.com"
			fechaDeNacimiento = LocalDate.of(1990, 02, 15)
			dni = 3720011
			telefono = 1500601445
		]
		cliente1 = new Cliente() => [
			usuario = usuario1
		]
		cliente2 = new Cliente() => [
			usuario = usuario2
		]
		cliente3 = new Cliente() => [
			usuario = usuario3
		]
		profesional1 = new Profesional() => [
			usuario = usuario4
		]
		profesional2 = new Profesional() => [
			usuario = usuario5
		]
		profesional3 = new Profesional() => [
			usuario = usuario6
		]
		this.createCliente(cliente1)
		this.createCliente(cliente2)
		this.createCliente(cliente3)
		this.createProfesional(profesional1)
		this.createProfesional(profesional2)
		this.createProfesional(profesional3)
	}

	def createUser(Usuario user) {
		val list = repoUser.searchByExample(user)
		if (list.isEmpty()) {
			repoUser.create(user)
			println("Usuario:" + user.nombre + " creado")
		} else {
			// val vueloBD = list.head
//			user.id = vueloBD.id
			repoUser.update(user)
//			println("Usuario:" + user.id + " actualizado")
		}
	}

	def createCliente(Cliente user) {
		val list = repoCliente.searchByExample(user)
		if (list.isEmpty()) {
			repoCliente.create(user)
			println("Cliente:" + user.usuario.email + " creado")
		} else {
			val vueloBD = list.head
			user.id = vueloBD.id
			repoCliente.update(user)
			println("Cliente:" + user.usuario.email + " actualizado")
		}
	}

	def createProfesional(Profesional user) {
		val list = repoProfesional.searchByExample(user)
		// val prof = repoProfesional.getId(user.id)
		if (list.isEmpty()) {
			repoProfesional.create(user)
			println("Profesional:" + user.usuario.email + " creado")
		} else {
			val vueloBD = list.head
			user.id = vueloBD.id
			repoProfesional.update(user)
			println("Profesional:" + user.usuario.email + " actualizado")
		}
	}

	def void startPresupuesto() {
		presupuesto1 = new Presupuesto => [
			especialidad = "Electricidad"
			nombre = "cambio de tablero"
			descripcion = "cambio de tablero para una sala de rack informatica primer piso"
			direccion = domicilio1
			notas = ""
			fechaCreacion = LocalDate.of(2020, 02, 02)
		]
		presupuesto2 = new Presupuesto => [
			especialidad = "Plomeria"
			nombre = "cambio de caños "
			descripcion = "cambio de caños de agua por 2mm en el lugar del estacionamiento"
			direccion = domicilio2
			notas = ""
			fechaCreacion = LocalDate.of(2014, 02, 10)
		]
		presupuesto3 = new Presupuesto => [
			especialidad = "Electricidad"
			nombre = "armar tablero "
			descripcion = "armar tablero de comando para bomba trifasica"
			direccion = domicilio3
			notas = ""
			fechaCreacion = LocalDate.of(2017, 02, 10)
		]
		presupuesto4 = new Presupuesto => [
			especialidad = "Electricidad"
			nombre = "instalacion de cables "
			descripcion = "instalacion de cables por bandeja desde el 1 hasta 3 el piso"
			direccion = domicilio4
			notas = ""
			fechaCreacion = LocalDate.of(2016, 02, 10)
		]
		presupuesto5 = new Presupuesto => [
			especialidad = "Herreria"
			nombre = "Soldadura de Rejas "
			descripcion = "Soldadura de rejas para ventanas"
			direccion = domicilio1
			notas = ""
			fechaCreacion = LocalDate.of(2016, 03, 10)
		]
		presupuesto6 = new Presupuesto => [
			especialidad = "Herreria"
			nombre = "soldadura de estructuras "
			descripcion = "soldar una estructura para escaleras de planta baja al primer piso "
			direccion = domicilio2
			notas = ""
			fechaCreacion = LocalDate.of(2016, 02, 10)
		]
		presupuesto7 = new Presupuesto => [
			especialidad = "Gasista"
			nombre = "cambio de caños "
			descripcion = "se cambian caños por caños fisurados"
			direccion = domicilio3
			notas = ""
			fechaCreacion = LocalDate.of(2017, 05, 10)
		]
		presupuesto8 = new Presupuesto => [
			especialidad = "Gasista"
			nombre = "instalacion de termotanque "
			descripcion = "instalacion de un termotanque en planta baja"
			direccion = domicilio4
			notas = ""
			fechaCreacion = LocalDate.of(2016, 02, 10)
		]
		presupuesto9 = new Presupuesto => [
			especialidad = "Carpinteria"
			nombre = "restauracion "
			descripcion = "se restaura una mesa antiguaa , se cambian tornillos y se pinta"
			direccion = domicilio1
			notas = ""
			fechaCreacion = LocalDate.of(2018, 12, 10)
		]
		presupuesto10 = new Presupuesto => [
			especialidad = "Carpinteria"
			nombre = "respaldar de cama "
			descripcion = "se realiza un respaldar a medida con mesa de luz flotante y estacion de carga de celulares"
			direccion = domicilio2
			notas = ""
			fechaCreacion = LocalDate.of(2019, 11, 10)
		]
		presupuesto11 = new Presupuesto => [
			especialidad = "Armado en Seco"
			nombre = "colocacion de divisiones "
			descripcion = "se coloca una nueva division entre la sala de estar y el comedor"
			direccion = domicilio3
			notas = ""
			fechaCreacion = LocalDate.of(2019, 08, 10)
		]
		presupuesto12 = new Presupuesto => [
			especialidad = "Pintor"
			nombre = "paredes exteriores "
			descripcion = "se pintan las paredes exteriores , con una liquido especial , para que tenga durabilidad en la interperie ya sea calor , lluvia o humedad"
			direccion = domicilio4
			notas = ""
			fechaCreacion = LocalDate.of(2017, 03, 11)
		]
		finalizado01 = new Presupuesto => [
			especialidad = "Electricidad"
			nombre = "instalacion de puesta tierra "
			descripcion = "instalacion de puesta tierra en el estacionamiento del edificio"
			direccion = domicilio1
			notas = ""
			fechaCreacion = LocalDate.of(2017, 09, 11)
		]
		finalizado02 = new Presupuesto => [
			especialidad = "Electricidad"
			nombre = "instalacion de termica "
			descripcion = "instalacion de termica piso 1 dpto a, b, c"
			direccion = domicilio2
			notas = ""
			fechaCreacion = LocalDate.of(2017, 05, 11)
		]

	}

	def void startDireccion() {
		domicilio1 = new Direccion => [
			provincia = "Buenos Aires"
			ciudad = "San martin"
			codPostal = 1457
			calle = "francia"
			altura = 1234
			pisoDep = "pb"
		]
		domicilio2 = new Direccion => [
			provincia = "Buenos Aires"
			ciudad = "Quilmes"
			codPostal = 1457
			calle = "jujuy"
			altura = 1234
			pisoDep = "pb"
		]
		domicilio3 = new Direccion => [
			provincia = "Buenos Aires"
			ciudad = "Lomas De Zamora"
			codPostal = 1457
			calle = "francia"
			altura = 1234
			pisoDep = "2"
		]
		domicilio4 = new Direccion => [
			provincia = "Buenos Aires"
			ciudad = "Tigre"
			codPostal = 1457
			calle = "italia"
			altura = 1234
			pisoDep = "4 c"
		]

	}

	def void startTrabajo() {
		trabajo1 = new Trabajo => [
			estado = Estado.FINALIZADO
			montoFinal = 300.200
			fechaFinalizacion = LocalDate.of(2020, 02, 02)
			calificacion = 5
			idCliente = 4L
			idProfesional = 4L
			presupuesto = presupuesto1
		]
		trabajo2 = new Trabajo => [
			estado = Estado.FINALIZADO
			montoFinal = 300.200
			calificacion = 5
			idCliente = 1L
			idProfesional = 1L
			presupuesto = presupuesto2
			montoFinal = 5000.23
			fechaFinalizacion = LocalDate.of(2014, 02, 10)
		]
		trabajo3 = new Trabajo => [
			estado = Estado.FINALIZADO
			montoFinal = 300.200
			calificacion = 5
			idCliente = 1L
			idProfesional = 1L
			presupuesto = presupuesto3
			montoFinal = 500.90
			fechaFinalizacion = LocalDate.of(2017, 02, 10)
		]
		trabajo4 = new Trabajo => [
			estado = Estado.FINALIZADO
			montoFinal = 300.200
			fechaFinalizacion = LocalDate.of(2020, 02, 02)
			calificacion = 5
			idCliente = 1L
			idProfesional = 1L
			presupuesto = presupuesto4
			montoFinal = 6000.56
		]
		trabajo5 = new Trabajo => [
			estado = Estado.FINALIZADO
			montoFinal = 300.200
			calificacion = 5
			idCliente = 1L
			idProfesional = 1L
			presupuesto = presupuesto5
			montoFinal = 10000.56
			fechaFinalizacion = LocalDate.of(2016, 03, 10)
		]
		trabajo6 = new Trabajo => [
			estado = Estado.PUBLICADO
			idCliente = 4L
			presupuesto = presupuesto1
		]
		trabajo7 = new Trabajo => [
			estado = Estado.PUBLICADO
			idCliente = 4L
			presupuesto = presupuesto3
		]
		trabajo8 = new Trabajo => [
			estado = Estado.PUBLICADO
			idCliente = 4L
			presupuesto = presupuesto4
		]
		trabajo9 = new Trabajo => [
			estado = Estado.CONTRATADO
			idCliente = 4L
			idProfesional = 4L
			presupuesto = presupuesto3
			montoFinal = 500.90
			fechaFinalizacion = LocalDate.of(2017, 02, 10)
		]
		
		this.createTrabajo(trabajo1)
		this.createTrabajo(trabajo2)
		this.createTrabajo(trabajo3)
		this.createTrabajo(trabajo4)
		this.createTrabajo(trabajo5)
		this.createTrabajo(trabajo6)
		this.createTrabajo(trabajo7)
		this.createTrabajo(trabajo8)
		this.createTrabajo(trabajo9)
	}

	def createPresupuesto(Presupuesto pres) {
		val listaUsuarios = repoPresupuesto.searchByExample(pres)
		if (listaUsuarios.isEmpty) {
			repoPresupuesto.create(pres)
			println("Candidato presupuesto nombre:" + pres.toString() + " creado")
		} else {
			val vueloBD = listaUsuarios.head
			repoPresupuesto.update(pres)
			println("Candidato presupuesto id:" + vueloBD.toString() + " creado")
		}
	}

	def createTrabajo(Trabajo trabajo) {
		val listaUsuarios = repoTrabajo.searchByExample(trabajo)
		if (listaUsuarios.isEmpty) {
			repoTrabajo.create(trabajo)
			println("Candidato presupuesto nombre:" + trabajo.toString() + " creado")
		} else {
			val vueloBD = listaUsuarios.head
			repoTrabajo.update(trabajo)
			println("Candidato presupuesto id:" + vueloBD.id + " creado")
		}
	}

	override isPending() {
		true
	}

	override run() {
		startUsuario
		startDireccion
		startPresupuesto
		startTrabajo
	}

}
