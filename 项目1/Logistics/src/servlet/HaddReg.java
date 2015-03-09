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
 * ���ߣ��ƴ�
 * ������ڣ�2011��7��20��
 * ���ܣ�ִ��������Ϣ��ӹ���
 */
public class HaddReg extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//ǰ̨��ֵ
		Region region=new Region();	
		region.setRegionname(request.getParameter("v1"));
		region.setRemarks(request.getParameter("v2"));
		//�������ݿ�
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://192.168.1.31:3306/logistics";
		String strUser = "hd";
		String strPwd="000000";
		//����������
		try {
			Class.forName(strClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn =null;
		PreparedStatement ps = null;
		try {
			 //���ݿ������ַ���
			 conn = DriverManager.getConnection(strCon,strUser,strPwd);
			 //ִ��������Ϣ����
			 ps =conn.prepareStatement("insert into region (RegName,RegRmk) values(?,?)");			
			 ps.setString(1, region.getRegionname());
			 ps.setString(2, region.getRemarks());
			 //��ӳɹ���ת���ɹ�ҳ��addsuc.jsp��������ת��ʧ��ҳ��addfail.jsp
			 int i= ps.executeUpdate();							
				if(i==1){
					request.getRequestDispatcher("/Destination/addsuc.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/Destination/addfail.jsp").forward(request, response);
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally{
				//�ر���Ӧ��Դ
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
