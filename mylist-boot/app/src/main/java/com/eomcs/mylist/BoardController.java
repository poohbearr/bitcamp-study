package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
  @RequestMapping("/board/list")
  public Object list() {
    return ArrayList3.toArray(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {
    //    System.out.println(contact);
    ArrayList3.add(board);
    return ArrayList3.size;
  }


  @RequestMapping("/board/get")
  public Object get(String name) {
    int index = indexOf(name);
    if (index == -1) {
      return "";
    }

    return ArrayList3.list[index];
  }

  @RequestMapping("/board/update")
  public Object update(Board board) {
    int index = indexOf(board.name);
    if (index == -1) {
      return 0;
    }

    return ArrayList3.set(index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board/delete")
  public Object delete(String name) {
    int index = indexOf(name);
    if (index == -1) {
      return 0;
    }

    ArrayList3.remove(index);
    return 1;
  }

  // 기능:
  // - 이메일로 연락처 정보를 찾는다.
  // - 찾은 연락처의 배열 인덱스를 리턴한다.
  //
  static int indexOf(String name) {
    for (int i = 0; i < ArrayList3.size; i++) {
      Board board = (Board) ArrayList3.list[i];
      if (board.name.equals(name)) { 
        return i;
      }
    }
    return -1;
  }
}
