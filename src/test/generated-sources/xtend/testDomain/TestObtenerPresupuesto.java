package testDomain;

import domain.Presupuesto;
import exceptions.BusinessException;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Before;
import org.junit.Test;
import testDomain.JuegoDeDatos;

@SuppressWarnings("all")
public class TestObtenerPresupuesto {
  private JuegoDeDatos datos;
  
  private Presupuesto presupuesto1;
  
  private Presupuesto presupuesto2;
  
  private Presupuesto presupuesto3;
  
  private Presupuesto presupuesto4;
  
  @Before
  public void init() {
    JuegoDeDatos _juegoDeDatos = new JuegoDeDatos();
    this.datos = _juegoDeDatos;
    this.datos.inicializarDatos();
    Presupuesto _presupuesto = new Presupuesto();
    final Procedure1<Presupuesto> _function = new Procedure1<Presupuesto>() {
      public void apply(final Presupuesto it) {
        it.setEspecialidad("Electricista");
        it.setDescripcion("cambio de tablero");
        it.setNotas("");
      }
    };
    Presupuesto _doubleArrow = ObjectExtensions.<Presupuesto>operator_doubleArrow(_presupuesto, _function);
    this.presupuesto1 = _doubleArrow;
    Presupuesto _presupuesto_1 = new Presupuesto();
    final Procedure1<Presupuesto> _function_1 = new Procedure1<Presupuesto>() {
      public void apply(final Presupuesto it) {
        it.setEspecialidad("Plomero");
        it.setDescripcion("cambio de caños de agua");
        it.setNotas("");
      }
    };
    Presupuesto _doubleArrow_1 = ObjectExtensions.<Presupuesto>operator_doubleArrow(_presupuesto_1, _function_1);
    this.presupuesto2 = _doubleArrow_1;
    Presupuesto _presupuesto_2 = new Presupuesto();
    final Procedure1<Presupuesto> _function_2 = new Procedure1<Presupuesto>() {
      public void apply(final Presupuesto it) {
        it.setEspecialidad("Electricista");
        it.setDescripcion("tablero");
      }
    };
    Presupuesto _doubleArrow_2 = ObjectExtensions.<Presupuesto>operator_doubleArrow(_presupuesto_2, _function_2);
    this.presupuesto3 = _doubleArrow_2;
    Presupuesto _presupuesto_3 = new Presupuesto();
    final Procedure1<Presupuesto> _function_3 = new Procedure1<Presupuesto>() {
      public void apply(final Presupuesto it) {
        it.setEspecialidad("Electricista");
        it.setDescripcion("instalacion de cables");
      }
    };
    Presupuesto _doubleArrow_3 = ObjectExtensions.<Presupuesto>operator_doubleArrow(_presupuesto_3, _function_3);
    this.presupuesto4 = _doubleArrow_3;
  }
  
  @Test
  public void consultaPresupuestoYLoEncuentra() {
  }
  
  @Test(expected = BusinessException.class)
  public void consultaPresupuestoYNoLoEncuentra() {
  }
  
  @Test
  public void enviarNotificacion() {
  }
}
