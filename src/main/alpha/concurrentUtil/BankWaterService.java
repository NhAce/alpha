package concurrentUtil;

import java.util.Map;
import java.util.concurrent.*;

/**
 * CyclicBarrier可以用于多线程计算数据，最后合并计算结果的场景。例如，用一个Excel保
 * 存了用户所有银行流水，每个Sheet保存一个账户近一年的每笔银行流水，现在需要统计用户
 * 的日均银行流水，先用多线程处理每个sheet里的银行流水，都执行完之后，得到每个sheet的日
 * 均银行流水，最后，再用barrierAction用这些线程的计算结果，计算出整个Excel的日均银行流
 * 水
 */
public class BankWaterService implements Runnable {

    /**
     * 创建 4 个屏障，处理完后执行当前类的 run 方法
     */
    private CyclicBarrier c = new CyclicBarrier(4, this);

    /**
     * 假设有 4 个 sheet，所以启动 4 个线程
     */
    private Executor executor = Executors.newFixedThreadPool(6);

    /**
     * 保存每个 sheet 计算出的银流结果
     */
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count(){

        for (int i = 0; i < 3; i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    //计算银流数据并保存
                    //计算代码略
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    //银流计算完成，插入一个屏障
                    try {
                        System.out.println("before -- " + Thread.currentThread().getName());
                        c.await();
                        System.out.println("after -- " + Thread.currentThread().getName());
                    }catch (InterruptedException | BrokenBarrierException e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    @Override
    public void run() {
        int result = 0;
        //汇总每个 sheet 计算出的结果
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()){
            result += sheet.getValue();
        }
        //保存并输出
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
        System.out.println(c.getNumberWaiting());
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }


}
