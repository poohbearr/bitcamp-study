package com.eomcs.mylist.domain;

import java.sql.Date;

public class Board {
  String title;
  String content;
  int viewCount;
  java.sql.Date createdDate;

  public Board() {
    System.out.println("Board() 호출됨!!!");
  }

  public Board(String csvStr) {
    String[] values = csvStr.split(","); // 예) ["홍길동","hong@test.com",010-1111-1111","비트캠프"]

    this.setTitle(values[0]); // 배열에 들어 있는 각 항목을 객체의 필드에 저장한다.
    this.setContent(values[1]);
    this.setViewCount(Integer.valueOf(values[2]));
    this.setCreatedDate(Date.valueOf(values[3]));
  }

  public static Board valueOf(String csvStr) {
    // 예) String csvStr => "홍길동,hong@test.com,010-1111-1111,비트캠프"

    String[] values = csvStr.split(","); // 예) ["홍길동","hong@test.com",010-1111-1111","비트캠프"]

    Board board = new Board();
    board.setTitle(values[0]); // 배열에 들어 있는 각 항목을 객체의 필드에 저장한다.
    board.setContent(values[1]);
    board.setViewCount(Integer.valueOf(values[2]));
    board.setCreatedDate(Date.valueOf(values[3]));

    return board;
  }

  public String toCsvString() {
    return String.format("%s,%s,%s,%s", 
        this.getTitle(),
        this.getContent(),
        this.getViewCount(),
        this.getCreatedDate());
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public java.sql.Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(java.sql.Date createdDate) {
    this.createdDate = createdDate;
  }

  @Override
  public String toString() {
    return "Board [title=" + title + ", content=" + content + ", viewCount=" + viewCount
        + ", createdDate=" + createdDate + "]";
  }
}
