package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Demmandeur;
import ma.zs.generated.bean.Filiere;
import ma.zs.generated.dao.DemmandeurDao;
import ma.zs.generated.service.facade.DemmandeurService;
import ma.zs.generated.service.facade.FiliereService;
import ma.zs.generated.ws.rest.provided.vo.DemmandeurVo;
import ma.zs.generated.service.util.*;
@Service
public class DemmandeurServiceImpl implements DemmandeurService {

   @Autowired
   private DemmandeurDao demmandeurDao;
   
   @Autowired
    private FiliereService filiereService ;
   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Demmandeur> findAll(){
		return demmandeurDao.findAll();
	}	
	@Override
	public List<Demmandeur> findByFiliereLibelle(String libelle){
		return demmandeurDao.findByFiliereLibelle(libelle);
	}
	@Override
	@Transactional
    public int deleteByFiliereLibelle(String libelle){
		return demmandeurDao.deleteByFiliereLibelle(libelle);
	}
	
     @Override
    public List<Demmandeur> findByFiliereId(Long id){
		return demmandeurDao.findByFiliereId(id);

	}
	   @Override
	   @Transactional
    public int deleteByFiliereId(Long id){
		return demmandeurDao.deleteByFiliereId(id);

	}
     		
	@Override
	public Demmandeur findByCne(String cne){
		return demmandeurDao.findByCne(cne);
	}

		@Override
		@Transactional
	public int deleteByCne(String  cne) {
		return demmandeurDao.deleteByCne(cne);	 
	}

	@Override
	public Demmandeur findById(Long id){
		return demmandeurDao.getOne(id);
	}

	@Override	
	public Demmandeur save (Demmandeur demmandeur){
	        if(demmandeur.getCne()==null)
			  return null;
		
			Demmandeur foundedDemmandeur = findByCne(demmandeur.getCne());
	       if(foundedDemmandeur!=null)
	          return null;  
	    
	          if(demmandeur.getFiliere()!=null){
				    Filiere filiere = filiereService.findByLibelle(demmandeur.getFiliere().getLibelle());
				  if(filiere == null)
				  demmandeur.setFiliere(filiereService.save(demmandeur.getFiliere()));
				  else
				  demmandeur.setFiliere(filiere);
			  }

	    Demmandeur savedDemmandeur = demmandeurDao.save(demmandeur);
	   return savedDemmandeur;
	}

    @Override
    public List<Demmandeur> save(List<Demmandeur> demmandeurs){
		List<Demmandeur> list = new ArrayList<Demmandeur>();
		for(Demmandeur demmandeur: demmandeurs){
		        list.add(save(demmandeur));	
		}
		return list;
	}


   @Override
   public Demmandeur update(Demmandeur demmandeur){
     
	        if(demmandeur.getCne()==null)
			  return null;
		
			Demmandeur foundedDemmandeur = findByCne(demmandeur.getCne());
	       if(foundedDemmandeur==null)
	          return null;  
	 
	   return  demmandeurDao.save(foundedDemmandeur);
     
     }
    
	@Override
	@Transactional
	public int delete(Demmandeur demmandeur){

	        if(demmandeur.getCne()==null)
			  return -1;
		
			Demmandeur foundedDemmandeur = findByCne(demmandeur.getCne());
	       if(foundedDemmandeur==null)
	          return -1;  
	   demmandeurDao.delete(foundedDemmandeur);
	   return 1;
	}


	public List<Demmandeur> findByCriteria(DemmandeurVo demmandeurVo){
      String query = "SELECT o FROM Demmandeur o where 1=1 ";
	 query += SearchUtil.addConstraint( "o", "password","=",demmandeurVo.getPassword());
	 query += SearchUtil.addConstraint( "o", "paysNaissance","=",demmandeurVo.getPaysNaissance());
	 query += SearchUtil.addConstraint( "o", "anneeInscription","=",demmandeurVo.getAnneeInscription());
	 query += SearchUtil.addConstraint( "o", "login","=",demmandeurVo.getLogin());
	 query += SearchUtil.addConstraint( "o", "cne","=",demmandeurVo.getCne());
	 query += SearchUtil.addConstraint( "o", "nbreAttestInscrRest","=",demmandeurVo.getNbreAttestInscrRest());
	 query += SearchUtil.addConstraint( "o", "nbreCertScolRest","=",demmandeurVo.getNbreCertScolRest());
	 query += SearchUtil.addConstraint( "o", "prenom","=",demmandeurVo.getPrenom());
	 query += SearchUtil.addConstraint( "o", "cin","=",demmandeurVo.getCin());
	  query += SearchUtil.addConstraintDate( "o", "dateNaissance","=",demmandeurVo.getDateNaissance());
	 query += SearchUtil.addConstraint( "o", "villeNaissance","=",demmandeurVo.getVilleNaissance());
	 query += SearchUtil.addConstraint( "o", "id","=",demmandeurVo.getId());
	 query += SearchUtil.addConstraint( "o", "codeApogee","=",demmandeurVo.getCodeApogee());
	 query += SearchUtil.addConstraint( "o", "nom","=",demmandeurVo.getNom());
	  query += SearchUtil.addConstraintMinMax("o","anneeInscription",demmandeurVo.getAnneeInscriptionMin(),demmandeurVo.getAnneeInscriptionMax());
	  query += SearchUtil.addConstraintMinMax("o","nbreAttestInscrRest",demmandeurVo.getNbreAttestInscrRestMin(),demmandeurVo.getNbreAttestInscrRestMax());
	  query += SearchUtil.addConstraintMinMax("o","nbreCertScolRest",demmandeurVo.getNbreCertScolRestMin(),demmandeurVo.getNbreCertScolRestMax());
	  query += SearchUtil.addConstraintMinMaxDate("o","dateNaissance",demmandeurVo.getDateNaissanceMin(),demmandeurVo.getDateNaissanceMax());

	 return entityManager.createQuery(query).getResultList();
	}
  
 
}