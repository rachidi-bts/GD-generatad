package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.OneToMany;
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
     @OneToMany(mappedBy = "noteEtudiant")
     private List<NoteEtudiantModule> noteEtudiantModules ;

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
     



}

