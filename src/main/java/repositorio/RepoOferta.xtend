package repositorio

import domain.Oferta
import javax.persistence.criteria.CriteriaBuilder
import org.hibernate.HibernateException
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

class RepoOferta extends AbstractRepository<Oferta> {

	static RepoClientes instances

	def static RepoClientes getInstance() {
		if (instances === null) {
			instances = new RepoClientes
		}
		instances
	}

	override getTipoEntidad() {
		Oferta
	}
	
	def Oferta searchById(Long id) {
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
			throw new RuntimeException("ERROR: La BD no tiene informacion de la oferta consultada.", e)
		} finally {
			entityManager?.close
		}
	}

	def Oferta searchByIdUser(String id) {
		val entityManager =  this.administradorEntidad
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
			throw new RuntimeException("ERROR: La BD no tiene informacion de la oferta consultada.", e)
		} finally {
			entityManager?.close
		}
	}
	
	override generateWhere(CriteriaBuilder criteria, CriteriaQuery<Oferta> query, Root<Oferta> camposCandidato, Oferta user) {
		if (user.id === null) {
			query.where(criteria.equal(camposCandidato.get("id"), user.id))
		}
	}
	
}