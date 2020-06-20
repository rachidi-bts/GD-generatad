package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Resultat;


@Repository
public interface ResultatDao extends JpaRepository<Resultat,Long> {

	Resultat findByLibelle(String libelle);
       int deleteByLibelle(String libelle);


}