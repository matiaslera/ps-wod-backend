package repositorio

import domain.Turno
import java.util.ArrayList
import java.util.List
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root
import org.eclipse.xtend.lib.annotations.Accessors
import org.hibernate.HibernateException
import java.time.LocalDate

@Accessors
class RepoTurnos extends AbstractRepository<Turno> {

	static RepoTurnos instance = null

	new() {
	}
	def static RepoTurnos getInstance() {
		if (instance === null) {
			instance = new RepoTurnos()
		}
		instance
	}

	override getTipoEntidad() {
		Turno
	}

	override generateWhere(CriteriaBuilder criterio, CriteriaQuery<Turno> query, Root<Turno> camposCandidato,
		Turno trabajo) {
		if (trabajo.id === null) {
			query.where(criterio.equal(camposCandidato.get("id"), trabajo.id))
		}
	}

	def Turno searchByLongId(Long id) {
		val entityManager = this.administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val _User = query.from(tipoEntidad)
			// val camposZona = query.from(entityType)
			// camposZona.fetch("ofertas")
			query.select(_User)
			query.where(criteria.equal(_User.get("id"), id))
			entityManager.createQuery(query).singleResult
		} catch (HibernateException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("ERROR: La BD no tiene informacion del presupuesto.", e)
		} finally {
			entityManager?.close
		}
	}

	def Turno searchByStringId(String id) {
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
			throw new RuntimeException("ERROR: La BD no tiene informacion del presupuesto.", e)
		} finally {
			entityManager?.close
		}
	}

//	def search(String especialidad, String nombre) {
//		var filtroProfesional = (this.filtrarPresupuestoPorProfesion(especialidad))
//		var listBusqueda = filtroProfesional.filter([p|p.presupuesto.nombre.contains(nombre)])
//		if (listBusqueda.isEmpty) {
//			throw new BusinessException("No se encontro presupuesto para el problema")
//		} else {
//			return (listBusqueda).toSet
//		}
//	}

//	def List<Turno> filtrarPresupuestoPorProfesion(String especialidad) {
//		(trabajosRealizados.filter[p|p.presupuesto.especialidad.equals(especialidad)]).toList
//	}
//
//	def List<Turno> listPorProfesion(String especialidad) {
//		(allInstances.filter[p|p.presupuesto.especialidad.equals(especialidad) && p.estado === Estado.FINALIZADO]).
//			toList
//	}

	def List<Turno> turnosCliente(Long id) {
		val entityManager = this.administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val tablaTrabajo = query.from(tipoEntidad)
			// val camposZona = query.from(entityType)
			// camposZona.fetch("ofertas")
			query.select(tablaTrabajo)
			query.where(criteria.equal(tablaTrabajo.get("idCliente"), id))
			entityManager.createQuery(query).resultList
		} catch (HibernateException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("ERROR: La BD no tiene informacion del turno consultado.", e)
		} finally {
			entityManager?.close
		}
	}
	
	def List<Turno> turnosProfesional(Long id) {
		val entityManager = this.administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val tablaTrabajo = query.from(tipoEntidad)
			// val camposZona = query.from(entityType)
			// camposZona.fetch("ofertas")
			query.select(tablaTrabajo)
			query.where(criteria.equal(tablaTrabajo.get("idProfesional"), id))
			entityManager.createQuery(query).resultList
		} catch (HibernateException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("ERROR: La BD no tiene informacion del turno consultado.", e)
		} finally {
			entityManager?.close
		}
	}
	
	
	def List<Turno> trabajosRealizados() {
		val entityManager = this.administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val tablaTrabajo = query.from(tipoEntidad)
			// val camposZona = query.from(entityType)
			// camposZona.fetch("ofertas")
			query.select(tablaTrabajo)
			query.where(criteria.equal(tablaTrabajo.get("estado"), 2))
			entityManager.createQuery(query).resultList
		} catch (HibernateException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("ERROR: La BD no tiene informacion del trabajo consultado.", e)
		} finally {
			entityManager?.close
		}
	}

	def List<Turno> trabajoEspecialidad(String especialidad) {
		val entityManager = this.administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val tablaTrabajo = query.from(tipoEntidad)
			// val camposZona = query.from(entityType)
			// camposZona.fetch("ofertas")
			query.select(tablaTrabajo)
			query.where(criteria.equal(tablaTrabajo.get("estado"), 0),criteria.and(criteria.equal(tablaTrabajo.get("presupuesto").get("especialidad"), especialidad)))
			entityManager.createQuery(query).resultList
		} catch (HibernateException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("ERROR: La BD no tiene informacion del trabajo consultado.", e)
		} finally {
			entityManager?.close
		}
	}
	
	def List<Turno> trabajoContratados(Long id) {
		val entityManager = this.administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val tablaTrabajo = query.from(tipoEntidad)
			// val camposZona = query.from(entityType)
			// camposZona.fetch("ofertas")
			query.select(tablaTrabajo)
			query.where(criteria.equal(tablaTrabajo.get("estado"), 1),criteria.and(criteria.equal(tablaTrabajo.get("idCliente"), id)))
			entityManager.createQuery(query).resultList
		} catch (HibernateException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("ERROR: La BD no tiene informacion del trabajo consultado.", e)
		} finally {
			entityManager?.close
		}
	}
	
	def List<Turno> trabajosFinalizados(Long id) {
		val entityManager = this.administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val tablaTrabajo = query.from(tipoEntidad)
			// val camposZona = query.from(entityType)
			// camposZona.fetch("ofertas")
			query.select(tablaTrabajo)
			query.where(criteria.equal(tablaTrabajo.get("estado"), 2),criteria.and(criteria.equal(tablaTrabajo.get("idCliente"), id)))
			entityManager.createQuery(query).resultList
		} catch (HibernateException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("ERROR: La BD no tiene informacion del trabajo consultado.", e)
		} finally {
			entityManager?.close
		}
	}
	
// (allInstances.filter[p|p.estado===Estado.FINALIZADO]).toList

}
