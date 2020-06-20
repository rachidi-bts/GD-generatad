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
import ma.zs.generated.bean.Responsable; 
import ma.zs.generated.service.facade.ResponsableService;
import ma.zs.generated.ws.rest.provided.converter.ResponsableConverter;
import ma.zs.generated.ws.rest.provided.vo.ResponsableVo;

@Api("Manages responsable services")
@RestController
@RequestMapping("generated/responsable")
public class ResponsableRest {

	@Autowired 
	private ResponsableService responsableService;
	
	@Autowired 
	private ResponsableConverter responsableConverter ;

    @ApiOperation("Saves the specified responsable")
	@PostMapping("/")
	public ResponsableVo save(@RequestBody ResponsableVo responsableVo){
		Responsable responsable= responsableConverter.toItem(responsableVo);
	  responsable=	responsableService.save(responsable);
		return responsableConverter.toVo(responsable);
	}

    @ApiOperation("Delete the specified responsable")
	@DeleteMapping("/")
	public int delete(@RequestBody ResponsableVo responsableVo){
		Responsable responsable = responsableConverter.toItem(responsableVo);
		return responsableService.delete(responsable);
	}

	@ApiOperation("Updates the specified responsable")
	@PutMapping("/")
	public ResponsableVo update(@RequestBody ResponsableVo responsableVo){
		Responsable responsable= responsableConverter.toItem(responsableVo);
	  responsable=	responsableService.update(responsable);
		return responsableConverter.toVo(responsable);
	}

	@ApiOperation("Finds a list of all responsables")
	@GetMapping("/")
	public List<ResponsableVo> findAll(){
		return responsableConverter.toVo(responsableService.findAll());
	}
    
	@ApiOperation("Finds a  responsable by login")
    @GetMapping("/login/{login}")
	public ResponsableVo findByLogin(@PathVariable String login){
		return  responsableConverter.toVo(responsableService.findByLogin(login));
	}
	@ApiOperation("Deletes a  responsable by login")
    @DeleteMapping("/login/{login}")
	public int deleteByLogin(@PathVariable String login){
		return  responsableService.deleteByLogin(login);
	}


    @ApiOperation("Finds a responsable by libelle of typeFiliere")
	@GetMapping("/typeFiliere/libelle/{libelle}")
	public List<ResponsableVo> findByTypeFiliereLibelle(@PathVariable String libelle){
		return responsableConverter.toVo(responsableService.findByTypeFiliereLibelle(libelle));
	}
	
	@ApiOperation("Deletes a responsable by libelle of typeFiliere")
	@DeleteMapping("/typeFiliere/libelle/{libelle}")
	public int deleteByTypeFiliereLibelle(@PathVariable String libelle){
		return responsableService.deleteByTypeFiliereLibelle(libelle);
	}
	
	@ApiOperation("Finds responsable by id of typeFiliere")
	@GetMapping("/typeFiliere/id/{id}")
	public List<ResponsableVo> findByTypeFiliereId(@PathVariable Long id){
		return responsableConverter.toVo(responsableService.findByTypeFiliereId(id));
	}
	@ApiOperation("Deletes responsable by id of typeFiliere")
	@DeleteMapping("/typeFiliere/id/{id}")
	public int deleteByTypeFiliereId(@PathVariable Long id){
		return responsableService.deleteByTypeFiliereId(id);
	}
     	
   
    @ApiOperation("Search responsable by a specific criterion")
    @PostMapping("/search")
	public List<ResponsableVo> findByCriteria(@RequestBody ResponsableVo responsableVo){
       return responsableConverter.toVo(responsableService.findByCriteria(responsableVo));
	}	
	public ResponsableConverter getResponsableConverter(){
		return responsableConverter;
	}
 
	public void setResponsableConverter(ResponsableConverter responsableConverter){
		this.responsableConverter=responsableConverter;
	}

	public ResponsableService getResponsableService(){
		return responsableService;
	}
	public void setResponsableService( ResponsableService responsableService){
	 	this.responsableService=responsableService;
	}
	

}