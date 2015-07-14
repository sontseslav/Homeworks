package ua.com.iteducate.java.basic.homework.l0016.shapes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class SaveToDB {

	private final String DB_CONNECTION ="jdbc:mysql://localhost/testdb";
	private final String DB_USER = "root";
	private final String DB_PASSWORD = "12345";
	private Connection conn = null;
	private Robot robot;
	private HashSet<Shape> shapes;
	
	public SaveToDB(Robot robot) {
		this.robot = robot;
	}

	private Connection getDBConnection(){
		try{
			conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		}catch(SQLException ex){
			ex.printStackTrace();
			return null;
		}
		return conn;
	}
	
	public void storeToDB() throws SQLException{
		if (conn == null) this.getDBConnection();
		if (conn == null){
			System.out.println("Fails to set connection");
			return;
		}
		try(Statement st = conn.createStatement()){
			st.executeUpdate("CREATE TABLE IF NOT EXISTS Shapes "
					+ "(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ " Shape VARCHAR(15),"
					+ " Square DOUBLE,"
					+ " Perimeter DOUBLE)");
		}
		conn.setAutoCommit(false);
		String query = "INSERT INTO Shapes (`Shape`,`Square`,`Perimeter`)"
				+ " VALUES(?,?,?)";
		shapes = robot.getShapes();
		try(PreparedStatement ps = conn.prepareStatement(query)){
			for(Shape shape : shapes){
				ps.setString(1, shape.getClass().getSimpleName());
				ps.setDouble(2, shape.calcS());
				ps.setDouble(3, shape.calcPerim());
				ps.executeUpdate();
			}
		}catch(SQLException ex){
			conn.rollback();
			ex.printStackTrace();
		}finally{
			conn.commit();
			conn.setAutoCommit(true);
			System.out.println("Shapes saved");
		}
	}
	
	public void showShapesInDB() throws SQLException{
		if (conn == null) this.getDBConnection();
		if (conn == null){
			System.out.println("Fails to set connection");
			return;
		}
		try(Statement st = conn.createStatement()){
			ResultSet rs = st.executeQuery("SELECT * FROM Shapes");
			ResultSetMetaData md = rs.getMetaData();
			for(int i = 0;i < md.getColumnCount();i++){
				System.out.print(md.getColumnName(i+1)+"\t\t\t");
			}
			System.out.println();
			while(rs.next()){
				for(int i = 0; i < md.getColumnCount();i++){
					System.out.print(rs.getString(i+1)+"\t\t\t");
				}
				System.out.println();
			}
		}
	}
}
