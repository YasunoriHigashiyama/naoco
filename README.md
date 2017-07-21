# naoco
naoco(New generation Aspect Oriented Compact Objects) - as Java model-layer framework project

# history
2017.07.22 Ver.0.0.01 β版 初版作成

# current progress
<p>
Ver.0.0.01
</p>
<p>
β版（ベータ版）です。
</p>
<p>
最低限の機能を実装しています。<br/>
現在の実装でも、商用アプリケーションの使用に耐えうる品質と性能を有していますが、今後の機能追加、設計改善により、パッケージとクラス、およびクラス内のメソッドの構成と名称が変更になる可能性があります。<br/>
マニュアル、ドキュメントを準備中です。<br/>
</p>

# about naoco
<p>
naoco(New generation Aspect Oriented Compact Objects)は、MVCモデルアプリケーションのモデル層フレームワークです。
</p>
<p>
JDK1.7に対応しています。
</p>
naocoは主に以下の機能を提供します。
<table>
  <tr>
    <td>トランザクション管理機能</td>
    <td>ロジックのトランザクションをスレッド単位で管理します。利用者はトランザクションに紐づくRDBMS接続などのリソース管理から開放されます。</td>
  </tr>
  <tr>
    <td>基本的なORMapper機能</td>
    <td>JavaBeans形式のEntityオブジェクトと、RDBMSから取得したResultSet、およびシンプルなINSERT文、UPDATE文、DELETE文の紐付けを行います。</br>また、主キー検索によるSELECT、UPDATE、DELETE、およびINSERTはEntityオブジェクトから自動生成をします。</td>
  </tr>
  <tr>
    <td>SQLテンプレート機能</td>
    <td>複雑なSQL文のレンダリングをJava実装から分離した別のファイルからの読み込みを標準とし、PreparedStatementの使用を強制します。
  </tr>
  <tr>
    <td>Producer-Consumerフレームワーク</td>
    <td>マルチスレッドパターンのProducer-Consumerパターンのフレームワークを実装しています。</br>naocoでは、シンプルなProducer-Consumerパターンのみではなく、中間処理を任意にProducerとConsumerの間に挟み込む機能も実装しています。</br>これにより、高度な処理の部品化と再利用化が可能となります。
    </td>
  </tr>
</table>

# development policy
<ul>
  <li>シンプルかつ統制のとれたソースコード記述を目標とし、ソースコードの高い可読性を維持します。
  <li>ユーザが使用するクラスはFacadeパターンを使用するなどの対応で最小限にとどめ、導入を容易なものとします。
  <li>実装する機能は必要最小限に絞り、ユーザに拡張性を提供することで、フレームワークとしての価値を高めます。
  <li>基本機能はJDKライブラリ以外のライブラリに依存しません。外部ライブラリに依存または連携する処理は、jp.gr.naoco.externalパッケージ配下に集約します。
</ul>

EOF
