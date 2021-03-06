package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.Resultat;
import ma.zs.generated.bean.Demmandeur;

@Entity
public class NoteEtudiant {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private Double noteFinale ;

     @ManyToOne
	private Resultat resultatFinal ;
     @ManyToOne
	private Demmandeur demmandeur ;
//     @OneToMany(mappedBy = "noteEtudiant")
  @OneToMany
     private List<NoteEtudiantModule> noteEtudiantModules ;
    // private String semestre;
     @OneToOne
     private Semestre semestre;
     private Long anneeUniversitaire;
     public NoteEtudiant(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public Double getNoteFinale(){
          return this.noteFinale;
     }
     public void setNoteFinale(Double noteFinale){
          this.noteFinale = noteFinale;
     }
     public Resultat getResultatFinal(){
          return this.resultatFinal;
     }
     public void setResultatFinal(Resultat resultatFinal){
          this.resultatFinal = resultatFinal;
     }
     public Demmandeur getDemmandeur(){
          return this.demmandeur;
     }
     public void setDemmandeur(Demmandeur demmandeur){
          this.demmandeur = demmandeur;
     }
     public List<NoteEtudiantModule> getNoteEtudiantModules(){
          return this.noteEtudiantModules;
     }
     
      public void setNoteEtudiantModules(List<NoteEtudiantModule> noteEtudiantModules){
          this.noteEtudiantModules = noteEtudiantModules;
     }


	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Long getAnneeUniversitaire() {
		return anneeUniversitaire;
	}

	public void setAnneeUniversitaire(Long anneeUniversitaire) {
		this.anneeUniversitaire = anneeUniversitaire;
	}

	
	public NoteEtudiant(Long id, Double noteFinale, Resultat resultatFinal, Demmandeur demmandeur,
			List<NoteEtudiantModule> noteEtudiantModules, Semestre semestre, Long anneeUniversitaire) {
		super();
		this.id = id;
		this.noteFinale = noteFinale;
		this.resultatFinal = resultatFinal;
		this.demmandeur = demmandeur;
		this.noteEtudiantModules = noteEtudiantModules;
		this.semestre = semestre;
		this.anneeUniversitaire = anneeUniversitaire;
	}

	@Override
	public String toString() {
		return "NoteEtudiant [id=" + id + ", noteFinale=" + noteFinale + ", resultatFinal=" + resultatFinal
				+ ", demmandeur=" + demmandeur + ", noteEtudiantModules=" + noteEtudiantModules + ", semestre="
				+ semestre + ", anneeUniversitaire=" + anneeUniversitaire + "]";
	}

	
      
     



}

