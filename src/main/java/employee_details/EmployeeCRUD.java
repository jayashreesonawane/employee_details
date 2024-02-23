package employee_details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import employee_details.Employee;

public class EmployeeCRUD {

public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servket", "root","root");
		return connection;
	}
	
	public int signUp(Employee employee) throws ClassNotFoundException, SQLException
	{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setDouble(3, employee.getSalary());
		preparedStatement.setLong(4, employee.getPhone());
		preparedStatement.setString(5, employee.getAddress());
		preparedStatement.setString(6, employee.getEmail());
		preparedStatement.setString(7, employee.getPassword());
		
		int count = preparedStatement.executeUpdate();
		connection.close();
		return count;
		
	}
	
	public int updateEmployee(Employee employee) throws ClassNotFoundException, SQLException
	{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE EMPLOYEE SET NAME=?,SALARY=?,PHONE=?,ADDRESS=?,EMAIL=?,PASSWORD=?");
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setDouble(2, employee.getSalary());
		preparedStatement.setLong(3, employee.getPhone());
		preparedStatement.setString(4, employee.getAddress());
		preparedStatement.setString(5, employee.getEmail());
		preparedStatement.setString(6, employee.getPassword());
		
		int count = preparedStatement.executeUpdate();
		connection.close();
		return count;
		
	}
	
	public String getEmployee(String email) throws ClassNotFoundException, SQLException
	{
		Connection connection= getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMAIL=?");
		preparedStatement.setString(1, email);
		
		ResultSet resultset = preparedStatement.executeQuery();
		String password = null;
		while (resultset.next()) 
		{
			password = resultset.getString("password");	
		}
		connection.close();
		return password;
	}
}

