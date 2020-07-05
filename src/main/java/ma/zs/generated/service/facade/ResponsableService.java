package ma.zs.generated.service.facade;

import java.util.List;


import ma.zs.generated.bean.Responsable;
import ma.zs.generated.ws.rest.provided.vo.ResponsableVo;

public interface ResponsableService {

        /**

     * find all Responsable in database 
     * @return List<Responsable> , If database is empty return  null.
     */
	List<Responsable> findAll();
	   
	/**

     * find Responsable from database by login (reference)
     * @param login - reference of Responsable 
     * @return the founded Responsable , If no Responsable were
     *         found in database return  null.
     */
	Responsable findByLogin(String login);

    /**
     * find Responsable from database by id (id)
     * @param id - id of Responsable 
     * @return the founded  Responsable , If no Responsable were
     *         found in database return  null.
     */
	Responsable findById(Long id);
	
	List<Responsable> findByTypeFiliereLibelle(String libelle);
    int deleteByTypeFiliereLibelle(String libelle);       
			
    List<Responsable> findByTypeFiliereId(Long id);
    int deleteByTypeFiliereId(Long id);
			 
    /**
     * save Responsable in database
     * @param responsable - Responsable to be saved 
     * @return the saved Responsable, If the Responsable can't be saved return null.
     */
	Responsable save(Responsable responsable);

	/**
     * save list Responsable in database
     * @param responsables - list of Responsable to be saved 
     * @return the saved Responsable list
     */
	List<Responsable> save(List<Responsable> responsables);
    
     /**
     * update Responsable in database
     * @param responsable - Responsable to be updated
     * @return the updated Responsable, If the Responsable can't be updated return null.
     */
    Responsable update(Responsable responsable);
    
       /**
     * delete Responsable from database
     * @param responsable - Responsable to be deleted
     * @return 1 if Responsable deleted successfully, If the Responsable can't be deleted return negative int
     */
	int delete(Responsable responsable);
        /**
     * delete Responsable from database by login (reference)
     * 
     * @param login - reference of Responsable to be deleted
     * @return 1 if Responsable deleted successfully
     */
	int deleteByLogin(String login);
    
	/**
     * search for Responsable in by some criteria
     * @return the searhed list Responsable 
     */
	List<Responsable> findByCriteria( ResponsableVo responsableVo);
}