import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class Test1 {
    public final static String prefix = "create table `t_gps_";
    public static void main(String[] args) throws Exception {
//        System.out.println(getMonFirstDay(null));
        String[] tabs = {"a","b","c","d"};
//        for (int m = 0; m < tabs.length; m++) {
//                for (int j = 1; j < 32; j++) {
//                    String sql = "CREATE TABLE `t_gps_" + tabs[m] + "_" + j + "` ("+
//                            "`id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',"+
//                    "`device_code` varchar(12) DEFAULT NULL COMMENT '终端编号',"+
//                    "`alarm_status` int(11) DEFAULT NULL COMMENT '报警标志',"+
//                    "`vehicle_status` int(11) DEFAULT NULL COMMENT '车辆状态',"+
//                    "`lat` double DEFAULT NULL COMMENT '纬度',"+
//                    "`lon` double DEFAULT NULL COMMENT '经度',"+
//                    "`height` double DEFAULT NULL COMMENT '海拔',"+
//                    "`speed` double DEFAULT NULL COMMENT 'GPS 速度',"+
//                    "`direction` double DEFAULT NULL COMMENT '方向',"+
//                    "`time` bigint(32) DEFAULT NULL COMMENT 'GPS 时间',"+
//                    "`mile` double DEFAULT NULL COMMENT '里程',"+
//                    "`oil` double DEFAULT NULL COMMENT '油量L',"+
//                    "`speed2` double DEFAULT NULL COMMENT '记录仪速度',"+
//                    "`signal_status` int(11) DEFAULT NULL COMMENT '扩展车辆信号状态位',"+
//                    "`bst` int(11) DEFAULT NULL COMMENT '位置基本信息状态位',"+
//                    "`io_status` int(11) DEFAULT NULL COMMENT 'IO状态位',"+
//                    "`analog` varchar(32) DEFAULT NULL COMMENT '模拟量',"+
//                    "`wifi` int(11) DEFAULT NULL COMMENT '无线通信网络信号强度',"+
//                    "`satellite_num` int(11) DEFAULT NULL COMMENT '定位卫星数',"+
//                    "`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',"+
//                    "`vendor_code` varchar(20) DEFAULT NULL COMMENT '运营商代码',"+
//                            "`alarm_handle` int(11) DEFAULT NULL COMMENT '是否处理'," +
//                    "PRIMARY KEY (`id`),"+
//                    "KEY `index_devicecode_time_alarmhandle` (`device_code`,`time`,`alarm_handle`)"+
//                    ") ENGINE=MyISAM DEFAULT CHARSET=utf8;\r\n";
//
//                    File file=new File("d://1.txt");
//                    OutputStream out=new FileOutputStream(file,true);
//                    byte b[] = sql.getBytes();
//                    out.write(b);
//                    out.close();
//                }
//        }

        for (int m = 0; m < tabs.length; m++){
            for (int n = 1; n < 151; n++){
//                for (int i = 1; i < 11; i++){
                    String sql = "drop table if exists t_gps_alarm_" + tabs[m]  + "_" + n + ";\r\n";
                    File file = new File("d://1.txt");
                    OutputStream out = new FileOutputStream(file, true);
                    byte[] b = sql.getBytes();
                    out.write(b);
                    out.close();
//                }
            }
        }
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(1511104289000l));
//        CountDownLatch countDownLatch;
//        CyclicBarrier cyclicBarrier;
    }

    /**
     * 获取年
     * @param date
     * @return
     */
    public static int getYear(Date date){
        if (date == null){
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取月
     * @param date
     * @return
     */
    public static int getMonth(Date date){
        if (date == null){
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH ) + 1;
    }

    /**
     * 获取日
     * @param date
     * @return
     */
    public static int getDay(Date date){
        if (date == null){
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前月的第一天日期
     * @param date
     * @return
     */
    public static Date getMonFirstDay(Date date){
        if (date == null){
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(getYear(date), getMonth(date) - 1,1);
        return calendar.getTime();
    }


}
