import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.lang.Math;

public class YouChuBank{
    public static int principal;
    public static double rate;
    public static String startDate;
    public static String endDate;
    public static long Days;
    
    public static void main(String[] args) {
        // isPrincipal();
        isRate();
    }
    //校验本金
    public static void isPrincipal(){
        String principal1 = Integer.toString(principal);
        boolean flg = false;
		while(flg == false) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入本金（13位以内的整数））:");
            principal1 = sc.nextLine();
            Pattern p = Pattern.compile("^[1-9]\\d{0,12}$");
            Matcher m = p.matcher(principal1);
            flg = m.matches();
		}
        principal = Integer.valueOf(principal1);
		//System.out.println("本金格式正确");
	}
    //校验利率
    public static void isRate() {
        String rate1 = Double.toString(rate);
        boolean flg = false;
        if (flg == false) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入利率：");
            rate1 = sc.nextLine();
            Pattern p = Pattern.compile("^(\\d|[1-9]\\d|100)(.\\d{1,4})?$");
            Matcher m = p.matcher(rate1);
            flg = m.matches();
		}
        rate = Double.valueOf(rate1);
    }
    //开始日期
    public static void isStartData(){
        boolean flg = false;
		if (flg == false) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入开始日期:");
            startDate = sc.nextLine();
            Pattern p = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}");
            Matcher m = p.matcher(startDate);
            flg = m.matches();
		}
    }
    //结束日期
    public static void isEndData(){
        boolean flg = false;
        if (flg == false) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入结束日期:");
            endDate = sc.nextLine();
            Pattern p = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}");
            Matcher m = p.matcher(endDate);
            flg = m.matches();
        }
    }
    public static void totaldays(String start,String end){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long time = sdf.parse(start).getTime();
            long time1 = sdf.parse(end).getTime();
            Days = (int) ((time1 -time) /(24
                        * 60 * 60 * 1000));
                } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static double interest(int principal,double rate,long days){
        return principal*rate*days;
    }
}

