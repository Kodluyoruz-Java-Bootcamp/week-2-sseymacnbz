package emlakcepte.model.messageType;

public class MessageTypeFactory {//Bu Factory'de daha önce oluşturduğumuz sınıflardan instance oluşturuldu.
	// Bir kullanıcı hangi mesaj tipini seçecekse, bu Factory yardımıyla yapacak. Her sınıftan mesaj tipine göre instance oluşturmayacak
	// Kullanıcı vereceği bir string ile o sınıftan instance oluşturmuş olacak.
	public MessageType createMessageTitle(String type) throws Exception{
		if(type.equalsIgnoreCase("bargain")) {
			return new BargainMessage();
		}
		else if(type.equalsIgnoreCase("urgent")) {
			return new UrgentMessage();
		}
		else if(type.equalsIgnoreCase("warn")) {
			return new WarnMessage();
		}
		else if(type.equalsIgnoreCase("other")) {
			return new OtherMessage();
		}
		else {
			throw new Exception("Lütfen doğru mesaj tipi seçin");
		}
	}

}
