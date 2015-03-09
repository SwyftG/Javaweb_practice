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
	作者：李柳依
	时间：2011年7月20日
	模块功能：车辆管理系统*/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		doPost(request,response);				
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//这个后台完成的业务逻辑是查询数据库数据。
		request.setCharacterEncoding("utf-8");
		//创建javabean对象。
		VeInfo info = new VeInfo();
		info.setVhcForm(request.getParameter("vf"));
		info.setOilType(request.getParameter("ot"));
		info.setVhcType(request.getParameter("vt"));
		//连接数据库。
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
			//前台传来的值可能为空，要分开考虑为空和不为空的情况。
			if(!info.getVhcForm().equals("")){
				
					if(info.getOilType().equals("全部")&&!(info.getVhcType().equals("全部"))){
						
						sql = "select * from vehicle where VhcForm='"+ info.getVhcForm()+ "' and VhcType='"+info.getVhcType()+"';";
					}
					else if(info.getVhcType().equals("全部")&&!(info.getOilType().equals("全部"))){
						
						sql = "select * from vehicle where VhcForm='"+ info.getVhcForm()+ "' and OilType='"+info.getOilType()+"';";	
					}
					else if(info.getVhcType().equals("全部")&&(info.getOilType().equals("全部"))){
						
						sql = "select * from vehicle where VhcForm='"+ info.getVhcForm()+"';";
					}else{
						
						sql = "select * from vehicle where VhcForm='"+ info.getVhcForm()+ "' and OilType='"+info.getOilType()+ "' and VhcType='"+info.getVhcType()+"';";
					}
			}else{
				
				if(info.getOilType().equals("全部") && !(info.getVhcType().equals("全部"))){
					
					sql = "select * from vehicle where VhcType='"+info.getVhcType()+"';";
				}
				else if(info.getVhcType().equals("全部") && !(info.getOilType().equals("全部"))){
					
					sql = "select * from vehicle where OilType='"+info.getOilType()+"';";	
				}
				else if(info.getVhcType().equals("全部") && (info.getOilType().equals("全部"))){
					
					sql = "select * from vehicle;";
				}else{
					
					sql = "select * from vehicle where OilType='"+info.getOilType()+"' and VhcType='"+info.getVhcType()+"';";
				}
			}
			//执行sql查询语句。
			rs = st.executeQuery(sql);					
			HttpSession session = request.getSession();
			//创建一个Arraylist对象,用于承载得到的查询结果，传给前台。
			List list = new ArrayList();
			
				while(rs.next()){
		
						VeInfo info2=new VeInfo();
						info2.setVhcForm(rs.getString("VhcForm"));
						info2.setOilType(rs.getString("OilType"));
						//数据库中的oilCpt字段的数据是float型
						info2.setOilCpt(rs.getFloat("OilCpt"));
						info2.setVhcType(rs.getString("VhcType"));
						//数据库中的VhcSpc字段的数据是bool型
						info2.setVhcSpc(rs.getBoolean("VhcSpc"));
						info2.setVhcLcs(rs.getString("VhcLcs"));
						info2.setVhcRmk(rs.getString("VhcRmk"));
						//数据库中的LoadCpt字段的数据是float型
						info2.setLoadCpt(rs.getFloat("LoadCpt"));
						//将VeInfo的对象作为一个整体放到list中。
						list.add(info2);	
				}
				//利用session传值。
				session.setAttribute("lsUL", list);	
			
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			//关闭相应的资源。
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

