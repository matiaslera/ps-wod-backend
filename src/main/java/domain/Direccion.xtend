package domain

class Direccion {

	String pais
	
	String provincia
	
	String ciudad
	
	String barrio
	
	String calle
	
	String altura
	
	String dep_piso
	
	override toString(){
		"La direccion es:" + pais + "de la provincia" + provincia + "de la ciudad:"+ ciudad + "del barrio" + barrio + "de la calle" + calle + "altura" + altura + dep_piso
	}
	
		
}