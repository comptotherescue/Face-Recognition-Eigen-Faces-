
import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.VideoInputFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;
import static com.googlecode.javacv.cpp.opencv_core.CV_AA;
import static com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_8U;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_core.cvCopy;
import static com.googlecode.javacv.cpp.opencv_core.cvCopy;
import static com.googlecode.javacv.cpp.opencv_core.cvCopy;
import static com.googlecode.javacv.cpp.opencv_core.cvCopy;
import static com.googlecode.javacv.cpp.opencv_core.cvCopy;
import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSeqElem;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSize;
import static com.googlecode.javacv.cpp.opencv_core.cvLoad;
import static com.googlecode.javacv.cpp.opencv_core.cvPoint;
import static com.googlecode.javacv.cpp.opencv_core.cvRectangle;
import static com.googlecode.javacv.cpp.opencv_core.cvSetImageROI;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2GRAY;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvResize;
import com.googlecode.javacv.cpp.opencv_objdetect;
import static com.googlecode.javacv.cpp.opencv_objdetect.cvHaarDetectObjects;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aditya
 */
public class Insert1 extends javax.swing.JFrame {

    private JFrame frame;
	MongoClient con;
	int[] a=new int[10001];
    /**
     * Creates new form Insert1
     */
    public Insert1() {
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Remove Existing Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Insert Image");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("Calculate Weight Vector");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Recognize Image");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton3.setText("Look at an image");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(35, 35, 35)
                .addComponent(jButton5)
                .addGap(34, 34, 34)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
					con=new MongoClient("localhost",27017);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				DB db=con.getDB("image");
				DBCollection col;
				if(db.collectionExists("no")){
				col=db.getCollection("no");
				col.drop();
				}
				if(db.collectionExists("SOI")){
					col=db.getCollection("SOI");
					col.drop();
					}
                                if(db.collectionExists("SOI_MEAN")){
					col=db.getCollection("SOI_MEAN");
					col.drop();
					}
				if(db.collectionExists("mean")){
					col=db.getCollection("mean");
					col.drop();
					}
				if(db.collectionExists("Teigen")){
					col=db.getCollection("Teigen");
					col.drop();
					}
				if(db.collectionExists("wt")){
					col=db.getCollection("wt");
					col.drop();
					}
				JOptionPane.showMessageDialog(null, "Existing Data removed!!","Data Removed",JOptionPane.INFORMATION_MESSAGE);
				con.close();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int number,flag=0;
         
