package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.TypeDocument;
import ma.zs.generated.ws.rest.provided.vo.TypeDocumentVo;

public interface TypeDocumentService {

        /**

     * find all TypeDocument in database 
     * @return List<TypeDocument> , If database is empty return  null.
     */
	List<TypeDocument> findAll();
	   
	/**

     * find TypeDocument from database by libelle (reference)
     * @param libelle - reference of TypeDocument 
     * @return the founded TypeDocument , If no TypeDocument were
     *         found in database return  null.
     */
	TypeDocument findByLibelle(String libelle);

    /**
     * find TypeDocument from database by id (id)
     * @param id - id of TypeDocument 
     * @return the founded  TypeDocument , If no TypeDocument were
     *         found in database return  null.
     */
	TypeDocument findById(Long id);
	
    /**
     * save TypeDocument in database
     * @param typeDocument - TypeDocument to be saved 
     * @return the saved TypeDocument, If the TypeDocument can't be saved return null.
     */
	TypeDocument save(TypeDocument typeDocument);

	/**
     * save list TypeDocument in database
     * @param typeDocuments - list of TypeDocument to be saved 
     * @return the saved TypeDocument list
     */
	List<TypeDocument> save(List<TypeDocument> typeDocuments);
    
     /**
     * update TypeDocument in database
     * @param typeDocument - TypeDocument to be updated
     * @return the updated TypeDocument, If the TypeDocument can't be updated return null.
     */
    TypeDocument update(TypeDocument typeDocument);
    
       /**
     * delete TypeDocument from database
     * @param typeDocument - TypeDocument to be deleted
     * @return 1 if TypeDocument deleted successfully, If the TypeDocument can't be deleted return negative int
     */
	int delete(TypeDocument typeDocument);
        /**
     * delete TypeDocument from database by libelle (reference)
     * 
     * @param libelle - reference of TypeDocument to be deleted
     * @return 1 if TypeDocument deleted successfully
     */
	int deleteByLibelle(String libelle);
    
	/**
     * search for TypeDocument in by some criteria
     * @return the searhed list TypeDocument 
     */
	List<TypeDocument> findByCriteria( TypeDocumentVo typeDocumentVo);
}