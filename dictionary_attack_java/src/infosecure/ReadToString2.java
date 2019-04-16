package infosecure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadToString2 {
	public static void main(String[] args) {
//		readhsc();
		readpsw();
		System.out.println("\n"+psw.value[psw.length()-1]+" "+psw.length());
	}
	
	static PSW2 psw =new PSW2();
		static void readpsw() {
			File file1 = new File("D:/Data/infosecure/ass2file3.txt");
			InputStream fins =null;
			try {
				fins = new FileInputStream(file1);
				byte[] car = new byte[16];
				int len =0; //actual length
				while (-1!=(len=fins.read(car))) {
					
					String info =new String(car,0,len);
					
//					System.out.print(info);
					psw.readFromStream(info);
					
				}
				
			} catch(FileNotFoundException e){
				e.printStackTrace();
				System.out.println("doesnt exist");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("read error");
			}  finally {
				try {
					if(null!=fins) {
						fins.close();
					}
				} catch (Exception e2) {
					System.out.println("cannot shut down inputstream");
				}
			}
		}
		static HSC hsc =new HSC();
		static void readhsc() {
			File file1 = new File("D:/Data/infosecure/formspring.txt");
			InputStream fins =null;
			try {
				fins = new FileInputStream(file1);
				byte[] car = new byte[16];
				int len =0; //actual length
				while (-1!=(len=fins.read(car))) {
					
					String info =new String(car,0,len);
//					System.out.print(info);
					
					hsc.readFromStream(info);
					
				}
				
			} catch(FileNotFoundException e){
				e.printStackTrace();
				System.out.println("doesnt exist");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("read error");
			}  finally {
				try {
					if(null!=fins) {
						fins.close();
					}
				} catch (Exception e2) {
					System.out.println("cannot shut down inputstream");
				}
			}
		}
	
	
}
