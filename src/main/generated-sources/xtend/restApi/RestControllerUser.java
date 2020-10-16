package restApi;

import com.google.common.base.Objects;
import domain.Cliente;
import domain.Profesional;
import domain.Usuario;
import exceptions.BusinessException;
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
  
  /**
   * CLIENTES
   */
  @Get("/get_cli")
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
        _xtrycatchfinallyexpression = ResultFactory.notFound("No existe ningun usuario");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Get("/getId_cli/:id")
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
  
  @Get("/get_id_ultimo")
  public Result ultimoIdCliente(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Number id = this.repoClientes.ultimoIdCliente();
        _xblockexpression = ResultFactory.ok(this._jSONUtils.toJson(id));
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
  
  @Post("/get_email")
  public Result searchByEmail(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      InputOutput.<String>println(("body: " + body));
      Result _xtrycatchfinallyexpression = null;
      try {
        Result _xblockexpression_1 = null;
        {
          final String email = this._jSONUtils.getPropertyValue(body, "email");
          Long _id = this.repoClientes.searchByEmail(email).getId();
          boolean _tripleNotEquals = ((_id).longValue() != 0);
          if (_tripleNotEquals) {
            final Cliente cliente = this.repoClientes.searchByEmail(email);
            return ResultFactory.ok(this._jSONUtils.toJson(cliente));
          }
          Long _id_1 = this.repoProfesionales.searchByEmail(email).getId();
          boolean _tripleNotEquals_1 = ((_id_1).longValue() != 0);
          if (_tripleNotEquals_1) {
            final Profesional profesional = this.repoProfesionales.searchByEmail(email);
            return ResultFactory.ok(this._jSONUtils.toJson(profesional));
          }
          _xblockexpression_1 = ResultFactory.ok(this._jSONUtils.toJson("sin usuario"));
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof UserException) {
          _xtrycatchfinallyexpression = ResultFactory.notFound("No se encontro ningun usuario");
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Put("/update_cliente/:id")
  public Result updateCliente(@Body final String body, final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    try {
      Result _xblockexpression = null;
      {
        final String error = "Debe ingresar el parámetro id";
        final String error2 = "Id en URL distinto del id que viene en el body";
        if ((id == null)) {
          ResultFactory.ok(this._jSONUtils.toJson(error));
          throw new BusinessException("Debe ingresar el parámetro id");
        }
        final Cliente actualizada = this._jSONUtils.<Cliente>fromJson(body, Cliente.class);
        Long _id = actualizada.getId();
        boolean _notEquals = (!Objects.equal(id, _id));
        if (_notEquals) {
          ResultFactory.ok(this._jSONUtils.toJson(error2));
          throw new BusinessException("Id en URL distinto del id que viene en el body");
        }
        _xblockexpression = this.createUpdateCliente(this.actualizarCliente(), body, "no se puede actualizar el cliente");
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Post("/create_cliente")
  public Result createCliente(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    return this.createUpdateCliente(this.crearCliente(), body, "no se puede crear el cliente");
  }
  
  @Delete("/delete_cliente/:id")
  public Result eliminarCliente(@Body final String body, final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Cliente user = this.repoClientes.searchById(Long.valueOf(id));
        this.repoClientes.delete(user);
        String _string = user.toString();
        String _plus = ("cliente eliminado" + _string);
        InputOutput.<String>println(_plus);
        _xblockexpression = ResultFactory.ok("{ \"status\" : \"OK\" }");
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof UserException) {
        _xtrycatchfinallyexpression = ResultFactory.notFound("No se puede eliminar ningun cliente");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  /**
   * PROFESIONALES
   */
  @Get("/get_pros")
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
        _xtrycatchfinallyexpression = ResultFactory.notFound("No existe ningun usuario");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Get("/getId_prof/:id")
  public Result profesionalId(final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Profesional usuario = this.repoProfesionales.getId(Long.valueOf(id));
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
  
  @Put("/update_profesional")
  public Result updateProfesional(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    return this.createUpdateProfesional(this.actualizarProfesional(), body, "no se puede actualizar el Profesional");
  }
  
  @Post("/create_profesional")
  public Result createProfesional(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    return this.createUpdateProfesional(this.crearProfesional(), body, "no se puede crear el Profesional");
  }
  
  @Delete("/delete_profesional/:id")
  public Result eliminarProfesional(@Body final String body, final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Profesional user = this.repoProfesionales.searchById(Long.valueOf(id));
        this.repoProfesionales.delete(user);
        String _string = user.toString();
        String _plus = ("Profesional eliminado" + _string);
        InputOutput.<String>println(_plus);
        _xblockexpression = ResultFactory.ok("{ \"status\" : \"OK\" }");
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof UserException) {
        _xtrycatchfinallyexpression = ResultFactory.notFound("No se puede eliminar ningun Profesional");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
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
  
  public Procedure1<Cliente> actualizarCliente() {
    final Procedure1<Cliente> _function = new Procedure1<Cliente>() {
      public void apply(final Cliente user) {
        RestControllerUser.this.repoClientes.update(user);
      }
    };
    return _function;
  }
  
  public Procedure1<Cliente> crearCliente() {
    final Procedure1<Cliente> _function = new Procedure1<Cliente>() {
      public void apply(final Cliente user) {
        RestControllerUser.this.repoClientes.create(user);
      }
    };
    return _function;
  }
  
  public Result createUpdateCliente(final Procedure1<? super Cliente> aBlock, final String body, final String error) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        InputOutput.<String>println(("este es el json cliente" + body));
        final Cliente user = this._jSONUtils.<Cliente>fromJson(body, Cliente.class);
        String _string = user.toString();
        String _plus = ("este es el objeto cliente" + _string);
        InputOutput.<String>println(_plus);
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
  
  public Procedure1<Profesional> actualizarProfesional() {
    final Procedure1<Profesional> _function = new Procedure1<Profesional>() {
      public void apply(final Profesional user) {
        RestControllerUser.this.repoProfesionales.update(user);
      }
    };
    return _function;
  }
  
  public Procedure1<Profesional> crearProfesional() {
    final Procedure1<Profesional> _function = new Procedure1<Profesional>() {
      public void apply(final Profesional user) {
        RestControllerUser.this.repoProfesionales.create(user);
      }
    };
    return _function;
  }
  
  public Result createUpdateProfesional(final Procedure1<? super Profesional> aBlock, final String body, final String error) {
    Result _xtrycatchfinallyexpression = null;
    try {
      Result _xblockexpression = null;
      {
        final Profesional user = this._jSONUtils.<Profesional>fromJson(body, Profesional.class);
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
    		Pattern.compile("/get_cli").matcher(target);
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
    		Pattern.compile("/get_id_ultimo").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = ultimoIdCliente(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/get_pros").matcher(target);
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
    		Pattern.compile("/get_email").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = searchByEmail(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/create_cliente").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = createCliente(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/create_profesional").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = createProfesional(body, target, baseRequest, request, response);
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
    		Pattern.compile("/update_profesional").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Put") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = updateProfesional(body, target, baseRequest, request, response);
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
    		Pattern.compile("/getId_cli/(\\w+)").matcher(target);
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
    		Pattern.compile("/getId_prof/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = profesionalId(id, target, baseRequest, request, response);
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
    {
    	Matcher matcher = 
    		Pattern.compile("/delete_cliente/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Delete") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = eliminarCliente(body, id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/delete_profesional/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Delete") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = eliminarProfesional(body, id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/update_cliente/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Put") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
            // set default content type (it can be overridden during next call)
            response.setContentType("application/json");
    		
    	    Result result = updateCliente(body, id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    //this.pageNotFound(baseRequest, request, response);
  }
}
