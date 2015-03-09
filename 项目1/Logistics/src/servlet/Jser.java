/*
作者：刘嘉杰
时间：2011年7月20日
模块功能：货运调度安排
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
import javabean.gdInfo;

public class Jser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//连接数据库。
		
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://192.168.1.31/logistics";
		String strUser = "hd";
		String strPwd = "000000";
		// 加载驱动类。
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
			
			//查询所有的司机姓名。
			rs1 = st.executeQuery("select Username from manager where UserPower='司机';");
			List list1 = new ArrayList();
	
			while(rs1.next())
			{
				gdInfo user = new gdInfo();
				user.setUserName(rs1.getString("UserName"));
				list1.add(user);
			}
			HttpSession session = request.getSession();
			session.setAttribute("UL1", list1);			
			
			//查询所有的车辆牌照
			rs2 = st.executeQuery("select VhcLcs from vehicle;");
			List list2 = new ArrayList();			
			while(rs2.next())
			{
				gdInfo user = new gdInfo();
				user.setVhcLcs(rs2.getString("VhcLcs"));
				list2.add(user);
			}
			session.setAttribute("UL2", list2);
			
			//查询出发地和目的地。
			rs3 = st.executeQuery("select * from goodsyard;");
			List list3 = new ArrayList();
	
			while(rs3.next())
			{
				gdInfo user = new gdInfo();
				user.setSGyName(rs3.getString("RegName")+rs3.getString("GyName"));
				user.setDGyName(rs3.getString("RegName")+rs3.getString("GyName"));
				list3.add(user);
			}
			session.setAttribute("UL3", list3);
			
			//查询货号
			rs4 = st.executeQuery("select GdID from goods;");
			List list4 = new ArrayList();
	
			while(rs4.next())
			{
				gdInfo user = new gdInfo();
				user.setGdID(rs4.getString("GdID"));
				list4.add(user);
			}
			session.setAttribute("UL4", list4);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			// 关闭相应资源。
			try {
				rs1.close();
				rs2.close();
				rs3.close();
				rs4.close();
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
		request.getRequestDispatcher("/goodslist/display.jsp").forward(request, response);
	}
		
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
		
	}
}
