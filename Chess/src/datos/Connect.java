package datos;

import java.sql.*;

public class Connect {

		protected Connection connect;
		protected Statement statement;
	
			public Connect () {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/ajedrez";
					String user = "root";
					String password = "administrador";
					connect= DriverManager.getConnection(url, user, password);
					statement = connect.createStatement();
				} catch (Exception e) {
				}
			}

			public void registrar(String insert) {
				//validar usuario
				try {
					statement = connect.createStatement();
					statement.execute(insert);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			public boolean validarUsuario(String textField_Usuario) {
				boolean validar = true;
				try {
					String usuario=textField_Usuario;
					String sql = "select Usuario from usuarios where usuario='"+ usuario +"'";
					statement = connect.createStatement();
					ResultSet rs = statement.executeQuery(sql);
					if(!(rs.next())) {
						validar = false;
					}
				}
				catch (Exception e) {
				}
				return validar;
			}
			
			public boolean validarUsuarioContraseña(String textField_Usuario, String passwordField) {
				boolean validar = true;
				try {
					String usuario=textField_Usuario;
					String contraseña=passwordField;
					String sql = "select * from usuarios where usuario='"+ usuario +"' and contraseña=MD5('"+contraseña+"')";
					statement = connect.createStatement();
					ResultSet rs = statement.executeQuery(sql);
					if(!(rs.next())) {
						validar = false;
					}
				}
				catch (Exception e) {
				}
				return validar;
			}
}