package hw1;

public abstract class Fan implements IUSB {
    private String name;

    public Fan() {
    }

    public Fan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void install() {
        System.out.println(name+"接通了---");
    }

    @Override
    public void uninstall() {
        System.out.println(name+"连接断开了---");
    }
}
