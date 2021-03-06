package runnable

import org.uqbar.xtrest.api.XTRest
import org.uqbar.xtrest.api.annotation.Controller
import restApi.RestControllerUser
import restApi.RestControllerPresupuesto
import restApi.RestControllerTurno

@Controller
class WorkOfDayApplication {

	new (WorkOfDayBootstrap mock){}
	
	def static void main(String[] args) {
		new WorkOfDayApplication(new WorkOfDayBootstrap) 
		XTRest.startInstance(8080, new RestControllerUser(),
			new RestControllerPresupuesto,
			new RestControllerTurno
		)
		///agreagar mas controller
	}
	
}



