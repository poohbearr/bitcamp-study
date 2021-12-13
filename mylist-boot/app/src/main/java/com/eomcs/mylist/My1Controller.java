package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class My1Controller {
  String[] memberLists = new String[5];
  int size = 0;

  @RequestMapping("/my1/list")
  public Object list() {
    String[] memberList = new String[size];
    for (int i = 0; i < size; i++) {
      memberList[i] = memberLists[i];
    }
    return memberList;
  }

  @RequestMapping("/my1/add")
  public Object add(String name, String idNum, String age, String email, String address) {
    String memberList = name + "," + idNum + "," + age + "," + address + "," + email;
    memberLists[size++] = memberList;
    return size;
  }

  @RequestMapping("my1/get")
  public Object get(String idNum) {
    for (int i = 0; i < size; i++) {
      if (memberLists[i].split(",")[1].equals(idNum))
        return memberLists[i];
    }
    return "";
  }

}
