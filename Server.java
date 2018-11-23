/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package distributedserver;

import com.googlecode.javacv.cpp.opencv_core;
import static com.googlecode.javacv.cpp.opencv_core.CV_AA;
import com.googlecode.javacv.cpp.opencv_core.CvMemStorage;
import static com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_8U;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_core.cvCopy;
import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSeqElem;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSize;
import static com.googlecode.javacv.cpp.opencv_core.cvLoad;
import static com.googlecode.javacv.cpp.opencv_core.cvPoint;
import static com.googlecode.javacv.cpp.opencv_core.cvRectangle;
import static com.googlecode.javacv.cpp.opencv_core.cvSetImageROI;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2GRAY;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvResize;
import com.googlecode.javacv.cpp.opencv_objdetect;
import static com.googlecode.javacv.cpp.opencv_objdetect.cvHaarDetectObjects;
import static distributedserver.Server.clicked;
import static distributedserver.Server.count;
import static distributedserver.Server.flag;
import static distributedserver.Server.fname;
import static distributedserver.Server.getdata;
import static distributedserver.Server.h;
import static distributedserver.Server.info;
import static distributedserver.Server.information;
import static distributedserver.Server.jPanel1;
import static distributedserver.Server.jTable1;
import static distributedserver.Server.jTable2;

import static distributedserver.Server.pix;
import static distributedserver.Server.pixels;
import static distributedserver.Server.recounter;
import static distributedserver.Server.request;
import static distributedserver.Server.soc;
import static distributedserver.Server.z;
import static distributedserver.Server.erasedata;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aditya
 */


public class Server extends javax.swing.JFrame{

    String[] columns = {"Client Address","Port","Start Time","Close Time","Image Recognition"};
    Boolean session=false;
    String port;
    static int pixels[][];
    static ArrayList pix;
    public static Boolean connect=false;
    public static ArrayList arr = new ArrayList();
    public static Boolean flag = false;
    public static int count=0;
    public static ArrayList<String> fname = new ArrayList<String>();
    
    public static Boolean Accept = false;
    public static Boolean Reject = false;
    static public String info="";
    static public int z;
    public static ArrayList<String> information = new ArrayList<String>();
     public static Boolean request=true;
    public static Socket soc[];
    public static int h=0;
    public static int recounter=0;
    public static int req=0;
    public static Boolean clicked=true;
   
    /**
     * Creates new form Server
     */
    public Server() {
        initComponents();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.CardLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client Address", "Port", "Start Time", "Close Time", "Image Recognition", "Information", "ImageDatabase"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, "card2");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client", "Image", "Information", "Accept", "Reject"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, "card3");

        jMenu1.setText("Preferences");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Connect");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Pending Request");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Go To");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Add Item");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setText("Session Manager");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Pending Requests ");
        jMenu4.setAlignmentX(100.0F);
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        
        try {
             soc=new Socket[10];
            socket s = new socket(8888);
            JOptionPane.showMessageDialog(null, "Connectin Established");
            s.start();
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, "Connection Refused");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        String ip = "192.168.0.100";
        int port = 9999;
        String ss = String.valueOf(ZonedDateTime.now());
        String et = "2:27:30PM";
        Boolean bool = true;
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{ip,port,ss,et,bool,"Bhalu","33"});
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
        
     JPanel panel = new JPanel(new BorderLayout(5, 5));
    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
    label.add(new JLabel("Username", SwingConstants.RIGHT));
    label.add(new JLabel("Password", SwingConstants.RIGHT));
    panel.add(label, BorderLayout.WEST);

    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
    JTextField username = new JTextField();
    controls.add(username);
    JPasswordField password = new JPasswordField();
    controls.add(password);
    panel.add(controls, BorderLayout.CENTER);

    JOptionPane.showMessageDialog(rootPane, panel, "login", JOptionPane.QUESTION_MESSAGE);
        
        if(username.getText().equals("1") && password.getText().equals("1"))
        {
            JOptionPane.showMessageDialog(rootPane, "Session Initiated");
            jScrollPane1.setVisible(false);
            jScrollPane2.setVisible(true);
            session = true;
            if(request)
            {
                getdata("List.txt");
                request = false;
            }
            int k=0;
            
            String in="";
                
                if(clicked)
                {
                clicked=false;
                
                    
                    
                    
                    File ff = new File("List.txt");
             try(BufferedReader br1 = new BufferedReader(new FileReader(ff)))
             {
            String line1 = br1.readLine();
            while(line1!=null){
                
                new Thread(new iterate(k)).start();
                k++;
                line1=br1.readLine();
                //Thread.sleep(6000);
            }
        }catch(Exception e){
            
        }
                    
                  
                }
            
            
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Session Aborted");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
      if(session)
      {
        jScrollPane2.setVisible(false);
        JOptionPane.showMessageDialog(rootPane, "Session Closed!");
        jScrollPane1.setVisible(true);
        session = false;
      }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu jMenu1;
    public static javax.swing.JMenu jMenu2;
    public static javax.swing.JMenu jMenu4;
    public static javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JMenuItem jMenuItem2;
    public static javax.swing.JMenuItem jMenuItem3;
    public static javax.swing.JMenuItem jMenuItem4;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

  
        public static void getdata(String filename){
             File fff = new File(filename);
        try(BufferedReader br = new BufferedReader(new FileReader(fff)))
        {
            String line = br.readLine();
            while(line!=null){
                  fname.add(line);
                  
                line = br.readLine();
            }
        }catch(Exception e)
        {
            System.out.println("File cannot be opened");
        }
        }
        
        public static void erasedata(String filename,int pos) throws FileNotFoundException, IOException
        {
            
            File inputFile = new File(filename);
            File tempFile = new File(filename);

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = fname.get(pos);
            JOptionPane.showMessageDialog(null, lineToRemove);
            fname.remove(pos);
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
    // trim newline when comparing with lineToRemove
                 
                 if(currentLine.equals(lineToRemove)) continue;
                 writer.write(currentLine);
            }
            writer.close(); 
            reader.close(); 
            tempFile.renameTo(inputFile);
        }
}

