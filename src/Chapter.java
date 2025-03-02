public class Chapter {
    private String title;
    private int pages;

    public Chapter(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }


    public int getPages() {
        return pages;
    }



    @Override
    public String toString() {
        return "Chapter{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }

    public String toFileFormat() {
        return  title + '\n' +
                 pages + '\n';

    }
}
