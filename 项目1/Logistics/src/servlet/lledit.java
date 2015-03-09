package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javabean.VeInfo;
public class lledit extends HttpServlet {

	/*
	作者：李柳依
	时间：2011年7月20日
	模块功能：车辆管理系统*/	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		//此页面的业务逻辑完成的是编辑数据库中的数据。
		request.setCharacterEncoding("utf-8");
		//创建javabean对象。
		VeInfo info = new VeInfo();
		info.setVhcLcs(request.getParameter("vl"));
		info.setVhcForm(request.getParameter("vf"));
		info.setOilType(request.getParameter("ot"));
		//考虑得到的传来数据是字符串，要强制转换成float型。
		info.setOilCpt(Float.parseFloat(request.getParameter("oc")));
		info.setLoadCpt(Float.parseFloat(request.getParameter("lc")));
		info.setVhcType(request.getParameter("vt"));
		//考虑得到的传来数据是字符串，要强制转换成Bool型。
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
		Statement st =null;
		
		try {

			//执行sql更新语句。
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();
			String s="update vehicle set VhcForm='"+info.getVhcForm()+"',OilType='"+info.getOilType()+"',OilCpt="+info.getOilCpt()+",LoadCpt="+ info.getLoadCpt()+",VhcType='"+info.getVhcType()+"',VhcSpc="+info.isVhcSpc()+",VhcRmk='"+ info.getVhcRmk()+"' where VhcLcs='"+info.getVhcLcs()+"';";
			//i是这条sql语句执行后影响的记录条数。
			int i=st.executeUpdate(s);		
			//成功和失败将会跳转到不同页面。
			if(i==1){				
				
				request.getRequestDispatcher("/vehicle/chansuc.jsp").forward(request, response);
			}else{
				
				request.getRequestDispatcher("/vehicle/chanfail.jsp").forward(request, response);
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			//关闭相应的资源。
			try {
				st.close();
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
	
}

