package org.crawler;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by LiChaojie on 2016/9/23.
 */
public class SourviewerRS {
    public static void main(String[] args){
        try{
            URL u = new URL("http://rs.xidian.edu.cn/portal.php");//The page of this website is Grabled.
            HttpURLConnection uc = (HttpURLConnection)u.openConnection();
            uc.setRequestProperty("Cookie","safedog-flow-item=FBB48A9C3727185DACA66AB4998F0A19; Q8qA_2132_saltkey=loNCjjoJ; Q8qA_2132_lastvisit=1474691059; Q8qA_2132_nofocus_portal=1; Q8qA_2132_lastact=1474696038%09member.php%09logging; Q8qA_2132_ulastactivity=c68ajqGrhKp2%2B0H7BUZs%2BiOACZMnIhZf5ZqU%2Fukade1ZkQvfEjiG; Q8qA_2132_sid=d7K649; Q8qA_2132_auth=3c2a87VQEaJPDpL5ZZKLzTVU3xTtyn%2Fjtwkd7Jqhv1awi4X5DS9zx5KGSxh8T%2B91f8wlb0okuZhWHNZJM6np4m5M4GI; Q8qA_2132_lastcheckfeed=270260%7C1474696038; Q8qA_2132_checkfollow=1; Q8qA_2132_lip=10.170.68.104%2C1474694933; Q8qA_2132_myrepeat_rr=R0");
            uc.setRequestProperty("Cache-Control","max-age=0");

            System.out.println(">>>:" + uc.getContentType());
            try{
                InputStream raw = uc.getInputStream();
                //Some website is compressed,we should use GZIPInputStream,otherwise the page is Garbled and we cannot get the right information.
                //GZIPInputStream ginput = new GZIPInputStream(raw);
                Reader reader = new InputStreamReader(raw,"utf-8");

                FileOutputStream out = new FileOutputStream("C:\\Users\\LiChaojie\\Desktop\\temp.txt");
                Writer writer = new OutputStreamWriter(out);

                int c;
                char[] temp = new char[8];
                while((c = reader.read(temp)) != -1){
                    System.out.print(new String(temp,0,temp.length));
                    writer.write(temp,0,temp.length);
                }
                raw.close();
                //sc.close();
            }catch(MalformedURLException ex){
                System.out.println("url is not a parseable URL");
            }
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
}
