package experiment.count;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCount {
    private static long Time;

    public static void serial() {
        int count1 = 0, count2 = 0;
//        生成Pattern对象，Pattern对象表示编译后的正则表达式
        Pattern pattern1 = Pattern.compile(Model.target1);
        Pattern pattern2 = Pattern.compile(Model.target2);

        try {
            long start = System.currentTimeMillis();
            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(Model.filename), Model.code));
            String str;
            while ((str = bf.readLine()) != null) {
                Matcher matcher1 = pattern1.matcher(str);//模式匹配用,生成Matcher对象，利用Matcher对象来进行一系列操作
                Matcher matcher2 = pattern2.matcher(str);
                while (matcher1.find()) {//find会像迭代器一样向前匹配字符串，并通过group返回匹配的子序列，
                    count1++;
                }
                while (matcher2.find()) {
                    count2++;
                }
            }
            bf.close();
            long end = System.currentTimeMillis();
            Time = end - start;
            System.out.println("串行检索时间为: " + Time + "ms 次数分别为: " + count1 + "  " + count2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parallel(int threadNumber) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<FutureTask<String>> result = new ArrayList<FutureTask<String>>();

        long start = System.currentTimeMillis();
        long fileLength = new File(Model.filename).length();
        Task task;
        long unit = fileLength / threadNumber;
        for(int i=0 ; i<threadNumber ; i++){
            if(i!=threadNumber-1) {
                 task = new Task(i * unit, (i + 1) * unit);
            }else{//最后一个线程处理完所有的字节
                 task = new Task(i * unit, fileLength);
            }
            FutureTask<String> futureTask = new FutureTask<String>(task);
            result.add(futureTask);
            executorService.submit(futureTask);
        }
        executorService.shutdown();

        int count1 = 0,count2=0;
        try {
            for (int i = 0; i < threadNumber; i++) {
                String[] str = result.get(i).get().split(",");
                count1+=Integer.valueOf(str[0]);
                count2+=Integer.valueOf(str[1]);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("并行检索时间为: " +(end-start) + "ms 线程数: "+threadNumber+"  加速比为:"+
                new DecimalFormat("#0.00").format(Time*1.0/(end-start))+
                "  次数分别为: 贾宝玉" + count1 + "  林黛玉" + count2);

    }

    public static void main(String[] args){
        serial();
        parallel(1);
        parallel(2);
        parallel(4);
        parallel(8);

    }
}
