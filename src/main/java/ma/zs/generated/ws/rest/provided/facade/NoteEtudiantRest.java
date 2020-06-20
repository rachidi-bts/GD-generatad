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
import ma.zs.generated.bean.NoteEtudiant; 
import ma.zs.generated.service.facade.NoteEtudiantService;
import ma.zs.generated.ws.rest.provided.converter.NoteEtudiantConverter;
import ma.zs.generated.ws.rest.provided.vo.NoteEtudiantVo;

@Api("Manages noteEtudiant services")
@RestController
@RequestMapping("generated/noteEtudiant")
public class NoteEtudiantRest {

	@Autowired 
	private NoteEtudiantService noteEtudiantService;
	
	@Autowired 
	private NoteEtudiantConverter noteEtudiantConverter ;

    @ApiOperation("Saves the specified noteEtudiant")
	@PostMapping("/")
	public NoteEtudiantVo save(@RequestBody NoteEtudiantVo noteEtudiantVo){
		NoteEtudiant noteEtudiant= noteEtudiantConverter.toItem(noteEtudiantVo);
	  noteEtudiant=	noteEtudiantService.save(noteEtudiant);
		return noteEtudiantConverter.toVo(noteEtudiant);
	}

    @ApiOperation("Delete the specified noteEtudiant")
	@DeleteMapping("/")
	public int delete(@RequestBody NoteEtudiantVo noteEtudiantVo){
		NoteEtudiant noteEtudiant = noteEtudiantConverter.toItem(noteEtudiantVo);
		return noteEtudiantService.delete(noteEtudiant);
	}

	@ApiOperation("Updates the specified noteEtudiant")
	@PutMapping("/")
	public NoteEtudiantVo update(@RequestBody NoteEtudiantVo noteEtudiantVo){
		NoteEtudiant noteEtudiant= noteEtudiantConverter.toItem(noteEtudiantVo);
	  noteEtudiant=	noteEtudiantService.update(noteEtudiant);
		return noteEtudiantConverter.toVo(noteEtudiant);
	}

	@ApiOperation("Finds a list of all noteEtudiants")
	@GetMapping("/")
	public List<NoteEtudiantVo> findAll(){
		return noteEtudiantConverter.toVo(noteEtudiantService.findAll());
	}
    
	@ApiOperation("Finds a noteEtudiant by id")
	@GetMapping("/id/{id}")
	public NoteEtudiantVo findById(@PathVariable Long id){
		return  noteEtudiantConverter.toVo(noteEtudiantService.findById(id));
	}
	

    @ApiOperation("Finds a noteEtudiant by libelle of resultatFinal")
	@GetMapping("/resultatFinal/libelle/{libelle}")
	public List<NoteEtudiantVo> findByResultatFinalLibelle(@PathVariable String libelle){
		return noteEtudiantConverter.toVo(noteEtudiantService.findByResultatFinalLibelle(libelle));
	}
	
	@ApiOperation("Deletes a noteEtudiant by libelle of resultatFinal")
	@DeleteMapping("/resultatFinal/libelle/{libelle}")
	public int deleteByResultatFinalLibelle(@PathVariable String libelle){
		return noteEtudiantService.deleteByResultatFinalLibelle(libelle);
	}
	
	@ApiOperation("Finds noteEtudiant by id of resultatFinal")
	@GetMapping("/resultatFinal/id/{id}")
	public List<NoteEtudiantVo> findByResultatFinalId(@PathVariable Long id){
		return noteEtudiantConverter.toVo(noteEtudiantService.findByResultatFinalId(id));
	}
	@ApiOperation("Deletes noteEtudiant by id of resultatFinal")
	@DeleteMapping("/resultatFinal/id/{id}")
	public int deleteByResultatFinalId(@PathVariable Long id){
		return noteEtudiantService.deleteByResultatFinalId(id);
	}
     	
    @ApiOperation("Finds a noteEtudiant by cne of demmandeur")
	@GetMapping("/demmandeur/cne/{cne}")
	public List<NoteEtudiantVo> findByDemmandeurCne(@PathVariable String cne){
		return noteEtudiantConverter.toVo(noteEtudiantService.findByDemmandeurCne(cne));
	}
	
	@ApiOperation("Deletes a noteEtudiant by cne of demmandeur")
	@DeleteMapping("/demmandeur/cne/{cne}")
	public int deleteByDemmandeurCne(@PathVariable String cne){
		return noteEtudiantService.deleteByDemmandeurCne(cne);
	}
	
	@ApiOperation("Finds noteEtudiant by id of demmandeur")
	@GetMapping("/demmandeur/id/{id}")
	public List<NoteEtudiantVo> findByDemmandeurId(@PathVariable Long id){
		return noteEtudiantConverter.toVo(noteEtudiantService.findByDemmandeurId(id));
	}
	@ApiOperation("Deletes noteEtudiant by id of demmandeur")
	@DeleteMapping("/demmandeur/id/{id}")
	public int deleteByDemmandeurId(@PathVariable Long id){
		return noteEtudiantService.deleteByDemmandeurId(id);
	}
     	
   
    @ApiOperation("Search noteEtudiant by a specific criterion")
    @PostMapping("/search")
	public List<NoteEtudiantVo> findByCriteria(@RequestBody NoteEtudiantVo noteEtudiantVo){
       return noteEtudiantConverter.toVo(noteEtudiantService.findByCriteria(noteEtudiantVo));
	}	
	public NoteEtudiantConverter getNoteEtudiantConverter(){
		return noteEtudiantConverter;
	}
 
	public void setNoteEtudiantConverter(NoteEtudiantConverter noteEtudiantConverter){
		this.noteEtudiantConverter=noteEtudiantConverter;
	}

	public NoteEtudiantService getNoteEtudiantService(){
		return noteEtudiantService;
	}
	public void setNoteEtudiantService( NoteEtudiantService noteEtudiantService){
	 	this.noteEtudiantService=noteEtudiantService;
	}
	

}