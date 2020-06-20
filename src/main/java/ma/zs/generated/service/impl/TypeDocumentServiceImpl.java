package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.TypeDocument;
import ma.zs.generated.dao.TypeDocumentDao;
import ma.zs.generated.service.facade.TypeDocumentService;
import ma.zs.generated.ws.rest.provided.vo.TypeDocumentVo;
import ma.zs.generated.service.util.*;
@Service
public class TypeDocumentServiceImpl implements TypeDocumentService {

   @Autowired
   private TypeDocumentDao typeDocumentDao;
   
   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<TypeDocument> findAll(){
		return typeDocumentDao.findAll();
	}	
	@Override
	public TypeDocument findByLibelle(String libelle){
		return typeDocumentDao.findByLibelle(libelle);
	}

		@Override
		@Transactional
	public int deleteByLibelle(String  libelle) {
		return typeDocumentDao.deleteByLibelle(libelle);	 
	}

	@Override
	public TypeDocument findById(Long id){
		return typeDocumentDao.getOne(id);
	}

	@Override	
	public TypeDocument save (TypeDocument typeDocument){
	        if(typeDocument.getLibelle()==null)
			  return null;
		
			TypeDocument foundedTypeDocument = findByLibelle(typeDocument.getLibelle());
	       if(foundedTypeDocument!=null)
	          return null;  

	    TypeDocument savedTypeDocument = typeDocumentDao.save(typeDocument);
	   return savedTypeDocument;
	}

    @Override
    public List<TypeDocument> save(List<TypeDocument> typeDocuments){
		List<TypeDocument> list = new ArrayList<TypeDocument>();
		for(TypeDocument typeDocument: typeDocuments){
		        list.add(save(typeDocument));	
		}
		return list;
	}


   @Override
   public TypeDocument update(TypeDocument typeDocument){
     
	        if(typeDocument.getLibelle()==null)
			  return null;
		
			TypeDocument foundedTypeDocument = findByLibelle(typeDocument.getLibelle());
	       if(foundedTypeDocument==null)
	          return null;  
	 
	   return  typeDocumentDao.save(foundedTypeDocument);
     
     }
    
	@Override
	@Transactional
	public int delete(TypeDocument typeDocument){

	        if(typeDocument.getLibelle()==null)
			  return -1;
		
			TypeDocument foundedTypeDocument = findByLibelle(typeDocument.getLibelle());
	       if(foundedTypeDocument==null)
	          return -1;  
	   typeDocumentDao.delete(foundedTypeDocument);
	   return 1;
	}


	public List<TypeDocument> findByCriteria(TypeDocumentVo typeDocumentVo){
      String query = "SELECT o FROM TypeDocument o where 1=1 ";
	 query += SearchUtil.addConstraint( "o", "libelle","=",typeDocumentVo.getLibelle());
	 query += SearchUtil.addConstraint( "o", "id","=",typeDocumentVo.getId());

	 return entityManager.createQuery(query).getResultList();
	}
  
 
}