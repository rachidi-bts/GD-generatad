package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.TypeFiliere;

@Entity
public class Filiere {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String abrv ;
     private String libelle ;

     @ManyToOne
	private TypeFiliere typeFiliere ;

     public Filiere(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public String getLibelle(){
          return this.libelle;
     }
     public void setLibelle(String libelle){
          this.libelle = libelle;
     }
     public String getAbrv(){
          return this.abrv;
     }
     public void setAbrv(String abrv){
          this.abrv = abrv;
     }
     public TypeFiliere getTypeFiliere(){
          return this.typeFiliere;
     }
     public void setTypeFiliere(TypeFiliere typeFiliere){
          this.typeFiliere = typeFiliere;
     }

	public Filiere(Long id, String abrv, String libelle, TypeFiliere typeFiliere) {
		super();
		this.id = id;
		this.abrv = abrv;
		this.libelle = libelle;
		this.typeFiliere = typeFiliere;
	}



}

