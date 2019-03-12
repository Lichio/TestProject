package org.httpparse;

/**
 * TestProject org.test24
 *
 * @author Lichaojie
 * @version 2017/12/27 16:16
 */
public class Test {

	public static void main(String[] args){

		System.out.println(new B().getValue());


//		count(f(7));
//		count(f(9));
	}

//	static int f(int n){
//		if(n == 0 || n == 1){
//			return 1;
//		}
//		return f(n - 1) + f(n - 2);
//	}
//
//	static void count(int n){
//		int temp = n - ((n>>1)&033333333333) - ((n>>2)&011111111111);
//		System.out.println(((temp + (temp >> 3))&030707070707)%63);
//	}

	static class A{
		protected int value;
		public A(int v){
			setValue(v);
		}
		public void setValue(int value){
			this.value = value;
		}
		public int getValue(){
			try {
				value ++;
				return value;
			}finally { //finally会在return语句之前执行，但不会影响return的值
				this.setValue(value);
				System.out.println(value);
			}
		}
	}
	static class B extends A{
		public B(){
			super(5); //执行父类构造器时，调用的是子类的setValue()方法
			setValue(getValue() - 3);
		}
		public void setValue(int value){
			super.setValue(2 * value);
		}
	}

}
