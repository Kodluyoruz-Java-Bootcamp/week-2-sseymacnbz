package emlakcepte.dao;

import java.util.ArrayList;
import java.util.List;

import emlakcepte.model.Logging;
import emlakcepte.model.User;

public class LoggingDao {
	private static List<Logging> logList = new ArrayList<>();
	
	public void searchingLog(Logging log) { // Logları listeye ekleme 
		logList.add(log);
	}

	public void printLogging(User user) { // Kayıtlı logları gelen kullanıcı bilgisine göre bastırma
		for(Logging log : logList) {
			if(log.getUser().equals(user)) {
				System.out.print(log.getProvince()+" ");
				System.out.println(log.getDistrict());
			}
		}
		
	}
}
