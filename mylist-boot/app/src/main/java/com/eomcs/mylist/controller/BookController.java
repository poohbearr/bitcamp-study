package com.eomcs.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

@RestController
public class BookController {
  ArrayList bookList = new ArrayList();

  public BookController() throws Exception {
    System.out.println("BookController() 호출됨!!!");

    try {
      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("books.test")));

      bookList = (ArrayList) in.readObject();

      in.close();
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
    }

  }

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

  @RequestMapping("/book/save")
  public Object save() throws Exception {

    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("books.test")));

    out.writeObject(bookList);

    out.close();

    return bookList.size();
  }
}
