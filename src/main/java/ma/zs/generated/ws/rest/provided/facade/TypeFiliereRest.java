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
import ma.zs.generated.bean.TypeFiliere; 
import ma.zs.generated.service.facade.TypeFiliereService;
import ma.zs.generated.ws.rest.provided.converter.TypeFiliereConverter;
import ma.zs.generated.ws.rest.provided.vo.TypeFiliereVo;

@Api("Manages typeFiliere services")
@RestController
@RequestMapping("generated/typeFiliere")
public class TypeFiliereRest {

	@Autowired 
	private TypeFiliereService typeFiliereService;
	
	@Autowired 
	private TypeFiliereConverter typeFiliereConverter ;

    @ApiOperation("Saves the specified typeFiliere")
	@PostMapping("/")
	public TypeFiliereVo save(@RequestBody TypeFiliereVo typeFiliereVo){
		TypeFiliere typeFiliere= typeFiliereConverter.toItem(typeFiliereVo);
	  typeFiliere=	typeFiliereService.save(typeFiliere);
		return typeFiliereConverter.toVo(typeFiliere);
	}

    @ApiOperation("Delete the specified typeFiliere")
	@DeleteMapping("/")
	public int delete(@RequestBody TypeFiliereVo typeFiliereVo){
		TypeFiliere typeFiliere = typeFiliereConverter.toItem(typeFiliereVo);
		return typeFiliereService.delete(typeFiliere);
	}

	@ApiOperation("Updates the specified typeFiliere")
	@PutMapping("/")
	public TypeFiliereVo update(@RequestBody TypeFiliereVo typeFiliereVo){
		TypeFiliere typeFiliere= typeFiliereConverter.toItem(typeFiliereVo);
	  typeFiliere=	typeFiliereService.update(typeFiliere);
		return typeFiliereConverter.toVo(typeFiliere);
	}

	@ApiOperation("Finds a list of all typeFilieres")
	@GetMapping("/")
	public List<TypeFiliereVo> findAll(){
		return typeFiliereConverter.toVo(typeFiliereService.findAll());
	}
    
	@ApiOperation("Finds a  typeFiliere by libelle")
    @GetMapping("/libelle/{libelle}")
	public TypeFiliereVo findByLibelle(@PathVariable String libelle){
		return  typeFiliereConverter.toVo(typeFiliereService.findByLibelle(libelle));
	}
	@ApiOperation("Deletes a  typeFiliere by libelle")
    @DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle){
		return  typeFiliereService.deleteByLibelle(libelle);
	}


   
    @ApiOperation("Search typeFiliere by a specific criterion")
    @PostMapping("/search")
	public List<TypeFiliereVo> findByCriteria(@RequestBody TypeFiliereVo typeFiliereVo){
       return typeFiliereConverter.toVo(typeFiliereService.findByCriteria(typeFiliereVo));
	}	
	public TypeFiliereConverter getTypeFiliereConverter(){
		return typeFiliereConverter;
	}
 
	public void setTypeFiliereConverter(TypeFiliereConverter typeFiliereConverter){
		this.typeFiliereConverter=typeFiliereConverter;
	}

	public TypeFiliereService getTypeFiliereService(){
		return typeFiliereService;
	}
	public void setTypeFiliereService( TypeFiliereService typeFiliereService){
	 	this.typeFiliereService=typeFiliereService;
	}
	

}