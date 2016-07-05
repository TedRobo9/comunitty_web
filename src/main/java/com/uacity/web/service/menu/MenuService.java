package com.uacity.web.service.menu;

import com.uacity.web.domain.Menu;

import java.util.List;

public interface MenuService {

	public void save(Menu menu);
	public void delete(Integer id);
	public List<Menu> getTopMenu();
	public Menu getMenuById(Integer id);
}
