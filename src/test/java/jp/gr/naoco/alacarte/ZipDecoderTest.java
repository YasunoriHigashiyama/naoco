package jp.gr.naoco.alacarte;

import java.io.File;

import jp.gr.naoco.alacarte.ZipDecoder;
import jp.gr.naoco.chain.OriginalLogAdaptor;
import jp.gr.naoco.core.NaocoCoreInitializer;

public class ZipDecoderTest {
	public static void main(String[] args) throws Exception {
		// naocoの初期化
		NaocoCoreInitializer.initialize("conf.laol01", new OriginalLogAdaptor());

		File in = new File("C:\\temp\\test.zip");
		File out = new File("C:\\temp\\test");
		ZipDecoder util = new ZipDecoder();
		util.decode(in, out);
	}

}
