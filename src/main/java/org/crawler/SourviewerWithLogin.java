package org.crawler;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

/**
 * Created by LiChaojie on 2016/9/23.
 */
public class SourviewerWithLogin {
    public static void main(String[] args){
        try{
            URL tempUrl = new URL("http://login.228.com.cn/login?service=http://www.228.com.cn/callback?callback=aHR0cDovL3d3dy4yMjguY29tLmNuLw==");
            HttpURLConnection tempConn = (HttpURLConnection)tempUrl.openConnection();
            tempConn.setRequestMethod("GET");
            String jSession = tempConn.getHeaderField("set-cookie");
            System.out.println("============£º" + jSession);

            Reader tempReader = new InputStreamReader(tempConn.getInputStream(),"utf-8");
            int c;
            char[] temp = new char[8];
            while((c = tempReader.read(temp)) != -1){
                System.out.print(new String(temp,0,temp.length));
            }
        }catch(IOException ex){

        }

        System.out.println("------------------------------------------------------------------");

        try{
            download("http://login.228.com.cn/validateCodeServlet/imgCode.images","C:\\Users\\LiChaojie\\Desktop\\result.jpg");

            String jSession,lt,execution,imgCode;
            Scanner in = new Scanner(System.in);
            System.out.print("Please input jSession:");
            jSession = in.nextLine();
            System.out.print("Please input lt:");
            lt = in.nextLine();
            System.out.println("Please input execution:");
            execution = in.nextLine();
            System.out.println("Please input imgCode:");
            imgCode = in.nextLine();

            URL url = new URL("http://login.228.com.cn/login?service=http://www.228.com.cn/callback?callback=aHR0cDovL3d3dy4yMjguY29tLmNuLw==");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            //conn.setUseCaches(false);

            conn.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            conn.setRequestProperty("Accept-Encoding","gzip, deflate");
            conn.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8");
            conn.setRequestProperty("Cache-Control","max-age=0");
            conn.setRequestProperty("Connection","keep-alive");
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            conn.setRequestProperty("Cookie","PHPStat_First_Time_10000001=1467122120098; PHPStat_Cookie_Global_User_Id=_ck16062821552011011509276629955; __ag_cm_=1467122120365; PHPStat_Msrc_First_10000001=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%25e6%25b0%25b8%25e4%25b9%2590%25e7%25a5%25a8%25e5%258a%25a1%25e5%25ae%2598%25e6%2596%25b9%25e7%25bd%2591%25e7%25ab%2599%3A%3A%3A%3A%3A%3Abzclk.baidu.com%3A%3A%3A%3Apmf_from_free_search; PHPStat_Main_Website_10000001=_ck16062821552011011509276629955%7C10000001%7C%7C%7C; PHPStat_Msrc_10000001=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%25e6%25b0%25b8%25e4%25b9%2590%25e7%25a5%25a8%25e5%258a%25a1%3A%3A%3A%3A%3A%3Abzclk.baidu.com%3A%3A%3A%3Apmf_from_free_search; PHPStat_Msrc_Type_10000001=pmf_from_free_search; _adwr=74682004%230; PHPStat_Return_Count_10000001=4; PHPStat_Return_Time_10000001=1474697499735; NTKF_T2D_CLIENTID=guestDF8A8858-ABDD-4B72-EE86-EB9B37F56A51; nTalk_CACHE_DATA={uid:kf_9209_ISME9754_guestDF8A8858-ABDD-4B,tid:1474698305724917}; looyu_id=6122116e2c51a30859f2f32aaa965964e8_20000356%3A26; _adwp=74682004.2574464885.1467122120.1474708166.1474712622.11; _adwc=74682004; _adwb=74682004; OZ_0a_1759=; OZ_1U_1759=vid=v77281c879e781.0&ctime=1474712644&ltime=1474712623; OZ_1Y_1759=erefer=-&eurl=http%3A//www.228.com.cn/&etime=1474697499&ctime=1474712644&ltime=1474712623&compid=1759; _ga=GA1.3.114404569.1467122120; _gat=1; JSESSIONID="+ jSession +"; org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE=zh_CN; Hm_lvt_0578294a14fae8ac90f4609ae2844eda=1472824629,1472905424,1474596315,1474697500; Hm_lpvt_0578294a14fae8ac90f4609ae2844eda=" + System.currentTimeMillis() + "; ag_fid=6vWdSWWvSuoXjHAF");
            conn.setRequestProperty("Host","login.228.com.cn");
            conn.setRequestProperty("Origin","http://login.228.com.cn");
            conn.setRequestProperty("Referer","http://login.228.com.cn/login?service=http://www.228.com.cn/callback?callback=aHR0cDovL3d3dy4yMjguY29tLmNuLw==");
            conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.89 Safari/537.36");

            OutputStreamWriter outS = new OutputStreamWriter(conn.getOutputStream(),"utf-8");
            outS.write("lt="+ lt +"&" +
                    "execution="+ execution +"&" +
                    "_eventId=submit&" +
                    "locale=zh_CN&" +
                    "username=18706811105&" +
                    "password=Lcj112358&" +
                    "imgCode=" + imgCode);
            outS.flush();
            outS.close();
            conn.connect();

            String str1 = conn.getHeaderField("set-cookie");
            System.out.println(">>>>>>>>>>>>>>>>>>1:" + str1);
            String str2 = conn.getHeaderField("set-cookie");
            System.out.println(">>>>>>>>>>>>>>>>>>2:" + str2);

            InputStream raw = conn.getInputStream();
            //Some website is compressed,we should use GZIPInputStream,otherwise the page is Garbled and we cannot get the right information.
            GZIPInputStream ginput = new GZIPInputStream(raw);
            Reader reader = new InputStreamReader(ginput,"utf-8");

            FileOutputStream out = new FileOutputStream("C:\\Users\\LiChaojie\\Desktop\\temp.txt");
            Writer writer = new OutputStreamWriter(out);

            int c;
            char[] temp = new char[8];
            while((c = reader.read(temp)) != -1){
                System.out.print(new String(temp,0,temp.length));
                writer.write(temp,0,temp.length);
            }
            raw.close();
        }catch(IOException ex){
            System.out.println(ex);
        }

    }

