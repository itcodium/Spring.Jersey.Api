package jersey.test;


import java.io.IOException;
import java.util.List;
 

import user.TestUserREST;
import user.dao.impl.UserDAO;
import user.model.User;

import com.DAO.ConexionDB;
import com.config.ConfigPropertyReader;

 
public class TestDb {

	public static void main(String[] args) {
		 /*
		User vuser=new User();
		 vuser.setName("Insert Name");
		 vuser.setEmail("insert@email.com");
		 
		TestUserDao.userGetAll();
		User u=TestUserDao.userGetById(2);
	 	  	 u.setEmail("updated@email.com");
	 	  	 u.setName("Update_Name");
	 	TestUserDao.userUpdate(u);
		TestUserDao.userInsert(vuser);
		 
		TestUserDao.userDelete(4);
		*/
		
		// TestUserREST.userInsert(); 
		   TestUserREST.userGetAll();
		// TestUserREST.userGetById("9");
		// TestUserREST.userDelete("8");
		// TestUserREST.userUpdate();
		
		 
 	}
	
	public static void testMariaDBConexion() {
		System.out.println("Test MariaDb");
		ConexionDB b=new ConexionDB();
			b.setEnlace("jdbc:mariadb://localhost:3306/test");
			b.setControlador("org.mariadb.jdbc.Driver");
			b.setUsuario("root");
			b.setContrasenia("123123");
			//b.cerrarConexion();
	 
			b.abrirConexion();
	 
	}
	
	public static void testMySQLConexion() {
		System.out.println("Test MySql");
		ConfigPropertyReader c=new ConfigPropertyReader();
		ConexionDB b=new ConexionDB();
		
		try {
			b.setEnlace(c.getPropValues("enlace"));
			b.setControlador(c.getPropValues("controlador"));
			b.setUsuario(c.getPropValues("usuario"));
			b.setContrasenia(c.getPropValues("contrasenia"));
			b.abrirConexion();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void testUserDAO() {
		System.out.println("Test MySql");
		UserDAO userData=new UserDAO();
		List<User> users= userData.userGetAll();
		for (User u : users) {
			System.out.print(u);
	         System.out.print("ID : " + u.getIdUser() );
	         System.out.print(", Name : " + u.getName() );
	      }
	}
}


