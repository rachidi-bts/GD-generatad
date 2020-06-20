package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

import ma.zs.generated.bean.Resultat; 
import ma.zs.generated.ws.rest.provided.vo.ResultatVo;

@Component 
public class ResultatConverter extends AbstractConverter<Resultat,ResultatVo>{ 

	public  ResultatConverter(){
		init(true);
	}

	@Override 
 	public Resultat toItem(ResultatVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Resultat item = new Resultat();
			 if(StringUtil.isNotEmpty(vo.getLibelle()))
                  item.setLibelle(vo.getLibelle());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public ResultatVo toVo(Resultat item) {
 		if (item == null) {
    		return null;
      	} else {
			ResultatVo vo = new ResultatVo();

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
