package repositorio;

import domain.Presupuesto;
import domain.Profesional;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import repositorio.AbstractRepository;

@SuppressWarnings("all")
public class RepoProfesionales extends AbstractRepository<Profesional> {
  private static RepoProfesionales repoProfesionales;
  
  public static RepoProfesionales getInstance() {
    RepoProfesionales _xblockexpression = null;
    {
      if ((RepoProfesionales.repoProfesionales == null)) {
        RepoProfesionales _repoProfesionales = new RepoProfesionales();
        RepoProfesionales.repoProfesionales = _repoProfesionales;
      }
      _xblockexpression = RepoProfesionales.repoProfesionales;
    }
    return _xblockexpression;
  }
  
  private List<Profesional> profesionales = new ArrayList<Profesional>();
  
  public void enviarNotificacionDePresupuesto(final Presupuesto problema) {
    final Consumer<Profesional> _function = new Consumer<Profesional>() {
      public void accept(final Profesional profesional) {
        boolean _equals = profesional.getProfesion().equals(problema.getEspecialidad());
        if (_equals) {
          profesional.agregarPresupuesto(problema);
        }
      }
    };
    this.profesionales.forEach(_function);
  }
  
  public List<Profesional> busquedaPorProfesion(final String profesion) {
    final Function1<Profesional, Boolean> _function = new Function1<Profesional, Boolean>() {
      public Boolean apply(final Profesional profesional) {
        return Boolean.valueOf(profesional.getProfesion().equals(profesion));
      }
    };
    return IterableExtensions.<Profesional>toList(IterableExtensions.<Profesional>filter(this.profesionales, _function));
  }
  
  public List<Profesional> busquedaPorZona(final String zona) {
    final Function1<Profesional, Boolean> _function = new Function1<Profesional, Boolean>() {
      public Boolean apply(final Profesional profesional) {
        return Boolean.valueOf(profesional.getZonaDeTrabajo().equals(zona));
      }
    };
    return IterableExtensions.<Profesional>toList(IterableExtensions.<Profesional>filter(this.profesionales, _function));
  }
  
  public List<Profesional> busquedaPorNombreYApellido(final String nombre) {
    final Function1<Profesional, Boolean> _function = new Function1<Profesional, Boolean>() {
      public Boolean apply(final Profesional profesional) {
        return Boolean.valueOf(profesional.getNombreyApellido().equals(nombre));
      }
    };
    return IterableExtensions.<Profesional>toList(IterableExtensions.<Profesional>filter(this.profesionales, _function));
  }
  
  public Class<Profesional> getEntityType() {
    return Profesional.class;
  }
}
