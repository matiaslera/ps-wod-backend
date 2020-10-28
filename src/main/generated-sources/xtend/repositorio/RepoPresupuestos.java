package repositorio;

import domain.Presupuesto;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.hibernate.HibernateException;
import repositorio.AbstractRepository;

@Accessors
@SuppressWarnings("all")
public class RepoPresupuestos extends AbstractRepository<Presupuesto> {
  private static RepoPresupuestos instance = null;
  
  public RepoPresupuestos() {
  }
  
  public static RepoPresupuestos getInstance() {
    RepoPresupuestos _xblockexpression = null;
    {
      if ((RepoPresupuestos.instance == null)) {
        RepoPresupuestos _repoPresupuestos = new RepoPresupuestos();
        RepoPresupuestos.instance = _repoPresupuestos;
      }
      _xblockexpression = RepoPresupuestos.instance;
    }
    return _xblockexpression;
  }
  
  public Class<Presupuesto> getTipoEntidad() {
    return Presupuesto.class;
  }
  
  public void generateWhere(final CriteriaBuilder criteria, final CriteriaQuery<Presupuesto> query, final Root<Presupuesto> camposCandidato, final Presupuesto pre) {
    String _nombre = pre.getNombre();
    boolean _tripleEquals = (_nombre == null);
    if (_tripleEquals) {
      query.where(criteria.equal(camposCandidato.<Object>get("nombre"), pre.getNombre()));
    }
  }
  
  public Presupuesto searchById(final Long id) {
    Presupuesto _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      Presupuesto _xtrycatchfinallyexpression = null;
      try {
        Presupuesto _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Presupuesto> query = criteria.<Presupuesto>createQuery(this.getTipoEntidad());
          final Root<Presupuesto> _User = query.<Presupuesto>from(this.getTipoEntidad());
          query.select(_User);
          query.where(criteria.equal(_User.<Object>get("id"), id));
          _xblockexpression_1 = entityManager.<Presupuesto>createQuery(query).getSingleResult();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion del presupuesto.", e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        if (entityManager!=null) {
          entityManager.close();
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  public Presupuesto searchByIdUser(final String id) {
    Presupuesto _xblockexpression = null;
    {
      final EntityManager entityManager = this.getAdministradorEntidad();
      Presupuesto _xtrycatchfinallyexpression = null;
      try {
        Presupuesto _xblockexpression_1 = null;
        {
          final CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
          final CriteriaQuery<Presupuesto> query = criteria.<Presupuesto>createQuery(this.getTipoEntidad());
          final Root<Presupuesto> _User = query.<Presupuesto>from(this.getTipoEntidad());
          query.select(_User);
          query.where(criteria.equal(_User.<Object>get("idUsuario"), id));
          _xblockexpression_1 = entityManager.<Presupuesto>createQuery(query).getSingleResult();
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof HibernateException) {
          final HibernateException e = (HibernateException)_t;
          e.printStackTrace();
          entityManager.getTransaction().rollback();
          throw new RuntimeException("ERROR: La BD no tiene informacion del presupuesto.", e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        if (entityManager!=null) {
          entityManager.close();
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
}
