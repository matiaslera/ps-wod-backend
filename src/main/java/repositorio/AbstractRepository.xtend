package repositorio

import javax.persistence.PersistenceException
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

abstract class AbstractRepository<T> {

	abstract def Class<T> getEntityType()

	static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WorkOfDay")

	def getEntityManager() {
		entityManagerFactory.createEntityManager
	}

	def void create(T t) {
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

}
