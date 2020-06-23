package ma.zs.generated.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import ma.zs.generated.bean.DemmandeDocument;
import ma.zs.generated.bean.Demmandeur;
import ma.zs.generated.bean.EtatDemmande;
import ma.zs.generated.bean.NoteEtudiant;
import ma.zs.generated.bean.NoteEtudiantModule;
import ma.zs.generated.bean.TypeDocument;
import ma.zs.generated.dao.DemmandeDocumentDao;
import ma.zs.generated.service.facade.DemmandeDocumentService;
import ma.zs.generated.service.facade.DemmandeurService;
import ma.zs.generated.service.facade.EtatDemmandeService;
import ma.zs.generated.service.facade.NoteEtudiantService;
import ma.zs.generated.service.facade.TypeDocumentService;
import ma.zs.generated.service.util.SearchUtil;
import ma.zs.generated.ws.rest.provided.vo.DemmandeDocumentVo;
@Service
public class DemmandeDocumentServiceImpl implements DemmandeDocumentService {

   @Autowired
   private DemmandeDocumentDao demmandeDocumentDao;
   
   @Autowired
    private EtatDemmandeService etatDemmandeService ;
   @Autowired
    private DemmandeurService demmandeurService ;
   @Autowired
    private TypeDocumentService typeDocumentService ;
   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<DemmandeDocument> findAll(){
		return demmandeDocumentDao.findAll();
	}	
	@Override
	public List<DemmandeDocument> findByEtatDemmandeLibelle(String libelle){
		return demmandeDocumentDao.findByEtatDemmandeLibelle(libelle);
	}
	@Override
	@Transactional
    public int deleteByEtatDemmandeLibelle(String libelle){
		return demmandeDocumentDao.deleteByEtatDemmandeLibelle(libelle);
	}
	
     @Override
    public List<DemmandeDocument> findByEtatDemmandeId(Long id){
		return demmandeDocumentDao.findByEtatDemmandeId(id);

	}
	   @Override
	   @Transactional
    public int deleteByEtatDemmandeId(Long id){
		return demmandeDocumentDao.deleteByEtatDemmandeId(id);

	}
     		
	@Override
	public List<DemmandeDocument> findByDemmandeurCne(String cne){
		return demmandeDocumentDao.findByDemmandeurCne(cne);
	}
	@Override
	@Transactional
    public int deleteByDemmandeurCne(String cne){
		return demmandeDocumentDao.deleteByDemmandeurCne(cne);
	}
	
     @Override
    public List<DemmandeDocument> findByDemmandeurId(Long id){
		return demmandeDocumentDao.findByDemmandeurId(id);

	}
	   @Override
	   @Transactional
    public int deleteByDemmandeurId(Long id){
		return demmandeDocumentDao.deleteByDemmandeurId(id);

	}
     		
	@Override
	public List<DemmandeDocument> findByTypeDocumentLibelle(String libelle){
		return demmandeDocumentDao.findByTypeDocumentLibelle(libelle);
	}
	@Override
	@Transactional
    public int deleteByTypeDocumentLibelle(String libelle){
		return demmandeDocumentDao.deleteByTypeDocumentLibelle(libelle);
	}
	
     @Override
    public List<DemmandeDocument> findByTypeDocumentId(Long id){
		return demmandeDocumentDao.findByTypeDocumentId(id);

	}
	   @Override
	   @Transactional
    public int deleteByTypeDocumentId(Long id){
		return demmandeDocumentDao.deleteByTypeDocumentId(id);

	}
     		

	@Override
	public DemmandeDocument findById(Long id){
		return demmandeDocumentDao.getOne(id);
	}

