package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterCheck
 */
@WebServlet("/RegisterCheck")
public class RegisterCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String userID, userPassword, userName, userGroup, userBirthday, userStartDate;
	private Connection conn;
	private Statement stmt;
	private ResultSet resultSet;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCheck() {
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
		request.setCharacterEncoding("EUC-KR");
		
		response.setContentType("text/html; charset=euc-kr");
		
		

		userID=request.getParameter("id");
		userPassword=request.getParameter("pw");
		userName=request.getParameter("name");
		userGroup=request.getParameter("group");
		userBirthday=request.getParameter("birthday");
		userStartDate=request.getParameter("startDate");
		
	
		if(userID == null || userID =="" || userPassword == null || userPassword =="" || userName == null || userName =="" || userGroup == null || userGroup =="" || userBirthday == null || userBirthday =="") {
			
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('ºóÄ­À» Ã¤¿öÁÖ½Ê½Ã¿À');");
			out.println("location='register.jsp';");
			out.println("</script>");
			
		}
		
		
		else {
		try {
			
			
				
			String sql = "insert into user(userID, userPassword, userName, userGroup, userBirthday, userStartDate) values (?,?,?,?,?,?)";     
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "Wlsdud1964");			


			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userID);
			ps.setString(2, userPassword);
			ps.setString(3, userName);
			ps.setString(4, userGroup);
			ps.setString(5, userBirthday);
			ps.setString(6, userStartDate);
			ps.executeUpdate();
			
			
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("id", userID);
			httpSession.setAttribute("pw", userPassword);
			httpSession.setAttribute("name", userName);
			httpSession.setAttribute("group", userGroup);
			httpSession.setAttribute("birthday", userBirthday);
			httpSession.setAttribute("startDate", userStartDate);
			
			PrintWriter out = response.getWriter();			
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Register Successful');");
			out.println("window.location='index.html';");
			out.println("</script>");
				
			
			
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