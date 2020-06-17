package restApi

import org.uqbar.xtrest.api.annotation.Controller
import runnable.WorkOfDayBootstrap
import org.uqbar.xtrest.json.JSONUtils
import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.annotation.Get
import domain.Usuario
import repositorio.RepoClientes
import java.util.Set
import org.uqbar.commons.model.exceptions.UserException
import domain.Cliente
import domain.Profesional
import repositorio.RepoProfesionales
import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.api.annotation.Post
import repositorio.RepoUsuario
import serializacion.UsuarioSerializable
import repositorio.RepoPresupuestos

@Controller
class RestControllerUser {
	
	extension JSONUtils = new JSONUtils
	
	RepoClientes repoClientes = new RepoClientes
	RepoProfesionales repoProfesionales = new RepoProfesionales
	RepoUsuario repoUser = new RepoUsuario()
	RepoPresupuestos repoPresupuesto = new RepoPresupuestos()
	
	new(WorkOfDayBootstrap object) {
	}
	
	@Get('/usuarios')
	def Result usuarios() {
		try {
			val Set<Usuario> lista = repoUser.allInstances.toSet
			ok(lista.toJson)
		} catch (UserException e) {
			notFound("No existe ningun usuario")
		}
	}
	
	@Get('/clientes')
	def Result clientes() {
		try {
			val Set<Cliente> lista = repoClientes.allInstances.toSet
			ok(lista.toJson)
		} catch (UserException e) {
			notFound("No hay Clientes cargados")
		}
	}
	
	
	@Get('/cliente/:id')
	def Result cliente() {
		try {
			val Cliente cliente = repoClientes.searchById(Long.valueOf(id))
			ok(cliente.toJson)
		} catch (UserException e) {
			notFound("No se encontro al cliente")
		}
	}
	
	@Get('/profesionales')
	def Result profesionales() {
		try {
			val Set<Profesional> lista = repoProfesionales.allInstances.toSet
			ok(lista.toJson)
		} catch (UserException e) {
			notFound("No hay profesionales cargados")
		}
	}
	
	
	@Get('/profesional/:id')
	def Result profesional() {
		try {
			val Profesional profesional = repoProfesionales.searchById(Long.valueOf(id))
			ok(profesional.toJson)
		} catch (UserException e) {
			notFound("No se encontro al profesional por id")
		}
	}
	
	@Post("/login")
	def Result login(@Body String body) {
		try {
			println(body)
			val loginData = body.fromJson(Cliente)
			println(loginData.usuario)
			val usarioLogueado = repoUser.searchUserByLogin(loginData)
			ok(UsuarioSerializable.toJson(usarioLogueado)) 
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	@Get("/perfil_completo/:id")
	def Result login(@Body String body) {
		try {
			val usuarioCompleto = repoUser.searchById(Long.valueOf(id))
			ok(usuarioCompleto.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	@Get("/presupuestos")
	def Result presupuestos() {
		try {
			val presupuesto = repoPresupuesto.allInstances()
			ok(presupuesto.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
	@Get("/search_presupuestos")
	def Result busquedaPresupuestos(@Body String body) {
		try {
			val especialidad= getPropertyValue(body,"especialidad")
			val nombre= getPropertyValue(body,"nombre")
			println(especialidad +" : " + nombre)
			val busqueda= repoPresupuesto.search(especialidad,nombre)
			
			ok(busqueda.toJson)
		} catch (Exception e) {
			internalServerError(e.message)
		}
	}
	
}