	@Override	
	public DemmandeDocument save (DemmandeDocument demmandeDocument){
		 if(demmandeDocument.getId()!=null)
		 {
		  DemmandeDocument foundedDemmandeDocument = findById(demmandeDocument.getId()); 
		       if(foundedDemmandeDocument!=null)
	          return null;	  }
	    
	          if(demmandeDocument.getEtatDemmande()!=null){
				    EtatDemmande etatDemmande = etatDemmandeService.findByLibelle(demmandeDocument.getEtatDemmande().getLibelle());
				  if(etatDemmande == null)
				  demmandeDocument.setEtatDemmande(etatDemmandeService.save(demmandeDocument.getEtatDemmande()));
				  else
				  demmandeDocument.setEtatDemmande(etatDemmande);
			  }
	    
	          if(demmandeDocument.getDemmandeur()!=null){
				    Demmandeur demmandeur = demmandeurService.findByCne(demmandeDocument.getDemmandeur().getCne());
				  if(demmandeur == null)
				  demmandeDocument.setDemmandeur(demmandeurService.save(demmandeDocument.getDemmandeur()));
				  else
				  demmandeDocument.setDemmandeur(demmandeur);
			  }
	    
	          if(demmandeDocument.getTypeDocument()!=null){
				    TypeDocument typeDocument = typeDocumentService.findByLibelle(demmandeDocument.getTypeDocument().getLibelle());
				  if(typeDocument == null)
				  demmandeDocument.setTypeDocument(typeDocumentService.save(demmandeDocument.getTypeDocument()));
				  else
				  demmandeDocument.setTypeDocument(typeDocument);
			  }

	    DemmandeDocument savedDemmandeDocument = demmandeDocumentDao.save(demmandeDocument);
	   return savedDemmandeDocument;
	}

    @Override
    public List<DemmandeDocument> save(List<DemmandeDocument> demmandeDocuments){
		List<DemmandeDocument> list = new ArrayList<DemmandeDocument>();
		for(DemmandeDocument demmandeDocument: demmandeDocuments){
		        list.add(save(demmandeDocument));	
		}
		return list;
	}


   @Override
   public DemmandeDocument update(DemmandeDocument demmandeDocument){
     
		 if(demmandeDocument.getId()==null)
			  return null;
		  DemmandeDocument foundedDemmandeDocument = findById(demmandeDocument.getId()); 
		       if(foundedDemmandeDocument==null)
	          return null;	  
	 
	   return  demmandeDocumentDao.save(foundedDemmandeDocument);
     
     }
    
	@Override
	@Transactional
	public int delete(DemmandeDocument demmandeDocument){

		 if(demmandeDocument.getId()==null)
			  return -1;
		  DemmandeDocument foundedDemmandeDocument = findById(demmandeDocument.getId()); 
		       if(foundedDemmandeDocument==null)
	          return -1;	  
	   demmandeDocumentDao.delete(foundedDemmandeDocument);
	   return 1;
	}


	public List<DemmandeDocument> findByCriteria(DemmandeDocumentVo demmandeDocumentVo){
      String query = "SELECT o FROM DemmandeDocument o where 1=1 ";
	  query += SearchUtil.addConstraintDate( "o", "dateDemmande","=",demmandeDocumentVo.getDateDemmande());
	  query += SearchUtil.addConstraintDate( "o", "dateValidation","=",demmandeDocumentVo.getDateValidation());
	 query += SearchUtil.addConstraint( "o", "id","=",demmandeDocumentVo.getId());
	  query += SearchUtil.addConstraintMinMaxDate("o","dateDemmande",demmandeDocumentVo.getDateDemmandeMin(),demmandeDocumentVo.getDateDemmandeMax());
	  query += SearchUtil.addConstraintMinMaxDate("o","dateValidation",demmandeDocumentVo.getDateValidationMin(),demmandeDocumentVo.getDateValidationMax());

	 return entityManager.createQuery(query).getResultList();
	}
	@Override
	public List<DemmandeDocument> findByDemmandeurNom(String nom) {
		return demmandeDocumentDao.findByDemmandeurNom(nom);
	}
	@Override
	public List<DemmandeDocument> findByDemmandeurCodeApogee(String codeApogee) {
		return demmandeDocumentDao.findByDemmandeurCodeApogee(codeApogee);
	}
	@Override
	public List<DemmandeDocument> findByDemmandeurCin(String cin) {
		return demmandeDocumentDao.findByDemmandeurCin(cin);
	}
	@Override
	public List<DemmandeDocument> findByDemmandeurFiliereAbrv(String abrv) {
		return demmandeDocumentDao.findByDemmandeurFiliereAbrv(abrv);
	}
	
