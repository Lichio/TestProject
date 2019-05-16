### ģʽ�ṹ
�򵥹���ģʽ�����Ľ�ɫ��
- ������Factory����������ݲ�ͬ���������ͬ�ľ����Ʒ
- �����Ʒ��Product�����ɹ����������Ķ���ĸ��࣬�����ǹ�ͬӵ�еĽӿ�
- �����Ʒ��ConcreteProduct�����ɹ��������ľ���ʵ��

![image](../../../../resources/static/simple_factory.png)

### ʾ��
����Ŀ¼�µ�������

![image](../../../../resources/static/simple_factory_example.png)

�˴���AnimalΪ������

### ����Ӧ�÷���
1. JDK�е�java.text.DateFormat
```java
public abstract class DateFormat extends Format{
	public final static DateFormat getDateInstance(int style);
}
```
���ݲ�ͬ��style������ͬ��Format����ʵ��

2. javax.crypto.KeyGenerator
```java
public class KeyGenerator {
	public static final KeyGenerator getInstance(String var0);
}
```
�����㷨��������ͬ�ļ����㷨����ʵ��
```
KeyGenerator keyGen=KeyGenerator.getInstance("DES");
```

3. MyBatis�е�SqlSessionFactory
```java
public interface SqlSessionFactory {
	
	SqlSession openSession();

  	SqlSession openSession(boolean autoCommit);

  	SqlSession openSession(Connection connection);
  	
  	SqlSession openSession(TransactionIsolationLevel level);

  	SqlSession openSession(ExecutorType execType);

 	SqlSession openSession(ExecutorType execType, boolean autoCommit);

 	SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level);

 	SqlSession openSession(ExecutorType execType, Connection connection);

 	Configuration getConfiguration();

}
```
�û������Ĵ���SqlSession��ϸ�ڣ�ֻϣ���ڲ�ͬ������ܹ������Ӧ���õ�SqlSession����

### Ӧ�ó���
- �ͻ���ֻ֪�����빤����Ĳ�����������δ������󲻹��ġ�
- �����ฺ�𴴽��Ķ���Ƚ��٣����ڴ����Ķ�����٣�������ɹ��������е�ҵ���߼�̫�����ӡ�

### �ܽ�
- �򵥹���ģʽ�ֳ�Ϊ��̬��������ģʽ���������ഴ����ģʽ���ڼ򵥹���ģʽ�У����Ը��ݲ����Ĳ�ͬ���ز�ͬ���ʵ�����򵥹���ģʽר�Ŷ���һ���������𴴽��������ʵ������������ʵ��ͨ�������й�ͬ�ĸ��ࡣ
- �򵥹���ģʽ�����ŵ�����ʵ���˶��󴴽��Ͷ���ʹ�õķ��룬������Ĵ�������ר�ŵĹ����ฺ��������ȱ�����ڹ����಻���������µľ����Ʒ��Ҫ�޸Ĺ�������ж��߼����룬���Ҳ�Ʒ�϶�ʱ�������������뽫��ǳ����ӡ