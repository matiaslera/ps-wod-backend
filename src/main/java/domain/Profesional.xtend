package domain

import org.eclipse.xtend.lib.annotations.Accessors
import org.mongodb.morphia.annotations.Entity

@Accessors
@Entity
class Profesional extends Cliente {

	Long id

	String profesion

	String titulosObtenidos

	String experienciaLaboral

	String zonaDeTrabajo

}
