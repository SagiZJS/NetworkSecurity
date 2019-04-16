package infosecure;

public class RPWfromYahoo {
	String in ="";
	PWstack[] hpws= new PWstack[1000000];
	private int count=0,leng=0;
	public RPWfromYahoo() {
		int countnow =0,length = in.length();
		StringBuffer now = new StringBuffer();
		while(count<length) {
			if(in.charAt(count)!='\r') {
				now.append(in.charAt(count++));
			} else {
				hpws[countnow++]= new PWstack(now.toString());
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
class PWstack {
	String value;
	public PWstack(String in) {
		value =in;
	}
	String readPW() {
		StringBuffer now =new StringBuffer(value);
		int f=now.lastIndexOf(":");
		now.delete(0, f+1);
		
		return now.toString();
	}
	
}
