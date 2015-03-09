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
	���ߣ�������
	ʱ�䣺2011��7��20��
	ģ�鹦�ܣ���������ϵͳ*/	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		//��ҳ���ҵ���߼���ɵ��Ǳ༭���ݿ��е����ݡ�
		request.setCharacterEncoding("utf-8");
		//����javabean����
		VeInfo info = new VeInfo();
		info.setVhcLcs(request.getParameter("vl"));
		info.setVhcForm(request.getParameter("vf"));
		info.setOilType(request.getParameter("ot"));
		//���ǵõ��Ĵ����������ַ�����Ҫǿ��ת����float�͡�
		info.setOilCpt(Float.parseFloat(request.getParameter("oc")));
		info.setLoadCpt(Float.parseFloat(request.getParameter("lc")));
		info.setVhcType(request.getParameter("vt"));
		//���ǵõ��Ĵ����������ַ�����Ҫǿ��ת����Bool�͡�
		info.setVhcSpc(Boolean.getBoolean(request.getParameter("vs")));
		info.setVhcRmk(request.getParameter("vr"));
		//�������ݿ⡣
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

			//ִ��sql������䡣
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();
			String s="update vehicle set VhcForm='"+info.getVhcForm()+"',OilType='"+info.getOilType()+"',OilCpt="+info.getOilCpt()+",LoadCpt="+ info.getLoadCpt()+",VhcType='"+info.getVhcType()+"',VhcSpc="+info.isVhcSpc()+",VhcRmk='"+ info.getVhcRmk()+"' where VhcLcs='"+info.getVhcLcs()+"';";
			//i������sql���ִ�к�Ӱ��ļ�¼������
			int i=st.executeUpdate(s);		
			//�ɹ���ʧ�ܽ�����ת����ͬҳ�档
			if(i==1){				
				
				request.getRequestDispatcher("/vehicle/chansuc.jsp").forward(request, response);
			}else{
				
				request.getRequestDispatcher("/vehicle/chanfail.jsp").forward(request, response);
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			//�ر���Ӧ����Դ��
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

