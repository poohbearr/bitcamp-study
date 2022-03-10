package com.eomcs.mylist.dao;

import java.io.File;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.domain.Board;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class JsonBoardDao extends AbstractBoardDao {

  String filename = "boards.json";

  public JsonBoardDao() {
    try {   
      ObjectMapper mapper = new ObjectMapper();
      //      TypeFactory 타입정보생성기 = mapper.getTypeFactory();
      //      CollectionType 컬렉션타입정보 = 타입정보생성기.constructCollectionType(
      //          List.class, // 컬렉션의 타입
      //          Board.class); // 컬렉션에 들어갈 항목의 타입
      //      Collection<Board> list = mapper.readValue(new File(filename), 
      //          컬렉션타입정보); // 생설할 목록의 타입정보
      //      boardList.addAll(list);

      boardList.addAll(mapper.readValue(new File(filename), 
          mapper.getTypeFactory().constructCollectionType(List.class, Board.class)));

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
