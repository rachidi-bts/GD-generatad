package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.TypeFiliere;
import ma.zs.generated.ws.rest.provided.vo.TypeFiliereVo;

public interface TypeFiliereService {

        /**

     * find all TypeFiliere in database 
     * @return List<TypeFiliere> , If database is empty return  null.
     */
	List<TypeFiliere> findAll();
	   
	/**

     * find TypeFiliere from database by libelle (reference)
     * @param libelle - reference of TypeFiliere 
     * @return the founded TypeFiliere , If no TypeFiliere were
     *         found in database return  null.
     */
	TypeFiliere findByLibelle(String libelle);

    /**
     * find TypeFiliere from database by id (id)
     * @param id - id of TypeFiliere 
     * @return the founded  TypeFiliere , If no TypeFiliere were
     *         found in database return  null.
     */
	TypeFiliere findById(Long id);
	
    /**
     * save TypeFiliere in database
     * @param typeFiliere - TypeFiliere to be saved 
     * @return the saved TypeFiliere, If the TypeFiliere can't be saved return null.
     */
	TypeFiliere save(TypeFiliere typeFiliere);

	/**
     * save list TypeFiliere in database
     * @param typeFilieres - list of TypeFiliere to be saved 
     * @return the saved TypeFiliere list
     */
	List<TypeFiliere> save(List<TypeFiliere> typeFilieres);
    
     /**
     * update TypeFiliere in database
     * @param typeFiliere - TypeFiliere to be updated
     * @return the updated TypeFiliere, If the TypeFiliere can't be updated return null.
     */
    TypeFiliere update(TypeFiliere typeFiliere);
    
       /**
     * delete TypeFiliere from database
     * @param typeFiliere - TypeFiliere to be deleted
     * @return 1 if TypeFiliere deleted successfully, If the TypeFiliere can't be deleted return negative int
     */
	int delete(TypeFiliere typeFiliere);
        /**
     * delete TypeFiliere from database by libelle (reference)
     * 
     * @param libelle - reference of TypeFiliere to be deleted
     * @return 1 if TypeFiliere deleted successfully
     */
	int deleteByLibelle(String libelle);
    
	/**
     * search for TypeFiliere in by some criteria
     * @return the searhed list TypeFiliere 
     */
	List<TypeFiliere> findByCriteria( TypeFiliereVo typeFiliereVo);
}