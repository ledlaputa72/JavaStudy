package hello;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import helloProcess.SawonDAO;
import helloProcess.SawonVO;

public class Hello {
	
	public static void main (String[] args) {
		ApplicationContext ac1 = new GenericXmlApplicationContext("jdbctemplatexml.xml");
		SawonDAO sd1 = (SawonDAO)ac1.getBean("sawonDAOBean");
		/*<bean id="sawonDAOBean" class="helloProcess.Sawon">
		 * Nproperty name="jdbcTemplate" ref="jdbcTempalteBean"/>		 * 
		</bean>*/
		/*
		 * SawonDAO¿¡ jdbTemplateÀû¿ë 
		 * SawonDAO sawonDAOBean= new SawonDAO()
		 */
		
		ArrayList<Object> alist1 = sd1.selectAll();
		
		Iterator<Object> it1=alist1.iterator();
		while(it1.hasNext()) {
			SawonVO sv1 = (SawonVO) it1.next();
			System.out.print(sv1.getName() + "\t" + sv1.getTel());
			System.out.println();
		}//Iterator end
		((AbstractApplicationContext)ac1).close();
	} //main end

}
