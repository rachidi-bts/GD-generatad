package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Responsable;
import ma.zs.generated.bean.TypeFiliere;
import ma.zs.generated.dao.ResponsableDao;
import ma.zs.generated.service.facade.ResponsableService;
import ma.zs.generated.service.facade.TypeFiliereService;
import ma.zs.generated.ws.rest.provided.vo.ResponsableVo;
import ma.zs.generated.service.util.*;
@Service
public class ResponsableServiceImpl implements ResponsableService {

   @Autowired
   private ResponsableDao responsableDao;
   
   @Autowired
    private TypeFiliereService typeFiliereService ;
   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Responsable> findAll(){
		return responsableDao.findAll();
	}	
	@Override
	public List<Responsable> findByTypeFiliereLibelle(String libelle){
		return responsableDao.findByTypeFiliereLibelle(libelle);
	}
	@Override
	@Transactional
    public int deleteByTypeFiliereLibelle(String libelle){
		return responsableDao.deleteByTypeFiliereLibelle(libelle);
	}
	
     @Override
    public List<Responsable> findByTypeFiliereId(Long id){
		return responsableDao.findByTypeFiliereId(id);

	}
	   @Override
	   @Transactional
    public int deleteByTypeFiliereId(Long id){
		return responsableDao.deleteByTypeFiliereId(id);

	}
     		
	@Override
	public Responsable findByLogin(String login){
		return responsableDao.findByLogin(login);
	}

		@Override
		@Transactional
	public int deleteByLogin(String  login) {
		return responsableDao.deleteByLogin(login);	 
	}

	@Override
	public Responsable findById(Long id){
		return responsableDao.getOne(id);
	}

	@Override	
	public Responsable save (Responsable responsable){
	        if(responsable.getLogin()==null)
			  return null;
		
			Responsable foundedResponsable = findByLogin(responsable.getLogin());
	       if(foundedResponsable!=null)
	          return null;  
	    
	          if(responsable.getTypeFiliere()!=null){
				    TypeFiliere typeFiliere = typeFiliereService.findByLibelle(responsable.getTypeFiliere().getLibelle());
				  if(typeFiliere == null)
				  responsable.setTypeFiliere(typeFiliereService.save(responsable.getTypeFiliere()));
				  else
				  responsable.setTypeFiliere(typeFiliere);
			  }

	    Responsable savedResponsable = responsableDao.save(responsable);
	   return savedResponsable;
	}

    @Override
    public List<Responsable> save(List<Responsable> responsables){
		List<Responsable> list = new ArrayList<Responsable>();
		for(Responsable responsable: responsables){
		        list.add(save(responsable));	
		}
		return list;
	}


   @Override
   public Responsable update(Responsable responsable){
     
	        if(responsable.getLogin()==null)
			  return null;
		
			Responsable foundedResponsable = findByLogin(responsable.getLogin());
	       if(foundedResponsable==null)
	          return null;  
	 
	   return  responsableDao.save(foundedResponsable);
     
     }
    
	@Override
	@Transactional
	public int delete(Responsable responsable){

	        if(responsable.getLogin()==null)
			  return -1;
		
			Responsable foundedResponsable = findByLogin(responsable.getLogin());
	       if(foundedResponsable==null)
	          return -1;  
	   responsableDao.delete(foundedResponsable);
	   return 1;
	}


	public List<Responsable> findByCriteria(ResponsableVo responsableVo){
      String query = "SELECT o FROM Responsable o where 1=1 ";
	 query += SearchUtil.addConstraint( "o", "password","=",responsableVo.getPassword());
	 query += SearchUtil.addConstraint( "o", "login","=",responsableVo.getLogin());
	 query += SearchUtil.addConstraint( "o", "id","=",responsableVo.getId());

	 return entityManager.createQuery(query).getResultList();
	}
  
 
}