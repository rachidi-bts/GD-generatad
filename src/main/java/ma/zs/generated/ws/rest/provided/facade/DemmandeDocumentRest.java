package  ma.zs.generated.ws.rest.provided.facade;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zs.generated.bean.DemmandeDocument; 
import ma.zs.generated.service.facade.DemmandeDocumentService;
import ma.zs.generated.ws.rest.provided.converter.DemmandeDocumentConverter;
import ma.zs.generated.ws.rest.provided.vo.DemmandeDocumentVo;
import ma.zs.generated.ws.rest.provided.vo.DemmandeurVo;

@Api("Manages demmandeDocument services")
@RestController
@RequestMapping("generated/demmandeDocument")
public class DemmandeDocumentRest {

	@Autowired 
	private DemmandeDocumentService demmandeDocumentService;
	
	@Autowired 
	private DemmandeDocumentConverter demmandeDocumentConverter ;

    @ApiOperation("Saves the specified demmandeDocument")
	@PostMapping("/")
	public DemmandeDocumentVo save(@RequestBody DemmandeDocumentVo demmandeDocumentVo){
		DemmandeDocument demmandeDocument= demmandeDocumentConverter.toItem(demmandeDocumentVo);
	  demmandeDocument=	demmandeDocumentService.save(demmandeDocument);
		return demmandeDocumentConverter.toVo(demmandeDocument);
	}

    @ApiOperation("Delete the specified demmandeDocument")
	@DeleteMapping("/")
	public int delete(@RequestBody DemmandeDocumentVo demmandeDocumentVo){
		DemmandeDocument demmandeDocument = demmandeDocumentConverter.toItem(demmandeDocumentVo);
		return demmandeDocumentService.delete(demmandeDocument);
	}

	@ApiOperation("Updates the specified demmandeDocument")
	@PutMapping("/")
	public DemmandeDocumentVo update(@RequestBody DemmandeDocumentVo demmandeDocumentVo){
		DemmandeDocument demmandeDocument= demmandeDocumentConverter.toItem(demmandeDocumentVo);
	  demmandeDocument=	demmandeDocumentService.update(demmandeDocument);
		return demmandeDocumentConverter.toVo(demmandeDocument);
	}

	@ApiOperation("Finds a list of all demmandeDocuments")
	@GetMapping("/")
	public List<DemmandeDocumentVo> findAll(){
		return demmandeDocumentConverter.toVo(demmandeDocumentService.findAll());
	}
    
	@ApiOperation("Finds a demmandeDocument by id")
	@GetMapping("/id/{id}")
	public DemmandeDocumentVo findById(@PathVariable Long id){
		return  demmandeDocumentConverter.toVo(demmandeDocumentService.findById(id));
	}
	


    @ApiOperation("Finds a demmandeDocument by libelle of etatDemmande")
	@GetMapping("/etatDemmande/libelle/{libelle}")
	public List<DemmandeDocumentVo> findByEtatDemmandeLibelle(@PathVariable String libelle){
		return demmandeDocumentConverter.toVo(demmandeDocumentService.findByEtatDemmandeLibelle(libelle));
	}
	
	@ApiOperation("Deletes a demmandeDocument by libelle of etatDemmande")
	@DeleteMapping("/etatDemmande/libelle/{libelle}")
	public int deleteByEtatDemmandeLibelle(@PathVariable String libelle){
		return demmandeDocumentService.deleteByEtatDemmandeLibelle(libelle);
	}
	
	@ApiOperation("Finds demmandeDocument by id of etatDemmande")
	@GetMapping("/etatDemmande/id/{id}")
	public List<DemmandeDocumentVo> findByEtatDemmandeId(@PathVariable Long id){
		return demmandeDocumentConverter.toVo(demmandeDocumentService.findByEtatDemmandeId(id));
	}
	@ApiOperation("Deletes demmandeDocument by id of etatDemmande")
	@DeleteMapping("/etatDemmande/id/{id}")
	public int deleteByEtatDemmandeId(@PathVariable Long id){
		return demmandeDocumentService.deleteByEtatDemmandeId(id);
	}
     	
    @ApiOperation("Finds a demmandeDocument by cne of demmandeur")
	@GetMapping("/demmandeur/cne/{cne}")
	public List<DemmandeDocumentVo> findByDemmandeurCne(@PathVariable String cne){
		return demmandeDocumentConverter.toVo(demmandeDocumentService.findByDemmandeurCne(cne));
	}
	
	@ApiOperation("Deletes a demmandeDocument by cne of demmandeur")
	@DeleteMapping("/demmandeur/cne/{cne}")
	public int deleteByDemmandeurCne(@PathVariable String cne){
		return demmandeDocumentService.deleteByDemmandeurCne(cne);
	}
	
