package domain;

import domain.Chat;
import java.awt.Image;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;
import repositorio.RepoChats;

@Observable
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_USER", discriminatorType = DiscriminatorType.STRING)
@Accessors
@SuppressWarnings("all")
public abstract class Usuario implements Serializable {
  @Id
  @GeneratedValue
  private Long id;
  
  @Column(length = 50)
  private String usuario;
  
  @Column(length = 50)
  private String contrasenia;
  
  @Column(length = 50)
  private String nombreyApellido;
  
  @Column(length = 50)
  private int dni;
  
  @Column
  private LocalDate fechaDeNacimiento;
  
  @Column(length = 50)
  private int telefono;
  
  @Transient
  private Image foto;
  
  public void enviarChat(final Chat chat) {
    RepoChats.getInstance().persistirChat(chat);
  }
  
  @Pure
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id;
  }
  
  @Pure
  public String getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(final String usuario) {
    this.usuario = usuario;
  }
  
  @Pure
  public String getContrasenia() {
    return this.contrasenia;
  }
  
  public void setContrasenia(final String contrasenia) {
    this.contrasenia = contrasenia;
  }
  
  @Pure
  public String getNombreyApellido() {
    return this.nombreyApellido;
  }
  
  public void setNombreyApellido(final String nombreyApellido) {
    this.nombreyApellido = nombreyApellido;
  }
  
  @Pure
  public int getDni() {
    return this.dni;
  }
  
  public void setDni(final int dni) {
    this.dni = dni;
  }
  
  @Pure
  public LocalDate getFechaDeNacimiento() {
    return this.fechaDeNacimiento;
  }
  
  public void setFechaDeNacimiento(final LocalDate fechaDeNacimiento) {
    this.fechaDeNacimiento = fechaDeNacimiento;
  }
  
  @Pure
  public int getTelefono() {
    return this.telefono;
  }
  
  public void setTelefono(final int telefono) {
    this.telefono = telefono;
  }
  
  @Pure
  public Image getFoto() {
    return this.foto;
  }
  
  public void setFoto(final Image foto) {
    this.foto = foto;
  }
}
