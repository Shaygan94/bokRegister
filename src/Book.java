import java.time.LocalDate;
import java.util.ArrayList;

public class Book {
    private String isbn;
    private LocalDate publicationDate;
    private String title;
    private String author;
    private int pages;
    private Genre Genre;
    ArrayList<Chapter> arrayChapter;
    private int minutesPerPage;

    public Book(String isbn, LocalDate publicationDate, String title, String author,
                int pages, Genre genre, int minutesPerPage) {
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.title = title;
        this.author = author;
        this.pages = pages;
        Genre = genre;
        this.minutesPerPage = minutesPerPage;
    }

    public int readingTime() {
        return minutesPerPage * pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public Genre getGenre() {
        return Genre;
    }

    public ArrayList<Chapter> getArrayChapter() {
        return arrayChapter;
    }

    public void setArrayChapter(ArrayList<Chapter> arrayChapter) {
        this.arrayChapter = arrayChapter;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public int getMinutesPerPage() {
        return minutesPerPage;
    }


    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", publicationDate=" + publicationDate +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", minutesPerPage=" + minutesPerPage +
                ", Genre=" + Genre +
                ", arrayChapter=" + arrayChapter +
                '}';
    }


    public String toFileFormat() {
        StringBuilder s = new StringBuilder(isbn + '\n' +
                publicationDate + '\n' +
                title + '\n' +
                author + '\n' +
                pages + '\n' +
                Genre + '\n' +
                minutesPerPage + '\n' +
                arrayChapter.size() + '\n');
        for (Chapter c : arrayChapter) {
            s.append(c.toFileFormat());
        }

        return s.toString();
    }
}




