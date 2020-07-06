package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.generated.bean.User;
import ma.zs.generated.service.util.NumberUtil;
import ma.zs.generated.service.util.StringUtil;
import ma.zs.generated.ws.rest.provided.vo.UserVo;

@Component 
public class UserConverter extends AbstractConverter<User,UserVo>{ 
    @Autowired
	private RoleConverter roleConverter ;
    private boolean  role;

	public  UserConverter(){
		init(true);
	}

	@Override 
 	public User toItem(UserVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
    	  User item = new User();
			 if(StringUtil.isNotEmpty(vo.getUsername()))
                  item.setUsername(vo.getUsername());
			 if(StringUtil.isNotEmpty(vo.getPassword()))
                  item.setPassword(vo.getPassword());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
             if(vo.getAuthoritiesVo()!=null && this.role)
	              item.setAuthorities(roleConverter.toItem(vo.getAuthoritiesVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public UserVo toVo(User item) {
 		if (item == null) {
    		return null;
      	} else {
      		UserVo vo = new UserVo();

			if(StringUtil.isNotEmpty(item.getUsername()))
				vo.setUsername(item.getUsername());
			
			if(StringUtil.isNotEmpty(item.getPassword()))
				vo.setPassword(item.getPassword());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
			 
       //     if(item.getAuthorities()!=null && this.role) {
			//	   vo.setAuthoritiesVo(roleConverter.toVo(item.getAuthorities())) ;

			//   } 

 			return vo;
 
 		}
 	}
	public void init(boolean value) { 
       role = value;
	}


	public RoleConverter getRoleConverter(){
		return this.roleConverter;
	}  
    public void setRoleConverter(RoleConverter roleConverter ){
		 this.roleConverter = roleConverter;
	}  
	 public boolean  isRole(){
		  return this.role;
	 }
	 public void  setRole(boolean role){
		   this.role = role;
	 }
} 
