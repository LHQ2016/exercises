package expriment.experiment01.twoPointLookup;

public class Array {//产生1M的有序与无序数组
    private static final int LENGTH =1*1024*1024;
    public static Integer[] disorder = new Integer[LENGTH];
    public static int[] order = new int[LENGTH];

    static {
        for (int i = 0; i < disorder.length; i++) {
            disorder[i] = (int)(Math.random()*1000);
            order[i] = i;
        }
//        Arrays.sort(order);
    }
    public static void join(Integer[] A,Integer[] B,Integer[] src){
        int i=0,j=0,t=0;
        while (i<A.length && j<B.length){
            if (A[i]<=B[j]) {
                src[t++]=A[i++];
            }else{
                src[t++]=B[j++];
            }
        }

        while (i<A.length){
            src[t++] = A[i++];
        }

        while (j<B.length){
            src[t++] = B[j++];
        }
    }

}
