package emlakcepte.model.messageType;

public class BargainMessage implements MessageType{

	@Override
	public String message() {//Bu sınıflar mesaj tipini seçeceğimiz subclass'lardır. Interface'i implemente edecekler.
		
		return "Pazarlık istiyorum";
	}
	
}
