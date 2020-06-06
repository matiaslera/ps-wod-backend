package runnable

class WorkOfDayApplication {

	static def void main(String[] args) {
		val inicializador = new WorkOfDayBootstrap()
		inicializador.run()
	}
}
