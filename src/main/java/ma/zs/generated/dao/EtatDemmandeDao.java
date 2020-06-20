package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.EtatDemmande;


@Repository
public interface EtatDemmandeDao extends JpaRepository<EtatDemmande,Long> {

	EtatDemmande findByLibelle(String libelle);
       int deleteByLibelle(String libelle);


}