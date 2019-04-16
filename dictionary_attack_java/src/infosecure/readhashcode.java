package infosecure;

 public class readhashcode {
	String in =""
			
	;

	hashstack[] hs= new hashstack[1000000];
	int count=0,leng=0;
	public readhashcode() {
		int countnow =0,length = in.length();
		StringBuffer now = new StringBuffer();
		while(count<length) {
			if(in.charAt(count)!='\r') {
				now.append(in.charAt(count++));
			} else {
				hs[countnow++]= new hashstack(now.toString());
				count+=2;
				leng++;
				now = new StringBuffer();
			}
		}
	}

	int length() {
		return leng;
	}
}
class hashstack {
	String value;
	public hashstack(String in) {
		value =in;
	}
}
