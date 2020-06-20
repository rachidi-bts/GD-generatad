package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.DemmandeDocument;
import ma.zs.generated.bean.EtatDemmande;
import ma.zs.generated.bean.Demmandeur;
import ma.zs.generated.bean.TypeDocument;
import ma.zs.generated.dao.DemmandeDocumentDao;
import ma.zs.generated.service.facade.DemmandeDocumentService;
import ma.zs.generated.service.facade.EtatDemmandeService;
import ma.zs.generated.service.facade.DemmandeurService;
import ma.zs.generated.service.facade.TypeDocumentService;
import ma.zs.generated.ws.rest.provided.vo.DemmandeDocumentVo;
import ma.zs.generated.service.util.*;
@Service
public class DemmandeDocumentServiceImpl implements DemmandeDocumentService {

   @Autowired
   private DemmandeDocumentDao demmandeDocumentDao;
   
   @Autowired
    private EtatDemmandeService etatDemmandeService ;
   @Autowired
    private DemmandeurService demmandeurService ;
   @Autowired
    private TypeDocumentService typeDocumentService ;
   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<DemmandeDocument> findAll(){
		return demmandeDocumentDao.findAll();
	}	
	@Override
	public List<DemmandeDocument> findByEtatDemmandeLibelle(String libelle){
		return demmandeDocumentDao.findByEtatDemmandeLibelle(libelle);
	}
	@Override
	@Transactional
    public int deleteByEtatDemmandeLibelle(String libelle){
		return demmandeDocumentDao.deleteByEtatDemmandeLibelle(libelle);
	}
	
     @Override
    public List<DemmandeDocument> findByEtatDemmandeId(Long id){
		return demmandeDocumentDao.findByEtatDemmandeId(id);

	}
	   @Override
	   @Transactional
    public int deleteByEtatDemmandeId(Long id){
		return demmandeDocumentDao.deleteByEtatDemmandeId(id);

	}
     		
	@Override
	public List<DemmandeDocument> findByDemmandeurCne(String cne){
		return demmandeDocumentDao.findByDemmandeurCne(cne);
	}
	@Override
	@Transactional
    public int deleteByDemmandeurCne(String cne){
		return demmandeDocumentDao.deleteByDemmandeurCne(cne);
	}
	
     @Override
    public List<DemmandeDocument> findByDemmandeurId(Long id){
		return demmandeDocumentDao.findByDemmandeurId(id);

	}
	   @Override
	   @Transactional
    public int deleteByDemmandeurId(Long id){
		return demmandeDocumentDao.deleteByDemmandeurId(id);

	}
     		
	@Override
	public List<DemmandeDocument> findByTypeDocumentLibelle(String libelle){
		return demmandeDocumentDao.findByTypeDocumentLibelle(libelle);
	}
	@Override
	@Transactional
    public int deleteByTypeDocumentLibelle(String libelle){
		return demmandeDocumentDao.deleteByTypeDocumentLibelle(libelle);
	}
	
     @Override
    public List<DemmandeDocument> findByTypeDocumentId(Long id){
		return demmandeDocumentDao.findByTypeDocumentId(id);

	}
	   @Override
	   @Transactional
    public int deleteByTypeDocumentId(Long id){
		return demmandeDocumentDao.deleteByTypeDocumentId(id);

	}
     		

	@Override
	public DemmandeDocument findById(Long id){
		return demmandeDocumentDao.getOne(id);
	}

	@Override	
	public DemmandeDocument save (DemmandeDocument demmandeDocument){
		 if(demmandeDocument.getId()!=null)
		 {
		  DemmandeDocument foundedDemmandeDocument = findById(demmandeDocument.getId()); 
		       if(foundedDemmandeDocument!=null)
	          return null;	  }
	    
	          if(demmandeDocument.getEtatDemmande()!=null){
				    EtatDemmande etatDemmande = etatDemmandeService.findByLibelle(demmandeDocument.getEtatDemmande().getLibelle());
				  if(etatDemmande == null)
				  demmandeDocument.setEtatDemmande(etatDemmandeService.save(demmandeDocument.getEtatDemmande()));
				  else
				  demmandeDocument.setEtatDemmande(etatDemmande);
			  }
	    
	          if(demmandeDocument.getDemmandeur()!=null){
				    Demmandeur demmandeur = demmandeurService.findByCne(demmandeDocument.getDemmandeur().getCne());
				  if(demmandeur == null)
				  demmandeDocument.setDemmandeur(demmandeurService.save(demmandeDocument.getDemmandeur()));
				  else
				  demmandeDocument.setDemmandeur(demmandeur);
			  }
	    
	          if(demmandeDocument.getTypeDocument()!=null){
				    TypeDocument typeDocument = typeDocumentService.findByLibelle(demmandeDocument.getTypeDocument().getLibelle());
				  if(typeDocument == null)
				  demmandeDocument.setTypeDocument(typeDocumentService.save(demmandeDocument.getTypeDocument()));
				  else
				  demmandeDocument.setTypeDocument(typeDocument);
			  }

	    DemmandeDocument savedDemmandeDocument = demmandeDocumentDao.save(demmandeDocument);
	   return savedDemmandeDocument;
	}

    @Override
    public List<DemmandeDocument> save(List<DemmandeDocument> demmandeDocuments){
		List<DemmandeDocument> list = new ArrayList<DemmandeDocument>();
		for(DemmandeDocument demmandeDocument: demmandeDocuments){
		        list.add(save(demmandeDocument));	
		}
		return list;
	}


   @Override
   public DemmandeDocument update(DemmandeDocument demmandeDocument){
     
		 if(demmandeDocument.getId()==null)
			  return null;
		  DemmandeDocument foundedDemmandeDocument = findById(demmandeDocument.getId()); 
		       if(foundedDemmandeDocument==null)
	          return null;	  
	 
	   return  demmandeDocumentDao.save(foundedDemmandeDocument);
     
     }
    
	@Override
	@Transactional
	public int delete(DemmandeDocument demmandeDocument){

		 if(demmandeDocument.getId()==null)
			  return -1;
		  DemmandeDocument foundedDemmandeDocument = findById(demmandeDocument.getId()); 
		       if(foundedDemmandeDocument==null)
	          return -1;	  
	   demmandeDocumentDao.delete(foundedDemmandeDocument);
	   return 1;
	}


	public List<DemmandeDocument> findByCriteria(DemmandeDocumentVo demmandeDocumentVo){
      String query = "SELECT o FROM DemmandeDocument o where 1=1 ";
	  query += SearchUtil.addConstraintDate( "o", "dateDemmande","=",demmandeDocumentVo.getDateDemmande());
	  query += SearchUtil.addConstraintDate( "o", "dateValidation","=",demmandeDocumentVo.getDateValidation());
	 query += SearchUtil.addConstraint( "o", "id","=",demmandeDocumentVo.getId());
	  query += SearchUtil.addConstraintMinMaxDate("o","dateDemmande",demmandeDocumentVo.getDateDemmandeMin(),demmandeDocumentVo.getDateDemmandeMax());
	  query += SearchUtil.addConstraintMinMaxDate("o","dateValidation",demmandeDocumentVo.getDateValidationMin(),demmandeDocumentVo.getDateValidationMax());

	 return entityManager.createQuery(query).getResultList();
	}
  
 
}