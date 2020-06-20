package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.NoteEtudiantModule;
import ma.zs.generated.bean.NoteEtudiant;
import ma.zs.generated.bean.Resultat;
import ma.zs.generated.bean.Module;
import ma.zs.generated.dao.NoteEtudiantModuleDao;
import ma.zs.generated.service.facade.NoteEtudiantModuleService;
import ma.zs.generated.service.facade.NoteEtudiantService;
import ma.zs.generated.service.facade.ResultatService;
import ma.zs.generated.service.facade.ModuleService;
import ma.zs.generated.ws.rest.provided.vo.NoteEtudiantModuleVo;
import ma.zs.generated.service.util.*;
@Service
public class NoteEtudiantModuleServiceImpl implements NoteEtudiantModuleService {

   @Autowired
   private NoteEtudiantModuleDao noteEtudiantModuleDao;
   
   @Autowired
    private NoteEtudiantService noteEtudiantService ;
   @Autowired
    private ResultatService resultatService ;
   @Autowired
    private ModuleService moduleService ;
   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<NoteEtudiantModule> findAll(){
		return noteEtudiantModuleDao.findAll();
	}	
     @Override
    public List<NoteEtudiantModule> findByNoteEtudiantId(Long id){
		return noteEtudiantModuleDao.findByNoteEtudiantId(id);

	}
	   @Override
	   @Transactional
    public int deleteByNoteEtudiantId(Long id){
		return noteEtudiantModuleDao.deleteByNoteEtudiantId(id);

	}
     		
	@Override
	public List<NoteEtudiantModule> findByResultatLibelle(String libelle){
		return noteEtudiantModuleDao.findByResultatLibelle(libelle);
	}
	@Override
	@Transactional
    public int deleteByResultatLibelle(String libelle){
		return noteEtudiantModuleDao.deleteByResultatLibelle(libelle);
	}
	
     @Override
    public List<NoteEtudiantModule> findByResultatId(Long id){
		return noteEtudiantModuleDao.findByResultatId(id);

	}
	   @Override
	   @Transactional
    public int deleteByResultatId(Long id){
		return noteEtudiantModuleDao.deleteByResultatId(id);

	}
     		
	@Override
	public List<NoteEtudiantModule> findByModuleLibelle(String libelle){
		return noteEtudiantModuleDao.findByModuleLibelle(libelle);
	}
	@Override
	@Transactional
    public int deleteByModuleLibelle(String libelle){
		return noteEtudiantModuleDao.deleteByModuleLibelle(libelle);
	}
	
     @Override
    public List<NoteEtudiantModule> findByModuleId(Long id){
		return noteEtudiantModuleDao.findByModuleId(id);

	}
	   @Override
	   @Transactional
    public int deleteByModuleId(Long id){
		return noteEtudiantModuleDao.deleteByModuleId(id);

	}
     		

	@Override
	public NoteEtudiantModule findById(Long id){
		return noteEtudiantModuleDao.getOne(id);
	}

	@Override	
	public NoteEtudiantModule save (NoteEtudiantModule noteEtudiantModule){
		 if(noteEtudiantModule.getId()==null)
			  return null;
		  NoteEtudiantModule foundedNoteEtudiantModule = findById(noteEtudiantModule.getId()); 
		       if(foundedNoteEtudiantModule!=null)
	          return null;	  
	    
	          if(noteEtudiantModule.getNoteEtudiant()!=null){
				   NoteEtudiant noteEtudiant = noteEtudiantService.findById(noteEtudiantModule.getNoteEtudiant().getId());
				  if(noteEtudiant == null)
				  noteEtudiantModule.setNoteEtudiant(noteEtudiantService.save(noteEtudiantModule.getNoteEtudiant()));
				  else
				  noteEtudiantModule.setNoteEtudiant(noteEtudiant);
			  }
	    
	          if(noteEtudiantModule.getResultat()!=null){
				    Resultat resultat = resultatService.findByLibelle(noteEtudiantModule.getResultat().getLibelle());
				  if(resultat == null)
				  noteEtudiantModule.setResultat(resultatService.save(noteEtudiantModule.getResultat()));
				  else
				  noteEtudiantModule.setResultat(resultat);
			  }
	    
	          if(noteEtudiantModule.getModule()!=null){
				    Module module = moduleService.findByLibelle(noteEtudiantModule.getModule().getLibelle());
				  if(module == null)
				  noteEtudiantModule.setModule(moduleService.save(noteEtudiantModule.getModule()));
				  else
				  noteEtudiantModule.setModule(module);
			  }

	    NoteEtudiantModule savedNoteEtudiantModule = noteEtudiantModuleDao.save(noteEtudiantModule);
	   return savedNoteEtudiantModule;
	}

    @Override
    public List<NoteEtudiantModule> save(List<NoteEtudiantModule> noteEtudiantModules){
		List<NoteEtudiantModule> list = new ArrayList<NoteEtudiantModule>();
		for(NoteEtudiantModule noteEtudiantModule: noteEtudiantModules){
		        list.add(save(noteEtudiantModule));	
		}
		return list;
	}


   @Override
   public NoteEtudiantModule update(NoteEtudiantModule noteEtudiantModule){
     
		 if(noteEtudiantModule.getId()==null)
			  return null;
		  NoteEtudiantModule foundedNoteEtudiantModule = findById(noteEtudiantModule.getId()); 
		       if(foundedNoteEtudiantModule==null)
	          return null;	  
	 
	   return  noteEtudiantModuleDao.save(foundedNoteEtudiantModule);
     
     }
    
	@Override
	@Transactional
	public int delete(NoteEtudiantModule noteEtudiantModule){

		 if(noteEtudiantModule.getId()==null)
			  return -1;
		  NoteEtudiantModule foundedNoteEtudiantModule = findById(noteEtudiantModule.getId()); 
		       if(foundedNoteEtudiantModule==null)
	          return -1;	  
	   noteEtudiantModuleDao.delete(foundedNoteEtudiantModule);
	   return 1;
	}


	public List<NoteEtudiantModule> findByCriteria(NoteEtudiantModuleVo noteEtudiantModuleVo){
      String query = "SELECT o FROM NoteEtudiantModule o where 1=1 ";
	 query += SearchUtil.addConstraint( "o", "ptsJury","=",noteEtudiantModuleVo.getPtsJury());
	 query += SearchUtil.addConstraint( "o", "note","=",noteEtudiantModuleVo.getNote());
	 query += SearchUtil.addConstraint( "o", "id","=",noteEtudiantModuleVo.getId());
	  query += SearchUtil.addConstraintMinMax("o","note",noteEtudiantModuleVo.getNoteMin(),noteEtudiantModuleVo.getNoteMax());

	 return entityManager.createQuery(query).getResultList();
	}
  
 
}