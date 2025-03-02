import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("In the start of the main()");
        BookRegister br = new BookRegister();
        Program p = new Program();
        p.setUserName(args[0]);
        try {
            br.initRegister();
            p.setBookRegister(br);
            p.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
