import java.util.Scanner;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.lang.Math;

public class YouChuBank2{
    // public static long principal;
    // public static double rate;
    // public static String startDate;
    // public static String endDate;
    // public static long Days;
    
    // private static final long Days = 0;

    //校验本金
    public static void isPrincipal(Long principal){
        String principal1 = Long.toString(principal);
        Pattern p = Pattern.compile("^[1-9]\\d{0,12}$");
        Matcher m = p.matcher(principal1);
        boolean flg = m.matches();
        if(flg==false){
            System.out.println("本金格式不正确");
        }

	}
    //校验利率
    public static void isRate(Double rate) {
        String rate1 = Double.toString(rate);
        Pattern p = Pattern.compile("^(\\d|[1-9]\\d|100)(.\\d{1,5})?$");
        Matcher m = p.matcher(rate1);
        boolean flg = m.matches();

        if(flg==false){
            System.out.println("利率格式不正确");
        }
        
    }
    //开始日期
    public static void isStartData(String startDate){
        Pattern p = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}");
        Matcher m = p.matcher(startDate);
        boolean flg = m.matches();
        if(flg==false){
            System.out.println("开始日期格式不正确");
        }
    }
    //结束日期
    public static void isEndData(String endDate){
        Pattern p = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}");
        Matcher m = p.matcher(endDate);
        boolean flg = m.matches();
        if(flg==false){
            System.out.println("结束日期格式不正确");
        }
    }
    public static long totaldays(String start,String end){
        long Days=0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long time = sdf.parse(start).getTime();
            long time1 = sdf.parse(end).getTime();
            Days = (int) ((time1 -time) /(24
                        * 60 * 60 * 1000));
                } catch (ParseException e) {
            e.printStackTrace();
        }
        return Days;
    }
    public static double interest(Long principal,double rate,long days){
        return principal*rate*days;
    }
}

