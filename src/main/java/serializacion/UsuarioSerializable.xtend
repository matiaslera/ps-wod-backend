package serializacion

//import com.fasterxml.jackson.databind.ser.std.StdSerializer
import domain.Usuario
import java.time.format.DateTimeFormatter
import java.time.LocalDate
import com.fasterxml.jackson.core.JsonGenerator
//import com.fasterxml.jackson.databind.SerializerProvider
import java.io.IOException
import java.util.Set
//import com.fasterxml.jackson.databind.ObjectMapper
//import com.fasterxml.jackson.databind.module.SimpleModule
/*
class UsuarioSerializable extends StdSerializer<Usuario> {

	new(Class<Usuario> t) {
		super(t);
	}
	
   	static final DateTimeFormatter FORMATTER2 = DateTimeFormatter.ofPattern("dd/MM/yyyy")
	
	def getStringDateFromLocalDate(LocalDate date){date.format(FORMATTER2)}
	
	override serialize(Usuario value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeStringField("id", value.uid.toString);
		gen.writeStringField("usuario", value.nombre.toString);
		gen.writeStringField("contrasenia", value.apellido);
		gen.writeStringField("nombreyApellido", value.nombre);
		gen.writeNumberField("dni", value.dni);
		gen.writeNumberField("telefono", value.telefono);
		gen.writeEndObject();
	}
	
	static def String toJson(Usuario vuelo) {
		mapper().writeValueAsString(vuelo)
	}
	
	static def String toJson(Set<Usuario> vuelos) {
		if(vuelos===null || vuelos.empty){return "[ ]"}
		mapper().writeValueAsString(vuelos)
	}
	static def mapper(){
		val ObjectMapper mapper = new ObjectMapper()
		val SimpleModule module = new SimpleModule()
		module.addSerializer(Usuario,new UsuarioSerializable(Usuario))
		mapper.registerModule(module)
		mapper
	}
} */