package restApi;

import domain.Cliente;
import domain.Presupuesto;
import domain.Profesional;
import domain.Usuario;
import java.io.IOException;
import java.util.List;
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
import org.uqbar.commons.model.exceptions.UserException;
import org.uqbar.xtrest.api.Result;
import org.uqbar.xtrest.api.annotation.Body;
import org.uqbar.xtrest.api.annotation.Controller;
import org.uqbar.xtrest.api.annotation.Get;
import org.uqbar.xtrest.api.annotation.Post;
import org.uqbar.xtrest.json.JSONUtils;
import org.uqbar.xtrest.result.ResultFactory;
import repositorio.RepoClientes;
import repositorio.RepoPresupuestos;
import repositorio.RepoProfesionales;
import repositorio.RepoUsuario;
import runnable.WorkOfDayBootstrap;
import serializacion.UsuarioSerializable;

@Controller
@SuppressWarnings("all")
public class RestControllerUser extends ResultFactory {
  @Extension
  private JSONUtils _jSONUtils = new JSONUtils();
  
  private RepoClientes repoClientes = new RepoClientes();
  
  private RepoProfesionales repoProfesionales = new RepoProfesionales();
  
  private RepoUsuario repoUser = new RepoUsuario();
  
  private RepoPresupuestos repoPresupuesto = new RepoPresupuestos();
  
  public RestControllerUser(final WorkOfDayBootstrap object) {
  }
  
  @Get("/usuarios")
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
  
  @Get("/clientes")
  public Result clientes(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Set<Cliente> lista = IterableExtensions.<Cliente>toSet(this.repoClientes.allInstances());
        _xblockexpression = ResultFactory.ok(this._jSONUtils.toJson(lista));
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof UserException) {
        _xtrycatchfinallyexpression = ResultFactory.notFound("No hay Clientes cargados");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Get("/cliente/:id")
  public Result cliente(final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Cliente cliente = this.repoClientes.searchById(Long.valueOf(id));
        _xblockexpression = ResultFactory.ok(this._jSONUtils.toJson(cliente));
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof UserException) {
        _xtrycatchfinallyexpression = ResultFactory.notFound("No se encontro al cliente");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Get("/profesionales")
  public Result profesionales(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Set<Profesional> lista = IterableExtensions.<Profesional>toSet(this.repoProfesionales.allInstances());
        _xblockexpression = ResultFactory.ok(this._jSONUtils.toJson(lista));
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof UserException) {
        _xtrycatchfinallyexpression = ResultFactory.notFound("No hay profesionales cargados");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Get("/profesional/:id")
  public Result profesional(final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Profesional profesional = this.repoProfesionales.searchById(Long.valueOf(id));
        _xblockexpression = ResultFactory.ok(this._jSONUtils.toJson(profesional));
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof UserException) {
        _xtrycatchfinallyexpression = ResultFactory.notFound("No se encontro al profesional por id");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Post("/login")
  public Result login(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        InputOutput.<String>println(body);
        final Cliente loginData = this._jSONUtils.<Cliente>fromJson(body, Cliente.class);
        InputOutput.<String>println(loginData.getUsuario());
        final Usuario usarioLogueado = this.repoUser.searchUserByLogin(loginData);
        _xblockexpression = ResultFactory.ok(UsuarioSerializable.toJson(usarioLogueado));
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        _xtrycatchfinallyexpression = ResultFactory.internalServerError(e.getMessage());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Get("/perfil_completo/:id")
  public Result login(@Body final String body, final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Usuario usuarioCompleto = this.repoUser.searchById(Long.valueOf(id));
        _xblockexpression = ResultFactory.ok(this._jSONUtils.toJson(usuarioCompleto));
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        _xtrycatchfinallyexpression = ResultFactory.internalServerError(e.getMessage());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Get("/presupuestos")
  public Result presupuestos(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final List<Presupuesto> presupuesto = this.repoPresupuesto.allInstances();
        _xblockexpression = ResultFactory.ok(this._jSONUtils.toJson(presupuesto));
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        _xtrycatchfinallyexpression = ResultFactory.internalServerError(e.getMessage());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Get("/search_presupuestos")
  public Result busquedaPresupuestos(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final String especialidad = this._jSONUtils.getPropertyValue(body, "especialidad");
        final String nombre = this._jSONUtils.getPropertyValue(body, "nombre");
        InputOutput.<String>println(((especialidad + " : ") + nombre));
        final Set<Presupuesto> busqueda = this.repoPresupuesto.search(especialidad, nombre);
        _xblockexpression = ResultFactory.ok(this._jSONUtils.toJson(busqueda));
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        _xtrycatchfinallyexpression = ResultFactory.internalServerError(e.getMessage());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  public void handle(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    {
    	Matcher matcher = 
    		Pattern.compile("/usuarios").matcher(target);
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
    		Pattern.compile("/clientes").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = clientes(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/profesionales").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = profesionales(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/presupuestos").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = presupuestos(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/search_presupuestos").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = busquedaPresupuestos(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/login").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = login(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/cliente/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = cliente(id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/profesional/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = profesional(id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/perfil_completo/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = login(body, id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    //this.pageNotFound(baseRequest, request, response);
  }
}
