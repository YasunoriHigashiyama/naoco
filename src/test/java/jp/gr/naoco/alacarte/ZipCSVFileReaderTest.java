package jp.gr.naoco.alacarte;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.zip.ZipEntry;

import jp.gr.naoco.alacarte.ZipCSVFileReader;
import jp.gr.naoco.alacarte.ZipFileWriter;
import jp.gr.naoco.alacarte.ZipFileWriter.CSVConfig;
import jp.gr.naoco.db.entity.AbstractEntity;
import jp.gr.naoco.db.entity.annotation.Column;
import jp.gr.naoco.db.entity.annotation.CsvIgnore;
import jp.gr.naoco.db.entity.annotation.Id;
import jp.gr.naoco.db.entity.annotation.Table;

import org.junit.Test;

public class ZipCSVFileReaderTest {
	private static void create() throws Exception {
		ZipFileWriter writer = new ZipFileWriter(new File("C:\\temp\\test02.zip"),
				java.nio.charset.Charset.forName("UTF-8"));
		try {
			writer.setZipEntry4Entity(TestEntity.class, "TEST01.csv");
			TestEntity entity = new TestEntity();
			entity.setString_id("id01");
			entity.setDouble_id(1D);
			entity.setLong_id(2L);
			entity.setString_value("hoge\"nhige");
			entity.setUtil_date_value(new java.util.Date(12345678000L));
			entity.setCsv_ignore_value("please_ignore");
			writer.writeEntity2CSV(entity);
			entity = new TestEntity();
			entity.setString_id("id02");
			entity.setDouble_id(3D);
			entity.setLong_id(4L);
			entity.setSql_date_value(new java.sql.Date(12355678000L));
			entity.setCsv_ignore_value("please_ignore");
			writer.writeEntity2CSV(entity);
			entity = new TestEntity();
			entity.setString_id("id03");
			entity.setDouble_id(5D);
			entity.setLong_id(6L);
			entity.setString_value("hoge\nhige");
			entity.setSql_timestamp_value(new java.sql.Timestamp(12365678000L));
			entity.setCsv_ignore_value("please_ignore");
			writer.writeEntity2CSV(entity);

			writer.setZipEntry4Entity(TestEntity.class, "TEST02.csv");
			entity = new TestEntity();
			entity.setString_id("id04");
			entity.setDouble_id(7D);
			entity.setLong_id(8L);
			entity.setString_value("あああ\"いいい");
			entity.setUtil_date_value(new java.util.Date(13345678000L));
			entity.setCsv_ignore_value("please_ignore");
			writer.writeEntity2CSV(entity);
			entity = new TestEntity();
			entity.setString_id("id05");
			entity.setDouble_id(9D);
			entity.setLong_id(10L);
			entity.setSql_date_value(new java.sql.Date(13355678000L));
			entity.setCsv_ignore_value("please_ignore");
			writer.writeEntity2CSV(entity);
			entity = new TestEntity();
			entity.setString_id("id06");
			entity.setDouble_id(11D);
			entity.setLong_id(12L);
			entity.setString_value("かかか\nききき");
			entity.setSql_timestamp_value(new java.sql.Timestamp(12365678000L));
			entity.setCsv_ignore_value("please_ignore");
			writer.writeEntity2CSV(entity);
		} finally {
			writer.close();
		}
	}

	/** エンティティ取得 */
	@Test
	public void test01() throws Exception {
		create();

		ZipCSVFileReader reader = new ZipCSVFileReader(new FileInputStream("C:\\temp\\test02.zip"), new CSVConfig());
		try {
			ZipEntry entry = null;
			while (null != (entry = reader.nextZipEntry())) {
				System.out.println(entry.getName());
				reader.setNext(TestEntity.class);
				TestEntity entity = null;
				while (null != (entity = (TestEntity) reader.readCSV2Entity())) {
					System.out.println("STRING_ID:" + entity.getString_id() + //
							" LONG_ID:" + entity.getLong_id() + //
							" DOUBLE_ID:" + entity.getDouble_id() + //
							" STRING_VALUE:" + entity.getString_value() + //
							" java.util.Date_VALUE:" + entity.getUtil_date_value() + //
							" java.sql.date_VALUE:" + entity.getSql_date_value() + //
							" java.sql.Timestamp_VALUE:" + entity.getSql_timestamp_value());
				}
			}
		} finally {
			reader.close();
		}
	}

