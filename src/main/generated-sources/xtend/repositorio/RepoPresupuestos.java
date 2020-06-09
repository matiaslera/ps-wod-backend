package repositorio;

import domain.Presupuesto;
import java.util.ArrayList;
import java.util.List;

/* @Accessors */@SuppressWarnings("all")
public class RepoPresupuestos {
  private static RepoPresupuestos repoPresupuestos;
  
  public static RepoPresupuestos getInstance() {
    throw new Error("Unresolved compilation problems:"
      + "\n=== cannot be resolved.");
  }
  
  private List<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
  
  public void agregarPresupuesto(final Presupuesto presupuesto) {
    this.presupuestos.add(presupuesto);
  }
}
