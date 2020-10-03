package repositorio;

import domain.Presupuesto;
import domain.Profesional;
import java.util.List;
import java.util.function.Consumer;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import repositorio.AbstractRepository;

@SuppressWarnings("all")
public class RepoProfesionales extends AbstractRepository<Profesional> {
  private static RepoProfesionales repoProfesionales;
  
  public static RepoProfesionales getInstance() {
    RepoProfesionales _xblockexpression = null;
    {
      if ((RepoProfesionales.repoProfesionales == null)) {
        RepoProfesionales _repoProfesionales = new RepoProfesionales();
        RepoProfesionales.repoProfesionales = _repoProfesionales;
      }
      _xblockexpression = RepoProfesionales.repoProfesionales;
    }
    return _xblockexpression;
  }
  
  public void enviarNotificacionDePresupuesto(final Presupuesto problema) {
    final Consumer<Profesional> _function = new Consumer<Profesional>() {
      public void accept(final Profesional profesional) {
        boolean _equals = profesional.getProfesion().equals(problema.getEspecialidad());
        if (_equals) {
          profesional.agregarTrabajo(problema);
          RepoProfesionales.this.update(profesional);
          InputOutput.<String>println(profesional.toString());
        }
      }
    };
    this.allInstances().forEach(_function);
    final Consumer<Profesional> _function_1 = new Consumer<Profesional>() {
      public void accept(final Profesional profesional) {
        RepoProfesionales.this.update(profesional);
      }
    };
    this.allInstances().forEach(_function_1);
  }
  
  public List<Profesional> busquedaPorProfesion(final String profesion) {
    final Function1<Profesional, Boolean> _function = new Function1<Profesional, Boolean>() {
      public Boolean apply(final Profesional profesional) {
        return Boolean.valueOf(profesional.getProfesion().equals(profesion));
      }
    };
    return IterableExtensions.<Profesional>toList(IterableExtensions.<Profesional>filter(this.allInstances(), _function));
  }
  
  public List<Profesional> busquedaPorZona(final String zona) {
    final Function1<Profesional, Boolean> _function = new Function1<Profesional, Boolean>() {
      public Boolean apply(final Profesional profesional) {
        return Boolean.valueOf(profesional.getZonaDeTrabajo().equals(zona));
      }
    };
    return IterableExtensions.<Profesional>toList(IterableExtensions.<Profesional>filter(this.allInstances(), _function));
  }
  
  public List<Profesional> busquedaPorNombreYApellido(final String nombre) {
    final Function1<Profesional, Boolean> _function = new Function1<Profesional, Boolean>() {
      public Boolean apply(final Profesional profesional) {
        return Boolean.valueOf(profesional.getUsuario().equals(nombre));
      }
    };
    return IterableExtensions.<Profesional>toList(IterableExtensions.<Profesional>filter(this.allInstances(), _function));
  }
  
  public Class<Profesional> getEntityType() {
    return Profesional.class;
  }
  
  public void generateWhere(final CriteriaBuilder criteria, final CriteriaQuery<Profesional> query, final Root<Profesional> camposCandidato, final Profesional user) {
    Long _id = user.getId();
    boolean _tripleNotEquals = (_id != null);
    if (_tripleNotEquals) {
      query.where(criteria.equal(camposCandidato.<Object>get("id"), user.getId()));
    }
  }
  
  public Profesional searchById(final Long id) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field entityManager is undefined"
      + "\ncriteriaBuilder cannot be resolved"
      + "\ncreateQuery cannot be resolved"
      + "\nfrom cannot be resolved"
      + "\nselect cannot be resolved"
      + "\nwhere cannot be resolved"
      + "\nequal cannot be resolved"
      + "\nget cannot be resolved"
      + "\ncreateQuery cannot be resolved"
      + "\nsingleResult cannot be resolved"
      + "\ntransaction cannot be resolved"
      + "\nrollback cannot be resolved"
      + "\nclose cannot be resolved");
  }
  
  public Profesional searchByIdUser(final String id) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field entityManager is undefined"
      + "\ncriteriaBuilder cannot be resolved"
      + "\ncreateQuery cannot be resolved"
      + "\nfrom cannot be resolved"
      + "\nselect cannot be resolved"
      + "\nwhere cannot be resolved"
      + "\nequal cannot be resolved"
      + "\nget cannot be resolved"
      + "\ncreateQuery cannot be resolved"
      + "\nsingleResult cannot be resolved"
      + "\ntransaction cannot be resolved"
      + "\nrollback cannot be resolved"
      + "\nclose cannot be resolved");
  }
}
