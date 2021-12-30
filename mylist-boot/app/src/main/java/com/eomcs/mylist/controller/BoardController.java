package com.eomcs.mylist.controller;

import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;

@RestController 
public class BoardController {
  ArrayList boardList = new ArrayList();

  @RequestMapping("/board/list")
  public Object list() {
    return boardList.toArray();
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {
    boardList.add(board);
    board.setCreatedDate(new Date(System.currentTimeMillis()));
    return boardList.size();
  }


  @RequestMapping("/board/get")
  public Object get(int index, Board board) {
    if (index < 0 || index >= boardList.size()) { // 값이 저장된 위치가 무효한 인덱스라면 
      return "";
    }
    board = (Board) boardList.get(index);
    board.setViewCount(board.getViewCount() + 1);

    return boardList.get(index);
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    if (index < 0 || index >= boardList.size()) { // 값이 저장된 위치가 무효한 인덱스라면 
      return 0;
    }
    Board old = (Board) boardList.get(index);
    board.setViewCount(old.getViewCount());
    board.setCreatedDate(old.getCreatedDate());

    return boardList.set(index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= boardList.size()) { // 값이 저장된 위치가 무효한 인덱스라면 
      return 0;
    }

    return boardList.remove(index) == null ? 0 : 1;
  }
}



