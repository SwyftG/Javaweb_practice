/*
���ߣ����ν�
ʱ�䣺2011��7��20��
ģ�鹦�ܣ����˵��Ȱ���
*/

package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javabean.VeInfo;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;
public class Jveh extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request,response);				
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//����javabean�������ڴ��ǰ̨��������ݣ�Ȼ�����Щ���ݼӵ����ݿ��С�
		VeInfo info = new VeInfo();
		
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
		Statement st =null;
		ResultSet rs = null;
		
		try {
			
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();
			String sql ="select * from vehicle where VhcLcs='"+request.getParameter("jvi")+"'";		
			rs = st.executeQuery(sql);	
			
			//��ȡ��ǰ̨��ʾ�Ĳ�ѯ���
			HttpSession session = request.getSession();
			List list = new ArrayList();
			
				while(rs.next()){
		
						VeInfo info2=new VeInfo();
						info2.setVhcForm(rs.getString("VhcForm"));
						info2.setOilType(rs.getString("OilType"));
						info2.setOilCpt(rs.getFloat("OilCpt"));
						info2.setVhcType(rs.getString("VhcType"));
						info2.setVhcSpc(rs.getBoolean("VhcSpc"));
						info2.setVhcLcs(rs.getString("VhcLcs"));
						info2.setLoadCpt(rs.getFloat("LoadCpt"));
						list.add(info2);	
				}
				session.setAttribute("lvf", list);	
			
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			try {
				//�ر���Դ
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

			request.getRequestDispatcher("/goodslist/JveInfo.jsp").forward(request, response);
		}
	}
}

