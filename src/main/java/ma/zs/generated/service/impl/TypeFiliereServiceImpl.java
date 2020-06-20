package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.TypeFiliere;
import ma.zs.generated.dao.TypeFiliereDao;
import ma.zs.generated.service.facade.TypeFiliereService;
import ma.zs.generated.ws.rest.provided.vo.TypeFiliereVo;
import ma.zs.generated.service.util.*;
@Service
public class TypeFiliereServiceImpl implements TypeFiliereService {

   @Autowired
   private TypeFiliereDao typeFiliereDao;
   
   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<TypeFiliere> findAll(){
		return typeFiliereDao.findAll();
	}	
	@Override
	public TypeFiliere findByLibelle(String libelle){
		return typeFiliereDao.findByLibelle(libelle);
	}

		@Override
		@Transactional
	public int deleteByLibelle(String  libelle) {
		return typeFiliereDao.deleteByLibelle(libelle);	 
	}

	@Override
	public TypeFiliere findById(Long id){
		return typeFiliereDao.getOne(id);
	}

	@Override	
	public TypeFiliere save (TypeFiliere typeFiliere){
	        if(typeFiliere.getLibelle()==null)
			  return null;
		
			TypeFiliere foundedTypeFiliere = findByLibelle(typeFiliere.getLibelle());
	       if(foundedTypeFiliere!=null)
	          return null;  

	    TypeFiliere savedTypeFiliere = typeFiliereDao.save(typeFiliere);
	   return savedTypeFiliere;
	}

    @Override
    public List<TypeFiliere> save(List<TypeFiliere> typeFilieres){
		List<TypeFiliere> list = new ArrayList<TypeFiliere>();
		for(TypeFiliere typeFiliere: typeFilieres){
		        list.add(save(typeFiliere));	
		}
		return list;
	}


   @Override
   public TypeFiliere update(TypeFiliere typeFiliere){
     
	        if(typeFiliere.getLibelle()==null)
			  return null;
		
			TypeFiliere foundedTypeFiliere = findByLibelle(typeFiliere.getLibelle());
	       if(foundedTypeFiliere==null)
	          return null;  
	 
	   return  typeFiliereDao.save(foundedTypeFiliere);
     
     }
    
	@Override
	@Transactional
	public int delete(TypeFiliere typeFiliere){

	        if(typeFiliere.getLibelle()==null)
			  return -1;
		
			TypeFiliere foundedTypeFiliere = findByLibelle(typeFiliere.getLibelle());
	       if(foundedTypeFiliere==null)
	          return -1;  
	   typeFiliereDao.delete(foundedTypeFiliere);
	   return 1;
	}


	public List<TypeFiliere> findByCriteria(TypeFiliereVo typeFiliereVo){
      String query = "SELECT o FROM TypeFiliere o where 1=1 ";
	 query += SearchUtil.addConstraint( "o", "libelle","=",typeFiliereVo.getLibelle());
	 query += SearchUtil.addConstraint( "o", "id","=",typeFiliereVo.getId());

	 return entityManager.createQuery(query).getResultList();
	}
  
 
}