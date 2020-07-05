package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Semestre {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String libellee ;


     public Semestre(){
       super();
     }

     public Long getId(){
    	
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public String getLibellee(){
          return this.libellee;
     }
     public void setLibellee(String libellee){
          this.libellee = libellee;
     }

	public Semestre(Long id, String libellee) {
		super();
		this.id = id;
		this.libellee = libellee;
	}



}

