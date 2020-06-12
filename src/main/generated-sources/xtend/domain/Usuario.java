package domain;

import domain.Chat;
import java.awt.Image;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import repositorio.RepoChats;

@Accessors
@Entity
@SuppressWarnings("all")
public class Usuario {
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
  private String dni;
  
  @Column
  private LocalDate fechaDeNacimiento;
  
  @Column(length = 50)
  private String telefono;
  
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
  public String getDni() {
    return this.dni;
  }
  
  public void setDni(final String dni) {
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
  public String getTelefono() {
    return this.telefono;
  }
  
  public void setTelefono(final String telefono) {
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
