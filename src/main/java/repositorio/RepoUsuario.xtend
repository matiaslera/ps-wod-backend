package repositorio

import domain.Usuario
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root
import org.hibernate.HibernateException
import domain.Cliente
import java.util.Set
import domain.Profesional

class RepoUsuario extends AbstractRepository<Usuario> {
	
	static RepoUsuario instance = null

	 new() {
	}

	static def getInstance() {
		if (instance === null) {
			instance = new RepoUsuario
		}
		instance
	}
	
	override getEntityType() {
		Usuario
	}
	
	override generateWhere(CriteriaBuilder criteria, CriteriaQuery<Usuario> query, Root<Usuario> camposCandidato, Usuario user) {
		if (user.nombre !== null) {
			query.where(criteria.equal(camposCandidato.get("id"), user.uid))
	}
	}
	
	def searchUserByLogin(Usuario login) {
	val userALogear = allInstances.findFirst(user|user.nombre == login.nombre)
		if (userALogear === null) {
			throw new Exception("No existe ningun User con ese Id, por favor intente de nuevo")
		}
		if (userALogear.apellido != login.apellido) {
			throw new Exception("Password incorrecto")
		}
		userALogear
	}
	
	def Usuario searchById(Long id) {
		val entityManager = entityManager
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(entityType)
			val _User = query.from(entityType)
			query.select(_User)
			query.where(criteria.equal(_User.get("id"), id))
			entityManager.createQuery(query).singleResult
		} catch (HibernateException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("ERROR: La BD no tiene informacion del user.", e)
		} finally {
			entityManager?.close
		}
	}

	def Usuario searchByIdUser(String id) {
		val entityManager = entityManager
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(entityType)
			val _User = query.from(entityType)
			query.select(_User)
			query.where(criteria.equal(_User.get("idUsuario"), id))
			entityManager.createQuery(query).singleResult
		} catch (HibernateException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("ERROR: La BD no tiene informacion del user.", e)
		} finally {
			entityManager?.close
		}
	}
	
	def Set<Cliente> getClientes(){

//		val entityManager = entityManager
//		try {
//			val criteria = entityManager.criteriaBuilder
//			val query = criteria.createQuery(entityType)
//			val _User = query.from(entityType)
//			query.select(_User)
//			query.where(criteria.equal(_User.get("id"), id))
//			entityManager.createQuery(query).singleResult
//		} catch (HibernateException e) {
//			e.printStackTrace
//			entityManager.transaction.rollback
//			throw new RuntimeException("ERROR: La BD no tiene informacion del user.", e)
//		} finally {
//			entityManager?.close
//		}
	}
	
	def Set<Profesional> getProfesional(){
		
	}
	
}