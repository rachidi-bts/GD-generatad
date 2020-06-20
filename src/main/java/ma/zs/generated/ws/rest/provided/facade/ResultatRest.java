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
import ma.zs.generated.bean.Resultat; 
import ma.zs.generated.service.facade.ResultatService;
import ma.zs.generated.ws.rest.provided.converter.ResultatConverter;
import ma.zs.generated.ws.rest.provided.vo.ResultatVo;

@Api("Manages resultat services")
@RestController
@RequestMapping("generated/resultat")
public class ResultatRest {

	@Autowired 
	private ResultatService resultatService;
	
	@Autowired 
	private ResultatConverter resultatConverter ;

    @ApiOperation("Saves the specified resultat")
	@PostMapping("/")
	public ResultatVo save(@RequestBody ResultatVo resultatVo){
		Resultat resultat= resultatConverter.toItem(resultatVo);
	  resultat=	resultatService.save(resultat);
		return resultatConverter.toVo(resultat);
	}

    @ApiOperation("Delete the specified resultat")
	@DeleteMapping("/")
	public int delete(@RequestBody ResultatVo resultatVo){
		Resultat resultat = resultatConverter.toItem(resultatVo);
		return resultatService.delete(resultat);
	}

	@ApiOperation("Updates the specified resultat")
	@PutMapping("/")
	public ResultatVo update(@RequestBody ResultatVo resultatVo){
		Resultat resultat= resultatConverter.toItem(resultatVo);
	  resultat=	resultatService.update(resultat);
		return resultatConverter.toVo(resultat);
	}

	@ApiOperation("Finds a list of all resultats")
	@GetMapping("/")
	public List<ResultatVo> findAll(){
		return resultatConverter.toVo(resultatService.findAll());
	}
    
	@ApiOperation("Finds a  resultat by libelle")
    @GetMapping("/libelle/{libelle}")
	public ResultatVo findByLibelle(@PathVariable String libelle){
		return  resultatConverter.toVo(resultatService.findByLibelle(libelle));
	}
	@ApiOperation("Deletes a  resultat by libelle")
    @DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle){
		return  resultatService.deleteByLibelle(libelle);
	}


   
    @ApiOperation("Search resultat by a specific criterion")
    @PostMapping("/search")
	public List<ResultatVo> findByCriteria(@RequestBody ResultatVo resultatVo){
       return resultatConverter.toVo(resultatService.findByCriteria(resultatVo));
	}	
	public ResultatConverter getResultatConverter(){
		return resultatConverter;
	}
 
	public void setResultatConverter(ResultatConverter resultatConverter){
		this.resultatConverter=resultatConverter;
	}

	public ResultatService getResultatService(){
		return resultatService;
	}
	public void setResultatService( ResultatService resultatService){
	 	this.resultatService=resultatService;
	}
	

}