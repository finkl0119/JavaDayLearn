package Q_JAVA_DATABASE;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**

USE cookDB;
DROP TABLE IF EXISTS teltbl;
create table teltbl 
(
	userName char(3) NOT NULL PRIMARY KEY
	, telephone CHAR(15) NOT NULL
	, addr VARCHAR(50) NOT NULL
	, gender CHAR(1) NOT NULL
	, createDt DATETIME NOT NULL
);

*/

class DataBase_Insert {
	
	public void insert() {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cookdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
			pstmt = conn.prepareStatement("INSERT INTO TELTBL (USERNAME,TELEPHONE,ADDR,GENDER,CREATEDT) VALUES (?, ?, ?, ?, NOW())");
			
			System.out.printf("이름: ");
			String userName = scan.next();
			
			System.out.printf("전화번호: ");
			String telephone = scan.next();
			
			System.out.printf("주소: ");
			String addr = scan.next();
			
			System.out.printf("성별: ");
			String gender = scan.next();

			pstmt.setString(1, userName);
			pstmt.setString(2, telephone);
			pstmt.setString(3, addr);
			pstmt.setString(4, gender);
			
			pstmt.executeUpdate();
	
		} catch (Exception e) {
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
	}
}

class DataBase_Search {

	public void search() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cookdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
			
			System.out.printf("검색어: ");
			String searchText = scan.next();
			pstmt = conn.prepareStatement("select * from telTBL WHERE userName LIKE"+ "'%" + searchText + "%'");
			rs = pstmt.executeQuery(); 
			System.out.println("이름"+"\t"+"전화번호"+"\t\t"+"주소"+"\t"+"성별"+"\t"+"날짜");
			
			while (rs.next()) {
				String userName = rs.getString("USERNAME");
				String telephone = rs.getString("TELEPHONE");
				String addr = rs.getString("ADDR");
				String gender = rs.getString("GENDER");
				Date createDt = rs.getDate("CREATEDT");
					
				System.out.println(userName+"\t"+telephone
						+"\t"+addr+"\t"+gender+"\t"+createDt);
			}
		} catch (Exception e) {
			
		} finally {
			try {
					rs.close();
					pstmt.close();
					conn.close();
			} catch (Exception e) {}
		}
	}
}


class DataBase_Select {

	public void select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cookdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
			pstmt = conn.prepareStatement("select * from telTBL");
			rs = pstmt.executeQuery(); 
			System.out.println("이름"+"\t"+"전화번호"+"\t\t"+"주소"+"\t"+"성별"+"\t"+"날짜");
			while (rs.next()) {
				String userName = rs.getString("USERNAME");
				String telephone = rs.getString("TELEPHONE");
				String addr = rs.getString("ADDR");
				String gender = rs.getString("GENDER");
				Date createDt = rs.getDate("CREATEDT");
				
				System.out.println(userName+"\t"+telephone
						+"\t"+addr+"\t"+gender+"\t"+createDt);
			}
		}		
		catch (Exception e) {
		} finally {
			try {
					rs.close();
					pstmt.close();
					conn.close();
			} catch (Exception e) {}
		}
	}
}

class DataBase_Delete {

	public void delete() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cookdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
			
			pstmt = conn.prepareStatement("DELETE FROM TELTBL");
			pstmt.executeUpdate();
		} catch (Exception e) {
			
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
			}
		}
	}
}

public class FirstDB {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int inputNo = 0;
		
		while (true) {
			System.out.println("");
			System.out.println("실행할 쿼리문을 선택하십시오.");
			System.out.println("1.추가 2.찾기 3.전체출력 4.삭제 5.종료");
			
			inputNo = scan.nextInt();
			
			if (inputNo == 1) {
				DataBase_Insert insert = new DataBase_Insert();
				insert.insert();
			} else if (inputNo == 2) {
				DataBase_Search search = new DataBase_Search(); 
				search.search();
			} else if (inputNo == 3) {
				DataBase_Select select = new DataBase_Select(); 
				select.select();
			} else if (inputNo == 4) {
				DataBase_Delete delete = new DataBase_Delete(); 
				delete.delete(); 
			} else {
				scan.close();
				break;
			}			
		}
	}

}
