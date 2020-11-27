package restApi

import org.uqbar.commons.model.exceptions.UserException
import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Delete
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.api.annotation.Post
import org.uqbar.xtrest.api.annotation.Put
import org.uqbar.xtrest.json.JSONUtils
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable
import repositorio.RepoTurnos
import domain.Turno
import domain.Estado

@Controller
class RestControllerTurno {
	
	extension JSONUtils = new JSONUtils
//	RepoProfesionales repoProfesionales = new RepoProfesionales
//	RepoPresupuestos repoPresupuesto = new RepoPresupuestos()
//	RepoOferta repoOferta = new RepoOferta()
	RepoTurnos repoTurnos = new RepoTurnos()
	
	// crea una nuevo turno
	@Post("/create_turno")
	def Result nuevoTurno(@Body String body) {
		println("este es el json recibido" + body)
		try {
			val turno = body.fromJson(Turno)
			if(turno.estado===null){
			turno.estado = Estado.PUBLICADO}
			repoTurnos.create(turno)
			println(turno.toString)
			ok('{ "status" : "OK" }')
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	//Leer un turno por id Long
	@Get("/reed_turno/:id")
	def Result consultas() {
		try {
			val consultas = repoTurnos.searchByLongId(Long.valueOf(id))
			ok(consultas.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	//Leer un turno por id string
	@Get("/reed_sturno/:id")
	def Result turnoString() {
		try {
			val consultas = repoTurnos.searchByStringId(id)
			ok(consultas.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	//Leer todos los turnos cargados
	@Get("/reed_turnos")
	def Result turnosList() {
		try {
			val consultas = repoTurnos.allInstances
			ok(consultas.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	//Updatear un turno
	@Put("/update_turno")
	def Result updateTurno(@Body String body) {
		println("este es el body del trabajo:" + body)
		try {
			val Turno trabajo = body.fromJson(Turno)
			println("este es el estado del trabajo:"+ trabajo.estado)
			repoTurnos.update(trabajo)
			ok('{ "status" : "OK" }')
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	//Eliminar un turno
	@Delete("/delete_turno")
	def Result eliminarTurno(@Body String body) {
		println("este es el body del trabajo:" + body)
		try {
			val Turno trabajo = body.fromJson(Turno)
			println("este es el estado del trabajo:"+ trabajo.estado)
			repoTurnos.delete(trabajo)
			ok('{ "status" : "OK" }')
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	//Consultar los turnos por idCliente
	@Get("/reed_turnoCliente/:id")
	def Result consultaTurnoCliente() {
		try {
			val consultas = repoTurnos.turnosCliente(Long.valueOf(id))
			if(consultas.empty){
				return ok('{ "status" : "0" }')
			}
			ok(consultas.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	//Consultar los turno por idProfesional
	@Get("/reed_turnoProfesional/:id")
	def Result consultaTurnoProfesional() {
		try {
			val consultas = repoTurnos.turnosProfesional(Long.valueOf(id))
			if(consultas.empty){
				return ok('{ "status" : "0" }')
			}
			ok(consultas.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
}