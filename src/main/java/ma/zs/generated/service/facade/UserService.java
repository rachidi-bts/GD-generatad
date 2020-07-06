package ma.zs.generated.service.facade;

import org.springframework.security.core.userdetails.UserDetailsService;

import ma.zs.generated.bean.User;


public interface UserService extends UserDetailsService {

	public int saveWithRoles(User user);
	public String authentificate(String login, String pass) ;
}
