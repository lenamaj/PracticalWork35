package com.alfa.model;

import com.alfa.model.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SourceBooks {

    public static List<Book> generateBooks() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("title1", "Author1", "Publisher1", 1998, 100, 200.00));
        list.add(new Book("title2", "Author2", "Publisher2", 1998, 100, 200.00));
        return list;

       /* return Arrays.asList(
                new Book("title1", "Author1", "Publisher1", 1998, 100, 200.00),
                new Book("title2", "Author2", "Publisher2", 2011, 110, 201.00),
                new Book("title3", "Author3", "Publisher3", 2001, 120, 202.00),
                new Book("title4", "Author4", "Publisher4", 2020, 420, 502.00)
        );*/
    }


}
