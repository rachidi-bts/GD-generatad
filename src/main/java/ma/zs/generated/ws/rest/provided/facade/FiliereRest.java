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
import ma.zs.generated.bean.Filiere; 
import ma.zs.generated.service.facade.FiliereService;
import ma.zs.generated.ws.rest.provided.converter.FiliereConverter;
import ma.zs.generated.ws.rest.provided.vo.FiliereVo;

@Api("Manages filiere services")
@RestController
@RequestMapping("generated/filiere")
public class FiliereRest {

	@Autowired 
	private FiliereService filiereService;
	
	@Autowired 
	private FiliereConverter filiereConverter ;

    @ApiOperation("Saves the specified filiere")
	@PostMapping("/")
	public FiliereVo save(@RequestBody FiliereVo filiereVo){
		Filiere filiere= filiereConverter.toItem(filiereVo);
	  filiere=	filiereService.save(filiere);
		return filiereConverter.toVo(filiere);
	}

    @ApiOperation("Delete the specified filiere")
	@DeleteMapping("/")
	public int delete(@RequestBody FiliereVo filiereVo){
		Filiere filiere = filiereConverter.toItem(filiereVo);
		return filiereService.delete(filiere);
	}

	@ApiOperation("Updates the specified filiere")
	@PutMapping("/")
	public FiliereVo update(@RequestBody FiliereVo filiereVo){
		Filiere filiere= filiereConverter.toItem(filiereVo);
	  filiere=	filiereService.update(filiere);
		return filiereConverter.toVo(filiere);
	}

	@ApiOperation("Finds a list of all filieres")
	@GetMapping("/")
	public List<FiliereVo> findAll(){
		return filiereConverter.toVo(filiereService.findAll());
	}
    
	@ApiOperation("Finds a  filiere by libelle")
    @GetMapping("/libelle/{libelle}")
	public FiliereVo findByLibelle(@PathVariable String libelle){
		return  filiereConverter.toVo(filiereService.findByLibelle(libelle));
	}
	@ApiOperation("Deletes a  filiere by libelle")
    @DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle){
		return  filiereService.deleteByLibelle(libelle);
	}


    @ApiOperation("Finds a filiere by libelle of typeFiliere")
	@GetMapping("/typeFiliere/libelle/{libelle}")
	public List<FiliereVo> findByTypeFiliereLibelle(@PathVariable String libelle){
		return filiereConverter.toVo(filiereService.findByTypeFiliereLibelle(libelle));
	}
	
	@ApiOperation("Deletes a filiere by libelle of typeFiliere")
	@DeleteMapping("/typeFiliere/libelle/{libelle}")
	public int deleteByTypeFiliereLibelle(@PathVariable String libelle){
		return filiereService.deleteByTypeFiliereLibelle(libelle);
	}
	
	@ApiOperation("Finds filiere by id of typeFiliere")
	@GetMapping("/typeFiliere/id/{id}")
	public List<FiliereVo> findByTypeFiliereId(@PathVariable Long id){
		return filiereConverter.toVo(filiereService.findByTypeFiliereId(id));
	}
	@ApiOperation("Deletes filiere by id of typeFiliere")
	@DeleteMapping("/typeFiliere/id/{id}")
	public int deleteByTypeFiliereId(@PathVariable Long id){
		return filiereService.deleteByTypeFiliereId(id);
	}
     	
   
    @ApiOperation("Search filiere by a specific criterion")
    @PostMapping("/search")
	public List<FiliereVo> findByCriteria(@RequestBody FiliereVo filiereVo){
       return filiereConverter.toVo(filiereService.findByCriteria(filiereVo));
	}	
	public FiliereConverter getFiliereConverter(){
		return filiereConverter;
	}
 
	public void setFiliereConverter(FiliereConverter filiereConverter){
		this.filiereConverter=filiereConverter;
	}

	public FiliereService getFiliereService(){
		return filiereService;
	}
	public void setFiliereService( FiliereService filiereService){
	 	this.filiereService=filiereService;
	}
	

}