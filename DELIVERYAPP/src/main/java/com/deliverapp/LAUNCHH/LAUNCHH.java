package com.deliverapp.LAUNCHH;

//import java.util.ArrayList;
import java.util.List;

//import java.util.Scanner;


import com.deliverapp.DaoIMPL.menuImplment;
import com.deliverapp.DaoIMPL.orderImplment;
import com.deliverapp.DaoIMPL.orderItemsImple;
import com.deliverapp.DaoIMPL.resturantImplement;
import com.deliverapp.DaoIMPL.userImplmentation;
import com.deliverapp.models.Menu;
import com.deliverapp.models.Order;
import com.deliverapp.models.OrderItmes;
import com.deliverapp.models.Resturant;
import com.deliverapp.models.User;
//import com.deliverapp.models.User;


public class LAUNCHH {
	public static void main(String[] args) {
		
		menuTableFunctions();
	}
	
	
	public static void orderItemsTableFunctions() {
		
//		OrderItmes oi=new OrderItmes(2, 2, 45, 18, 26767);
		
		orderItemsImple oiim=new orderItemsImple();
		

		
		List<OrderItmes>al=oiim.getAllOrderitems();
		System.out.println(al);
		
		
		
		
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void orderTableFunctions() {
		//Order o=new Order(1, 5, 4, "01-01-2025", "6700", "Delivered", "Phone Pe");
		
		
		orderImplment oi=new orderImplment();
		List<Order>al= oi.getAllOrders();
		System.out.println(al);
		
		
		
		
	}
	
	
	
	
	
	public static void usertabletfulctions() {
		

		User user=new User();
		
		user.setName("koshik");
		user.setUsername("kingg");
		user.setPassword("virat");
		user.setEmail("csdgay@gmail.com");
		user.setNumber("0901229209");
		user.setAddress("ja2in");
		user.setRole("Customer");
		
		
		
		
		
		userImplmentation u=new userImplmentation();
		u.addUser(user);
		
		
		//u.deleteUser(3);
		
		
		
	
		
		
	
	
//		List<User> allUsers = u.getAllUsers();
//		
//		System.out.println(allUsers);
//		
//		System.out.println("Enter the id that you want to delect...");
//		Scanner sc=new Scanner(System.in);
//	
//		int n=sc.nextInt();
//			
//	
//		u.deleteUser(n);
//		
//		sc.close();
		
	}
	
	
	
	
	
	public static void resturantTableFucntions() {
		//Resturant res=new Resturant();
		
		 // Resturantid, Name, Address, Phone, CusineType,, Adminid, Rating, IsActive, Igamepath
		
		
//		res.setName("BAWARCHI");
//		res.setAddress("MR PALLI");
//		res.setPhone("76878789798");
//		res.setCusinetype("INDIAN");
//		res.setAdminid(2367);
//		res.setRating(4.22);
//		res.setIsactive("open");
//		res.setImagepath("C:\\Users\\KOSHIK\\Documents\\ecpliceJDBC\\JdBc\\src\\img\\virat.jpg");
//		r.addResturant(res);
	
		
		resturantImplement r=new resturantImplement();
		
		
		
		List<Resturant>rl= r.getallResturant();
		for(Resturant x:rl) {
			System.out.println(x.getName()+" "+x.getAddress()+" "+x.getPhone()+" "+x.getCusinetype()+" "+x.getAdminid()+" "
					+x.getRating()+" "+x.getIsactive()+" "+x.getImagepath());
			System.out.println("NEXT DETAILSSSSSSSSSSSSSSSS---------------");
		}
		
		
		
		
		
		
		
	}
	
	
	public static void menuTableFunctions() {
		
		// Menuid, Resturantid, Itemname, Description, Price, IsAvaliable, Ratings, Imagepath
		
//		Menu menu=new Menu();
//		menu.setMenuid(1);
//		menu.setResturantid(4);
//		menu.setItemname("BRIYANI");
//		menu.setPrice("189.67");
//		menu.setIsavaliable("yes");
//		menu.setRatings(4.25);
//		menu.setImagepath("C:\\Users\\KOSHIK\\Documents\\ecpliceJDBC\\JdBc\\src\\img\\virat.jpg");
//		mi.addMenu(menu);
		
		
		menuImplment mi=new menuImplment();
		
		Menu m = mi.getMenu(4);
		
		System.out.println(m);
	
		
		
		
	}
	
}
