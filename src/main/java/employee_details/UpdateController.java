package employee_details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import employee_details.Employee;
import employee_details.EmployeeCRUD;

public class UpdateController extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		double salary = Double.parseDouble(req.getParameter("salary"));
		long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setSalary(salary);
		employee.setPhone(phone);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setPassword(password);

		EmployeeCRUD crud = new EmployeeCRUD();
		try {
			int count = crud.updateEmployee(employee);
			if (count != 0) {
				PrintWriter out = res.getWriter();
				out.print("Update Successful!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
		

