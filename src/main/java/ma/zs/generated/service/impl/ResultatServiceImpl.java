package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Resultat;
import ma.zs.generated.dao.ResultatDao;
import ma.zs.generated.service.facade.ResultatService;
import ma.zs.generated.ws.rest.provided.vo.ResultatVo;
import ma.zs.generated.service.util.*;
@Service
public class ResultatServiceImpl implements ResultatService {

   @Autowired
   private ResultatDao resultatDao;
   
   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Resultat> findAll(){
		return resultatDao.findAll();
	}	
	@Override
	public Resultat findByLibelle(String libelle){
		return resultatDao.findByLibelle(libelle);
	}

		@Override
		@Transactional
	public int deleteByLibelle(String  libelle) {
		return resultatDao.deleteByLibelle(libelle);	 
	}

	@Override
	public Resultat findById(Long id){
		return resultatDao.getOne(id);
	}

	@Override	
	public Resultat save (Resultat resultat){
	        if(resultat.getLibelle()==null)
			  return null;
		
			Resultat foundedResultat = findByLibelle(resultat.getLibelle());
	       if(foundedResultat!=null)
	          return null;  

	    Resultat savedResultat = resultatDao.save(resultat);
	   return savedResultat;
	}

    @Override
    public List<Resultat> save(List<Resultat> resultats){
		List<Resultat> list = new ArrayList<Resultat>();
		for(Resultat resultat: resultats){
		        list.add(save(resultat));	
		}
		return list;
	}


   @Override
   public Resultat update(Resultat resultat){
     
	        if(resultat.getLibelle()==null)
			  return null;
		
			Resultat foundedResultat = findByLibelle(resultat.getLibelle());
	       if(foundedResultat==null)
	          return null;  
	 
	   return  resultatDao.save(foundedResultat);
     
     }
    
	@Override
	@Transactional
	public int delete(Resultat resultat){

	        if(resultat.getLibelle()==null)
			  return -1;
		
			Resultat foundedResultat = findByLibelle(resultat.getLibelle());
	       if(foundedResultat==null)
	          return -1;  
	   resultatDao.delete(foundedResultat);
	   return 1;
	}


	public List<Resultat> findByCriteria(ResultatVo resultatVo){
      String query = "SELECT o FROM Resultat o where 1=1 ";
	 query += SearchUtil.addConstraint( "o", "libelle","=",resultatVo.getLibelle());
	 query += SearchUtil.addConstraint( "o", "id","=",resultatVo.getId());

	 return entityManager.createQuery(query).getResultList();
	}
  
 
}