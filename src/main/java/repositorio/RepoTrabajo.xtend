package repositorio

import domain.Trabajo
import exceptions.BusinessException
import java.util.List
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root
import org.hibernate.HibernateException

class RepoTrabajo extends AbstractRepository<Trabajo> {
	
	static RepoTrabajo instance = null

	 new() {
	}

	static def getInstance() {
		if (instance === null) {
			instance = new RepoTrabajo()
		}
		instance
	}

	def List<Trabajo> filtrarPresupuestoPorProfesion(String especialidad) {
		(trabajosRealizados.filter[p|p.presupuesto.especialidad.equals(especialidad)]).toList
	}
	
	override getTipoEntidad() {
		Trabajo
	}
	
	override generateWhere(CriteriaBuilder criterio, CriteriaQuery<Trabajo> query, Root<Trabajo> camposCandidato, Trabajo trabajo) {
		if (trabajo.id === null) {
			query.where(criterio.equal(camposCandidato.get("id"), trabajo.id))
			}
	}

	def List<Trabajo> listPorProfesion(String especialidad) {
		(allInstances.filter[p|p.presupuesto.especialidad.equals(especialidad) && p.realizado===false]).toList
	}
	
	def search(String especialidad, String nombre) {
		var filtroProfesional = (this.filtrarPresupuestoPorProfesion(especialidad))
		var listBusqueda = filtroProfesional.filter([p|p.presupuesto.nombre.contains(nombre)])
		if (listBusqueda.isEmpty) {
			throw new BusinessException("No se encontro presupuesto para el problema")
		}
		else{
			return (listBusqueda).toSet
		}
	}
	
	def List<Trabajo> trabajosRealizados(){
		(allInstances.filter[p|p.realizado]).toList
	}
	
	def Trabajo searchById(Long id) {
		val entityManager = this.administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val _User = query.from(tipoEntidad)
			//val camposZona = query.from(entityType)
			//camposZona.fetch("ofertas")
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

	def Trabajo searchByIdUser(String id) {
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
	
	
}