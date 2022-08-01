import java.awt.event.KeyEvent;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer extends javax.swing.JFrame {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket connection;
    private ServerSocket server;
    private int totalClients = 100;
    private int port=1234;
    public boolean temp = true;
  
    public MainServer() {
        
        initComponents();
        this.setTitle("Server");
        this.setVisible(true);
        status.setVisible(true);
    }
    
    public void startRunning()
    { 
        try
        { while (temp==true)
        { status.setText("Waiting for port no");
        }
            server=new ServerSocket(port);
            while(true)
            {
                try
                {
                    status.setText(" Waiting for Someone to Connect...");
                    connection=server.accept();
                    status.setText(" Now Connected  ");


                    output = new ObjectOutputStream(connection.getOutputStream());
                    output.flush();
                    input = new ObjectInputStream(connection.getInputStream());

                    whileChatting();

                }catch(EOFException eofException)
                {
                }
            }
        }
        catch(IOException ioException)
        {
                ioException.printStackTrace();
        }
    }
    
   private void whileChatting() throws IOException
   {
        String message="";    
        jTextField1.setEditable(true);
        do{
                try
                {
                        message = (String) input.readObject();
                        chatArea.append("\n"+message);
                }catch(ClassNotFoundException classNotFoundException)
                {
                        
                }
        }while(!message.equals("Client - END"));
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        portno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        chatArea.setColumns(20);
        chatArea.setRows(5);
        jScrollPane1.setViewportView(chatArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 110, 360, 270);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(30, 60, 270, 30);

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(310, 60, 80, 30);

        status.setText("...");
        jPanel1.add(status);
        status.setBounds(30, 80, 300, 40);

        jLabel2.setBackground(new java.awt.Color(51, 0, 51));
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Write your text here");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 40, 150, 20);

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
        portno.setBounds(100, 10, 70, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Port");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 10, 26, 17);

        jButton2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton2.setText("Start Listening");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(190, 10, 130, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(417, 425));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        sendMessage(jTextField1.getText());
	jTextField1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
        sendMessage(jTextField1.getText());
	jTextField1.setText("");
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            }        // TODO add your handling code here:
    }//GEN-LAST:event_portnoKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        port= Integer.parseInt(portno.getText());
        temp = false;
        System.out.println(port);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void sendMessage(String message)
    {
        try
        {
            output.writeObject("Server - " + message);
            output.flush();
            chatArea.append("\nServer - "+message);
        }
        catch(IOException ioException)
        {
            chatArea.append("\n Unable to Send Message");
        }
    }
    

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chatArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField portno;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
