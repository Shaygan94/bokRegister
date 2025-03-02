import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
   private BookRegister bookRegister;

 public Program() throws FileNotFoundException {
     bookRegister = new BookRegister();
 }

    public void setBookRegister(BookRegister bookRegister) {
        this.bookRegister = bookRegister;
    }



    public void run() throws IOException {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        while (choice != 8) {
            System.out.println("Enter choice");
            System.out.println("1. Add Book");
            System.out.println("2. Show all books");
            System.out.println("3. Books by Genre");
            System.out.println("4. Books by maximum reading time");
            System.out.println("5. Remove book");
            System.out.println("6. Books by auhtor");
            System.out.println("7. Show books older than a specific date in this format YYYY-MM-DD");
            System.out.println("8. Exit");
            choice = scan.nextInt();
            switch (choice) {
                case 1 -> addBook();
                case 2 -> showBooks();
                case 3 -> booksByGenre();
                case 4 -> booksByMaximumReadingTime();
                case 5 -> removeBook();
                case 6 -> booksByAuthor();
                case 7 -> booksOlderThan();
                case 8 -> quit();
                default -> System.out.println("Invalid choice, your choices are 1-7");
            }
        }
    }

    private void booksOlderThan() {
        System.out.println("Please enter the specific date you would want to see books older than in this format YYYY-MM-DD; ");
        Scanner scan = new Scanner(System.in);
        String date = scan.nextLine();
        LocalDate localDate = LocalDate.parse(date);
        bookRegister.booksByPublishedDate(localDate);
    }

    private void addBook() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter isbn");
        String isbn = scan.nextLine();

        System.out.println("Enter publish date in this format YYYY-MM-DD");
        String choice = scan.nextLine();
        LocalDate publishDate = LocalDate.parse(choice);

        System.out.println("Enter book title");
        String bookTitle = scan.nextLine();

        System.out.println("Enter author");
        String author = scan.nextLine();

        System.out.println("Enter total pages in book");
        int totalPages = scan.nextInt();
        scan.nextLine(); //Swallowing line

        System.out.println("Enter Genre of book, you can choose from CRIME, ACTION, FANTASY, CLASSIC, OTHER;");
        String genreChoice = scan.nextLine().toUpperCase();
        Genre genre = Genre.valueOf(genreChoice);

        System.out.println("Enter minutes per page");
        int minutesPerPage = scan.nextInt();
        scan.nextLine(); //Swallowing line


        Book book = new Book(isbn, publishDate, bookTitle, author, totalPages, genre, minutesPerPage );

        ArrayList<Chapter> chapters = new ArrayList<>();
        boolean chapterChoice = true;
        while(chapterChoice){

            System.out.println("Enter Chapter title");
            String chapterTitle = scan.nextLine();

            System.out.println("Enter number of pages in chapter");
            int chapterPages = scan.nextInt();
            scan.nextLine(); // swallowing
            Chapter chapter = new Chapter(chapterTitle, chapterPages);
            chapters.add(chapter);

            System.out.println("Wanna add more chapters? choose between 'Y/N'. ");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("N")){
                chapterChoice = false;
            }


        }

        bookRegister.addBook(book);


    }

    private void showBooks() {
        bookRegister.numberOfBooks();
    }

    private void booksByGenre() {
        System.out.println("Enter book genre, you can choose between: CRIME, ACTION, FANTASY, CLASSIC, OTHER;");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine().toUpperCase();
        Genre g = Genre.valueOf(choice);
        bookRegister.genreInBooks(g);
    }
    private void booksByMaximumReadingTime() {
        System.out.println("Enter book with over x minute reading time");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        ArrayList<Book> b = bookRegister.booksByReadingTime(choice);
        for (Book book : b) {
            System.out.println(book);
        }
      }


    private void removeBook() {
        System.out.println("Enter ISBN of the book you want to remove");
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.nextLine();
        bookRegister.removeBook(isbn);
    }

    private void booksByAuthor() {
        System.out.println("Please enter name of the author");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        bookRegister.authorInBooks(choice);
    }

    private void quit() throws IOException {
        System.out.println("Quitting, goodbye!!");
        bookRegister.writeBooksToFile();
    }

}
