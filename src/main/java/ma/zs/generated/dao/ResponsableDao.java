package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Responsable;


@Repository
public interface ResponsableDao extends JpaRepository<Responsable,Long> {

	Responsable findByLogin(String login);
       int deleteByLogin(String login);

       List<Responsable> findByTypeFiliereLibelle(String libelle);
       int deleteByTypeFiliereLibelle(String libelle);       
       List<Responsable> findByTypeFiliereId(Long id);
       int deleteByTypeFiliereId(Long id);

}