package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

import ma.zs.generated.bean.Responsable; 
import ma.zs.generated.ws.rest.provided.vo.ResponsableVo;

@Component 
public class ResponsableConverter extends AbstractConverter<Responsable,ResponsableVo>{ 
    @Autowired
	private TypeFiliereConverter typeFiliereConverter ;
    private boolean  typeFiliere;

	public  ResponsableConverter(){
		init(true);
	}

	@Override 
 	public Responsable toItem(ResponsableVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Responsable item = new Responsable();
			 if(StringUtil.isNotEmpty(vo.getPassword()))
                  item.setPassword(vo.getPassword());
			 if(StringUtil.isNotEmpty(vo.getLogin()))
                  item.setLogin(vo.getLogin());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
             if(vo.getTypeFiliereVo()!=null && this.typeFiliere)
	              item.setTypeFiliere(typeFiliereConverter.toItem(vo.getTypeFiliereVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public ResponsableVo toVo(Responsable item) {
 		if (item == null) {
    		return null;
      	} else {
			ResponsableVo vo = new ResponsableVo();

			if(StringUtil.isNotEmpty(item.getPassword()))
				vo.setPassword(item.getPassword());
			
			if(StringUtil.isNotEmpty(item.getLogin()))
				vo.setLogin(item.getLogin());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
            if(item.getTypeFiliere()!=null && this.typeFiliere) {
				  //  typeFiliereConverter.init(false);
				   vo.setTypeFiliereVo(typeFiliereConverter.toVo(item.getTypeFiliere())) ;
			       // typeFiliereConverter.init(true);
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
