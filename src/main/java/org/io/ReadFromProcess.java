package org.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by LiChaojie on 2016/3/10.
 */
public class ReadFromProcess {
    public static void main(String[] args)throws IOException{
        //运行命令“Java -version”，返回此命令的子进程。
        Process process = Runtime.getRuntime().exec("java -version");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line = null;
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
    }
}
