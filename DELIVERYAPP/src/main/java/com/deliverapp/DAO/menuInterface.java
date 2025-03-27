package com.deliverapp.DAO;


import java.util.List;


import com.deliverapp.models.Menu;

public interface menuInterface {
	
	void addMenu(Menu menu);
	
	Menu getMenu(int menuid);
	
	void updateMenu(Menu menu);
	
	void deleteMenu(int menuid);
	
	List<Menu>getAllMenu(int resturantid);
	
	
	

}
