
/*
作者：李唯
时间：2011年7月20日
模块功能：货物管理系统*/
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javabean.goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class lvedit extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		// 驱动类的名称
		String strClass = "com.mysql.jdbc.Driver";
		// 数据库连接字符串
		String strUrl = "jdbc:mysql://192.168.1.31/logistics";
		String strUser = "hd";
		String strPwd = "000000";
		
		Connection conn = null;
		Statement st = null;
	
		try {
			Class.forName(strClass);
			// 数据库连接对象。
			conn = DriverManager.getConnection(strUrl,strUser,strPwd);
			// Statement对象来执行sql语句。
			st = conn.createStatement();
	
			goods goods2=new goods();	
			goods2.setGoods_ID(request.getParameter("goods_ID"));
			goods2.setGoods_Type(request.getParameter("goods_Type"));
			goods2.setGoods_Weight(request.getParameter("goods_Weight"));
			goods2.setGoods_Place(request.getParameter("goods_Place"));
			goods2.setDanger(request.getParameter("danger"));
			goods2.setMsg(request.getParameter("msg"));
			goods2.setGoods_Status(request.getParameter("goods_Status"));
	
			PreparedStatement pst=conn.prepareStatement("update goods set GdType='"+goods2.getGoods_Type()+"',GdWeight='"+goods2.getGoods_Weight()+"', GyName='"+goods2.getGoods_Place()+"',GdDanger='"+goods2.getDanger()+"' ,GdStatus='"+goods2.getGoods_Status()+"' ,GdRmk='"+goods2.getMsg()+"' where GdID='"+goods2.getGoods_ID()+"'; ");
			pst.executeUpdate();
			response.sendRedirect(request.getContextPath()+"/goods/blank.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭相应的资源。
		
				
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}
				
			
		
		
		
		
		
		
		
		
		
		
		
		

		
	}

}
