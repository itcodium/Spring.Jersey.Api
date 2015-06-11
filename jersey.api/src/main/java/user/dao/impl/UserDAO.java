package user.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

import user.dao.IUser;
import user.model.User;

 
public class UserDAO implements IUser  
{
	private Connection conn = null;
	private DataSource dataSource;
	private CallableStatement cs;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 
	public User userGetById(int idUser) {
		User user= null;
		 
	     try {
	        	conn= dataSource.getConnection();
	              cs = conn.prepareCall("{call userGetById(?)}");
	              cs.setInt(1, idUser);
	              cs.execute();
	             ResultSet rs = cs.executeQuery();
	             
	                while (rs.next()) {
	                	user = new User();
	                	user.setIdUser(rs.getInt("IdUser"));
	                	user.setName(rs.getString("Name"));
	                	user.setEmail(rs.getString("Email"));
	                }
	                rs.close();
	        } catch (SQLException e) {
	            System.err.println("SQLException: " + e.getMessage());
	        }
	        finally {
	            if (cs != null) {
	                try {
	                	cs.close();
	                } catch (SQLException e) {
	                    System.err.println("SQLException: " + e.getMessage());
	                }
	            }
	            
	            try {
					if (!this.conn.isClosed()){
						this.conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} 
	        }
	       
	    return user;
	}
	
	public   List <User> userGetAll() {
		List<User> users = new ArrayList<User>();
		User user= null;
		 
	     try {
	        	conn= dataSource.getConnection();
	              cs = conn.prepareCall("{call userGetAll}");
	             ResultSet rs = cs.executeQuery();
	             
	                while (rs.next()) {
	                	user = new User();
	                	user.setIdUser(rs.getInt("IdUser"));
	                	user.setName(rs.getString("Name"));
	                	user.setEmail(rs.getString("Email"));
	                	users.add(user);
	                }
	                rs.close();
	        } catch (SQLException e) {
	            System.err.println("SQLException: " + e.getMessage());
	        }
	        finally {
	            if (cs != null) {
	                try {
	                	cs.close();
	                } catch (SQLException e) {
	                    System.err.println("SQLException: " + e.getMessage());
	                }
	            }
	            
	            try {
					if (!this.conn.isClosed()){
						this.conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} 
	        }
	       
	        return users;
	    }

	
	public void insert(User u) {
		try {
        	conn= dataSource.getConnection();
              cs = conn.prepareCall("{call userInsert(?,?)}");
              cs.setString(1, u.getName());
              cs.setString(2, u.getEmail());
              cs.execute();
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        finally {
            if (cs != null) {
                try {
                	cs.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            
            try {
				if (!this.conn.isClosed()){
					this.conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
        }
	}
 
	public void delete(int idUser) {
	     try {
	        	conn= dataSource.getConnection();
	              cs = conn.prepareCall("{call userDelete(?)}");
	              cs.setInt(1, idUser);
	              cs.execute();
	        } catch (SQLException e) {
	            System.err.println("SQLException: " + e.getMessage());
	        }
	        finally {
	            if (cs != null) {
	                try {
	                	cs.close();
	                } catch (SQLException e) {
	                    System.err.println("SQLException: " + e.getMessage());
	                }
	            }
	            
	            try {
					if (!this.conn.isClosed()){
						this.conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} 
	        }
	}
 
	public void update(User u) {
		try {
        	conn= dataSource.getConnection();
              cs = conn.prepareCall("{call userUpdate(?,?,?)}");
              cs.setInt(1, u.getIdUser());
              cs.setString(2, u.getName());
              cs.setString(3, u.getEmail());
              cs.execute();
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        finally {
            if (cs != null) {
                try {
                	cs.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            
            try {
				if (!this.conn.isClosed()){
					this.conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
        }
		
	}
 
	

 
}
