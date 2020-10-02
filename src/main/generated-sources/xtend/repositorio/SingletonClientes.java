package repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class SingletonClientes {
  private static SingletonClientes clientePers = new SingletonClientes();
  
  private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WorkOfDay");
  
  private EntityManager entityManager = this.entityManagerFactory.createEntityManager();
  
  public static SingletonClientes getInstance() {
    SingletonClientes _xblockexpression = null;
    {
      if ((SingletonClientes.clientePers == null)) {
        SingletonClientes _singletonClientes = new SingletonClientes();
        SingletonClientes.clientePers = _singletonClientes;
      }
      _xblockexpression = SingletonClientes.clientePers;
    }
    return _xblockexpression;
  }
  
  @Pure
  public EntityManagerFactory getEntityManagerFactory() {
    return this.entityManagerFactory;
  }
  
  public void setEntityManagerFactory(final EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }
  
  @Pure
  public EntityManager getEntityManager() {
    return this.entityManager;
  }
  
  public void setEntityManager(final EntityManager entityManager) {
    this.entityManager = entityManager;
  }
}
