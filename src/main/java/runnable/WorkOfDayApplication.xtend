package runnable

import org.uqbar.xtrest.api.XTRest
import org.uqbar.xtrest.api.annotation.Controller
import restApi.RestControllerUser
import restApi.RestControllerPresupuesto

@Controller
class WorkOfDayApplication {

	def static void main(String[] args) {
		val datos = new WorkOfDayBootstrap 
		XTRest.startInstance(8080, new RestControllerUser(datos),
			new RestControllerPresupuesto
		)
		///agreagar mas controller
	}
	
}



