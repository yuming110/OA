package com.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import com.we.bean.Job;
import com.we.bean.Menu;
import com.we.bean.Page;
import com.we.bean.User;
import com.web.model.OAModel;
import com.web.model.impl.OAModelImpl;
import com.web.vo.UserVo;


public class MainServlet extends HttpServlet{

	private OAModel oAModel = new OAModelImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String methodName = req.getParameter("methodName");
		Class c = MainServlet.class;
		
		try {
			Method method = c.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this,req, resp);
		
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 登录
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		
		
		User user = oAModel.loadByUserName(userName);
		if(user != null){
			if(userPass.equals(user.getUserPass())){
				List<Menu> menuList = oAModel.loadUserByUid(user.getUid());
				req.getSession().setAttribute("menuList",menuList );
				req.getSession().setAttribute("loginUser", user);
				resp.sendRedirect("view/welcome.jsp");
			}else{
				req.setAttribute("loginError", "密码输入错误，请重新输入！");
				resp.sendRedirect("login.jsp");
			}
		}else{
			req.setAttribute("loginError", "账号输入错误，请重新输入！");
			resp.sendRedirect("login.jsp");
		}
	}
	/**
	 * 用户列表
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showUserVo(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		int pageNo = Integer.valueOf(req.getParameter("pageNo"));
		int pageSize = Integer.valueOf(req.getParameter("pageSize"));
		
        Page<UserVo> page= oAModel.loadByUserVo(pageNo, pageSize);
        
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rows", page.getDataList());//easyui要求返回的分页数据
		map.put("total", page.getTotal());
		
		String json = JSONObject.fromObject(map).toString();
		
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(json);
		resp.getWriter().flush();
	}
	
	
	/**
	 * 角色列表
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showJob(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		List<Job> jobList=oAModel.loadShowJob();
		req.setAttribute("jobList", jobList);
		req.getRequestDispatcher("view/user/showJob.jsp").forward(req, resp);
		
	}
	/**
	 * 删除角色
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showJobIdDelect(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String jobid = req.getParameter("jobid");
		this.oAModel.loadDelectJob(Integer.valueOf(jobid));
		resp.sendRedirect("view/user/showJob.jsp");
		
	}
	/**
	 * 根据角色的id，查找该角色对应的用户 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showJobid(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String jobid = req.getParameter("jobid");
		Job job = oAModel.loadJobidShow(Integer.valueOf(jobid));
		req.setAttribute("job", job);
		
		List<Object[]> uList=oAModel.loadJobidShowUser(Integer.valueOf(jobid));
		req.setAttribute("uList", uList);
		req.getRequestDispatcher("view/user/alterJob.jsp").forward(req, resp);
		
	}
	/**
	 * 角色修改
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void alterJob(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String jobid = req.getParameter("jobid");
		String[] ujid = req.getParameterValues("ujid");
		
		
		oAModel.loadAlterJob(Integer.valueOf(jobid), ujid);
		this.showJob(req, resp);
	}
	
	/**
	 * 查询角色对应的菜单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showMenuRid(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String jobid = req.getParameter("jobid");
		
		Job job = oAModel.loadJobidShow(Integer.valueOf(jobid));
		req.setAttribute("job", job);
		
		List<Object[]> list=oAModel.showMenuName(Integer.valueOf(jobid));
		req.setAttribute("list", list);
		System.out.println(list.size());
		req.getRequestDispatcher("view/user/alterMenu.jsp").forward(req, resp);
	}
	
	/**
	 * 修改权限
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void alterMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rid = req.getParameter("jobid");
		String[] mName = req.getParameterValues("mName");
		oAModel.loadAlterMenu(Integer.valueOf(rid), mName);
		this.showJob(req, resp);
	}
}
