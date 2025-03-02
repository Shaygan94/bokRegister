public class Chapter {
    private String title;
    private int pages;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
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
