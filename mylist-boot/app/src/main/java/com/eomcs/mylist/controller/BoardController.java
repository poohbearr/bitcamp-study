package com.eomcs.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;

@RestController 
public class BoardController {
  ArrayList boardList = new ArrayList();

  public BoardController() throws Exception {
    System.out.println("BoardController() 호출됨!!!");

    try {
      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("boards.ser2")));

      // 1) 객체가 각각 따로 serialize 되었을 경우, 다음과 같이 객체 단위로 읽으면 되고,
      //    while(true) { 
      //      try {
      //        Board board = (Board) in.readObject();
      //        boardList.add(board);
      //
      //      } catch (Exception e) {
      //        break;
      //      }
      //    }

      // 2) 목록이 통째로 serialize 되었을 경우, 한 번에 목록을 읽으면 된다.
      boardList = (ArrayList) in.readObject(); // 단, 기존에 생성한 ArrayList 객체는 버린다.

      in.close();
      // in.close(); // 데코레이터를 close() 하면 그 데코레이터와 연결된 객체들도 모두 close() 된다.
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
    }
  }

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

  @RequestMapping("/board/save")
  public Object save() throws Exception {
    // 1) 주 작업 객체 준비
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("boards.ser2")));

    // 1) 다음과 같이 목록에 들어 있는 객체를 한 개씩 순차적으로 serialize 할 수도 있고,
    //    Object[] arr = boardList.toArray();
    //    for (Object obj : arr) {
    //      out.writeObject(obj);
    //    }

    // 2) 다음과 같이 목록을 serialize 할 수도 있다.
    out.writeObject(boardList);
    out.close();
    // out.close(); // 데코레이터에서 close()하면 그 데코레이터와 연결된 모든 객체도 자동으로 close() 한다.
    return boardList.size();
  }
}



