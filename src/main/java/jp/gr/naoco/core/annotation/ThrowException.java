package jp.gr.naoco.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 例外発生時の処理を示す
 * <p>
 * {@link @Interceptor}アノテーションを付与したクラス内のメソッドについて、 例外発生時に呼出すメソッドを示す。
 * </p>
 * <p>
 * <b>本アノテーションはクラス内で一件のメソッドのみ付与するものとする</b>。 複数のメソッドに本アノテーションを付与した場合に、どのメソッドが呼び出されるかは 保障しない。
 * </p>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ThrowException {

}
