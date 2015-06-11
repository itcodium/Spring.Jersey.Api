package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionDB {
    private String enlace;
    private String controlador;
    private String error;
    private String usuario;
    private String contrasenia;
    protected Connection cnn;

    public ConexionDB(){
        this.enlace = "jdbc:mariadb://localhost:3306/test";
        this.controlador = "org.mariadb.jdbc.Driver";
        this.error = " ";
        this.usuario = "root";
        this.contrasenia = "123123";
     
        
    }
    
    
    public void abrirConexion(){
        try{
            Class.forName(getControlador()).newInstance();
            cnn= DriverManager.getConnection(getEnlace(), getUsuario(), getContrasenia());
        }catch (Exception e){
            setError(e.getMessage());
            System.out.println("error al conectar " + getError());
        }
        
        if(cnn != null){
        	System.out.println("Conexion Realiazada Correctamete!");
        }	
    }
    
    public String getEnlace(){
    	return this.enlace;	
    }

    public String setEnlace(String pEnlace){
    	return this.enlace=pEnlace;	
    }
    
    public String getControlador(){
    	return this.controlador;	
    }
    
    public String setControlador(String pControlador){
    	return this.controlador=pControlador;	
    }
    
    public String getError(){
    	return this.error;	
    }
    
    public void setError(String pError){
    	this.error=pError;	
    }
    
    public String getUsuario(){
    	return this.usuario ;	
    }
    public String setUsuario(String pUsuario ){
    	return this.usuario=pUsuario ;	
    }    
    public String getContrasenia(){
    	return  this.contrasenia;	
    }
    
    public String setContrasenia(String pContrasenia){
    	return  this.contrasenia=pContrasenia;	
    }
    
    
    
    public void cerrarConexion(){
        try{
        	cnn.close();
        }catch(Exception e){
            setError(e.getMessage());
            System.out.println("error al conectar " + getError());
        }

    }

}


