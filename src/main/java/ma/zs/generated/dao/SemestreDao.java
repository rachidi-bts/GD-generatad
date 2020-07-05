package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Semestre;


@Repository
public interface SemestreDao extends JpaRepository<Semestre,Long> {

	Semestre findByLibellee(String libellee);
	
       int deleteByLibellee(String libellee);


}