package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.TypeFiliere;

@Entity
public class Responsable {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String password ;
     private String login ;

     @ManyToOne
	private TypeFiliere typeFiliere ;

     public Responsable(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public String getLogin(){
          return this.login;
     }
     public void setLogin(String login){
          this.login = login;
     }
     public String getPassword(){
          return this.password;
     }
     public void setPassword(String password){
          this.password = password;
     }
     public TypeFiliere getTypeFiliere(){
          return this.typeFiliere;
     }
     public void setTypeFiliere(TypeFiliere typeFiliere){
          this.typeFiliere = typeFiliere;
     }

	public Responsable(Long id, String password, String login, TypeFiliere typeFiliere) {
		super();
		this.id = id;
		this.password = password;
		this.login = login;
		this.typeFiliere = typeFiliere;
	}



}

