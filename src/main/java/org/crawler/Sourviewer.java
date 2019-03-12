package org.crawler;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by LiChaojie on 2016/9/23.
 */
public class Sourviewer {
    public static void main(String[] args){
        try{
            URL u = new URL("https://www.amazon.com/");//The page of this website is Grabled.
            HttpURLConnection uc = (HttpURLConnection)u.openConnection();
            uc.setRequestProperty("Cookie", "skin=noskin; csm-hit=NW34KPFESQRYC88B2209+s-NW34KPFESQRYC88B2209|1480066404380; x-wl-uid=1uc6JNMtuXqPL/3Tg2hZ0L+6G8C3UdLTefrbD4nyo4tV9/dEFrilHFqunlBAXPaZ0EGpRM47MpHs=; session-token=9/cW37Dj/e4oknE5wOb0/WoNFl+5pI79dW3nE+fZ3DggTmVmxxm0xSs2tF4F9bA9mws+/S9RYPh7cEc2ERiSwqTL6CMuVlTAiO1tNaSO7h/WVo6gAaEVwfrUMrW9quijBM+6aV1+2kHHSmSf7yyXJq3rekd/8+slzKotCSAchdAwkRXL2zW54WrMyfo+l8nbJfylJH91K9fC4HoK4MQJKGLjGzrwLLkzrfQsAlz1+ktRq5jUQFr/S7P2eKMh0T+C; ubid-main=163-7363256-3879445; session-id-time=2082787201l; session-id=159-5997850-1013706");
            uc.setRequestProperty("Cache-Control","max-age=0");
            uc.setRequestProperty("Connection","keep-alive");
            //uc.setRequestProperty("If-Modified-Since","Sat, 24 Sep 2016 10:40:07 GMT");
            uc.setRequestMethod("GET");

            System.out.println(">>>:" + uc.getContentType());
            try{
                InputStream raw = uc.getInputStream();
                //Some website is compressed,we should use GZIPInputStream,otherwise the page is Garbled and we cannot get the right information.
                //GZIPInputStream ginput = new GZIPInputStream(raw);
                Reader reader = new InputStreamReader(raw,"utf-8");

                FileOutputStream out = new FileOutputStream("C:\\Users\\LiChaojie\\Desktop\\temp.html");
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
