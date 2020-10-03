package repositorio;

import domain.Oferta;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import repositorio.AbstractRepository;
import repositorio.RepoClientes;

@SuppressWarnings("all")
public class RepoOferta extends AbstractRepository<Oferta> {
  private static RepoClientes instances;
  
  public static RepoClientes getInstance() {
    RepoClientes _xblockexpression = null;
    {
      if ((RepoOferta.instances == null)) {
        RepoClientes _repoClientes = new RepoClientes();
        RepoOferta.instances = _repoClientes;
      }
      _xblockexpression = RepoOferta.instances;
    }
    return _xblockexpression;
  }
  
  public Class<Oferta> getEntityType() {
    return Oferta.class;
  }
  
  public Oferta searchById(final Long id) {
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
  
  public Oferta searchByIdUser(final String id) {
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
  
  public void generateWhere(final CriteriaBuilder criteria, final CriteriaQuery<Oferta> query, final Root<Oferta> camposCandidato, final Oferta user) {
    Long _id = user.getId();
    boolean _tripleEquals = (_id == null);
    if (_tripleEquals) {
      query.where(criteria.equal(camposCandidato.<Object>get("id"), user.getId()));
    }
  }
}
