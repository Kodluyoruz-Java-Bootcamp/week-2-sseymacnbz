package emlakcepte.model.messageType;

public class UrgentMessage implements MessageType{

	@Override
	public String message() {//Bu sınıflar mesaj tipini seçeceğimiz subclass'lardır. Interface'i implemente edecekler.
		return "Acil dönüş istiyorum";
	}

}
