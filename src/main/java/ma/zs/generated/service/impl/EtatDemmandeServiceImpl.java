package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.EtatDemmande;
import ma.zs.generated.dao.EtatDemmandeDao;
import ma.zs.generated.service.facade.EtatDemmandeService;
import ma.zs.generated.ws.rest.provided.vo.EtatDemmandeVo;
import ma.zs.generated.service.util.*;
@Service
public class EtatDemmandeServiceImpl implements EtatDemmandeService {

   @Autowired
   private EtatDemmandeDao etatDemmandeDao;
   
   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<EtatDemmande> findAll(){
		return etatDemmandeDao.findAll();
	}	
	@Override
	public EtatDemmande findByLibelle(String libelle){
		return etatDemmandeDao.findByLibelle(libelle);
	}

		@Override
		@Transactional
	public int deleteByLibelle(String  libelle) {
		return etatDemmandeDao.deleteByLibelle(libelle);	 
	}

	@Override
	public EtatDemmande findById(Long id){
		return etatDemmandeDao.getOne(id);
	}

	@Override	
	public EtatDemmande save (EtatDemmande etatDemmande){
	        if(etatDemmande.getLibelle()==null)
			  return null;
		
			EtatDemmande foundedEtatDemmande = findByLibelle(etatDemmande.getLibelle());
	       if(foundedEtatDemmande!=null)
	          return null;  

	    EtatDemmande savedEtatDemmande = etatDemmandeDao.save(etatDemmande);
	   return savedEtatDemmande;
	}

    @Override
    public List<EtatDemmande> save(List<EtatDemmande> etatDemmandes){
		List<EtatDemmande> list = new ArrayList<EtatDemmande>();
		for(EtatDemmande etatDemmande: etatDemmandes){
		        list.add(save(etatDemmande));	
		}
		return list;
	}


   @Override
   public EtatDemmande update(EtatDemmande etatDemmande){
     
	        if(etatDemmande.getLibelle()==null)
			  return null;
		
			EtatDemmande foundedEtatDemmande = findByLibelle(etatDemmande.getLibelle());
	       if(foundedEtatDemmande==null)
	          return null;  
	 
	   return  etatDemmandeDao.save(foundedEtatDemmande);
     
     }
    
	@Override
	@Transactional
	public int delete(EtatDemmande etatDemmande){

	        if(etatDemmande.getLibelle()==null)
			  return -1;
		
			EtatDemmande foundedEtatDemmande = findByLibelle(etatDemmande.getLibelle());
	       if(foundedEtatDemmande==null)
	          return -1;  
	   etatDemmandeDao.delete(foundedEtatDemmande);
	   return 1;
	}


	public List<EtatDemmande> findByCriteria(EtatDemmandeVo etatDemmandeVo){
      String query = "SELECT o FROM EtatDemmande o where 1=1 ";
	 query += SearchUtil.addConstraint( "o", "libelle","=",etatDemmandeVo.getLibelle());
	 query += SearchUtil.addConstraint( "o", "id","=",etatDemmandeVo.getId());

	 return entityManager.createQuery(query).getResultList();
	}
  
 
}