	//PDF
	@Override
	public int infoDemmandeurPdf(String cin, String libelle) throws DocumentException, FileNotFoundException {
		Demmandeur demmandeur = demmandeurService.findByCin(cin);
		TypeDocument typeDocument = typeDocumentService.findByLibelle(libelle);
		String pattern = "dd/MM/yyyy";
		String pattern2 = "yyyy";
		String pattern3 = "dd MMMM yyyy ";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(pattern3);
		Document document = new Document();
		 PdfWriter.getInstance(document, new FileOutputStream(typeDocument.getLibelle() + demmandeur.getNom() + demmandeur.getPrenom() + ".pdf"));
		document.open();
		
        
		Font font1 = FontFactory.getFont(FontFactory.TIMES, 9, BaseColor.BLACK);
		Paragraph p1 = new Paragraph("ROYAUME DU MAROC" + "\n" + "Université Cadi Ayyad." + "\n" +
		"Faculté des Sciences et Techniques"
						+ "\n" + "Gueliz-Marrakech" + "\n" + "\n" , font1);
		p1.setAlignment(Element.ALIGN_LEFT);
		document.add(p1);
		
		Font font2 = FontFactory.getFont(FontFactory.TIMES, 10, Font.UNDERLINE);
		Paragraph p2 = new Paragraph("Service des Affaires Estudiantines" , font2);
		p2.setAlignment(Element.ALIGN_LEFT);
		document.add(p2);
		

		/*
		Paragraph p2 = new Paragraph("المملكة المغربية" + "\n" + "جامعة القاضي عياض" + "\n"
				+ "كلية العلوم و التقنيات مراكش" + "\n" + "\n" + "\n" + "مصلحة الشؤون الطلابية");
		p2.setAlignment(Element.ALIGN_RIGHT);
		document.add(p2);
		*/
		
		 Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 20, Font.UNDERLINE);
		Paragraph p3 = new Paragraph("\n " + typeDocument.getLibelle(), font3);
		p3.setAlignment(Element.ALIGN_CENTER);
		document.add(p3);
		

		Font font = FontFactory.getFont(FontFactory.TIMES, 11);
		Paragraph p = new Paragraph("\n\n\n" + "   " + "Le Doyen de la Faculté des Sciences et Techniques de Marrakech atteste que l'étudiant(e):"
				+ "\n\n" + "   " + "Nom complet:  " + demmandeur.getNom() + " " + demmandeur.getPrenom() + "\n\n" + "   "
				+ "Numéro de la carte d'identité nationale : " + demmandeur.getCin() + "\n\n" + "   "
				+ "Code national de l'étudiant(e) : " + "                 " + demmandeur.getCne() + "\n\n" + "   " + "né(e) le"
				+ " " + simpleDateFormat3.format(demmandeur.getDateNaissance()) + " " + "à" + " " +
				demmandeur.getVilleNaissance() + " " + "(" + demmandeur.getPaysNaissance() + ")" + "\n\n" + "   "
				+ "est régulièrement inscrit(e) à la Faculté des Sciences et Techniques Gueliz-Marrakech pour" + "\n" + "   "
				+ "l'année universitaire" + " " + demmandeur.getAnneeInscription() + "." + "\n\n" + "   "
				, font);
		
