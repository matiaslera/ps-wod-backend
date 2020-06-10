package repositorio;

import domain.Presupuesto;
import domain.Profesional;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("all")
public class RepoProfesionales {
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
}
