package ma.zs.generated.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.zs.generated.bean.Role;
import ma.zs.generated.dao.RoleRepository;
import ma.zs.generated.service.facade.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role save(Role role) {
		Role loadedRole=roleRepository.findByAuthority(role.getAuthority());
		if(loadedRole==null) {
			roleRepository.save(role);
			return role;
		}
		return loadedRole;
	}

}
