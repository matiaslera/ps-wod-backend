package restApi

import domain.Oferta
import domain.Presupuesto
import domain.Profesional
import java.time.LocalDate
import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.api.annotation.Post
import org.uqbar.xtrest.json.JSONUtils
import repositorio.RepoClientes
import repositorio.RepoOferta
import repositorio.RepoPresupuestos
import repositorio.RepoProfesionales

@Controller
class RestControllerPresupuesto {
	
	extension JSONUtils = new JSONUtils
	RepoClientes repoClientes //= new RepoClientes
	RepoProfesionales repoProfesionales //= new RepoProfesionales
	RepoPresupuestos repoPresupuesto// = new RepoPresupuestos()
	RepoOferta repoOferta// = new RepoOferta()
	
	//busca los trabajos terminados
	@Get("/presupuestos")
	def Result presupuestos() {
		try {
			val presupuesto = repoPresupuesto.trabajosRealizados()
			ok(presupuesto.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	//busca entre los trabajos terminados
	@Post("/search_presupuestos")
	def Result busquedaPresupuestos(@Body String body) {
		try {
			val especialidad= getPropertyValue(body,"especialidad")
			val nombre= getPropertyValue(body,"problema")
			println(especialidad +" : " + nombre)
			val busqueda= repoPresupuesto.search(especialidad,nombre)
			ok(busqueda.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	//crea una nueva consulta
	@Post("/new_qery/:id")
	def Result nuevaConsulta(@Body String body){
			try {
			val consulta= new Presupuesto()=>[
			descripcion=body.getPropertyValue("descripcion")
			direccion=body.getPropertyValue("direccion")
			especialidad=body.getPropertyValue("especialidad")
			problema=body.getPropertyValue("problema")
			realizado=false
			fecha= LocalDate.now
			]
			repoPresupuesto.create(consulta)
			val Presupuesto consultaCreada= repoPresupuesto.searchById(Long.valueOf(consulta.id))
			val cliente= repoClientes.searchById(Long.valueOf(id))
//			cliente.addPresupuesto(consultaCreada)
			repoClientes.update(cliente)
			println(consultaCreada.toString)
			ok('{ "status" : "OK" }') 
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	//devuelve las consultas que realizo el cliente
	@Get("/query_made/:id")
	def Result consultas() {
		try {
//			val consultas= repoClientes.consultasRealizadas(Long.valueOf(id))
//			ok(consultas.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	//devuelve la consulta completa
	@Get("/job_completo/:id")
	def Result jobCompleto() {
		try {
			val presupuesto= repoPresupuesto.searchById(Long.valueOf(id))	
			ok(presupuesto.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	//son los TRABAJOS REALIZADOS DE este profesional, todos los trabajos son finalizados
	@Get("/query_tecnica/:id")
	def Result consultasTecnicas() {
		try {
			val tecnico= repoProfesionales.searchById(Long.valueOf(id))
			val trabajos = tecnico.trabajos
			ok(trabajos.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	//crea las ofertas de los tecnicos 
	@Post("/job_answer/:id")
	def Result repuestaTrabajo(@Body String body) {
		try {
			val oferta= new Oferta()=>[
			comentario=body.getPropertyValue("comentario")
			monto=body.getPropertyAsInteger("monto")
			idProfesional =body.getPropertyAsInteger("idProfesional")
			nombreApellido = body.getPropertyValue("nombreApellido")
			fechaCreacion= LocalDate.now
			]
			repoOferta.create(oferta)
			val presupuesto=repoPresupuesto.searchById(Long.valueOf(id))
			println(presupuesto.toString)
			presupuesto.addOferta(oferta)
			repoPresupuesto.update(presupuesto)
			ok('{ "status" : "OK" }')
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	//consultas las consultas creadas con aquella profesion que le pase
	@Post("/prof_tecnica")
	def Result especialidadTecnica(@Body String body) {
		try {
			println(body)
			val user = body.fromJson(Profesional)
			println(user.profesion)
			val jobEspecialidad = repoPresupuesto.listPorProfesion(user.profesion)
			ok(jobEspecialidad.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	
	//crea los trabajos pedientes
	@Post("/add_job")
	def Result crearTrabajo(@Body String body) {
		try {
			val presupuestoOb=body.fromJson(Presupuesto)
			///val id=body.getPropertyValue("id")
			//val montoBody=body.getPropertyAsInteger("monto")
			//val idProfBody=body.getPropertyAsInteger("idProfesional")
			//val notasBody=body.getPropertyValue("notas")
			println("estoy aquiiiiiiiiiiiiiiiiiii")
			presupuestoOb.realizado=false
			presupuestoOb.contratado=true
			//val presupuesto=repoPresupuesto.searchById(Long.valueOf(id))
			//presupuesto.monto=montoBody
			//presupuesto.notas=notasBody
			//presupuesto.idProfesional=Long.valueOf(idProfBody)
		//	presupuesto.realizado=false
			//presupuesto.contratado=true
			//println("estoy aquiiiiiiiiiiiiiiiiiii 2 222222222222222")

			//this.presupuesto.monto=this.oferta.monto
   			// this.presupuesto.notas=this.oferta.comentario
   			//this.presupuesto.idProfesional=this.oferta.idProfesional
			
			//println(presupuesto.toString)
			repoPresupuesto.update(presupuestoOb)
			//println(presupuesto.toString)
			ok('{ "status" : "OK" }')
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	
	//hacer llamados para obtener trabajos pendientes de un usuario en particular
	@Get("/jod_pendiente/:id")
	def Result trabajosPendientes() {
		try {
//			val trabajos = repoClientes.trabajosPendiente(Long.valueOf(id))
//			ok(trabajos.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
		//hacer llamados para obtener trabajos finalizados para un usuario en particular
	@Get("/jod_finalizados/:id")
	def Result trabajosFinalizados() {
		try {
//			val trabajos = repoClientes.trabajosFinalizado(Long.valueOf(id))
//			ok(trabajos.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	@Post("/end_job")
	def Result finalizarTrabajo(@Body String body) {
		try {
			val presupuesto=body.fromJson(Presupuesto)
			repoPresupuesto.update(presupuesto)
			ok('{ "status" : "OK" }')
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	//1--- El tecnico debe poder constestar los presupuesto
	//2--- se tiene crear una tabla con los resultado de las respuseta que recibe el cliente, es decir con los prespuesto q hacen los tecnicos
	//3---debe devolver los trabajos pendientes que ya contrato
	//4-- se debe devolver los trabajos que ya realizo
	
}