package domain

import org.uqbar.commons.model.annotations.Observable
import javax.persistence.Embeddable
import org.eclipse.xtend.lib.annotations.Accessors
import javax.persistence.Column

@Observable
@Embeddable
@Accessors
class Direccion {
	
	@Column(length=50)
	String provincia
	
	@Column(length=50)
	String ciudad
	
	@Column(length=50)
	int codPostal
	
	@Column(length=50)
	String calle
	
	@Column(length=50)
	int altura
	
	@Column(length=50)
	String pisoDep
	
	override toString(){
		"La direccion es:" + "de la provincia" + provincia + "de la ciudad:"+ ciudad + "del barrio" + codPostal + "de la calle" + calle + "altura" + altura + pisoDep
	}
	
		
}