package emlakcepte.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import emlakcepte.model.Realty;

public class RealtyDaoSingleton {
	private static List<Realty> realtyList = new ArrayList<>();
	
	private static RealtyDaoSingleton instance = new RealtyDaoSingleton();
	
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
	
	// Vitrin rastgele 10 ilandan oluşturuldu.
	public static void getShowcase() {
		Collections.shuffle(realtyList); // Random olması için ilanlar karıştırıldı
		int randomShowcases = 10; // 10 adet ilan seçeceğimiz belirtildi
		System.out.println(realtyList.subList(0, randomShowcases).toString()); // İlanlardan bir subList oluşturulup bastırıldı
	}
}
