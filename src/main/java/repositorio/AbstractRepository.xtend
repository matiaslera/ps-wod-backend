package repositorio

import java.util.List
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence
import javax.persistence.PersistenceException
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

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
	def List<T> searchByExample(T t) {
		val entityManager = this.administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder //creando una consulta, devuelve Criteriaquery object
			val query = criteria.createQuery(tipoEntidad) //asigna lo que va a buscar la consulta, devuelve  Criteriaquery object
			val from = query.from(tipoEntidad)//asigna una tabla donde busca la consulta, devuelve  Criteriaquery object
			query.select(from)
			generateWhere(criteria, query, from, t)
			entityManager.createQuery(query).resultList
		} finally {
			entityManager?.close
		}
	}
	abstract def void generateWhere(CriteriaBuilder criterio, CriteriaQuery<T> query, Root<T> camposCandidato, T user)
	/**
	 * Inserta un nuevo objeto en la tabla
	 */
	def void create(T t) {
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
	def void update(T t) {
		val entityManager = this.administradorEntidad
		try {
			entityManager => [
				transaction.begin
				merge(t)
				//refresh(t) Actualiza el estado de la instancia desde la base de datos, sobrescribiendo los cambios realizados en la entidad.
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
	def void delete(T t){
		val entityManager = this.administradorEntidad
		try {
			entityManager => [
				transaction.begin
				//remove(t) //Elimina la instancia de la entidad.
				//detach(t)//Elimina la entidad dada del contexto de persistencia, lo que provoca que una entidad gestionada se separe.
				remove(contains(t) ? t : merge(t));
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
	}
	/**
	 * Buscar un objeto en la tabla por Id
	 */
	def getId(Long id){
	val entityManager = this.administradorEntidad
		try {
			return entityManager.find(tipoEntidad,id) //se encuentra de forma activa, si no encuentra algo no pasa nada
			//return  entityManager.getReference(tipoEntidad,id) se encuentra de forma perezosa, se devuelve un error si no se encuetra
		} 
		 catch (PersistenceException  e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("Ocurrió un error,no se pudo encontrar este objeto", e)
		}
         finally {
			entityManager?.close	
		}
	}
	/**
	 * Eliminar el contexto de persistencia, haciendo que todas las entidades administradas se desconecten
	 */
	def deleteContexto(){
	val entityManager = this.administradorEntidad
		try {
			return entityManager=>[clear]
		} 
		 catch (PersistenceException  e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("Ocurrió un error,no se pudo eliminar las sesiones abiertas", e)
		}
         finally {
			entityManager?.close	
		}
	}
	
	def isFoundContexto(T t){
	val entityManager = this.administradorEntidad
		try {
			return entityManager=>[contains(t)] 
		} 
		 catch (PersistenceException  e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("Ocurrió un error,no se pudo eliminar las sesiones abiertas", e)
		}
         finally {
			entityManager?.close	
		}
	}
	
}
/*
interface Dao <T>{
	
	def Optional<T> get(long id);
    
    def List<T> getAll();
    
    def void save(T t);
    
    def void update(T t, String[] params);
    
    def void delete(T t);
}

 * def ejecutarTransaccion(Consumer<EntityManager> action, T t, String accion) {
		val entityManager = this.administradorEntidad
        val transaccion = entityManager.transaction
        try {
            transaccion.begin();
            action.accept(entityManager);
            transaccion.commit(); 
        }
        catch (RuntimeException e) {
        	e.printStackTrace
            transaccion.rollback();
            throw new RuntimeException("Ocurrió un error"+accion+ t.toString(), e)
        }
         finally {
			entityManager?.close	
		}
    }
 */
/*Errores
 *  catch (HibernateException ex) {
              throw new TransactionRequiredException("existe un transaccion en el proceso");
          } 
		catch (Exception ex) {
              throw new EntityExistsException("La entidad ya existe", ex);
          }
 */