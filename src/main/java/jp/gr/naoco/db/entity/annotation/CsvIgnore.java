package jp.gr.naoco.db.entity.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * マスタ配信CSV無視カラム用アノテーション<br>
 * マスタ配信CSVファイルに含めたくないカラムにつける。
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CsvIgnore {
}
