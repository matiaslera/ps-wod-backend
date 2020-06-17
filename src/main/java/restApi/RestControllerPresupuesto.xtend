package restApi

import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.json.JSONUtils
import repositorio.RepoClientes
import repositorio.RepoProfesionales
import repositorio.RepoUsuario
import repositorio.RepoPresupuestos
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.api.annotation.Put
import org.uqbar.xtrest.api.annotation.Post
import domain.Presupuesto

@Controller
class RestControllerPresupuesto {
	
	
	extension JSONUtils = new JSONUtils
	
	RepoClientes repoClientes = new RepoClientes
	RepoProfesionales repoProfesionales = new RepoProfesionales
	RepoUsuario repoUser = new RepoUsuario()
	RepoPresupuestos repoPresupuesto = new RepoPresupuestos()
	
	
	@Get("/presupuestos")
	def Result presupuestos() {
		try {
			val presupuesto = repoPresupuesto.allInstances()
			ok(presupuesto.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
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
	
	@Post("/new_qery/:id")
	def Result nuevaConsulta(@Body String body){
			try {
			val Presupuesto presNuevo= fromJson(body,Presupuesto)
			val cliente= repoClientes.searchById(Long.valueOf(id))
			cliente.addPresupuesto(presNuevo)
			repoClientes.update(cliente)
			println(presNuevo.toString)
			println(cliente.toString)
			ok('{ "status" : "OK" }') 
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	// se crea un presupuesto para enviar a los tecnicos de dicha especialidad
	
}