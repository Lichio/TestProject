package org.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by LiChaojie on 2016/3/10.
 */
public class CMDInputTest {
    public static void main(String[] args)throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while((line = bufferedReader.readLine()) != null){
            if(line.equals("exit")){
                return;
            }
            System.out.println(">>>" + line);
        }
    }
}
