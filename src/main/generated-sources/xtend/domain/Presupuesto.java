package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import domain.Direccion;
import domain.Oferta;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;

@Observable
@Embeddable
@Accessors
@SuppressWarnings("all")
public class Presupuesto {
  @Column(length = 50)
  private String nombre;
  
  @Column(length = 50)
  private String especialidad;
  
  @Column(length = 150)
  private String descripcion;
  
  @Column(length = 150)
  private String notas;
  
  @Embedded
  private Direccion direccion;
  
  @Column
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate fechaCreacion;
  
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JsonProperty("ofertas")
  private Set<Oferta> ofertas;
  
  public void addOferta(final Oferta presupuesto) {
    this.ofertas.add(presupuesto);
  }
  
  public void removeOferta(final Oferta presupuesto) {
    this.ofertas.remove(presupuesto);
  }
  
  public Oferta encontrarOferta(final Oferta presupuesto) {
    final Function1<Oferta, Boolean> _function = new Function1<Oferta, Boolean>() {
      public Boolean apply(final Oferta pre) {
        return Boolean.valueOf(pre.equals(presupuesto));
      }
    };
    return IterableExtensions.<Oferta>head(IterableExtensions.<Oferta>filter(this.ofertas, _function));
  }
  
  public String toString() {
    return (((((" nombre: " + this.nombre) + " especialidad: ") + this.especialidad) + " descripcion:") + this.descripcion);
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
  public String getNotas() {
    return this.notas;
  }
  
  public void setNotas(final String notas) {
    this.notas = notas;
  }
  
  @Pure
  public Direccion getDireccion() {
    return this.direccion;
  }
  
  public void setDireccion(final Direccion direccion) {
    this.direccion = direccion;
  }
  
  @Pure
  public LocalDate getFechaCreacion() {
    return this.fechaCreacion;
  }
  
  public void setFechaCreacion(final LocalDate fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }
  
  @Pure
  public Set<Oferta> getOfertas() {
    return this.ofertas;
  }
  
  public void setOfertas(final Set<Oferta> ofertas) {
    this.ofertas = ofertas;
  }
}
