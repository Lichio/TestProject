package oj.nk.�����ǵ���Ϸ$ԲȦ�����ʣ�µ���;

/**
 * TestProject oj.nk.�����ǵ���Ϸ$ԲȦ�����ʣ�µ���
 *
 * @author Lichaojie
 * @version 2018/5/16 20:50
 *
 * ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ��
 * ����,�и���Ϸ��������:����,��С������Χ��һ����Ȧ��Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������
 * ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ,
 * ����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���,
 * �����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��������������,�ĸ�С���ѻ�õ������Ʒ�أ�
 * (ע��С���ѵı���Ǵ�0��n-1)
 */
public class Main {
	public int LastRemaining_Solution(int n, int m) {
		if(n == 0 || m == 0) return -1;
		int flag=0;
		boolean[] kick = new boolean[n];
		//set kick flag to False;
		for(int i=0;i<n-1;i++){
			kick[flag]=false;
		}
		int counter=0;//��¼�Ѿ����ڻ������ĸ���
		int accumulate=0;//��¼ÿһ�����ѱ����ĸ���
		while(true){
			if(!kick[flag]){//�жϵ�ǰλ�õ����Ƿ��ѱ��Ƴ�Ȧ��
				accumulate++;
				if(counter==n-1){
					return flag;
				}
				if(accumulate==m){
					kick[flag]=true;
					accumulate=0;
					counter++;
				}
			}
			flag=(flag+1)%n;
		}
	}
}
