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
import ma.zs.generated.bean.NoteEtudiantModule; 
import ma.zs.generated.service.facade.NoteEtudiantModuleService;
import ma.zs.generated.ws.rest.provided.converter.NoteEtudiantModuleConverter;
import ma.zs.generated.ws.rest.provided.vo.NoteEtudiantModuleVo;

@Api("Manages noteEtudiantModule services")
@RestController
@RequestMapping("generated/noteEtudiantModule")
public class NoteEtudiantModuleRest {

	@Autowired 
	private NoteEtudiantModuleService noteEtudiantModuleService;
	
	@Autowired 
	private NoteEtudiantModuleConverter noteEtudiantModuleConverter ;

    @ApiOperation("Saves the specified noteEtudiantModule")
	@PostMapping("/")
	public NoteEtudiantModuleVo save(@RequestBody NoteEtudiantModuleVo noteEtudiantModuleVo){
		NoteEtudiantModule noteEtudiantModule= noteEtudiantModuleConverter.toItem(noteEtudiantModuleVo);
	  noteEtudiantModule=	noteEtudiantModuleService.save(noteEtudiantModule);
		return noteEtudiantModuleConverter.toVo(noteEtudiantModule);
	}

    @ApiOperation("Delete the specified noteEtudiantModule")
	@DeleteMapping("/")
	public int delete(@RequestBody NoteEtudiantModuleVo noteEtudiantModuleVo){
		NoteEtudiantModule noteEtudiantModule = noteEtudiantModuleConverter.toItem(noteEtudiantModuleVo);
		return noteEtudiantModuleService.delete(noteEtudiantModule);
	}

	@ApiOperation("Updates the specified noteEtudiantModule")
	@PutMapping("/")
	public NoteEtudiantModuleVo update(@RequestBody NoteEtudiantModuleVo noteEtudiantModuleVo){
		NoteEtudiantModule noteEtudiantModule= noteEtudiantModuleConverter.toItem(noteEtudiantModuleVo);
	  noteEtudiantModule=	noteEtudiantModuleService.update(noteEtudiantModule);
		return noteEtudiantModuleConverter.toVo(noteEtudiantModule);
	}

	@ApiOperation("Finds a list of all noteEtudiantModules")
	@GetMapping("/")
	public List<NoteEtudiantModuleVo> findAll(){
		return noteEtudiantModuleConverter.toVo(noteEtudiantModuleService.findAll());
	}
    
	@ApiOperation("Finds a noteEtudiantModule by id")
	@GetMapping("/id/{id}")
	public NoteEtudiantModuleVo findById(@PathVariable Long id){
		return  noteEtudiantModuleConverter.toVo(noteEtudiantModuleService.findById(id));
	}
	


	
	@ApiOperation("Finds noteEtudiantModule by id of noteEtudiant")
	@GetMapping("/noteEtudiant/id/{id}")
	public List<NoteEtudiantModuleVo> findByNoteEtudiantId(@PathVariable Long id){
		return noteEtudiantModuleConverter.toVo(noteEtudiantModuleService.findByNoteEtudiantId(id));
	}
	@ApiOperation("Deletes noteEtudiantModule by id of noteEtudiant")
	@DeleteMapping("/noteEtudiant/id/{id}")
	public int deleteByNoteEtudiantId(@PathVariable Long id){
		return noteEtudiantModuleService.deleteByNoteEtudiantId(id);
	}
     	
    @ApiOperation("Finds a noteEtudiantModule by libelle of resultat")
	@GetMapping("/resultat/libelle/{libelle}")
	public List<NoteEtudiantModuleVo> findByResultatLibelle(@PathVariable String libelle){
		return noteEtudiantModuleConverter.toVo(noteEtudiantModuleService.findByResultatLibelle(libelle));
	}
	
	@ApiOperation("Deletes a noteEtudiantModule by libelle of resultat")
	@DeleteMapping("/resultat/libelle/{libelle}")
	public int deleteByResultatLibelle(@PathVariable String libelle){
		return noteEtudiantModuleService.deleteByResultatLibelle(libelle);
	}
	
	@ApiOperation("Finds noteEtudiantModule by id of resultat")
	@GetMapping("/resultat/id/{id}")
	public List<NoteEtudiantModuleVo> findByResultatId(@PathVariable Long id){
		return noteEtudiantModuleConverter.toVo(noteEtudiantModuleService.findByResultatId(id));
	}
	@ApiOperation("Deletes noteEtudiantModule by id of resultat")
	@DeleteMapping("/resultat/id/{id}")
	public int deleteByResultatId(@PathVariable Long id){
		return noteEtudiantModuleService.deleteByResultatId(id);
	}
     	
    @ApiOperation("Finds a noteEtudiantModule by libelle of module")
	@GetMapping("/module/libelle/{libelle}")
	public List<NoteEtudiantModuleVo> findByModuleLibelle(@PathVariable String libelle){
		return noteEtudiantModuleConverter.toVo(noteEtudiantModuleService.findByModuleLibelle(libelle));
	}
	
	@ApiOperation("Deletes a noteEtudiantModule by libelle of module")
	@DeleteMapping("/module/libelle/{libelle}")
	public int deleteByModuleLibelle(@PathVariable String libelle){
		return noteEtudiantModuleService.deleteByModuleLibelle(libelle);
	}
	
	@ApiOperation("Finds noteEtudiantModule by id of module")
	@GetMapping("/module/id/{id}")
	public List<NoteEtudiantModuleVo> findByModuleId(@PathVariable Long id){
		return noteEtudiantModuleConverter.toVo(noteEtudiantModuleService.findByModuleId(id));
	}
	@ApiOperation("Deletes noteEtudiantModule by id of module")
	@DeleteMapping("/module/id/{id}")
	public int deleteByModuleId(@PathVariable Long id){
		return noteEtudiantModuleService.deleteByModuleId(id);
	}
     	
   
    @ApiOperation("Search noteEtudiantModule by a specific criterion")
    @PostMapping("/search")
	public List<NoteEtudiantModuleVo> findByCriteria(@RequestBody NoteEtudiantModuleVo noteEtudiantModuleVo){
       return noteEtudiantModuleConverter.toVo(noteEtudiantModuleService.findByCriteria(noteEtudiantModuleVo));
	}	
	public NoteEtudiantModuleConverter getNoteEtudiantModuleConverter(){
		return noteEtudiantModuleConverter;
	}
 
	public void setNoteEtudiantModuleConverter(NoteEtudiantModuleConverter noteEtudiantModuleConverter){
		this.noteEtudiantModuleConverter=noteEtudiantModuleConverter;
	}

	public NoteEtudiantModuleService getNoteEtudiantModuleService(){
		return noteEtudiantModuleService;
	}
	public void setNoteEtudiantModuleService( NoteEtudiantModuleService noteEtudiantModuleService){
	 	this.noteEtudiantModuleService=noteEtudiantModuleService;
	}
	

}