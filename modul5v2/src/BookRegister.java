import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BookRegister {

    private ArrayList<Book> books;

    public void initRegister() throws FileNotFoundException {
        books = readBooksFromFile();

    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equalsIgnoreCase(isbn)) {
                books.remove(b);
                return;
            }
        }
    }

    public void numberOfBooks() {
        for (Book b : books) {
            System.out.println(b.toString());
        }
        int count = books.size();
        System.out.println("Number of books: " + count);
    }

    public void genreInBooks(Genre genre) {
        for (Book b : books) {
            if (b.getGenre() == genre) {
                System.out.println("Books with Specific Genre:" + b.toString());
            }
        }


    }

    public void authorInBooks(String author) {
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Books with Specific Author:" + b.toString());
            }
        }

    }

    public ArrayList<Book> booksByReadingTime(int minutes) {
        ArrayList<Book> booksToReturn = new ArrayList<>();
        for (Book b : books) {
            if (b.readingTime() > minutes) {
                booksToReturn.add(b);
            }
        }
        return booksToReturn;
    }

    public void booksByPublishedDate(LocalDate publishedDate) {
        for (Book b : books) {
            if (b.getPublicationDate().isBefore(publishedDate)) {
                System.out.println("Books with Specific Publication Date:" + b.toString());
            }
        }
    }


    public void writeBooksToFile() throws IOException {
        File file = new File("books2.txt");
        try (FileWriter writer = new FileWriter(file);) {
            for (Book b : books) {
                writer.write(b.toFileFormat());
                writer.write("---\n");

            }
        }
    }
    public ArrayList<Book> readBooksFromFile() throws FileNotFoundException {
      ArrayList<Book> booksToReturn = new ArrayList<>();
        File file = new File("books2.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            Book b = new Book();
            String isbn = scan.nextLine();
            b.setIsbn(isbn);
            String publishDate = scan.nextLine();
            b.setPublicationDate(LocalDate.parse(publishDate));
            String title = scan.nextLine();
            b.setTitle(title);
            String author = scan.nextLine();
            b.setAuthor(author);
            String pages = scan.nextLine();
            b.setPages(Integer.parseInt(pages));
            String genre = scan.nextLine();
            b.setGenre(Genre.valueOf(genre));
            String minutesPerPage = scan.nextLine();
            b.setMinutesPerPage(Integer.parseInt(minutesPerPage));
            String numberOfChapters = scan.nextLine();
            int chapterArraySize = Integer.parseInt(numberOfChapters);
            ArrayList<Chapter> chapters = new ArrayList<>();
            for (int i = 0; i < chapterArraySize; i++) {
                Chapter c = new Chapter();
                String chapterTitle = scan.nextLine();
                c.setTitle(chapterTitle);
                String pagesInChapter = scan.nextLine();
                c.setPages(Integer.parseInt(pagesInChapter));
                chapters.add(c);

            }
            b.setArrayChapter(chapters);
            booksToReturn.add(b);
            scan.nextLine();

        } return booksToReturn;
    }

}