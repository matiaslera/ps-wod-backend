package restApi

import domain.Presupuesto
import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.api.annotation.Post
import org.uqbar.xtrest.json.JSONUtils
import repositorio.RepoOferta
import repositorio.RepoPresupuestos
import repositorio.RepoProfesionales
import repositorio.RepoTrabajo
import domain.Trabajo
import domain.Estado
import domain.Oferta
import java.time.LocalDate
import domain.Profesional
import org.uqbar.xtrest.api.annotation.Put

@Controller
class RestControllerPresupuesto {

	extension JSONUtils = new JSONUtils
	RepoProfesionales repoProfesionales = new RepoProfesionales
	RepoPresupuestos repoPresupuesto = new RepoPresupuestos()
	RepoOferta repoOferta = new RepoOferta()
	RepoTrabajo repoTrabajo = new RepoTrabajo()

// busca los trabajos terminados
	@Get("/job_final")
	def Result presupuestos() {
		try {
			val presupuesto = repoTrabajo.trabajosRealizados()
			ok(presupuesto.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}

	// un trabajo *** una prueba
	@Get("/job")
	def Result unTrabajo() {
		try {
			val presupuesto = repoTrabajo.trabajosRealizados().head
			ok(presupuesto.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}

//	}
// crea una nueva consulta
	@Post("/create_job")
	def Result nuevaConsulta(@Body String body) {
		println("este es el json recibido" + body)
		try {
			// crear trabajo, editar presupuesto
			val job = body.fromJson(Trabajo)
			job.estado = Estado.PUBLICADO
			repoTrabajo.create(job)
			println(job.toString)
			ok('{ "status" : "OK" }')
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}

// devuelve las consultas que realizo el cliente
	@Get("/query_made/:id")
	def Result consultas() {
		try {
			val consultas = repoTrabajo.trabajosPublicado(Long.valueOf(id))
			ok(consultas.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}

// devuelve la consulta completa
	@Get("/job_completo/:id")
	def Result jobCompleto() {
		try {
			val presupuesto = repoTrabajo.searchByLongId(Long.valueOf(id))
			ok(presupuesto.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}

// crea las ofertas de los tecnicos, solo una oferta para un trabajo especifico, viene oferta y el id del trabajo
	@Post("/create_oferta/:id")
	def Result repuestaTrabajo(@Body String body) {
		try {
			val Oferta oferta = body.fromJson(Oferta)
			val trabajo = repoTrabajo.searchByLongId(Long.valueOf(id))
			oferta.fechaCreacion = LocalDate.now();
			repoOferta.create(oferta)
			trabajo.presupuesto.addOferta(oferta)
			repoTrabajo.update(trabajo)
			println(trabajo.toString)
			println(oferta.toString)
			ok('{ "status" : "OK" }')
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}

// devuelven los trabajos por la especialidad, recibe el profesional
	@Post("/job_especialidad")
	def Result trabajosPorEspecialidad(@Body String body) {
		try {
			val Profesional profesional = body.fromJson(Profesional)
			println(profesional.toString)
			val String especialidad = profesional.profesion
			println(especialidad)
			val trabajo = repoTrabajo.trabajoEspecialidad(especialidad)
			println(trabajo)
			ok(trabajo.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}

// devuelve los trabajos contratados que realizo el cliente, se va el id
	@Get("/job_contratado/:id")
	def Result trabajosContratado() {
		try {
			val consultas = repoTrabajo.trabajoContratados(Long.valueOf(id))
			ok(consultas.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
// contratar el trabajo, recibo el trabajo y lo updateo
	@Put("/job_contratado")
	def Result updateTrabajo(@Body String body) {
		println("este es el body del trabajo:" + body)
		try {
			println("este es el body del trabajo:" + body)
			val Trabajo trabajo = body.fromJson(Trabajo)
			println("este es el estado del trabajo:"+ trabajo.estado)
			repoTrabajo.update(trabajo)
			ok('{ "status" : "OK" }')
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
// trabajos finalizados de este cliente
	@Get("/job_finalizado/:id")
	def Result trabajosFinalizado() {
		try {
			val presupuesto = repoTrabajo.trabajosFinalizados(Long.valueOf(id))
			ok(presupuesto.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}

// son los TRABAJOS REALIZADOS DE este profesional, todos los trabajos son finalizados
	@Get("/job_finalizadoTec/:id")
	def Result consultasTecnicas() {
		try {
			val tecnico = repoProfesionales.searchById(Long.valueOf(id))
			val trabajos = tecnico.trabajos
			ok(trabajos.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	/*Updatear el trabajo */
	@Put("/job_update")
	def Result updateJob(@Body String body) {
		println("este es el body del trabajo:" + body)
		try {
			println("este es el body del trabajo:" + body)
			val Trabajo trabajo = body.fromJson(Trabajo)
			println("este es el estado del trabajo:"+ trabajo.estado)
			repoTrabajo.update(trabajo)
			ok('{ "status" : "OK" }')
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}


// 1--- El tecnico debe poder constestar los presupuesto
// 2--- se tiene crear una tabla con los resultado de las respuseta que recibe el cliente, es decir con los prespuesto q hacen los tecnicos
// 3---debe devolver los trabajos pendientes que ya contrato
// 4-- se debe devolver los trabajos que ya realizo
}
