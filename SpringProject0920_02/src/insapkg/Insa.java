package insapkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Insa Ŭ���� ���� ���� ���´٤�
@Component("insa10") // or @Component(value="insa10")
//==> <bean id="insa10" ... 
//"insa10"�� �������� �ڵ����� Ŭ������"Insa"�� "insa"�� �ٲ㼭 �̸��� �ڵ� �����Ѵ�.  
//�׷��ϱ�  <context:component-scan base-package="insapkg"/>�� 
//Insa Ŭ������ applicationContext�� bean���� ��Ͻ��� 
// ��Ŭ������ spring bean�̶�� �˷��ش�. 

public class Insa {
	
	// property .. value = "ȫ�浿"... �� ���� annotation 
	/*<bean id="insabean" class="insapkg.Insa">
	<property name="name" value="ȫ�浿">
	</bean>*/
	@Value("ȫ�浿") //������Ƽ�� 
	
	private String name; //setName("ȫ�浿") or �����ڷ� ó�� 
	
	//������
	public Insa(String name) { //������ �����ε� 
		this.name = name;
	}
	
	public Insa() { //����Ʈ ������ 		
	}
	
	//setter getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//��� ���� 
	public String helloName(String str1) {
		return this.name + " ��\n" + str1;
	}
}
