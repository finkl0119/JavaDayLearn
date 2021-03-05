package Q_JAVA_DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstDB_1 {
	private static Connection conn;//�����ͺ��̽� ������ ����
	private static PreparedStatement pstmt;//���� �غ� �Ŀ� �������� ������
	private static ResultSet rs = null;//select�� ����� ���� ��
	private static Statement stmt;//�������� ������
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String result = "";
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cookdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
		pstmt = conn.prepareStatement("select * from userTBL");
		rs = pstmt.executeQuery();
		//2��
		//		stmt = conn.createStatement();
		//		String sql ="select * from userTBL";
		//		rs = stmt.executeQuery(sql);
		if( rs!=null ){
			while( rs.next()){
				String userID = rs.getString("userID");
				String userName = rs.getString("userName");
				String birthYear = rs.getString("birthYear");
				String addr = rs.getString("addr");
				String mobile1 = rs.getString("mobile1");
				String mobile2 = rs.getString("mobile2");
				String height = rs.getString("height");
				String mDate = rs.getString("mDate");
				System.out.println(userID+"\t"+userName+"\t  "+birthYear
						+"\t   "+addr+"\t    "+mobile1+"\t"+mobile2+"\t"
						+height+"\t"+mDate);
			}
		}
		System.out.println(result);
		/*
		pstmt = conn.prepareStatement(" insert into userTBL values (?,?,?,?,?,?,?,?)");
		pstmt.setString(1, d.getA());
		pstmt.setString(2, d.getB());
		pstmt.setString(3, d.getC());
		pstmt.setInt(4, d.getD());
		pstmt.setInt(5, d.getE());
		pstmt.setInt(6, d.getF());
		pstmt.setInt(7, d.getE());
		pstmt.setInt(8, d.getF());
		 */
	}

}
