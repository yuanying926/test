import java.io.*;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) throws IOException{
        //获取临时目录。我们将阅读test.txt文件
		FileInputStream fip = new FileInputStream("a.txt");
		// 构建FileInputStream对象
		
		InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
		// 构建InputStreamReader对象,编码与写入相同

		StringBuffer sb = new StringBuffer();
		while (reader.ready()) {
			sb.append( (char)reader.read());
			// 转成char加到StringBuffer对象中
		}
		String data = sb.toString();
		reader.close();
		// 关闭读取流		
		fip.close();
        //数据加载完成
        String[] data1 = data.split("\\r?\\n| ");
        // for(int i=0;i<=data1.length;i++){
        //     System.out.println(data1[i]);
        // }
        long principal;
        double rate;
        String startDate;
        String endDate;
        long Days;
        TreeMap<String,Object> data2 = new TreeMap<String,Object>();
        TreeMap<String,Object> data_final = new TreeMap<>();
        for(int i=0;i+3<data1.length;i+=4){
            principal = Long.valueOf(data1[i].trim()) ;
            rate = Double.valueOf(data1[i+1].trim()) ;
            startDate = data1[i+2].trim();
            endDate = data1[i+3].trim();
            //校验
            YouChuBank2.isPrincipal(principal);
            YouChuBank2.isRate(rate);
            YouChuBank2.isStartData(startDate);
            YouChuBank2.isEndData(endDate);
            //开始计算
            Days = YouChuBank2.totaldays(startDate,endDate);
            double interest = YouChuBank2.interest(principal,rate,Days);
            data2.put(endDate, interest);
        }
        data_final.putAll(data2);
        System.out.println(data_final.keySet());
        File f = new File("b.txt");
		FileOutputStream fop = new FileOutputStream(f);
		// 构建FileOutputStream对象,文件不存在会自动新建
		
		OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
		// 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
		
		writer.append(data2.values().toString());
        writer.close();
		//关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉
		
		fop.close();

    }
    // private static String getType(Object a) {
    //     return a.getClass().toString();
 
    // }
}