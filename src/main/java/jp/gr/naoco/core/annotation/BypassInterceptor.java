package jp.gr.naoco.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * インターセプト対象外のメソッドを示す
 * <p>
 * {@link @Interceptee}アノテーションを付与したクラスの中で、本アノテーションを 付与したメソッドは処理前後のインターセプター呼出し対象外とする。
 * </p>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BypassInterceptor {
}
