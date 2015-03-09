/*
���ߣ����ν�
ʱ�䣺2011��7��20��
ģ�鹦�ܣ����˵��Ȱ������
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
		//����javabean�������ڴ��ǰ̨��������ݣ�Ȼ�����Щ���ݼӵ����ݿ��С�
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
		
		//�������ݿ�
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
			//���ڴ�javabean�õ��������������ַ������Ǽӵ����ݿ�����ݽ��������룬����һ���ַ�ת����
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
				//�ر���Դ
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