			ArrayList pix=new ArrayList();
			BasicDBObject obj1 = null,obj2=null;
			File file = null;
			int[][] pixels = null;
			try {
				con=new MongoClient("localhost",27017);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DB db=con.getDB("image");
			DBCollection col=db.getCollection("no");
			DBObject obj=col.findOne();
			if(obj==null){
				number=1;
				obj1=new BasicDBObject("number", number);
				flag=1;
			}
			else{
				number=(int) obj.get("number");
				number+=1;
				obj2=new BasicDBObject("number",number);
			}
                        String[] options = new String[] {"take pic", "existing pic"};
                        int response = JOptionPane.showOptionDialog(null, "Enter the mode of insertion", "How to insert",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
                        System.out.println(response);
                        if(response==1){
			JFileChooser filename = new JFileChooser("F:\\BE\\Project\\faces94\\male");
			int returnval = filename.showOpenDialog(frame);
			if(returnval == JFileChooser.APPROVE_OPTION )
			{
				file = filename.getSelectedFile();
			
			}
                        }
                        else{
                            IplImage image;
    CanvasFrame canvas = new CanvasFrame("Web Cam");
    canvas.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    FrameGrabber grabber = new VideoInputFrameGrabber(0); // 1 for next camera
        //int i=0;
        try {
            JOptionPane.showMessageDialog(null, "Get Ready");
            grabber.start();
            IplImage img;
               
                img = grabber.grab();
                if (img != null) {
                   cvSaveImage("ak"+number+".jpeg", img);
                    // show image on window
                    canvas.showImage(img);
                    grabber.release();
                }
                file=new File("ak"+number+".jpeg");
                 //Thread.sleep(INTERVAL);
        
        } catch (Exception e) {
        }
                        }
                        /////////////////////////////////////////////////////////////
                        final String CASCADE_FILE = "haarcascade_frontalface_alt.xml";
                        IplImage originalImage=cvLoadImage(file.getAbsolutePath(), 1);
                 IplImage grayImage = IplImage.create(originalImage.width(),originalImage.height(), IPL_DEPTH_8U, 1);  
     cvCvtColor(originalImage, grayImage, CV_BGR2GRAY);  
    
     opencv_core.CvMemStorage storage = opencv_core.CvMemStorage.create();  
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
           IplImage cropped = cvCreateImage(cvGetSize(originalImage), originalImage.depth(), originalImage.nChannels());
           cvCopy(originalImage, cropped);
           IplImage resize=IplImage.create(100, 100, originalImage.depth(), originalImage.nChannels());
           cvResize(originalImage,resize);
           cvSaveImage("ak"+number+".jpeg", resize);  

     }
                        /////////////////////////////////////////////////////////////
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
                    BufferedImage resizeImageJpg = resizeImage(originalImage, type);
		ImageIO.write(resizeImageJpg, "jpg", new File("c:\\image\\mkyong_jpg.jpg")); 
		    
			Graphics2D g1 = resizedImage.createGraphics();
			g1.drawImage(img, 0, 0, 100, 100, null);
                    */    
		    int width = img.getWidth();
		    int height = img.getHeight();

                    
                    
//convert to grayscale
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
                    System.out.println(pix.size()); 
		    String mes=JOptionPane.showInputDialog("\nEnter the information of this iImage", "NULL");
		    DBCollection col2=db.getCollection("SOI");
		    BasicDBObject obj3=new BasicDBObject("num", number).append("image", pix).append("info", mes);
		    col2.insert(obj3);
		    if(flag==1){
		    col.insert(obj1);
		    }else{
		    	col.update(obj,obj2);
		    }
		    con.close();
		    JOptionPane.showMessageDialog(null, "Image Inserted Successfully!!","Success",JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else
			{
			JOptionPane.showMessageDialog(null, "Select the file!!","File not selected",JOptionPane.ERROR_MESSAGE);	
			}
                        
                        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //mean
                              try {
					 con=new MongoClient("localhost",27017);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int i;
				DB db=con.getDB("image");
				DBCollection col=db.getCollection("no");
				DBCollection col1=db.getCollection("SOI");
				DBObject obj=col.findOne();
				int num=(int) obj.get("number");
				
				
				ArrayList b;
				
				
				for(i=0;i<10000;i++){
					a[i]=0;
                                        
				}
				
				DBCursor cur=col1.find();
				do{
					
				 DBObject ob=cur.next();
                                 ArrayList a1;
				 a1=(ArrayList) ob.get("image");
				
				 i=0;
                                  System.out.println("hello");
				 while(i<10000){
					 a[i]+=(int)a1.get(i);
					
					 i++;
				 }
                                
				 a1.clear();
				}while(cur.hasNext());
				for(i=0;i<10000;i++){
				
					a[i]=a[i]/num;
					
				}
				//save the mean in database
				DBCollection mean=db.getCollection("mean");
				mean.drop();
				mean=db.getCollection("mean");
				ArrayList m=new ArrayList();
				for(i=0;i<10000;i++){
					m.add(a[i]);
				}
				BasicDBObject o=new BasicDBObject("mean",m);
				mean.insert(o);
				
				DBCursor cur1=col1.find();
				ArrayList c=new ArrayList();
                                   DBCollection colm=db.getCollection("SOI_MEAN");
                                   colm.drop();
				while(cur1.hasNext()){
					int j=0;
					c.clear();
					DBObject ob1=cur1.next();
					int n=(int) ob1.get("num");
					b=(ArrayList) ob1.get("image");
					
					while(j<10000){
					int x=(int) b.get(j);
					x=x-a[j];
					c.add(x);
					
					j++;
					}
					String msg=(String) ob1.get("info");
					BasicDBObject ob2=new BasicDBObject("num",n).append("image", c).append("info", msg);
					colm.insert(ob2);
					b.clear();
				}
				con.close();
				
			   covariance c1=new covariance();
                           weight w=new weight();
                           JOptionPane.showMessageDialog(null, "Weights calculated successfully");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        MongoClient conn;
				try {
					con=new MongoClient("localhost",27017);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				File file=null;
				ArrayList pix=new ArrayList();
				int[] img1=new int[10000];
				JFileChooser filename = new JFileChooser("F:\\BE\\Project\\project\\Eigenfaceinsert");
				
				int returnval = filename.showOpenDialog(frame);
				if(returnval == JFileChooser.APPROVE_OPTION )
				{
					file = filename.getSelectedFile();
				
				}
				if(file!=null){
					BufferedImage img;
					try {
						//display image
						BufferedImage img_1=ImageIO.read(file);
			            ImageIcon icon=new ImageIcon(img_1);
			            JFrame frame=new JFrame();
			            frame.getContentPane().setLayout(new FlowLayout());
			            frame.setSize(200,300);
			            JLabel lbl=new JLabel();
			            lbl.setIcon(icon);
			            frame.getContentPane().add(lbl);
			            frame.setVisible(true);
			            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						img = ImageIO.read(file);
					
				    Raster raster=img.getData();
				    SampleModel sampleModel = raster.getSampleModel();
				    int w=raster.getWidth(),h=raster.getHeight();
				    int[][] pixels =new int[w][h];
				    for (int x=0;x<w;x++)
				    {
				        for(int y=0;y<h;y++)
				        {
				            pixels[x][y]=raster.getSample(x,y,0);
				        }
				    }
				    //scale down to 100x100
				    BufferedImage resizedImage = new BufferedImage(100, 100, img.getType());
					Graphics2D g1 = resizedImage.createGraphics();
					g1.drawImage(img, 0, 0, 100, 100, null);
					g1.dispose();
				    int width = img.getWidth();
				    int height = img.getHeight();

				    //convert to grayscale
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
				    for(int i=0;i<10000;i++){
				    	img1[i]=(int) pix.get(i);
				    }
				    pix.clear();
				    DB db=con.getDB("image");
				    DBCollection co=db.getCollection("no");
				    DBObject ob=co.findOne();
				    int n=(int) ob.get("number");
				    double[][] VT=new double[n][10000];
				    int[] w1=new int[n];
				    DBCollection col=db.getCollection("mean");
				    DBObject obj=col.findOne();
				    pix=(ArrayList) obj.get("mean");
				    for(int i=0;i<10000;i++){
				    	int k=(int) pix.get(i);
				    	img1[i]=img1[i]-k;
				    	
				    }
				    DBCollection col1=db.getCollection("Teigen");
				    DBCursor cur=col1.find();
				    int j=0;
				    while(cur.hasNext()){
				    	DBObject obj1=cur.next();
				    	pix=(ArrayList) obj1.get("VT"+j);
				    	for(int i=0;i<10000;i++){
				    		VT[j][i]=(double) pix.get(i);
				    	}
				    	j++;
				    }
				    
				    int sum=0;
				    for(int i=0;i<n;i++){
				    	
				    		for(int k=0;k<10000;k++){
				    		 sum+=VT[i][k]*img1[k];
				    		 w1[i]=sum;
				    		}
				    		sum=0;
				    	
				    }
				    for(int i=0;i<n;i++){
				    	System.out.println(w1[i]);
				    }
				    DBCollection col4=db.getCollection("wt");
				    DBCursor cur4=col4.find();
				    int diff=9999999;
				    int thr=2700000;
				    int pos=0,g=0,i=0;
				    ArrayList k=new ArrayList();
				    while(cur4.hasNext()){
                                        System.out.println(i);
				    	DBObject obj4=cur4.next();
				    	k.clear();
				    	g=0;
				    	k=(ArrayList) obj4.get("wt");
				    	
				    		g=(int) k.get(1);
				    		
				    		g=Math.abs(g-w1[1]);
				    		System.out.println("->"+g);
				    		if(g<=diff){
				    			diff=g;
				    			pos=i+1;
				    		}
				    		i++;
				    	}
				    	
				    	
				    
				    if(diff<thr){
				    	System.out.println("<>"+pos);
			    		DBCollection col5=db.getCollection("SOI");
			    		BasicDBObject ob5=new BasicDBObject();
			    		ob5.put("num", pos);
			    		DBCursor cur5=col5.find(ob5);
			    		DBObject obj5=cur5.next();
			    		String des=(String) obj5.get("info");
			    		JOptionPane.showMessageDialog(null, "The information of this image is:- \n"+des,"Recognized",JOptionPane.INFORMATION_MESSAGE);
			    		
			    		
				    }
				    else{
				    	JOptionPane.showMessageDialog(null, "This image is not recognized by the system!!\n","Not Recognized",JOptionPane.INFORMATION_MESSAGE);
				    	
				    }
				    
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else
				{
					JOptionPane.showMessageDialog(null, "Select the file!!","File not selected",JOptionPane.ERROR_MESSAGE);	
					}
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        graydisplay g=new graydisplay();
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Insert1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insert1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insert1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insert1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Insert1 i=new Insert1();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Insert1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    // End of variables declaration//GEN-END:variables

    private void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
