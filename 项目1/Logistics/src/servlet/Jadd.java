/*
作者：刘嘉杰
时间：2011年7月20日
模块功能：货运调度安排添加
*/

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import javabean.gdInfo; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Jadd extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创建javabean对象，用于存放前台输入的数据，然后把这些数据加到数据库中。
		gdInfo info = new gdInfo();
	
		info.setUserName(request.getParameter("sj"));
		info.setVhcLcs(request.getParameter("vl"));
		info.setSGyName(request.getParameter("ot"));
		info.setDGyName(request.getParameter("lc"));
		info.setGdID(request.getParameter("oc"));
		info.setGLKm(request.getParameter("km"));
		info.setGLStime(request.getParameter("tm1")+"-"+request.getParameter("tm2")+"-"+request.getParameter("tm3"));
		info.setGLDtime(request.getParameter("tm4")+"-"+request.getParameter("tm5")+"-"+request.getParameter("tm6"));
		info.setGlStatus(request.getParameter("status"));
		
		//连接数据库
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
		PreparedStatement ps = null;
		
		try {
			//由于从javabean得到的数据是中文字符，考虑加到数据库的数据将会是乱码，做了一下字符转换。
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			ps =conn.prepareStatement("insert into goodslist (GLID,UserName,VhcLcs,SGyName,DGyName,GdID,GLKm,GLStime,GLDtime,GlStatus) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, info.getGLID());
			ps.setString(2, new String(info.getUserName().getBytes("ISO8859-1"),"utf-8"));
			ps.setString(3, new String(info.getVhcLcs().getBytes("ISO8859-1"),"utf-8"));
			ps.setString(4, new String(info.getSGyName().getBytes("ISO8859-1"),"utf-8"));
			ps.setString(5, new String(info.getDGyName().getBytes("ISO8859-1"),"utf-8"));
			ps.setString(6, info.getGdID());
			ps.setString(7,info.getGLKm());
			ps.setString(8, info.getGLStime());
			ps.setString(9, info.getGLDtime());
			ps.setString(10, new String(info.getGlStatus().getBytes("ISO8859-1"),"utf-8"));
			
			int i= ps.executeUpdate();							
			response.sendRedirect(request.getContextPath()+"/goodslist/found.jsp");
			
			
		
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			try {
				//关闭资源
				ps.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			try {
				conn.close();
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

