package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.Resultat;
import ma.zs.generated.ws.rest.provided.vo.ResultatVo;

public interface ResultatService {

        /**

     * find all Resultat in database 
     * @return List<Resultat> , If database is empty return  null.
     */
	List<Resultat> findAll();
	   
	/**

     * find Resultat from database by libelle (reference)
     * @param libelle - reference of Resultat 
     * @return the founded Resultat , If no Resultat were
     *         found in database return  null.
     */
	Resultat findByLibelle(String libelle);

    /**
     * find Resultat from database by id (id)
     * @param id - id of Resultat 
     * @return the founded  Resultat , If no Resultat were
     *         found in database return  null.
     */
	Resultat findById(Long id);
	
    /**
     * save Resultat in database
     * @param resultat - Resultat to be saved 
     * @return the saved Resultat, If the Resultat can't be saved return null.
     */
	Resultat save(Resultat resultat);

	/**
     * save list Resultat in database
     * @param resultats - list of Resultat to be saved 
     * @return the saved Resultat list
     */
	List<Resultat> save(List<Resultat> resultats);
    
     /**
     * update Resultat in database
     * @param resultat - Resultat to be updated
     * @return the updated Resultat, If the Resultat can't be updated return null.
     */
    Resultat update(Resultat resultat);
    
       /**
     * delete Resultat from database
     * @param resultat - Resultat to be deleted
     * @return 1 if Resultat deleted successfully, If the Resultat can't be deleted return negative int
     */
	int delete(Resultat resultat);
        /**
     * delete Resultat from database by libelle (reference)
     * 
     * @param libelle - reference of Resultat to be deleted
     * @return 1 if Resultat deleted successfully
     */
	int deleteByLibelle(String libelle);
    
	/**
     * search for Resultat in by some criteria
     * @return the searhed list Resultat 
     */
	List<Resultat> findByCriteria( ResultatVo resultatVo);
}