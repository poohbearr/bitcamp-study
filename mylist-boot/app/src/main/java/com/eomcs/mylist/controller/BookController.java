package com.eomcs.mylist.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class BookController {
  ArrayList bookList = new ArrayList();

  public BookController() throws Exception {
    System.out.println("BookController() 호출됨!!!");

    try {
      BufferedReader in = new BufferedReader(new FileReader("books.json"));

      ObjectMapper mapper = new ObjectMapper();

      bookList = new ArrayList(mapper.readValue(in.readLine(), Book[].class));

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
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("books.json")));

    ObjectMapper mapper = new ObjectMapper();

    out.println(mapper.writeValueAsString(bookList.toArray()));

    out.close();
    // out.close(); // 데코레이터에서 close()하면 그 데코레이터와 연결된 모든 객체도 자동으로 close() 한다.
    return bookList.size();
  }
}
