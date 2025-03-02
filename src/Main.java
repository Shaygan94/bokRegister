import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("In the start of the main()");
        try {
          new Program().run();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
