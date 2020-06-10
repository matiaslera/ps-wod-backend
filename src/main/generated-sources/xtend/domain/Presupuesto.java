package domain;

import java.awt.Image;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Presupuesto {
  private String especialidad;
  
  private String descripcion;
  
  private String direccion;
  
  private String notas;
  
  private float presupuesto;
  
  private LocalDate fecha;
  
  private List<Image> fotos = new ArrayList<Image>();
  
  @Pure
  public String getEspecialidad() {
    return this.especialidad;
  }
  
  public void setEspecialidad(final String especialidad) {
    this.especialidad = especialidad;
  }
  
  @Pure
  public String getDescripcion() {
    return this.descripcion;
  }
  
  public void setDescripcion(final String descripcion) {
    this.descripcion = descripcion;
  }
  
  @Pure
  public String getDireccion() {
    return this.direccion;
  }
  
  public void setDireccion(final String direccion) {
    this.direccion = direccion;
  }
  
  @Pure
  public String getNotas() {
    return this.notas;
  }
  
  public void setNotas(final String notas) {
    this.notas = notas;
  }
  
  @Pure
  public float getPresupuesto() {
    return this.presupuesto;
  }
  
  public void setPresupuesto(final float presupuesto) {
    this.presupuesto = presupuesto;
  }
  
  @Pure
  public LocalDate getFecha() {
    return this.fecha;
  }
  
  public void setFecha(final LocalDate fecha) {
    this.fecha = fecha;
  }
  
  @Pure
  public List<Image> getFotos() {
    return this.fotos;
  }
  
  public void setFotos(final List<Image> fotos) {
    this.fotos = fotos;
  }
}
