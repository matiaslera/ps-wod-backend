package domain

import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.Table
import javax.persistence.Transient
import javax.persistence.DiscriminatorValue
import javax.persistence.OneToMany
import javax.persistence.FetchType
import javax.persistence.CascadeType
import java.util.HashSet
import java.util.Set
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import java.io.Serializable

@Entity
@Table(name="Profesional")
@DiscriminatorValue("PROF")
@Accessors
class Profesional implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id
	
	@Transient
	Usuario usuario

	@Column(length=50)
	String profesion

	@Column(length=50)
	String titulosObtenidos

	@Column(length=50)
	String experienciaLaboral

	@Column(length=50)
	String zonaDeTrabajo

	@Column(length=50)
	boolean guardia = false
		
	@OneToMany(fetch=FetchType.EAGER,cascade =CascadeType.ALL)
	Set<Presupuesto> trabajos =new HashSet<Presupuesto>()
	
	new (Usuario user){
		usuario=user
	}
	
	def void agregarTrabajo(Presupuesto problema) {
		if(!trabajos.contains(problema)){
		trabajos.add(problema)
			//problema.setProfesional(this)
		}
	}
	
	def void removeTrabajo(Presupuesto problema) {
		if(trabajos.contains(problema)){
			trabajos.remove(problema)
			//problema.setProfesional(null)
		}
	}

}
