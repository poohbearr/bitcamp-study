package com.eomcs.mylist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.BookDao;
import com.eomcs.mylist.domain.Book;

@RestController
public class BookController {

  @Autowired
  BookDao bookDao;

  @RequestMapping("/book/list")
  public Object list() {
    return bookDao.findAll();
  }

  @RequestMapping("/book/add")
  public Object add(Book book) throws Exception {
    bookDao.insert(book);
    //book.setReadDate(new Date(System.currentTimeMillis()));
    return bookDao.countAll();
  }


  @RequestMapping("/book/get")
  public Object get(int index) throws Exception {
    Book book = bookDao.findByNo(index);
    if (book == null) { // 값이 저장된 위치가 무효한 인덱스라면 
      return "";
    }

    return book;
  }

  @RequestMapping("/book/update")
  public Object update(int index, Book book) throws Exception {
    Book old = bookDao.findByNo(index);
    if (old == null) { // 값이 저장된 위치가 무효한 인덱스라면 
      return 0;
    }

    return bookDao.update(index, book);
  }

  @RequestMapping("/book/delete")
  public Object delete(int index) throws Exception {
    return bookDao.delete(index);
  }

}
