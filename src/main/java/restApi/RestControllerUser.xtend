package restApi

import org.uqbar.xtrest.api.annotation.Controller
import runnable.WorkOfDayBootstrap
import org.uqbar.xtrest.json.JSONUtils
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.type.TypeFactory
import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.annotation.Get
import domain.Usuario
import repositorio.RepoClientes
import java.util.Set
import org.uqbar.commons.model.exceptions.UserException
import domain.Cliente
import domain.Profesional
import repositorio.RepoProfesionales

@Controller
class RestControllerUser {
	
	extension JSONUtils = new JSONUtils
	ObjectMapper mapper = new ObjectMapper();
	
	RepoClientes repoClientes = new RepoClientes
	RepoProfesionales repoProfesionales = new RepoProfesionales
	
	new(WorkOfDayBootstrap object) {
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

}