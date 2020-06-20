package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.Demmandeur;
import ma.zs.generated.ws.rest.provided.vo.DemmandeurVo;

public interface DemmandeurService {

        /**

     * find all Demmandeur in database 
     * @return List<Demmandeur> , If database is empty return  null.
     */
	List<Demmandeur> findAll();
	   
	/**

     * find Demmandeur from database by cne (reference)
     * @param cne - reference of Demmandeur 
     * @return the founded Demmandeur , If no Demmandeur were
     *         found in database return  null.
     */
	Demmandeur findByCne(String cne);

    /**
     * find Demmandeur from database by id (id)
     * @param id - id of Demmandeur 
     * @return the founded  Demmandeur , If no Demmandeur were
     *         found in database return  null.
     */
	Demmandeur findById(Long id);
	
	List<Demmandeur> findByFiliereLibelle(String libelle);
    int deleteByFiliereLibelle(String libelle);       
			
    List<Demmandeur> findByFiliereId(Long id);
    int deleteByFiliereId(Long id);
			 
    /**
     * save Demmandeur in database
     * @param demmandeur - Demmandeur to be saved 
     * @return the saved Demmandeur, If the Demmandeur can't be saved return null.
     */
	Demmandeur save(Demmandeur demmandeur);

	/**
     * save list Demmandeur in database
     * @param demmandeurs - list of Demmandeur to be saved 
     * @return the saved Demmandeur list
     */
	List<Demmandeur> save(List<Demmandeur> demmandeurs);
    
     /**
     * update Demmandeur in database
     * @param demmandeur - Demmandeur to be updated
     * @return the updated Demmandeur, If the Demmandeur can't be updated return null.
     */
    Demmandeur update(Demmandeur demmandeur);
    
       /**
     * delete Demmandeur from database
     * @param demmandeur - Demmandeur to be deleted
     * @return 1 if Demmandeur deleted successfully, If the Demmandeur can't be deleted return negative int
     */
	int delete(Demmandeur demmandeur);
        /**
     * delete Demmandeur from database by cne (reference)
     * 
     * @param cne - reference of Demmandeur to be deleted
     * @return 1 if Demmandeur deleted successfully
     */
	int deleteByCne(String cne);
    
	/**
     * search for Demmandeur in by some criteria
     * @return the searhed list Demmandeur 
     */
	List<Demmandeur> findByCriteria( DemmandeurVo demmandeurVo);
}