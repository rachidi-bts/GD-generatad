package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

import ma.zs.generated.bean.NoteEtudiant; 
import ma.zs.generated.ws.rest.provided.vo.NoteEtudiantVo;

@Component 
public class NoteEtudiantConverter extends AbstractConverter<NoteEtudiant,NoteEtudiantVo>{ 
    @Autowired
	private ResultatConverter resultatConverter ;
    private boolean  resultatFinal;
    @Autowired
	private DemmandeurConverter demmandeurConverter ;
    private boolean  demmandeur;
	    @Autowired
		private NoteEtudiantModuleConverter noteEtudiantModuleConverter ;
    private boolean noteEtudiantModules;
    @Autowired
    private SemestreConverter semestreConverter;
    private boolean semestre;

	public  NoteEtudiantConverter(){
		init(true);
	}

	@Override 
 	public NoteEtudiant toItem(NoteEtudiantVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	NoteEtudiant item = new NoteEtudiant();
			 if(StringUtil.isNotEmpty(vo.getNoteFinale()))
                  item.setNoteFinale(NumberUtil.toDouble(vo.getNoteFinale()));
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
             if(vo.getResultatFinalVo()!=null && this.resultatFinal)
	              item.setResultatFinal(resultatConverter.toItem(vo.getResultatFinalVo())) ;
             if(vo.getDemmandeurVo()!=null && this.demmandeur)
	              item.setDemmandeur(demmandeurConverter.toItem(vo.getDemmandeurVo())) ;

             if(vo.getSemestreVo()!=null && this.semestre)
	              item.setSemestre(semestreConverter.toItem(vo.getSemestreVo())) ;
             
	         if(ListUtil.isNotEmpty(vo.getNoteEtudiantModulesVo()) && this.noteEtudiantModules)
                  item.setNoteEtudiantModules(noteEtudiantModuleConverter.toItem(vo.getNoteEtudiantModulesVo()));

		return item;
 		}
 	}

 	 @Override 
 	public NoteEtudiantVo toVo(NoteEtudiant item) {
 		if (item == null) {
    		return null;
      	} else {
			NoteEtudiantVo vo = new NoteEtudiantVo();

			 if(item.getNoteFinale()!=null)
				vo.setNoteFinale(NumberUtil.toString(item.getNoteFinale()));
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
            if(item.getResultatFinal()!=null && this.resultatFinal) {
				  //  resultatConverter.init(false);
				   vo.setResultatFinalVo(resultatConverter.toVo(item.getResultatFinal())) ;
			       // resultatConverter.init(true);
			   } 
            if(item.getDemmandeur()!=null && this.demmandeur) {
				   // demmandeurConverter.init(false);
				   vo.setDemmandeurVo(demmandeurConverter.toVo(item.getDemmandeur())) ;
			       // demmandeurConverter.init(true);
			   } 
            
            if(item.getSemestre()!=null && this.semestre) {
				   // semestreConverter.init(false);
				   vo.setSemestreVo(semestreConverter.toVo(item.getSemestre())) ;
			       // semestreConverter.init(true);
			   } 
	         if(ListUtil.isNotEmpty(item.getNoteEtudiantModules()) && this.noteEtudiantModules){
				// noteEtudiantModuleConverter.init(false);
                vo.setNoteEtudiantModulesVo(noteEtudiantModuleConverter.toVo(item.getNoteEtudiantModules()));
              	// noteEtudiantModuleConverter.init(true);
			 }

 			return vo;
 
 		}
 	}
	public void init(boolean value) { 
       resultatFinal = value;
       demmandeur = value;
       noteEtudiantModules = value;
       semestre = value;
	}


	public ResultatConverter getResultatConverter(){
		return this.resultatConverter;
	}  
    public void setResultatConverter(ResultatConverter resultatConverter ){
		 this.resultatConverter = resultatConverter;
	}  
	 public boolean  isResultatFinal(){
		  return this.resultatFinal;
	 }
	 public void  setResultatFinal(boolean resultatFinal){
		   this.resultatFinal = resultatFinal;
	 }
	 
	 public SemestreConverter getSemestreConverter(){
			return this.semestreConverter;
		}  
	    public void setSemestreConverter(SemestreConverter semestreConverter ){
			 this.semestreConverter = semestreConverter;
		}  
		 public boolean  isSemestre(){
			  return this.semestre;
		 }
		 public void  setSemestre(boolean semestre){
			   this.semestre = semestre;
		 }

	public DemmandeurConverter getDemmandeurConverter(){
		return this.demmandeurConverter;
	}  
    public void setDemmandeurConverter(DemmandeurConverter demmandeurConverter ){
		 this.demmandeurConverter = demmandeurConverter;
	}  
	 public boolean  isDemmandeur(){
		  return this.demmandeur;
	 }
	 public void  setDemmandeur(boolean demmandeur){
		   this.demmandeur = demmandeur;
	 }
       public boolean  isNoteEtudiantModules(){
		 return this.noteEtudiantModules ;
	   }
		 public void  setNoteEtudiantModules(boolean noteEtudiantModules ){
            this.noteEtudiantModules  = noteEtudiantModules ;
		 }
} 
