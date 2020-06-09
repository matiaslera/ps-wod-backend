package testDomain

import org.junit.Before
import org.junit.Test
import domain.Cliente
import java.time.LocalDate
import domain.Profesional
import domain.Chat
import repositorio.RepoChats
import org.junit.Assert

class TestChat {

	Cliente jose
	Profesional daniel
	Chat conversacion1
	Chat conversacion2
	Chat conversacion3

	@Before
	def void init() {
		jose = new Cliente => [
			usuario = "josep"
			contrasenia = "12345"
			nombreyApellido = "Jose Gimenez"
			dni = "94562345"
			direccion = "Juan B. Justo 2734"
			fechaDeNacimiento = LocalDate.of(1990, 06, 15);
			telefono = "34652817"

		]

		daniel = new Profesional => [
			usuario = "dani"
			contrasenia = "2468"
			nombreyApellido = "Danel Ruiz"
			dni = "45621356"
			direccion = "Las Heras 2734"
			fechaDeNacimiento = LocalDate.of(1980, 08, 27);
			telefono = "45621367"
			profesion = "electricista"
			titulosObtenidos = "ecnico superior"
			experienciaLaboral = "mantenimiento en UNSAM"
			zonaDeTrabajo = "San Martin"
		]

		// simulacion de conversación por chat
		conversacion1 = new Chat
		conversacion1.origen = jose.usuario
		conversacion1.destinatario = daniel.usuario
		conversacion1.mensaje = "Deseo cambiar fecha del turno"
		jose.enviarChat(conversacion1)

		conversacion2 = new Chat
		conversacion2.origen = daniel.usuario
		conversacion2.destinatario = jose.usuario
		conversacion2.mensaje = "No se puede, no tengo libre hasta dentro de tres meses"
		daniel.enviarChat(conversacion2)

		conversacion3 = new Chat
		conversacion3.origen = jose.usuario
		conversacion3.destinatario = daniel.usuario
		conversacion3.mensaje = "Ok, lo dejamos así entonces"
		jose.enviarChat(conversacion3)

	}

	@Test
	def void envioDeMensajes() {
		Assert.assertEquals(RepoChats.instance.mensajes.size, 3, 0.1)
	}

	@Test
	def void simulacionDeConversacionPorChat() {
		var mensaje1 = RepoChats.instance.mensajes.get(0)
		Assert.assertTrue(mensaje1.origen.equals("josep"))
		Assert.assertTrue(mensaje1.destinatario.equals("dani"))
		var mensaje2 = RepoChats.instance.mensajes.get(1)
		Assert.assertTrue(mensaje2.origen.equals("dani"))
		Assert.assertTrue(mensaje2.destinatario.equals("josep"))
	}
}
