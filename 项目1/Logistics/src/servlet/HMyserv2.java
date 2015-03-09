package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.Region;
/**
 * 作者： 黄翠
 * 完成日期：2011年7月20日
 * 页面功能：执行区域信息查找功能
 */
public class HMyserv2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//前台传值
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://192.168.1.31:3306/logistics";
		String strUser = "hd";
		String strPwd="000000";
		//定义一个集合对象
		List list1 = new ArrayList();

			try {
				Class.forName(strClass);
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			Connection conn =null;
			Statement st =null;
			ResultSet rs = null;
			
			try {
				//数据库连接字符串
				 conn = DriverManager.getConnection(strCon,strUser,strPwd);
				 //Statement执行sql语句
				 st = conn.createStatement();
				 //执行区域信息查询
				 rs = st.executeQuery("select * from region");		 
				 while(rs.next())
					{	Region region=new Region();			    
						region.setRegionname( rs.getString("RegName") );
						list1.add(region);
					}
				 session.setAttribute("HUL", list1);
			} catch (SQLException e) {				
				e.printStackTrace();
			}finally{
				//关闭相应资源
				try {
					if(rs!=null)rs.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();    
				}
				
				try {
					if(st!=null)st.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				try {
					if(conn!=null)conn.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
			request.getRequestDispatcher("/Destination/veGyd.jsp").forward(request, response);
	}
	
	}


