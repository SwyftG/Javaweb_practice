/*
���ߣ���Ψ
ʱ�䣺2011��7��20��
ģ�鹦�ܣ��������ϵͳ
*/

package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javabean.lvg;

public class lvgyd extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�������ݿ⡣
		
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://192.168.1.31/logistics";
		String strUser = "hd";
		String strPwd = "000000";
		// ���������ࡣ
		try {
			Class.forName(strClass);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
		Connection conn =null;
		Statement st =null;
		
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		try {
			
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();
			
			//��ѯ�����غ�Ŀ�ĵء�
			rs3 = st.executeQuery("select * from goodsyard;");
			List list3 = new ArrayList();
	
			while(rs3.next())
			{
				lvg user = new lvg();
				user.setAddress(rs3.getString("RegName")+rs3.getString("GyName"));
				
				list3.add(user);
			}
			HttpSession session=request.getSession();
			session.setAttribute("lvUL3", list3);
			
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			// �ر���Ӧ��Դ��
			try {
				
				rs3.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();    
			}
			
			try {
				st.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
			try {
				conn.close();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}	
		request.getRequestDispatcher("/goods/xinzeng.jsp").forward(request, response);
	}
		
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
		
	}
}
