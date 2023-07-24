
package BankWebTask;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConfigInterface config = new Config();
    private Connection con = null;
    private PreparedStatement prepare = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		con = config.config();
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String action = request.getParameter("action");
		String bootstrapCSS = "<link\n" +
		        "\thref=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\"\n" +
		        "\trel=\"stylesheet\"\n" +
		        "\tintegrity=\"sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM\"\n" +
		        "\tcrossorigin=\"anonymous\">";

		String bootstrapJS = "<script\n" +
		        "\tsrc=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"\n" +
		        "\tintegrity=\"sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz\"\n" +
		        "\tcrossorigin=\"anonymous\"></script>";
		pw.println("<html><body>");
		pw.println(bootstrapCSS);
		pw.println(bootstrapJS);
		if(action.equals("Report By Day"))
		{
			String query = "SELECT * FROM transaction WHERE DAY(date) = 24;";		
			try
			{
				prepare = con.prepareStatement(query);
				ResultSet resultSet = prepare.executeQuery(query);
				pw.println("<div class='container mt-5'>");
				pw.println("<h1 class='text-center '>Display Transaction DAY 24</h1>");
				pw.println("<div class=\"table-responsive pt-3 \">");
				pw.println("<table class=\"table table-bordered table-hover table-dark table-striped mx-auto\">");
				pw.println("<thead><tr>"
				        + "<th scope=\"col\">Transaction ID</th>"
						+ "<th scope=\"col\">User ID</th>"
				        + "<th scope=\"col\">Transaction Type</th>"
				        + "<th scope=\"col\">Amount</th>"
				        + "<th scope=\"col\">Status</th>"
				        + "<th scope=\"col\">Date</th>"
				        + "</tr></thead>");
				pw.println("<tbody>"); // Added tbody tag to wrap the table body content
				while (resultSet.next()) {
				    int tid = resultSet.getInt("ID");
				    int uid = resultSet.getInt("userID");
				    String type = resultSet.getString("type");
				    int amount = resultSet.getInt("amount");
				    String status = resultSet.getString("status");
				    Date date = resultSet.getDate("date");

				    // Rows should be on the same line with all the columns
				    pw.println("<tr>"
				            + "<td>" + tid + "</td>"
				            + "<td>" + uid + "</td>"
				            + "<td>" + type + "</td>"
				            + "<td>" + amount + "</td>"
				            + "<td>" + status + "</td>"
				            + "<td>" + date + "</td>"
				            + "</tr>");
				}
				pw.println("</tbody>"); // Closed the tbody tag
				pw.println("</table>");
				pw.println("</div>");
				pw.println("</div>");
				pw.println("</body></html>");
			}catch(SQLException e)
			{
				
				e.printStackTrace();
			}
		}
		else if(action.equals("Report By Month"))
		{
			String query = "SELECT * FROM transaction WHERE MONTH(date) = 07;";		
			try
			{
				prepare = con.prepareStatement(query);
				ResultSet resultSet = prepare.executeQuery(query);
				pw.println("<div class='container mt-5'>");
				pw.println("<h1 class='text-center '>Display Transaction MONTH 07</h1>");
				pw.println("<div class=\"table-responsive pt-3 \">");
				pw.println("<table class=\"table table-bordered table-hover table-dark table-striped mx-auto\">");
				pw.println("<thead><tr>"
				        + "<th scope=\"col\">Transaction ID</th>"
						+ "<th scope=\"col\">User ID</th>"
				        + "<th scope=\"col\">Transaction Type</th>"
				        + "<th scope=\"col\">Amount</th>"
				        + "<th scope=\"col\">Status</th>"
				        + "<th scope=\"col\">Date</th>"
				        + "</tr></thead>");
				pw.println("<tbody>"); // Added tbody tag to wrap the table body content
				while (resultSet.next()) {
				    int tid = resultSet.getInt("ID");
				    int uid = resultSet.getInt("userID");
				    String type = resultSet.getString("type");
				    int amount = resultSet.getInt("amount");
				    String status = resultSet.getString("status");
				    Date date = resultSet.getDate("date");

				    // Rows should be on the same line with all the columns
				    pw.println("<tr>"
				            + "<td>" + tid + "</td>"
				            + "<td>" + uid + "</td>"
				            + "<td>" + type + "</td>"
				            + "<td>" + amount + "</td>"
				            + "<td>" + status + "</td>"
				            + "<td>" + date + "</td>"
				            + "</tr>");
				}
				pw.println("</tbody>"); // Closed the tbody tag
				pw.println("</table>");
				pw.println("</div>");
				pw.println("</div>");
				pw.println("</body></html>");
			}catch(SQLException e)
			{
				
				e.printStackTrace();
			}
		}
		else if(action.equals("Report By Year"))
		{
			String query = "SELECT * FROM transaction WHERE YEAR(date) = 2023;";		
			try
			{
				prepare = con.prepareStatement(query);
				ResultSet resultSet = prepare.executeQuery(query);
				pw.println("<div class='container mt-5'>");
				pw.println("<h1 class='text-center '>Display Transaction YEAR 2023</h1>");
				pw.println("<div class=\"table-responsive pt-3 \">");
				pw.println("<table class=\"table table-bordered table-hover table-dark table-striped mx-auto\">");
				pw.println("<thead><tr>"
				        + "<th scope=\"col\">Transaction ID</th>"
						+ "<th scope=\"col\">User ID</th>"
				        + "<th scope=\"col\">Transaction Type</th>"
				        + "<th scope=\"col\">Amount</th>"
				        + "<th scope=\"col\">Status</th>"
				        + "<th scope=\"col\">Date</th>"
				        + "</tr></thead>");
				pw.println("<tbody>"); // Added tbody tag to wrap the table body content
				while (resultSet.next()) {
				    int tid = resultSet.getInt("ID");
				    int uid = resultSet.getInt("userID");
				    String type = resultSet.getString("type");
				    int amount = resultSet.getInt("amount");
				    String status = resultSet.getString("status");
				    Date date = resultSet.getDate("date");

				    // Rows should be on the same line with all the columns
				    pw.println("<tr>"
				            + "<td>" + tid + "</td>"
				            + "<td>" + uid + "</td>"
				            + "<td>" + type + "</td>"
				            + "<td>" + amount + "</td>"
				            + "<td>" + status + "</td>"
				            + "<td>" + date + "</td>"
				            + "</tr>");
				}
				pw.println("</tbody>"); // Closed the tbody tag
				pw.println("</table>");
				pw.println("</div>");
				pw.println("</div>");
				pw.println("</body></html>");
			}catch(SQLException e)
			{
				
				e.printStackTrace();
			}
		}
	}

}
