package chat;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatFrame extends javax.swing.JFrame implements ChatCallbackAdapter {
  /**
	 * 
	 */
  private static final long serialVersionUID = 1580673677145725871L;
  private Chat chat;

  /** Creates new form Chat */
  public ChatFrame() {
    initComponents();
    setVisible(true);
    setLocationRelativeTo(null);
    disableNewMessages();

    startChat();
  }

  /**
   * This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    MessagesScrollPane = new javax.swing.JScrollPane();
    MessagesTextArea = new javax.swing.JTextArea();
    NewMessageScrollPane = new javax.swing.JScrollPane();
    NewMessageTextArea = new javax.swing.JTextArea();
    SendButton = new javax.swing.JButton();
    OnlineUsersLabel = new javax.swing.JLabel();
    OnlineUsers = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Chat");

    MessagesTextArea.setColumns(20);
    MessagesTextArea.setEditable(false);
    MessagesTextArea.setRows(5);
    MessagesScrollPane.setViewportView(MessagesTextArea);

    NewMessageTextArea.setColumns(20);
    NewMessageTextArea.setRows(5);
    NewMessageScrollPane.setViewportView(NewMessageTextArea);

    SendButton.setText("Send");
    SendButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        SendButtonActionPerformed(evt);
      }
    });

    OnlineUsersLabel.setText("Online:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout
        .setHorizontalGroup(
            layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                    javax.swing.GroupLayout.Alignment.TRAILING,
                    layout
                        .createSequentialGroup()
                        .addContainerGap()
                        .addGroup(
                            layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(MessagesScrollPane,
                                    javax.swing.GroupLayout.Alignment.LEADING,
                                    javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                .addGroup(
                                    layout
                                        .createSequentialGroup()
                                        .addComponent(NewMessageScrollPane,
                                            javax.swing.GroupLayout.PREFERRED_SIZE, 295,
                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(
                                            javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SendButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                            75, Short.MAX_VALUE))
                                .addGroup(
                                    javax.swing.GroupLayout.Alignment.LEADING,
                                    layout
                                        .createSequentialGroup()
                                        .addComponent(OnlineUsersLabel)
                                        .addPreferredGap(
                                            javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(OnlineUsers,
                                            javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)))
                        .addContainerGap())
        );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OnlineUsersLabel)
                            .addComponent(OnlineUsers))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(MessagesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 192,
                        Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SendButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NewMessageScrollPane,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                    .addContainerGap())
        );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_SendButtonActionPerformed
    chat.sendMessage(NewMessageTextArea.getText());
    MessagesTextArea.append("Me: " + NewMessageTextArea.getText() + "\n");
    NewMessageTextArea.setText(null);
  }// GEN-LAST:event_SendButtonActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      @Override
      public void run() {
        new ChatFrame();
      }
    });
  }


  public void startChat() {
    MessagesTextArea.append("Connecting...");
    chat = new Chat(this);
    chat.start();
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JScrollPane MessagesScrollPane;
  private javax.swing.JTextArea MessagesTextArea;
  private javax.swing.JScrollPane NewMessageScrollPane;
  private javax.swing.JTextArea NewMessageTextArea;
  private javax.swing.JLabel OnlineUsers;
  private javax.swing.JLabel OnlineUsersLabel;
  private javax.swing.JButton SendButton;

  // End of variables declaration//GEN-END:variables

  public void disableNewMessages() {
    NewMessageTextArea.setEnabled(false);
    SendButton.setEnabled(false);
  }

  public void enableNewMessages() {
    NewMessageTextArea.setEnabled(true);
    SendButton.setEnabled(true);
  }

  @Override
  public void callback(JSONArray data) throws JSONException {}

  @Override
  public void on(String event, JSONObject obj) {
    try {
      if (event.equals("user message")) {
        MessagesTextArea.append(obj.getString("user") + ": " + obj.getString("message") + "\n");
      }

      else if (event.equals("announcement")) {
        MessagesTextArea.append(obj.getString("user") + " " + obj.getString("action") + "\n");
      }

      else if (event.equals("nicknames")) {
        JSONArray names = obj.names();
        String str = "";
        for (int i = 0; i < names.length(); i++) {
          if (i != 0)
            str += ", ";
          str += names.getString(i);
        }
        OnlineUsers.setText(str);
      }
    } catch (JSONException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public void onMessage(String message) {}

  @Override
  public void onMessage(JSONObject json) {}

  @Override
  public void onConnect() {
    MessagesTextArea.append("done!\n");
    enableNewMessages();

    String nickname = JOptionPane.showInputDialog(null, "Nickname", null, WIDTH);
    if (!nickname.isEmpty()) {
      chat.join(nickname);
      MessagesTextArea.append("You joined as " + nickname + "\n");
    }
  }

  @Override
  public void onDisconnect() {
    JOptionPane.showMessageDialog(null, "Connection lost", "Error", JOptionPane.ERROR_MESSAGE);
    disableNewMessages();
  }

  @Override
  public void onConnectFailure() {
    MessagesTextArea.append("error!\n");
  }

}
