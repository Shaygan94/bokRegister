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

    public int readingTime() {
        return minutesPerPage * pages;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return Genre;
    }

    public void setGenre(Genre genre) {
        Genre = genre;
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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getMinutesPerPage() {
        return minutesPerPage;
    }

    public void setMinutesPerPage(int minutesPerPage) {
        this.minutesPerPage = minutesPerPage;
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




