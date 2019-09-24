package hello;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.sun.xml.internal.ws.api.server.SDDocument;

import helloProcess.SawonDAO;
import helloProcess.SawonVO;

public class Hello {
	
	public static SawonDAO sd1;

	/*<bean id="sawonDAOBean" class="helloProcess.Sawon">
	 * Nproperty name="jdbcTemplate" ref="jdbcTempalteBean"/>		 * 
	</bean>*/
	/*
	 * SawonDAO¿¡ jdbTemplateÀû¿ë 
	 * SawonDAO sawonDAOBean= new SawonDAO()
	 */
	
	public static void main (String[] args) {
		ApplicationContext ac1 = new GenericXmlApplicationContext("jdbctemplatexml.xml");
		sd1 = (SawonDAO)ac1.getBean("sawonDAOBean");
		
		kaja();
		sd1.update1();
		kaja();
		
		((AbstractApplicationContext)ac1).close();
	}
		
	public static void kaja() {
		ArrayList<Object> alist1 = sd1.selectAll();
		Iterator<Object> it1=alist1.iterator();
		
		while(it1.hasNext()) {
			SawonVO sv1 = (SawonVO) it1.next();
			System.out.print(sv1.getName() + "\t" + sv1.getTel());
			System.out.println();
			}//Iterator end
	}
				
}
