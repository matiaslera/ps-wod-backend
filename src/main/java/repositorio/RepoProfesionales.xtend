package repositorio

import domain.Profesional
import java.util.ArrayList
import java.util.List
import domain.Presupuesto
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root
import org.hibernate.HibernateException

class RepoProfesionales extends AbstractRepository <Profesional>{

	static RepoProfesionales repoProfesionales

	def static RepoProfesionales getInstance() {
		if (repoProfesionales === null) {
			repoProfesionales = new RepoProfesionales
		}
		repoProfesionales
	}

	List<Profesional> profesionales = new ArrayList

	def enviarNotificacionDePresupuesto(Presupuesto problema) {
		profesionales.forEach [ profesional |
			if (profesional.profesion.equals(problema.especialidad)) {
				profesional.agregarPresupuesto(problema)
			}
		]
	}

	def List<Profesional> busquedaPorProfesion(String profesion) {
		profesionales.filter(profesional|profesional.profesion.equals(profesion)).toList
	}

	def List<Profesional> busquedaPorZona(String zona) {
		profesionales.filter(profesional|profesional.zonaDeTrabajo.equals(zona)).toList
	}

	def List<Profesional> busquedaPorNombreYApellido(String nombre) {
		profesionales.filter(profesional|profesional.nombreyApellido.equals(nombre)).toList
	}
	
	override getEntityType() {
		Profesional
	}
	
	override generateWhere(CriteriaBuilder criteria, CriteriaQuery<Profesional> query, Root<Profesional> camposCandidato, Profesional user) {
			if (user.usuario !== null) {
			query.where(criteria.equal(camposCandidato.get("id"), user.id))
		}
		
	}
	
	def Profesional searchById(Long id) {
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
			throw new RuntimeException("ERROR: La BD no tiene informacion del cliente.", e)
		} finally {
			entityManager?.close
		}
	}

	def Profesional searchByIdUser(String id) {
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
			throw new RuntimeException("ERROR: La BD no tiene informacion del cliente.", e)
		} finally {
			entityManager?.close
		}

	}

}
