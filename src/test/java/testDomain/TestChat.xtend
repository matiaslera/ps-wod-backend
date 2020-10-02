package testDomain

import domain.Chat
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import repositorio.RepoChats

class TestChat {
	
	JuegoDeDatos datos
	Chat conversacion1
	Chat conversacion2
	Chat conversacion3
/* 
	@Before
	def void init() {
		datos = new JuegoDeDatos
		datos.inicializarDatos

		// simulacion de conversación por chat
		conversacion1 = new Chat
		conversacion1.origen = datos.jose.usuario
		conversacion1.destinatario = datos.daniel.usuario
		conversacion1.mensaje = "Deseo cambiar fecha del turno"
		datos.jose.enviarChat(conversacion1)

		conversacion2 = new Chat
		conversacion2.origen = datos.daniel.usuario
		conversacion2.destinatario = datos.jose.usuario
		conversacion2.mensaje = "No se puede, no tengo libre hasta dentro de tres meses"
		datos.daniel.enviarChat(conversacion2)

		conversacion3 = new Chat
		conversacion3.origen = datos.jose.usuario
		conversacion3.destinatario = datos.daniel.usuario
		conversacion3.mensaje = "Ok, lo dejamos así entonces"
		datos.jose.enviarChat(conversacion3)

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
	}*/
}
