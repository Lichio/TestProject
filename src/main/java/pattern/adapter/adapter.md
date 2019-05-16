### ģʽ�ṹ
������ģʽ�����Ľ�ɫ��
- Ŀ��ӿڣ�Target�����ͻ�Ҫ�õ��ض�����Ľӿ�
- ��������Adapter����������һ���ӿڣ���Ϊһ��ת�������������ߺͳ���Ŀ�����������
- �����ߣ�Adaptee����������Ľ�ɫ����������һ���Ѿ����ڵĽӿڣ�����ӿ���Ҫ����
- �ͻ���Client��

������ģʽ��**����������**��**��������**����ʵ�֡�

#### ����������
![](../../../resources/static/adapter_object.png)

#### ��������
![](../../../resources/static/adapter_class.png)

�ͻ����ڴ�ʹ��request()��������Adaptee�ಢû�и÷�����Ϊ��ʹClient�ܹ�ʹ��Adaptee�࣬�ṩһ����������Adapter��Adapterʵ����request()����������request()�����е���Adaptee��Ĺ��ܣ�����ʹClient�ܹ����ʹ��Adaptee��Ĺ��ܡ�

> ������������ʵ������������ͨ��**���**�ķ�ʽ�����������ߵĹ��ܣ�����������ʵ������������ͨ��**�̳�**�ķ�ʽ�����������ߵĹ��ܡ�

### ʾ��
����Ŀ¼�µ�������

![](../../../resources/static/adapter_example.png)

����Television�ǿͻ���IPower220v��Ŀ��ӿڣ�PowerAdapter����������Power110v�������ߡ�

������ڵ�����Ҫ�������ѹΪ220v���������׼�����ѹΪ110v�����ǽ�����Դ��������110vת����220v��

### ����Ӧ�÷���
1. SpringMVC�е�HandlerAdapter

![](../../../resources/static/springmvc.png)

����ͼ��֪��DispatcherServlet���յ�������ͨ��HandlerMapping����ȡ�����Ӧ�Ĵ�����Handler�����������ж���ʵ�֣�Controller��HttpRequestHandler��HandlerMethod�ȣ�����ͬ�Ĵ�����ʵ�ִ�������ķ�ʽ��ͬ����Ϊǰ�˿�������DispatcherServlet����������θ�������ѡ����ʴ���������ϸ�ڣ���������һ��ͳһ�ķ�����HandlerAdapter��handle()��������ִ�����󣬼�����ͬ�������Ĵ�����ͳһ�����handle()������

```java
public interface HandlerAdapter {

	boolean supports(Object handler);

	ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception;

	long getLastModified(HttpServletRequest request, Object handler);

}
```

![](../../../resources/static/adapter_application_1.png)

����DispatcherServletΪClient��HandlerAdapterΪTarget��HandlerAdapterImpl(��ʾHandlerAdapter��ʵ����)ΪAdapter��HandlerClass����ʾ������ʵ���ࣩΪAdaptee��

- ��������ΪController����ʱ��������ΪSimpleControllerHandlerAdapter
```java
public interface Controller {

	ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
```

![](../../../resources/static/adapter_application_2.png)

- ��������ΪHttpRequestHandler����ʱ��������ΪHttpRequestHandlerAdapter

```java
public interface HttpRequestHandler {

	void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

}
```

![](../../../resources/static/adapter_application_3.png)

### Ӧ�ó���
- ϵͳ��Ҫʹ�����е��࣬����Щ��Ľӿڲ�����ϵͳ����Ҫ��
- ��Ҫ����һ�������ظ�ʹ�õ��࣬������һЩ�˴�֮��û��̫�������һЩ�࣬����һЩ�����ڽ�����������һ������
- ���ڶ�����������������ϵķ�ʽ������չ��һ�����������԰Ѷ��ֲ�ͬ��Դ��Դ�༰�����ࣩ���䵽ͬһ��Ŀ�ꣻ������������������ַ�ʽ�޷����¶���adaptee����Ϊ�������Ժܷ���������µ���Ϊ��
- �����������������ü̳еķ�ʽ������չ��adapter�������¶���adaptee����Ϊ����ͨ���̳з�ʽ��϶Ƚϸߣ���Java��֧�ֶ�̳У���adapter��Ҫ�̳�������ʱ�÷�ʽ�޷�ʵ�֡�

### �ܽ�
- ������ģʽ���ڽ�һ���ӿ�ת���ɿͻ�ϣ������һ���ӿڣ�������ģʽʹ�ӿڲ����ݵ���Щ�����һ�����������Ϊ��װ����������ģʽ�ȿ�����Ϊ��ṹ��ģʽ��Ҳ������Ϊ����ṹ��ģʽ��
- ������ģʽ����Ҫ�ŵ��ǽ�Ŀ������������������������͸���Ժ͸����ԣ�ͬʱϵͳ������Ժ���չ�Զ��ǳ��ã��������������������µ����������ǳ����㣻��������ģʽ��ȱ�������������ںܶ��������в���ͬʱ�������������࣬����������ģʽ��ȱ���Ǻ����¶��廻��������ķ�����




