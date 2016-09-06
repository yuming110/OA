package com.web.util;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBUtil {
	private static String URL;
	private static String USER;
	private static String DRIVERCLASS;
	private static String PASSWORD;
	
	/**
	 * 静态初始化块 当类第一次被访问是执行
	 * 
	 */
     static{
    	  Properties p=new Properties();
    	  InputStream in=null;
    	  
    	  try {
			in=DBUtil.class.getResourceAsStream("/com/web/util/Clientjdbc.properties");
			p.load(in);//加载文件

	    	DRIVERCLASS=p.getProperty("DRIVERCLASS");
	    	URL=p.getProperty("URL");
	    	USER=p.getProperty("USER");
	    	PASSWORD=p.getProperty("PASSWORD");
	    	
		  } catch (FileNotFoundException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		 }
	}
    	  
		/**
		 * 连接数据库 获取连接对象
		 * 
		 * @return
		 */
		public static Connection getConnection() {
			Connection conn = null;
			try {
				Class.forName(DRIVERCLASS);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}

		
		public static boolean executeDML(String sql,Object[] params){
			Connection conn=null;
			// 预处理 预编译 占位符 ？/:变量名(占位符只能代表一个值)
			PreparedStatement ps=null;
			boolean b=false;
			try {
			      conn=DBUtil.getConnection();
			      ps=conn.prepareStatement(sql);
			     // sql带有？ 需要设置参数
			     if(null!=params&&params.length>0){
			    	 for(int i=0;i<params.length;i++){
			    		 ps.setObject((i+1),params[i]);
			    		 b=true;
			    	 }
			     }
			     b=ps.execute();
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (ps != null)
						ps.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return b;
		} 
		/**
		 * sql查询语句
		 */
		public static List<Object[]> executeQurry(String sql, Object[] params) {
			Connection conn = null;
			// 预处理 预编译 占位符 ？/:变量名(占位符只能代表一个值)
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Object[]> list = new ArrayList<Object[]>();
			try {
				conn = DBUtil.getConnection();
				ps = conn.prepareStatement(sql);
				// sql带有？ 需要设置参数
				if (null != params && params.length > 0) {
					for (int i = 0; i < params.length; i++) {
						ps.setObject((i + 1), params[i]);
					}
				}
				rs = ps.executeQuery();
				// 处理结果集 获取结果集列数
				int columncount = rs.getMetaData().getColumnCount();
				Object[] os = null;
				while (rs.next()) {
					os = new Object[columncount];
					for (int i = 0; i < columncount; i++) {
						os[i] = rs.getObject(i + 1);
					}
					list.add(os);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				
					try {
						if(rs!=null)rs.close();
						if(ps!=null)ps.close();
						if(conn!=null)conn.close();
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
			}
			
			return list;

		}


   	  
      


}
