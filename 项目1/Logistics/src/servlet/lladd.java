package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import javabean.VeInfo;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class lladd extends HttpServlet {

	/*
	作者：李柳依
	时间：2011年7月20日
	模块功能：车辆管理系统*/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创建javabean对象，用于存放前台输入的数据，然后把这些数据加到数据库中。
		VeInfo info = new VeInfo();
	
		info.setVhcLcs(request.getParameter("vl"));
		info.setVhcForm(request.getParameter("vf"));
		info.setOilType(request.getParameter("ot"));
		info.setOilCpt(Float.parseFloat(request.getParameter("oc")));
		info.setLoadCpt(Float.parseFloat(request.getParameter("lc")));
		info.setVhcType(request.getParameter("vt"));
		info.setVhcSpc(Boolean.getBoolean(request.getParameter("vs")));
		info.setVhcRmk(request.getParameter("vr"));
		//连接数据库。
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
			//执行sql添加语句。
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			ps =conn.prepareStatement("insert into vehicle(VhcLcs,VhcForm,OilType,OilCpt,LoadCpt,VhcType,VhcSpc,VhcRmk) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, info.getVhcLcs());
			ps.setString(2, info.getVhcForm());
			//由于从javabean得到的数据是中文字符，考虑加到数据库的数据将会是乱码，做了一下字符转换。
			ps.setString(3, new String(info.getOilType().getBytes("ISO8859-1"),"utf-8"));
			ps.setDouble(4, info.getOilCpt());
			ps.setDouble(5, info.getLoadCpt());
			ps.setString(6, new String(info.getVhcType().getBytes("ISO8859-1"),"utf-8"));
			ps.setBoolean(7, info.isVhcSpc());
			ps.setString(8, info.getVhcLcs());
			//i是这条sql语句执行后影响的记录条数。
			int i= ps.executeUpdate();				
			HttpSession session = request.getSession();			
			//如果修改成功，跳转到addsuc页面，失败则跳转到addfail页面。
			if(i==1){
				request.getRequestDispatcher("/vehicle/addsuc.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/vehicle/addfail.jsp").forward(request, response);
			}
			
			
		
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			//关闭相应资源
			try {
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
