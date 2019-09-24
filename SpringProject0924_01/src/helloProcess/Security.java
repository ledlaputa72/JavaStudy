package helloProcess;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //���Ⱑ xml�� <aop:aspect>�κ� ��, AspectJ�� ����� 
public class Security {
	
	//��  xml�� pointcut �κ� // �����Ұ��� kajaDrive()
	@Pointcut("execution(* helloProcess..*())") 
	//helloProcess Ŭ���� �ؿ� ��� �޼ҵ�(���ڰ� ����)�� ���� == kajaDrive()
	//�������� Pointcut ����� �޼ҵ� only
	
	private void mukja() {
		//�ƹ� �޼ҵ带 ���� 
		//��Ը� ���� , �׸��� ������ ���� mukja() �̰� ����� 
		//�������̼��� ���������� �ƹ� �޼ҵ� ���� ��ġ�ؾ� �ϹǷ� �� �޼ҵ� ����� ���� 
	}
	
	//�׷����� mukja()�� ���� �ѹ� �Ẹ�� 
	//before  ��, kajaDrive() �������� goSecurity() ���� �Ѵٴ�
//	@Before("mukja()") //������ ���� ���´�. 
	@After("mukja()") //������ ���߿� ���´�. 
	public void goSecurity() {
		System.out.println("���� : ����� ���� ó�� ��~");
	}
	//�ֿ�޼ҵ忡 before�� ����, ��������� goSecurity()

}
