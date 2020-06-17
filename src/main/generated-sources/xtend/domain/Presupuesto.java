package domain;

import java.awt.Image;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Entity
@Accessors
@SuppressWarnings("all")
public class Presupuesto {
  @Id
  @GeneratedValue
  private Long id;
  
  @Column(length = 50)
  private String nombre;
  
  @Column(length = 50)
  private String especialidad;
  
  @Column(length = 250)
  private String descripcion;
  
  @Column(length = 50)
  private String direccion;
  
  @Column(length = 250)
  private String notas;
  
  @Column(length = 50)
  private float monto;
  
  @Column
  private LocalDate fecha;
  
  @Transient
  private List<Image> fotos = new ArrayList<Image>();
  
  @Pure
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
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
  public float getMonto() {
    return this.monto;
  }
  
  public void setMonto(final float monto) {
    this.monto = monto;
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
