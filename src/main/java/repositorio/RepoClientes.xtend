package repositorio

import domain.Cliente
import org.eclipse.xtend.lib.annotations.Accessors
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root
import org.hibernate.HibernateException
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence
import javax.persistence.EntityManager
import domain.Usuario
import javax.persistence.NoResultException

@Accessors
class RepoClientes extends AbstractRepository<Cliente> {

	static RepoClientes repoClientes

	def static RepoClientes getInstance() {
		if (repoClientes === null) {
			repoClientes = new RepoClientes
		}
		repoClientes
	}

	override getTipoEntidad() {
		Cliente
	}
	
	override generateWhere(CriteriaBuilder criteria, CriteriaQuery<Cliente> query, Root<Cliente> camposCandidato, Cliente user) {
		if (user.usuario.nombre !== null) {
			query.where(criteria.equal(camposCandidato.get("id"), user.id))
		}
	}
	
	def Cliente searchById(Long id) {
		val entityManager = administradorEntidad
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
			throw new RuntimeException("ERROR: La BD no tiene informacion del cliente.", e)
		} finally {
			entityManager?.close
		}
	}
	
	def Cliente searchByEmail(String email) {
		val entityManager = administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val _User = query.from(tipoEntidad)
			query.select(_User)
			query.where(criteria.equal(_User.get("usuario").get("email"), email))
			entityManager.createQuery(query).singleResult
		}catch (NoResultException nre){
			return new Cliente()=>[
				id = Long.valueOf(0)
			]
		} catch (HibernateException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("ERROR: La BD no tiene informacion del cliente.", e)
		} 
		finally {
			entityManager?.close
		}
	}

	def Cliente searchByIdUser(String id) {
		val entityManager = administradorEntidad
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
			throw new RuntimeException("ERROR: La BD no tiene informacion del cliente.", e)
		} finally {
			entityManager?.close
		}
	}
	
	def ultimoIdCliente(){
		val entityManager = administradorEntidad
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(tipoEntidad)
			val _User = query.from(tipoEntidad)
			query.select(_User)
			query.orderBy(criteria.desc(_User.get("id")))
			val list = entityManager.createQuery(query).resultList
			   if(list.empty ) {
			   	return 0}
			   	else{
			   		 return list.get(0).id
			   	}
		} catch (HibernateException e) {
			e.printStackTrace
			entityManager.transaction.rollback
			throw new RuntimeException("ERROR: La BD no tiene informacion del cliente.", e)
		} finally {
			entityManager?.close
		}
	}
//	def trabajosPendiente(Long id){
//		val user=searchById(id)
//		return user.ofertasJob.filter[job|job.contratado==true && job.realizado==false].toSet
//	}
//	
//	def trabajosFinalizado(Long id){
//		val user=searchById(id)
//		println(user.toString)
//		return user.ofertasJob.filter[job|job.contratado==true && job.realizado==true].toSet
//	}
//	
//	def consultasRealizadas(Long id){
//		val user=searchById(id)
//		return user.ofertasJob.filter[job|job.contratado==false && job.realizado==false].toSet
//	}
}

@Accessors
class SingletonClientes{
	
	 static SingletonClientes clientePers = new SingletonClientes()
	
	 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WorkOfDay")
	EntityManager entityManager = entityManagerFactory.createEntityManager()
	
	def static SingletonClientes getInstance() {
		if (clientePers === null) {
			clientePers = new SingletonClientes()
		}
		clientePers
	}
	
}