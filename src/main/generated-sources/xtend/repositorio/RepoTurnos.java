package repositorio;

import domain.Turno;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RepoTurnos {
  private static RepoTurnos repoTurnos;
  
  public static RepoTurnos getInstance() {
    RepoTurnos _xblockexpression = null;
    {
      if ((RepoTurnos.repoTurnos == null)) {
        RepoTurnos _repoTurnos = new RepoTurnos();
        RepoTurnos.repoTurnos = _repoTurnos;
      }
      _xblockexpression = RepoTurnos.repoTurnos;
    }
    return _xblockexpression;
  }
  
  private List<Turno> turnos = new ArrayList<Turno>();
  
  public void persistirTurno(final Turno turno) {
    this.turnos.add(turno);
  }
  
  @Pure
  public List<Turno> getTurnos() {
    return this.turnos;
  }
  
  public void setTurnos(final List<Turno> turnos) {
    this.turnos = turnos;
  }
}
