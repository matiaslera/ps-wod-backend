package restApi;

import domain.Cliente;
import domain.Usuario;
import java.io.IOException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.model.exceptions.UserException;
import org.uqbar.xtrest.api.Result;
import org.uqbar.xtrest.api.annotation.Body;
import org.uqbar.xtrest.api.annotation.Controller;
import org.uqbar.xtrest.api.annotation.Delete;
import org.uqbar.xtrest.api.annotation.Get;
import org.uqbar.xtrest.api.annotation.Post;
import org.uqbar.xtrest.api.annotation.Put;
import org.uqbar.xtrest.json.JSONUtils;
import org.uqbar.xtrest.result.ResultFactory;
import repositorio.RepoClientes;
import repositorio.RepoProfesionales;
import repositorio.RepoUsuario;

@Controller
@SuppressWarnings("all")
public class RestControllerUser extends ResultFactory {
  @Extension
  private JSONUtils _jSONUtils = new JSONUtils();
  
  private RepoClientes repoClientes = new RepoClientes();
  
  private RepoProfesionales repoProfesionales = new RepoProfesionales();
  
  private RepoUsuario repoUser = new RepoUsuario();
  
  public RestControllerUser() {
  }
  
  @Get("/get_usuarios")
  public Result usuarios(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Set<Usuario> lista = IterableExtensions.<Usuario>toSet(this.repoUser.allInstances());
        _xblockexpression = ResultFactory.ok(this._jSONUtils.toJson(lista));
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof UserException) {
        _xtrycatchfinallyexpression = ResultFactory.notFound("No existe ningun usuario");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Get("/getId_usuario/:id")
  public Result usuariosId(final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Usuario usuario = this.repoUser.searchById(Long.valueOf(id));
        _xblockexpression = ResultFactory.ok(this._jSONUtils.toJson(usuario));
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof UserException) {
        _xtrycatchfinallyexpression = ResultFactory.notFound("No existe ningun usuario");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Get("/getId/:id")
  public Result userId(final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Usuario usuario = this.repoUser.getId(Long.valueOf(id));
        _xblockexpression = ResultFactory.ok(this._jSONUtils.toJson(usuario));
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof UserException) {
        _xtrycatchfinallyexpression = ResultFactory.notFound("No existe ningun usuario");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Put("/update_usuario")
  public Result updateUsuarios(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    return this.createUpdateUser(this.actualizarUser(), body, "no se puede actualizar el usuario");
  }
  
  @Post("/create_usuario")
  public Result createUsuarios(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    return this.createUpdateUser(this.crearUser(), body, "no se puede crear el usuario");
  }
  
  @Delete("/delete_usuario/:id")
  public Result eliminarUsuario(@Body final String body, final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Usuario user = this.repoUser.searchById(Long.valueOf(id));
        this.repoUser.delete(user);
        String _string = user.toString();
        String _plus = ("usuario eliminado" + _string);
        InputOutput.<String>println(_plus);
        _xblockexpression = ResultFactory.ok("{ \"status\" : \"OK\" }");
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof UserException) {
        _xtrycatchfinallyexpression = ResultFactory.notFound("No se puede eliminar ningun usuario");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Get("/getId/:id")
  public Result clienteId(final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Cliente usuario = this.repoClientes.getId(Long.valueOf(id));
        _xblockexpression = ResultFactory.ok(this._jSONUtils.toJson(usuario));
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof UserException) {
        _xtrycatchfinallyexpression = ResultFactory.notFound("No existe ningun cliente");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  /**
   * @Get('/clientes')
   * def Result clientes() {
   * try {
   * val Set<Cliente> lista = repoClientes.allInstances.toSet
   * ok(lista.toJson)
   * } catch (UserException e) {
   * notFound("No hay Clientes cargados")
   * }
   * }
   * 
   * 
   * @Get('/cliente/:id')
   * def Result cliente() {
   * try {
   * val Cliente cliente = repoClientes.searchById(Long.valueOf(id))
   * ok(cliente.toJson)
   * } catch (UserException e) {
   * notFound("No se encontro al cliente")
   * }
   * }
   * 
   * @Get('/profesionales')
   * def Result profesionales() {
   * try {
   * val Set<Profesional> lista = repoProfesionales.allInstances.toSet
   * ok(lista.toJson)
   * } catch (UserException e) {
   * notFound("No hay profesionales cargados")
   * }
   * }
   * 
   * 
   * @Get('/profesional/:id')
   * def Result profesional() {
   * try {
   * val Profesional profesional = repoProfesionales.searchById(Long.valueOf(id))
   * ok(profesional.toJson)
   * } catch (UserException e) {
   * notFound("No se encontro al profesional por id")
   * }
   * }
   * 
   * @Post("/login")
   * def Result login(@Body String body) {
   * try {
   * //println(body)
   * //val loginData = body.fromJson(Cliente)
   * //println(loginData.apellido)
   * //val usarioLogueado = repoUser.searchUserByLogin(loginData)
   * //ok(UsuarioSerializable.toJson(usarioLogueado))
   * } catch (Exception e) {
   * internalServerError(e.message)
   * }
   * }
   * 
   * @Get("/perfil_completo/:id")
   * def Result login(@Body String body) {
   * try {
   * val usuarioCompleto = repoUser.searchById(Long.valueOf(id))
   * ok(usuarioCompleto.toJson)
   * } catch (Exception e) {
   * internalServerError(e.message)
   * }
   * }
   * def abandonarEquipo() {
   * [Usuario equipo, SuperIndividuo individuo|equipo.eliminarUnIntegrante(individuo)]
   * }
   */
  public Procedure1<Usuario> actualizarUser() {
    final Procedure1<Usuario> _function = new Procedure1<Usuario>() {
      public void apply(final Usuario user) {
        RestControllerUser.this.repoUser.update(user);
      }
    };
    return _function;
  }
  
  public Procedure1<Usuario> crearUser() {
    final Procedure1<Usuario> _function = new Procedure1<Usuario>() {
      public void apply(final Usuario user) {
        RestControllerUser.this.repoUser.create(user);
      }
    };
    return _function;
  }
  
  public Result createUpdateUser(final Procedure1<? super Usuario> aBlock, final String body, final String error) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Usuario user = this._jSONUtils.<Usuario>fromJson(body, Usuario.class);
        aBlock.apply(user);
        _xblockexpression = ResultFactory.ok("{ \"status\" : \"OK\" }");
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        Result _xblockexpression_1 = null;
        {
          ResultFactory.internalServerError(e.getMessage());
          _xblockexpression_1 = ResultFactory.notFound(error);
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  public void handle(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    {
    	Matcher matcher = 
    		Pattern.compile("/get_usuarios").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = usuarios(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/create_usuario").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = createUsuarios(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/update_usuario").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Put") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = updateUsuarios(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/getId_usuario/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = usuariosId(id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/getId/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = userId(id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/getId/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = clienteId(id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/delete_usuario/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Delete") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = eliminarUsuario(body, id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    //this.pageNotFound(baseRequest, request, response);
  }
}
