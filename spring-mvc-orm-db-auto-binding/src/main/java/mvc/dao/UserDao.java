package mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import mvc.model.User;

@Repository
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Transactional
	public int saveUser(User user) {
		int id = (Integer)this.hibernateTemplate.save(user);
		return id;
	}
}
