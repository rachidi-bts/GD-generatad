package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.zs.generated.bean.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByAuthority(String authority);
}
