package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

import ma.zs.generated.bean.EtatDemmande; 
import ma.zs.generated.ws.rest.provided.vo.EtatDemmandeVo;

@Component 
public class EtatDemmandeConverter extends AbstractConverter<EtatDemmande,EtatDemmandeVo>{ 

	public  EtatDemmandeConverter(){
		init(true);
	}

	@Override 
 	public EtatDemmande toItem(EtatDemmandeVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	EtatDemmande item = new EtatDemmande();
			 if(StringUtil.isNotEmpty(vo.getLibelle()))
                  item.setLibelle(vo.getLibelle());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public EtatDemmandeVo toVo(EtatDemmande item) {
 		if (item == null) {
    		return null;
      	} else {
			EtatDemmandeVo vo = new EtatDemmandeVo();

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
