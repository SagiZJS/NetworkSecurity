package infosecure;
public class PSW {
//	String test = "739827:NUMBAONEMAMI2002@YAHOO.COM:cedinme@0424\r\n" + 
//			"739829:joseca@comcast.net:hsbc1234\r\n" + 
//			"739831:princesslia3@gmail.com:neworleans24\r\n" + 
//			"739833:ruthgibbs1980@aol.com:gamera24\r\n" + 
//			"739835:centizen@gmx.com:blu-fire\r\n" + 
//			"739837:leeonna_sanchez@live.com:leeonna7211\r\n" + 
//			"739839:undertheredsunx@gmail.com:partys56\r\n" + 
//			"739841:nvmediagroup@yahoo.com:wegotmoney$\r\n" + 
//			"739843:elrofeet@plantar-fasciitis-elrofeet.c";
	String[] value =new String[1000000];
//	String[] hsvalue =new String[1000000];
	inStream inS =new inStream();
	int count=0;
	
	
	void readFromStream(String input) {
		StringBuffer temp = new StringBuffer();
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i)=='\n') {
				inS.now.append(temp);
				if(inS.now.length()>0)push();
				temp.delete(0, temp.length());
			}else if(input.charAt(i)!='\r'){
				temp.append(input.charAt(i));
				
			}
			
		}
		inS.now.append(temp);
	}
	void push() {
		
		inS.now.delete(0,inS.now.indexOf(" ")+1);
		inS.now.delete(inS.now.lastIndexOf(" "), inS.now.length());
		
		value[count]=inS.now.toString();
		System.out.println(value[count]+" "+value[count].length());
		inS.now.delete(0, inS.now.length());
		count++;
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	int length() {
		return count;
	}
}

class inStream{
	StringBuffer now = new StringBuffer();
	int index=0;
}