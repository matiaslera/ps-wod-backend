package repositorio

import javax.persistence.PersistenceException
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.Root
import javax.persistence.criteria.CriteriaQuery
import java.util.List
import domain.Usuario

abstract class AbstractRepository<T> {


	static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WorkOfDay")

	def List<T> allInstances() {
		val entityManager = this.entityManager
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(entityType)
			val from = query.from(entityType)
			query.select(from)
			entityManager.createQuery(query).resultList
		} finally {
			entityManager?.close
		}
	}

	abstract def Class<T> getEntityType()

	/**
	 * Devuelve segun la busqueda de un criterio
	 */
	def searchByExample(T t) {
		val entityManager = this.entityManager
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(entityType)
			val from = query.from(entityType)
			query.select(from)
			generateWhere(criteria, query, from, t)
			entityManager.createQuery(query).resultList
		} finally {
			entityManager?.close
		}
	}

	abstract def void generateWhere(CriteriaBuilder criteria, CriteriaQuery<T> query, Root<T> camposCandidato, T user)

	/**
	 * Inserta un nuevo objeto en la tabla
	 */
	def create(T t) {
		val entityManager = this.entityManager
		try {
			entityManager => [
				transaction.begin
				persist(t)
				transaction.commit
			]
		} catch (PersistenceException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e)
		} finally {
			entityManager?.close
		}
	}

	/**
	 * Modifica un objeto en la tabla
	 */
	def update(T t) {
		val entityManager = this.entityManager
		try {
			entityManager => [
				transaction.begin
				merge(t)
				transaction.commit
			]
		} catch (PersistenceException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("Ocurrió un error, la operación no puede completarse", e)
		} finally {
			entityManager?.close
		}
	}

	def getEntityManager() {
		entityManagerFactory.createEntityManager
	}

	//jety.server.Autentication
	
	
}
