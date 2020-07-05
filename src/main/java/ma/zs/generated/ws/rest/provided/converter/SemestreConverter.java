package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

import ma.zs.generated.bean.Semestre; 
import ma.zs.generated.ws.rest.provided.vo.SemestreVo;

@Component 
public class SemestreConverter extends AbstractConverter<Semestre,SemestreVo>{ 

	public  SemestreConverter(){
		init(true);
	}

	@Override 
 	public Semestre toItem(SemestreVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Semestre item = new Semestre();
			 if(StringUtil.isNotEmpty(vo.getLibellee()))
                  item.setLibellee(vo.getLibellee());
			 
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public SemestreVo toVo(Semestre item) {
 		if (item == null) {
    		return null;
      	} else {
			SemestreVo vo = new SemestreVo();

			if(StringUtil.isNotEmpty(item.getLibellee()))
				vo.setLibellee(item.getLibellee());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));

 			return vo;
 
 		}
 	}
	public void init(boolean value) { 
	}

} 
