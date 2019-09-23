package configurationbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import constarg.Constarg;
import insa.Insa;

//���� annotation�� �� �ּ��� �ް� ���� 
@Configuration // ȯ�漳�� ���� 
public class ConfigurationBean {

	//applicarionContext1.xml --> Configurarion.java 
	//src���� �ȿ� ��Ű���ȿ� .java����� �� 
	//���⿡ bean�½��� ������ ��ġ @Bean���� ���� 
	@Bean //�̰� ��ü�� insaBean() �޼ҵ� 
	public Insa insaBean() { //�̸��� id����=[��ü��]
							//�̰��� ȣ�⿡ ���� �޼ҵ����ǹ� ���� 
		return new Insa("ȫ�浿"); //��ü ����� ���� 
	} //new Insa("ȫ�浿")��ü�� bean ��ü 
	
	public Constarg constargBean() { //id = bean��ü ���� 
		return new Constarg(insaBean()); //insaBean()�� �޼ҵ� ȣ�⹮ 
		
	}
}

