package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.EtatDemmande;
import ma.zs.generated.ws.rest.provided.vo.EtatDemmandeVo;

public interface EtatDemmandeService {

        /**

     * find all EtatDemmande in database 
     * @return List<EtatDemmande> , If database is empty return  null.
     */
	List<EtatDemmande> findAll();
	   
	/**

     * find EtatDemmande from database by libelle (reference)
     * @param libelle - reference of EtatDemmande 
     * @return the founded EtatDemmande , If no EtatDemmande were
     *         found in database return  null.
     */
	EtatDemmande findByLibelle(String libelle);

    /**
     * find EtatDemmande from database by id (id)
     * @param id - id of EtatDemmande 
     * @return the founded  EtatDemmande , If no EtatDemmande were
     *         found in database return  null.
     */
	EtatDemmande findById(Long id);
	
    /**
     * save EtatDemmande in database
     * @param etatDemmande - EtatDemmande to be saved 
     * @return the saved EtatDemmande, If the EtatDemmande can't be saved return null.
     */
	EtatDemmande save(EtatDemmande etatDemmande);

	/**
     * save list EtatDemmande in database
     * @param etatDemmandes - list of EtatDemmande to be saved 
     * @return the saved EtatDemmande list
     */
	List<EtatDemmande> save(List<EtatDemmande> etatDemmandes);
    
     /**
     * update EtatDemmande in database
     * @param etatDemmande - EtatDemmande to be updated
     * @return the updated EtatDemmande, If the EtatDemmande can't be updated return null.
     */
    EtatDemmande update(EtatDemmande etatDemmande);
    
       /**
     * delete EtatDemmande from database
     * @param etatDemmande - EtatDemmande to be deleted
     * @return 1 if EtatDemmande deleted successfully, If the EtatDemmande can't be deleted return negative int
     */
	int delete(EtatDemmande etatDemmande);
        /**
     * delete EtatDemmande from database by libelle (reference)
     * 
     * @param libelle - reference of EtatDemmande to be deleted
     * @return 1 if EtatDemmande deleted successfully
     */
	int deleteByLibelle(String libelle);
    
	/**
     * search for EtatDemmande in by some criteria
     * @return the searhed list EtatDemmande 
     */
	List<EtatDemmande> findByCriteria( EtatDemmandeVo etatDemmandeVo);
}