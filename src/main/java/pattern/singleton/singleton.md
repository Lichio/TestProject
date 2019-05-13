### ģʽ�ṹ
Singleton2ʵ�ַ�ʽ����ͼ

![ClassDiagram](static/΢��ͼƬ_20190513182335.png)

### ʾ��
����ʵ�ַ�ʽ����Ŀ¼�µ�������

### ����Ӧ�÷���
1. JDK��java.lang.Runtime���װ��java����ʱ������ÿһ��java����������һ��JVM���̣���ÿ��JVM���̶���ֻ��Ӧһ������ʱ������Runtimeʵ�������Ҵ�ʵ������JVMΪ��ʵ�����ġ�ʵ�ַ�ʽΪ����ʽ��ͬSingleton3����
```java
public class Runtime {
    private static Runtime currentRuntime = new Runtime();
    
    public static Runtime getRuntime() {
    	return currentRuntime;
    }
      
    private Runtime() {}
}
```
2. MyBatis��org.apache.ibatis.executor.ErrorContext�����ڼ�¼��ǰִ���߳���ִ�л����еĴ�����Ϣ��һ���߳�ֻ��Ҫһ��ʵ����
```java
public class ErrorContext {

    private static final ThreadLocal<ErrorContext> LOCAL = new ThreadLocal<ErrorContext>();

    private ErrorContext() {
    }

    public static ErrorContext instance() {
        ErrorContext context = LOCAL.get();
        if (context == null) {
            context = new ErrorContext();
            LOCAL.set(context);
        }
        return context;
    }
}    
```


### Ӧ�ó���
- ��Щ����ֻ��Ҫһ�����̳߳ء����桢��־�����
- ����Ƶ���ش���������
- ����Ĵ������̺ķѺܶ���Դ
