package testDomain;

import domain.Cliente;
import domain.Profesional;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class JuegoDeDatos {
  private Cliente jose;
  
  private Profesional daniel;
  
  public void inicializarDatos() {
  }
  
  @Pure
  public Cliente getJose() {
    return this.jose;
  }
  
  public void setJose(final Cliente jose) {
    this.jose = jose;
  }
  
  @Pure
  public Profesional getDaniel() {
    return this.daniel;
  }
  
  public void setDaniel(final Profesional daniel) {
    this.daniel = daniel;
  }
}
