package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.Filiere;
import ma.zs.generated.ws.rest.provided.vo.FiliereVo;

public interface FiliereService {

        /**

     * find all Filiere in database 
     * @return List<Filiere> , If database is empty return  null.
     */
	List<Filiere> findAll();
	   
	/**

     * find Filiere from database by libelle (reference)
     * @param libelle - reference of Filiere 
     * @return the founded Filiere , If no Filiere were
     *         found in database return  null.
     */
	Filiere findByLibelle(String libelle);

    /**
     * find Filiere from database by id (id)
     * @param id - id of Filiere 
     * @return the founded  Filiere , If no Filiere were
     *         found in database return  null.
     */
	Filiere findById(Long id);
	
	List<Filiere> findByTypeFiliereLibelle(String libelle);
    int deleteByTypeFiliereLibelle(String libelle);       
			
    List<Filiere> findByTypeFiliereId(Long id);
    int deleteByTypeFiliereId(Long id);
			 
    /**
     * save Filiere in database
     * @param filiere - Filiere to be saved 
     * @return the saved Filiere, If the Filiere can't be saved return null.
     */
	Filiere save(Filiere filiere);

	/**
     * save list Filiere in database
     * @param filieres - list of Filiere to be saved 
     * @return the saved Filiere list
     */
	List<Filiere> save(List<Filiere> filieres);
    
     /**
     * update Filiere in database
     * @param filiere - Filiere to be updated
     * @return the updated Filiere, If the Filiere can't be updated return null.
     */
    Filiere update(Filiere filiere);
    
       /**
     * delete Filiere from database
     * @param filiere - Filiere to be deleted
     * @return 1 if Filiere deleted successfully, If the Filiere can't be deleted return negative int
     */
	int delete(Filiere filiere);
        /**
     * delete Filiere from database by libelle (reference)
     * 
     * @param libelle - reference of Filiere to be deleted
     * @return 1 if Filiere deleted successfully
     */
	int deleteByLibelle(String libelle);
    
	/**
     * search for Filiere in by some criteria
     * @return the searhed list Filiere 
     */
	List<Filiere> findByCriteria( FiliereVo filiereVo);
}