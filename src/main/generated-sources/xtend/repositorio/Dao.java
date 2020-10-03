package repositorio;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("all")
public interface Dao<T extends Object> {
  public abstract Optional<T> get(final long id);
  
  public abstract List<T> getAll();
  
  public abstract void save(final T t);
  
  public abstract void update(final T t, final String[] params);
  
  public abstract void delete(final T t);
}
