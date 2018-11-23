import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class weight {
	MongoClient conn;
	int n,i=0,j=0,k=0;
	ArrayList a,b;
	public weight(){            
		try {
			conn=new MongoClient("localhost",27017);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB db=conn.getDB("image");
		DBCollection col=db.getCollection("no");
		DBObject obj=col.findOne();
		n=(int) obj.get("number");
		DBCollection col1=db.getCollection("SOI_MEAN");
		DBCollection col2=db.getCollection("Teigen");
		int[][] w=new int[n][n];
		int[][] Q=new int[10000][n];
		
		double[][] VT=new double[n][10000];
		DBCursor cur=col1.find();
                
                //System.out.println(opp);
		do{
			 DBObject ob=cur.next();
			for(i=0;i<10000;i++){
			    
			     a=(ArrayList) ob.get("image");
			     Q[i][j]=(int)a.get(i);
			}
			j++;
		}while(cur.hasNext());
		
		DBCursor cur1=col2.find();
		j=0;
		while(cur1.hasNext()){
			DBObject ob1=cur1.next();
			for(i=0;i<10000;i++){
			
				b=(ArrayList) ob1.get("VT"+j);
				VT[j][i]= (double) b.get(i);
			}
			j++;
		}
		
		int sum=0;
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				for(k=0;k<10000;k++){
					sum=(int) (sum+VT[i][k]*Q[k][j]);
					w[i][j]=sum;
				}
				sum=0;
			}
		}
		/*for(i=0;i<n;i++){
			System.out.println("");
			for(j=0;j<n;j++){
				System.out.print(w[i][j]+"\t");
			}
			
		}*/
		DBCollection col3=db.getCollection("wt");
		col3.drop();
		
		ArrayList wt=new ArrayList();
		
		for(i=0;i<n;i++){
			wt.clear();
			for(j=0;j<n;j++){
				wt.add(w[j][i]);
			}
			BasicDBObject obj3=new BasicDBObject("num",i).append("wt", wt);
			col3.insert(obj3);
		}
		
	    conn.close();
		
		
	}

}
