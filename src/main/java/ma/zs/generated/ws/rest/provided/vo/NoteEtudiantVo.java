package  ma.zs.generated.ws.rest.provided.vo;

import java.util.List;

public class NoteEtudiantVo {

     private String noteFinale ;
   
     private String id ;
    
     private String anneeUniversitaire;

	private ResultatVo resultatFinalVo ;
	private DemmandeurVo demmandeurVo ;
    private SemestreVo semestreVo;
     private List<NoteEtudiantModuleVo> noteEtudiantModulesVo ;

     private String noteFinaleMax ;
     private String noteFinaleMin ;

 public NoteEtudiantVo(){
       super();
     }


     public String getNoteFinale(){
          return this.noteFinale;
     }
      public void setNoteFinale(String noteFinale){
          this.noteFinale = noteFinale;
     }


     public String getId(){
          return this.id;
     }
      public void setId(String id){
          this.id = id;
     }

      public String getAnneeUniversitaire() {
  		return this.anneeUniversitaire;
  	}


  	public void setAnneeUniversitaire(String anneeUniversitaire) {
  		this.anneeUniversitaire = anneeUniversitaire;
  	}

      public String getNoteFinaleMax(){
          return this.noteFinaleMax;
     }
     
      public String getNoteFinaleMin(){
          return this.noteFinaleMin;
     }

     public void setNoteFinaleMax(String noteFinaleMax){
          this.noteFinaleMax = noteFinaleMax;
     }

     public void setNoteFinaleMin(String noteFinaleMin){
          this.noteFinaleMin = noteFinaleMin;
     }
     
     
     

      public ResultatVo getResultatFinalVo(){
          return this.resultatFinalVo;
     }
       
     public void setResultatFinalVo(ResultatVo resultatFinalVo){
          this.resultatFinalVo = resultatFinalVo;
     }
   
      public DemmandeurVo getDemmandeurVo(){
          return this.demmandeurVo;
     }
       
     public void setDemmandeurVo(DemmandeurVo demmandeurVo){
          this.demmandeurVo = demmandeurVo;
     }
     
     public SemestreVo getSemestreVo(){
         return this.semestreVo;
    }
      
    public void setSemestreVo(SemestreVo semestreVo){
         this.semestreVo = semestreVo;
    }
   

      public List<NoteEtudiantModuleVo> getNoteEtudiantModulesVo(){
          return this.noteEtudiantModulesVo;
     }
       
     public void setNoteEtudiantModulesVo(List<NoteEtudiantModuleVo> noteEtudiantModulesVo){
          this.noteEtudiantModulesVo = noteEtudiantModulesVo;
     }



}