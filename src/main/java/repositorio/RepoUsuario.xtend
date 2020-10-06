package repositorio

import domain.Usuario
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root
import org.hibernate.HibernateException

class RepoUsuario extends AbstractRepository<Usuario> {
	
	static RepoUsuario instance

	 new() {}

	static def getInstance() {
		if (instance === null) {
			instance = new RepoUsuario
		}
		instance
	}
	
	override getTipoEntidad() {
		Usuario
	}
	
	override generateWhere(CriteriaBuilder criterio, CriteriaQuery<Usuario> consulta, Root<Usuario> camposCandidato, Usuario user) {
		if (user.email !== null ) {
			consulta.where(criterio.equal(camposCandidato.get("email"), user.email))
	}
	}
	
	def Usuario searchById(Long id) {
		val entityManager = this.administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder 
			val query = criteria.createQuery(tipoEntidad)
			val _User = query.from(tipoEntidad)
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
		val entityManager = this.administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val _User = query.from(tipoEntidad)
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
	

}