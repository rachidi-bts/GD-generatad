package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

import ma.zs.generated.bean.DemmandeDocument; 
import ma.zs.generated.ws.rest.provided.vo.DemmandeDocumentVo;

@Component 
public class DemmandeDocumentConverter extends AbstractConverter<DemmandeDocument,DemmandeDocumentVo>{ 
    @Autowired
	private EtatDemmandeConverter etatDemmandeConverter ;
    private boolean  etatDemmande;
    @Autowired
	private DemmandeurConverter demmandeurConverter ;
    private boolean  demmandeur;
    @Autowired
	private TypeDocumentConverter typeDocumentConverter ;
    private boolean  typeDocument;
    @Autowired
    private SemestreConverter semestreConverter;
    private boolean semestre;

	public  DemmandeDocumentConverter(){
		init(true);
	}

	@Override 
 	public DemmandeDocument toItem(DemmandeDocumentVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	DemmandeDocument item = new DemmandeDocument();
             if(StringUtil.isNotEmpty(vo.getDateDemmande()))
			      item.setDateDemmande(DateUtil.parse(vo.getDateDemmande()));
             if(StringUtil.isNotEmpty(vo.getDateValidation()))
			      item.setDateValidation(DateUtil.parse(vo.getDateValidation()));
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
			 if(StringUtil.isNotEmpty(vo.getAnneeUniversitaire()))
			      item.setAnneeUniversitaire(NumberUtil.toLong(vo.getAnneeUniversitaire()));
             if(vo.getEtatDemmandeVo()!=null && this.etatDemmande)
	              item.setEtatDemmande(etatDemmandeConverter.toItem(vo.getEtatDemmandeVo())) ;
             if(vo.getDemmandeurVo()!=null && this.demmandeur)
	              item.setDemmandeur(demmandeurConverter.toItem(vo.getDemmandeurVo())) ;
             if(vo.getSemestreVo()!=null && this.semestre)
	              item.setSemestre(semestreConverter.toItem(vo.getSemestreVo())) ;
             if(vo.getTypeDocumentVo()!=null && this.typeDocument)
	              item.setTypeDocument(typeDocumentConverter.toItem(vo.getTypeDocumentVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public DemmandeDocumentVo toVo(DemmandeDocument item) {
 		if (item == null) {
    		return null;
      	} else {
			DemmandeDocumentVo vo = new DemmandeDocumentVo();

            if(item.getDateDemmande()!=null)
			    vo.setDateDemmande(DateUtil.formateDate(item.getDateDemmande()));	     
            if(item.getDateValidation()!=null)
			    vo.setDateValidation(DateUtil.formateDate(item.getDateValidation()));	     
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
			 if(item.getAnneeUniversitaire()!=null)
					vo.setAnneeUniversitaire(NumberUtil.toString(item.getAnneeUniversitaire()));
            if(item.getEtatDemmande()!=null && this.etatDemmande) {
            	
				   vo.setEtatDemmandeVo(etatDemmandeConverter.toVo(item.getEtatDemmande())) ;
			        
			   } 
            if(item.getDemmandeur()!=null && this.demmandeur) {

            	vo.setDemmandeurVo(demmandeurConverter.toVo(item.getDemmandeur())) ;
			       
			   } 
            if(item.getSemestre()!=null && this.semestre) {
				   
				   vo.setSemestreVo(semestreConverter.toVo(item.getSemestre())) ;
			       
			   } 
            if(item.getTypeDocument()!=null && this.typeDocument) {
				    
				   vo.setTypeDocumentVo(typeDocumentConverter.toVo(item.getTypeDocument())) ;
			        
			   } 

 			return vo;
 
 		}
 	}
	public void init(boolean value) { 
       etatDemmande = value;
       demmandeur = value;
       typeDocument = value;
       semestre = value;
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
		 
	public EtatDemmandeConverter getEtatDemmandeConverter(){
		return this.etatDemmandeConverter;
	}  
    public void setEtatDemmandeConverter(EtatDemmandeConverter etatDemmandeConverter ){
		 this.etatDemmandeConverter = etatDemmandeConverter;
	}  
	 public boolean  isEtatDemmande(){
		  return this.etatDemmande;
	 }
	 public void  setEtatDemmande(boolean etatDemmande){
		   this.etatDemmande = etatDemmande;
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

	public TypeDocumentConverter getTypeDocumentConverter(){
		return this.typeDocumentConverter;
	}  
    public void setTypeDocumentConverter(TypeDocumentConverter typeDocumentConverter ){
		 this.typeDocumentConverter = typeDocumentConverter;
	}  
	 public boolean  isTypeDocument(){
		  return this.typeDocument;
	 }
	 public void  setTypeDocument(boolean typeDocument){
		   this.typeDocument = typeDocument;
	 }
} 
