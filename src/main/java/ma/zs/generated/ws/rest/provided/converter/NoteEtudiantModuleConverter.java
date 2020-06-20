package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

import ma.zs.generated.bean.NoteEtudiantModule; 
import ma.zs.generated.ws.rest.provided.vo.NoteEtudiantModuleVo;

@Component 
public class NoteEtudiantModuleConverter extends AbstractConverter<NoteEtudiantModule,NoteEtudiantModuleVo>{ 
    @Autowired
	private NoteEtudiantConverter noteEtudiantConverter ;
    private boolean  noteEtudiant;
    @Autowired
	private ResultatConverter resultatConverter ;
    private boolean  resultat;
    @Autowired
	private ModuleConverter moduleConverter ;
    private boolean  module;

	public  NoteEtudiantModuleConverter(){
		init(true);
	}

	@Override 
 	public NoteEtudiantModule toItem(NoteEtudiantModuleVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	NoteEtudiantModule item = new NoteEtudiantModule();
			 if(StringUtil.isNotEmpty(vo.getPtsJury()))
                  item.setPtsJury(vo.getPtsJury());
			 if(StringUtil.isNotEmpty(vo.getNote()))
                  item.setNote(NumberUtil.toDouble(vo.getNote()));
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
             if(vo.getNoteEtudiantVo()!=null && this.noteEtudiant)
	              item.setNoteEtudiant(noteEtudiantConverter.toItem(vo.getNoteEtudiantVo())) ;
             if(vo.getResultatVo()!=null && this.resultat)
	              item.setResultat(resultatConverter.toItem(vo.getResultatVo())) ;
             if(vo.getModuleVo()!=null && this.module)
	              item.setModule(moduleConverter.toItem(vo.getModuleVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public NoteEtudiantModuleVo toVo(NoteEtudiantModule item) {
 		if (item == null) {
    		return null;
      	} else {
			NoteEtudiantModuleVo vo = new NoteEtudiantModuleVo();

			if(StringUtil.isNotEmpty(item.getPtsJury()))
				vo.setPtsJury(item.getPtsJury());
			
			 if(item.getNote()!=null)
				vo.setNote(NumberUtil.toString(item.getNote()));
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
            if(item.getNoteEtudiant()!=null && this.noteEtudiant) {
				    noteEtudiantConverter.init(false);
				   vo.setNoteEtudiantVo(noteEtudiantConverter.toVo(item.getNoteEtudiant())) ;
			        noteEtudiantConverter.init(true);
			   } 
            if(item.getResultat()!=null && this.resultat) {
				    resultatConverter.init(false);
				   vo.setResultatVo(resultatConverter.toVo(item.getResultat())) ;
			        resultatConverter.init(true);
			   } 
            if(item.getModule()!=null && this.module) {
				    moduleConverter.init(false);
				   vo.setModuleVo(moduleConverter.toVo(item.getModule())) ;
			        moduleConverter.init(true);
			   } 

 			return vo;
 
 		}
 	}
	public void init(boolean value) { 
       noteEtudiant = value;
       resultat = value;
       module = value;
	}


	public NoteEtudiantConverter getNoteEtudiantConverter(){
		return this.noteEtudiantConverter;
	}  
    public void setNoteEtudiantConverter(NoteEtudiantConverter noteEtudiantConverter ){
		 this.noteEtudiantConverter = noteEtudiantConverter;
	}  
	 public boolean  isNoteEtudiant(){
		  return this.noteEtudiant;
	 }
	 public void  setNoteEtudiant(boolean noteEtudiant){
		   this.noteEtudiant = noteEtudiant;
	 }

	public ResultatConverter getResultatConverter(){
		return this.resultatConverter;
	}  
    public void setResultatConverter(ResultatConverter resultatConverter ){
		 this.resultatConverter = resultatConverter;
	}  
	 public boolean  isResultat(){
		  return this.resultat;
	 }
	 public void  setResultat(boolean resultat){
		   this.resultat = resultat;
	 }

	public ModuleConverter getModuleConverter(){
		return this.moduleConverter;
	}  
    public void setModuleConverter(ModuleConverter moduleConverter ){
		 this.moduleConverter = moduleConverter;
	}  
	 public boolean  isModule(){
		  return this.module;
	 }
	 public void  setModule(boolean module){
		   this.module = module;
	 }
} 
