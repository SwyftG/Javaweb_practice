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

import javabean.Region;

/**
 * 作者：黄翠
 * 完成日期：2011年7月20日
 * 功能：执行区域信息添加功能
 */
public class HaddReg extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//前台传值
		Region region=new Region();	
		region.setRegionname(request.getParameter("v1"));
		region.setRemarks(request.getParameter("v2"));
		//连接数据库
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://192.168.1.31:3306/logistics";
		String strUser = "hd";
		String strPwd="000000";
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
			 //执行区域信息增加
			 ps =conn.prepareStatement("insert into region (RegName,RegRmk) values(?,?)");			
			 ps.setString(1, region.getRegionname());
			 ps.setString(2, region.getRemarks());
			 //添加成功跳转到成功页面addsuc.jsp，否则跳转到失败页面addfail.jsp
			 int i= ps.executeUpdate();							
				if(i==1){
					request.getRequestDispatcher("/Destination/addsuc.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/Destination/addfail.jsp").forward(request, response);
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
