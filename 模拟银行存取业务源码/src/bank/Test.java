package bank;

import java.util.*;

public class Test {
	static {
		System.out.println("----------------");
		System.out.println("欢迎进入网上银行!");
		System.out.println("----------------");
	}
	public static HashMap<String, Users> user = new HashMap<String, Users>();
	public static void main(String[] args) {
		Users us1 = new Users("1001","王恩帅","11111",5000);
		Users us2 = new Users("1002","刘备","22222",4000);
		Users us3 = new Users("1003","张飞","33333",3000);
		Users us4 = new Users("1004","关羽","44444",2000);
		/*
			把各用户的信息存储进集合里
		*/
		user.put(us1.getCardID(), us1);
		user.put(us2.getCardID(), us2);
		user.put(us3.getCardID(), us3);
		user.put(us4.getCardID(), us4);
		String Id = login();
		choose(Id);
	}
	public static void menu() {//菜单函数
		System.out.println("请输入您要进行的操作类型,按回车键结束!");
		System.out.println("1:存款");
		System.out.println("2:取款");
		System.out.println("3:查询");
		System.out.println("0:退出");
	}
	public static String login() {//登录函数
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		HashMap<String, Users> u = Test.user;//存储账户的信息
		int flag=0;
		String idThis = null;
		while(true) {//输入的银行卡号存在则跳出循环
			System.out.println("请输入您的银行卡号:");
			String id = null;
			int b=0,n;
			if(b==0) {
				id = in.nextLine();
			}
			if(!u.containsKey(id)) {//判断输入的银行卡号是否已存在
				System.out.println("无此卡号,按1重新输入,按任意键退出:");
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
		if(flag == 1) {//判断是否要退出系统
			exit();
		}
		while(true) {//输入的银行卡密码相同则跳出循环
			int l = 0;
			System.out.println("请输入您的银行卡密码:");
			String pswd = in.nextLine();
			l++;
			if(!pswd.equals(u.get(idThis).getPasswd())) {//判断输入的银行卡密码是否相同
				System.out.println("您输入的密码不对,按1重新输入,按任意键退出:");
				int num = in.nextInt();
				if(num != 1) {
					exit();//按按任意键退出
				}
				else {
					if(l>0) {
						pswd = in.nextLine();
					}
				}
			}
			else {
				System.out.println("密码输入正确,登录成功!");
				System.out.println("欢迎您,"+u.get(idThis).getName()+"先生!");
				try {
			            Thread.sleep(1000);
			    } catch (InterruptedException e) {
			            e.printStackTrace(); 
			    }//延时1秒
				return idThis;
			}
		}
	}
	
	public static void readMoney(String idthis) {//存款函数
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		HashMap<String, Users> u = Test.user;
		System.out.println("请输入您要存入的金额:");
		double money = in.nextDouble();
		u.get(idthis).setMoney(u.get(idthis).getMoney() + money);//把要存入的金额存入用户余额里
		System.out.println("是否要查看当前的余额?");
		System.out.println("按1确认,按2取消!");
		int sw = in.nextInt();
		while(true) {//判断是否查看当前余额
			if(sw == 1) {
				showMoney(idthis);
				break;
			}
			else if(sw == 2){
				return ;
			}
			else {
				System.out.println("请输入正确的选项:");
				sw = in.nextInt();
			}
		}
	}
	public static void writeMoney(String idthis) {//取款函数
		HashMap<String, Users> us1 = Test.user;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("请输入您要取出的金额:");
		double money = in.nextDouble();
		while(true) {
			if(us1.get(idthis).getMoney()<money) {//判断账户里的余额是否足够
				System.out.println("您的余额不足,请重新输入您要取款的金额:");
				money = in.nextDouble();
			}
			else {
				us1.get(idthis).setMoney(us1.get(idthis).getMoney() - money);//从用户的余额里减去取出的金额
				break;
			}
		}
		System.out.println("是否要查看当前的余额?");
		System.out.println("按1确认,按2取消!");
		int sw = in.nextInt();
		while(true) {
			if(sw == 1) {//是否查看当前余额
				showMoney(idthis);
				break;
			}
			else if(sw == 2){
				return ;
			}
			else {
				System.out.println("请输入正确的选项:");
				sw = in.nextInt();
			}
		}
	}
	public static void showMoney(String idThis) {//查询余额函数
		HashMap<String, Users> us1 = Test.user;
		System.out.println("您当前金额为:"+us1.get(idThis).getMoney());
	}
	public static void exit() {//退出函数
		System.out.println("欢迎下次使用,再见!");
		System.exit(0);
	}
	public static void choose(String idThis) { //功能选择函数
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
				default:System.out.println("请重新输入您的选项:");k++;
			}
		}
	}
}

