package AplicationModel

import domain.Profesional
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import repositorio.RepoProfesionales

@Accessors
class BusquedaProfesional {

	Profesional profesionalSeleccionado

	List<Profesional> usuarios = new ArrayList

	def void buscarPorNombre(String valorDeBusqueda) {
		usuarios = RepoProfesionales.instance.busquedaPorNombreYApellido(valorDeBusqueda)
	}

	def void buscarPorZona(String valorDeBusqueda) {
		usuarios = RepoProfesionales.instance.busquedaPorZona(valorDeBusqueda)
	}

	def void buscarPorProfesion(String valorDeBusqueda) {
		usuarios = RepoProfesionales.instance.busquedaPorProfesion(valorDeBusqueda)
	}

	def void limpiar() {
		usuarios.clear
	}

}
