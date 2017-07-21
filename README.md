# naoco
naoco(New generation Aspect Oriented Compact Objects) - as Java model-layer framework project

# history
2017.07.22 Ver.0.0.01 初版作成

# current progress
Ver.0.0.01
最低限の機能を実装しています。
現在の実装でも、商用アプリケーションの使用に耐えうる品質と性能を有していますが、今後の機能追加、処理改善により、パッケージとクラス構成が変更になる可能性があります。
マニュアル、ドキュメントを準備中です。

# about naoco
naoco(New generation Aspect Oriented Compact Objects)は、MVCモデルアプリケーションのモデル層フレームワークです。
JDK1.7に対応しています。
以下の処理を対象としています。
・トランザクション管理機能：ロジックのトランザクションをスレッド単位で管理します。利用者はトランザクションに紐づくRDBMS接続などのリソース管理から開放されます。
・基本的なORMapper機能：JavaBeans形式のEntityオブジェクトと、RDBMSから取得したResultSet、およびシンプルなINSERT,UPDATE,DELETE文の紐付けを行います。
                     また、主キー検索のSELECT、UPDATE,DELETE,およびINSERTはEntityオブジェクトから自動生成をします。
・SQLテンプレート機能：複雑なSQL文のレンダリングをJava実装から分離した別のファイルからの読み込みを標準とし、PreparedStatementの使用を強制します。
・Producer-Consumerフレームワーク：マルチスレッドパターンのProducer-Consumerパターンのフレームワークを実装しています。
　　　　　　　　　　　　　　　　　　　naocoでは、シンプルなProducer-Consumerパターンのみではなく、中間処理を任意にProducerとConsumerの間に挟み込む機能も実装しています。
　　　　　　　　　　　　　　　　　　　これにより、高度な処理の部品化と再利用化が可能となります。

# development policy
・シンプルかつ統制のとれたソースコード記述を目標とし、ソースコードの高い可読性を維持します。
・ユーザが使用するクラスはFacadeパターンを使用するなどの対応で最小限にとどめ、導入を容易なものとします。
・実装する機能は必要最小限に絞り、ユーザに拡張性を提供することで、フレームワークとしての価値を高めます。
・基本機能はJDKライブラリ以外のライブラリに依存しません。外部ライブラリに依存または連携する処理は、jp.gr.naoco.externalパッケージ配下に集約します。

EOF
