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
import ma.zs.generated.bean.Semestre; 
import ma.zs.generated.service.facade.SemestreService;
import ma.zs.generated.ws.rest.provided.converter.SemestreConverter;
import ma.zs.generated.ws.rest.provided.vo.SemestreVo;

@Api("Manages semestre services")
@RestController
@RequestMapping("generated/semestre")
public class SemestreRest {

	@Autowired 
	private SemestreService semestreService;
	
	@Autowired 
	private SemestreConverter semestreConverter ;

    @ApiOperation("Saves the specified semestre")
	@PostMapping("/")
	public SemestreVo save(@RequestBody SemestreVo semestreVo){
		Semestre semestre= semestreConverter.toItem(semestreVo);
	  semestre=	semestreService.save(semestre);
		return semestreConverter.toVo(semestre);
	}
    

    @ApiOperation("Delete the specified semestre")
	@DeleteMapping("/")
	public int delete(@RequestBody SemestreVo semestreVo){
		Semestre semestre = semestreConverter.toItem(semestreVo);
		return semestreService.delete(semestre);
	}

	@ApiOperation("Updates the specified semestre")
	@PutMapping("/")
	public SemestreVo update(@RequestBody SemestreVo semestreVo){
		Semestre semestre= semestreConverter.toItem(semestreVo);
	  semestre=	semestreService.update(semestre);
		return semestreConverter.toVo(semestre);
	}

	@ApiOperation("Finds a list of all semestres")
	@GetMapping("/")
	public List<SemestreVo> findAll(){
		return semestreConverter.toVo(semestreService.findAll());
	}
    
	@ApiOperation("Finds a  semestre by libelle")
    @GetMapping("/libellee/{libellee}")
	public SemestreVo findByLibellee(@PathVariable String libellee){
		return  semestreConverter.toVo(semestreService.findByLibellee(libellee));
	}
	@ApiOperation("Deletes a  semestre by libelle")
    @DeleteMapping("/libellee/{libellee}")
	public int deleteByLibellee(@PathVariable String libellee){
		return  semestreService.deleteByLibellee(libellee);
	}


   
    @ApiOperation("Search semestre by a specific criterion")
    @PostMapping("/search")
	public List<SemestreVo> findByCriteria(@RequestBody SemestreVo semestreVo){
       return semestreConverter.toVo(semestreService.findByCriteria(semestreVo));
	}	
	public SemestreConverter getSemestreConverter(){
		return semestreConverter;
	}
 
	public void setSemestreConverter(SemestreConverter semestreConverter){
		this.semestreConverter=semestreConverter;
	}

	public SemestreService getSemestreService(){
		return semestreService;
	}
	public void setSemestreService( SemestreService semestreService){
	 	this.semestreService=semestreService;
	}
	

}