package org.ztest.test4;

/**
 * Created by Lichaojie on 2017/2/17.
 */
public class Node {
    private boolean flag;

    Node(){flag = false;}

    boolean getValue(){
//        if(flag){
//            flag = false;
//        }else{
//            flag = true;
//        }
//        return !flag;
        int i = (int)(Math.random() * 10) % 2;
        return i == 1?true:false;
    }
}
