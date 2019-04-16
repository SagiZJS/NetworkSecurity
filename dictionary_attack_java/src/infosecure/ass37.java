package infosecure;

import org.apache.commons.codec.digest.*;

public class ass37 {

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
		for(int j=8000;j<rd.psw.length();j++) {
			for(int i=0;i<rd.hsc.length();i++) {
				for(int salt =0;salt<100;salt++) {
					StringBuffer salts = new StringBuffer();			
					if(salt<10) salts.append('0');
					salts.append(Integer.toString(salt));
					salts.append(rd.psw.value[j]);
//					System.out.println(salts);
					if(equal(hsh.sha256Hex(salts.toString())
							,rd.hsc.value[i])) {
						System.out.println(""+rd.psw.value[j]+":"+j+" "+rd.hsc.value[i]+":"+i+"salt:"+salt);
					}
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
