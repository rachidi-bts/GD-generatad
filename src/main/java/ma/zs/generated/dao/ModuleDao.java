package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Module;


@Repository
public interface ModuleDao extends JpaRepository<Module,Long> {

	Module findByLibelle(String libelle);
       int deleteByLibelle(String libelle);


}