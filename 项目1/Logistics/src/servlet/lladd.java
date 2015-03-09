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
	���ߣ�������
	ʱ�䣺2011��7��20��
	ģ�鹦�ܣ���������ϵͳ*/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����javabean�������ڴ��ǰ̨��������ݣ�Ȼ�����Щ���ݼӵ����ݿ��С�
		VeInfo info = new VeInfo();
	
		info.setVhcLcs(request.getParameter("vl"));
		info.setVhcForm(request.getParameter("vf"));
		info.setOilType(request.getParameter("ot"));
		info.setOilCpt(Float.parseFloat(request.getParameter("oc")));
		info.setLoadCpt(Float.parseFloat(request.getParameter("lc")));
		info.setVhcType(request.getParameter("vt"));
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
		PreparedStatement ps = null;
		
		try {
			//ִ��sql�����䡣
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			ps =conn.prepareStatement("insert into vehicle(VhcLcs,VhcForm,OilType,OilCpt,LoadCpt,VhcType,VhcSpc,VhcRmk) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, info.getVhcLcs());
			ps.setString(2, info.getVhcForm());
			//���ڴ�javabean�õ��������������ַ������Ǽӵ����ݿ�����ݽ��������룬����һ���ַ�ת����
			ps.setString(3, new String(info.getOilType().getBytes("ISO8859-1"),"utf-8"));
			ps.setDouble(4, info.getOilCpt());
			ps.setDouble(5, info.getLoadCpt());
			ps.setString(6, new String(info.getVhcType().getBytes("ISO8859-1"),"utf-8"));
			ps.setBoolean(7, info.isVhcSpc());
			ps.setString(8, info.getVhcLcs());
			//i������sql���ִ�к�Ӱ��ļ�¼������
			int i= ps.executeUpdate();				
			HttpSession session = request.getSession();			
			//����޸ĳɹ�����ת��addsucҳ�棬ʧ������ת��addfailҳ�档
			if(i==1){
				request.getRequestDispatcher("/vehicle/addsuc.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/vehicle/addfail.jsp").forward(request, response);
			}
			
			
		
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			//�ر���Ӧ��Դ
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
