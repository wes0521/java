package bank;

class Users {
	private String cardID;//���п���
	private String name;//�ֿ�����
	private String passwd;//���п�����
	private double money;//���п����
	
	public Users() {//�����޲�
	}

	public Users(String cardID, String name, String passwd, double money) {
		super();
		this.cardID = cardID;
		this.name = name;
		this.passwd = passwd;
		this.money = money;
	}

	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
}
