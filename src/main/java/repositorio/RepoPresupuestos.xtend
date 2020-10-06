package repositorio

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import domain.Presupuesto
import exceptions.BusinessException
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root
import org.hibernate.HibernateException

@Accessors
class RepoPresupuestos extends AbstractRepository<Presupuesto> {
	
	static RepoPresupuestos instance = null

	 new() {
	}

	static def getInstance() {
		if (instance === null) {
			instance = new RepoPresupuestos
		}
		instance
	}

	def List<Presupuesto> filtrarPresupuestoPorProfesion(String especialidad) {
		(trabajosRealizados.filter[p|p.especialidad.equals(especialidad)]).toList
	}
	
	override getTipoEntidad() {
		Presupuesto
	}
	
	override generateWhere(CriteriaBuilder criteria, CriteriaQuery<Presupuesto> query, Root<Presupuesto> camposCandidato, Presupuesto pre) {
		if (pre.id === null) {
			query.where(criteria.equal(camposCandidato.get("id"), pre.id))
			}
	}
	def List<Presupuesto> listPorProfesion(String especialidad) {
		(allInstances.filter[p|p.especialidad.equals(especialidad) && p.realizado===false]).toList
	}
	
	def search(String especialidad, String nombre) {
		var filtroProfesional = (this.filtrarPresupuestoPorProfesion(especialidad))
		var listBusqueda = filtroProfesional.filter([p|p.descripcion.contains(nombre)])
		if (listBusqueda.isEmpty) {
			throw new BusinessException("No se encontro presupuesto para el problema")
		}
		else{
			return (listBusqueda).toSet
		}
	}
	
	def List<Presupuesto> trabajosRealizados(){
		(allInstances.filter[p|p.realizado]).toList
	}
	
	def Presupuesto searchById(Long id) {
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

	def Presupuesto searchByIdUser(String id) {
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
