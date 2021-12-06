package com.eomcs.study.lang.variable;

//변수 : 메모리를 준비시키는 명령어

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam3") // 클래스 이름이 같은 경우 충돌 방지
@RequestMapping("/lang/variable/exam3")
public class Exam3 {


  // 스프링 부트는 클라이언트가 보낸 값을 파라미터 타입에 맞춰 자동 형변환을 수행한다.
  // => 웹 브라우저가 보내는 값은 무조건 "문자열"이다!

  // 1) "100" ==> byte
  // 테스트 URL : http://localhost:8080/lang/variable/exam3/test1?value=100
  @GetMapping("/test1")
  public String test1(byte value) {
    return "==> " + value;
  }

  @GetMapping("/test2")
  public String test2(short value) {
    return "==> " + value;
  }

  @GetMapping("/test3")
  public String test3(int value) {
    return "==> " + value;
  }


  @GetMapping("/test4")
  public String test4(long value) {
    return "==> " + value;
  }


  @GetMapping("/test5")
  public String test5(float value) {
    return "==> " + value;
  }


  @GetMapping("/test6")
  public String test6(double value) {
    return "==> " + value;
  }

  @GetMapping("/test7")
  public String test7(boolean value) {
    return "==> " + value;
  }

  @GetMapping("/test8")
  public String test8(char value) {
    return "==> " + value;
  }

  @GetMapping("/test9")
  public String test9(java.sql.Date value) {
    return "==> " + value;
  }


}







