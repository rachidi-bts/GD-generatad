package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.NoteEtudiant;
import ma.zs.generated.bean.Resultat;
import ma.zs.generated.bean.Demmandeur;
import ma.zs.generated.bean.NoteEtudiantModule;
import ma.zs.generated.dao.NoteEtudiantDao;
import ma.zs.generated.service.facade.NoteEtudiantService;
import ma.zs.generated.service.facade.ResultatService;
import ma.zs.generated.service.facade.DemmandeurService;
import ma.zs.generated.service.facade.NoteEtudiantModuleService;
import ma.zs.generated.ws.rest.provided.vo.NoteEtudiantVo;
import ma.zs.generated.service.util.*;
@Service
public class NoteEtudiantServiceImpl implements NoteEtudiantService {

   @Autowired
   private NoteEtudiantDao noteEtudiantDao;
   
   @Autowired
    private ResultatService resultatFinalService ;
   @Autowired
    private DemmandeurService demmandeurService ;
     @Autowired
    private NoteEtudiantModuleService noteEtudiantModulesService ;
   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<NoteEtudiant> findAll(){
		return noteEtudiantDao.findAll();
	}	
	@Override
	public List<NoteEtudiant> findByResultatFinalLibelle(String libelle){
		return noteEtudiantDao.findByResultatFinalLibelle(libelle);
	}
	@Override
	@Transactional
    public int deleteByResultatFinalLibelle(String libelle){
		return noteEtudiantDao.deleteByResultatFinalLibelle(libelle);
	}
	
     @Override
    public List<NoteEtudiant> findByResultatFinalId(Long id){
		return noteEtudiantDao.findByResultatFinalId(id);

	}
	   @Override
	   @Transactional
    public int deleteByResultatFinalId(Long id){
		return noteEtudiantDao.deleteByResultatFinalId(id);

	}
     		
	@Override
	public List<NoteEtudiant> findByDemmandeurCne(String cne){
		return noteEtudiantDao.findByDemmandeurCne(cne);
	}
	@Override
	@Transactional
    public int deleteByDemmandeurCne(String cne){
		return noteEtudiantDao.deleteByDemmandeurCne(cne);
	}
	
     @Override
    public List<NoteEtudiant> findByDemmandeurId(Long id){
		return noteEtudiantDao.findByDemmandeurId(id);

	}
	   @Override
	   @Transactional
    public int deleteByDemmandeurId(Long id){
		return noteEtudiantDao.deleteByDemmandeurId(id);

	}
     		

	@Override
	public NoteEtudiant findById(Long id){
		return noteEtudiantDao.getOne(id);
	}

	@Override	
	public NoteEtudiant save (NoteEtudiant noteEtudiant){
		 if(noteEtudiant.getId()==null)
			  return null;
		  NoteEtudiant foundedNoteEtudiant = findById(noteEtudiant.getId()); 
		       if(foundedNoteEtudiant!=null)
	          return null;	  
	    
	          if(noteEtudiant.getResultatFinal()!=null){
				    Resultat resultat = resultatFinalService.findByLibelle(noteEtudiant.getResultatFinal().getLibelle());
				  if(resultat == null)
				  noteEtudiant.setResultatFinal(resultatFinalService.save(noteEtudiant.getResultatFinal()));
				  else
				  noteEtudiant.setResultatFinal(resultat);
			  }
	    
	          if(noteEtudiant.getDemmandeur()!=null){
				    Demmandeur demmandeur = demmandeurService.findByCne(noteEtudiant.getDemmandeur().getCne());
				  if(demmandeur == null)
				  noteEtudiant.setDemmandeur(demmandeurService.save(noteEtudiant.getDemmandeur()));
				  else
				  noteEtudiant.setDemmandeur(demmandeur);
			  }

	    NoteEtudiant savedNoteEtudiant = noteEtudiantDao.save(noteEtudiant);
               if(ListUtil.isNotEmpty(noteEtudiant.getNoteEtudiantModules())){
		  savedNoteEtudiant.setNoteEtudiantModules(noteEtudiantModulesService.save(prepareNoteEtudiantModules(savedNoteEtudiant,noteEtudiant.getNoteEtudiantModules())));
		 }
	   return savedNoteEtudiant;
	}

    @Override
    public List<NoteEtudiant> save(List<NoteEtudiant> noteEtudiants){
		List<NoteEtudiant> list = new ArrayList<NoteEtudiant>();
		for(NoteEtudiant noteEtudiant: noteEtudiants){
		        list.add(save(noteEtudiant));	
		}
		return list;
	}

     private List<NoteEtudiantModule> prepareNoteEtudiantModules(NoteEtudiant noteEtudiant,List<NoteEtudiantModule> noteEtudiantModules){
		    for(NoteEtudiantModule noteEtudiantModule:noteEtudiantModules ){
                  noteEtudiantModule.setNoteEtudiant(noteEtudiant); 
			}
			return noteEtudiantModules;
	  }

   @Override
   public NoteEtudiant update(NoteEtudiant noteEtudiant){
     
		 if(noteEtudiant.getId()==null)
			  return null;
		  NoteEtudiant foundedNoteEtudiant = findById(noteEtudiant.getId()); 
		       if(foundedNoteEtudiant==null)
	          return null;	  
	 
	   return  noteEtudiantDao.save(foundedNoteEtudiant);
     
     }
    
	@Override
	@Transactional
	public int delete(NoteEtudiant noteEtudiant){

		 if(noteEtudiant.getId()==null)
			  return -1;
		  NoteEtudiant foundedNoteEtudiant = findById(noteEtudiant.getId()); 
		       if(foundedNoteEtudiant==null)
	          return -1;	  
	   noteEtudiantDao.delete(foundedNoteEtudiant);
	   return 1;
	}


	public List<NoteEtudiant> findByCriteria(NoteEtudiantVo noteEtudiantVo){
      String query = "SELECT o FROM NoteEtudiant o where 1=1 ";
	 query += SearchUtil.addConstraint( "o", "noteFinale","=",noteEtudiantVo.getNoteFinale());
	 query += SearchUtil.addConstraint( "o", "id","=",noteEtudiantVo.getId());
	  query += SearchUtil.addConstraintMinMax("o","noteFinale",noteEtudiantVo.getNoteFinaleMin(),noteEtudiantVo.getNoteFinaleMax());

	 return entityManager.createQuery(query).getResultList();
	}
	@Override
	public NoteEtudiant findByDemmandeurCneAndSemestreAndAnneeUniversitaire(String cne, String semestre,Long anneeUniversitaire) {
		return noteEtudiantDao.findByDemmandeurCneAndSemestreAndAnneeUniversitaire(cne,semestre,anneeUniversitaire);
	}
  
 
}