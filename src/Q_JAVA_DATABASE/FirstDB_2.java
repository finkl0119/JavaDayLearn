package Q_JAVA_DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

class MySql{
	private static Connection conn;//�����ͺ��̽� ������ ����
	private static PreparedStatement pstmt;//���� �غ� �Ŀ� �������� ������
	private static ResultSet rs = null;//select�� ����� ���� ��
	private static Statement stmt;//�������� ������
	public static Connection getConn() {
		return conn;
	}
	public static void setConn(Connection conn) {
		MySql.conn = conn;
	}
	public static PreparedStatement getPstmt() {
		return pstmt;
	}
	public static void setPstmt(PreparedStatement pstmt) {
		MySql.pstmt = pstmt;
	}
	public static ResultSet getRs() {
		return rs;
	}
	public static void setRs(ResultSet rs) {
		MySql.rs = rs;
	}
	public static Statement getStmt() {
		return stmt;
	}
	public static void setStmt(Statement stmt) {
		MySql.stmt = stmt;
	}

}


class Tel{
	
	private String name;
	private String tel;
	private String addr;
	private String saung;

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getSaung() {
		return saung;
	}
	public void setSaung(String saung) {
		this.saung = saung;
	}

	
	
	Tel(String name, String tel, String addr, String saung){
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.saung = saung;
	}
}



public class FirstDB_2 {
	
	
	public static String saungCheck(Integer saung) {
		
		if(saung == 1) {
			return "��";
		}
		else {
			return "��";
		}
		
	}
	
	

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		new MySql();
		
		MySql.setConn(DriverManager
				.getConnection("jdbc:mysql://localhost:3306/cookdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234"));
		
		String result ="";
		
		
		while(true) {
			System.out.println("1.�߰� 2.ã�� 3.��ü��� 4.���� 5.����");
			 int select1 = sc.nextInt();
			
			 if(select1 == 1) {
				 System.out.println("�̸�: ");
				 String name = sc.next();
				 System.out.println("��ȭ��ȣ: ");
				 String tel = sc.next();
				 System.out.println("�ּ�: ");
				 String addr = sc.next();
				 System.out.println("����(��1, ��2): ");
				 Integer saung = sc.nextInt();
				 
				 Tel saveTel = new Tel(name,tel,addr,saungCheck(saung));
				 
				  MySql.setPstmt(MySql.getConn().prepareStatement("insert into teltbl values (?,?,?,?,?)"));
				  
				  
				  
				 MySql.getPstmt().setString(1, saveTel.getName());
				 MySql.getPstmt().setString(2, saveTel.getTel());
				 MySql.getPstmt().setString(3, saveTel.getAddr());
				 MySql.getPstmt().setInt(4, saung);
				 MySql.getPstmt().setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
				 MySql.getPstmt().executeUpdate();
			 
			 }
			 
			 if(select1 == 2) {
				 System.out.println("�̸�: ");
				 String name = sc.next();
				 
				 MySql.setPstmt(MySql.getConn().prepareStatement("select * from telTBL where userName = ?"));
				 
				 MySql.getPstmt().setString(1, name);
				 MySql.setRs(MySql.getPstmt().executeQuery());
				 
				 
				 if(MySql.getRs() != null) {
					 while(MySql.getRs().next()) {
						 String sqlName = MySql.getRs().getString("userName");
						 String sqlTel = MySql.getRs().getString("telephone");
						 String sqlAddr = MySql.getRs().getString("addr");
						 String sqlSaung = MySql.getRs().getString("gender");
						 String sqlTime = MySql.getRs().getString("createDt");
						 System.out.println(sqlName + "\t " + sqlTel + "\t " + sqlAddr +"\t " + sqlSaung + "\t " + sqlTime + "\t ");
					 }
				 }
			 }
			
			if(select1 == 3) {
				MySql.setPstmt(MySql.getConn().prepareStatement("select * from telTBL"));
				 
				MySql.setRs(MySql.getPstmt().executeQuery());
				 
				if(MySql.getRs() != null) {
					while(MySql.getRs().next()) {
						 String sqlName = MySql.getRs().getString("userName");
						 String sqlTel = MySql.getRs().getString("telephone");
						 String sqlAddr = MySql.getRs().getString("addr");
						 String sqlSaung = MySql.getRs().getString("gender");
						 String sqlTime = MySql.getRs().getString("createDt");
						 System.out.println(sqlName + "\t " + sqlTel + "\t " + sqlAddr +"\t " + sqlSaung + "\t " + sqlTime + "\t ");
				
					}
				}
			}
			
			
			if(select1 == 4) {
				 System.out.println("�̸�: ");
				 String name = sc.next();
				 
				
				 MySql.setPstmt(MySql.getConn().prepareStatement("delete from telTBL where userName = ?"));
				
				 MySql.getPstmt().setString(1, name);
				 MySql.getPstmt().executeUpdate();
			}
			
		}

	}

}
