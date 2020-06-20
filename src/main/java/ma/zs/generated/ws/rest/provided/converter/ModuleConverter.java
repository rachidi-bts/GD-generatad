package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

import ma.zs.generated.bean.Module; 
import ma.zs.generated.ws.rest.provided.vo.ModuleVo;

@Component 
public class ModuleConverter extends AbstractConverter<Module,ModuleVo>{ 

	public  ModuleConverter(){
		init(true);
	}

	@Override 
 	public Module toItem(ModuleVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Module item = new Module();
			 if(StringUtil.isNotEmpty(vo.getLibelle()))
                  item.setLibelle(vo.getLibelle());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public ModuleVo toVo(Module item) {
 		if (item == null) {
    		return null;
      	} else {
			ModuleVo vo = new ModuleVo();

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
