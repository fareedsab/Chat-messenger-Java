
import java.awt.event.KeyEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Client extends javax.swing.JFrame {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String message="";
    private String serverIP;
    private Socket connection;
    private int port;
    private String ip;
    public boolean temp= true;
    
    
    public Client(String s) {
        
        initComponents();
        
        this.setTitle("Client");
        this.setVisible(true);
        status.setVisible(true);
        serverIP = s;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ipno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        portno = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg7.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(20, 100, 270, 30);

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(310, 100, 80, 30);

        chatArea.setColumns(20);
        chatArea.setRows(5);
        jScrollPane1.setViewportView(chatArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 170, 360, 210);

        jLabel2.setText("Write your text here");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 80, 150, 20);

        status.setText("...");
        jPanel1.add(status);
        status.setBounds(20, 130, 300, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("IPADDRESS");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 10, 70, 14);

        ipno.setText("192");
        ipno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ipnoKeyTyped(evt);
            }
        });
        jPanel1.add(ipno);
        ipno.setBounds(100, 10, 120, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Port");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 50, 27, 15);

        portno.setText("0");
        portno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                portnoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                portnoKeyTyped(evt);
            }
        });
        jPanel1.add(portno);
        portno.setBounds(100, 50, 120, 20);

        jButton2.setText("Connect");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(260, 23, 90, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(414, 428));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

        sendMessage(jTextField1.getText());
	jTextField1.setText("");
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       sendMessage(jTextField1.getText());
	jTextField1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ipnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ipnoKeyTyped
       
    }//GEN-LAST:event_ipnoKeyTyped

    private void portnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_portnoKeyTyped
      char c= evt.getKeyChar();
     if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE  ){
         evt.consume();
     }
    }//GEN-LAST:event_portnoKeyTyped

    private void portnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_portnoKeyPressed
       String port = portno.getText();
            int lenght1 = port.length();
            char c = evt.getKeyChar();
            if (evt.getKeyChar()>= '0' && evt.getKeyChar()<= '9'){
            if(lenght1<4){
                portno.setEditable(true);
            }
            else {
                portno.setEditable(false);
            }
            }
            else{
                if( evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE|| evt.getExtendedKeyCode()==KeyEvent.VK_DELETE )
                {portno.setEditable(true);}
                else{
                portno.setEditable(false);}
            }
    }//GEN-LAST:event_portnoKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        port= Integer.parseInt(portno.getText());
        ip=ipno.getText();
        System.out.println(ip);
        temp=false;
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public void startRunning()
    {
       try
       {
            status.setText("Attempting Connection ...");
            try
            {  while (temp==true)
            { status.setText("Not connected");
            }
            boolean help=true;
            
                connection = new Socket(InetAddress.getByName(ip),port);
            }catch(IOException ioEception)
            {
                    JOptionPane.showMessageDialog(null,"Server Might Be Down!","Warning",JOptionPane.WARNING_MESSAGE);
            }
            status.setText("Connected to: " + connection.getInetAddress().getHostName());


            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());

            whileChatting();
       }
       catch(IOException ioException)
       {
            ioException.printStackTrace();
       }
    }
    
    private void whileChatting() throws IOException
    {
      jTextField1.setEditable(true);
      do{
              try
              {
                      message = (String) input.readObject();
                      chatArea.append("\n"+message);
              }
              catch(ClassNotFoundException classNotFoundException)
              {
              }
      }while(!message.equals("Client - END"));
    }
  
    
    private void sendMessage(String message)
    {
        try
        {
            output.writeObject("Client - " + message);
            output.flush();
            chatArea.append("\nClient - "+message);
        }
        catch(IOException ioException)
        {
            chatArea.append("\n Unable to Send Message");
        }
    }
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chatArea;
    private javax.swing.JTextField ipno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField portno;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
