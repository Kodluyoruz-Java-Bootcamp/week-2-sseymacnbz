package emlakcepte.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.dao.RealtyDaoSingleton;
import emlakcepte.model.Logging;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyType;
import emlakcepte.model.User;
import emlakcepte.model.UserType;

@Service
public class RealtyService {
	
	RealtyDaoSingleton realtyDaoSingleton = RealtyDaoSingleton.getInstance();
	Logging logItem = new Logging(); // İlan arama kayıtlarını tutacaktır.
	
	@Autowired
	private LoggingService loggingService;
	public void createRealty(Realty realty) {	
		
		// Bireysel kullanıcıların ilan sınırı aşılırsa bastıramayacağına dair uyarı verir
		if (UserType.INDIVIDUAL.equals(realty.getUser().getType()) ) {
			if(getAllByUserName(realty.getUser()).size()>=3) {
				System.out.println("Bireysel kullanıcılar sadece 3 adet ilan yayınlayabilir");
			}
		}
		else {
		realtyDaoSingleton.saveRealty(realty);
		System.out.println("createRealty :: " + realty.getTitle());
		}
	}
	
	public List<Realty> getAll(){
		return realtyDaoSingleton.findAll();
	}
	
	public void printAll(List<Realty> realtList) {
		realtList.forEach(realty -> System.out.println(realty));
	}

	public void getAllByProvince(String province) {
		
		getAll().stream()
		.filter(realty -> realty.getProvince().equals(province))
		//.count();
		.forEach(realty -> System.out.println(realty));
		
	}
	
	public List<Realty> getAllByUserName(User user){	
		return getAll().stream()
		.filter(realty -> realty.getUser().getMail().equals(user.getMail()))
		.toList();		
	}

	public List<Realty> getActiveRealtyByUserName(User user) {
		
		return getAll().stream()
		.filter(realty -> realty.getUser().getName().equals(user.getName()))
		.filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus()))
		.toList();

	}
	
	// Kendisine verilen il ve ilçeye göre arama yapıp ekrana bastıracaktır.
	public void getByDistrict(User user, String province, String district){
		
		// Arama yapılırken bir yandan da kayıt altına alınmaktadır. Aramayı yapan;
		logItem.setUser(user); // kullanıcı
		logItem.setProvince(province); // aradığı şehir
		logItem.setDistrict(district); // aradığı ilçe 
		loggingService.searchingLog(logItem);
		
		for(Realty realty:getAll()) { // Tüm ilanlar alındı
			if(realty.getProvince().equalsIgnoreCase(province)) { // Şehirler eşleşiyorsa
				if(realty.getDistrict().equalsIgnoreCase(district)) { // İlçeler eşleşiyorsa
					System.out.println(realty.toString()); // ilanı stringe çevirip ver.
				}
			}
		}
	}
	
	// Vitrini getir
	public void getShowcase() {
		RealtyDaoSingleton.getShowcase();
	}
	
	public void getSizeOfRealtyByProvince(String province) {
		System.out.println(getAll().stream()
		.filter(realty -> realty.getProvince().equals(province)).count());
	}

}
