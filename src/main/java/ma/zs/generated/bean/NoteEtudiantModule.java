package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.NoteEtudiant;
import ma.zs.generated.bean.Resultat;
import ma.zs.generated.bean.Module;

@Entity
public class NoteEtudiantModule {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String ptsJury ;
     private Double note ;

     @ManyToOne
	private NoteEtudiant noteEtudiant ;
     @ManyToOne
	private Resultat resultat ;
     @ManyToOne
	private Module module ;

     public NoteEtudiantModule(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public Module getModule(){
          return this.module;
     }
     public void setModule(Module module){
          this.module = module;
     }
     public Double getNote(){
          return this.note;
     }
     public void setNote(Double note){
          this.note = note;
     }
     public String getPtsJury(){
          return this.ptsJury;
     }
     public void setPtsJury(String ptsJury){
          this.ptsJury = ptsJury;
     }
     public Resultat getResultat(){
          return this.resultat;
     }
     public void setResultat(Resultat resultat){
          this.resultat = resultat;
     }
     public NoteEtudiant getNoteEtudiant(){
          return this.noteEtudiant;
     }
     public void setNoteEtudiant(NoteEtudiant noteEtudiant){
          this.noteEtudiant = noteEtudiant;
     }



}

