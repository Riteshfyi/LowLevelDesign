public class Client {
    public static void main(String[] args) {
        DesktopBuilder desktopBuilder = new DesktopBuilder();
        Computer desktop  = new Director(desktopBuilder).setup();
        System.out.println(desktop);
    }
}
