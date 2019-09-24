package helloProcess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class SawonDAO {

   private ArrayList<Object> alist1;
   private JdbcTemplate jt1;
   
   public JdbcTemplate getJdbcTemplate() {
      return jt1;
   }
   
   public void setJdbcTemplate(JdbcTemplate jt1) {
      this.jt1 = jt1;
   }
   
   // ��� ����ϴ� �޼ҵ�
   public ArrayList<Object> selectAll() {
      
      // ���ڿ��� ��ȭ�� ���� �� ���
      StringBuffer sb1 = new StringBuffer();
      
      sb1.append("SELECT name, tel FROM TelTable");
      
      // RowMapper �� import �� �� swing �� �ƴ� springframework �� �Ѵ�.
      alist1 = (ArrayList<Object>)getJdbcTemplate().query(sb1.toString(), new RowMapper<Object>() {
         
         public Object mapRow(ResultSet rs1, int joolBun1) throws SQLException {
            
            SawonVO sv1 = new SawonVO();
            
            System.out.println("�� ��ȣ =" + joolBun1);
            
            sv1.setName(rs1.getString("name"));
            sv1.setTel(rs1.getString("tel"));
            
            return sv1;
            
         }
         
      });
      
      System.out.println("�ڷ� �� ���� : " + kajaSoo());
      
      return alist1;
      
   }
   
   
   public int kajaSoo() {
	   //int soo=jt1.queryForInt("select count(name) from Teltable
	   int soo=jt1.queryForObject("select count(name) from TelTable", Integer.class); //����� one row
	   return soo;
   } //kajasoo() end 
   
}