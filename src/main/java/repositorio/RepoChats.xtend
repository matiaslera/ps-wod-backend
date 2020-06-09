package repositorio

import domain.Chat
import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class RepoChats {

	static RepoChats repoChats

	def static RepoChats getInstance() {
		if (repoChats === null) {
			repoChats = new RepoChats
		}
		repoChats
	}

	ArrayList<Chat> mensajes = new ArrayList

	def void persistirChat(Chat chat) {
		mensajes.add(chat)
	}
	
	

}
