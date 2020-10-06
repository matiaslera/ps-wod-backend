package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Entity
@Accessors
@SuppressWarnings("all")
public class Oferta {
  @Id
  @GeneratedValue
  private Long id;
  
  @Column(length = 150)
  private String comentario;
  
  @Column(length = 20)
  private int idProfesional;
  
  @Column(length = 50)
  private String nombreApellido;
  
  @Column(length = 100)
  private String especialidad;
  
  @Column(length = 250)
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate fechaCreacion;
  
  @Column(length = 50)
  private float monto;
  
  @Pure
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id;
  }
  
  @Pure
  public String getComentario() {
    return this.comentario;
  }
  
  public void setComentario(final String comentario) {
    this.comentario = comentario;
  }
  
  @Pure
  public int getIdProfesional() {
    return this.idProfesional;
  }
  
  public void setIdProfesional(final int idProfesional) {
    this.idProfesional = idProfesional;
  }
  
  @Pure
  public String getNombreApellido() {
    return this.nombreApellido;
  }
  
  public void setNombreApellido(final String nombreApellido) {
    this.nombreApellido = nombreApellido;
  }
  
  @Pure
  public String getEspecialidad() {
    return this.especialidad;
  }
  
  public void setEspecialidad(final String especialidad) {
    this.especialidad = especialidad;
  }
  
  @Pure
  public LocalDate getFechaCreacion() {
    return this.fechaCreacion;
  }
  
  public void setFechaCreacion(final LocalDate fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }
  
  @Pure
  public float getMonto() {
    return this.monto;
  }
  
  public void setMonto(final float monto) {
    this.monto = monto;
  }
}
