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
//import serializacion.UsuarioSerializable
import org.uqbar.xtrest.api.annotation.Delete
import org.uqbar.xtrest.api.annotation.Put

@Controller
class RestControllerUser {
	
	extension JSONUtils = new JSONUtils
	
	RepoClientes repoClientes = new RepoClientes()
	RepoProfesionales repoProfesionales = new RepoProfesionales()
	RepoUsuario repoUser = new RepoUsuario()
	
	new() {}
	
	@Get('/get_usuarios')
	def Result usuarios() {
		try {
		val Set<Usuario> lista = repoUser.allInstances.toSet
	  		ok(lista.toJson)
		} catch (UserException e) {
			notFound("No existe ningun usuario")
		}
	}
	@Get('/getId_usuario/:id')
	def Result usuariosId() {
		try {
		val Usuario usuario = repoUser.searchById(Long.valueOf(id))
	  		ok(usuario.toJson)
		} catch (UserException e) {
			notFound("No existe ningun usuario")
		}
	}
	@Get('/getId/:id')
	def Result userId() {
		try {
		val Usuario usuario = repoUser.getId(Long.valueOf(id))
	  		ok(usuario.toJson)
		} catch (UserException e) {
			notFound("No existe ningun usuario")
		}
	}
	@Put('/update_usuario')
	def Result updateUsuarios(@Body String body) {
		createUpdateUser(actualizarUser, body,"no se puede actualizar el usuario")
	}
	@Post('/create_usuario')
	def Result createUsuarios(@Body String body) {
		createUpdateUser(crearUser, body,"no se puede crear el usuario")
	}
	@Delete('/delete_usuario/:id')
	def Result eliminarUsuario(@Body String body) {
		try {
		val user = repoUser.searchById(Long.valueOf(id))
		repoUser.delete(user)
		println("usuario eliminado"+user.toString())
	  	ok('{ "status" : "OK" }')
		} catch (UserException e) {
			notFound("No se puede eliminar ningun usuario")
		}
	}
	@Get('/getId/:id')
	def Result clienteId() {
		try {
		val Cliente usuario = repoClientes.getId(Long.valueOf(id))
	  		ok(usuario.toJson)
		} catch (UserException e) {
			notFound("No existe ningun cliente")
		}
	}
	
	/* 
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
			//println(body)
			//val loginData = body.fromJson(Cliente)
			//println(loginData.apellido)
			//val usarioLogueado = repoUser.searchUserByLogin(loginData)
			//ok(UsuarioSerializable.toJson(usarioLogueado)) 
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
		def abandonarEquipo() {
		[Usuario equipo, SuperIndividuo individuo|equipo.eliminarUnIntegrante(individuo)]
	}
	*/ 

	def actualizarUser() {
		[Usuario user|repoUser.update(user)]
	}

	def crearUser() {
		[Usuario user|repoUser.create(user)]
	}

	def createUpdateUser((Usuario)=>void aBlock, String body,String error) {
		try {
			val user = body.fromJson(Usuario)
			aBlock.apply(user)
			ok('{ "status" : "OK" }'
			);
		} catch (Exception e) {
			internalServerError(e.message)
			notFound(error)
		}
	}
	
}

	