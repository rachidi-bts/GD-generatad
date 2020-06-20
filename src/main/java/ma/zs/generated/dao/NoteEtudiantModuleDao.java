package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.NoteEtudiantModule;


@Repository
public interface NoteEtudiantModuleDao extends JpaRepository<NoteEtudiantModule,Long> {


       List<NoteEtudiantModule> findByNoteEtudiantId(Long id);
       int deleteByNoteEtudiantId(Long id);
       List<NoteEtudiantModule> findByResultatLibelle(String libelle);
       int deleteByResultatLibelle(String libelle);       
       List<NoteEtudiantModule> findByResultatId(Long id);
       int deleteByResultatId(Long id);
       List<NoteEtudiantModule> findByModuleLibelle(String libelle);
       int deleteByModuleLibelle(String libelle);       
       List<NoteEtudiantModule> findByModuleId(Long id);
       int deleteByModuleId(Long id);

}