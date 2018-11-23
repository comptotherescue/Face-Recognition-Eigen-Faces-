import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Jama.EigenvalueDecomposition;
import Jama.Matrix;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class covariance {

	MongoClient con;
	int n=0,i=0,j=0,k=0;
	double sum=0;
	ArrayList a;
	
	public covariance(){
		try {
			con=new MongoClient("localhost",27017);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB db=con.getDB("image");
		DBCollection col=db.getCollection("no");
		DBCollection col1=db.getCollection("SOI_MEAN");
		DBObject obj=col.findOne();
		n=(int) obj.get("number");
                  System.out.println(n);
		int[][] A=new int[10000][n];
		int[][] AT=new int[n][10000];
		double[][] ATA=new double[n][n];
		double[][] U=new double[n][n];//lower dimension eigen vector
		double[][] V=new double[10000][n];//high dimension eigen vector
		double[][] VT=new double[n][10000];//transpose of V
		int[] w=new int[n];
		ArrayList a = new ArrayList();
		DBCursor cur=col1.find();
		while(cur.hasNext()){
			DBObject obj1=cur.next();
			a=(ArrayList) obj1.get("image");
                        System.out.println(a.size());
			for(i=0;i<10000;i++){
				A[i][j]=AT[j][i]=(int) a.get(i);
			}
			j++;
			a.clear();
		}
		
		//ATA multiplication
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				for(k=0;k<10000;k++){
					sum=sum+AT[i][k]*A[k][j];
				}
				ATA[i][j]=sum;
				sum=0;
			}
		}

		
		
		Matrix m=new Matrix(ATA);
		EigenvalueDecomposition eigen=m.eig();
		Matrix evectors = eigen.getV();
		U=evectors.getArray();
		sum=0;
		//change U[n][n] to higher dimension V[10000][n]
		for(i=0;i<10000;i++){
			for(j=0;j<n;j++){
				for(k=0;k<n;k++){
					sum=sum+A[i][k]*U[j][k];/// V=AU  10000*n * n*n= 10000*n
					V[i][j]=sum;// column are eigen vectors
					//Transpose of V rows are eigen vectors
				}
				sum=0;
			}
		}
		Matrix v=new Matrix(V);
		v.norm1();
		V=v.getArray();
		for(int i=0;i<n;i++){
			for(int j=0;j<10000;j++){
				VT[i][j]=V[j][i];
			}
		}
		/*for(j=0;j<10000;j++){          //// V=AU A=N2xM U=MxM V=N2 X M 10000xn
			System.out.println("");
			for(k=0;k<n;k++){
		System.out.print(V[j][k]+"\t");
			}
		}*/
		
		DBCollection col2=db.getCollection("Teigen");
		col2.drop();
		col2=db.getCollection("Teigen");
		//save transpose into arraylist
		for(i=0;i<n;i++){
			for(j=0;j<10000;j++){
				a.add(VT[i][j]);
				
			}
			BasicDBObject ob=new BasicDBObject("VT"+i,a);
			col2.insert(ob);
		}
		
		
		
		
		con.close();
		
	}
}
