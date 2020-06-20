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
import ma.zs.generated.bean.TypeDocument; 
import ma.zs.generated.service.facade.TypeDocumentService;
import ma.zs.generated.ws.rest.provided.converter.TypeDocumentConverter;
import ma.zs.generated.ws.rest.provided.vo.TypeDocumentVo;

@Api("Manages typeDocument services")
@RestController
@RequestMapping("generated/typeDocument")
public class TypeDocumentRest {

	@Autowired 
	private TypeDocumentService typeDocumentService;
	
	@Autowired 
	private TypeDocumentConverter typeDocumentConverter ;

    @ApiOperation("Saves the specified typeDocument")
	@PostMapping("/")
	public TypeDocumentVo save(@RequestBody TypeDocumentVo typeDocumentVo){
		TypeDocument typeDocument= typeDocumentConverter.toItem(typeDocumentVo);
	  typeDocument=	typeDocumentService.save(typeDocument);
		return typeDocumentConverter.toVo(typeDocument);
	}

    @ApiOperation("Delete the specified typeDocument")
	@DeleteMapping("/")
	public int delete(@RequestBody TypeDocumentVo typeDocumentVo){
		TypeDocument typeDocument = typeDocumentConverter.toItem(typeDocumentVo);
		return typeDocumentService.delete(typeDocument);
	}

	@ApiOperation("Updates the specified typeDocument")
	@PutMapping("/")
	public TypeDocumentVo update(@RequestBody TypeDocumentVo typeDocumentVo){
		TypeDocument typeDocument= typeDocumentConverter.toItem(typeDocumentVo);
	  typeDocument=	typeDocumentService.update(typeDocument);
		return typeDocumentConverter.toVo(typeDocument);
	}

	@ApiOperation("Finds a list of all typeDocuments")
	@GetMapping("/")
	public List<TypeDocumentVo> findAll(){
		return typeDocumentConverter.toVo(typeDocumentService.findAll());
	}
    
	@ApiOperation("Finds a  typeDocument by libelle")
    @GetMapping("/libelle/{libelle}")
	public TypeDocumentVo findByLibelle(@PathVariable String libelle){
		return  typeDocumentConverter.toVo(typeDocumentService.findByLibelle(libelle));
	}
	@ApiOperation("Deletes a  typeDocument by libelle")
    @DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle){
		return  typeDocumentService.deleteByLibelle(libelle);
	}


   
    @ApiOperation("Search typeDocument by a specific criterion")
    @PostMapping("/search")
	public List<TypeDocumentVo> findByCriteria(@RequestBody TypeDocumentVo typeDocumentVo){
       return typeDocumentConverter.toVo(typeDocumentService.findByCriteria(typeDocumentVo));
	}	
	public TypeDocumentConverter getTypeDocumentConverter(){
		return typeDocumentConverter;
	}
 
	public void setTypeDocumentConverter(TypeDocumentConverter typeDocumentConverter){
		this.typeDocumentConverter=typeDocumentConverter;
	}

	public TypeDocumentService getTypeDocumentService(){
		return typeDocumentService;
	}
	public void setTypeDocumentService( TypeDocumentService typeDocumentService){
	 	this.typeDocumentService=typeDocumentService;
	}
	

}