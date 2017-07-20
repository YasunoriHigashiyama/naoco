package jp.gr.naoco.core;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.gr.naoco.core.exception.ConnectionInstantiationException;
import jp.gr.naoco.core.transaction.InterceptorContext;
import jp.gr.naoco.core.transaction.TransactionManager;

/**
 * 本ライブラリ内で利用アプリケーション側が頻繁に使用する処理の呼出しを纏めたファサードクラス
 */
public class NaocoCoreFacade {
	// /////////////////////////////////////////////////////////////////////////////////////////////
	// Constructor

	private NaocoCoreFacade() {
		// nothing to do
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////
	// Methods

	/**
	 * データベースのストアドプロシージャーを呼び出すための CallableStatement オブジェクトを生成する。
	 * <p>
	 * 本メソッドで取得するオブジェクトは、{@link NaocoCoreFacade#getConnection()}で取得したオブジェクトに対し、 {@link Connection#prepareCall(String)}
	 * の呼出しで取得するオブジェクトと同じであるが、トランザクションの終了時に 自動でクローズをするため、呼出し元でクローズをする必要がない。
	 * </p>
	 * <p>
	 * ただし、Statementから取得されるResultSetについては、呼出し元でクローズをする必要がある。
	 * </p>
	 *
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public static CallableStatement prepareCall(String sql) throws SQLException {
		return TransactionManager.prepareCall(sql);
	}

	/**
	 * データベースのストアドプロシージャーを呼び出すための CallableStatement オブジェクトを生成する。
	 * <p>
	 * 本メソッドで取得するオブジェクトは、{@link NaocoCoreFacade#getConnection()}で取得したオブジェクトに対し、
	 * {@link Connection#prepareCall(String, int, int)} の呼出しで取得するオブジェクトと同じであるが、トランザクションの終了時に
	 * 自動でクローズをするため、呼出し元でクローズをする必要がない。
	 * </p>
	 * <p>
	 * ただし、Statementから取得されるResultSetについては、呼出し元でクローズをする必要がある。
	 * </p>
	 *
	 * @param sql
	 * @param resultSetType
	 * @param resultSetConcurrency
	 * @return
	 * @throws SQLException
	 */
	public static CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		return TransactionManager.prepareCall(sql, resultSetType, resultSetConcurrency);
	}

