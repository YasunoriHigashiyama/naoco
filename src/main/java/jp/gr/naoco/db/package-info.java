/**
 * naoco（Newgeneration Aspect Oriented Compact Objects）のDB操作関連機能パッケージです。
 * <p>
 * laol.dbでは以下の機能を保有するライブラリを提供します。
 * </p>
 * <ul>
 * <li>Entityのスーパークラスと、サブクラスで付与すべきアノテーション</li>
 * <li>SQLレンダリングと実行機能</li>
 * </ul>
 * <p>
 * 本パッケージのSQL実行機能については、コネクションやステートメントの取得について、 {@link jp.gr.naoco.core}の機能に依存します。<br>
 * 具体的には、{@link jp.gr.naoco.core}で生成したトランザクション境界内でDB操作が 実行されることを前提としており、実行するDB接続は
 * {@link jp.gr.naoco.core}で生成したトランザクションに 紐づくDB接続を利用します。
 * </p>
 * <p>
 * naocoのDB機能を利用する場合、本パッケージとその配下のパッケージのクラス群の中で、以下のクラスを主に使用します。
 * </p>
 * <ol>
 * <li>{@link jp.gr.naoco.db.entity.AbstractEntity}のサブクラスとして、テーブルやクエリに対応するエンティティサブクラスを定義し、 クラスとフィールドに
 * {@link jp.gr.naoco.db.annotation}パッケージ内のアノテーションを付与する。</li>
 * <li>{@link jp.gr.naoco.db.CommonDao}から、DBクエリ発行機能を呼び出す。</li>
 * </ol>
 * <p>
 * EntityからSQL文の生成と実行などをする機能は、{@link jp.gr.naoco.db}パッケージ配下のクラスにて 提供します。
 * </p>
 * <p>
 * 接続するDBアプリケーション間のクエリ表現の差異については、 {@link jp.gr.naoco.db.sql.DatabaseBridge}とその関連クラスで吸収する方針です。<br>
 * 利用しようとするDBアプリケーションに関する定義が上記クラスにない場合、上記クラスを拡張する必要があります。
 * </p>
 *
 * @author naoco0917
 */
package jp.gr.naoco.db;
