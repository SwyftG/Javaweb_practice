/*
作者：李唯
时间：2011年7月20日
模块功能：货物管理系统*/
package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javabean.goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class lvsearch extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		doPost(request,response);				
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://192.168.1.31/logistics";
		String strUser = "hd";
		String strPwd = "000000";
		
	
		try {
			Class.forName(strClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn =null;
		Statement st =null;
		// 盛放查询结果的结果集
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();
			String sql =null;		
			
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			// Statement对象来执行sql语句。
			st = conn.createStatement();	
			// 执行查询
			rs = st.executeQuery("select * from goods;");
			HttpSession session = request.getSession();
			//创建list对象，获取该司机的此项任务的详细信息。
			List list = new ArrayList();
			
				while(rs.next()){
						goods goods = new goods();
						goods.setGoods_ID(rs.getString("GdID"));
						goods.setGoods_Type(rs.getString("GdType"));
						goods.setGoods_Weight(rs.getString("GdWeight"));
						goods.setGoods_Place(rs.getString("GyName"));
						goods.setDanger(rs.getString("GdDanger"));
						goods.setMsg(rs.getString("GdRmk"));
						goods.setGoods_Status(rs.getString("GdStatus"));
						list.add(goods);
				}
				
				session.setAttribute("lvUL", list);
				response.sendRedirect(request.getContextPath()+"/goods/Goods.jsp");
			
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			try {
				if(rs!=null)rs.close();
			
			}catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			try {
				if(st!=null)st.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			try {
				if(conn!=null)conn.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}

		
		}
	}
}

