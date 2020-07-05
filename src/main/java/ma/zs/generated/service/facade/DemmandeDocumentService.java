package ma.zs.generated.service.facade;

import java.io.FileNotFoundException;
import java.util.List;

import com.itextpdf.text.DocumentException;

import ma.zs.generated.bean.DemmandeDocument;
import ma.zs.generated.bean.Demmandeur;
import ma.zs.generated.ws.rest.provided.vo.DemmandeDocumentVo;

public interface DemmandeDocumentService {

        /**

     * find all DemmandeDocument in database 
     * @return List<DemmandeDocument> , If database is empty return  null.
     */
	List<DemmandeDocument> findAll();
	   

    /**
     * find DemmandeDocument from database by id (id)
     * @param id - id of DemmandeDocument 
     * @return the founded  DemmandeDocument , If no DemmandeDocument were
     *         found in database return  null.
     */
	DemmandeDocument findById(Long id);
	
	DemmandeDocument findBySemestreLibelleeAndAnneeUniversitaire(String libellee, Long anneeUniversitaire);
	
	  DemmandeDocument findByAnneeUniversitaire(Long anneeUniversitaire);

	List<DemmandeDocument> findByEtatDemmandeLibelle(String libelle);
    int deleteByEtatDemmandeLibelle(String libelle);       
			
    List<DemmandeDocument> findByEtatDemmandeId(Long id);
    int deleteByEtatDemmandeId(Long id);
			 
	List<DemmandeDocument> findByDemmandeurCne(String cne);
    int deleteByDemmandeurCne(String cne);    
    
    public List<DemmandeDocument> findByDemmandeurNom(String nom);

   	public List<DemmandeDocument> findByDemmandeurCodeApogee(String codeApogee);
   	
   	public List<DemmandeDocument> findByDemmandeurCin(String cin);
   	
    public List<DemmandeDocument> findByDemmandeurFiliereAbrv(String abrv);
    
    public int infoDemmandeurPdf(String cin, String libelle,Long anneeUniversitaire) throws DocumentException, FileNotFoundException;
    
	public int infoRelevePdf(String cne,String libellee, Long anneeUniversitaire, String libelle) throws DocumentException, FileNotFoundException;
		
	public int listeDemmandeurExcel(List<Demmandeur> demmandeurs);
	
    List<DemmandeDocument> findByDemmandeurId(Long id);
    int deleteByDemmandeurId(Long id);
    
    
			 
	List<DemmandeDocument> findByTypeDocumentLibelle(String libelle);
    int deleteByTypeDocumentLibelle(String libelle);       
			
    List<DemmandeDocument> findByTypeDocumentId(Long id);
    int deleteByTypeDocumentId(Long id);
			 
    /**
     * save DemmandeDocument in database
     * @param demmandeDocument - DemmandeDocument to be saved 
     * @return the saved DemmandeDocument, If the DemmandeDocument can't be saved return null.
     */
	DemmandeDocument save(DemmandeDocument demmandeDocument);

	/**
     * save list DemmandeDocument in database
     * @param demmandeDocuments - list of DemmandeDocument to be saved 
     * @return the saved DemmandeDocument list
     */
	List<DemmandeDocument> save(List<DemmandeDocument> demmandeDocuments);
    
     /**
     * update DemmandeDocument in database
     * @param demmandeDocument - DemmandeDocument to be updated
     * @return the updated DemmandeDocument, If the DemmandeDocument can't be updated return null.
     */
    DemmandeDocument update(DemmandeDocument demmandeDocument);
    
       /**
     * delete DemmandeDocument from database
     * @param demmandeDocument - DemmandeDocument to be deleted
     * @return 1 if DemmandeDocument deleted successfully, If the DemmandeDocument can't be deleted return negative int
     */
	int delete(DemmandeDocument demmandeDocument);
    
	/**
     * search for DemmandeDocument in by some criteria
     * @return the searhed list DemmandeDocument 
     */
	List<DemmandeDocument> findByCriteria( DemmandeDocumentVo demmandeDocumentVo);
}