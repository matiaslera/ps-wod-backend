package AplicationModel;

import domain.Profesional;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import repositorio.RepoProfesionales;

@Accessors
@SuppressWarnings("all")
public class BusquedaProfesional {
  private Profesional profesionalSeleccionado;
  
  private List<Profesional> usuarios = new ArrayList<Profesional>();
  
  public void buscarPorNombre(final String valorDeBusqueda) {
    this.usuarios = RepoProfesionales.getInstance().busquedaPorNombreYApellido(valorDeBusqueda);
  }
  
  public void buscarPorZona(final String valorDeBusqueda) {
    this.usuarios = RepoProfesionales.getInstance().busquedaPorZona(valorDeBusqueda);
  }
  
  public void buscarPorProfesion(final String valorDeBusqueda) {
    this.usuarios = RepoProfesionales.getInstance().busquedaPorProfesion(valorDeBusqueda);
  }
  
  public void limpiar() {
    this.usuarios.clear();
  }
  
  @Pure
  public Profesional getProfesionalSeleccionado() {
    return this.profesionalSeleccionado;
  }
  
  public void setProfesionalSeleccionado(final Profesional profesionalSeleccionado) {
    this.profesionalSeleccionado = profesionalSeleccionado;
  }
  
  @Pure
  public List<Profesional> getUsuarios() {
    return this.usuarios;
  }
  
  public void setUsuarios(final List<Profesional> usuarios) {
    this.usuarios = usuarios;
  }
}
