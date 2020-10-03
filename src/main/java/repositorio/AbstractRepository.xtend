package repositorio

import javax.persistence.PersistenceException
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.Root
import javax.persistence.criteria.CriteriaQuery
import java.util.List
import domain.Usuario
import java.util.Optional
import javax.persistence.EntityExistsException
import javax.transaction.RollbackException
import javax.transaction.TransactionRequiredException

abstract class AbstractRepository <T>{

	//El patrón Data Access Object (DAO)- patrón estructural 
	static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WorkOfDay")
	
	def getAdministradorEntidad() {
		entityManagerFactory.createEntityManager
	}
    abstract def Class<T> getTipoEntidad()
    /**
	 * Devuelve todas las instacias de T
	 */	
	def List<T> allInstances() {
		val entityManager = this.administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val from = query.from(tipoEntidad)
			query.select(from)
			entityManager.createQuery(query).resultList
		} finally {
			entityManager?.close
		}
	}
	/**
	 * Devuelve segun la busqueda de un criterio
	 */
	def searchByExample(T t) {
		val entityManager = this.administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val from = query.from(tipoEntidad)
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
		val entityManager = this.administradorEntidad
		//entityType.newInstance()
		try {
			entityManager => [
				transaction.begin
				persist(t)
				transaction.commit
			]
		} 
		 catch (PersistenceException  e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("Ocurrió un error,no se pudo crea el objeto"+ t.toString(), e)
		}
         finally {
			entityManager?.close
		}
	}
	/**
	 * Modifica un objeto en la tabla
	 */
	def update(T t) {
		val entityManager = this.administradorEntidad
		try {
			entityManager => [
				transaction.begin
				merge(t)
				transaction.commit
			]
		} catch (PersistenceException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("Ocurrió un error, no se pudo actualizar el objeto"+ t.toString(), e)
		} finally {
			entityManager?.close
		}
	}
	/**
	 * Eliminar un objeto en la tabla
	 */
	def delete(T t){
		val entityManager = this.administradorEntidad
		try {
			entityManager => [
				transaction.begin
				remove(t)
				transaction.commit
			]
		} 
		 catch (PersistenceException  e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("Ocurrió un error,no se puede eliminar el objeto"+ t.toString(), e)
		}
         finally {
			entityManager?.close	
		}
	//jety.server.Autentication
	}

	def getId(Long id){
		/*val entityManager = this.administradorEntidad
		try {
			entityManager => [
				transaction.begin
				T entidad= fin(getTipoEntidad)
				transaction.commit
			]
		} 
		 catch (PersistenceException  e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("Ocurrió un error,no se puede eliminar el objeto"+ t.toString(), e)
		}
         finally {
			entityManager?.close	
		}
		
		 *  Session session = sessionFactory.getCurrentSession();
 76:         try {
 77:             session.beginTransaction();
 78:             T entity = (T) session.get(getEntityClass(), id);
 79:             session.getTransaction().commit();
 80:
 81:             return entity;
		 */
	}
}

interface Dao <T>{
	
	def Optional<T> get(long id);
    
    def List<T> getAll();
    
    def void save(T t);
    
    def void update(T t, String[] params);
    
    def void delete(T t);
}

/*Errores
 * 
 *  catch (HibernateException ex) {
              throw new TransactionRequiredException("existe un transaccion en el proceso");
          } 
		catch (Exception ex) {
              throw new EntityExistsException("La entidad ya existe", ex);
          }
 */