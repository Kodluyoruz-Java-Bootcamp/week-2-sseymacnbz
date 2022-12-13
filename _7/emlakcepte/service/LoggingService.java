package emlakcepte.service;

import org.springframework.beans.factory.annotation.Autowired;

import emlakcepte.dao.LoggingDao;
import emlakcepte.model.Logging;
import emlakcepte.model.User;

public class LoggingService {
	// Bu servis yapılan aramalara dair logları tutacaktır.
	@Autowired
	private LoggingDao loggingDao;
	
	public void searchingLog(Logging log) { // Arama logları için metod
		loggingDao.searchingLog(log);
	}
	
	public void printLogging(User user) { // Logları bastırmak için metod
		loggingDao.printLogging(user);
	}
}
