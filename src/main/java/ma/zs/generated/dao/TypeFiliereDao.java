package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.TypeFiliere;


@Repository
public interface TypeFiliereDao extends JpaRepository<TypeFiliere,Long> {

	TypeFiliere findByLibelle(String libelle);
       int deleteByLibelle(String libelle);


}