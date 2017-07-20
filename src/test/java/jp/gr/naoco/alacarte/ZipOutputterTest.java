package jp.gr.naoco.alacarte;

import java.io.File;

import jp.gr.naoco.alacarte.ZipEncoder;
import jp.gr.naoco.chain.OriginalLogAdaptor;
import jp.gr.naoco.core.NaocoCoreInitializer;

public class ZipOutputterTest {
	public static void main(String[] args) throws Exception {
		// naocoの初期化
		NaocoCoreInitializer.initialize("conf.laol01", new OriginalLogAdaptor());

		File in = new File(
				"C:\\development\\workspace\\cdp_common\\src\\main\\java");
		File out = new File("C:\\temp\\test.zip");
		ZipEncoder util = new ZipEncoder();
		util.output(in, out);
	}
}
