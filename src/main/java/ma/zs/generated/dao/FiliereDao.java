package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Filiere;


@Repository
public interface FiliereDao extends JpaRepository<Filiere,Long> {

	Filiere findByLibelle(String libelle);
       int deleteByLibelle(String libelle);

       List<Filiere> findByTypeFiliereLibelle(String libelle);
       int deleteByTypeFiliereLibelle(String libelle);       
       List<Filiere> findByTypeFiliereId(Long id);
       int deleteByTypeFiliereId(Long id);

}