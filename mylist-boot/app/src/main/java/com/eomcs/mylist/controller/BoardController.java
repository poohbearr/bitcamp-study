package com.eomcs.mylist.controller;

import java.io.FileReader;
import java.io.FileWriter;
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

    FileReader in = new FileReader("boards.csv");

    StringBuilder buf = new StringBuilder();
    int c;
    while ((c = in.read()) != -1) { // 파일에서 한 문자를 읽는다.
      if (c == '\n') { // 만약 읽은 문자가 줄바꿈 명령이라면, 지금까지 읽은 CSV 데이터를 분석하여 Contact 객체에 담는다.
        boardList.add(Board.valueOf(buf.toString())); // // 파일에서 읽은 csv 데이터로 객체를 초기화시킨후 목록에 등록한다.

        buf.setLength(0); // 다음 데이터를 읽기 위해 버퍼를 초기화시킨다.

      } else { // 문자를 읽을 때 마다 버퍼에 임시 보관한다.
        buf.append((char) c);
      }
    }

    in.close();
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
    FileWriter out = new FileWriter("boards.csv"); // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 생성된다.

    Object[] arr = boardList.toArray();
    for (Object obj : arr) {
      Board board = (Board) obj;
      out.write(board.toCsvString() + "\n");
    }
    out.close();
    return arr.length;
  }
}



