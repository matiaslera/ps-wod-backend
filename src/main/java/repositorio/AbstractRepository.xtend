package repositorio

import com.mongodb.MongoClient
import domain.Cliente
import domain.Profesional
import org.mongodb.morphia.Datastore
import org.mongodb.morphia.Morphia

abstract class AbstractRepository<T> {
	Datastore ds

	new() {
		if (ds === null) {

			val mongo = new MongoClient("localhost", 27017)

			new Morphia => [
				map(Cliente).map(Profesional)
				ds = createDatastore(mongo, "WORK OF DAY")
				ds.ensureIndexes
			]
			println("Conectado a MongoDB. Bases: " + ds.getDB.collectionNames)

		}
	}
	
	abstract def Class<T> getEntityType()
	
	def T create(T t) {
		ds.save(t)
		t
	}
	
}
