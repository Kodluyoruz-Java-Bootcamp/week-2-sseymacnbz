package emlakcepte.model.messageType;

public class WarnMessage implements MessageType{

	@Override
	public String message() {//Bu sınıflar mesaj tipini seçeceğimiz subclass'lardır. Interface'i implemente edecekler.
		return "Uyarıda bulunmak istiyorum";
	}

}
