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
			query.where(criteria.equal(camposCandidato.get("id"), user.usuario.uid))
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
	
	def trabajosPendiente(Long id){
		val user=searchById(id)
		return user.ofertasJob.filter[job|job.contratado==true && job.realizado==false].toSet
	}
	
	def trabajosFinalizado(Long id){
		val user=searchById(id)
		println(user.toString)
		return user.ofertasJob.filter[job|job.contratado==true && job.realizado==true].toSet
	}
	
	def consultasRealizadas(Long id){
		val user=searchById(id)
		return user.ofertasJob.filter[job|job.contratado==false && job.realizado==false].toSet
	}
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