package jp.gr.naoco.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * トランザクション対象外のメソッドを示す
 * <p>
 * {@link @Transaction}アノテーションを付与したクラスの中で、本アノテーションを
 * 付与したメソッドはトランザクション対象外（DB接続対象外）とする。
 * </p>
 * <p>
 * トランザクション終了後のコミット、ロールバックのみスキップしたい場合は、 本アノテーションではなく、{@link
 * 
 * @BypassCommitRollback}を使用すること。
 *                                </p>
 *                                <p>
 *                                呼出し元でトランザクションが存在する場合は、本アノテーションを付与しても、
 *                                呼出し元のトランザクションとして振る舞うが、本アノテーションを付与したメソッドでの DB処理は、今後意図的に例外浮揚などで抑止する可能性があり推奨しない。
 *                                </p>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BypassTransaction {
}
