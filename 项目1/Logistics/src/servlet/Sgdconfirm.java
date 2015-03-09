package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javabean.drive;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
作者：李柳依
时间：2011年7月20日
模块功能：车辆管理系统*/

public class Sgdconfirm extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//此后台完成的业务逻辑是提供任务确认，修改数据库中货单状态。
		request.setCharacterEncoding("utf-8");
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
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();
			
			HttpSession session= request.getSession();
			//创建list对象，获取该司机的此项任务的详细信息。
			List list  = (List)session.getAttribute("llDL"); 
			drive dv1=new drive();
			if(list!= null){
    	   		dv1 = (drive)list.get(0);
			}
			
			if(dv1!=null){
				
				String g =dv1.getGlstatus();	
				int id=dv1.getGlId();	
				String sql =null;		
				//如果是‘已分配’的状态，货单确认以后将数据库中货单状态改为'已确认'，如果是‘已确认’的状态，货单确认以后将其状态改为'已送达'
				if("已分配".equals(g)){
					sql="update goodslist join goods on goodslist.GdID=goods.GdID set GlStatus='已确认' where GLId='"+id+"'";
				}else{
					
					sql="update goodslist join goods on goodslist.GdID=goods.GdID set GlStatus='已送达' where GLId='"+id+"'";
				}
				//执行sql语句,i是执行sql语句后影响的记录条数。
				int i=st.executeUpdate(sql);					
				//执行sql语句成功或失败将跳转到不同的页面。
				if(i==1){
					
					request.getRequestDispatcher("/UserLogin/consuc.jsp").forward(request, response);
				}else{
					
					request.getRequestDispatcher("/UserLogin/confail.jsp").forward(request, response);
				}
				
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			//关闭相应的资源。
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
