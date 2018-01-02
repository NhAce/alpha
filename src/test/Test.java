import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
public class Test {
    public static void main(String[] args) throws Exception {
//        int sharedShift = 16;
//        int exclusiveMask = (1 << sharedShift) - 1;
//        System.out.println("SHARED_UNIT " + (1 << sharedShift));
//        System.out.println("MAX_COUNT " + ((1 << sharedShift) -1));
//        System.out.println("EXCLUSIVE_MASK " + ((1 << sharedShift) -1));
//        System.out.println(1 & exclusiveMask);
        System.out.println(new Random().nextInt(200));

        String url = "jdbc:mysql://127.0.0.1/gps_1";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "1234";
        Class.forName(driver);
        Connection connection = null;
        connection = DriverManager.getConnection(url, user, password);
        if (connection != null){
            System.out.println("数据库连接成功！");
//            insert(connection);
        }else {
            System.out.println("数据库连接失败！");
        }
//
//        String tableName = "t_gps_" + getMonth(11) + Test1.getDay(new Date());
//        System.out.println(tableName);
//
//        String max = 29030011 + "";
//        int dbNo = Integer.valueOf(max.substring(0, max.length() - 6));
//        System.out.println("dbName: gps_" + dbNo);
//        String a = max.substring(max.length() - 6, max.length());
//        int a1 = Integer.valueOf(a);
//        System.out.println("tableName: t_gps_" + getMonth(Test1.getMonth(new Date())) + Test1.getDay(new Date()) + "_" + getTableNo(a1));
        String aa = "http://localhost:10008/bsp/api/locationList?deviceCode=111&beginTime=2017-01-01 16:10:29&endTime=2017-01-01 16:11:29&token=123456&pageNumber=1&pageSize=10";
        System.out.println(aa.substring(79));
    }

    public static String getMonth(int month){
        String[] indexs = {"a", "b", "c", "d"};
        return indexs[month % 4];
    }

    public static int getTableNo(int num){
        if (num > 0){
            return (num - 1) / 10000 + 1;
        }
        return 1;
    }

    public static void insert(Connection connection) throws Exception{
        //开始时间
        long beginTime = new Date().getTime();
        //sql 前缀
        String prefix = "insert into t_gps_a15_1 (device_code, alarm_status, vehicle_status, lat, lon, height, speed, direction, time, mile, oil, speed2, signal_status, bst, io_status, analog, wifi, satellite_num, vendor_code) values";
        //保存sql后缀
        StringBuffer suffix = null;
        //设置事务非自动提交
        connection.setAutoCommit(false);
        PreparedStatement pst = (PreparedStatement)connection.prepareStatement("");
        long time = System.currentTimeMillis() / 1000;
        //外层循环，提交事务次数
        for (int i = 1; i<1441; i++){
            suffix = new StringBuffer();
            for (int j = 1; j < 10001; j++){
                int lat = new Random().nextInt(200);
                int lon = new Random().nextInt(200);
                suffix.append("('" + j + "','10','11','" + lat +"','" + lon + "','10','25','10','" + (time + i) + "','200','1','30','1','10','20','111','12','18','haha"+j+"'),");
            }
            String sql = prefix + suffix.substring(0, suffix.length() - 1);
            pst.addBatch(sql);
            pst.executeBatch();
            connection.commit();
            System.out.println(i);
        }
        pst.close();
        connection.close();

        long endTime = new Date().getTime();
        System.out.println("1440W数据插入花费时间：" + (endTime - beginTime)/1000 + "s");

    }

}
