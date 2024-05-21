package org.learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner
        Scanner scanner = new Scanner(System.in);
        // Chiedo all'utente quanti libri vuole inserire inizializzo array
        System.out.println("Quanti libri vuoi aggiungere?");
        int arrayL = 0;
        try {
            arrayL = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ERRORE: Hai inserito un numero/carattere non valido");
        }
        Book[] books = new Book[arrayL];

        // Itero array facendo inserire i dati dei libri all' utente
        for (int i = 0; i < books.length; i++) {
            System.out.println("Inserisci il nome del libro");
            String name = scanner.nextLine();

            System.out.println("Inserisci il numero delle pagine");
            int pages = 0;
            try {
                pages = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERRORE: Hai inserito un carattere non valido");
            }

            System.out.println("Inserisci l'autore");
            String author = scanner.nextLine();

            System.out.println("Inserisci l'editore");
            String publisher = scanner.nextLine();

            try {
                books[i] = new Book(name, pages, author, publisher);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        // chiudo scanner
        scanner.close();

        // Prendo il file books.txt
        File booksTxt = new File("./resources/books.txt");
        System.out.println(booksTxt.exists());
        // try-with-resources per scrivere il file
        try (FileWriter fileWriter = new FileWriter(booksTxt)) {
            for (int i = 0; i < books.length; i++) {
                fileWriter.write("Titolo: " + books[i].getTitle() +"\n");
                fileWriter.write("Pagine: " + books[i].getPageNum()+"\n");
                fileWriter.write("Autore: " + books[i].getAuthor()+"\n");
                fileWriter.write("Editore: " + books[i].getEditor()+"\n");
                fileWriter.write("-----------------------------------------\n");
            }
        } catch (IOException e) {
            System.out.println("Impossibile scrivere sul file");
        }

        // Leggo file
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(booksTxt);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Impossibile leggere il file");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
    }
}
