package org.crawler;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by LiChaojie on 2016/9/24.
 */
public class test {
    public static void main(String[] args){
        try{
            URL tempUrl = new URL("http://login.228.com.cn/login?service=http://www.228.com.cn/callback?callback=aHR0cDovL3d3dy4yMjguY29tLmNuLw==");
            HttpURLConnection tempConn = (HttpURLConnection)tempUrl.openConnection();
            tempConn.setRequestMethod("GET");
            String str = tempConn.getHeaderField("set-cookie");
            System.out.println("============£º" + str);

            Reader tempReader = new InputStreamReader(tempConn.getInputStream(),"utf-8");
            int c;
            char[] temp = new char[8];
            while((c = tempReader.read(temp)) != -1){
                //System.out.print(new String(temp,0,temp.length));
            }

            download("http://login.228.com.cn/validateCodeServlet/imgCode.images","C:\\Users\\LiChaojie\\Desktop\\result.jpg");

        }catch(IOException ex){

        }



        System.out.println(">>>:" + System.currentTimeMillis());

//                String s1 = "PHPStat_First_Time_10000001=1467122120098; PHPStat_Cookie_Global_User_Id=_ck16062821552011011509276629955; __ag_cm_=1467122120365; PHPStat_Msrc_First_10000001=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%25e6%25b0%25b8%25e4%25b9%2590%25e7%25a5%25a8%25e5%258a%25a1%25e5%25ae%2598%25e6%2596%25b9%25e7%25bd%2591%25e7%25ab%2599%3A%3A%3A%3A%3A%3Abzclk.baidu.com%3A%3A%3A%3Apmf_from_free_search; PHPStat_Main_Website_10000001=_ck16062821552011011509276629955%7C10000001%7C%7C%7C; PHPStat_Msrc_10000001=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%25e6%25b0%25b8%25e4%25b9%2590%25e7%25a5%25a8%25e5%258a%25a1%3A%3A%3A%3A%3A%3Abzclk.baidu.com%3A%3A%3A%3Apmf_from_free_search; PHPStat_Msrc_Type_10000001=pmf_from_free_search; _adwr=74682004%230; _adwp=74682004.2574464885.1467122120.1474606306.1474697499.9; _adwc=74682004; PHPStat_Return_Count_10000001=4; PHPStat_Return_Time_10000001=1474697499735; NTKF_T2D_CLIENTID=guestDF8A8858-ABDD-4B72-EE86-EB9B37F56A51; nTalk_CACHE_DATA={uid:kf_9209_ISME9754_guestDF8A8858-ABDD-4B,tid:1474698305724917}; looyu_id=6122116e2c51a30859f2f32aaa965964e8_20000356%3A26; OZ_0a_1759=; _ga=GA1.3.114404569.1467122120; OZ_1U_1759=vid=v77281c879e781.0&ctime=1474702101&ltime=1474700927; OZ_1Y_1759=erefer=-&eurl=http%3A//www.228.com.cn/&etime=1474697499&ctime=1474702101&ltime=1474700927&compid=1759; org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE=zh_CN; JSESSIONID=6AD069567B12917F62A5EBECB0BEA706; Hm_lvt_0578294a14fae8ac90f4609ae2844eda=1472824629,1472905424,1474596315,1474697500; Hm_lpvt_0578294a14fae8ac90f4609ae2844eda=1474703456; ag_fid=6vWdSWWvSuoXjHAF";
//        String s2 = "PHPStat_First_Time_10000001=1467122120098; PHPStat_Cookie_Global_User_Id=_ck16062821552011011509276629955; __ag_cm_=1467122120365; PHPStat_Msrc_First_10000001=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%25e6%25b0%25b8%25e4%25b9%2590%25e7%25a5%25a8%25e5%258a%25a1%25e5%25ae%2598%25e6%2596%25b9%25e7%25bd%2591%25e7%25ab%2599%3A%3A%3A%3A%3A%3Abzclk.baidu.com%3A%3A%3A%3Apmf_from_free_search; PHPStat_Main_Website_10000001=_ck16062821552011011509276629955%7C10000001%7C%7C%7C; PHPStat_Msrc_10000001=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%25e6%25b0%25b8%25e4%25b9%2590%25e7%25a5%25a8%25e5%258a%25a1%3A%3A%3A%3A%3A%3Abzclk.baidu.com%3A%3A%3A%3Apmf_from_free_search; PHPStat_Msrc_Type_10000001=pmf_from_free_search; _adwr=74682004%230; _adwp=74682004.2574464885.1467122120.1474606306.1474697499.9; _adwc=74682004; PHPStat_Return_Count_10000001=4; PHPStat_Return_Time_10000001=1474697499735; NTKF_T2D_CLIENTID=guestDF8A8858-ABDD-4B72-EE86-EB9B37F56A51; nTalk_CACHE_DATA={uid:kf_9209_ISME9754_guestDF8A8858-ABDD-4B,tid:1474698305724917}; looyu_id=6122116e2c51a30859f2f32aaa965964e8_20000356%3A26; OZ_0a_1759=; _ga=GA1.3.114404569.1467122120; OZ_1U_1759=vid=v77281c879e781.0&ctime=1474702101&ltime=1474700927; OZ_1Y_1759=erefer=-&eurl=http%3A//www.228.com.cn/&etime=1474697499&ctime=1474702101&ltime=1474700927&compid=1759; org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE=zh_CN; JSESSIONID=B72B408999C5E5B2A57C7297DCCC6350; Hm_lvt_0578294a14fae8ac90f4609ae2844eda=1472824629,1472905424,1474596315,1474697500; Hm_lpvt_0578294a14fae8ac90f4609ae2844eda=1474704150; ag_fid=6vWdSWWvSuoXjHAF";
//        String s3 = "PHPStat_First_Time_10000001=1467122120098; PHPStat_Cookie_Global_User_Id=_ck16062821552011011509276629955; __ag_cm_=1467122120365; PHPStat_Msrc_First_10000001=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%25e6%25b0%25b8%25e4%25b9%2590%25e7%25a5%25a8%25e5%258a%25a1%25e5%25ae%2598%25e6%2596%25b9%25e7%25bd%2591%25e7%25ab%2599%3A%3A%3A%3A%3A%3Abzclk.baidu.com%3A%3A%3A%3Apmf_from_free_search; PHPStat_Main_Website_10000001=_ck16062821552011011509276629955%7C10000001%7C%7C%7C; PHPStat_Msrc_10000001=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%25e6%25b0%25b8%25e4%25b9%2590%25e7%25a5%25a8%25e5%258a%25a1%3A%3A%3A%3A%3A%3Abzclk.baidu.com%3A%3A%3A%3Apmf_from_free_search; PHPStat_Msrc_Type_10000001=pmf_from_free_search; _adwr=74682004%230; _adwp=74682004.2574464885.1467122120.1474606306.1474697499.9; _adwc=74682004; PHPStat_Return_Count_10000001=4; PHPStat_Return_Time_10000001=1474697499735; NTKF_T2D_CLIENTID=guestDF8A8858-ABDD-4B72-EE86-EB9B37F56A51; nTalk_CACHE_DATA={uid:kf_9209_ISME9754_guestDF8A8858-ABDD-4B,tid:1474698305724917}; looyu_id=6122116e2c51a30859f2f32aaa965964e8_20000356%3A26; OZ_0a_1759=; _ga=GA1.3.114404569.1467122120; OZ_1U_1759=vid=v77281c879e781.0&ctime=1474702101&ltime=1474700927; OZ_1Y_1759=erefer=-&eurl=http%3A//www.228.com.cn/&etime=1474697499&ctime=1474702101&ltime=1474700927&compid=1759; org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE=zh_CN; JSESSIONID=886F8F2A7614A63D3101717A3C414214; Hm_lvt_0578294a14fae8ac90f4609ae2844eda=1472824629,1472905424,1474596315,1474697500; Hm_lpvt_0578294a14fae8ac90f4609ae2844eda=1474705650; ag_fid=6vWdSWWvSuoXjHAF";

//        String s1 = "PHPStat_First_Time_10000001=1467122120098; PHPStat_Cookie_Global_User_Id=_ck16062821552011011509276629955; __ag_cm_=1467122120365; PHPStat_Msrc_First_10000001=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%25e6%25b0%25b8%25e4%25b9%2590%25e7%25a5%25a8%25e5%258a%25a1%25e5%25ae%2598%25e6%2596%25b9%25e7%25bd%2591%25e7%25ab%2599%3A%3A%3A%3A%3A%3Abzclk.baidu.com%3A%3A%3A%3Apmf_from_free_search; PHPStat_Main_Website_10000001=_ck16062821552011011509276629955%7C10000001%7C%7C%7C; bdshare_firstime=1472907174189; PHPStat_Msrc_10000001=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%25e6%25b0%25b8%25e4%25b9%2590%25e7%25a5%25a8%25e5%258a%25a1%3A%3A%3A%3A%3A%3Abzclk.baidu.com%3A%3A%3A%3Apmf_from_free_search; PHPStat_Msrc_Type_10000001=pmf_from_free_search; _adwr=74682004%230; route_yl=678c16f835b40d619bedc0959d61c89c; PHPStat_Return_Count_10000001=4; PHPStat_Return_Time_10000001=1474697499735; products=181883744%5E%E4%B8%AD%E5%9B%BD%E6%96%B0%E6%AD%8C%E5%A3%B0%E5%B7%85%E5%B3%B0%E4%B9%8B%E5%A4%9C(%E6%83%A0%E6%B0%91%E5%AD%A3%E9%A2%86%E5%88%B8%E6%9C%80%E9%AB%98%E5%87%8F150%E5%85%83); NTKF_T2D_CLIENTID=guestDF8A8858-ABDD-4B72-EE86-EB9B37F56A51; nTalk_CACHE_DATA={uid:kf_9209_ISME9754_guestDF8A8858-ABDD-4B,tid:1474698305724917}; looyu_id=6122116e2c51a30859f2f32aaa965964e8_20000356%3A26; QT_JSESSIONID=261F08C8D2A897C676E9D705485B4208; _adwp=74682004.2574464885.1467122120.1474708166.1474712622.11; _adwc=74682004; _adwb=74682004; OZ_0a_1759=; OZ_1U_1759=vid=v77281c879e781.0&ctime=1474714216&ltime=1474713528; OZ_1Y_1759=erefer=-&eurl=http%3A//www.228.com.cn/&etime=1474697499&ctime=1474714216&ltime=1474713528&compid=1759; _ga=GA1.3.114404569.1467122120; _gat=1; Hm_lvt_0578294a14fae8ac90f4609ae2844eda=1472824629,1472905424,1474596315,1474697500; Hm_lpvt_0578294a14fae8ac90f4609ae2844eda=1474714217; ag_fid=6vWdSWWvSuoXjHAF; __storejs__=%22__storejs__%22";
//        String s2 = "PHPStat_First_Time_10000001=1467122120098; PHPStat_Cookie_Global_User_Id=_ck16062821552011011509276629955; __ag_cm_=1467122120365; PHPStat_Msrc_First_10000001=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%25e6%25b0%25b8%25e4%25b9%2590%25e7%25a5%25a8%25e5%258a%25a1%25e5%25ae%2598%25e6%2596%25b9%25e7%25bd%2591%25e7%25ab%2599%3A%3A%3A%3A%3A%3Abzclk.baidu.com%3A%3A%3A%3Apmf_from_free_search; PHPStat_Main_Website_10000001=_ck16062821552011011509276629955%7C10000001%7C%7C%7C; bdshare_firstime=1472907174189; PHPStat_Msrc_10000001=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%25e6%25b0%25b8%25e4%25b9%2590%25e7%25a5%25a8%25e5%258a%25a1%3A%3A%3A%3A%3A%3Abzclk.baidu.com%3A%3A%3A%3Apmf_from_free_search; PHPStat_Msrc_Type_10000001=pmf_from_free_search; _adwr=74682004%230; route_yl=678c16f835b40d619bedc0959d61c89c; PHPStat_Return_Count_10000001=4; PHPStat_Return_Time_10000001=1474697499735; products=181883744%5E%E4%B8%AD%E5%9B%BD%E6%96%B0%E6%AD%8C%E5%A3%B0%E5%B7%85%E5%B3%B0%E4%B9%8B%E5%A4%9C(%E6%83%A0%E6%B0%91%E5%AD%A3%E9%A2%86%E5%88%B8%E6%9C%80%E9%AB%98%E5%87%8F150%E5%85%83); NTKF_T2D_CLIENTID=guestDF8A8858-ABDD-4B72-EE86-EB9B37F56A51; nTalk_CACHE_DATA={uid:kf_9209_ISME9754_guestDF8A8858-ABDD-4B,tid:1474698305724917}; looyu_id=6122116e2c51a30859f2f32aaa965964e8_20000356%3A26; QT_JSESSIONID=261F08C8D2A897C676E9D705485B4208; _adwp=74682004.2574464885.1467122120.1474708166.1474712622.11; _adwc=74682004; _gat=1; OZ_0a_1759=; OZ_1U_1759=vid=v77281c879e781.0&ctime=1474714495&ltime=1474714216; OZ_1Y_1759=erefer=-&eurl=http%3A//www.228.com.cn/&etime=1474697499&ctime=1474714495&ltime=1474714216&compid=1759; _adwb=74682004; ag_fid=6vWdSWWvSuoXjHAF; _ga=GA1.3.114404569.1467122120; Hm_lvt_0578294a14fae8ac90f4609ae2844eda=1472824629,1472905424,1474596315,1474697500; Hm_lpvt_0578294a14fae8ac90f4609ae2844eda=1474714497; __storejs__=%22__storejs__%22";
//        String s3 = "PHPStat_First_Time_10000001=1467122120098; PHPStat_Cookie_Global_User_Id=_ck16062821552011011509276629955; __ag_cm_=1467122120365; PHPStat_Msrc_First_10000001=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%25e6%25b0%25b8%25e4%25b9%2590%25e7%25a5%25a8%25e5%258a%25a1%25e5%25ae%2598%25e6%2596%25b9%25e7%25bd%2591%25e7%25ab%2599%3A%3A%3A%3A%3A%3Abzclk.baidu.com%3A%3A%3A%3Apmf_from_free_search; PHPStat_Main_Website_10000001=_ck16062821552011011509276629955%7C10000001%7C%7C%7C; bdshare_firstime=1472907174189; PHPStat_Msrc_10000001=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%25e6%25b0%25b8%25e4%25b9%2590%25e7%25a5%25a8%25e5%258a%25a1%3A%3A%3A%3A%3A%3Abzclk.baidu.com%3A%3A%3A%3Apmf_from_free_search; PHPStat_Msrc_Type_10000001=pmf_from_free_search; _adwr=74682004%230; route_yl=678c16f835b40d619bedc0959d61c89c; PHPStat_Return_Count_10000001=4; PHPStat_Return_Time_10000001=1474697499735; products=181883744%5E%E4%B8%AD%E5%9B%BD%E6%96%B0%E6%AD%8C%E5%A3%B0%E5%B7%85%E5%B3%B0%E4%B9%8B%E5%A4%9C(%E6%83%A0%E6%B0%91%E5%AD%A3%E9%A2%86%E5%88%B8%E6%9C%80%E9%AB%98%E5%87%8F150%E5%85%83); NTKF_T2D_CLIENTID=guestDF8A8858-ABDD-4B72-EE86-EB9B37F56A51; nTalk_CACHE_DATA={uid:kf_9209_ISME9754_guestDF8A8858-ABDD-4B,tid:1474698305724917}; looyu_id=6122116e2c51a30859f2f32aaa965964e8_20000356%3A26; QT_JSESSIONID=261F08C8D2A897C676E9D705485B4208; _adwp=74682004.2574464885.1467122120.1474708166.1474712622.11; _adwc=74682004; _gat=1; Hm_lvt_0578294a14fae8ac90f4609ae2844eda=1472824629,1472905424,1474596315,1474697500; Hm_lpvt_0578294a14fae8ac90f4609ae2844eda=1474714725; _adwb=74682004; OZ_0a_1759=; OZ_1U_1759=vid=v77281c879e781.0&ctime=1474714726&ltime=1474714495; OZ_1Y_1759=erefer=-&eurl=http%3A//www.228.com.cn/&etime=1474697499&ctime=1474714726&ltime=1474714495&compid=1759; _ga=GA1.3.114404569.1467122120; ag_fid=6vWdSWWvSuoXjHAF; __storejs__=%22__storejs__%22";
//
//
//        System.out.println(s1);
//        char c1,c2,c3;
//        for(int i = 0; i < s2.length(); i ++){
//            c1 = s1.charAt(i);
//            c2 = s2.charAt(i);
//            if(c1 == c2) System.out.print(" ");
//            else System.out.print(c2);
//        }
//        System.out.println();
//        for(int i = 0; i < s2.length(); i ++){
//            c1 = s1.charAt(i);
//            c3 = s3.charAt(i);
//            if(c1 == c3) System.out.print(" ");
//            else System.out.print(c3);
//        }
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
            System.out.println("2222222222222222222222222222222");
        } catch (IOException ex) {
            System.out.println(ex);

        }
    }
}
