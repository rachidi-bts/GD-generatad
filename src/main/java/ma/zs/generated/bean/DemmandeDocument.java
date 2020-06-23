package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.EtatDemmande;
import ma.zs.generated.bean.Demmandeur;
import ma.zs.generated.bean.TypeDocument;

@Entity
public class DemmandeDocument {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date dateDemmande ;
     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date dateValidation ;

     @ManyToOne
	private EtatDemmande etatDemmande ;
     @ManyToOne
	private Demmandeur demmandeur ;
     @ManyToOne
	private TypeDocument typeDocument ;
    private Long anneeUniversitaire;
    private String semestre;

     public DemmandeDocument(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public Demmandeur getDemmandeur(){
          return this.demmandeur;
     }
     public void setDemmandeur(Demmandeur demmandeur){
          this.demmandeur = demmandeur;
     }
     public TypeDocument getTypeDocument(){
          return this.typeDocument;
     }
     public void setTypeDocument(TypeDocument typeDocument){
          this.typeDocument = typeDocument;
     }
     public Date getDateDemmande(){
          return this.dateDemmande;
     }
     public void setDateDemmande(Date dateDemmande){
          this.dateDemmande = dateDemmande;
     }
     public EtatDemmande getEtatDemmande(){
          return this.etatDemmande;
     }
     public void setEtatDemmande(EtatDemmande etatDemmande){
          this.etatDemmande = etatDemmande;
     }
     public Date getDateValidation(){
          return this.dateValidation;
     }
     public void setDateValidation(Date dateValidation){
          this.dateValidation = dateValidation;
     }

	public Long getAnneeUniversitaire() {
		return anneeUniversitaire;
	}

	public void setAnneeUniversitaire(Long anneeUniversitaire) {
		this.anneeUniversitaire = anneeUniversitaire;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
    


}

