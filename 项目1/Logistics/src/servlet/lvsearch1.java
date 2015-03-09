/*
作者：李唯
时间：2011年7月20日
模块功能：货物管理系统*/
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

import javabean.goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class lvsearch1 extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		// 驱动类的名称
		String strClass = "com.mysql.jdbc.Driver";
		// 数据库连接字符串
		String strCon = "jdbc:mysql://192.168.1.31/logistics";
		String strUser = "hd";
		String strPwd="000000";
		goods goods1=new goods();
		goods1.setGoods_Type(request.getParameter("goods_Type"));
		goods1.setGoods_Status(request.getParameter("goods_Status"));
		
		
		// 定义一个集合对象。。。
		List list = new ArrayList();
		// 加载驱动类
			try {
				Class.forName(strClass);
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			Connection conn =null;
			Statement st =null;
			ResultSet rs = null;
			try {
				// 数据库连接对象。
				 conn = DriverManager.getConnection(strCon,strUser,strPwd);
				// Statement对象来执行sql语句。
				 st = conn.createStatement();
				 
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		 
				// 盛放查询结果的结果集
				// 执行查询
				
				 String sql =null;
				 sql = "select * from goods where GdStatus='未装运';";
				 rs = st.executeQuery(sql);
					if(rs!=null){
						while(rs.next())
						{	
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
						HttpSession session = request.getSession();
						session.setAttribute("UL", list);}
						
						
						
					
					} catch (SQLException e) {
						
						e.printStackTrace();
					}finally{
						// 关闭相应资源
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
					 request.getRequestDispatcher("/goods/chazhao.jsp").forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		doPost(request,response);
	}
}
