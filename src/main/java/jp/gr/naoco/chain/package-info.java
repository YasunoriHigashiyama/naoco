/**
 * naoco（Newgeneration Aspect Oriented Compact Objects）のProducer-Consumerパターン実現支援パッケージです。
 * <p>
 * laol.chainでは以下の機能を保有するライブラリを提供します。
 * </p>
 * <ul>
 * <li>Producer、Consumer、およびConsumerProducerのスーパークラス</li>
 * <li>上記のサブクラスを連結して実行する機能</li>
 * </ul>
 * <p>
 * 本パッケージの{@link jp.gr.naoco.chain.Factory}でインスタンスを生成した場合、DBトランザクション境界の設定と インターセプターの実行について
 * {@link jp.gr.naoco.core}パッケージに依存します。
 * </p>
 * <p>
 * naocoのProducer-Consumerパターン支援機能を利用する場合、本パッケージとその配下のパッケージのクラス群の中で、以下のクラスを主に使用します。
 * </p>
 * <ol>
 * <li>{@link jp.gr.naoco.db.chain.Producer}、
 * {@link jp.gr.naoco.db.chain.ConsumerProducer}、
 * {@link jp.gr.naoco.db.chain.Consumer}のサブクラスを定義する。</li>
 * <li>{@link jp.gr.naoco.chain.Chain}で上記サブクラスを連結し、処理を実行する。</li>
 * </ol>
 * <p>
 * {@link jp.gr.naoco.db.chain.Producer}、
 * {@link jp.gr.naoco.db.chain.ConsumerProducer}内で呼び出したofferメソッドにより、
 * {@link jp.gr.naoco.chain.Chain}で接続した次の{@link jp.gr.naoco.db.chain.Consumer}あるいは
 * {@link jp.gr.naoco.db.chain.ConsumerProducer}のexecuteメソッドを実行します。<br>
 * Chainで接続する要素は、先頭は必ずProducerで末端はConsumerでなければなりません。中間のConsumerProducerは何個でも接続できます。<br>
 * Producerは任意の回数offerメソッドを呼び出します。後続のConsumer、あるいはConsumerProducerは前の要素が呼び出したofferの回数だけexecuteが呼び出され、
 * 前の要素から渡されたContainerを「消費」します。ConsumerProducerはexecuteメソッド内で前述した前要素から渡されたContainerの消費と同時に、次の要素へ渡す Containerを生産します。<br>
 * Chainで接続するProducer、ConsumerProducer、Consumerの接続方法には以下の3つがあります。
 * </p>
 * <ul>
 * <li><b>direct</b>:offerの呼出しにより、次のConsumer、あるいはConsumerProducerのexecuteを直接呼出します。offer呼出しが完了し呼出し元に処理が戻った時は、次のConsumer、
 * あるいはConsumerProducerのexecuteメソッドが完了したことを意味します。</li>
 * <li><b>sequential</b>:Producerのexecuteメソッドの完了後、ConsumerProducerについてはその前にあるProducerが最後のoffer呼出しによるexecuteを実行後に、
 * offerの呼び出しで指定したContainerのキューを、同一スレッドで次のConsumer、あるいはConsumerProducerが一件ずつexecuteを実行して「消費」します。</li>
 * <li><b>parallel</b>:Producer、あるいはConsumerProducerのexecuteメソッドと並行して、次のConsumer、あるいはConsumerProducerを別スレッドで
 * offerにより渡されたContainerをexecuteメソッドにより「消費」します。Consumerの消費がProducerの生産より遅い場合、Containerは一定数までキューに貯められますが、
 * 一定数を超えるとofferメソッド内部でスレッドをwaitをしてキューの消費を待ちます。逆にConsumerの消費がProducerの生産より早い場合、次のProduerの呼出されるまで、
 * Consumerのexecute呼出しがwaitとなります。</li>
 * </ul>
 * <p>
 * 上記３つの接続方法について、要素内でoffer呼出し後に指定したContainerの内容を変更しない限りは、機能的な差異はありません。<br>
 * 利用者は利用状況に合わせて適切な接続方法を選択する必要があります。
 * </p>
 *
 * @author naoco0917
 */
package jp.gr.naoco.chain;
