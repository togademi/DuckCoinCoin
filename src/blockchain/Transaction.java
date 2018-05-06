package blockchain;

import java.util.Date;
import java.util.Random;
import java.text.Format;
import java.text.SimpleDateFormat;

public class Transaction {
	
	//================================================================================
	// Properties
	//================================================================================

	public static final int MAX_VALUE = 10; //random number concatenated to the transaction identification (string)
	Random random = new Random();
	private int randomNumber; //Random number lower than MAX_VALUE to put at the end of transaction
	private int index; //index of the transaction in the list
	private String timestamp; //date of creation of the transaction (String)
	private long longtime; //date of creation of the transaction (long)
	private String sender; //hexadecimal address of the sender
	private String receiver; //hexadecimal address of the receiver
	private int sum; //transaction sum
	private String signature_sender; //signature of the sender
	
	//================================================================================
	// Constructors
	//================================================================================
	
	public Transaction() {
		this.randomNumber = random.nextInt(MAX_VALUE);
	}
	
	//================================================================================
	// Accessors
	//================================================================================
	
	public String getTransaction() {
		if (this.getSender() == null) {
			return "Genesis";
		}
		return index + ") " + sender + "-" + receiver + " :" + randomNumber;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getSum() {
		return sum;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}
	
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public int getRandomNumber() {
		return randomNumber;
	}
	
	//================================================================================
	// Methods
	//================================================================================

	public String convertTime(long time) {
	    Date date = new Date(time);
	    Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    return format.format(date);
	}
	
	public String concatenateTransaction() {
		if (this.getSender() == null) {
			return "Genesis";
		}
		return ( this.getSender() + this.getReceiver() + this.getRandomNumber() );
	}
}
