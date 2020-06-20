package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Module;
import ma.zs.generated.dao.ModuleDao;
import ma.zs.generated.service.facade.ModuleService;
import ma.zs.generated.ws.rest.provided.vo.ModuleVo;
import ma.zs.generated.service.util.*;
@Service
public class ModuleServiceImpl implements ModuleService {

   @Autowired
   private ModuleDao moduleDao;
   
   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Module> findAll(){
		return moduleDao.findAll();
	}	
	@Override
	public Module findByLibelle(String libelle){
		return moduleDao.findByLibelle(libelle);
	}

		@Override
		@Transactional
	public int deleteByLibelle(String  libelle) {
		return moduleDao.deleteByLibelle(libelle);	 
	}

	@Override
	public Module findById(Long id){
		return moduleDao.getOne(id);
	}

	@Override	
	public Module save (Module module){
	        if(module.getLibelle()==null)
			  return null;
		
			Module foundedModule = findByLibelle(module.getLibelle());
	       if(foundedModule!=null)
	          return null;  

	    Module savedModule = moduleDao.save(module);
	   return savedModule;
	}

    @Override
    public List<Module> save(List<Module> modules){
		List<Module> list = new ArrayList<Module>();
		for(Module module: modules){
		        list.add(save(module));	
		}
		return list;
	}


   @Override
   public Module update(Module module){
     
	        if(module.getLibelle()==null)
			  return null;
		
			Module foundedModule = findByLibelle(module.getLibelle());
	       if(foundedModule==null)
	          return null;  
	 
	   return  moduleDao.save(foundedModule);
     
     }
    
	@Override
	@Transactional
	public int delete(Module module){

	        if(module.getLibelle()==null)
			  return -1;
		
			Module foundedModule = findByLibelle(module.getLibelle());
	       if(foundedModule==null)
	          return -1;  
	   moduleDao.delete(foundedModule);
	   return 1;
	}


	public List<Module> findByCriteria(ModuleVo moduleVo){
      String query = "SELECT o FROM Module o where 1=1 ";
	 query += SearchUtil.addConstraint( "o", "libelle","=",moduleVo.getLibelle());
	 query += SearchUtil.addConstraint( "o", "id","=",moduleVo.getId());

	 return entityManager.createQuery(query).getResultList();
	}
  
 
}