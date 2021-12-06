// 리터럴: 문자열 리터럴과 escape character
package com.eomcs.study.lang.leteral;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lang/literal/exam6")
public class Exam6 {

  @GetMapping("/test1")
  public String test1() {
    return "012ABC가각간똘똠똡똥";
  }

  @GetMapping("/test2")
  public String test2() {
    //- 제어 문자
    //  \n - Line Feed(LF), 0x0a
    //  \r - Carrage Return(CR), 0x0d
    //  \f - Form Feed, 0x0c
    //  \t - Tab, 0x09
    //  \b - Backspace, 0x08
    //  \' - Single Quote, 0x27
    //  \" - Double Quote, 0x22
    //  \\ - Backslash, 0x5c
    return "012\nABC\n가각간\n똘똠똡똥";
  }

  @GetMapping("/test3")
  public String test3() {

    return "012\rABC\r가각간\r똘똠똡똥"; // 웹 브라우저에서 소용 없다.
  }

  @GetMapping("/test4")
  public String test4() {

    return "012\tABC\t가각간\t똘똠똡똥";
  }

  @GetMapping("/test5")
  public String test5() {

    return "012\bABC\b가각간\b똘똠똡똥"; // 웹 브라우저에서 소용 없다.
  }

  @GetMapping("/test6")
  public String test6() {

    return "012\\ABC\\가각간\\똘똠똡똥"; // 웹 브라우저에서 소용 없다.
  }
  @GetMapping("/test7")
  public String test7() {

    return "012\"바보\"똘똠똡똥"; // escape character \"\"
  }



}







