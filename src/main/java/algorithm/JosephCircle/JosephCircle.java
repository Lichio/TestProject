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
        int counter=0;//记录被移出圈子的人数
        int accumulate=0;//记录上一次移除操作之后遍历过的人数，当accumulate==k时 则删除当前位置的人
        while(true){
            if(!kick[flag]){//判断当前位置的人是否已被移出圈子
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
