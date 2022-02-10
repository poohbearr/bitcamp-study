package com.eomcs.net.ex12.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ChatClient extends JFrame {
  private static final long serialVersionUID = 1L;

  JTextField addressTf = new JTextField(30);
  JTextField portTf = new JTextField(4);
  JTextArea messageListTa = new JTextArea();
  JTextField messageTf = new JTextField(35);
  JButton connectBtn = new JButton("연결");

  Socket socket;
  DataInputStream in;
  DataOutputStream out;
  String nickname;

  public ChatClient() {

    String title = "대화명을 입력하세요\n(2자 이상)";

    while (true) {
      nickname = JOptionPane.showInputDialog(title);
      if (nickname == null) {
        System.exit(0);
      } else if (nickname != null && nickname.length() >= 2) {
        break;
      }
      title = "대화명을 다시 입력하세요!\n(2자 이상)";
    }

    this.setTitle("채팅!! - " + nickname);

    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        if (connectBtn.getText().equals("종료")) { // 
          try {
            out.writeUTF("\\quit");
            out.flush();
          } catch (Exception ex) {

          }
        }
        try {in.close();} catch (Exception ex) {}
        try {out.close();} catch (Exception ex) {}
        try {socket.close();} catch (Exception ex) {}
        System.exit(0);
      }
    });
    this.setSize(500, 400);

    Container contentPane = this.getContentPane();

    JPanel topPanel = new JPanel();
    topPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 기본 레이아웃 관리자를 교체
    topPanel.add(addressTf);
    topPanel.add(portTf);

    // 1) 로컬 클래스
    //    class MyActionListener implements ActionListener {
    //      @Override
    //      public void actionPerformed(ActionEvent e) {
    //      }
    //    }
    //    connectBtn.addActionListener(new MyActionListener());

    // 2) 익명 클래스
    //    connectBtn.addActionListener(new ActionListener() {
    //      @Override
    //      public void actionPerformed(ActionEvent e) {
    //      }
    //    });

    // 3) 람다(lambda) 문법
    //    connectBtn.addActionListener(e -> System.out.println("연결 버튼 눌렀음!"));

    // 4) 메서드 레퍼런스
    connectBtn.addActionListener(this::connectChatServer);

    topPanel.add(connectBtn);
    contentPane.add(topPanel, BorderLayout.NORTH);

    JScrollPane scrollPane = new JScrollPane(messageListTa);
    contentPane.add(scrollPane, BorderLayout.CENTER);

    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 기본 레이아웃 관리자를 교체
    bottomPanel.add(messageTf);

    JButton sendBtn = new JButton("보내기");
    sendBtn.addActionListener(this::sendMessage);
    bottomPanel.add(sendBtn);

    contentPane.add(bottomPanel, BorderLayout.SOUTH);

    messageTf.addActionListener(this::sendMessage);


    this.setVisible(true);
  }

  public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    new ChatClient();

  }

  public void connectChatServer(ActionEvent e) {
    if (connectBtn.getText().equals("연결")) {
      try {
        socket = new Socket(addressTf.getText(), Integer.parseInt(portTf.getText()));

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        out.writeUTF(nickname);
        out.flush();

        new MessageReceiver(in).start();

      } catch (Exception ex) {
        JOptionPane.showMessageDialog(
            this, "서버에 연결 오류!", "통신 오류!", JOptionPane.ERROR_MESSAGE);
      }

      connectBtn.setText("종료");

    } else {
      try {
        out.writeUTF("\\quit");
        out.flush();
      } catch (Exception ex) {

      }
      connectBtn.setText("연결");
      messageListTa.setText("");
    }
  }

  public void sendMessage(ActionEvent e) {
    if (messageTf.getText().length() == 0) {
      return;
    }

    try {
      out.writeUTF(messageTf.getText());
      out.flush();
      messageTf.setText("");

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(
          this, "메시지 전송 오류!", "통신 오류!", JOptionPane.ERROR_MESSAGE);
    }
  }

  class MessageReceiver extends Thread {

    DataInputStream in;

    public MessageReceiver(DataInputStream in) {
      this.in = in;
    }
    @Override
    public void run() {
      while (true) {
        try {
          String message = in.readUTF();
          if (message.equals("<![QUIT[]]>")) { // 서버에서 연결을 끊겠다는 메시지가 오면 스레드를 종료한다.
            break; // 스레드 종료? run() 메서드의 실행을 마치면 스레드는 종료한다.
          }
          messageListTa.append(message + "\n");

        } catch (Exception e) {}
      }
    }
  }
}
