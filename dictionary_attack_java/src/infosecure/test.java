package infosecure;
import org.apache.commons.codec.digest.*;
public class test {
	public static void main(String[] args) {
		String test  ="18bd908a17242ff0cc7187ac52f8f7cf8dee5d28d9f8d9b4d1989fb9cfd76c51 1babygurl 'formspring.txt'\r\n" + 
				"dfa879d6e37120401d73885ab1bafe489a841dda65ddfd827cdc325100b8e265 softball00 'formspring.txt'\r\n" + 
				"f06732f2f12284ddd06bbd774c8fe4ea1226c75c5426ce8dd95607bc11d50ebb sugarbaby1 'formspring.txt'\r\n" + 
				"011d3637c1c9e3e60fd775bbada12d2a07de879a625bf38c310594b0a7e34812 theblackparade 'formspring.txt'\r\n" + 
				"abfc0b0ff3d9688343bba68c745dc96f446f2f823a544222c79d8d0aad083e7b sweetie13 'formspring.txt'\r\n" + 
				"6e11198e2bd8e561def4b65462dbf9d7c59760810321c9baf73412c666cfd240 loveme10 'formspring.txt'\r\n" + 
				"9579f7443019a98e29958aa42f00514e215f18699a25cb05802181208be96839 softball03 'formspring.txt'\r\n" + 
				"bca33249aaf6357b57d5cdfbb7e62b96e885a8449b4abc02f74cd7db08f6959c candyland1 'formspring.txt'\r\n" + 
				"9fdbd70b22a9fb7fde211a5fb3922925fd7a2e934df8aae7f95ac849c9752f13 loveable2 'formspring.txt'\r\n" + 
				"eaee59036cff3c4d0ef04f0c356aead69f4cf9d82b7fd250e3ff7e07b041a4cb matt4eva 'formspring.txt'\r\n" + 
				"636986a6752115cd62bb110c1401dc4b16fe84a43cc280a0b60baa18af472f66 dancer26 'formspring.txt'";
		System.out.println(DigestUtils.sha1Hex("paradeuce"));
	}

}
