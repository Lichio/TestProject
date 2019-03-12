package org.collection;

import java.util.Scanner;

/**
 * org.test1
 * Created on 2017/10/27
 *
 * @author Lichaojie
 */
public class BRRead {

	//Java如何获取控制台输入

	public static void main(String[] args) {
		method1();
		method2();
		method3();
	}

	public static void method1(){
		Scanner scan = new Scanner(System.in);
		// 从键盘接收数据

		//next方式接收字符串
		System.out.println("next方式接收：");
		// 判断是否还有输入
		if(scan.hasNext()){
			String str1 = scan.next();
			System.out.println("输入的数据为："+str1);
		}
	}

	public static void method2(){
		Scanner scan = new Scanner(System.in);
		// 从键盘接收数据

		//nextLine方式接收字符串
		System.out.println("nextLine方式接收：");
		// 判断是否还有输入
		if(scan.hasNextLine()){
			String str2 = scan.nextLine();
			System.out.println("输入的数据为："+str2);
		}
	}

	public static void method3(){
		Scanner scan = new Scanner(System.in);
		// 从键盘接收数据
		int i = 0 ;
		float f = 0.0f ;
		System.out.print("输入整数：");
		if(scan.hasNextInt()){
			// 判断输入的是否是整数
			i = scan.nextInt() ;
			// 接收整数
			System.out.println("整数数据：" + i) ;
		}else{
			// 输入错误的信息
			System.out.println("输入的不是整数！") ;
		}
		System.out.print("输入小数：");
		if(scan.hasNextFloat()){
			// 判断输入的是否是小数
			f = scan.nextFloat() ;
			// 接收小数
			System.out.println("小数数据：" + f) ;
		}else{
			// 输入错误的信息
			System.out.println("输入的不是小数！") ;
		}
	}

}
