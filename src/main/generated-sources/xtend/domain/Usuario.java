package domain;

import domain.Chat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;
import repositorio.RepoChats;

@Observable
@Entity
@Table(name = "Usuario")
@Accessors
@SuppressWarnings("all")
public class Usuario implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(length = 50, name = "id_user")
  private String uid;
  
  @Column(length = 50)
  private String nombre;
  
  @Column(length = 50)
  private String apellido;
  
  @Column(name = "correo")
  private String email;
  
  @Column(length = 50)
  private int dni;
  
  @Temporal(TemporalType.DATE)
  private Date fechaDeNacimiento;
  
  @Column(length = 20)
  private int telefono;
  
  @Column(length = 50)
  private String fotoUrl;
  
  @Column(length = 50)
  private String proveedor = null;
  
  public Usuario() {
  }
  
  public void enviarChat(final Chat chat) {
    RepoChats.getInstance().persistirChat(chat);
  }
  
  public String toString() {
    return ((((("id: " + this.uid) + " nombre: ") + this.nombre) + " apellido: ") + this.apellido);
  }
  
  @Pure
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id;
  }
  
  @Pure
  public String getUid() {
    return this.uid;
  }
  
  public void setUid(final String uid) {
    this.uid = uid;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public String getApellido() {
    return this.apellido;
  }
  
  public void setApellido(final String apellido) {
    this.apellido = apellido;
  }
  
  @Pure
  public String getEmail() {
    return this.email;
  }
  
  public void setEmail(final String email) {
    this.email = email;
  }
  
  @Pure
  public int getDni() {
    return this.dni;
  }
  
  public void setDni(final int dni) {
    this.dni = dni;
  }
  
  @Pure
  public Date getFechaDeNacimiento() {
    return this.fechaDeNacimiento;
  }
  
  public void setFechaDeNacimiento(final Date fechaDeNacimiento) {
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
  public String getFotoUrl() {
    return this.fotoUrl;
  }
  
  public void setFotoUrl(final String fotoUrl) {
    this.fotoUrl = fotoUrl;
  }
  
  @Pure
  public String getProveedor() {
    return this.proveedor;
  }
  
  public void setProveedor(final String proveedor) {
    this.proveedor = proveedor;
  }
}