	/**
	 * データベースのストアドプロシージャーを呼び出すための CallableStatement オブジェクトを生成する。
	 * <p>
	 * 本メソッドで取得するオブジェクトは、{@link NaocoCoreFacade#getConnection()}で取得したオブジェクトに対し、
	 * {@link Connection#prepareCall(String, int, int, int)} の呼出しで取得するオブジェクトと同じであるが、トランザクションの終了時に
	 * 自動でクローズをするため、呼出し元でクローズをする必要がない。
	 * </p>
	 * <p>
	 * ただし、Statementから取得されるResultSetについては、呼出し元でクローズをする必要がある。
	 * </p>
	 *
	 * @param sql
	 * @param resultSetType
	 * @param resultSetConcurrency
	 * @return
	 * @throws SQLException
	 */
	public static CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		return TransactionManager.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
	}

	/**
	 * パラメータ付き SQL 文をデータベースに送るための PreparedStatement オブジェクトを生成を生成する。
	 * <p>
	 * 本メソッドで取得するオブジェクトは、{@link NaocoCoreFacade#getConnection()}で取得したオブジェクトに対し、
	 * {@link Connection#prepareStatement(String)} の呼出しで取得するオブジェクトと同じであるが、トランザクションの終了時に 自動でクローズをするため、呼出し元でクローズをする必要がない。
	 * </p>
	 * <p>
	 * ただし、Statementから取得されるResultSetについては、呼出し元でクローズをする必要がある。
	 * </p>
	 *
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public static PreparedStatement prepareStatement(String sql) throws SQLException {
		return TransactionManager.prepareStatement(sql);
	}

	/**
	 * パラメータ付き SQL 文をデータベースに送るための PreparedStatement オブジェクトを生成を生成する。
	 * <p>
	 * 本メソッドで取得するオブジェクトは、{@link NaocoCoreFacade#getConnection()}で取得したオブジェクトに対し、
	 * {@link Connection#prepareStatement(String, int)} の呼出しで取得するオブジェクトと同じであるが、トランザクションの終了時に
	 * 自動でクローズをするため、呼出し元でクローズをする必要がない。
	 * </p>
	 * <p>
	 * ただし、Statementから取得されるResultSetについては、呼出し元でクローズをする必要がある。
	 * </p>
	 *
	 * @param sql
	 * @param autoGeneratedKeys
	 * @return
	 * @throws SQLException
	 */
	public static PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		return TransactionManager.prepareStatement(sql, autoGeneratedKeys);
	}

	/**
	 * パラメータ付き SQL 文をデータベースに送るための PreparedStatement オブジェクトを生成を生成する。
	 * <p>
	 * 本メソッドで取得するオブジェクトは、{@link NaocoCoreFacade#getConnection()}で取得したオブジェクトに対し、
	 * {@link Connection#prepareStatement(String, int[])} の呼出しで取得するオブジェクトと同じであるが、トランザクションの終了時に
	 * 自動でクローズをするため、呼出し元でクローズをする必要がない。
	 * </p>
	 * <p>
	 * ただし、Statementから取得されるResultSetについては、呼出し元でクローズをする必要がある。
	 * </p>
	 *
	 * @param sql
	 * @param columnIndexes
	 * @return
	 * @throws SQLException
	 */
	public static PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		return TransactionManager.prepareStatement(sql, columnIndexes);
	}

	/**
	 * パラメータ付き SQL 文をデータベースに送るための PreparedStatement オブジェクトを生成を生成する。
	 * <p>
	 * 本メソッドで取得するオブジェクトは、{@link NaocoCoreFacade#getConnection()}で取得したオブジェクトに対し、
	 * {@link Connection#prepareStatement(String, int, int)} の呼出しで取得するオブジェクトと同じであるが、トランザクションの終了時に
	 * 自動でクローズをするため、呼出し元でクローズをする必要がない。
	 * </p>
	 * <p>
	 * ただし、Statementから取得されるResultSetについては、呼出し元でクローズをする必要がある。
	 * </p>
	 *
	 * @param sql
	 * @param resultSetType
	 * @param resultSetConcurrency
	 * @return
	 * @throws SQLException
	 */
	public static PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		return TransactionManager.prepareStatement(sql, resultSetType, resultSetConcurrency);
	}

	/**
	 * パラメータ付き SQL 文をデータベースに送るための PreparedStatement オブジェクトを生成を生成する。
	 * <p>
	 * 本メソッドで取得するオブジェクトは、{@link NaocoCoreFacade#getConnection()}で取得したオブジェクトに対し、
	 * {@link Connection#prepareStatement(String, int, int, int)} の呼出しで取得するオブジェクトと同じであるが、トランザクションの終了時に
	 * 自動でクローズをするため、呼出し元でクローズをする必要がない。
	 * </p>
	 * <p>
	 * ただし、Statementから取得されるResultSetについては、呼出し元でクローズをする必要がある。
	 * </p>
	 *
	 * @param sql
	 * @param resultSetType
	 * @param resultSetConcurrency
	 * @param resultSetHoldability
	 * @return
	 * @throws SQLException
	 */
	public static PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		return TransactionManager.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
	}

	/**
	 * パラメータ付き SQL 文をデータベースに送るための PreparedStatement オブジェクトを生成を生成する。
	 * <p>
	 * 本メソッドで取得するオブジェクトは、{@link NaocoCoreFacade#getConnection()}で取得したオブジェクトに対し、
	 * {@link Connection#prepareStatement(String, String[])} の呼出しで取得するオブジェクトと同じであるが、トランザクションの終了時に
	 * 自動でクローズをするため、呼出し元でクローズをする必要がない。
	 * </p>
	 * <p>
	 * ただし、Statementから取得されるResultSetについては、呼出し元でクローズをする必要がある。
	 * </p>
	 *
	 * @param sql
	 * @param resultSetType
	 * @param resultSetConcurrency
	 * @param resultSetHoldability
	 * @return
	 * @throws SQLException
	 */
	public static PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		return TransactionManager.prepareStatement(sql, columnNames);
	}

	/**
	 * 現在のトランザクション上にあるDBコネクションを取得する
	 *
	 * @return 現在のトランザクション上にあるDBコネクション
	 * @exception IllegalStateException
	 *                現在の処理がトランザクション内にない場合
	 */
	public static Connection getConnection() {
		return TransactionManager.getCurrentConnection();
	}

	/**
	 * 現在のトランザクション上にあるDBコネクションを取得するのに使用したドライバクラス名を取得する。
	 * <p>
	 * 接続先DBを判別するのに使用する。
	 * </p>
	 *
	 * @return 現在のトランザクション上にあるDBコネクションを取得するのに使用したドライバクラス名
	 */
	public static String getDriverName() {
		return TransactionManager.getCurrentConnectionDriverName();
	}

	/**
	 * 現在のトランザクションについて、例外を浮揚せずにトランザクションの終了まで処理が正常に完了した場合に、 変更をロールバックするように予約をする
	 * <p>
	 * 呼出し元のトランザクションを継承（TAKEOVER）している場合は、呼出し元の トランザクションについてのロールバック予約となる。
	 * </p>
	 */
	public static void reserveRollback() {
		TransactionManager.reserveRollback();
	}

	/**
	 * 現在のトランザクションを強制的にコミットする
	 *
	 * @throws SQLException
	 */
	public static void commitForce() throws SQLException {
		TransactionManager.commitForce();
	}

	/**
	 * 現在のトランザクションを強制的にロールバックする
	 *
	 * @throws SQLException
	 */
	public static void rollbackForce() throws SQLException {
		TransactionManager.rollbackForce();
	}

	/**
	 * インターセプター間でデータをやり取りするためのオブジェクトを取得する
	 *
	 * @return インターセプター間でデータをやり取りするためのオブジェクト
	 */
	public static InterceptorContext getInterceptorContext() {
		return InterceptorContext.getInstance();
	}

	/**
	 * 新規のトランザクションを開始する
	 * <p>
	 * 本メソッドで開始したトランザクションは、commitTransaction、rollbackTransactionを呼び出して必ず終了させること。
	 * </p>
	 *
	 * @param DB設定のルックアップ名
	 */
	public static void startTransaction(String lookupName) throws ConnectionInstantiationException {
		TransactionManager.startTransaction(lookupName);
	}

	/**
	 * 新規のトランザクションを開始する。
	 * <p>
	 * 既に同一のルックアップ名のトランザクションが開始済みであれば、そのトランザクションを継続、再開する。</br>
	 * 実行時に本トランザクションで新規のトランザクションが始まらなかった場合でも、commitTransaction、rollbackTransactionを呼び出してこのメソッドの呼び出して開始したトランザクションは終了させること。
	 * </p>
	 *
	 * @param DB設定のルックアップ名
	 */
	public static void takeoverTransaction(String lookupName) throws ConnectionInstantiationException {
		TransactionManager.takeoverTransaction(lookupName);
	}

	/**
	 * 現在のトランザクションをコミットして終了する。
	 */
	public static void commitTransaction() throws SQLException {
		TransactionManager.commitTransaction(true);
	}

	/**
	 * 現在のトランザクションをロールバックして終了する。
	 */
	public static void rollbackTransaction() throws SQLException {
		TransactionManager.rollbackTransaction(true);
	}
}