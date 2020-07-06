package ma.zs.generated.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ma.zs.generated.bean.Role;
import ma.zs.generated.bean.User;
import ma.zs.generated.dao.UserRepository;
import ma.zs.generated.service.aspect.security.JwtUtil;
import ma.zs.generated.service.facade.RoleService;
import ma.zs.generated.service.facade.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Autowired
	private AuthenticationManager authenticationManager;

	public String authentificate(String login, String pass) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, pass));
		} catch (Exception e) {
			return "Bad Creditienl for " + login;
		}
		UserDetails userDetails = loadUserByUsername(login);
		return  JwtUtil.generateToken(userDetails)+
		 userDetails.getUsername();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	@Override
	public int saveWithRoles(User user) {
		if (user == null || user.getUsername() == null || user.getUsername().isEmpty() || user.getPassword() == null
				|| user.getPassword().isEmpty()) {
			return -1;
		}
		UserDetails loadedUser = loadUserByUsername(user.getUsername());
		if (loadedUser != null) {
			return -2;
		} else if (user.getAuthorities() != null && !user.getAuthorities().isEmpty()) {
			user.getAuthorities().forEach(r -> {
				Role myRole = roleService.save(r);
				r.setId(myRole.getId());
			});
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);

		return 0;
	}

}
