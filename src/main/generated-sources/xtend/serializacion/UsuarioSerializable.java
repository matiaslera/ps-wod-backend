package serializacion;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import domain.Usuario;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class UsuarioSerializable extends StdSerializer<Usuario> {
  public UsuarioSerializable(final Class<Usuario> t) {
    super(t);
  }
  
  private static final DateTimeFormatter FORMATTER2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  
  public String getStringDateFromLocalDate(final LocalDate date) {
    return date.format(UsuarioSerializable.FORMATTER2);
  }
  
  public void serialize(final Usuario value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {
    gen.writeStartObject();
    gen.writeStringField("id", value.getId().toString());
    gen.writeStringField("usuario", value.getUsuario().toString());
    gen.writeStringField("contrasenia", value.getContrasenia());
    gen.writeStringField("nombreyApellido", value.getNombreyApellido());
    gen.writeNumberField("dni", value.getDni());
    gen.writeNumberField("telefono", value.getTelefono());
    gen.writeEndObject();
  }
  
  public static String toJson(final Usuario vuelo) {
    try {
      return UsuarioSerializable.mapper().writeValueAsString(vuelo);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static String toJson(final Set<Usuario> vuelos) {
    try {
      String _xblockexpression = null;
      {
        if (((vuelos == null) || vuelos.isEmpty())) {
          return "[ ]";
        }
        _xblockexpression = UsuarioSerializable.mapper().writeValueAsString(vuelos);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static ObjectMapper mapper() {
    ObjectMapper _xblockexpression = null;
    {
      final ObjectMapper mapper = new ObjectMapper();
      final SimpleModule module = new SimpleModule();
      UsuarioSerializable _usuarioSerializable = new UsuarioSerializable(Usuario.class);
      module.<Usuario>addSerializer(Usuario.class, _usuarioSerializable);
      mapper.registerModule(module);
      _xblockexpression = mapper;
    }
    return _xblockexpression;
  }
}
