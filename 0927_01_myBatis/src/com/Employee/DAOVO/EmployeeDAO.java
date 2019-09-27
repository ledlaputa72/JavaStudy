package com.Employee.DAOVO;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmployeeDAO {
	
	private static SqlSessionFactory sqlSessionFactory1;
	static {
		String myxml="Mybatis-config.xml";
		InputStream istream=null;
		
		try {
			istream=Resources.getResourceAsStream(myxml);
			//�갡 Mybatie-config.xml ȯ�漳�������� �о� ���δ� 
		} catch(IOException e) {
			e.printStackTrace();
		}
		//���̹�Ƽ�� configuration file(��������)�� �о� 
		// SqlSessionFactory ��ü�� �����ȴ�. 
		sqlSessionFactory1=new SqlSessionFactoryBuilder().build(istream);
		
	}
	
	public static List<EmployeeVO> employeeAllData(){ 
		//employee-mapper.xml �� <select id="employeeAllDate" 
		
		return sqlSessionFactory1.openSession().selectList("employeeAllData");
		//���⼭ sqlSessionFactory�� query ���� --> mapper.xml�� select������ 
		// ��ü ����� ����� selsctList()�� ���� ���̰� 
	}
	
	public static EmployeeVO employeeSearchData(int employee_id){
		//employee-mapper.xml �� <select id="employeeSearchData
		
		return sqlSessionFactory1.openSession().selectOne("employeeSearchData", employee_id);
	}
	
	

}
