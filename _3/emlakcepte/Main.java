package emlakcepte;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import emlakcepte.model.Message;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyType;
import emlakcepte.model.User;
import emlakcepte.model.UserType;
import emlakcepte.model.messageType.MessageTypeFactory;
import emlakcepte.service.RealtyService;
import emlakcepte.service.UserService;

public class Main {

	public static void main(String[] args) throws Exception {

		UserService userService = new UserService(); 
		RealtyService realtyService = new RealtyService();
		MessageTypeFactory messageFactory = new MessageTypeFactory();

		User userPelin = prepareUser("Pelin", "mimar.pelin@gmail.com", "Pelin123");
		User userSami = new User("Sami", "sami@gmail.com", "123", UserType.INDIVIDUAL, Collections.emptyList());
		
		
		userService.createUser(userPelin);
		userService.createUser(userSami);

		userService.printAllUser();

		System.out.println("-----");


		Realty realty = new Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userPelin,
				RealtyType.ACTIVE);
		realty.setProvince("İstanbul");

		realtyService.createRealty(realty);

		Realty realty1 = new Realty();
		realty1.setNo(124L);
		realty1.setTitle("Büyükdere Ana Cadde üstünde 16.060 m2 kapalı alanlı PLAZA");
		realty1.setStatus(RealtyType.ACTIVE);
		realty1.setUser(userPelin);
		realty1.setProvince("İstanbul");

		realtyService.createRealty(realty1);

		Realty favori1 = new Realty();
		favori1.setNo(125L);
		favori1.setTitle("KAVAKPINAR MAHALLESİNDE 2+1 80 M2 ARAKAT İSKANLI");
		favori1.setStatus(RealtyType.ACTIVE);
		favori1.setUser(userPelin);
		favori1.setProvince("Ankara");

		realtyService.createRealty(favori1);

		realty.setUser(userSami);
		userSami.setRealtyList(List.of(realty, realty1));

		List<Realty> favorilerim = new ArrayList<>();
		favorilerim.add(favori1);
		userSami.setFavoriteRealtyList(favorilerim);

		// sistemdeki bütün ilanlar

		System.out.println("Bütün ilanlar");

		realtyService.printAll(realtyService.getAll());

		// İstanbuldaki ilanların bulunması

		System.out.println("İstanbul'daki ilanlar");

		realtyService.getAllByProvince("İstanbul");

		// Bir kullanıcının bütün ilanlarını listele
		realtyService.printAll(realtyService.getAllByUserName(userPelin));

		realtyService.printAll(realtyService.getActiveRealtyByUserName(userSami));

		// Factory Design ile mesaj başlığı belirlendi
		Message message = new Message(messageFactory.createMessageTitle("urgent"), "ilan ile ilgili bilgilendirme verebilir misiniz?", userPelin,
				userSami);

		userSami.setMessages(List.of(message));
		userPelin.setMessages(List.of(message));

		userSami.getMessages();


	}

	private static User prepareUser(String name, String email, String password) {
		User user = new User();
		user.setName(name);
		user.setMail(email);
		user.setPassword(password);
		user.setType(UserType.INDIVIDUAL);
		user.setCreateDate(LocalDateTime.now());
		return user;
	}

}
