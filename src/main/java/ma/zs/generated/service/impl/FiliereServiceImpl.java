package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Filiere;
import ma.zs.generated.bean.TypeFiliere;
import ma.zs.generated.dao.FiliereDao;
import ma.zs.generated.service.facade.FiliereService;
import ma.zs.generated.service.facade.TypeFiliereService;
import ma.zs.generated.ws.rest.provided.vo.FiliereVo;
import ma.zs.generated.service.util.*;
@Service
public class FiliereServiceImpl implements FiliereService {

   @Autowired
   private FiliereDao filiereDao;
   
   @Autowired
    private TypeFiliereService typeFiliereService ;
   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Filiere> findAll(){
		return filiereDao.findAll();
	}	
	@Override
	public List<Filiere> findByTypeFiliereLibelle(String libelle){
		return filiereDao.findByTypeFiliereLibelle(libelle);
	}
	@Override
	@Transactional
    public int deleteByTypeFiliereLibelle(String libelle){
		return filiereDao.deleteByTypeFiliereLibelle(libelle);
	}
	
     @Override
    public List<Filiere> findByTypeFiliereId(Long id){
		return filiereDao.findByTypeFiliereId(id);

	}
	   @Override
	   @Transactional
    public int deleteByTypeFiliereId(Long id){
		return filiereDao.deleteByTypeFiliereId(id);

	}
     		
	@Override
	public Filiere findByLibelle(String libelle){
		return filiereDao.findByLibelle(libelle);
	}

		@Override
		@Transactional
	public int deleteByLibelle(String  libelle) {
		return filiereDao.deleteByLibelle(libelle);	 
	}

	@Override
	public Filiere findById(Long id){
		return filiereDao.getOne(id);
	}

	@Override	
	public Filiere save (Filiere filiere){
	        if(filiere.getLibelle()==null)
			  return null;
		
			Filiere foundedFiliere = findByLibelle(filiere.getLibelle());
	       if(foundedFiliere!=null)
	          return null;  
	    
	          if(filiere.getTypeFiliere()!=null){
				    TypeFiliere typeFiliere = typeFiliereService.findByLibelle(filiere.getTypeFiliere().getLibelle());
				  if(typeFiliere == null)
				  filiere.setTypeFiliere(typeFiliereService.save(filiere.getTypeFiliere()));
				  else
				  filiere.setTypeFiliere(typeFiliere);
			  }

	    Filiere savedFiliere = filiereDao.save(filiere);
	   return savedFiliere;
	}

    @Override
    public List<Filiere> save(List<Filiere> filieres){
		List<Filiere> list = new ArrayList<Filiere>();
		for(Filiere filiere: filieres){
		        list.add(save(filiere));	
		}
		return list;
	}


   @Override
   public Filiere update(Filiere filiere){
     
	        if(filiere.getLibelle()==null)
			  return null;
		
			Filiere foundedFiliere = findByLibelle(filiere.getLibelle());
	       if(foundedFiliere==null)
	          return null;  
	 
	   return  filiereDao.save(foundedFiliere);
     
     }
    
	@Override
	@Transactional
	public int delete(Filiere filiere){

	        if(filiere.getLibelle()==null)
			  return -1;
		
			Filiere foundedFiliere = findByLibelle(filiere.getLibelle());
	       if(foundedFiliere==null)
	          return -1;  
	   filiereDao.delete(foundedFiliere);
	   return 1;
	}


	public List<Filiere> findByCriteria(FiliereVo filiereVo){
      String query = "SELECT o FROM Filiere o where 1=1 ";
	 query += SearchUtil.addConstraint( "o", "abrv","=",filiereVo.getAbrv());
	 query += SearchUtil.addConstraint( "o", "libelle","=",filiereVo.getLibelle());
	 query += SearchUtil.addConstraint( "o", "id","=",filiereVo.getId());

	 return entityManager.createQuery(query).getResultList();
	}
	@Override
	public Filiere findByAbrv(String abrv) {
		return filiereDao.findByAbrv(abrv);
	}
	@Override
	public int deleteByAbrv(String abrv) {
		return filiereDao.deleteByAbrv(abrv);
	}
  
 
}