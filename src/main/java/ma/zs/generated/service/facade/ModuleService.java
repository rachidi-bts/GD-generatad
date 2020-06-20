package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.Module;
import ma.zs.generated.ws.rest.provided.vo.ModuleVo;

public interface ModuleService {

        /**

     * find all Module in database 
     * @return List<Module> , If database is empty return  null.
     */
	List<Module> findAll();
	   
	/**

     * find Module from database by libelle (reference)
     * @param libelle - reference of Module 
     * @return the founded Module , If no Module were
     *         found in database return  null.
     */
	Module findByLibelle(String libelle);

    /**
     * find Module from database by id (id)
     * @param id - id of Module 
     * @return the founded  Module , If no Module were
     *         found in database return  null.
     */
	Module findById(Long id);
	
    /**
     * save Module in database
     * @param module - Module to be saved 
     * @return the saved Module, If the Module can't be saved return null.
     */
	Module save(Module module);

	/**
     * save list Module in database
     * @param modules - list of Module to be saved 
     * @return the saved Module list
     */
	List<Module> save(List<Module> modules);
    
     /**
     * update Module in database
     * @param module - Module to be updated
     * @return the updated Module, If the Module can't be updated return null.
     */
    Module update(Module module);
    
       /**
     * delete Module from database
     * @param module - Module to be deleted
     * @return 1 if Module deleted successfully, If the Module can't be deleted return negative int
     */
	int delete(Module module);
        /**
     * delete Module from database by libelle (reference)
     * 
     * @param libelle - reference of Module to be deleted
     * @return 1 if Module deleted successfully
     */
	int deleteByLibelle(String libelle);
    
	/**
     * search for Module in by some criteria
     * @return the searhed list Module 
     */
	List<Module> findByCriteria( ModuleVo moduleVo);
}