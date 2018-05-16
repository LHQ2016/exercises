package experiment04.ThreadPools;

public class TaskUpload extends Upload {

    public TaskUpload(String info){
        this.info = info;
    }
    public String getInfo(){
        return info;
    }
    @Override
    public boolean uploadPic()  {
        // TODO Auto-generated method stub
        System.out.println(info+"sleep begin ....");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(info+"sleep end ....");
        return false;
    }
}