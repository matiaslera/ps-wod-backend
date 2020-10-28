package domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import domain.Chat;
import domain.Tipo;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;
import repositorio.RepoChats;

@Observable
@Embeddable
@Accessors
@SuppressWarnings("all")
public class Usuario implements Serializable {
  @Column
  private String uid;
  
  @Column(length = 50)
  private String nombre;
  
  @Column(length = 50)
  private String apellido;
  
  @Column
  private String email;
  
  @Column
  private String nacionalidad;
  
  @Column(length = 50)
  private int dni;
  
  @JsonDeserialize(using = LocalDateDeserializer.class)
  private LocalDate fechaDeNacimiento;
  
  @Column(length = 20)
  private int telefono;
  
  @Column(length = 50)
  private String fotoUrl;
  
  @Column(length = 50)
  private String proveedor = null;
  
  @Column
  private Tipo tipo;
  
  public Usuario() {
  }
  
  public void enviarChat(final Chat chat) {
    RepoChats.getInstance().persistirChat(chat);
  }
  
  public String toString() {
    return (((((" nombre: " + this.nombre) + " apellido: ") + this.apellido) + "email: ") + this.email);
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
  public String getNacionalidad() {
    return this.nacionalidad;
  }
  
  public void setNacionalidad(final String nacionalidad) {
    this.nacionalidad = nacionalidad;
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
  
  @Pure
  public Tipo getTipo() {
    return this.tipo;
  }
  
  public void setTipo(final Tipo tipo) {
    this.tipo = tipo;
  }
}
