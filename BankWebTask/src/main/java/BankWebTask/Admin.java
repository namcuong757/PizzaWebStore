package BankWebTask;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin extends Person{
	public String admin_user;
	public String admin_pass;
	private ConfigInterface config = new Config();
    private Connection con = null;
    private PreparedStatement prepare = null;
	public Admin()
	{
		super();
		admin_user = "admin";
		admin_pass = "222";
		
	}
}
