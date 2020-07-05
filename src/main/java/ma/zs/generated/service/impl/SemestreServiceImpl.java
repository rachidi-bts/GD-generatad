package ma.zs.generated.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.generated.bean.Semestre;
import ma.zs.generated.dao.SemestreDao;
import ma.zs.generated.service.facade.SemestreService;
import ma.zs.generated.service.util.SearchUtil;
import ma.zs.generated.ws.rest.provided.vo.SemestreVo;
@Service
public class SemestreServiceImpl implements SemestreService {

   @Autowired
   private SemestreDao semestreDao;
   
   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Semestre> findAll(){
		return semestreDao.findAll();
	}	
	@Override
	public Semestre findByLibellee(String libellee){
		return semestreDao.findByLibellee(libellee);
	}

		@Override
		@Transactional
	public int deleteByLibellee(String  libellee) {
		return semestreDao.deleteByLibellee(libellee);	 
	}

	@Override
	public Semestre findById(Long id){
		return semestreDao.getOne(id);
	}

	@Override	
	public Semestre save (Semestre semestre){
	        if(semestre.getLibellee()==null)
			  return null;
		
			Semestre foundedSemestre = findByLibellee(semestre.getLibellee());
	       if(foundedSemestre!=null)
	          return null;  

	    Semestre savedSemestre = semestreDao.save(semestre);
	   return savedSemestre;
	}

    @Override
    public List<Semestre> save(List<Semestre> semestres){
		List<Semestre> list = new ArrayList<Semestre>();
		for(Semestre semestre: semestres){
		        list.add(save(semestre));	
		}
		return list;
	}


   @Override
   public Semestre update(Semestre semestre){
     
	        if(semestre.getLibellee()==null)
			  return null;
		
			Semestre foundedSemestre = findByLibellee(semestre.getLibellee());
	       if(foundedSemestre==null)
	          return null;  
	 
	   return  semestreDao.save(foundedSemestre);
     
     }
    
	@Override
	@Transactional
	public int delete(Semestre semestre){

	        if(semestre.getLibellee()==null)
			  return -1;
		
			Semestre foundedSemestre = findByLibellee(semestre.getLibellee());
	       if(foundedSemestre==null)
	          return -1;  
	   semestreDao.delete(foundedSemestre);
	   return 1;
	}


	public List<Semestre> findByCriteria(SemestreVo semestreVo){
      String query = "SELECT o FROM Semestre o where 1=1 ";
	 query += SearchUtil.addConstraint( "o", "libelle","=",semestreVo.getLibellee());
	 query += SearchUtil.addConstraint( "o", "id","=",semestreVo.getId());

	 return entityManager.createQuery(query).getResultList();
	}
  
 
}