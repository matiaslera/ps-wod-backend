package restApi

import domain.Cliente
import domain.Profesional
import domain.Usuario
import java.util.Set
import org.uqbar.commons.model.exceptions.UserException
import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Delete
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.api.annotation.Post
import org.uqbar.xtrest.api.annotation.Put
import org.uqbar.xtrest.json.JSONUtils
import repositorio.RepoClientes
import repositorio.RepoProfesionales
import repositorio.RepoUsuario
import exceptions.BusinessException
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable

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
	/*****CLIENTES**** */
	@Get('/get_cli')
	def Result clientes() {
		try {
		val Set<Cliente> lista = repoClientes.allInstances.toSet
	  		ok(lista.toJson)
		} catch (UserException e) {
			notFound("No existe ningun usuario")
		}
	}
	@Get('/getId_cli/:id')
	def Result clienteId() {
		try {
		val Cliente usuario = repoClientes.getId(Long.valueOf(id))
	  		ok(usuario.toJson)
		} catch (UserException e) {
			notFound("No existe ningun cliente")
		}
	}

	@Get('/get_id_ultimo')
	def Result ultimoIdCliente() {
		try {
		val  id = repoClientes.ultimoIdCliente()
	  	ok(id.toJson())
		} catch (UserException e) {
			notFound("No existe ningun cliente")
		}
	}
	@Post('/get_email')
	def Result searchByEmail(@Body String body) {
		println("body: "+ body)
		try {
		val email =getPropertyValue(body,"email")
		if(repoClientes.searchByEmail(email).id!==0){
			val cliente=repoClientes.searchByEmail(email)
			return ok(cliente.toJson())
		}
		if(repoProfesionales.searchByEmail(email).id!==0){
			val profesional=repoProfesionales.searchByEmail(email)
			return ok(profesional.toJson())
		}
 		ok("sin usuario".toJson())
		} catch (UserException e) {
			notFound("No se encontro ningun usuario")
		}
	}
	@Put('/update_cliente/:id')
	def Result updateCliente(@Body String body) {
		val String error='Debe ingresar el parámetro id'
		val String error2='Id en URL distinto del id que viene en el body'
		if (id === null) {
			ok(error.toJson())
			 throw new BusinessException("Debe ingresar el parámetro id")
		}
		val actualizada = body.fromJson(Cliente)
		if (id != actualizada.id) {
			ok(error2.toJson())
			 throw new BusinessException("Id en URL distinto del id que viene en el body")
		}
		createUpdateCliente(actualizarCliente, body,"no se puede actualizar el cliente")
	}
	@Post('/create_cliente')
	def Result createCliente(@Body String body) {
		createUpdateCliente(crearCliente, body,"no se puede crear el cliente")
	}
	@Delete('/delete_cliente/:id')
	def Result eliminarCliente(@Body String body) {
		try {
		val user = repoClientes.searchById(Long.valueOf(id))
		repoClientes.delete(user)
		println("cliente eliminado"+user.toString())
	  	ok('{ "status" : "OK" }')
		} catch (UserException e) {
			notFound("No se puede eliminar ningun cliente")
		}
	}
	/*****PROFESIONALES******/
	@Get('/get_pros')
	def Result profesionales() {
		try {
		val Set<Profesional> lista = repoProfesionales.allInstances.toSet
	  		ok(lista.toJson)
		} catch (UserException e) {
			notFound("No existe ningun usuario")
		}
	}
	@Get('/getId_prof/:id')
	def Result profesionalId() {
		try {
		val Profesional usuario = repoProfesionales.getId(Long.valueOf(id))
	  		ok(usuario.toJson)
		} catch (UserException e) {
			notFound("No existe ningun cliente")
		}
	}
	@Put('/update_profesional')
	def Result updateProfesional(@Body String body) {
		createUpdateProfesional(actualizarProfesional, body,"no se puede actualizar el Profesional")
	}
	@Post('/create_profesional')
	def Result createProfesional(@Body String body) {
		createUpdateProfesional(crearProfesional, body,"no se puede crear el Profesional")
	}
	@Delete('/delete_profesional/:id')
	def Result eliminarProfesional(@Body String body) {
		try {
		val user = repoProfesionales.searchById(Long.valueOf(id))
		repoProfesionales.delete(user)
		println("Profesional eliminado"+user.toString())
	  	ok('{ "status" : "OK" }')
		} catch (UserException e) {
			notFound("No se puede eliminar ningun Profesional")
		}
	}

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
			ok('{ "status" : "OK" }');
		} catch (Exception e) {
			internalServerError(e.message)
			notFound(error)
		}
	}
	def actualizarCliente() {
		[Cliente user|repoClientes.update(user)]
	}

	def crearCliente() {
		[Cliente user|repoClientes.create(user)]
	}
	def createUpdateCliente((Cliente)=>void aBlock, String body,String error) {
		try {
			println("este es el json cliente" +body)
			val user = body.fromJson(Cliente)
			println("este es el objeto cliente" +user.toString())
			aBlock.apply(user)
			ok('{ "status" : "OK" }');
		} catch (Exception e) {
			internalServerError(e.message)
			notFound(error)
		}
	}
	def actualizarProfesional() {
		[Profesional user|repoProfesionales.update(user)]
	}

	def crearProfesional() {
		[Profesional user|repoProfesionales.create(user)]
	}
	def createUpdateProfesional((Profesional)=>void aBlock, String body,String error) {
		try {
			val user = body.fromJson(Profesional)
			aBlock.apply(user)
			ok('{ "status" : "OK" }');
		} catch (Exception e) {
			internalServerError(e.message)
			notFound(error)
		}
	}
	
}

@Accessors
@Observable
class UserFB{
	
	 String providerId
	 String uid
	 String email
}

	