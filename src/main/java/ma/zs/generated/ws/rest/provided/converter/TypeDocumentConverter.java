package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

import ma.zs.generated.bean.TypeDocument; 
import ma.zs.generated.ws.rest.provided.vo.TypeDocumentVo;

@Component 
public class TypeDocumentConverter extends AbstractConverter<TypeDocument,TypeDocumentVo>{ 

	public  TypeDocumentConverter(){
		init(true);
	}

	@Override 
 	public TypeDocument toItem(TypeDocumentVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	TypeDocument item = new TypeDocument();
			 if(StringUtil.isNotEmpty(vo.getLibelle()))
                  item.setLibelle(vo.getLibelle());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public TypeDocumentVo toVo(TypeDocument item) {
 		if (item == null) {
    		return null;
      	} else {
			TypeDocumentVo vo = new TypeDocumentVo();

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
