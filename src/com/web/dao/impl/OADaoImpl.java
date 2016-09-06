package com.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.we.bean.Job;
import com.we.bean.Menu;
import com.we.bean.Page;
import com.we.bean.User;
import com.web.dao.OADao;

import com.web.util.DBUtil;
import com.web.vo.UserVo;

public class OADaoImpl implements OADao {

	/**
	 * 登录，根据账户查询
	 * @return
	 */
	public User loadByUserName(String userName){
		String sql = "select * from user where userName=?" ;
		List<Object[]> list = DBUtil.executeQurry(sql, new Object[]{userName});
		User user = null;
		if(list.size()>0&&list!=null){
			Object[] os = list.get(0);
			user = new User((Integer)os[0],userName,String.valueOf(os[2]),String.valueOf(os[3]),(Integer)os[4],(Integer)os[5],(Integer)os[6]);
		}
		return user;
	}
	
	 /**
     * 用户权限管理
     */
	@Override
	public List<Menu> loadUserByUid(int uid) {
		
		String sql = "select  m.* from userjob uj,jobmenu jm,menu m where uj.job_id=jm.job_id and jm.menu_id=m.menu_id and m.isshow=1 and uj.user_id=? " ;
		List<Object[]> list = DBUtil.executeQurry(sql,new Object[]{uid});
		
		List<Menu> menuList = new ArrayList<Menu>();
		Menu menu = null;
		
		if(list.size() > 0 && list != null){
			
			for(Object[] os : list){
				menu = new Menu((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[2]), (Integer)os[3], (Integer)os[4], (Integer)os[5]);
				
				menuList.add(menu);
			}
		}
		return 	menuList;
	}
	
	/**
	 * 查询用户信息
	 * @return
	 */
	public Page<UserVo> loadByUserVo(int pageNo,int pageSize){
		String sql = "select u.userName,u.userPass,u.uName,(select d.dName from department d where u.department_id=d.department_id),(select jobName from job j where u.job_id=j.job_id),(select jtName from jobtitle jt where u.jobtitle_id=jt.jobtitle_id) from user u limit ?,?";
		
		List<Object[]> list = DBUtil.executeQurry(sql,new Object[]{(pageNo-1)*pageSize,pageSize} );
		List<UserVo> userList = new ArrayList<UserVo>();
		UserVo userVo=null;
		if(list.size()>0 && list!=null){
			System.out.println(list);
			for(Object[] ob : list){
				userVo = new UserVo((Integer)ob[0],String.valueOf(ob[1]),String.valueOf(ob[2]),String.valueOf(ob[3]),String.valueOf(ob[4]),String.valueOf(ob[5]),String.valueOf(ob[6]));
				userList.add(userVo);
			}
		}
		sql="select count(*) from user";
		list = DBUtil.executeQurry(sql,null);
		long total=(Long)list.get(0)[0];
		return new Page<UserVo>(pageNo,pageSize,userList,total);
	}

	/**
	 * 查询所有职位
	 * @return
	 */
	public List<Job> loadShowJob(){
		String sql = "select * from job";
		List<Object[]> list = DBUtil.executeQurry(sql, null);
		List<Job> jobList = new ArrayList<Job>();
		Job job = null;
		if(list.size()>0 && list!=null){
			for(Object[] ob : list){
				job = new Job((Integer)ob[0],String.valueOf(ob[1]),(Integer)ob[2]);
				jobList.add(job);
			}
		}
		return jobList;
	}
	
	/**
	 * 删除角色
	 * @param jobid
	 */
	public void loadDelectJob(int jobid){
		System.out.println("dao");
		String sql = "delete from job where job_id=?";
		DBUtil.executeDML(sql, new Object[]{jobid});
		sql = "select * from job";
		List<Object[]> ob = DBUtil.executeQurry(sql, null);
	}
	
	/**
	 * 根据角色id查询角色
	 * @param jobid
	 * @return
	 */
	public Job loadJobidShow(int jobid){
		String sql = "select * from job where job_id=?";
		List<Object[]> list = DBUtil.executeQurry(sql,new Object[]{jobid});
		Job job = null;
		if(list.size()>0&&list!=null){
			Object[] os = list.get(0);
			job = new Job(jobid,String.valueOf(os[1]),(Integer)os[2]);
		}
		return job;
	}
	
	/**
	 * 根据jobid查询用户
	 */
	public  List<Object[]> loadJobidShowUser(int jobid){
		String sql = "select u.user_id,u.uName,(select 1 from userjob uj where uj.user_id=u.user_id and uj.job_id=?) from user u";
		List<Object[]> uList = DBUtil.executeQurry(sql,new Object[]{jobid});
		return uList;
	}
	
	/**
	 * 修改角色
	 * @param jobid
	 * @param ujid
	 */
	public void loadAlterJob(int jobid,String[] ujid){
		String sql = "delete from userjob where job_id=?";
		DBUtil.executeDML(sql, new Object[]{jobid});
		
		sql = "insert into userjob(user_id,job_id) values(?,?)";
		for(String ujids : ujid){
			DBUtil.executeDML(sql, new Object[]{ujid,jobid});
		}
	}
	
	/**
	 * 查询菜单
	 * @param jobid
	 * @return
	 */
	public List<Object[]> showMenuName(int jobid){
		String sql = "select m.menu_id,m.mName,m.url,m.level,m.parentid,(select 1 from jobmenu jm where jm.menu_id=m.menu_id and jm.job_id=?) from menu m";
		
		return DBUtil.executeQurry(sql, new Object[]{jobid});
	}
	
	/**
	 * 修改角色权限
	 * @param jobid
	 * @param mName
	 */
	public void loadAlterMenu(int jobid,String[] mName){
		String sql = "delete from jobmenu where job_id=?";
		DBUtil.executeDML(sql, new Object[]{jobid});
		
		sql = "insert into jobmenu(jobid,menu_id) values(?,?)";
		for(String mNames:mName){
			DBUtil.executeDML(sql, new Object[]{jobid,mNames});
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}