class socket extends Thread{
    
    private ServerSocket serversocket;
    Socket s;
    int l;
    DataInputStream din;
    public socket(int port) throws IOException
    {
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //model.addRow(new Object[]{"192.168.0.1",port,"5:31:00PM","5:31:50PM",false,"-","33"});
        
        serversocket = new ServerSocket(port);
        l=port;
       
    }
    public void run()
    {
    while(true)
    {
    try { 
         s = serversocket.accept();
         din=new DataInputStream((s.getInputStream()));
         int a = din.read();
                
                if(a==1){
                    soc[h]=s;
                    h++;
                    (new Thread(new node(s))).start();
                    
                }
            else
                {
                    
                 new Thread(new client(s)).start();
                   
                   
                   
                }
        
    } catch (IOException ex) {
        //Logger.getLogger(socket.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    }
    
}
class iterate extends Thread{
        String in="";
        int kkk;
        public iterate(int k){
            kkk=k;
            
        }
        public void run(){
        
          int aaa=kkk;
            DefaultTableModel model;
                    model = (DefaultTableModel) jTable2.getModel();
          
                File fff = new File(fname.get(aaa)+".txt");
                  try {
                BufferedReader br = new BufferedReader(new FileReader(fff));
                 String line;
          
                line = br.readLine();
            
                 while(line!=null){
                in=in+line;
                line=br.readLine();
                 }
                 } catch (IOException ex) {
                Logger.getLogger(socket.class.getName()).log(Level.SEVERE, null, ex);
            }
                    Action accept = new AbstractAction()
{                   
    public void actionPerformed(ActionEvent e)
    {
        try {
            DataInputStream din = new DataInputStream(soc[recounter%h].getInputStream());
            DataOutputStream dos = new DataOutputStream(soc[recounter%h].getOutputStream());
             int modelRow = Integer.valueOf( e.getActionCommand() );
        ((DefaultTableModel)jTable2.getModel()).removeRow(modelRow);
                                
                                dos.write(2);
                                /////////////////////////
                                File f=new File(fname.get(modelRow)+"crop.jpeg");
                                FileInputStream fis = new FileInputStream(f);
          byte[] buffer = new byte[fis.available()];
          fis.read(buffer);
          ObjectOutputStream oos = new ObjectOutputStream(soc[recounter%h].getOutputStream()) ;
          
         oos.writeObject(buffer);
         File fff = new File(fname.get(modelRow)+".txt");
         BufferedReader br1 = new BufferedReader(new FileReader(fff));
                 String line;
          
                line = br1.readLine();
            
                 while(line!=null){
                in=in+line;
                line=br1.readLine();
                 }
         dos.writeUTF(in);
         
         recounter++;
                             /////////////////////
                                erasedata("List.txt",modelRow);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
                                
    }
};
  
                    Action reject = new AbstractAction()
{
    public void actionPerformed(ActionEvent e)
    {
                       // JOptionPane.showMessageDialog(null, aaa);
        try {
            int modelRow = Integer.valueOf( e.getActionCommand() );
        ((DefaultTableModel)jTable2.getModel()).removeRow(modelRow); 
            //model.removeRow(aaa);
           
            erasedata("List.txt",modelRow);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    };
                    Action show = new AbstractAction()
{
    public void actionPerformed(ActionEvent e)
    {
                        int modelRow = Integer.valueOf( e.getActionCommand() );
                           ImageIcon icon = new ImageIcon( fname.get(modelRow)+".jpeg");
        JDialog dialog = new JDialog();
dialog.setUndecorated(true);
JLabel label = new JLabel( icon );
dialog.add( label );
dialog.pack();
dialog.setVisible(true);
dialog.setLocation(200, 200);

    }
    };
                    ButtonColumn showimg = new ButtonColumn(jTable2, show, 1);
                    showimg.setMnemonic(KeyEvent.VK_D);
                    ButtonColumn buttonColumn = new ButtonColumn(jTable2, accept, 3);
                    buttonColumn.setMnemonic(KeyEvent.VK_D);
                    ButtonColumn buttonColumn2 = new ButtonColumn(jTable2, reject, 4);
                    buttonColumn.setMnemonic(KeyEvent.VK_E);
                    model.addRow(new Object[]{"1","Show image",in,"Accept","Reject"});
                    in="";
                    
                      
        }
    }
class node extends Thread
{
    Socket t;
    DataInputStream din;
    DataOutputStream dos;
    Calendar cal = Calendar.getInstance();
    DefaultTableModel model;
    int l;
    public node(Socket m)
    {
        t=m;
    }

    node() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void run()
    {
      while(true)
      {
          try {
              if(flag)
              {
              count++;
              model = (DefaultTableModel) jTable1.getModel();
              model.addRow(new Object[]{t.getLocalAddress().toString(),t.getPort(),cal.getTime().toString(),"-",false,"-",count});
              l = model.getRowCount();
              
              dos = new DataOutputStream(t.getOutputStream());
              din = new DataInputStream(t.getInputStream());
              dos.write(1);
              for(int i=0;i<10000;i++){
                  dos.write((int) pix.get(i));
              }
              
              Calendar cal1=Calendar.getInstance();
              model.setValueAt(cal1.getTime(), l-1, 3);
              z=din.read();
              //JOptionPane.showMessageDialog(null, z);
              if(z==3){
                  model.setValueAt(true, l-1, 4);
                  info=info+din.readUTF();
                  model.setValueAt(info, l-1, 5);
              }
              else{
                  info="ak";
              }
             
              flag=false;
              }
              else
              {
                Thread.sleep(500);
              }
              
          } catch (IOException ex) {
              //Logger.getLogger(node.class.getName()).log(Level.SEVERE, null, ex);
              model.setValueAt(cal.getTime(), l-1, 4);
              
          } catch (InterruptedException ex) {
              Logger.getLogger(node.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    }
}

class client extends Thread
{
    Socket t;
    DataInputStream din;
    DataOutputStream dos;
    int time;
    public client(Socket m)
    {
        t=m;
    }
    
    public void run()
    {
      
          try {
              while(t.isConnected()){
                    
                    din = new DataInputStream(t.getInputStream());
                    //BufferedImage img=ImageIO.read(ImageIO.createImageInputStream(t.getInputStream()));
                   /*File f=new File("ak.jpg");
                   int k=din.read();
                   byte[] fc=new byte[k];
                   din.readFully(fc);
                   BufferedImage img = ImageIO.read(new ByteArrayInputStream(fc));
                   File imageFile = new File("ak.jpg");
                   ImageIO.write(img, "jpg", imageFile);
                          */
                    Calendar cal = Calendar.getInstance();
        ObjectInputStream ois = new ObjectInputStream(t.getInputStream());
        byte[] buffer = (byte[])ois.readObject();
        FileOutputStream fos = new FileOutputStream("downloaded");
        fos.write(buffer);
        byte[] image = buffer;
        time=(int) cal.getTimeInMillis();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream in = new ByteArrayInputStream(buffer);
	BufferedImage bufferedImage = ImageIO.read(in);
        ImageIO.write(bufferedImage,"jpeg",new File(time+".jpeg"));
       
        
        ///////////////////////////////////////////////////////
        File filename = new File("List.txt");
        if(!filename.exists())
        {
            filename.createNewFile();
            
        }
        if(request)
        {
            getdata(filename.getPath());
            request=false;
        }
      
        File file=new File(time+".jpeg");
        System.out.println(file.getAbsolutePath());
        final String CASCADE_FILE = "haarcascade_frontalface_alt.xml";
        
        IplImage originalImage=cvLoadImage(file.getAbsolutePath(), 1);
                                                
         System.out.println("1");
        IplImage grayImage = IplImage.create(originalImage.width(),originalImage.height(), IPL_DEPTH_8U, 1);  
        System.out.println("2");
        cvCvtColor(originalImage, grayImage, CV_BGR2GRAY);  
    
        CvMemStorage storage = CvMemStorage.create();  
        System.out.println("4");
        opencv_objdetect.CvHaarClassifierCascade cascade = new opencv_objdetect.CvHaarClassifierCascade(cvLoad(CASCADE_FILE));
        System.out.println("3");
        opencv_core.CvSeq faces = cvHaarDetectObjects(grayImage, cascade, storage, 1.1, 1, 0);
        System.out.println("5");
     for (int i = 0; i < faces.total(); i++) {  
       opencv_core.CvRect r = new opencv_core.CvRect(cvGetSeqElem(faces, i));  
       cvRectangle(originalImage, cvPoint(r.x(), r.y()), cvPoint(r.x() + r.width(), r.y() + r.height()), opencv_core.CvScalar.BLUE, 5, CV_AA, 0);  
       opencv_core.CvRect r1 = new opencv_core.CvRect(r.x(), r.y(), r.width(), r.height());
        cvSetImageROI(originalImage, r1);
           opencv_core.IplImage cropped = cvCreateImage(cvGetSize(originalImage), originalImage.depth(), originalImage.nChannels());
           cvCopy(originalImage, cropped);
           opencv_core.IplImage resize=opencv_core.IplImage.create(100, 100, originalImage.depth(), originalImage.nChannels());
           cvResize(originalImage,resize);
           cvSaveImage(time+"crop.jpeg", resize);  

     }
                        /////////////////////////////////////////////////////////////
                        file=new File(time+"crop.jpeg");
			if(file!=null){
			BufferedImage img;
			try {
				img = ImageIO.read(file);
			
		    Raster raster=img.getData();
		    SampleModel sampleModel = raster.getSampleModel();
		    int w=raster.getWidth(),h=raster.getHeight();
		    pixels =new int[w][h];
		    for (int x=0;x<w;x++)
		    {
		        for(int y=0;y<h;y++)
		        {
		            pixels[x][y]=raster.getSample(x,y,0);
		        }
		    }
		    //scale down to 100x100
                    /*BufferedImage resizedImage = new BufferedImage(100, 100, img.getType());
                    int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
                    Buffere0dImage resizeImageJpg = resizeImage(originalImage, type);
		ImageIO.write(resizeImageJpg, "jpg", new File("c:\\image\\mkyong_jpg.jpg")); 
		    
			Graphics2D g1 = resizedImage.createGraphics();
			g1.drawImage(img, 0, 0, 100, 100, null);
                    */    
		    int width = img.getWidth();
		    int height = img.getHeight();

                    
                    
//convert to grayscale
                    pix=new ArrayList();
                    pix.clear();
		    for(int y = 0; y < height; y++){
		      for(int x = 0; x < width; x++){
		        int p = img.getRGB(x,y);

		        int a = (p>>24)&0xff;
		        int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;

		        //calculate average
		        int avg = (r+g+b)/3;

		        //replace RGB value with avg
		        p = (a<<24) | (avg<<16) | (avg<<8) | avg;

		        pix.add(avg);
                       
		      }
		    }
                    flag = true;
                    while(info.equals("")){
                        Thread.sleep(100);
                    }
                    dos=new DataOutputStream(t.getOutputStream());
                    dos.write(z);
                    if(z==3){
                    dos.writeUTF(info);
                    }
                    else{
                     fname.add(time+"");
                     FileWriter fw = new FileWriter(filename.getAbsoluteFile(),true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     bw.newLine();
                     bw.append(time+"");
                     bw.close();
                    }
                    info="";
                    z=0;
                   int r = din.read();
              if(r == 3)
              { 
                  String info = din.readUTF();
                  information.add(info);
                    File filen = new File(time+".txt");
                    if(!filen.exists())
                    {
                    filen.createNewFile();
            
                    }
                    FileWriter fw1 = new FileWriter(filen.getAbsoluteFile());
                    
                    BufferedWriter bw1 = new BufferedWriter(fw1);
                    bw1.newLine();
                    bw1.write(info);
                    bw1.close();
              }
                    System.out.print(pix);
                            
          } catch (IOException ex) {
              JOptionPane.showMessageDialog(null, ex);
              Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
          }             catch (InterruptedException ex) {
                            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
                        }
      
    }
              }
}       catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
