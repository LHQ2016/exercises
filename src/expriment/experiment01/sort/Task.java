package expriment.experiment01.sort;

import java.util.concurrent.Callable;

public class Task implements Callable<Integer[]>{
    Integer[] arr;
    boolean flag;

    public Task(Integer[] arr,String type){
        this.arr = arr;
        if(type.equals("qsort")){
            flag=true;
        }
    }

    public Integer[] call() {
        if(flag) {
            q_sort(arr, 0, arr.length - 1);
        }else{
            divide(arr,0,arr.length-1);
        }
        return arr;
    }

    public static void divide(Integer[] A,int l,int r ){
        if(l<r){
            divide(A,l,(l+r)/2);
            divide(A,(l+r)/2+1,r);
            join(A,l,(l+r)/2,r);
        }
    }
    public static void join(Integer[] A,int l,int m,int r ){
        int i=l,j=m+1,t=0;   //i左数组的指针   j右数组的指针   t新数组的指针
        int[] tem = new int[r-l+1];//临时数组用来存放合并的结果

        while (i<=m && j<=r){
            if (A[i]<=A[j]) {
                tem[t++]=A[i++];
            }else{
                tem[t++]=A[j++];
            }
        }

        while (i<=m){
            tem[t++] = A[i++];
        }

        while (j<=r){
            tem[t++] = A[j++];
        }

        t=0;
        while (l<=r){
            A[l++] = tem[t++];
        }
    }

    public static void q_sort(Integer[] A,int l,int r){
        if(l>r){
            return ;
        }
        int key = A[l];
        int i=l,j=r;

        while (i<j){
            while (i<j && A[j]>=key){
                j--;
            }
            A[i]=A[j];

            while (i<j && A[i]<=key){
                i++;
            }
            A[j]=A[i];
        }

        A[i] = key;
        q_sort(A,l,i-1);
        q_sort(A,i+1,r);
    }

}
