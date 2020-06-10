package repositorio;

import domain.Presupuesto;
import exceptions.BusinessException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RepoPresupuestos {
  private static RepoPresupuestos repoPresupuestos;
  
  public static RepoPresupuestos getInstance() {
    RepoPresupuestos _xblockexpression = null;
    {
      if ((RepoPresupuestos.repoPresupuestos == null)) {
        RepoPresupuestos _repoPresupuestos = new RepoPresupuestos();
        RepoPresupuestos.repoPresupuestos = _repoPresupuestos;
      }
      _xblockexpression = RepoPresupuestos.repoPresupuestos;
    }
    return _xblockexpression;
  }
  
  private List<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
  
  public void persistirPresupuesto(final Presupuesto presupuesto) {
    this.presupuestos.add(presupuesto);
  }
  
  public List<Presupuesto> buscarPresupuesto(final Presupuesto problema) {
    try {
      List<Presupuesto> filtroProfesional = this.filtrarPresupuestoPorProfesion(problema);
      final Function1<Presupuesto, Boolean> _function = new Function1<Presupuesto, Boolean>() {
        public Boolean apply(final Presupuesto p) {
          return Boolean.valueOf(p.getDescripcion().contains(problema.getDescripcion()));
        }
      };
      Iterable<Presupuesto> filtro = IterableExtensions.<Presupuesto>filter(filtroProfesional, _function);
      boolean _isEmpty = IterableExtensions.isEmpty(filtro);
      if (_isEmpty) {
        throw new BusinessException("No se encontro presupuesto para el problema");
      } else {
        return IterableExtensions.<Presupuesto>toList(filtro);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public List<Presupuesto> filtrarPresupuestoPorProfesion(final Presupuesto problema) {
    final Function1<Presupuesto, Boolean> _function = new Function1<Presupuesto, Boolean>() {
      public Boolean apply(final Presupuesto p) {
        return Boolean.valueOf(p.getEspecialidad().equals(problema.getEspecialidad()));
      }
    };
    return IterableExtensions.<Presupuesto>toList(IterableExtensions.<Presupuesto>filter(this.presupuestos, _function));
  }
  
  @Pure
  public List<Presupuesto> getPresupuestos() {
    return this.presupuestos;
  }
  
  public void setPresupuestos(final List<Presupuesto> presupuestos) {
    this.presupuestos = presupuestos;
  }
}
