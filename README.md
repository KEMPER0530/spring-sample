# SpringBootSample(2020/1/2)

書籍の検索、登録を実施するアプリです。
詳しくはこちらをご覧ください。<br>
<https://kemper0530.com/sample>

## 開発環境

- SpringBoot 2.0.3
- mysql Ver 5.7
- thymeleaf
- lombok Ver 1.18.4
- Docker にて開発環境構築

## 機能一覧

- ログイン(SpringSecurity を利用)
- 書籍検索
- 書籍 登録
- 書籍 編集・削除

## テスト

- 単体テスト(Junit Ver4)

## 本番環境

- AWS
- EC2(docker 構築し、nginx 経由でアプリにアクセスしています。DB も docker 上で起動させています。)
- Route53 でドメイン管理済
- ELB 経由で HTTPS 化しています

## 今後実装したいこと

- CI の導入、テスト、デプロイの自動化
- フロントを Vue.js を利用し、サーバー側とフロント側で分ける
- AWS のその他の機能使用(例：S3 上に画像ファイルを配置する等)
