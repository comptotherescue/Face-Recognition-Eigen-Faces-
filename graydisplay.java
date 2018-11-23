
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.awt.image.BufferedImage;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
class graydisplay {
    MongoClient con=null;
    public graydisplay(){
     try {
					 con=new MongoClient("localhost",27017);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int i;
                                int a12[];
                                a12=new int[10000];
                                JFrame jf=new JFrame();
                                JTabbedPane tabbed= new JTabbedPane();
                                
          
				DB db=con.getDB("image");
                                DBCollection col1=db.getCollection("SOI");
                                DBCursor cur=col1.find();
                                do{
                                DBObject ob=cur.next();
                                 ArrayList a1;
				 a1=(ArrayList) ob.get("image");
				String g=(String) ob.get("info");
				 i=0;
                                  System.out.println("hello");
                               
                                  
				 while(i<10000){
                                        a12[i]=0;
					 a12[i]+=(int)a1.get(i);
					
					 i++;
				 }
            
            
            BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
             int p;
           for (int k = 0; k < 100; k++){
            for (int j = 0; j < 100; j++) {
            p = a12[j*100+k]<<24 | a12[j*100+k]<<16 | a12[j*100+k]<<8;    
            image.setRGB(k, j, p);
            }
           }
            ImageIcon ii = new ImageIcon(image);
        
    tabbed.addTab(g, new JScrollPane(new JLabel(ii)));
    
                                }while(cur.hasNext());
    jf.add(tabbed);
    jf.pack();
    
    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    jf.setVisible(true);
    con.close();
}
}