	/** 文字列配列取得 */
	@Test
	public void test02() throws Exception {
		create();

		ZipCSVFileReader reader = new ZipCSVFileReader(new FileInputStream("C:\\temp\\test02.zip"), new CSVConfig());
		try {
			ZipEntry entry = null;
			while (null != (entry = reader.nextZipEntry())) {
				System.out.println(entry.getName());
				reader.setNext();
				String[] values = null;
				while (null != (values = reader.readCSV())) {
					for (int i = 0; i < values.length; i++) {
						System.out.print(values[i] + ", ");
					}
					System.out.println();
				}
			}
		} finally {
			reader.close();
		}
	}

	/** マップ取得 */
	@Test
	public void test03() throws Exception {
		create();

		ZipCSVFileReader reader = new ZipCSVFileReader(new FileInputStream("C:\\temp\\test02.zip"), new CSVConfig());
		try {
			ZipEntry entry = null;
			while (null != (entry = reader.nextZipEntry())) {
				System.out.println(entry.getName());
				reader.setNext();
				LinkedHashMap<String, String> map = null;
				while (null != (map = reader.readCSV2Map())) {
					for (String key : map.keySet()) {
						System.out.print(key + ":" + map.get(key) + ", ");
					}
					System.out.println();
				}
			}
		} finally {
			reader.close();
		}
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////
	// Inner Classes

	@Table(name = "TEST_TABLE")
	public static class TestEntity extends AbstractEntity {
		@Id(name = "STRING_ID")
		private String string_id;
		@Id(name = "LONG_ID")
		private Long long_id;
		@Id(name = "DOUBLE_ID")
		private Double double_id;
		@Column(name = "STRING_VALUE")
		private String string_value;
		@Column(name = "LONG_VALUE")
		private Long long_value;
		@Column(name = "DOUBLE_VALUE")
		private Double double_value;
		@Column(name = "UTIL_DATE_VALUE")
		private java.util.Date util_date_value;
		@CsvIgnore()
		@Column(name = "CSV_IGNORE_VALUE")
		private String csv_ignore_value;
		@Column(name = "SQL_TIMESTAMP_VALUE")
		private java.sql.Timestamp sql_timestamp_value;
		@Column(name = "SQL_DATE_VALUE")
		private java.sql.Date sql_date_value;
		@Column(name = "SQL_TIME_VALUE")
		private java.sql.Time sql_time_value;

		public String getString_id() {
			return string_id;
		}

		public void setString_id(String string_id) {
			this.string_id = string_id;
			setFieldNameSet_.add("STRING_ID");
		}

		public Long getLong_id() {
			return long_id;
		}

		public void setLong_id(Long long_id) {
			this.long_id = long_id;
			setFieldNameSet_.add("LONG_ID");
		}

		public Double getDouble_id() {
			return double_id;
		}

		public void setDouble_id(Double double_id) {
			this.double_id = double_id;
			setFieldNameSet_.add("DOUBLE_ID");
		}

		public String getString_value() {
			return string_value;
		}

		public void setString_value(String string_value) {
			this.string_value = string_value;
			setFieldNameSet_.add("STRING_VALUE");
		}

		public Long getLong_value() {
			return long_value;
		}

		public void setLong_value(Long long_value) {
			this.long_value = long_value;
			setFieldNameSet_.add("LONG_VALUE");
		}

		public Double getDouble_value() {
			return double_value;
		}

		public void setDouble_value(Double double_value) {
			this.double_value = double_value;
			setFieldNameSet_.add("DOUBLE_VALUE");
		}

		public java.util.Date getUtil_date_value() {
			return util_date_value;
		}

		public void setUtil_date_value(java.util.Date util_date_value) {
			this.util_date_value = util_date_value;
			setFieldNameSet_.add("UTIL_DATE_VALUE");
		}

		public String getCsv_ignore_value() {
			return csv_ignore_value;
		}

		public void setCsv_ignore_value(String csv_ignore_value) {
			this.csv_ignore_value = csv_ignore_value;
			setFieldNameSet_.add("CSV_IGNORE_VALUE");
		}

		public java.sql.Timestamp getSql_timestamp_value() {
			return sql_timestamp_value;
		}

		public void setSql_timestamp_value(java.sql.Timestamp sql_timestamp_value) {
			this.sql_timestamp_value = sql_timestamp_value;
			setFieldNameSet_.add("SQL_TIMESTAMP_VALUE");
		}

		public java.sql.Date getSql_date_value() {
			return sql_date_value;
		}

		public void setSql_date_value(java.sql.Date sql_date_value) {
			this.sql_date_value = sql_date_value;
			setFieldNameSet_.add("SQL_DATE_VALUE");
		}

		public java.sql.Time getSql_time_value() {
			return sql_time_value;
		}

		public void setSql_time_value(java.sql.Time sql_time_value) {
			this.sql_time_value = sql_time_value;
			setFieldNameSet_.add("SQL_TIME_VALUE");
		}
	}
}
