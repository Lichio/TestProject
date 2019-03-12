package algorithm.JosephCircle;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Lichaojie on 2017/8/4.
 */
public class JosephCircle {
    public void josephCircle(int n,int k){
        int flag=0;
        boolean[] kick = new boolean[n];
        //set kick flag to False;
        for(int i=0;i<n-1;i++){
            kick[i]=false;
        }
        int counter=0;//��¼���Ƴ�Ȧ�ӵ�����
        int accumulate=0;//��¼��һ���Ƴ�����֮�����������������accumulate==kʱ ��ɾ����ǰλ�õ���
        while(true){
            if(!kick[flag]){//�жϵ�ǰλ�õ����Ƿ��ѱ��Ƴ�Ȧ��
                accumulate++;
                if(counter==n-1){
                    System.out.println("kick last person===="+(flag+1));
                    break;
                }
                if(accumulate==k){
                    kick[flag]=true;
                    System.out.println("kick person===="+(flag+1));
                    accumulate=0;
                    counter++;
                }
            }
            flag=(flag+1)%n;
        }

    }
    public static void main(String[] args) {
        JosephCircle jCircle = new JosephCircle();
        jCircle.josephCircle(20, 3);


        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(System.currentTimeMillis());
        System.out.println(calendar.getTime());

        Date date = new Date();
        System.out.println(date.toString());
    }
}
