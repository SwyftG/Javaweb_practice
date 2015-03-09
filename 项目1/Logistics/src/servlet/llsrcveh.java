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
public class llsrcveh extends HttpServlet {
	/*
	���ߣ�������
	ʱ�䣺2011��7��20��
	ģ�鹦�ܣ���������ϵͳ*/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		doPost(request,response);				
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�����̨��ɵ�ҵ���߼��ǲ�ѯ���ݿ����ݡ�
		request.setCharacterEncoding("utf-8");
		//����javabean����
		VeInfo info = new VeInfo();
		info.setVhcForm(request.getParameter("vf"));
		info.setOilType(request.getParameter("ot"));
		info.setVhcType(request.getParameter("vt"));
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
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();
			String sql =null;		
			//ǰ̨������ֵ����Ϊ�գ�Ҫ�ֿ�����Ϊ�պͲ�Ϊ�յ������
			if(!info.getVhcForm().equals("")){
				
					if(info.getOilType().equals("ȫ��")&&!(info.getVhcType().equals("ȫ��"))){
						
						sql = "select * from vehicle where VhcForm='"+ info.getVhcForm()+ "' and VhcType='"+info.getVhcType()+"';";
					}
					else if(info.getVhcType().equals("ȫ��")&&!(info.getOilType().equals("ȫ��"))){
						
						sql = "select * from vehicle where VhcForm='"+ info.getVhcForm()+ "' and OilType='"+info.getOilType()+"';";	
					}
					else if(info.getVhcType().equals("ȫ��")&&(info.getOilType().equals("ȫ��"))){
						
						sql = "select * from vehicle where VhcForm='"+ info.getVhcForm()+"';";
					}else{
						
						sql = "select * from vehicle where VhcForm='"+ info.getVhcForm()+ "' and OilType='"+info.getOilType()+ "' and VhcType='"+info.getVhcType()+"';";
					}
			}else{
				
				if(info.getOilType().equals("ȫ��") && !(info.getVhcType().equals("ȫ��"))){
					
					sql = "select * from vehicle where VhcType='"+info.getVhcType()+"';";
				}
				else if(info.getVhcType().equals("ȫ��") && !(info.getOilType().equals("ȫ��"))){
					
					sql = "select * from vehicle where OilType='"+info.getOilType()+"';";	
				}
				else if(info.getVhcType().equals("ȫ��") && (info.getOilType().equals("ȫ��"))){
					
					sql = "select * from vehicle;";
				}else{
					
					sql = "select * from vehicle where OilType='"+info.getOilType()+"' and VhcType='"+info.getVhcType()+"';";
				}
			}
			//ִ��sql��ѯ��䡣
			rs = st.executeQuery(sql);					
			HttpSession session = request.getSession();
			//����һ��Arraylist����,���ڳ��صõ��Ĳ�ѯ���������ǰ̨��
			List list = new ArrayList();
			
				while(rs.next()){
		
						VeInfo info2=new VeInfo();
						info2.setVhcForm(rs.getString("VhcForm"));
						info2.setOilType(rs.getString("OilType"));
						//���ݿ��е�oilCpt�ֶε�������float��
						info2.setOilCpt(rs.getFloat("OilCpt"));
						info2.setVhcType(rs.getString("VhcType"));
						//���ݿ��е�VhcSpc�ֶε�������bool��
						info2.setVhcSpc(rs.getBoolean("VhcSpc"));
						info2.setVhcLcs(rs.getString("VhcLcs"));
						info2.setVhcRmk(rs.getString("VhcRmk"));
						//���ݿ��е�LoadCpt�ֶε�������float��
						info2.setLoadCpt(rs.getFloat("LoadCpt"));
						//��VeInfo�Ķ�����Ϊһ������ŵ�list�С�
						list.add(info2);	
				}
				//����session��ֵ��
				session.setAttribute("lsUL", list);	
			
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			//�ر���Ӧ����Դ��
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

			request.getRequestDispatcher("/vehicle/searchVehicle.jsp").forward(request, response);
		}
	}
}

