package infosecure;

import org.apache.commons.codec.digest.*;

public class ass2startfrom30w {

	public static void main(String[] args) {
		DigestUtils hsh = new DigestUtils();
//		readhashcode rhc = new readhashcode();
		ReadToString rd =new ReadToString();
		rd.readhsc();
		rd.readpsw();
		System.out.println(rd.hsc.value[0]+" length:"+rd.hsc.length());
		System.out.println(rd.psw.value[0]+" length:"+rd.psw.length());
//		System.out.println(rhc.leng);
////		RPWfromYahoo yh = new RPWfromYahoo();
//		System.out.println(yh.hpws[0].readPW()+"\nlenth:"+yh.length());
		for(int i=300000;i<rd.hsc.length();i++) {
			
			for(int j=0;j<rd.psw.length();j++) {

				if(equal(hsh.sha1Hex(rd.psw.value[j])
						,rd.hsc.value[i])) {
					System.out.println(""+rd.psw.value[j]+":"+j+" "+rd.hsc.value[i]+":"+i);
				}
			}
		}
	}
//	
	static boolean equal(String in1, String in2) {
		boolean flag =false;
		flag = in1.substring(4).equalsIgnoreCase(in2.substring(4));
		return flag;
	}
}
