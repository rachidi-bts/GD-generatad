package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.NoteEtudiant;
import ma.zs.generated.ws.rest.provided.vo.NoteEtudiantVo;

public interface NoteEtudiantService {
	NoteEtudiant findByDemmandeurCneAndSemestreAndAnneeUniversitaire(String cne,String semestre, Long anneeUniversitaire);

        /**

     * find all NoteEtudiant in database 
     * @return List<NoteEtudiant> , If database is empty return  null.
     */
	List<NoteEtudiant> findAll();
	   

    /**
     * find NoteEtudiant from database by id (id)
     * @param id - id of NoteEtudiant 
     * @return the founded  NoteEtudiant , If no NoteEtudiant were
     *         found in database return  null.
     */
	NoteEtudiant findById(Long id);
	
	List<NoteEtudiant> findByResultatFinalLibelle(String libelle);
    int deleteByResultatFinalLibelle(String libelle);       
			
    List<NoteEtudiant> findByResultatFinalId(Long id);
    int deleteByResultatFinalId(Long id);
			 
	List<NoteEtudiant> findByDemmandeurCne(String cne);
    int deleteByDemmandeurCne(String cne);       
			
    List<NoteEtudiant> findByDemmandeurId(Long id);
    int deleteByDemmandeurId(Long id);
			 
    /**
     * save NoteEtudiant in database
     * @param noteEtudiant - NoteEtudiant to be saved 
     * @return the saved NoteEtudiant, If the NoteEtudiant can't be saved return null.
     */
	NoteEtudiant save(NoteEtudiant noteEtudiant);

	/**
     * save list NoteEtudiant in database
     * @param noteEtudiants - list of NoteEtudiant to be saved 
     * @return the saved NoteEtudiant list
     */
	List<NoteEtudiant> save(List<NoteEtudiant> noteEtudiants);
    
     /**
     * update NoteEtudiant in database
     * @param noteEtudiant - NoteEtudiant to be updated
     * @return the updated NoteEtudiant, If the NoteEtudiant can't be updated return null.
     */
    NoteEtudiant update(NoteEtudiant noteEtudiant);
    
       /**
     * delete NoteEtudiant from database
     * @param noteEtudiant - NoteEtudiant to be deleted
     * @return 1 if NoteEtudiant deleted successfully, If the NoteEtudiant can't be deleted return negative int
     */
	int delete(NoteEtudiant noteEtudiant);
    
	/**
     * search for NoteEtudiant in by some criteria
     * @return the searhed list NoteEtudiant 
     */
	List<NoteEtudiant> findByCriteria( NoteEtudiantVo noteEtudiantVo);
}