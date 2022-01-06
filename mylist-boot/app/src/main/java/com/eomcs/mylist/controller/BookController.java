package com.eomcs.mylist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

@RestController
public class BookController {
  ArrayList bookList = new ArrayList();

  @RequestMapping("/book/list")
  public Object list() {
    return bookList.toArray();
  }

  @RequestMapping("/book/add")
  public Object add(Book book) {
    bookList.add(book);
    //book.setReadDate(new Date(System.currentTimeMillis()));
    return bookList.size();
  }


  @RequestMapping("/book/get")
  public Object get(int index, Book book) {
    if (index < 0 || index >= bookList.size()) { // 값이 저장된 위치가 무효한 인덱스라면 
      return "";
    }
    book = (Book) bookList.get(index);

    return bookList.get(index);
  }

  @RequestMapping("/book/update")
  public Object update(int index, Book book) {
    if (index < 0 || index >= bookList.size()) { // 값이 저장된 위치가 무효한 인덱스라면 
      return 0;
    }
    //    Book old = (Book) bookList.get(index);
    //        book.setViewCount(old.getViewCount());
    //    book.setReadDate(old.getReadDate());

    return bookList.set(index, book) == null ? 0 : 1;
  }

  @RequestMapping("/book/delete")
  public Object delete(int index) {
    if (index < 0 || index >= bookList.size()) { // 값이 저장된 위치가 무효한 인덱스라면 
      return 0;
    }

    return bookList.remove(index) == null ? 0 : 1;
  }
}
