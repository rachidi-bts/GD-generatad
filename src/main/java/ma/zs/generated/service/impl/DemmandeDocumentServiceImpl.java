package ma.zs.generated.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
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
	public DemmandeDocument findByAnneeUniversitaire(Long anneeUniversitaire) {
		return demmandeDocumentDao.findByAnneeUniversitaire(anneeUniversitaire);
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
	public int infoDemmandeurPdf(String cin, String libelle,Long anneeUniversitaire) throws DocumentException, FileNotFoundException {
		Demmandeur demmandeur = demmandeurService.findByCin(cin);
		TypeDocument typeDocument = typeDocumentService.findByLibelle(libelle);
		DemmandeDocument demmandeDocument = demmandeDocumentDao.findByAnneeUniversitaire(anneeUniversitaire);

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
				+ "l'année universitaire" + " " + demmandeDocument.getAnneeUniversitaire() + "." + "\n\n" + "   "
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
	public int infoRelevePdf(String cne,String libellee, Long anneUniversitaire, String libelle) throws DocumentException, FileNotFoundException {
		Demmandeur demmandeur = demmandeurService.findByCne(cne);
		TypeDocument typeDocument = typeDocumentService.findByLibelle(libelle);
		//DemmandeDocument demmandeDocument = demmandeDocumentDao.findByAnneeUniversitaire(anneeUniversitaire);

		NoteEtudiant noteEtudiant = noteEtudiantService.findByDemmandeurCneAndSemestreLibelleeAndAnneeUniversitaire(cne, libellee, anneUniversitaire);
		String pattern = "dd MMMM yyyy ";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Document document = new Document();
		 PdfWriter.getInstance(document, new FileOutputStream(typeDocument.getLibelle() +
				 demmandeur.getNom() + demmandeur.getPrenom() + ".pdf"));
		document.open();
		

		
		float [] pointColumnWidths1 = {400};
		PdfPTable table1 = new PdfPTable(pointColumnWidths1);
		table1.setWidthPercentage(100);
		
		Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD, 10, BaseColor.BLACK);
		Paragraph p1 = new Paragraph("Université Cadi Ayyad",font2);
		p1.setAlignment(Element.ALIGN_LEFT);
		
		Paragraph p11 = new Paragraph("Année universitaire" + "  " 
		+ noteEtudiant.getAnneeUniversitaire() +"/"+ (noteEtudiant.getAnneeUniversitaire()+1),font2);
		p11.setAlignment(Element.ALIGN_CENTER);
		PdfPCell c = new PdfPCell();
		c.addElement(p1);
		c.addElement(p11);
		c.setBorderWidth(2);
        c.setFixedHeight(40);
		table1.addCell(c);
		document.add(table1);
		
		Font font1 = FontFactory.getFont(FontFactory.TIMES, 10, BaseColor.BLACK);
		Paragraph p2 = new Paragraph("Faculté des Sciences et Techniques Gueliz-Marrakech", font1);
		p2.setAlignment(Element.ALIGN_LEFT);
		document.add(p2);
		
		Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 20, Font.UNDERLINE);
		Paragraph p3 = new Paragraph( typeDocument.getLibelle(), font3);
		p3.setAlignment(Element.ALIGN_CENTER);
		document.add(p3);
		
		Font font4 = FontFactory.getFont(FontFactory.TIMES, 12);
		Phrase p4 = new Phrase("\n\n" +   "Nom Prénom :  " +"          " , font4);
		Font fontph4 = FontFactory.getFont(FontFactory.TIMES_BOLD, 12, BaseColor.BLACK);
		Phrase ph4 = new Phrase( demmandeur.getNom()  + " " + demmandeur.getPrenom() + "\n" , fontph4);
		Paragraph p5 = new Paragraph( "N° :" + "    " + demmandeur.getCodeApogee() + "          "
		+ "CNE : " + "    " + demmandeur.getCne() +"\n"
		+ "Né(e) le" + " " + simpleDateFormat.format(demmandeur.getDateNaissance()) + "    " + "à : " + " " 
		+ demmandeur.getVilleNaissance()  + "\n"
		+ "Inscrit(e) en"+ "  " +noteEtudiant.getSemestre().getLibellee() + "  " + demmandeur.getFiliere().getLibelle()  + "\n"
		+ "a obtenu les notes suivantes :"  + "\n\n" , font4);
		document.add(p4);
		document.add(ph4);
		document.add(p5);

		
		float [] pointColumnWidths = {200,200,200,200};
		 PdfPTable table = new PdfPTable(pointColumnWidths); 
		 table.setWidthPercentage(100);
		
		
		 PdfPCell m =new PdfPCell(new Paragraph("         "+"Module",font4));
		 m.setFixedHeight(30);
		 PdfPCell n = new PdfPCell(new Paragraph("       "+"Note/Barème",font4));
		 n.setFixedHeight(30);
		 PdfPCell r = new PdfPCell(new Paragraph("        "+"Résultat",font4));
		 r.setFixedHeight(30);
		 PdfPCell p = new PdfPCell(new Paragraph("          "+"Pts Jury",font4));
		 p.setFixedHeight(30);
		 
		  // Adding cells to the table       
	      table.addCell(m);       
	      table.addCell(n);       
	      table.addCell(r);       
	      table.addCell(p);
		 
		 List<NoteEtudiantModule> noteEtudiantModules = noteEtudiant.getNoteEtudiantModules();
		 for (NoteEtudiantModule noteEtudiantModule : noteEtudiantModules) {
			 
		 PdfPCell m1 = new PdfPCell(new Paragraph(noteEtudiantModule.getModule().getLibelle(),font4));
		// m1.setFixedHeight(25);
		 PdfPCell n1 = new PdfPCell(new Paragraph("           "+noteEtudiantModule.getNote()+"/20",font4));
		 PdfPCell r1 = new PdfPCell(new Paragraph("             "+noteEtudiantModule.getResultat().getLibelle(),font4));
		 PdfPCell p10 = new PdfPCell(new Paragraph("           "+noteEtudiantModule.getPtsJury(),font4));
	             
	      table.addCell(m1);       
	      table.addCell(n1);
	      table.addCell(r1);
	      table.addCell(p10); }
	      
	     
	      // Adding Table to document        
	      document.add(table);  
	          
	      Paragraph p6 = new Paragraph("Résultat" + "                                        " + noteEtudiant.getNoteFinale() + 
	      "/20"+"                                "  + noteEtudiant.getResultatFinal().getLibelle(),fontph4);
	      document.add(p6);
	      
	      Paragraph p7 = new Paragraph("\n");
	      document.add(p7);
	      
	      Image img, img1;
	      
	      try {
	    	  img = Image.getInstance("codeBarre.jpg");
	    	  img.setAlignment(Element.ALIGN_RIGHT);
	    	  document.add(img);
	      } catch (MalformedURLException e) {
	    	  e.printStackTrace();
	      } catch (IOException e) {
	    	  e.printStackTrace();
	      }
	      
	   /*   float [] pointColumnWidths2 = {60};
			PdfPTable table2 = new PdfPTable(pointColumnWidths2);
			table2.setWidthPercentage(10);
		
			Font fontt = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 11, BaseColor.BLACK);
			Paragraph pp = new Paragraph(" " +noteEtudiant.getAnneeUniversitaire()+ " ",fontt);
			pp.setAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cc = new PdfPCell();
	        c.setFixedHeight(20);
			cc.addElement(pp);
			
			table2.addCell(cc);
			document.add(table2);*/
			
	      
	      try {
	    	  img1 = Image.getInstance("fstg.jpg");
	    	  img1.setAlignment(Element.ALIGN_RIGHT);
	    	  document.add(img1);
	      } catch (MalformedURLException e) {
	    	  e.printStackTrace();
	      } catch (IOException e) {
	    	  e.printStackTrace();
	      }
	      
	      Paragraph phh1 = new Paragraph("\n\n\n\n"+"                                " + "Fait à Marrakech" + "\n" , font4);
	      Paragraph phh2 = new Paragraph( "Le Doyen de la Faculté des Sciences et Techniques de Marrakech" + "\n\n\n\n" , font4);
	      Paragraph phh3 = new Paragraph( "   "+"Avis important : Il ne peut être délivré qu'un seul exemplaire du présent relevé de note."
	      		+ "Aucun duplicata ne sera fourni.", font1);
	      
         
	      document.add(phh1);
	      document.add(phh2);
	      document.add(phh3);
	      // Closing the document       
	      document.close();

		return 1;
	}
	
	//Excel
	@Override
	public int listeDemmandeurExcel(List<Demmandeur> demmandeurs) {Workbook workbook = new XSSFWorkbook();
	String pattern = " yyyy ";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    Sheet sheet = workbook.createSheet("Liste des étudiants");
	Row header = sheet.createRow(0);

      header.createCell(0).setCellValue("Cne");
      header.createCell(1).setCellValue("Cin");
      header.createCell(2).setCellValue("Code_Apogee");
      header.createCell(3).setCellValue("Prénom");
      header.createCell(4).setCellValue("Nom");
      header.createCell(5).setCellValue("Ville_Naissance");
      header.createCell(6).setCellValue("Annee_Inscription");
   //   header.createCell(7).setCellValue("Dîplome");
      header.createCell(7).setCellValue("Adresse");
System.out.println(demmandeurs);


      int rowNum = 1;
     for (Demmandeur demmandeur : demmandeurs) {
         Row row = sheet.createRow(rowNum++);
         row.createCell(0).setCellValue(demmandeur.getCne());
         row.createCell(1).setCellValue(demmandeur.getCin());
         row.createCell(2).setCellValue(demmandeur.getCodeApogee());
         row.createCell(3).setCellValue(demmandeur.getPrenom());
         row.createCell(4).setCellValue(demmandeur.getNom());
         row.createCell(5).setCellValue(demmandeur.getVilleNaissance());
         row.createCell(6).setCellValue(demmandeur.getAnneeInscription());
    //     row.createCell(7).setCellValue(demmandeur.getFiliere().getTypeFiliere().getLibelle()+" " +
      //                                  demmandeur.getFiliere().getLibelle());
         row.createCell(7).setCellValue(demmandeur.getPrenom() + "." + demmandeur.getNom() +
        		                         "@edu.uca.ma");

	}
    // String fileLocation = "C:/Users/hp/Desktop/";
     try {
	     FileOutputStream outputStream = new FileOutputStream("Liste des étudiants.xlsx");
		workbook.write(outputStream);
	     workbook.close();

	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
     return 1;
	}
	
	
  
 
}