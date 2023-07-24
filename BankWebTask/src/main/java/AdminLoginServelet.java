import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServelet
 */
@WebServlet("/AdminLoginServelet")
public class AdminLoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConfigInterface config = new Config();
    private Connection con = config.config();
    private PreparedStatement prepare = null;
    private ResultSet rs = null;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServelet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String admin = request.getParameter("adminUserName");
		String password = request.getParameter("password");
		String adminDb = null, passwordDb = null;
		String user_query = "Select admin,password from adminLogIn;";
		try 
		{
			prepare = con.prepareStatement(user_query);
			rs = prepare.executeQuery();
			while(rs.next())
			{
				adminDb = rs.getString("user");
				passwordDb = rs.getString("password");

				if(admin.equals(adminDb) && password.equals(passwordDb))
				{
					response.sendRedirect("http://localhost:8080/Whasapps/Eregister.");
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
