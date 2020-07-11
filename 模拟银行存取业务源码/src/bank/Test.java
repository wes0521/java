package bank;

import java.util.*;

public class Test {
	static {
		System.out.println("----------------");
		System.out.println("��ӭ������������!");
		System.out.println("----------------");
	}
	public static HashMap<String, Users> user = new HashMap<String, Users>();
	public static void main(String[] args) {
		Users us1 = new Users("1001","����˧","11111",5000);
		Users us2 = new Users("1002","����","22222",4000);
		Users us3 = new Users("1003","�ŷ�","33333",3000);
		Users us4 = new Users("1004","����","44444",2000);
		/*
			�Ѹ��û�����Ϣ�洢��������
		*/
		user.put(us1.getCardID(), us1);
		user.put(us2.getCardID(), us2);
		user.put(us3.getCardID(), us3);
		user.put(us4.getCardID(), us4);
		String Id = login();
		choose(Id);
	}
	public static void menu() {//�˵�����
		System.out.println("��������Ҫ���еĲ�������,���س�������!");
		System.out.println("1:���");
		System.out.println("2:ȡ��");
		System.out.println("3:��ѯ");
		System.out.println("0:�˳�");
	}
	public static String login() {//��¼����
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		HashMap<String, Users> u = Test.user;//�洢�˻�����Ϣ
		int flag=0;
		String idThis = null;
		while(true) {//��������п��Ŵ���������ѭ��
			System.out.println("�������������п���:");
			String id = null;
			int b=0,n;
			if(b==0) {
				id = in.nextLine();
			}
			if(!u.containsKey(id)) {//�ж���������п����Ƿ��Ѵ���
				System.out.println("�޴˿���,��1��������,��������˳�:");
				n = in.nextInt();
				if(n != 1) {
					flag = 1;
					b++;
					break;
				}
				else {
					id = in.nextLine();
				}
			}
			else {
				 idThis = id;
				break;
			}
		}
		if(flag == 1) {//�ж��Ƿ�Ҫ�˳�ϵͳ
			exit();
		}
		while(true) {//��������п�������ͬ������ѭ��
			int l = 0;
			System.out.println("�������������п�����:");
			String pswd = in.nextLine();
			l++;
			if(!pswd.equals(u.get(idThis).getPasswd())) {//�ж���������п������Ƿ���ͬ
				System.out.println("����������벻��,��1��������,��������˳�:");
				int num = in.nextInt();
				if(num != 1) {
					exit();//����������˳�
				}
				else {
					if(l>0) {
						pswd = in.nextLine();
					}
				}
			}
			else {
				System.out.println("����������ȷ,��¼�ɹ�!");
				System.out.println("��ӭ��,"+u.get(idThis).getName()+"����!");
				try {
			            Thread.sleep(1000);
			    } catch (InterruptedException e) {
			            e.printStackTrace(); 
			    }//��ʱ1��
				return idThis;
			}
		}
	}
	
	public static void readMoney(String idthis) {//����
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		HashMap<String, Users> u = Test.user;
		System.out.println("��������Ҫ����Ľ��:");
		double money = in.nextDouble();
		u.get(idthis).setMoney(u.get(idthis).getMoney() + money);//��Ҫ����Ľ������û������
		System.out.println("�Ƿ�Ҫ�鿴��ǰ�����?");
		System.out.println("��1ȷ��,��2ȡ��!");
		int sw = in.nextInt();
		while(true) {//�ж��Ƿ�鿴��ǰ���
			if(sw == 1) {
				showMoney(idthis);
				break;
			}
			else if(sw == 2){
				return ;
			}
			else {
				System.out.println("��������ȷ��ѡ��:");
				sw = in.nextInt();
			}
		}
	}
	public static void writeMoney(String idthis) {//ȡ���
		HashMap<String, Users> us1 = Test.user;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("��������Ҫȡ���Ľ��:");
		double money = in.nextDouble();
		while(true) {
			if(us1.get(idthis).getMoney()<money) {//�ж��˻��������Ƿ��㹻
				System.out.println("��������,������������Ҫȡ��Ľ��:");
				money = in.nextDouble();
			}
			else {
				us1.get(idthis).setMoney(us1.get(idthis).getMoney() - money);//���û���������ȥȡ���Ľ��
				break;
			}
		}
		System.out.println("�Ƿ�Ҫ�鿴��ǰ�����?");
		System.out.println("��1ȷ��,��2ȡ��!");
		int sw = in.nextInt();
		while(true) {
			if(sw == 1) {//�Ƿ�鿴��ǰ���
				showMoney(idthis);
				break;
			}
			else if(sw == 2){
				return ;
			}
			else {
				System.out.println("��������ȷ��ѡ��:");
				sw = in.nextInt();
			}
		}
	}
	public static void showMoney(String idThis) {//��ѯ����
		HashMap<String, Users> us1 = Test.user;
		System.out.println("����ǰ���Ϊ:"+us1.get(idThis).getMoney());
	}
	public static void exit() {//�˳�����
		System.out.println("��ӭ�´�ʹ��,�ټ�!");
		System.exit(0);
	}
	public static void choose(String idThis) { //����ѡ����
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int k = 0;
		while(true) {
			if(k == 0) {
				menu();
			}
			int n = in.nextInt();
			switch(n) {
				case 0:exit();
				case 1:readMoney(idThis);break;
				case 2:writeMoney(idThis);break;
				case 3:showMoney(idThis);break;
				default:System.out.println("��������������ѡ��:");k++;
			}
		}
	}
}

