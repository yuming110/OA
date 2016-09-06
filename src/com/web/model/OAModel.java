package com.web.model;

import java.util.List;

import com.we.bean.Job;
import com.we.bean.Menu;
import com.we.bean.Page;
import com.we.bean.User;
import com.web.vo.UserVo;

public interface OAModel {
	/**
	 * 登录，根据账户查询
	 * @return
	 */
	public User loadByUserName(String userName);
	
	/**
	 * 用户群权限
	 * @param uid
	 * @return
	 */
	public List<Menu> loadUserByUid(int uid);
	
	/**
	 * 查询用户信息
	 * @return
	 */
	public Page<UserVo> loadByUserVo(int pageNo,int pageSize);
	/**
	 * 查询所有职位
	 * @return
	 */
	public List<Job> loadShowJob();
	/**
	 * 删除角色
	 * @param jobid
	 */
	public void loadDelectJob(int jobid);
	
	/**
	 * 根据角色id查询角色
	 * @param jobid
	 * @return
	 */
	public Job loadJobidShow(int jobid);
	
	/**
	 * 根据jobid查询用户
	 */
	public  List<Object[]> loadJobidShowUser(int jobid);
	/**
	 * 修改角色
	 * @param jobid
	 * @param ujid
	 */
	public void loadAlterJob(int jobid,String[] ujid);
	/**
	 * 查询菜单
	 * @param jobid
	 * @return
	 */
	public List<Object[]> showMenuName(int jobid);
	/**
	 * 修改角色权限
	 * @param jobid
	 * @param mName
	 */
	public void loadAlterMenu(int jobid,String[] mName);
	
}
