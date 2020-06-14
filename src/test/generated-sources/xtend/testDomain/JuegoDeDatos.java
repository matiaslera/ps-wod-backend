package testDomain;

import domain.Cliente;
import domain.Profesional;
import java.time.LocalDate;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class JuegoDeDatos {
  private Cliente jose;
  
  private Profesional daniel;
  
  public void inicializarDatos() {
    Cliente _cliente = new Cliente();
    final Procedure1<Cliente> _function = new Procedure1<Cliente>() {
      public void apply(final Cliente it) {
        it.setUsuario("josep");
        it.setContrasenia("12345");
        it.setNombreyApellido("Jose Gimenez");
        it.setDireccion("Juan B. Justo 2734");
        it.setFechaDeNacimiento(LocalDate.of(1990, 6, 15));
      }
    };
    Cliente _doubleArrow = ObjectExtensions.<Cliente>operator_doubleArrow(_cliente, _function);
    this.jose = _doubleArrow;
    Profesional _profesional = new Profesional();
    final Procedure1<Profesional> _function_1 = new Procedure1<Profesional>() {
      public void apply(final Profesional it) {
        it.setUsuario("dani");
        it.setContrasenia("2468");
        it.setNombreyApellido("Danel Ruiz");
        it.setFechaDeNacimiento(LocalDate.of(1980, 8, 27));
        it.setProfesion("ElectricistaElectricista");
        it.setTitulosObtenidos("Técnico superior");
        it.setExperienciaLaboral("mantenimiento en UNSAM");
        it.setZonaDeTrabajo("San Martin");
      }
    };
    Profesional _doubleArrow_1 = ObjectExtensions.<Profesional>operator_doubleArrow(_profesional, _function_1);
    this.daniel = _doubleArrow_1;
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
