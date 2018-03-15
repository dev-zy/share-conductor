# css-conductor
1. gradle-wrapper.properties（\gradle\wrapper）
```properties
distributionBase=GRADLE_USER_HOME
distributionPath=\.gradle/wrapper/dists
zipStoreBase=GRADLE_USER_HOME
zipStorePath=\.gradle/wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-4.4-bin.zip
```
2. 启动server
```bash
./gradlew server   [Linux]
gradlew.bat server [windows]
```
启动访问：http://localhost:8080/
3. 安装node.js
4. 安装gradle
5. 启动watch
```bash
npm install –g gulp
npm install --save-dev gulp-install gulp babel
cd ui
gulp watch
```
