package restApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Cliente;
import domain.Profesional;
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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.exceptions.UserException;
import org.uqbar.xtrest.api.Result;
import org.uqbar.xtrest.api.annotation.Controller;
import org.uqbar.xtrest.api.annotation.Get;
import org.uqbar.xtrest.json.JSONUtils;
import org.uqbar.xtrest.result.ResultFactory;
import repositorio.RepoClientes;
import repositorio.RepoProfesionales;
import runnable.WorkOfDayBootstrap;

@Controller
@SuppressWarnings("all")
public class RestControllerUser extends ResultFactory {
  @Extension
  private JSONUtils _jSONUtils = new JSONUtils();
  
  private ObjectMapper mapper = new ObjectMapper();
  
  private RepoClientes repoClientes = new RepoClientes();
  
  private RepoProfesionales repoProfesionales = new RepoProfesionales();
  
  public RestControllerUser(final WorkOfDayBootstrap object) {
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
  
  public void handle(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
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
    //this.pageNotFound(baseRequest, request, response);
  }
}
