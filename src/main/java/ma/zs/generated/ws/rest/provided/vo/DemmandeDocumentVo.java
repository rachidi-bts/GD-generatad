package  ma.zs.generated.ws.rest.provided.vo;

import java.util.Date;

public class DemmandeDocumentVo {

     private String dateDemmande ;
   
     private String dateValidation ;
   
     private String id ;
     
     private String anneeUniversitaire;
   
    private SemestreVo semestreVo;
	private EtatDemmandeVo etatDemmandeVo ;
	private DemmandeurVo demmandeurVo ;
	private TypeDocumentVo typeDocumentVo ;


     private String dateDemmandeMax ;
     private String dateDemmandeMin ;
     private String dateValidationMax ;
     private String dateValidationMin ;

 public DemmandeDocumentVo(){
       super();
     }


     public String getDateDemmande(){
          return this.dateDemmande;
     }
      public void setDateDemmande(String dateDemmande){
          this.dateDemmande = dateDemmande;
     }


     public String getDateValidation(){
          return this.dateValidation;
     }
      public void setDateValidation(String dateValidation){
          this.dateValidation = dateValidation;
     }

      

     public String getAnneeUniversitaire() {
		return this.anneeUniversitaire;
	}


	public void setAnneeUniversitaire(String anneeUniversitaire) {
		this.anneeUniversitaire = anneeUniversitaire;
	}


	public SemestreVo getSemestreVo() {
		return semestreVo;
	}


	public void setSemestreVo(SemestreVo semestreVo) {
		this.semestreVo = semestreVo;
	}


	public String getId(){
          return this.id;
     }
      public void setId(String id){
          this.id = id;
     }



      public String getDateDemmandeMax(){
          return this.dateDemmandeMax;
     }
     
      public String getDateDemmandeMin(){
          return this.dateDemmandeMin;
     }

     public void setDateDemmandeMax(String dateDemmandeMax){
          this.dateDemmandeMax = dateDemmandeMax;
     }

     public void setDateDemmandeMin(String dateDemmandeMin){
          this.dateDemmandeMin = dateDemmandeMin;
     }
     
     

      public String getDateValidationMax(){
          return this.dateValidationMax;
     }
     
      public String getDateValidationMin(){
          return this.dateValidationMin;
     }

     public void setDateValidationMax(String dateValidationMax){
          this.dateValidationMax = dateValidationMax;
     }

     public void setDateValidationMin(String dateValidationMin){
          this.dateValidationMin = dateValidationMin;
     }
     
     
     

      public EtatDemmandeVo getEtatDemmandeVo(){
          return this.etatDemmandeVo;
     }
       
     public void setEtatDemmandeVo(EtatDemmandeVo etatDemmandeVo){
          this.etatDemmandeVo = etatDemmandeVo;
     }
   
      public DemmandeurVo getDemmandeurVo(){
          return this.demmandeurVo;
     }
       
     public void setDemmandeurVo(DemmandeurVo demmandeurVo){
          this.demmandeurVo = demmandeurVo;
     }
   
      public TypeDocumentVo getTypeDocumentVo(){
          return this.typeDocumentVo;
     }
       
     public void setTypeDocumentVo(TypeDocumentVo typeDocumentVo){
          this.typeDocumentVo = typeDocumentVo;
     }
   




}