package com.eomcs.mylist;

import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class BoardController {
  ArrayList boardList = new ArrayList();

  @RequestMapping("/board/list")
  public Object list() {
    return ArrayList.toArray(boardList);
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {
    ArrayList.add(boardList, board);
    board.setCreatedDate(new Date(System.currentTimeMillis()));
    return boardList.size;
  }


  @RequestMapping("/board/get")
  public Object get(int index, Board board) {
    if (index < 0 || index >= boardList.size) { // 값이 저장된 위치가 무효한 인덱스라면 
      return "";
    }
    board = (Board) boardList.list[index];
    board.viewCount++;

    return boardList.list[index];
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    if (index < 0 || index >= boardList.size) { // 값이 저장된 위치가 무효한 인덱스라면 
      return 0;
    }
    Board old = (Board) boardList.list[index];
    board.viewCount = old.viewCount;
    board.createdDate = old.createdDate;

    return ArrayList.set(boardList, index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= boardList.size) { // 값이 저장된 위치가 무효한 인덱스라면 
      return 0;
    }

    return ArrayList.remove(boardList, index) == null ? 0 : 1;
  }
}



