package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Demmandeur;


@Repository
public interface DemmandeurDao extends JpaRepository<Demmandeur,Long> {

	Demmandeur findByCne(String cne);
       int deleteByCne(String cne);

       List<Demmandeur> findByFiliereLibelle(String libelle);
       int deleteByFiliereLibelle(String libelle);       
       List<Demmandeur> findByFiliereId(Long id);
       int deleteByFiliereId(Long id);

}