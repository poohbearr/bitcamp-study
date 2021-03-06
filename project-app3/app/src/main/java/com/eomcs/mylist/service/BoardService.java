package com.eomcs.mylist.service;

import java.util.List;
import com.eomcs.mylist.domain.Board;

public interface BoardService {

  int add(Board board);

  List<Board> list(int pageSize, int pageNo);

  Board get(int no);

  int update(Board board);

  int delete(Board board);

  int size();
}
