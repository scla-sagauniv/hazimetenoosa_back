# hazimetenoosa_back

### API Doc
[https://scla-sagauniv.github.io/hazimetenoosa_back/dist/](https://scla-sagauniv.github.io/hazimetenoosa_back/dist/)

### set up

```bash
docker compose up -d
docker compose exec -it app /bin/bash
sh gradlew build --continuous
# 別タブ開く
docker compose exec -it app /bin/bash
sh gradlew bootRun
```
上の実行が終わったら、vscode開いて、`F5`を押す  
ブラウザで [http://localhost:8080/greeting](http://localhost:8080/greeting)を開いて`Hello, world!`が表示されれば成功