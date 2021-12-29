package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ContactController {
  
  // Contact 객체 목록을 저장할 메모리 준비
  // => Object[] list = new Object[5];
  // => int size = 0;
  ArrayList contacts = new ArrayList();

  @RequestMapping("/contact/list")
  public Object list() {
    return ArrayList.toArray(contacts); 
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) {
    //    System.out.println(contact);
    ArrayList.add(contacts, contact);
    return contacts.size;
  }


  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }

    return contacts.list[index];
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.email);
    if (index == -1) {
      return 0;
    }

    return ArrayList.set(contacts, index, contact) == null ? 0 : 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }

    ArrayList.remove(contacts, index);
    return 1;
  }

  // 기능:
  // - 이메일로 연락처 정보를 찾는다.
  // - 찾은 연락처의 배열 인덱스를 리턴한다.
  //
  int indexOf(String email) {
    for (int i = 0; i < contacts.size; i++) {
      Contact contact = (Contact) contacts.list[i];
      if (contact.email.equals(email)) { 
        return i;
      }
    }
    return -1;
  }
}