		Font fontt = FontFactory.getFont(FontFactory.TIMES, 11, Font.UNDERLINE);
		Phrase diplome = new Phrase("Diplôme :", fontt);
		Phrase phh = new Phrase("  " + "3ème Année" + " " + demmandeur.getFiliere().getTypeFiliere().getLibelle() +
				" " + demmandeur.getFiliere().getAbrv() + "\n\n" +"   ", font);
		Phrase annee = new Phrase("Année :", fontt);
		Phrase phh2 = new Phrase("      " + demmandeur.getFiliere().getTypeFiliere().getLibelle() + " " + "ST" + " " 
		+ demmandeur.getFiliere().getLibelle(), font);
		p.add(diplome);
		p.add(phh);
		p.add(annee);
		p.add(phh2);
		document.add(p);
		
		Paragraph p4 = new Paragraph("\n\n\n" + "                               "
				+ "                                                                " +
		"Fait à Marrakech , le " + simpleDateFormat3.format(new Date()), font);
		document.add(p4);

		Paragraph p5 = new Paragraph("\n \r\r\r\r"  + demmandeur.getCodeApogee() + "\n \r");
		p5.setAlignment(Element.ALIGN_RIGHT);
		document.add(p5);
		
		// ligne
		document.add(new LineSeparator()); // Thick line
		
		Phrase ph1 = new Phrase(" Adresse :", font2);
		Phrase ph2 = new Phrase("   " + "B.P549, Av.Abdelkarim elkhattabi \t\t\t\t\t" + "العنوان" + "\n"
		+"                     " + "Gueliz-Marrakech" + "\n" + "                     " + "Tél: +212 24 43 34" + 
				"                                               "
		+ "                                                                            " + "Fax: +212 24 43 31" + "\n" 
				+ "\r", font1);
		/*String FONT = "resources/fonts/NotoNaskhArabic-Regular.ttf";
		Font f = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	    final String arabic2 = "\u0627\u0644\u0639\u0646\u0648\u0627\u0646" ;
	    Phrase ph6 = new Phrase();
		ph6.add(new Chunk(arabic2,f));*/
		Paragraph p6 = new Paragraph();
		p6.add(ph1);
		p6.add(ph2);
		//p6.add(ph6);
		document.add(p6);
	

		// ligne
		document.add(new LineSeparator()); // Thick line
		Paragraph p7 = new Paragraph("\t Le présent document n'est délivré qu'en un seul exemplaire." + "\n"
				+ "Il appartient à l'étudiant d'en faire dephotocopies certifiées conformes.", font1);
		p7.setAlignment(Element.ALIGN_CENTER);
		
