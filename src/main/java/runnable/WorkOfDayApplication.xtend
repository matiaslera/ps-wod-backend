package runnable

import org.uqbar.xtrest.api.XTRest
import org.uqbar.xtrest.api.annotation.Controller

@Controller
class WorkOfDayApplication {

	def static void main(String[] args) {
		(new WorkOfDayBootstrap).run
		XTRest.start(8080, WorkOfDayApplication)
	}
}
