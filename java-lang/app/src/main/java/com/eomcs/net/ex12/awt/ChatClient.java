package com.eomcs.net.ex12.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient extends Frame {
  private static final long serialVersionUID = 1L;

  public ChatClient() {
    super("채팅");
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        // 윈도우의 x 버튼을 눌렀을 때
        System.exit(0);
      }
    });
    this.setSize(400, 300);

    Panel topPanel = new Panel();
    topPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 기본 레이아웃 관리자를 교체

    TextField addressTf = new TextField(30);
    topPanel.add(addressTf);

    TextField portTf = new TextField(4);
    topPanel.add(portTf);

    Button ConnectBtn = new Button("연결");
    topPanel.add(ConnectBtn);

    add(topPanel, BorderLayout.NORTH);

    TextArea messageListTa = new TextArea();
    add(messageListTa, BorderLayout.CENTER);

    Panel bottomPanel = new Panel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 기본 레이아웃 관리자를 교체

    TextField messageTf = new TextField(40);
    bottomPanel.add(messageTf);

    Button sendBtn = new Button("보내기");
    bottomPanel.add(sendBtn);

    add(bottomPanel, BorderLayout.SOUTH);

    this.setVisible(true);
  }

  public static void main(String[] args) {

    new ChatClient();

  }
}
