package jp.gr.naoco.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * トランザクション終了後の更新反映対象外のメソッドを示す
 * <p>
 * {@link @Transaction}アノテーションを付与したクラスの中で、本アノテーションを 付与したメソッドはトランザクション終了後の更新反映対象外 （コミットあるいはロールバックを行わない）とする。
 * </p>
 * <p>
 * トランザクション対象外（DB接続対象外の処理）としたい場合は、 本アノテーションではなく、{@link @BypassTransaction} を使用すること。
 * </p>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BypassCommitRollback {
}
