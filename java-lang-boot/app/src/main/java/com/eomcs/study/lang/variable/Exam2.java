// 배열 : 같은 종류의 메모리를 여러 개 만드는 명령문
package com.eomcs.study.lang.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam2") // 클래스 이름이 같은 경우 충돌 방지
@RequestMapping("/lang/variable/exam2")
public class Exam2 {

  //여러 개의 값을 받는 방법
  //=> http://localhost:8080/lang/variable/exam2/test1?name1=%ED%99%8D%EA%B8%B8%EB%8F%99&name2=%EC%9E%84%EA%BA%BD%EC%A0%95&name3=%EC%9C%A0%EA%B4%80%EC%88%9C&name4=%EC%95%88%EC%A4%91%EA%B7%BC&name5=%EC%9C%A4%EB%B4%89%EA%B8%B8&name6=%EA%B9%80%EA%B5%AC&name7=%ED%99%8D%EB%B2%94%EB%8F%84
  @GetMapping("/test1")
  public String test1(String name1, String name2, String name3, String name4, String name5, String name6, String name7) {
    return "=> " + name1 + ", " + name2 + ", " + name3 + ", " + name4 + ", " + name5 + ", " + name6 + ", " + name7;
  }

  //여러 개의 값을 받는 방법 : 배열 사용 후
  //=> 배열 메모리에 값을 넘길 때는 같은 파라미터 이름을 사용해야 한다.
  //=> http://localhost:8080/lang/variable/exam2/test1?name1=%ED%99%8D%EA%B8%B8%EB%8F%99&name2=%EC%9E%84%EA%BA%BD%EC%A0%95&name3=%EC%9C%A0%EA%B4%80%EC%88%9C&name4=%EC%95%88%EC%A4%91%EA%B7%BC&name5=%EC%9C%A4%EB%B4%89%EA%B8%B8&name6=%EA%B9%80%EA%B5%AC&name7=%ED%99%8D%EB%B2%94%EB%8F%84
  @GetMapping("/test2")
  public String test2(String[] name) {
    return "=> " + name[0] + ", " + name[1] + ", " + name[2] + ", " + name[3] + ", " + name[4] + ", " + name[5] + ", " + name[6];
  }

}







