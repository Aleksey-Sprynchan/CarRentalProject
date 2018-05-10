package by.htp.sprynchan.car_rental.dao.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.dao.OrderDao;
import by.htp.sprynchan.car_rental.dao.impl.OrderDaoDBImpl;

public class qwe {

	public qwe() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		List<Order> orderDatesList = new ArrayList();
		
		Order o1 = new Order();
		o1.setStartDate(LocalDate.parse("2018-05-09"));
		o1.setEndDate(LocalDate.parse("2018-05-11"));
		orderDatesList.add(o1);	
		
		Order o2 = new Order();
		o2.setStartDate(LocalDate.parse("2018-05-15"));
		o2.setEndDate(LocalDate.parse("2018-05-18"));
		orderDatesList.add(o2);		
		
		Order o3 = new Order();
		o3.setStartDate(LocalDate.parse("2018-05-28"));
		o3.setEndDate(LocalDate.parse("2018-05-30"));
		orderDatesList.add(o3);		



		List<String> dates = new ArrayList<>();
	
		for(Order o: orderDatesList) {
			LocalDate start = o.getStartDate();
			LocalDate end = o.getEndDate();
			while(!start.isAfter(end)) {
				dates.add(start.toString());
				start = start.plusDays(1);
			}
			
		}
		
		for(String s: dates) {
			System.out.println(s);
		}
		
		
		String [] dat = new String[dates.size()];
		
		dat = dates.toArray(dat);
		System.out.println("!!!!!!!!!!!!!");
		for(String s: dat) {
			System.out.println(s);
		}
		
		JSONArray ar = new JSONArray();
		for(String s: dat) {
			ar.add(s);
		}
		
		System.out.println(ar);
		
		
		List<Map> qwe = new ArrayList<>();
		
		
		
	}

}