	@GetMapping("/demmandeur/nom/{nom}")
	public List<DemmandeDocumentVo> findByDemmandeurNom(@PathVariable String nom) {
		return demmandeDocumentConverter.toVo(demmandeDocumentService.findByDemmandeurNom(nom));
	}


	@GetMapping("/demmandeur/codeApogee/{codeApogee}")
	public List<DemmandeDocumentVo> findByDemmandeurCodeApogee(@PathVariable String codeApogee) {
		return demmandeDocumentConverter.toVo(demmandeDocumentService.findByDemmandeurCodeApogee(codeApogee));
	}
	
	@GetMapping("/demmandeur/cin/{cin}")
	public List<DemmandeDocumentVo> findByDemmandeurCin(@PathVariable String cin) {
		return demmandeDocumentConverter.toVo(demmandeDocumentService.findByDemmandeurCin(cin));
	}
	
	@GetMapping("/demmandeur/filiere/abrv/{abrv}")
	public List<DemmandeDocumentVo> findByDemmandeurFiliereAbrv(@PathVariable String abrv){
	return demmandeDocumentConverter.toVo(demmandeDocumentService.findByDemmandeurFiliereAbrv(abrv));
	}

	@GetMapping("/infoDemmandeurPdf/cin/{cin}/libelle/{libelle}")
	public int infoDemmandeurPdf(@PathVariable String cin, @PathVariable String libelle) throws DocumentException, FileNotFoundException{
		return demmandeDocumentService.infoDemmandeurPdf(cin, libelle);
	} 
	
	@GetMapping("/infoRelevePdf/cne/{cne}/semestre/{semestre}/anneeUniversitaire/{anneeUniversitaire}/libelle/{libelle}")
	public int infoRelevePdf(@PathVariable String cne,@PathVariable String semestre,@PathVariable Long anneeUniversitaire, @PathVariable String libelle) throws DocumentException, FileNotFoundException{
		return demmandeDocumentService.infoRelevePdf(cne,semestre,anneeUniversitaire, libelle);
	} 
	
	
	@ApiOperation("Finds demmandeDocument by id of demmandeur")
	@GetMapping("/demmandeur/id/{id}")
	public List<DemmandeDocumentVo> findByDemmandeurId(@PathVariable Long id){
		return demmandeDocumentConverter.toVo(demmandeDocumentService.findByDemmandeurId(id));
	}
	@ApiOperation("Deletes demmandeDocument by id of demmandeur")
	@DeleteMapping("/demmandeur/id/{id}")
	public int deleteByDemmandeurId(@PathVariable Long id){
		return demmandeDocumentService.deleteByDemmandeurId(id);
	}
     	
    @ApiOperation("Finds a demmandeDocument by libelle of typeDocument")
	@GetMapping("/typeDocument/libelle/{libelle}")
	public List<DemmandeDocumentVo> findByTypeDocumentLibelle(@PathVariable String libelle){
		return demmandeDocumentConverter.toVo(demmandeDocumentService.findByTypeDocumentLibelle(libelle));
	}
	
	@ApiOperation("Deletes a demmandeDocument by libelle of typeDocument")
	@DeleteMapping("/typeDocument/libelle/{libelle}")
	public int deleteByTypeDocumentLibelle(@PathVariable String libelle){
		return demmandeDocumentService.deleteByTypeDocumentLibelle(libelle);
	}
	
	@ApiOperation("Finds demmandeDocument by id of typeDocument")
	@GetMapping("/typeDocument/id/{id}")
	public List<DemmandeDocumentVo> findByTypeDocumentId(@PathVariable Long id){
		return demmandeDocumentConverter.toVo(demmandeDocumentService.findByTypeDocumentId(id));
	}
	@ApiOperation("Deletes demmandeDocument by id of typeDocument")
	@DeleteMapping("/typeDocument/id/{id}")
	public int deleteByTypeDocumentId(@PathVariable Long id){
		return demmandeDocumentService.deleteByTypeDocumentId(id);
	}
     	
   
    @ApiOperation("Search demmandeDocument by a specific criterion")
    @PostMapping("/search")
	public List<DemmandeDocumentVo> findByCriteria(@RequestBody DemmandeDocumentVo demmandeDocumentVo){
       return demmandeDocumentConverter.toVo(demmandeDocumentService.findByCriteria(demmandeDocumentVo));
	}	
	public DemmandeDocumentConverter getDemmandeDocumentConverter(){
		return demmandeDocumentConverter;
	}
 
	public void setDemmandeDocumentConverter(DemmandeDocumentConverter demmandeDocumentConverter){
		this.demmandeDocumentConverter=demmandeDocumentConverter;
	}

	public DemmandeDocumentService getDemmandeDocumentService(){
		return demmandeDocumentService;
	}
	public void setDemmandeDocumentService( DemmandeDocumentService demmandeDocumentService){
	 	this.demmandeDocumentService=demmandeDocumentService;
	}
	

}