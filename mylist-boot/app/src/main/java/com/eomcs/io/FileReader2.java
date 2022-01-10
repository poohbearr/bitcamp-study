package com.eomcs.io;

import java.io.FileReader;

public class FileReader2 {

  FileReader in;

  public FileReader2(String filename) throws Exception {
    in = new FileReader(filename);
  }

  public String readLine() throws Exception {
    StringBuilder buf = new StringBuilder();
    int c;
    while ((c = in.read()) != -1) {// 파일에서 한 문자를 읽는다. 더이상 읽을 문자가 없으면 반복문을 종료하다.
      if (c == '\n') { // 만약 읽은 문자가 줄바꿈 명령이라면, 지금까지 읽은 CSV 데이터를 분석하여 Contact 객체에 담는다.
        return buf.toString();
      } else { // 문자를 읽을 때 마다 버퍼이 임시 보관한다.
        buf.append((char) c);
      }
    }
    return buf.toString();
  }

  public void close() throws Exception {
    in.close();
  }

}
