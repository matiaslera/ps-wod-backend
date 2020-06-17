package restApi;

import domain.Cliente;
import domain.Presupuesto;
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

@Controller
@SuppressWarnings("all")
public class RestControllerPresupuesto extends ResultFactory {
  @Extension
  private JSONUtils _jSONUtils = new JSONUtils();
  
  private RepoClientes repoClientes = new RepoClientes();
  
  private RepoProfesionales repoProfesionales = new RepoProfesionales();
  
  private RepoUsuario repoUser = new RepoUsuario();
  
  private RepoPresupuestos repoPresupuesto = new RepoPresupuestos();
  
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
  
  @Post("/search_presupuestos")
  public Result busquedaPresupuestos(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final String especialidad = this._jSONUtils.getPropertyValue(body, "especialidad");
        final String nombre = this._jSONUtils.getPropertyValue(body, "problema");
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
  
  @Post("/new_qery/:id")
  public Result nuevaConsulta(@Body final String body, final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Presupuesto presNuevo = this._jSONUtils.<Presupuesto>fromJson(body, Presupuesto.class);
        final Cliente cliente = this.repoClientes.searchById(Long.valueOf(id));
        cliente.addPresupuesto(presNuevo);
        this.repoClientes.update(cliente);
        InputOutput.<String>println(presNuevo.toString());
        InputOutput.<String>println(cliente.toString());
        _xblockexpression = ResultFactory.ok("{ \"status\" : \"OK\" }");
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
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
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
    		Pattern.compile("/new_qery/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = nuevaConsulta(body, id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    //this.pageNotFound(baseRequest, request, response);
  }
}
