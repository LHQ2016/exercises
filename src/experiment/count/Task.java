package experiment.count;

import java.io.RandomAccessFile;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task implements Callable<String> {
    long start,end;

    public Task(){}
    public Task(long start,long end){
        this.start = start;
        this.end = end;

    }

    public String call() throws Exception {
        int count1 = 0, count2 = 0;
//      生成Pattern对象，Pattern对象表示编译后的正则表达式
        Pattern pattern1 = Pattern.compile(Model.target1);
        Pattern pattern2 = Pattern.compile(Model.target2);

        RandomAccessFile randomAccessFile = new RandomAccessFile(Model.filename,"r");
        randomAccessFile.seek(start);

        String str = new String();

        byte[] buff = new byte[Model.buffLen];
        long count = (end-start)/Model.buffLen;
        long l = (end-start)%Model.buffLen;

        if(l==0){
            count--;
        }

        for(int i=0 ; i<count+1 ; i++) {
            if(i==count &&  l>0){
                buff = new byte[(int)l];
                randomAccessFile.read(buff);
            }else {
                randomAccessFile.read(buff);
            }
            str = new String(buff, Model.code);

            Matcher matcher1 = pattern1.matcher(str);//模式匹配用,生成Matcher对象，利用Matcher对象来进行一系列操作
            Matcher matcher2 = pattern2.matcher(str);
            while (matcher1.find()) {//find会像迭代器一样向前匹配字符串，并通过group返回匹配的子序列，
                count1++;
            }
            while (matcher2.find()) {
                count2++;
            }
        }
        randomAccessFile.close();

        return count1+","+count2;
    }
}