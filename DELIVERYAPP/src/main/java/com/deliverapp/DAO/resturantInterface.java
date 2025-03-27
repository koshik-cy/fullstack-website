package com.deliverapp.DAO;

import java.util.List;


import com.deliverapp.models.Resturant;

public interface resturantInterface {
	
	void addResturant(Resturant res);
	
	Resturant getResturant(int resid);
	
	void updateResturnat(Resturant res);
	
	void deleteResturnat(int resid);
	
	List<Resturant> getallResturant();

}
