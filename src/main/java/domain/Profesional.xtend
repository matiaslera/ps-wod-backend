package domain

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Profesional extends Cliente {

	Long id

	String profesion

	String titulosObtenidos

	String experienciaLaboral

	String zonaDeTrabajo

}
