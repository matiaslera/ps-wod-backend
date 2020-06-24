package testDomain

import domain.Presupuesto
import java.time.LocalDate
import org.junit.Test
import org.junit.Before
import org.junit.Assert
import exceptions.BusinessException

class TestObtenerPresupuesto {

	JuegoDeDatos datos
	Presupuesto presupuesto1
	Presupuesto presupuesto2
	Presupuesto presupuesto3
	Presupuesto presupuesto4

	@Before
	def void init() {
		datos = new JuegoDeDatos
		datos.inicializarDatos

		presupuesto1 = new Presupuesto => [
			especialidad = "Electricista"
			descripcion = "cambio de tablero"
			direccion = "Santa Rosalia 2720"
			notas = ""
			monto = 3000
			fecha = LocalDate.of(2020, 02, 02)
		]

		presupuesto2 = new Presupuesto => [
			especialidad = "Plomero"
			descripcion = "cambio de caños de agua"
			direccion = "Belgrano 2720"
			notas = ""
			monto = 5000
			fecha = LocalDate.of(2014, 02, 10)
		]

		presupuesto3 = new Presupuesto => [
			especialidad = "Electricista"
			descripcion = "tablero"
		]

		presupuesto4 = new Presupuesto => [
			especialidad = "Electricista"
			descripcion = "instalacion de cables"
		]

		//RepoPresupuestos.instance.persistirPresupuesto(presupuesto1)
		//RepoPresupuestos.instance.persistirPresupuesto(presupuesto2)
	}

	@Test
	def void consultaPresupuestoYLoEncuentra() {
		//var presupuestos = datos.jose.obtenerPresupuesto(presupuesto3)
	//	Assert.assertEquals(presupuestos.get(0).monto, 3000, 0.1)
	}

	@Test(expected=BusinessException)
	def void consultaPresupuestoYNoLoEncuentra() {
	//	var presupuestos = datos.jose.obtenerPresupuesto(presupuesto4)
	//	Assert.assertEquals(presupuestos.get(0).monto, 3000, 0.1)
	}

	@Test
	def void enviarNotificacion() {
		datos.jose.enviarNotificacionPresupuesto(presupuesto4)
		//System.out.println(datos.daniel.consutasPres.size)
		//Assert.assertEquals(datos.daniel.consutasPres.size, 1 ,0.1)
	}
	
}
