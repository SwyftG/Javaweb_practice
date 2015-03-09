package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.Region;
/**
 * 作者： 黄翠
 * 完成日期：2011年7月20日
 * 页面功能：执行区域信息删除功能
 */
public class HdelReg extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//前台传值
		Region region = new Region();
		region.setRegionname(request.getParameter("rg"));
		//连接数据库
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://192.168.1.31/logistics";
		String strUser = "hd";
		String strPwd = "000000";
		//加载驱动类
		try {
			Class.forName(strClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		Connection conn =null;
		Statement st =null;		
		try {
			//数据库连接字符串
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			//Statement执行sql语句
			st = conn.createStatement();
			String s1="delete from goodsyard where RegName='"+ new String(region.getRegionname().getBytes("ISO8859-1"),"utf-8")+"'";			
			String s2="delete from region where RegName='"+ new String(region.getRegionname().getBytes("ISO8859-1"),"utf-8")+"'";			
			st.executeUpdate(s1);
			st.executeUpdate(s2);			
			request.getRequestDispatcher("/Destination/blank.jsp").forward(request, response);			
		}catch (Exception e) {			
			e.printStackTrace();		
		}finally{
			//关闭相应资源
			try {
				if(st!=null) st.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			try {
				if(conn!=null) conn.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
