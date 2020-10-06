package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import domain.Oferta;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Entity
@Accessors
@SuppressWarnings("all")
public class Presupuesto {
  @Id
  @GeneratedValue
  private Long id;
  
  @Column(length = 50)
  private Long idProfesional;
  
  @Column(length = 50)
  private String problema;
  
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
  private boolean realizado = false;
  
  @Column
  private boolean contratado = false;
  
  @Column
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate fecha;
  
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
    return ((((("id: " + this.id) + " nombre: ") + this.problema) + " especialidad: ") + this.especialidad);
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
  public String getProblema() {
    return this.problema;
  }
  
  public void setProblema(final String problema) {
    this.problema = problema;
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
  public boolean isRealizado() {
    return this.realizado;
  }
  
  public void setRealizado(final boolean realizado) {
    this.realizado = realizado;
  }
  
  @Pure
  public boolean isContratado() {
    return this.contratado;
  }
  
  public void setContratado(final boolean contratado) {
    this.contratado = contratado;
  }
  
  @Pure
  public LocalDate getFecha() {
    return this.fecha;
  }
  
  public void setFecha(final LocalDate fecha) {
    this.fecha = fecha;
  }
  
  @Pure
  public Set<Oferta> getOfertas() {
    return this.ofertas;
  }
  
  public void setOfertas(final Set<Oferta> ofertas) {
    this.ofertas = ofertas;
  }
}
