package com.Employee.DAOVO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
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
	
	//AllData view 
	public static List<EmployeeVO> employeeAllData(){ 
		//employee-mapper.xml �� <select id="employeeAllDate" 
		
		return sqlSessionFactory1.openSession().selectList("employeeAllData");
		//���⼭ sqlSessionFactory�� query ���� --> mapper.xml�� select������ 
		// ��ü ����� ����� selsctList()�� ���� ���̰� 
	}
	
	//Select Data view 
	public static EmployeeVO employeeSearchData(int employee_id){
		//employee-mapper.xml �� <select id="employeeSearchData
		
		return (EmployeeVO) sqlSessionFactory1.openSession().selectOne("employeeSearchData", employee_id);
	}
	
	//Select Data view 
	public static EmployeeVO employeeSearchData2(int employee_id, String last_name){
		//hashmap 
		HashMap hm1=new HashMap();
		hm1.put("employee_id", employee_id);
		hm1.put("last_name", last_name);
		
		return (EmployeeVO) sqlSessionFactory1.openSession().selectOne("employeeSearchData2", hm1);
	}
	
	//Insert Data 
	public static int employeeInsertData(EmployeeVO employeeVO) { 
		SqlSession sqlsession1 = sqlSessionFactory1.openSession();
		sqlsession1.insert("employeeInsertData", employeeVO);
		sqlsession1.commit();
		return sqlsession1.insert("employeeInsertData", employeeVO);
	}
	
	//Update Data
	public static int employeeUpdateData(EmployeeVO employeeVO) { 
		SqlSession sqlsession1 = sqlSessionFactory1.openSession();
		sqlsession1.update("employeeUpdateData", employeeVO);
		sqlsession1.commit();
		return sqlsession1.update("employeeUpdateData", employeeVO);
	}
	
	//Delete Data
	public static int employeeDeleteData(int employee_id) { 
		SqlSession sqlsession1 = sqlSessionFactory1.openSession();
		sqlsession1.delete("employeeDeleteData", employee_id);
		sqlsession1.commit();
		return sqlsession1.delete("employeeDeleteData", employee_id);
	}
	

}
