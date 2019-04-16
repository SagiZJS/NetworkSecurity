package infosecure;

public class HSC {
//	String test = "00000c8d335a2f83106f4269ef412be535a81df0\r\n" + 
//			"00000b035be71dcc6eb2d026d480456735a820a1\r\n" + 
//			"00000e02e46bef12ce0723b9adb003ba35a820f4\r\n" + 
//			"000007446184bcd0f9f0b026b5c7733d35a82207\r\n" + 
//			"00000a0770c4c5cdfa98c44a1bea666b35a823eb\r\n" + 
//			"8f14e1a00697a66eae6ea8b270d8982735a82c14\r\n" + 
//			"00000e89b7fab0792eb50f52ab4fc6b135a831d2\r\n" + 
//			"1fa31ab525205e8b00b86ba79e69b41535a832e6\r\n" + 
//			"00000221ffe030cf1aa4e1b2a123ac4635a83374\r\n" + 
//			"00000d71632fb51f89db2fb4234a965e35a83d72";
	int hslen=64;
	String[] value = new String[6500000];
	inStreamhs inS =new inStreamhs();
	int count=0;
	int cot=0;
	
	
	void readFromStream(String input) {
		StringBuffer temp = new StringBuffer();
		for(int i=0;i<input.length();i++) {
//			System.out.println((int)input.charAt(i)+":"+input.charAt(i)+" count:"+cot);
			if(input.charAt(i)=='\r') {
			}else if (input.charAt(i)!='\n') {
				temp.append(input.charAt(i));
				cot++;
				if(cot==hslen) {
					inS.now.append(temp);
					push();
					cot=0;
//					System.out.println("cot=40");
//					System.out.println(temp);
					temp.delete(0,temp.length());
				}
			}
		}
//		System.out.println(inS.now);
		inS.now.append(temp);
//		System.out.println("temp"+temp);
	}
	void push() {
		
		value[count]=inS.now.toString();
//		System.out.println(value[count]);
		inS.now.delete(0, inS.now.length());
		count++;
//		try {
//			Thread.sleep(1100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	int length() {
		return count;
	}
}

class inStreamhs{
	StringBuffer now = new StringBuffer();
	int index=0;
}