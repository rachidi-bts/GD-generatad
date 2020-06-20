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
import ma.zs.generated.bean.Module; 
import ma.zs.generated.service.facade.ModuleService;
import ma.zs.generated.ws.rest.provided.converter.ModuleConverter;
import ma.zs.generated.ws.rest.provided.vo.ModuleVo;

@Api("Manages module services")
@RestController
@RequestMapping("generated/module")
public class ModuleRest {

	@Autowired 
	private ModuleService moduleService;
	
	@Autowired 
	private ModuleConverter moduleConverter ;

    @ApiOperation("Saves the specified module")
	@PostMapping("/")
	public ModuleVo save(@RequestBody ModuleVo moduleVo){
		Module module= moduleConverter.toItem(moduleVo);
	  module=	moduleService.save(module);
		return moduleConverter.toVo(module);
	}

    @ApiOperation("Delete the specified module")
	@DeleteMapping("/")
	public int delete(@RequestBody ModuleVo moduleVo){
		Module module = moduleConverter.toItem(moduleVo);
		return moduleService.delete(module);
	}

	@ApiOperation("Updates the specified module")
	@PutMapping("/")
	public ModuleVo update(@RequestBody ModuleVo moduleVo){
		Module module= moduleConverter.toItem(moduleVo);
	  module=	moduleService.update(module);
		return moduleConverter.toVo(module);
	}

	@ApiOperation("Finds a list of all modules")
	@GetMapping("/")
	public List<ModuleVo> findAll(){
		return moduleConverter.toVo(moduleService.findAll());
	}
    
	@ApiOperation("Finds a  module by libelle")
    @GetMapping("/libelle/{libelle}")
	public ModuleVo findByLibelle(@PathVariable String libelle){
		return  moduleConverter.toVo(moduleService.findByLibelle(libelle));
	}
	@ApiOperation("Deletes a  module by libelle")
    @DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle){
		return  moduleService.deleteByLibelle(libelle);
	}


   
    @ApiOperation("Search module by a specific criterion")
    @PostMapping("/search")
	public List<ModuleVo> findByCriteria(@RequestBody ModuleVo moduleVo){
       return moduleConverter.toVo(moduleService.findByCriteria(moduleVo));
	}	
	public ModuleConverter getModuleConverter(){
		return moduleConverter;
	}
 
	public void setModuleConverter(ModuleConverter moduleConverter){
		this.moduleConverter=moduleConverter;
	}

	public ModuleService getModuleService(){
		return moduleService;
	}
	public void setModuleService( ModuleService moduleService){
	 	this.moduleService=moduleService;
	}
	

}