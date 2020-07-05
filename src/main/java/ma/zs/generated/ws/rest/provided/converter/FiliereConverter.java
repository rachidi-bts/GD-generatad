package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

import ma.zs.generated.bean.Filiere; 
import ma.zs.generated.ws.rest.provided.vo.FiliereVo;

@Component 
public class FiliereConverter extends AbstractConverter<Filiere,FiliereVo>{ 
    @Autowired
	private TypeFiliereConverter typeFiliereConverter ;
    private boolean  typeFiliere;

	public  FiliereConverter(){
		init(true);
	}

	@Override 
 	public Filiere toItem(FiliereVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Filiere item = new Filiere();
			 if(StringUtil.isNotEmpty(vo.getAbrv()))
                  item.setAbrv(vo.getAbrv());
			 if(StringUtil.isNotEmpty(vo.getLibelle()))
                  item.setLibelle(vo.getLibelle());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
             if(vo.getTypeFiliereVo()!=null && this.typeFiliere)
	              item.setTypeFiliere(typeFiliereConverter.toItem(vo.getTypeFiliereVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public FiliereVo toVo(Filiere item) {
 		if (item == null) {
    		return null;
      	} else {
			FiliereVo vo = new FiliereVo();

			if(StringUtil.isNotEmpty(item.getAbrv()))
				vo.setAbrv(item.getAbrv());
			
			if(StringUtil.isNotEmpty(item.getLibelle()))
				vo.setLibelle(item.getLibelle());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
            if(item.getTypeFiliere()!=null && this.typeFiliere) {
<<<<<<< HEAD
				   
=======
>>>>>>> branch 'master' of https://github.com/rachidi-bts/GD-generatad.git
				   vo.setTypeFiliereVo(typeFiliereConverter.toVo(item.getTypeFiliere())) ;
<<<<<<< HEAD
			        
=======
>>>>>>> branch 'master' of https://github.com/rachidi-bts/GD-generatad.git
			   } 

 			return vo;
 
 		}
 	}
	public void init(boolean value) { 
       typeFiliere = value;
	}


	public TypeFiliereConverter getTypeFiliereConverter(){
		return this.typeFiliereConverter;
	}  
    public void setTypeFiliereConverter(TypeFiliereConverter typeFiliereConverter ){
		 this.typeFiliereConverter = typeFiliereConverter;
	}  
	 public boolean  isTypeFiliere(){
		  return this.typeFiliere;
	 }
	 public void  setTypeFiliere(boolean typeFiliere){
		   this.typeFiliere = typeFiliere;
	 }
} 
