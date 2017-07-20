package jp.gr.naoco.alacarte;

import java.io.File;

import jp.gr.naoco.alacarte.ZipFileWriter;

public class ZipFileWriterTest {
	public static void main(String[] args) throws Exception {
		ZipFileWriter writer = new ZipFileWriter(new File(
				"C:\\temp\\test01.zip"),
				java.nio.charset.Charset.forName("UTF-8"));

		writer.setZipEntry("file01.csv");
		writer.writeCSV("hoge01", "hige01", "hage01", "hege01");
		writer.writeCSV("hoge02", "hige02", "hage02", "hege02");
		writer.writeCSV("hoge03", "hige03", "hage03", "he\nge03");
		writer.writeCSV("hoge04", "hige04", "hag\"e04", "hege04");
		writer.writeCSV("hoge05", "hige05", "hage05", "hege05");
		writer.setZipEntry("file02.csv");
		writer.writeCSV("foge01", "fige01", "fage01", "fege01");
		writer.writeCSV("foge02", "fige02", "fage02", "fege02");
		writer.writeCSV("foge\n03", "fige03", "fage03", "fege03");
		writer.writeCSV("foge04", "fige04", "fage04", "fege04");
		writer.writeCSV("foge05", "fige05", "fage05", "fege05");
		writer.setZipEntry("file03.csv");
		writer.writeCSV("doge01", "dige01", "dage01", "dege01");
		writer.writeCSV("doge02", "dige02", "dage02", "dege02");
		writer.writeCSV("doge03", "dige03", "dage03", "dege03");
		writer.writeCSV("doge04", "dige04", "dage04", "dege04");
		writer.writeCSV("doge05", "dige05", "dage05", "dege05");
		writer.close();
	}
}
