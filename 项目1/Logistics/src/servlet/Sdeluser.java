package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	/**
	 * ���ߣ��θ�
	 * ������ڣ�2011-7-21
	 * ģ�鹦�ܣ�ɾ���û��Լ������
	 */
public class Sdeluser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�����ַ����͡�
		request.setCharacterEncoding("utf-8");
		//�������ݿ�
		String strClass = "com.mysql.jdbc.Driver";
		String strUrl = "jdbc:mysql://localhost:3306/logistics";
		String strUser = "songge";
		String strPwd = "123456";
		
		try {
			Class.forName(strClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conn = null;
		Statement st = null;
		//ִ������ɾ����sql��䡣
		try {
			conn = DriverManager.getConnection(strUrl,strUser,strPwd);
			st = conn.createStatement();
			//ɾ��goodlist�еĻ���
			st.executeUpdate("delete from goodslist where UserName='"+ new String(request.getParameter("sun").getBytes("ISO8859-1"),"utf-8")+"' ");
			//ɾ��UID��Ӧ���û�
			st.execute("delete from manager where UID='"+ request.getParameter("id")+"' ");
			//��ת����ʾҳ��ĺ�̨
			request.getRequestDispatcher("Ssuser").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ͷ���Դ
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doGet(request,response);
	}

}
