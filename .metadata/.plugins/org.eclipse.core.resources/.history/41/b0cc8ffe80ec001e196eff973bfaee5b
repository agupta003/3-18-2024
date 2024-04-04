package mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dao.UserDao;
import mvc.model.User;


@Service                                                                      
public class UserService {
	                                  
	@Autowired
	private UserDao ud;
	            
	public int createUser(User user) {
		return this.ud.saveUser(user);
	}
}
