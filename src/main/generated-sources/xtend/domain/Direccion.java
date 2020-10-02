package domain;

@SuppressWarnings("all")
public class Direccion {
  private String pais;
  
  private String provincia;
  
  private String ciudad;
  
  private String barrio;
  
  private String calle;
  
  private String altura;
  
  private String dep_piso;
  
  public String toString() {
    return (((((((((((("La direccion es:" + this.pais) + "de la provincia") + this.provincia) + "de la ciudad:") + this.ciudad) + "del barrio") + this.barrio) + "de la calle") + this.calle) + "altura") + this.altura) + this.dep_piso);
  }
}
