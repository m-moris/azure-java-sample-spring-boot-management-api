# Spring BootでAzure REST APIを使い仮想マシンを操作するサンプル

Azure Management REST API をたたいて仮想マシンを操作するSpring Boot (Java)のWebアプリです。

簡易サンプルなので以下の機能のみの実装です。

+ サブスクリプションにある仮想マシン一覧の表示
+ 仮想マシンの停止 (Dellocate)
+ 仮想マシンの開始 (Start)

## 前提条件

+ JDK 10.0 or later
+ Azure サブスクリプション
+ Azure Command Line Tools (https://docs.microsoft.com/ja-jp/cli/azure/install-azure-cli?view=azure-cli-latest)

## 事前準備

サブスクリプションIDを確認します。

```
az login
az account show
```


`az ad sp` コマンドでサービスプリンシパルを作成します。
```
az ad sp create-for-rbac --name ServicePrincipalName --password PASSWORD
```

以下の出力が得られます。

```json
{
  "appId": "application id(client id)",
  "displayName": "ServicePrincipalName",
  "name": "http://ServicePrincipalName",
  "password": "client secret",
  "tenant": "XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX"
}
```

`src/main/resources/application.properties` を作成し、各値を設定します。

```
subscriptionId=<<set your subscription id>>
tenantId=<<set your tenant id>>
clientId=<<set your client id>>
clientSecret=<<set your client secret>>
```

## 実行

以下のコマンドを実行します。

```
mvn spring-boot:run
```

http://localhost:8080/ にアクセスすると、仮想マシン一覧が表示されるでしょう。


以上
