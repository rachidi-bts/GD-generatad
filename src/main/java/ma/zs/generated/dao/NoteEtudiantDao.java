package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.NoteEtudiant;


@Repository
public interface NoteEtudiantDao extends JpaRepository<NoteEtudiant,Long> {
		NoteEtudiant findByDemmandeurCneAndSemestreAndAnneeUniversitaire(String cne,String semestre, Long anneeUniversirtaire);
       List<NoteEtudiant> findByResultatFinalLibelle(String libelle);
       int deleteByResultatFinalLibelle(String libelle);       
       List<NoteEtudiant> findByResultatFinalId(Long id);
       int deleteByResultatFinalId(Long id);
       List<NoteEtudiant> findByDemmandeurCne(String cne);
       int deleteByDemmandeurCne(String cne);       
       List<NoteEtudiant> findByDemmandeurId(Long id);
       int deleteByDemmandeurId(Long id);

}