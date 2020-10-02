package domain

import java.time.LocalDate

class Educacion {

	String titulo
	
	String establecimiento
	
	LocalDate fechaIngreso	
	
	LocalDate fechaFinalizacion
	
	override toString(){
		"El titulo es:" + titulo + "se curso en" + establecimiento + "desde:"+ fechaIngreso + "hasta:" + fechaFinalizacion 
	}
}