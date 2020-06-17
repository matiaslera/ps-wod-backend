package repositorio;

import domain.Presupuesto;
import exceptions.BusinessException;
import java.util.List;
import java.util.Set;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
  
  public List<Presupuesto> filtrarPresupuestoPorProfesion(final String especialidad) {
    final Function1<Presupuesto, Boolean> _function = new Function1<Presupuesto, Boolean>() {
      public Boolean apply(final Presupuesto p) {
        return Boolean.valueOf(p.getEspecialidad().equals(especialidad));
      }
    };
    return IterableExtensions.<Presupuesto>toList(IterableExtensions.<Presupuesto>filter(this.allInstances(), _function));
  }
  
  public Class<Presupuesto> getEntityType() {
    return Presupuesto.class;
  }
  
  public void generateWhere(final CriteriaBuilder criteria, final CriteriaQuery<Presupuesto> query, final Root<Presupuesto> camposCandidato, final Presupuesto pre) {
    Long _id = pre.getId();
    boolean _tripleEquals = (_id == null);
    if (_tripleEquals) {
      query.where(criteria.equal(camposCandidato.<Object>get("id"), pre.getId()));
    }
  }
  
  public Set<Presupuesto> search(final String especialidad, final String nombre) {
    try {
      List<Presupuesto> filtroProfesional = this.filtrarPresupuestoPorProfesion(especialidad);
      final Function1<Presupuesto, Boolean> _function = new Function1<Presupuesto, Boolean>() {
        public Boolean apply(final Presupuesto p) {
          return Boolean.valueOf(p.getDescripcion().contains(nombre));
        }
      };
      Iterable<Presupuesto> listBusqueda = IterableExtensions.<Presupuesto>filter(filtroProfesional, _function);
      boolean _isEmpty = IterableExtensions.isEmpty(listBusqueda);
      if (_isEmpty) {
        throw new BusinessException("No se encontro presupuesto para el problema");
      } else {
        return IterableExtensions.<Presupuesto>toSet(listBusqueda);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
