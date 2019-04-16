package infosecure;
public class PSW2 {
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
	String[] value2 =new String[1000000];
	String[] value3 =new String[1000000];
//	String[] hsvalue =new String[1000000];
	inStrea inS =new inStrea();
	inStrea inS1 =new inStrea();
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
		
		if(inS.now.indexOf(":")!=-1) {
			StringBuffer temp = new StringBuffer(inS.now);
			StringBuffer slt = new StringBuffer(temp);
			/*************************/
			
			slt.delete(0, slt.lastIndexOf(":")+1);
			
			/******************************/
			temp.delete(0, temp.indexOf(" ")+1);
			
			temp.delete(temp.lastIndexOf(":"), temp.length());
			temp.delete(temp.lastIndexOf(":"), temp.length());
			
			/**********************/
			inS.now.delete(inS.now.indexOf(":"),inS.now.length());
			boolean flag= false;
			for(int i=0;i<count;i++) {
				if(slt.toString().equalsIgnoreCase(value3[i])) {
					flag = true;
				}
			}
			if(!flag) {
				value3[count]=slt.toString();
				value2[count]=temp.toString();
				value[count]=inS.now.toString();
				System.out.print(value2[count]+" "+value[count]+"\n"/*+value[count].length()*/);
				count++;
			}
			
		}
		inS.now.delete(0, inS.now.length());
		
		
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

class inStrea{
	StringBuffer now = new StringBuffer();
	int index=0;
}