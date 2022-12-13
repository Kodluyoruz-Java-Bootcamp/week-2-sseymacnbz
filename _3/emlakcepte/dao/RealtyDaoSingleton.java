package emlakcepte.dao;

import java.util.ArrayList;
import java.util.List;

import emlakcepte.model.Realty;

public class RealtyDaoSingleton {
	private static List<Realty> realtyList = new ArrayList<>();
	
	// Bu instance return edilecek ve service class'larında kullanılacak 
	private static RealtyDaoSingleton instance = new RealtyDaoSingleton();
	
	//Cosntructor private. Böylece dışarıdan bir nesne oluşturulması engellenecek
	private RealtyDaoSingleton() {
		
	}
	
	public static RealtyDaoSingleton getInstance() {
		return instance;
	}
	
	public void saveRealty(Realty realty) {
		realtyList.add(realty);
	}
	
	public List<Realty> findAll(){
		return realtyList;
	}
}
