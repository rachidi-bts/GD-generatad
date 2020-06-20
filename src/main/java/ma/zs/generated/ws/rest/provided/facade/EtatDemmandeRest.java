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
import ma.zs.generated.bean.EtatDemmande; 
import ma.zs.generated.service.facade.EtatDemmandeService;
import ma.zs.generated.ws.rest.provided.converter.EtatDemmandeConverter;
import ma.zs.generated.ws.rest.provided.vo.EtatDemmandeVo;

@Api("Manages etatDemmande services")
@RestController
@RequestMapping("generated/etatDemmande")
public class EtatDemmandeRest {

	@Autowired 
	private EtatDemmandeService etatDemmandeService;
	
	@Autowired 
	private EtatDemmandeConverter etatDemmandeConverter ;

    @ApiOperation("Saves the specified etatDemmande")
	@PostMapping("/")
	public EtatDemmandeVo save(@RequestBody EtatDemmandeVo etatDemmandeVo){
		EtatDemmande etatDemmande= etatDemmandeConverter.toItem(etatDemmandeVo);
	  etatDemmande=	etatDemmandeService.save(etatDemmande);
		return etatDemmandeConverter.toVo(etatDemmande);
	}

    @ApiOperation("Delete the specified etatDemmande")
	@DeleteMapping("/")
	public int delete(@RequestBody EtatDemmandeVo etatDemmandeVo){
		EtatDemmande etatDemmande = etatDemmandeConverter.toItem(etatDemmandeVo);
		return etatDemmandeService.delete(etatDemmande);
	}

	@ApiOperation("Updates the specified etatDemmande")
	@PutMapping("/")
	public EtatDemmandeVo update(@RequestBody EtatDemmandeVo etatDemmandeVo){
		EtatDemmande etatDemmande= etatDemmandeConverter.toItem(etatDemmandeVo);
	  etatDemmande=	etatDemmandeService.update(etatDemmande);
		return etatDemmandeConverter.toVo(etatDemmande);
	}

	@ApiOperation("Finds a list of all etatDemmandes")
	@GetMapping("/")
	public List<EtatDemmandeVo> findAll(){
		return etatDemmandeConverter.toVo(etatDemmandeService.findAll());
	}
    
	@ApiOperation("Finds a  etatDemmande by libelle")
    @GetMapping("/libelle/{libelle}")
	public EtatDemmandeVo findByLibelle(@PathVariable String libelle){
		return  etatDemmandeConverter.toVo(etatDemmandeService.findByLibelle(libelle));
	}
	@ApiOperation("Deletes a  etatDemmande by libelle")
    @DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle){
		return  etatDemmandeService.deleteByLibelle(libelle);
	}


   
    @ApiOperation("Search etatDemmande by a specific criterion")
    @PostMapping("/search")
	public List<EtatDemmandeVo> findByCriteria(@RequestBody EtatDemmandeVo etatDemmandeVo){
       return etatDemmandeConverter.toVo(etatDemmandeService.findByCriteria(etatDemmandeVo));
	}	
	public EtatDemmandeConverter getEtatDemmandeConverter(){
		return etatDemmandeConverter;
	}
 
	public void setEtatDemmandeConverter(EtatDemmandeConverter etatDemmandeConverter){
		this.etatDemmandeConverter=etatDemmandeConverter;
	}

	public EtatDemmandeService getEtatDemmandeService(){
		return etatDemmandeService;
	}
	public void setEtatDemmandeService( EtatDemmandeService etatDemmandeService){
	 	this.etatDemmandeService=etatDemmandeService;
	}
	

}