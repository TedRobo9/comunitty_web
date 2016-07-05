package com.uacity.web.service.admin;

import com.uacity.web.common.util.SystemConstant;
import com.uacity.web.dao.AdminDao;
import com.uacity.web.domain.AdminInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired 
	private AdminDao dao;
	
	public void save(AdminInfo admin){
		dao.save(admin);
	}

	@Override
	public Page<AdminInfo> search(String userName,
			String realName, int page) {
		Pageable pa = new PageRequest(page, SystemConstant.pageSize);
		return dao.findByUsernameContainingAndRealnameContaining(userName, realName, pa);
	}

	@Override
	public AdminInfo getById(int id) {
		return dao.findOne(id);
	}

	@Override
	public void delete(Iterable<AdminInfo> admins) {
		dao.deleteInBatch(admins);
		
	}

	@Override
	public void deleteById(Integer id) {
		dao.delete(id);
	}

	@Override
	public AdminInfo getAdmin(String username, String password) {
		return dao.findByUsernameAndPassword(username, password);
	}

	@Override
	public AdminInfo getByName(String username) {
		return dao.findByUsername(username);
	}
}
