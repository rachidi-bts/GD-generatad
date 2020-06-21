package  ma.zs.generated.ws.rest.provided.facade;

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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zs.generated.bean.Demmandeur; 
import ma.zs.generated.service.facade.DemmandeurService;
import ma.zs.generated.ws.rest.provided.converter.DemmandeurConverter;
import ma.zs.generated.ws.rest.provided.vo.DemmandeurVo;

@Api("Manages demmandeur services")
@RestController
@RequestMapping("generated/demmandeur")
public class DemmandeurRest {

	@Autowired 
	private DemmandeurService demmandeurService;
	
	@Autowired 
	private DemmandeurConverter demmandeurConverter ;

    @ApiOperation("Saves the specified demmandeur")
	@PostMapping("/")
	public DemmandeurVo save(@RequestBody DemmandeurVo demmandeurVo){
		Demmandeur demmandeur= demmandeurConverter.toItem(demmandeurVo);
	  demmandeur=	demmandeurService.save(demmandeur);
		return demmandeurConverter.toVo(demmandeur);
	}

    @ApiOperation("Delete the specified demmandeur")
	@DeleteMapping("/")
	public int delete(@RequestBody DemmandeurVo demmandeurVo){
		Demmandeur demmandeur = demmandeurConverter.toItem(demmandeurVo);
		return demmandeurService.delete(demmandeur);
	}

	@ApiOperation("Updates the specified demmandeur")
	@PutMapping("/")
	public DemmandeurVo update(@RequestBody DemmandeurVo demmandeurVo){
		Demmandeur demmandeur= demmandeurConverter.toItem(demmandeurVo);
	  demmandeur=	demmandeurService.update(demmandeur);
		return demmandeurConverter.toVo(demmandeur);
	}

	@ApiOperation("Finds a list of all demmandeurs")
	@GetMapping("/")
	public List<DemmandeurVo> findAll(){
		return demmandeurConverter.toVo(demmandeurService.findAll());
	}
    
	@ApiOperation("Finds a  demmandeur by cne")
    @GetMapping("/cne/{cne}")
	public DemmandeurVo findByCne(@PathVariable String cne){
		return  demmandeurConverter.toVo(demmandeurService.findByCne(cne));
	}
	@ApiOperation("Deletes a  demmandeur by cne")
    @DeleteMapping("/cne/{cne}")
	public int deleteByCne(@PathVariable String cne){
		return  demmandeurService.deleteByCne(cne);
	}
	
	@GetMapping("/codeApogee/{codeApogee}")
	public DemmandeurVo findByCodeApogee(@PathVariable String codeApogee) {
		return demmandeurConverter.toVo(demmandeurService.findByCodeApogee(codeApogee));
	}

	@GetMapping("/nom/{nom}")
	public DemmandeurVo findByNom(@PathVariable String nom) {
		return demmandeurConverter.toVo(demmandeurService.findByNom(nom));
	}

	@GetMapping("/cin/{cin}")
	public DemmandeurVo findByCin(@PathVariable String cin) {
		return demmandeurConverter.toVo(demmandeurService.findByCin(cin));
	}
	
	
	@GetMapping("/filiere/abrv/{abrv}")
	public List<DemmandeurVo> findByFiliereAbrv(@PathVariable String abrv){
	return demmandeurConverter.toVo(demmandeurService.findByFiliereAbrv(abrv));
	}
	


    @ApiOperation("Finds a demmandeur by libelle of filiere")
	@GetMapping("/filiere/libelle/{libelle}")
	public List<DemmandeurVo> findByFiliereLibelle(@PathVariable String libelle){
		return demmandeurConverter.toVo(demmandeurService.findByFiliereLibelle(libelle));
	}
	
	@ApiOperation("Deletes a demmandeur by libelle of filiere")
	@DeleteMapping("/filiere/libelle/{libelle}")
	public int deleteByFiliereLibelle(@PathVariable String libelle){
		return demmandeurService.deleteByFiliereLibelle(libelle);
	}
	
	@ApiOperation("Finds demmandeur by id of filiere")
	@GetMapping("/filiere/id/{id}")
	public List<DemmandeurVo> findByFiliereId(@PathVariable Long id){
		return demmandeurConverter.toVo(demmandeurService.findByFiliereId(id));
	}
	@ApiOperation("Deletes demmandeur by id of filiere")
	@DeleteMapping("/filiere/id/{id}")
	public int deleteByFiliereId(@PathVariable Long id){
		return demmandeurService.deleteByFiliereId(id);
	}
     	
   
    @ApiOperation("Search demmandeur by a specific criterion")
    @PostMapping("/search")
	public List<DemmandeurVo> findByCriteria(@RequestBody DemmandeurVo demmandeurVo){
       return demmandeurConverter.toVo(demmandeurService.findByCriteria(demmandeurVo));
	}	
	public DemmandeurConverter getDemmandeurConverter(){
		return demmandeurConverter;
	}
 
	public void setDemmandeurConverter(DemmandeurConverter demmandeurConverter){
		this.demmandeurConverter=demmandeurConverter;
	}

	public DemmandeurService getDemmandeurService(){
		return demmandeurService;
	}
	public void setDemmandeurService( DemmandeurService demmandeurService){
	 	this.demmandeurService=demmandeurService;
	}
	

}