package com.alfa.controller;

import com.alfa.model.ServiceBooks;
import com.alfa.model.entity.Book;
import com.alfa.view.BooksView;
import com.alfa.view.InputDataView;

import java.util.List;
import java.util.function.Predicate;

public class BooksController {

    private BooksView printBooks;
    private ServiceBooks serviceBooks;
    private InputDataView dataView;


    public BooksController() {

        printBooks = new BooksView();
        serviceBooks = new ServiceBooks();
        dataView = new InputDataView(printBooks);
    }

    public void execute() {
        while (true) {
            System.out.println();
            int menuItem = dataView.inputMenuItem();
            switch (menuItem) {
                case 0: System.exit(0);
                case 1: printBooks.printListBooks(serviceBooks.getBookList()); break;
                case 2: inputAddBook(); break;
                case 3: inputNewPrise(); break;
                case 4: handleFilterMenu(); break;
                default: printBooks.printMessage(BooksView.ERROR_ENTER);

            }
        }
    }

    private void inputAddBook() {
        String name = dataView.inputString(BooksView.ENTER_TITLE);
        String author = dataView.inputString(BooksView.ENTER_AUTHOR);
        String publisher = dataView.inputString(BooksView.ENTER_PUBLISHER);
        String year = dataView.inputString(BooksView.ENTER_YEAR);
        String pages = dataView.inputString(BooksView.ENTER_PAGES);
        String cost = dataView.inputString(BooksView.ENTER_COST);
        serviceBooks.addBook(name, author, publisher, Integer.parseInt(year), Integer.parseInt(pages),
                Double.parseDouble(cost));
    }

    private void inputNewPrise() {
        String cost = dataView.inputString(BooksView.ENTER_COST);
        serviceBooks.increasePrise(Double.parseDouble(cost));
    }

    public void handleFilterMenu() {
        while (true) {
            System.out.println();
            int menuItem = dataView.inputFilterMenu();
            switch (menuItem) {
                case 1: filterByAuthor(); break;
                case 2:
                case 3:
                default:
                    printBooks.printMessage(BooksView.ERROR_ENTER);

            }
        }
    }
    private void filterByAuthor() {
        String author = dataView.inputString(BooksView.ENTER_AUTHOR);
        printBooks.printListBooks(serviceBooks.filterBy(book -> book.getAuthor().equals(author)));

    }

}
