package domain

import javax.persistence.Entity
import org.eclipse.xtend.lib.annotations.Accessors
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column
import java.time.LocalDate

@Entity
@Accessors
class Oferta {
	
	@Id
	@GeneratedValue
	Long id
	
	@Column(length=150)
	String comentario
	
	@Column(length=20)
	int idProfesional 
	
	@Column(length=50)
	String nombreApellido
	
	@Column(length=100)
	String especialidad
	
	@Column(length=250)
	LocalDate fechaCreacion
	
	@Column(length=50)
	float monto
	
	
}