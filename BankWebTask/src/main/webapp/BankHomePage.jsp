<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*" import="BankWebTask.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank Home Page</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<style>
body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 50vh;
	margin: 0;
}

.card-container {
	width: 700px;
	max-width: 1000px;
	padding: 20px;
}

.card {
	margin: auto; /* Add this to center the card horizontally */
	height: 50%;
	text-align: center;
}

.card-title {
	font-size: 45px;
}

.card-subtitle {
	font-size: 35px;
}
/* Increase the font size for the display button */
.btn-primary {
	font-size: 25px;
}

td {
	font-size: 25px;
	font-weight: bold;
}
</style>
</head>
<body>
	<%!private Connection con = null;
	private PreparedStatement prepare = null;
	int id = -1;
	int balance = -1;
	String name, address, phoneNumber;
	%>
	<%
	//String user = request.getParameter("username");
	String user = "user01";
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    String url = "jdbc:mysql://localhost:3306/testDB?useSSL=false";
	    con = DriverManager.getConnection(url, "root", "password123");
	    if (con == null) {
	        System.out.println("Connection Failed");
	    } else {
	        System.out.println("Database MySQL connected");
	    }
	} catch (ClassNotFoundException | SQLException e) {
	    e.printStackTrace();
	}

	try {
	    String query = "Select ID from logIn Where user = ?";
	    prepare = con.prepareStatement(query);
	    prepare.setString(1, user);
	    ResultSet resultSet = prepare.executeQuery();
	    
	    while (resultSet.next()) {
	        id = resultSet.getInt("ID");
	    }
	    
	    if(id != -1) {
	        String info_query = "Select * from Bank Where userID = ?";
	        prepare = con.prepareStatement(info_query);
	        prepare.setInt(1, id);
	        ResultSet resultSet1 = prepare.executeQuery();
	        
	        while(resultSet1.next()) {
	            balance = resultSet1.getInt("balance");
	            name = resultSet1.getString("name");
	            address = resultSet1.getString("address");
	            phoneNumber = resultSet1.getString("phoneNumber");
	        }
	    }
	    System.out.println(id);
	} catch(SQLException e) {
	    e.printStackTrace();
	}

	%>
	<div class="card-container pt-5 mt-5">
		<div class="card mx-auto">
			<div class="card-body">
				<h2 class="card-title">Account Display</h2>
				<h3 class="card-subtitle mb-3 text-muted">Successfully Update
					DB</h3>
				<form action="Eregister.jsp" method="post">
					<table class="table text-center">
						<tr>
							<td>Your account balance: <%= balance %></td>
						</tr>
					</table>
					<input type="submit" value="Admin"
								class="btn btn-primary">
				</form>
			</div>
		</div>
	</div>
</body>
</html>