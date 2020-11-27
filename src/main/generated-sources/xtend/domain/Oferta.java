package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
  
  @Column(length = 50)
  private Long idProfesional;
  
  @Column(length = 150)
  private String comentario;
  
  @Column(length = 100)
  private String especialidad;
  
  @Column(length = 50)
  private String nombreProf;
  
  @Column(length = 50)
  private String apellidoProf;
  
  @Column(length = 250)
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JsonIgnore
  private LocalDate fechaCreacion;
  
  @Column(length = 50)
  private float montoAprox;
  
  private static String DATE_PATTERN = "yyyy/MM/dd";
  
  public String toString() {
    return ((((("este es la oferta con id: " + this.id) + "id del profesional: ") + this.idProfesional) + "COMEntario del profe: ") + this.comentario);
  }
  
  @JsonProperty("fechaCreacion")
  public String fechaNacimiento() {
    return this.formatter().format(this.fechaCreacion);
  }
  
  @JsonProperty("fechaCreacion")
  public void asignarFechaDeNacimiento(final String fecha) {
    this.fechaCreacion = LocalDate.parse(fecha, this.formatter());
  }
  
  public DateTimeFormatter formatter() {
    return DateTimeFormatter.ofPattern(Oferta.DATE_PATTERN);
  }
  
  @Pure
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id;
  }
  
  @Pure
  public Long getIdProfesional() {
    return this.idProfesional;
  }
  
  public void setIdProfesional(final Long idProfesional) {
    this.idProfesional = idProfesional;
  }
  
  @Pure
  public String getComentario() {
    return this.comentario;
  }
  
  public void setComentario(final String comentario) {
    this.comentario = comentario;
  }
  
  @Pure
  public String getEspecialidad() {
    return this.especialidad;
  }
  
  public void setEspecialidad(final String especialidad) {
    this.especialidad = especialidad;
  }
  
  @Pure
  public String getNombreProf() {
    return this.nombreProf;
  }
  
  public void setNombreProf(final String nombreProf) {
    this.nombreProf = nombreProf;
  }
  
  @Pure
  public String getApellidoProf() {
    return this.apellidoProf;
  }
  
  public void setApellidoProf(final String apellidoProf) {
    this.apellidoProf = apellidoProf;
  }
  
  @Pure
  public LocalDate getFechaCreacion() {
    return this.fechaCreacion;
  }
  
  public void setFechaCreacion(final LocalDate fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }
  
  @Pure
  public float getMontoAprox() {
    return this.montoAprox;
  }
  
  public void setMontoAprox(final float montoAprox) {
    this.montoAprox = montoAprox;
  }
}
