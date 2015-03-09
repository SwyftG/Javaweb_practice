package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.Goodsyard;

/**
 * 作者：黄翠
 * 完成日期：2011年7月20日
 * 功能：执行货场信息添加功能
 */
public class HaddGyd extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//前台传值
		Goodsyard gyd = new Goodsyard();
		gyd.setGoodsyardname(request.getParameter("j1"));
		gyd.setRegion(request.getParameter("j2"));
		gyd.setAddress(request.getParameter("j3"));
		gyd.setArea(Integer.parseInt(request.getParameter("j4")));
		gyd.setIndoor(request.getParameter("j5"));
		gyd.setDanger(request.getParameter("j6"));
		gyd.setRemarks(request.getParameter("j7"));
		//连接数据库
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://localhost:3306/logistics";
		String strUser = "songge";
		String strPwd="123456";
		//加载驱动类
		try {
			Class.forName(strClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn =null;
		PreparedStatement ps = null;
		try {
			 //数据库连接字符串
			 conn = DriverManager.getConnection(strCon,strUser,strPwd);
			 //执行货场信息增加
			 ps =conn.prepareStatement("insert into goodsyard(GyName,RegName,GyAddress,GyArea,GyIndoor,GyDanger,GyRmk) values(?,?,?,?,?,?,?)");
			 ps.setString(1, gyd.getGoodsyardname());
			 ps.setString(2, gyd.getRegion());
			 ps.setString(3, gyd.getAddress());
			 ps.setInt(4, gyd.getArea());
			 ps.setString(5, gyd.getIndoor());
			 ps.setString(6, gyd.getDanger());
			 ps.setString(7, gyd.getRemarks());
			 //添加成功跳转到成功页面/addsuc2.jsp，否则跳转到失败页面addfail2.jsp
			 int i= ps.executeUpdate();				
			 HttpSession session = request.getSession();			
				if(i==1){
					request.getRequestDispatcher("/Destination/addsuc2.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/Destination/addfail2.jsp").forward(request, response);
				}
	
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally{
				//关闭相应资源
				try {
					if(ps!=null) ps.close();
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
