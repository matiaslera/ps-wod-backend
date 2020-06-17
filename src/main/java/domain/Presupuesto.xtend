package domain

import java.awt.Image
import java.time.LocalDate
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column
import javax.persistence.Transient
import javax.persistence.Entity

@Entity
@Accessors
class Presupuesto {
	
	@Id
	@GeneratedValue
	Long id
	
	@Column(length=50)
	String nombre
	
	@Column(length=50)
	String especialidad
	
	@Column(length=250)
	String descripcion
	
	@Column(length=50)
	String direccion
	
	@Column(length=250)
	String notas
	
	@Column(length=50)
	float monto
	
	@Column
	LocalDate fecha
	
	@Transient
	List<Image> fotos = new ArrayList
	
	
	override toString(){
		"id: "+ id + "nombre: "+ nombre
	}
}
