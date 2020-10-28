package domain

import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column
import javax.persistence.Entity
import org.eclipse.xtend.lib.annotations.Accessors
import javax.persistence.Table
import javax.persistence.Embedded
import java.time.LocalDate

@Entity
@Accessors
@Table(name="Trabajo")
class Trabajo {
	
	@Id
	@GeneratedValue
	Long id
	
	@Column(length=50)
	Long idProfesional
	
	@Column(length=50)
	Long idCliente
	
	@Embedded
	Presupuesto presupuesto
	
	@Column(length=50)
	Double montoFinal
	
	@Column(length=10)
	int calificacion
	
	@Column(length=10)
	LocalDate fechaFinalizacion
	
	@Column
	boolean realizado = false
	
	@Column
	boolean contratado = false
	
	override toString(){
		"este trabajo con id: " + id +" esta contratado:"+realizado +" esta contratado: "+ contratado+ " con el profesional id: "+idProfesional +" con el cliente id: "+idCliente
	}
	}