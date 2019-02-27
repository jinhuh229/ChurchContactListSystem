package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginCheck
 */
@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String userID, userPassword;
	private Connection conn;
	private Statement stmt;
	private ResultSet resultSet;
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		
		response.setContentType("text/html; charset=euc-kr");

		userID=request.getParameter("id");
		userPassword=request.getParameter("pw");
		
		if(userID == null || userID =="" || userPassword == null || userPassword =="" ) {
			
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('ºóÄ­À» Ã¤¿öÁÖ½Ê½Ã¿À');");
			out.println("location='register.jsp';");
			out.println("</script>");
			
		}
		
		
		else {
		try {
			
			
				
			String sql = "select userID,userPassword from user where userID=? and userPassword=?";     
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "Wlsdud1964");			


			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userID);
			ps.setString(2, userPassword);

			resultSet = ps.executeQuery();
			
			
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("id", userID);
			httpSession.setAttribute("pw", userPassword);

			
			while (resultSet.next()) {
				PrintWriter out = response.getWriter();			
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Login Successful');");
				out.println("window.location='main.jsp';");
				out.println("</script>");
				
				return;
			}
			
			
			PrintWriter out = response.getWriter();			
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('User ID or Password wrong!');");
			out.println("window.location='index.html';");
			out.println("</script>");
			
			return;
				
			
			
			//response.sendRedirect("loginCheckResult.jsp");
			
		
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		}//else
		
		
	} //doPost
	}