package runnable

import org.uqbar.arena.bootstrap.Bootstrap
import domain.Cliente
import domain.Profesional
import domain.Usuario
import repositorio.RepoUsuario
import domain.Presupuesto
import java.time.LocalDate
import repositorio.RepoPresupuestos
import repositorio.RepoClientes
import repositorio.SingletonClientes

class WorkOfDayBootstrap implements Bootstrap {

	/*RepoClientes repoCliente = new RepoClientes()*/
	//RepoPresupuestos repoPresupuesto = new RepoPresupuestos()
	
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
	
	Presupuesto finalizado01
	Presupuesto finalizado02					
	
	new() {
		isPending
		run
	}
	
	def void startUsuario() {
		usuario = new Usuario() => [
			apellido = "user"
			nombre = "Jose de San Martin"
			dni = 23001144
			telefono = 1500601478
		]
		usuario1 = new Usuario() => [
			apellido = "user1"
			nombre = "Manuel Belgrano"
			dni = 37200100
			telefono = 1500601473
		]
		usuario2 = new Usuario() => [
			apellido = "user2"
			nombre = "Julio A Roca"
			dni = 25445566
			telefono = 1500601474
		]
		usuario3 = new Usuario() => [
			apellido = "user3"
			nombre = "Bartolome Mitre"
			dni = 25778899
			telefono = 1500601473
		]
		usuario4 = new Usuario() => [
			apellido = "user4"
			nombre = "Carlos Villate"
			dni = 45447788
			telefono = 1500601472
		]
		usuario5 = new Usuario() => [
			apellido = "user5"
			nombre = "Juan Rosas"
			dni = 32996633
			telefono = 1500601471
		]
		usuario6 = new Usuario() => [
			apellido = "user6"
			nombre = "Ariana Grande"
			dni = 3720011
			telefono = 1500601445
		]
		usuario7 = new Usuario() => [
			apellido = "user7"
			nombre = "Hanna Baker"
			dni = 37200188
			telefono = 1500601445
		]
		usuario8 = new Usuario() => [
			apellido = "user8"
			nombre = "Noel steven"
			dni = 37200195
			telefono = 1500601474
			
		]
		usuario9 = new Usuario() => [
			apellido = "user9"
			nombre = "Bartolito Finn"
			dni = 37200123
			telefono = 1500601474
		]
		usuario10 = new Usuario() => [
			apellido = "user10"
			nombre = "Drew jensen"
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
		//this.updateUser(finalizado01,usuario1)
	}

	def createUser(Usuario user) {
		 
		 SingletonClientes.instance.entityManager.transaction.begin
		 user.toString()
		 SingletonClientes.instance.entityManager.persist(user)
		 SingletonClientes.instance.entityManager.transaction.commit
//		val listaUsuarios = repoUser.searchByExample(user)
//		if (listaUsuarios.isEmpty) {
//			repoUser.create(user)
//			println("Candidato user:" + user.usuario + " creado")
//		} else {
//			val vueloBD = listaUsuarios.head
//			user.id = vueloBD.id
//			repoUser.update(user)
//			println("Candidato usuario:" + user.id + " creado")
//		}
	/* 	val repoUsuarios = RepoUsuario.instance
		val listaUsuarios = repoUsuarios.searchByExample(user)//2 lista cliente, profesionales
		if (listaUsuarios.isEmpty) {
			repoUsuarios.create(user)
			println("Candidato user:" + user.apellido + " creado")
		} else {
			val vueloBD = listaUsuarios.head
			user.uid = vueloBD.uid
			repoUsuarios.update(user)
			println("Candidato usuario:" + user.uid + " creado")
		}*/
	}

	def void starPresupuesto(){
		presupuesto1 = new Presupuesto => [
			especialidad = "Electricidad"
			setProblema="cambio de tablero"
			descripcion = "cambio de tablero para una sala de rack informatica primer piso"
			direccion = "Santa Rosalia 2720"
			notas = ""
			contratado= false
			realizado=false
			monto = 3000
			fecha = LocalDate.of(2020, 02, 02)
		]

		presupuesto2 = new Presupuesto => [
			especialidad = "Plomeria"
			setProblema="cambio de caños "
			descripcion = "cambio de caños de agua por 2mm en el lugar del estacionamiento"
			direccion = "Belgrano 2720"
			notas = ""
			contratado= false
			realizado=false
			monto = 5000
			fecha = LocalDate.of(2014, 02, 10)
		]

		presupuesto3 = new Presupuesto => [
			especialidad = "Electricidad"
			setProblema="armar tablero "
			descripcion = "armar tablero de comando para bomba trifasica"
			direccion = "Santa Rosa 2720"
			notas = ""
			contratado= true
			realizado=false
			monto = 5000
			fecha = LocalDate.of(2017, 02, 10)
		]

		presupuesto4 = new Presupuesto => [
			especialidad = "Electricidad"
			setProblema="instalacion de cables "
			descripcion = "instalacion de cables por bandeja desde el 1 hasta 3 el piso"
		    direccion = "Avenina siempre viva 1234"
			notas = ""
			contratado= true
			realizado=true
			monto = 6000
			fecha = LocalDate.of(2016, 02, 10)
		]
		presupuesto5 = new Presupuesto => [
			especialidad = "Herreria"
			setProblema="Soldadura de Rejas "
			descripcion = "Soldadura de rejas para ventanas"
			direccion = "adrogue 6145"
			notas = ""
			contratado= true
			realizado=true
			monto = 10000
			fecha = LocalDate.of(2016, 03, 10)
		]
		
		presupuesto6 = new Presupuesto => [
			especialidad = "Herreria"
			setProblema="soldadura de estructuras "
			descripcion = "soldar una estructura para escaleras de planta baja al primer piso "
			direccion = "cordoba 2773"
			notas = ""
			contratado= true
			realizado=true
			monto = 16000
			fecha = LocalDate.of(2016, 02, 10)
		]
		presupuesto7 = new Presupuesto => [
			especialidad = "Gasista"
			setProblema="cambio de caños "
			descripcion = "se cambian caños por caños fisurados"
			direccion = "cerrito 6969"
			notas = ""
			contratado= true
			realizado=true
			monto = 12000
			fecha = LocalDate.of(2017, 05, 10)
		]
		presupuesto8 = new Presupuesto => [
			especialidad = "Gasista"
			setProblema="instalacion de termotanque "
			descripcion = "instalacion de un termotanque en planta baja"
			direccion = "mendoza 5489"
			notas = ""
			contratado= true
			realizado=true
			monto = 18000
			fecha = LocalDate.of(2016, 02, 10)
		]
		presupuesto9 = new Presupuesto => [
			especialidad = "Carpinteria"
			setProblema="restauracion "
			descripcion = "se restaura una mesa antiguaa , se cambian tornillos y se pinta"
			direccion = "avenida santa fe 4720"
			notas = ""
			contratado= true
			realizado=true
			monto = 5000
			fecha = LocalDate.of(2018, 12, 10)
		]
		presupuesto10 = new Presupuesto => [
			especialidad = "Carpinteria"
			setProblema="respaldar de cama "
			descripcion = "se realiza un respaldar a medida con mesa de luz flotante y estacion de carga de celulares"
			direccion = "bondpland 2720"
			notas = ""
			contratado= true
			realizado=true
			monto = 10000
			fecha = LocalDate.of(2019, 11, 10)
		]
		presupuesto11 = new Presupuesto => [
			especialidad = "Armado en Seco"
			setProblema="colocacion de divisiones "
			descripcion = "se coloca una nueva division entre la sala de estar y el comedor"
				direccion = "avenida rivadavia 8752"
			notas = ""
			contratado= true
			realizado=true
			monto = 20000
			fecha = LocalDate.of(2019, 08, 10)
		]
		presupuesto12 = new Presupuesto => [
			especialidad = "Pintor"
			setProblema="paredes exteriores "
			descripcion = "se pintan las paredes exteriores , con una liquido especial , para que tenga durabilidad en la interperie ya sea calor , lluvia o humedad"
			direccion = "rosedal 6348"
			notas = ""
			contratado= true
			realizado=true
			monto = 35000
			fecha = LocalDate.of(2017, 03, 11)
		]
		
		finalizado01 = new Presupuesto => [
			especialidad = "Electricidad"
			setProblema="instalacion de puesta tierra "
			descripcion = "instalacion de puesta tierra en el estacionamiento del edificio"
		    direccion = "Av. corrientes 1122"
			notas = ""
			contratado= true
			realizado=true
			monto = 7500
			fecha = LocalDate.of(2017, 09, 11)
		]
		
		finalizado02 = new Presupuesto => [
			especialidad = "Electricidad"
			setProblema="instalacion de termica "
			descripcion = "instalacion de termica piso 1 dpto a, b, c"
		    direccion = "Av. cordoba 2000"
			notas = ""
			contratado= false
			realizado=false
			monto = 19500
			fecha = LocalDate.of(2017, 05, 11)
		]
		
		/*this.createPresupesto(presupuesto1)
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
		this.createPresupesto(finalizado01)
		this.createPresupesto(finalizado02)¨*/
	}

	/*def createPresupesto(Presupuesto pres){
		val listaUsuarios = repoPresupuesto.searchByExample(pres)
		if (listaUsuarios.isEmpty) {
			repoPresupuesto.create(pres)
			println("Candidato presupuesto nombre:" + pres.getProblema + " creado")
		} else {
			val vueloBD = listaUsuarios.head
			pres.id = vueloBD.id
			repoPresupuesto.update(pres)
			println("Candidato presupuesto id:" + pres.id + " creado")
		}
	}
	
	
	def updateUser(Presupuesto pres,Cliente cli){
		val listaUsuarios = repoCliente.searchByExample(cli)
		if (listaUsuarios.isEmpty) {
			repoCliente.create(cli)
			println("Candidato presupuesto nombre:" + pres.getProblema + " creado")
		} else {
			cli.addPresupuesto(pres)
			val vueloBD = listaUsuarios.head
			//pres.id = vueloBD.uid
			repoCliente.update(cli)
			println("Cliente actualizado id:" + pres.id + " creado")
		}
	}*/
	
	
	
	override isPending() {
		true
	}
	
	override run() {
		//starPresupuesto
		startUsuario
	}
	
}
