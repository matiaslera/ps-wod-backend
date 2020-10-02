package domain;

import java.time.LocalDate;

@SuppressWarnings("all")
public class Educacion {
  private String titulo;
  
  private String establecimiento;
  
  private LocalDate fechaIngreso;
  
  private LocalDate fechaFinalizacion;
  
  public String toString() {
    return ((((((("El titulo es:" + this.titulo) + "se curso en") + this.establecimiento) + "desde:") + this.fechaIngreso) + "hasta:") + this.fechaFinalizacion);
  }
}
