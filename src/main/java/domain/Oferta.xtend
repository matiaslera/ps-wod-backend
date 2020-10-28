package domain

import javax.persistence.Entity
import org.eclipse.xtend.lib.annotations.Accessors
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column
import java.time.LocalDate
//import com.fasterxml.jackson.databind.annotation.JsonSerialize
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.annotation.JsonFormat

@Entity
@Accessors
class Oferta {
	
	@Id
	@GeneratedValue
	Long id
	
	@Column(length=50)
	Long idProfesional
	
	@Column(length=150)
	String comentario
	
	@Column(length=100)
	String especialidad
	
	//@JsonSerialize(using=LocalDateSerializer)
	//@JsonDeserialize(using=LocalDateDeserializer)
	@Column(length=250)
	@JsonFormat(pattern="yyyy-MM-dd")
	LocalDate fechaCreacion
	
	@Column(length=50)
	float montoAprox
	
	
}