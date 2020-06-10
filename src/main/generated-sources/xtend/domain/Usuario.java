package domain;

import domain.Chat;
import java.awt.Image;
import java.time.LocalDate;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import repositorio.RepoChats;

@Accessors
@SuppressWarnings("all")
public abstract class Usuario {
  private String usuario;
  
  private String contrasenia;
  
  private String nombreyApellido;
  
  private String dni;
  
  private LocalDate fechaDeNacimiento;
  
  private String telefono;
  
  private Image foto;
  
  public void enviarChat(final Chat chat) {
    RepoChats.getInstance().persistirChat(chat);
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
