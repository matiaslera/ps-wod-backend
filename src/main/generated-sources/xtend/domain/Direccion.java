package domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;

@Observable
@Embeddable
@Accessors
@SuppressWarnings("all")
public class Direccion {
  @Column(length = 50)
  private String provincia;
  
  @Column(length = 50)
  private String ciudad;
  
  @Column(length = 50)
  private int codPostal;
  
  @Column(length = 50)
  private String calle;
  
  @Column(length = 50)
  private int altura;
  
  @Column(length = 50)
  private String pisoDep;
  
  public String toString() {
    return ((((((((((("La direccion es:" + "de la provincia") + this.provincia) + "de la ciudad:") + this.ciudad) + "del barrio") + Integer.valueOf(this.codPostal)) + "de la calle") + this.calle) + "altura") + Integer.valueOf(this.altura)) + this.pisoDep);
  }
  
  @Pure
  public String getProvincia() {
    return this.provincia;
  }
  
  public void setProvincia(final String provincia) {
    this.provincia = provincia;
  }
  
  @Pure
  public String getCiudad() {
    return this.ciudad;
  }
  
  public void setCiudad(final String ciudad) {
    this.ciudad = ciudad;
  }
  
  @Pure
  public int getCodPostal() {
    return this.codPostal;
  }
  
  public void setCodPostal(final int codPostal) {
    this.codPostal = codPostal;
  }
  
  @Pure
  public String getCalle() {
    return this.calle;
  }
  
  public void setCalle(final String calle) {
    this.calle = calle;
  }
  
  @Pure
  public int getAltura() {
    return this.altura;
  }
  
  public void setAltura(final int altura) {
    this.altura = altura;
  }
  
  @Pure
  public String getPisoDep() {
    return this.pisoDep;
  }
  
  public void setPisoDep(final String pisoDep) {
    this.pisoDep = pisoDep;
  }
}
