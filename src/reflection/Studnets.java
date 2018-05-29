package reflection;

public class Studnets {
    public int id;
    private String name;
    String address;

    public Studnets() {
    }

    Studnets(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private Studnets(int id){
        this.id = id;
    }

    public Studnets(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Studnets{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    void fun(String string){
        System.out.println("fun : "+string);
    }

    private void method(String name){
        System.out.println(name);
    }

    public void test(String string){
        System.out.println("通过反射调用test方法，传入的参数是："+string);
    }
}
