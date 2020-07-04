package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

import ma.zs.generated.bean.Demmandeur; 
import ma.zs.generated.ws.rest.provided.vo.DemmandeurVo;

@Component 
public class DemmandeurConverter extends AbstractConverter<Demmandeur,DemmandeurVo>{ 
    @Autowired
	private FiliereConverter filiereConverter ;
    private boolean  filiere;

	public  DemmandeurConverter(){
		init(true);
	}

	@Override 
 	public Demmandeur toItem(DemmandeurVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Demmandeur item = new Demmandeur();
			 if(StringUtil.isNotEmpty(vo.getPassword()))
                  item.setPassword(vo.getPassword());
			 if(StringUtil.isNotEmpty(vo.getPaysNaissance()))
                  item.setPaysNaissance(vo.getPaysNaissance());
			 if(StringUtil.isNotEmpty(vo.getAnneeInscription()))
                  item.setAnneeInscription(NumberUtil.toLong(vo.getAnneeInscription()));
			 if(StringUtil.isNotEmpty(vo.getLogin()))
                  item.setLogin(vo.getLogin());
			 if(StringUtil.isNotEmpty(vo.getCne()))
                  item.setCne(vo.getCne());
			 if(StringUtil.isNotEmpty(vo.getNbreAttestInscrRest()))
                  item.setNbreAttestInscrRest(NumberUtil.toLong(vo.getNbreAttestInscrRest()));
			 if(StringUtil.isNotEmpty(vo.getNbreCertScolRest()))
                  item.setNbreCertScolRest(NumberUtil.toLong(vo.getNbreCertScolRest()));
			 if(StringUtil.isNotEmpty(vo.getPrenom()))
                  item.setPrenom(vo.getPrenom());
			 if(StringUtil.isNotEmpty(vo.getCin()))
                  item.setCin(vo.getCin());
             if(StringUtil.isNotEmpty(vo.getDateNaissance()))
			      item.setDateNaissance(DateUtil.parse(vo.getDateNaissance()));
			 if(StringUtil.isNotEmpty(vo.getVilleNaissance()))
                  item.setVilleNaissance(vo.getVilleNaissance());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
			 if(StringUtil.isNotEmpty(vo.getCodeApogee()))
                  item.setCodeApogee(vo.getCodeApogee());
			 if(StringUtil.isNotEmpty(vo.getNom()))
                  item.setNom(vo.getNom());
             if(vo.getFiliereVo()!=null && this.filiere)
	              item.setFiliere(filiereConverter.toItem(vo.getFiliereVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public DemmandeurVo toVo(Demmandeur item) {
 		if (item == null) {
    		return null;
      	} else {
			DemmandeurVo vo = new DemmandeurVo();

			if(StringUtil.isNotEmpty(item.getPassword()))
				vo.setPassword(item.getPassword());
			
			if(StringUtil.isNotEmpty(item.getPaysNaissance()))
				vo.setPaysNaissance(item.getPaysNaissance());
			
			 if(item.getAnneeInscription()!=null)
				vo.setAnneeInscription(NumberUtil.toString(item.getAnneeInscription()));
			if(StringUtil.isNotEmpty(item.getLogin()))
				vo.setLogin(item.getLogin());
			
			if(StringUtil.isNotEmpty(item.getCne()))
				vo.setCne(item.getCne());
			
			 if(item.getNbreAttestInscrRest()!=null)
				vo.setNbreAttestInscrRest(NumberUtil.toString(item.getNbreAttestInscrRest()));
			 if(item.getNbreCertScolRest()!=null)
				vo.setNbreCertScolRest(NumberUtil.toString(item.getNbreCertScolRest()));
			if(StringUtil.isNotEmpty(item.getPrenom()))
				vo.setPrenom(item.getPrenom());
			
			if(StringUtil.isNotEmpty(item.getCin()))
				vo.setCin(item.getCin());
			
            if(item.getDateNaissance()!=null)
			    vo.setDateNaissance(DateUtil.formateDate(item.getDateNaissance()));	     
			if(StringUtil.isNotEmpty(item.getVilleNaissance()))
				vo.setVilleNaissance(item.getVilleNaissance());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
			if(StringUtil.isNotEmpty(item.getCodeApogee()))
				vo.setCodeApogee(item.getCodeApogee());
			
			if(StringUtil.isNotEmpty(item.getNom()))
				vo.setNom(item.getNom());
			
            if(item.getFiliere()!=null && this.filiere) {
				   vo.setFiliereVo(filiereConverter.toVo(item.getFiliere())) ;
			   } 

 			return vo;
 
 		}
 	}
	public void init(boolean value) { 
       filiere = value;
	}


	public FiliereConverter getFiliereConverter(){
		return this.filiereConverter;
	}  
    public void setFiliereConverter(FiliereConverter filiereConverter ){
		 this.filiereConverter = filiereConverter;
	}  
	 public boolean  isFiliere(){
		  return this.filiere;
	 }
	 public void  setFiliere(boolean filiere){
		   this.filiere = filiere;
	 }
} 
