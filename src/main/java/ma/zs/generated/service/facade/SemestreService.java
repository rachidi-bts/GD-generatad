package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.Semestre;
import ma.zs.generated.ws.rest.provided.vo.SemestreVo;

public interface SemestreService {
 
	
	/**
	 * 
	 * find all Semestre in database
	 * 
	 * @return List<Semestre> , If database is empty return null.
	 */
	List<Semestre> findAll();

	/**
	 * 
	 * find Semestre from database by libelle (reference)
	 * 
	 * @param libelle - reference of Semestre
	 * @return the founded Semestre , If no Semestre were found in database
	 *         return null.
	 */
	Semestre findByLibellee(String libellee);

	/**
	 * find Semestre from database by id (id)
	 * 
	 * @param id - id of Semestre
	 * @return the founded Semestre , If no Semestre were found in database
	 *         return null.
	 */
	Semestre findById(Long id);

	/**
	 * save Semestre in database
	 * 
	 * @param semestre - Semestre to be saved
	 * @return the saved Semestre, If the Semestre can't be saved return
	 *         null.
	 */
	Semestre save(Semestre semestre);

	/**
	 * save list Semestre in database
	 * 
	 * @param semestres - list of Semestre to be saved
	 * @return the saved Semestre list
	 */
	List<Semestre> save(List<Semestre> semestres);

	/**
	 * update Semestre in database
	 * 
	 * @param semestre - Semestre to be updated
	 * @return the updated Semestre, If the Semestre can't be updated return
	 *         null.
	 */
	Semestre update(Semestre semestre);

	/**
	 * delete Semestre from database
	 * 
	 * @param semestre - Semestre to be deleted
	 * @return 1 if Semestre deleted successfully, If the Semestre can't be
	 *         deleted return negative int
	 */
	int delete(Semestre semestre);

	/**
	 * delete Semestre from database by libelle (reference)
	 * 
	 * @param libelle - reference of Semestre to be deleted
	 * @return 1 if Semestre deleted successfully
	 */
	int deleteByLibellee(String libellee);

	/**
	 * search for Semestre in by some criteria
	 * 
	 * @return the searhed list Semestre
	 */
	List<Semestre> findByCriteria(SemestreVo semestreVo);
}