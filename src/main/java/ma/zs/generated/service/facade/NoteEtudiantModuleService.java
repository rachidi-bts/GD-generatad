package ma.zs.generated.service.facade;

import java.util.List;

import ma.zs.generated.bean.NoteEtudiant;
import ma.zs.generated.bean.NoteEtudiantModule;
import ma.zs.generated.ws.rest.provided.vo.NoteEtudiantModuleVo;

public interface NoteEtudiantModuleService {

        /**

     * find all NoteEtudiantModule in database 
     * @return List<NoteEtudiantModule> , If database is empty return  null.
     */
	List<NoteEtudiantModule> findAll();	   

    /**
     * find NoteEtudiantModule from database by id (id)
     * @param id - id of NoteEtudiantModule 
     * @return the founded  NoteEtudiantModule , If no NoteEtudiantModule were
     *         found in database return  null.
     */
	NoteEtudiantModule findById(Long id);
	
    List<NoteEtudiantModule> findByNoteEtudiantId(Long id);
    int deleteByNoteEtudiantId(Long id);
			 
	List<NoteEtudiantModule> findByResultatLibelle(String libelle);
    int deleteByResultatLibelle(String libelle);       
			
    List<NoteEtudiantModule> findByResultatId(Long id);
    int deleteByResultatId(Long id);
			 
	List<NoteEtudiantModule> findByModuleLibelle(String libelle);
    int deleteByModuleLibelle(String libelle);       
			
    List<NoteEtudiantModule> findByModuleId(Long id);
    int deleteByModuleId(Long id);
			 
    /**
     * save NoteEtudiantModule in database
     * @param noteEtudiantModule - NoteEtudiantModule to be saved 
     * @return the saved NoteEtudiantModule, If the NoteEtudiantModule can't be saved return null.
     */
	NoteEtudiantModule save(NoteEtudiantModule noteEtudiantModule);

	/**
     * save list NoteEtudiantModule in database
     * @param noteEtudiantModules - list of NoteEtudiantModule to be saved 
     * @return the saved NoteEtudiantModule list
     */
	List<NoteEtudiantModule> save(List<NoteEtudiantModule> noteEtudiantModules);
    
     /**
     * update NoteEtudiantModule in database
     * @param noteEtudiantModule - NoteEtudiantModule to be updated
     * @return the updated NoteEtudiantModule, If the NoteEtudiantModule can't be updated return null.
     */
    NoteEtudiantModule update(NoteEtudiantModule noteEtudiantModule);
    
       /**
     * delete NoteEtudiantModule from database
     * @param noteEtudiantModule - NoteEtudiantModule to be deleted
     * @return 1 if NoteEtudiantModule deleted successfully, If the NoteEtudiantModule can't be deleted return negative int
     */
	int delete(NoteEtudiantModule noteEtudiantModule);
    
	/**
     * search for NoteEtudiantModule in by some criteria
     * @return the searhed list NoteEtudiantModule 
     */
	List<NoteEtudiantModule> findByCriteria( NoteEtudiantModuleVo noteEtudiantModuleVo);
}