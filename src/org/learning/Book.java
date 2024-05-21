package org.learning;

public class Book {
    // Attributi
    private String title;
    private int pageNum;
    private String author;
    private String publisher;

    // Costruttore
    public Book(String title, int pageNum, String author, String publisher) throws IllegalArgumentException {
        checkString(title, "Il titolo non può essere vuoto");
        checkString(author, "L'autore non può essere vuoto");
        checkString(publisher, "L'editore non può essere vuoto");
        checkNumber(pageNum);

        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pageNum = pageNum;
    }
    // Metodi

    private void checkString(String str, String msg) throws IllegalArgumentException{
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(msg);
        }
    }

    private void checkNumber(int num) throws IllegalArgumentException{
        if (num <= 0) {
            throw new IllegalArgumentException("Il numero non può essere inferiore o uguale a 0");
        }
    }


    // Setter / Getter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IllegalArgumentException{
        checkString(title, "Il titolo non può essere vuoto");
        this.title = title;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) throws IllegalArgumentException{
        checkNumber(pageNum);
        this.pageNum = pageNum;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws IllegalArgumentException{
        checkString(author, "L'autore non può essere vuoto");
        this.author = author;
    }

    public String getEditor() {
        return publisher;
    }

    public void setEditor(String publisher) throws IllegalArgumentException{
        checkString(publisher, "L'editore non può essere vuoto");
        this.publisher = publisher;
    }
}
