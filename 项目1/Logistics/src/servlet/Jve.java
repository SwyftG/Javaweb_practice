/*
���ߣ����ν�
ʱ�䣺2011��7��20��
ģ�鹦�ܣ����˵��Ȱ��Ų�ѯ
*/

package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javabean.gdInfo;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;
public class Jve extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		doPost(request,response);				
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		//����javabean�������ڴ��ǰ̨��������ݣ�Ȼ�����Щ���ݼӵ����ݿ��С�
		gdInfo info = new gdInfo();
		info.setGLID(request.getParameter("gi"));
		info.setSGyName(request.getParameter("ot"));
		info.setGlStatus(request.getParameter("vt"));
		
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
			String sql =null;		
			
			//��ѯ���ܵ��ж����
			if(!(("").equals(info.getGLID()))){
				
					if(info.getSGyName().equals("ȫ��")&&!(info.getGlStatus().equals("ȫ��"))){
						
						sql = "select * from goodslist where GLID="+Integer.parseInt(info.getGLID())+ " and GlStatus='"+info.getGlStatus()+"';";
					}
					else if(info.getGlStatus().equals("ȫ��")&&!(info.getSGyName().equals("ȫ��"))){
						
						sql = "select * from goodslist where GLID="+Integer.parseInt(info.getGLID())+ " and SGyName='"+info.getSGyName()+"';";	
					}
					else if(info.getGlStatus().equals("ȫ��")&&(info.getSGyName().equals("ȫ��"))){
						
						sql = "select * goodslist where GLID="+Integer.parseInt(info.getGLID())+";";
					}else{
						
						sql = "select * from goodslist where GLID="+Integer.parseInt(info.getGLID())+ " and SGyName='"+info.getSGyName()+ "' and GlStatus='"+info.getGlStatus()+"';";
					}
			}else{
				
				if(info.getSGyName().equals("ȫ��") && !(info.getGlStatus().equals("ȫ��"))){
					
					sql = "select * from goodslist where  GlStatus='"+info.getGlStatus()+"';";
				}
				else if(info.getGlStatus().equals("ȫ��") && !(info.getSGyName().equals("ȫ��"))){
					
					sql = "select * from goodslist where SGyName='"+info.getSGyName()+"';";	
				}
				else if(info.getGlStatus().equals("ȫ��") && (info.getSGyName().equals("ȫ��"))){
					
					sql = "select * from goodslist;";
				}else{
					
					sql = "select * from goodslist where SGyName='"+info.getSGyName()+"' and GlStatus='"+info.getGlStatus()+"';";
				}
			}
			
			//��ȡ��ǰ̨��ʾ�Ĳ�ѯ���
			rs = st.executeQuery(sql);					
			HttpSession session = request.getSession();
			List list = new ArrayList();
			while(rs.next()){
		 
						gdInfo info2=new gdInfo();
						info2.setGLID(rs.getString("GLID"));
						info2.setUserName(rs.getString("UserName"));
						info2.setVhcLcs(rs.getString("VhcLcs"));
						info2.setSGyName(rs.getString("SGyName"));
						info2.setDGyName(rs.getString("DGyName"));
						info2.setGdID(rs.getString("GdID"));
						info2.setGLKm(rs.getString("GLKm"));
						info2.setGLStime(rs.getString("GLStime"));
						info2.setGLDtime(rs.getString("GLDtime"));
						info2.setGlStatus(rs.getString("GlStatus"));
						list.add(info2);	
			}
			session.setAttribute("jUL", list);	
			
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

			request.getRequestDispatcher("/goodslist/found.jsp").forward(request, response);
		}
	}
}

