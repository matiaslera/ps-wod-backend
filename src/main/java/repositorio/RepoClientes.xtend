package repositorio

import domain.Cliente
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import domain.Usuario
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root
import org.hibernate.HibernateException

@Accessors
class RepoClientes extends AbstractRepository<Cliente> {

	static RepoClientes repoClientes

	def static RepoClientes getInstance() {
		if (repoClientes === null) {
			repoClientes = new RepoClientes
		}
		repoClientes
	}

	List<Cliente> usuarios = new ArrayList

	def void persistirUsuario(Cliente usuario) {
		usuarios.add(usuario)
	}

	def login(Usuario usuario) {
		usuarios.forEach[usu|usu.usuario.equals(usuario)]
	}

	override getEntityType() {
		Cliente
	}
	
	override generateWhere(CriteriaBuilder criteria, CriteriaQuery<Cliente> query, Root<Cliente> camposCandidato, Cliente user) {
		if (user.usuario !== null) {
			query.where(criteria.equal(camposCandidato.get("id"), user.id))
		}
	}
	
	def Cliente searchById(Long id) {
		val entityManager = entityManager
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(entityType)
			val _User = query.from(entityType)
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
		val entityManager = entityManager
		try {
			val criteria = entityManager.criteriaBuilder
			val query = criteria.createQuery(entityType)
			val _User = query.from(entityType)
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

}
