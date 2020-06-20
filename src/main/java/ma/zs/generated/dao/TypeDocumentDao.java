package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.TypeDocument;


@Repository
public interface TypeDocumentDao extends JpaRepository<TypeDocument,Long> {

	TypeDocument findByLibelle(String libelle);
       int deleteByLibelle(String libelle);


}