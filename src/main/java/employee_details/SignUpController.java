package employee_details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee_details.Employee;
import employee_details.EmployeeCRUD;

public class SignUpController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("first_name");
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
			int count = crud.signUp(employee);
			if (count != 0) {
				PrintWriter out = resp.getWriter();
				out.print("Registration Successful!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
				dispatcher.forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}

