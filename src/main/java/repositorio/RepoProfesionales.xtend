package repositorio

import domain.Profesional
import java.util.List
import domain.Presupuesto
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root
import org.hibernate.HibernateException
import javax.persistence.NoResultException

class RepoProfesionales extends AbstractRepository <Profesional>{

	static RepoProfesionales repoProfesionales

	def static RepoProfesionales getInstance() {
		if (repoProfesionales === null) {
			repoProfesionales = new RepoProfesionales
		}
		repoProfesionales
	}

	
	def enviarNotificacionDePresupuesto(Presupuesto problema) {
		allInstances.forEach [ profesional |
			if (profesional.profesion.equals(problema.especialidad)) {
				//val profesionalEncontrado=searchById(profesional.id)
				//profesionalEncontrado.agregarPresupuesto(problema)
				profesional.agregarTrabajo(problema)
				update(profesional)
				println(profesional.toString)
			}
		]
		allInstances.forEach [ profesional |update(profesional)]
	}

	def List<Profesional> busquedaPorProfesion(String profesion) {
		allInstances.filter(profesional|profesional.profesion.equals(profesion)).toList
	}

	def List<Profesional> busquedaPorZona(String zona) {
		allInstances.filter(profesional|profesional.zonaDeTrabajo.equals(zona)).toList
	}

	def List<Profesional> busquedaPorNombreYApellido(String nombre) {
		allInstances.filter(profesional|profesional.usuario.equals(nombre)).toList
	}
	
	override getTipoEntidad() {
		Profesional
	}
	
	override generateWhere(CriteriaBuilder criteria, CriteriaQuery<Profesional> query, Root<Profesional> camposCandidato, Profesional user) {
//			if (user.usuario.email !== null) {
//			query.where(criteria.equal(camposCandidato.get("id"), user.id))
			if (user.usuario.nombre !== null) {
			query.where(criteria.equal(camposCandidato.get("id"), user.id))
		}
	}
	
	def Profesional searchById(Long id) {
		val entityManager = this.administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val _User = query.from(tipoEntidad)
			//val camposZona = query.from(entityType)
			//camposZona.fetch("ofertasJob")
			query.select(_User)
			query.where(criteria.equal(_User.get("usuario").get("id"), id))
			entityManager.createQuery(query).singleResult
		} catch (HibernateException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("ERROR: La BD no tiene informacion del profesional.", e)
		} finally {
			entityManager?.close
		}
	}
	
	def Profesional searchByEmail(String email) {
		val entityManager = administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val _User = query.from(tipoEntidad)
			query.select(_User)
			query.where(criteria.equal(_User.get("usuario").get("email"), email))
			entityManager.createQuery(query).singleResult
		} catch (NoResultException nre){
			return new Profesional()=>[
				id = Long.valueOf(0)
			]
		} catch (HibernateException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("ERROR: La BD no tiene informacion del profesional.", e)
		} finally {
			entityManager?.close
		}
	}
	
	def Profesional searchByIdUser(String id) {
		val entityManager = this.administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val _User = query.from(tipoEntidad)
			query.select(_User)
			query.where(criteria.equal(_User.get("idUsuario"), id))
			entityManager.createQuery(query).singleResult
		}catch (HibernateException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("ERROR: La BD no tiene informacion del profesional.", e)
		} finally {
			entityManager?.close
		}

	}
	
	def ultimoIdProfesional(){
		val entityManager = administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val _User = query.from(tipoEntidad)
			query.select(_User)
			query.orderBy(criteria.desc(_User.get("id")))
			val result=entityManager.createQuery(query).resultList
			   if(result.size() > 0) {
       		 return result.get(0);
    		}
		} catch (HibernateException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("ERROR: La BD no tiene informacion del cliente.", e)
		} finally {
			entityManager?.close
		}
	}

}
