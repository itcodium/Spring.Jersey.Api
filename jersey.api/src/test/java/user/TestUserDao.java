package user;
 
import java.util.List;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.dao.impl.UserDAO;
import user.model.User;


public class TestUserDao{
	static ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    static UserDAO userDao = (UserDAO) context.getBean("UserDAO");
    
	public TestUserDao(){}
	public static void userGetAll() {
	        List<User> usuarios= userDao.userGetAll();
	        System.out.println(usuarios);
	}
	public static User userGetById(int idUser) {
        User user= userDao.userGetById(idUser);
        System.out.println(user);
        return user;
	}
	
	public static void userDelete(int idUser) {
        userDao.delete(idUser);
        System.out.println("User Delete");
	}
	
	public static void userUpdate(User u) {
        userDao.update(u);
        System.out.println("User Update");
	}
	
	public static void userInsert(User u) {
        userDao.insert(u);
        System.out.println("User Insert");
	}
}
