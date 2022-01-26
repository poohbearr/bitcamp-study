package com.eomcs.mylist.dao;

import java.io.File;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.domain.Board;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class JsonBoardDao extends AbstractBoardDao {

  String filename = "boards.json";

  public JsonBoardDao() {
    try {   
      ObjectMapper mapper = new ObjectMapper();
      boardList.addAll(mapper.readValue(new File(filename), Board[].class));

    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류 발생!");
    }
  }

  @Override
  protected void save() throws Exception {

    ObjectMapper mapper = new ObjectMapper();

    mapper.writeValue(new File(filename), boardList.toArray());

  }

}
