package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

import ma.zs.generated.bean.TypeFiliere; 
import ma.zs.generated.ws.rest.provided.vo.TypeFiliereVo;

@Component 
public class TypeFiliereConverter extends AbstractConverter<TypeFiliere,TypeFiliereVo>{ 

	public  TypeFiliereConverter(){
		init(true);
	}

	@Override 
 	public TypeFiliere toItem(TypeFiliereVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	TypeFiliere item = new TypeFiliere();
			 if(StringUtil.isNotEmpty(vo.getLibelle()))
                  item.setLibelle(vo.getLibelle());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public TypeFiliereVo toVo(TypeFiliere item) {
 		if (item == null) {
    		return null;
      	} else {
			TypeFiliereVo vo = new TypeFiliereVo();

			if(StringUtil.isNotEmpty(item.getLibelle()))
				vo.setLibelle(item.getLibelle());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));

 			return vo;
 
 		}
 	}
	public void init(boolean value) { 
	}

} 
