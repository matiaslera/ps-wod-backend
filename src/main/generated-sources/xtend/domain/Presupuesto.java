package domain;

import domain.Cliente;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/* @Accessors */@SuppressWarnings("all")
public class Presupuesto {
  private String direccion;
  
  private String descripcion;
  
  private List<Image> fotos = new ArrayList<Image>();
  
  private Cliente cliente;
  
  private String especialidad;
  
  private String contacto;
  
  private String notas;
  
  private Double presupuesto;
}
