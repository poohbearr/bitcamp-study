package com.eomcs.mylist.domain;

public class Todo implements java.io.Serializable {
  String title;
  boolean done;

  public Todo() {
    System.out.println("Todo() 호출됨!!!");
  }

  public static Todo valueOf(String csvStr) {
    // 예) String csvStr => "홍길동,hong@test.com,010-1111-1111,비트캠프"

    String[] values = csvStr.split(","); // 예) ["홍길동","hong@test.com",010-1111-1111","비트캠프"]

    Todo todo = new Todo();
    todo.setTitle(values[0]); // 배열에 들어 있는 각 항목을 객체의 필드에 저장한다.
    todo.setDone(Boolean.valueOf(values[1]));

    return todo;
  }

  public String toCsvString() {
    return String.format("%s,%s", 
        this.getTitle(),
        this.isDone());
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public boolean isDone() {
    return done;
  }
  public void setDone(boolean done) {
    this.done = done;
  }
  @Override
  public String toString() {
    return "Todo [title=" + title + ", done=" + done + "]";
  }


}
