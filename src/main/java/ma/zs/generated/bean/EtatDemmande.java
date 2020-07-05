package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class EtatDemmande {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String libelle ;


     public EtatDemmande(){
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

	public EtatDemmande(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}



}

