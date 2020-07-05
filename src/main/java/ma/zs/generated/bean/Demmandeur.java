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
import ma.zs.generated.bean.Filiere;

@Entity
public class Demmandeur {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String password ;
     private String paysNaissance ;
     private Long anneeInscription ;
     private String login ;
     private String cne ;
     private Long nbreAttestInscrRest ;
     private Long nbreCertScolRest ;
     private String prenom ;
     private String cin ;
     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date dateNaissance ;
     private String villeNaissance ;
     private String codeApogee ;
     private String nom ;

     @ManyToOne
	private Filiere filiere ;

     public Demmandeur(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public String getCodeApogee(){
          return this.codeApogee;
     }
     public void setCodeApogee(String codeApogee){
          this.codeApogee = codeApogee;
     }
     public String getNom(){
          return this.nom;
     }
     public void setNom(String nom){
          this.nom = nom;
     }
     public String getPrenom(){
          return this.prenom;
     }
     public void setPrenom(String prenom){
          this.prenom = prenom;
     }
     public String getCin(){
          return this.cin;
     }
     public void setCin(String cin){
          this.cin = cin;
     }
     public Date getDateNaissance(){
          return this.dateNaissance;
     }
     public void setDateNaissance(Date dateNaissance){
          this.dateNaissance = dateNaissance;
     }
     public String getVilleNaissance(){
          return this.villeNaissance;
     }
     public void setVilleNaissance(String villeNaissance){
          this.villeNaissance = villeNaissance;
     }
     public String getPaysNaissance(){
          return this.paysNaissance;
     }
     public void setPaysNaissance(String paysNaissance){
          this.paysNaissance = paysNaissance;
     }
     public Long getAnneeInscription(){
          return this.anneeInscription;
     }
     public void setAnneeInscription(Long anneeInscription){
          this.anneeInscription = anneeInscription;
     }
     public Filiere getFiliere(){
          return this.filiere;
     }
     public void setFiliere(Filiere filiere){
          this.filiere = filiere;
     }
     public String getPassword(){
          return this.password;
     }
     public void setPassword(String password){
          this.password = password;
     }
     public Long getNbreAttestInscrRest(){
          return this.nbreAttestInscrRest;
     }
     public void setNbreAttestInscrRest(Long nbreAttestInscrRest){
          this.nbreAttestInscrRest = nbreAttestInscrRest;
     }
     public Long getNbreCertScolRest(){
          return this.nbreCertScolRest;
     }
     public void setNbreCertScolRest(Long nbreCertScolRest){
          this.nbreCertScolRest = nbreCertScolRest;
     }
     public String getLogin(){
          return this.login;
     }
     public void setLogin(String login){
          this.login = login;
     }
     public String getCne(){
          return this.cne;
     }
     public void setCne(String cne){
          this.cne = cne;
     }

	public Demmandeur(Long id, String password, String paysNaissance, Long anneeInscription, String login, String cne,
			Long nbreAttestInscrRest, Long nbreCertScolRest, String prenom, String cin, Date dateNaissance,
			String villeNaissance, String codeApogee, String nom, Filiere filiere) {
		super();
		this.id = id;
		this.password = password;
		this.paysNaissance = paysNaissance;
		this.anneeInscription = anneeInscription;
		this.login = login;
		this.cne = cne;
		this.nbreAttestInscrRest = nbreAttestInscrRest;
		this.nbreCertScolRest = nbreCertScolRest;
		this.prenom = prenom;
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.villeNaissance = villeNaissance;
		this.codeApogee = codeApogee;
		this.nom = nom;
		this.filiere = filiere;
	}



}

