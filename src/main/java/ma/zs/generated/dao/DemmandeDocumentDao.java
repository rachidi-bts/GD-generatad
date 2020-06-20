package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.DemmandeDocument;


@Repository
public interface DemmandeDocumentDao extends JpaRepository<DemmandeDocument,Long> {


       List<DemmandeDocument> findByEtatDemmandeLibelle(String libelle);
       int deleteByEtatDemmandeLibelle(String libelle);       
       List<DemmandeDocument> findByEtatDemmandeId(Long id);
       int deleteByEtatDemmandeId(Long id);
       List<DemmandeDocument> findByDemmandeurCne(String cne);
       int deleteByDemmandeurCne(String cne);       
       List<DemmandeDocument> findByDemmandeurId(Long id);
       int deleteByDemmandeurId(Long id);
       List<DemmandeDocument> findByTypeDocumentLibelle(String libelle);
       int deleteByTypeDocumentLibelle(String libelle);       
       List<DemmandeDocument> findByTypeDocumentId(Long id);
       int deleteByTypeDocumentId(Long id);

}