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

import javabean.Goodsyard;
/**
 * 作者： 黄翠
 * 完成日期：2011年7月20日
 * 页面功能：执行货场信息修改功能
 */
public class HeditGyd extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//前台传值
		Goodsyard gyd = new Goodsyard();
		gyd.setGoodsyardname(request.getParameter("b1"));
		gyd.setRegion(request.getParameter("b2"));
		gyd.setAddress(request.getParameter("b3"));		
		gyd.setArea(Integer.parseInt(request.getParameter("b4")));
		gyd.setIndoor(request.getParameter("b5"));
		gyd.setDanger(request.getParameter("b6"));
		gyd.setRemarks(request.getParameter("b7"));
		//连接数据库
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://192.168.1.31:3306/logistics";
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
			//Ststement执行sql语句
			st = conn.createStatement();
			String s="update goodsyard set RegName='"+gyd.getRegion()+"',GyAddress='"+gyd.getAddress()+"',GyArea='"+gyd.getArea()+"',GyIndoor='"+gyd.getIndoor()+"',GyDanger='"+gyd.getDanger()+"',GyRmk='"+gyd.getRemarks()+"' where GyName='"+gyd.getGoodsyardname()+"';";
			//修改成功跳转到成功页面editsuc2.jsp，否则跳转到失败页面editfail2.jsp
			int i=st.executeUpdate(s);		
			if(i==1){								
				request.getRequestDispatcher("/Destination/editsuc2.jsp").forward(request, response);
			}else{				
				request.getRequestDispatcher("/Destination/editfail2.jsp").forward(request, response);
			}
			
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
	
	}


