package com.web.model.impl;

import java.util.List;

import com.we.bean.Job;
import com.we.bean.Menu;
import com.we.bean.Page;
import com.we.bean.User;
import com.web.dao.OADao;
import com.web.dao.impl.OADaoImpl;
import com.web.model.OAModel;
import com.web.vo.UserVo;

public class OAModelImpl implements OAModel{
	private OADao oADao = new OADaoImpl();

	/**
	 * 登录，根据账户查询
	 * @return
	 */
	public User loadByUserName(String userName) {
		return oADao.loadByUserName(userName);
	}
	
	/**
	 * 用户群权限
	 * @param uid
	 * @return
	 */
	public List<Menu> loadUserByUid(int uid){
		return oADao.loadUserByUid(uid);
	}

	/**
	 * 查询用户
	 */
	public Page<UserVo> loadByUserVo(int pageNo, int pageSize) {
		return oADao.loadByUserVo(pageNo, pageSize);
	}
	
	/**
	 * 查询所有职位
	 * @return
	 */
	public List<Job> loadShowJob(){
		return oADao.loadShowJob();
	}
	
	/**
	 * 删除角色
	 * @param jobid
	 */
	public void loadDelectJob(int jobid){
		oADao.loadDelectJob(jobid);
	}
	
	/**
	 * 根据角色id查询角色
	 * @param jobid
	 * @return
	 */
	public Job loadJobidShow(int jobid){
		return oADao.loadJobidShow(jobid);
	}
	
	/**
	 * 根据jobid查询用户
	 */
	public  List<Object[]> loadJobidShowUser(int jobid){
		return oADao.loadJobidShowUser(jobid);
		
	}
	
	/**
	 * 修改角色
	 * @param jobid
	 * @param ujid
	 */
	public void loadAlterJob(int jobid,String[] ujid){
		oADao.loadAlterJob(jobid, ujid);
	}
	
	/**
	 * 查询菜单
	 * @param jobid
	 * @return
	 */
	public List<Object[]> showMenuName(int jobid){
		return oADao.showMenuName(jobid);
	}
	
	/**
	 * 修改角色权限
	 * @param jobid
	 * @param mName
	 */
	public void loadAlterMenu(int jobid,String[] mName){
		oADao.loadAlterMenu(jobid, mName);
	}
}