    public static void download(String uri,String path) {
        try {
            System.out.println("11111111111111111111111111111");
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            conn.setRequestProperty("Cookie","PHPStat_First_Time_10000001=1467122120098; PHPStat_Cookie_Global_User_Id=_ck16062821552011011509276629955; __ag_cm_=1467122120365; PHPStat_Msrc_First_10000001=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%25e6%25b0%25b8%25e4%25b9%2590%25e7%25a5%25a8%25e5%258a%25a1%25e5%25ae%2598%25e6%2596%25b9%25e7%25bd%2591%25e7%25ab%2599%3A%3A%3A%3A%3A%3Abzclk.baidu.com%3A%3A%3A%3Apmf_from_free_search; PHPStat_Main_Website_10000001=_ck16062821552011011509276629955%7C10000001%7C%7C%7C; PHPStat_Msrc_10000001=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%25e6%25b0%25b8%25e4%25b9%2590%25e7%25a5%25a8%25e5%258a%25a1%3A%3A%3A%3A%3A%3Abzclk.baidu.com%3A%3A%3A%3Apmf_from_free_search; PHPStat_Msrc_Type_10000001=pmf_from_free_search; _adwr=74682004%230; PHPStat_Return_Count_10000001=4; PHPStat_Return_Time_10000001=1474697499735; NTKF_T2D_CLIENTID=guestDF8A8858-ABDD-4B72-EE86-EB9B37F56A51; looyu_id=6122116e2c51a30859f2f32aaa965964e8_20000356%3A26; _adwp=74682004.2574464885.1467122120.1474712622.1474718889.12; _adwc=74682004; org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE=zh_CN; _ga=GA1.3.114404569.1467122120; OZ_1U_1759=vid=v77281c879e781.0&ctime=1474722155&ltime=1474722153; OZ_1Y_1759=erefer=-&eurl=http%3A//www.228.com.cn/&etime=1474718889&ctime=1474722155&ltime=1474722153&compid=1759; JSESSIONID=44F333BEB4199C2030EE3432F12BD16C; Hm_lvt_0578294a14fae8ac90f4609ae2844eda=1472905424,1474596315,1474697500,1474718890; Hm_lpvt_0578294a14fae8ac90f4609ae2844eda=1474723952; ag_fid=6vWdSWWvSuoXjHAF");
            InputStream in = conn.getInputStream();

            OutputStream out = new FileOutputStream(path);

            int i;
            byte[] temp = new byte[1024];
            while ((i = in.read(temp)) != -1) {
                byte[] b = new byte[i];
                System.arraycopy(temp,0,b,0,i);
                out.write(b);
            }
            out.flush();
            out.close();
            System.out.println("2222222222222222222222222222222");
        } catch (IOException ex) {
            System.out.println(ex);

        }
    }
}
