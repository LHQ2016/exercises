package reflection.proxytest;

public class StudentImpl implements StudentDao {
    @Override
    public void login() {
        System.out.println("��¼����");
    }

    @Override
    public void register() {
        System.out.println("ע�Ṧ��");
    }
}