		document.add(p7);
		document.close();
		return 1;
	}
	
	@Autowired
	private NoteEtudiantService noteEtudiantService;
	//Relevé
	@Override
	public int infoRelevePdf(String cne,String semestre, Long anneUniversitaire, String libelle) throws DocumentException, FileNotFoundException {
		Demmandeur demmandeur = demmandeurService.findByCne(cne);
		TypeDocument typeDocument = typeDocumentService.findByLibelle(libelle);
		NoteEtudiant noteEtudiant = noteEtudiantService.findByDemmandeurCneAndSemestreAndAnneeUniversitaire(cne, semestre, anneUniversitaire);
		String pattern = "dd MMMM yyyy ";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Document document = new Document();
		 PdfWriter.getInstance(document, new FileOutputStream(typeDocument.getLibelle() +
				 demmandeur.getNom() + demmandeur.getPrenom() + ".pdf"));
		document.open();
		
		//ParagraphBorder border = new ParagraphBorder();
		//writer.setPageEvent(border);

		
		float [] pointColumnWidths1 = {400};
		PdfPTable table1 = new PdfPTable(pointColumnWidths1);
		table1.setWidthPercentage(100);
		
		Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD, 9, BaseColor.BLACK);
		Paragraph p1 = new Paragraph("Université Cadi Ayyad",font2);
		p1.setAlignment(Element.ALIGN_LEFT);
		PdfPCell c = new PdfPCell(p1);
		c.setBorderWidth(2);
        c.setFixedHeight(45);
		table1.addCell(c);
		document.add(table1);
		
		Font font1 = FontFactory.getFont(FontFactory.TIMES, 9, BaseColor.BLACK);
		Paragraph p2 = new Paragraph("Faculté des Sciences et Techniques Gueliz-Marrakech", font1);
		p2.setAlignment(Element.ALIGN_LEFT);
		document.add(p2);
		
		Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 20, Font.UNDERLINE);
		Paragraph p3 = new Paragraph("\n " + typeDocument.getLibelle(), font3);
		p3.setAlignment(Element.ALIGN_CENTER);
		document.add(p3);
		
		Font font4 = FontFactory.getFont(FontFactory.TIMES, 11);
		Paragraph p4 = new Paragraph("\n\n\n" +   "Nom Prénom :  " +"          "+ demmandeur.getNom() 
		        + " " + demmandeur.getPrenom() + "\n"
				+ "N° :" + "    " + demmandeur.getCodeApogee() + "          "
				+ "CNE : " + "    " + demmandeur.getCne() +"\n"
				+ "Né(e) le" + " " + simpleDateFormat.format(demmandeur.getDateNaissance()) + "    " + "à : " + " " 
				+ demmandeur.getVilleNaissance()  + "\n"
				+ "Inscrit(e) en semestre 6" + "  " + demmandeur.getFiliere().getLibelle()  
				+ "a obtenu les notes suivantes :"  + "\n\n" , font4);
		document.add(p4);
		
		float [] pointColumnWidths = {200};
		 PdfPTable table = new PdfPTable(pointColumnWidths); 
		 table.setWidthPercentage(100);
		
		 PdfPCell c1 = new PdfPCell(new Paragraph("Module" + "                            " + "Note/Baréme" +"              "
				 +"Résultat"+ "                            " + "PtsJury"));
		 table.addCell(c1);
		 List<NoteEtudiantModule> noteEtudiantModules = noteEtudiant.getNoteEtudiantModules();
		 for (NoteEtudiantModule noteEtudiantModule : noteEtudiantModules) {
			 PdfPCell c2 = new PdfPCell(new Paragraph(noteEtudiantModule.getModule().getLibelle()+ "                 " + noteEtudiantModule.getNote()
			 +"              " +noteEtudiantModule.getResultat().getLibelle()+ "               " + noteEtudiantModule.getPtsJury()));
			 table.addCell(c2);
			
		}
		/* m.setBorderColorRight(BaseColor.WHITE);   
		 Phrase m =new Phrase("Module");
		 Phrase n =new Phrase("Note/Barème");
		 Phrase r =new Phrase("Résultat");
		 Phrase p =new Phrase("Pts Jury");
		 
		 Phrase m1 =new Phrase("Thermodynamique");
		 Phrase n1 =new Phrase("10/20");
		 Phrase r1 =new Phrase("V");
		 Phrase p10 =new Phrase(" ");
		 PdfPCell m2 = new PdfPCell(new Paragraph("Mécanique du point et optique géométrique"));
		 PdfPCell n2 = new PdfPCell(new Paragraph("10/20"));
		 PdfPCell r2 = new PdfPCell(new Paragraph("VAR"));
		 PdfPCell p2 = new PdfPCell(new Paragraph(" "));
		 
		 PdfPCell c9 = new PdfPCell(new Paragraph("Analyse1 : Fonction d'une variable réelle "));
		 
	      // Adding cells to the table       
	   /*   table.addCell(new PdfPCell(m));       
	      table.addCell(new PdfPCell(n));       
	      table.addCell(new PdfPCell(r));       
	      table.addCell(new PdfPCell(p));       
	      table.addCell(new PdfPCell(m1));       
	      table.addCell(new PdfPCell(n1));
	      table.addCell(new PdfPCell(r1));
	      table.addCell(new PdfPCell(p10));
	      table.addCell(c5);
	      table.addCell(c6);
	      table.addCell(c7);
	      table.addCell(c8);*/
	     // table.addCell();
	         
	      // Adding Table to document        
	      document.add(table);                  
	         
	      // Closing the document       
	      document.close();

		return 1;
	}
  
 
}