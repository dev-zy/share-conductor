# css-conductor
## 1. gradle-wrapper.properties（\gradle\wrapper）
```properties
distributionBase=GRADLE_USER_HOME
distributionPath=\.gradle/wrapper/dists
zipStoreBase=GRADLE_USER_HOME
zipStorePath=\.gradle/wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-4.4-bin.zip
```
## 2. 启动server
```bash
./gradlew server   [Linux]
gradlew.bat server [windows]
```
启动访问：http://localhost:8080/
## 3. 安装node.js
## 4. 安装gradle
## 5. 启动watch
#### 1）方式一
```bash
cd ui

npm install gulp –g
npm install --save-dev gulp-install gulp babel
npm install gulp-env
npm install autoprefixer
npm install gulp-eslint
npm install rimraf
npm install browser-sync
npm install gulp-sourcemaps
npm install gulp-postcss
npm install postcss-nested
npm install postcss-simple-vars
npm install postcss-simple-extend
npm install cssnano
npm install gulp-imagemin
npm install imagemin-pngquant
npm install run-sequence
npm install gulp-gh-pages
npm install path
npm install child_process
npm install webpack
npm install webpack-dev-middleware
npm install webpack-hot-middleware
npm install fs
npm install lodash
npm install lodash.merge

gulp watch
```
需要改造js中import的ES6语法为ES5语法：
```javascript
import gulp from 'gulp';
```
为
```javascript
const gulp = require('gulp');
```
#### 2）方式二（已验证）
```bash
cd ui

npm install gulp@3.9.0 –g
npm install --save-dev gulp-install gulp@3.9.0 babel
npm install --save-dev babel-preset-es2015

gulp watch
```
#### 3）方式三
```bash
cd ui

npm install gulp –g
npm install --save-dev gulp-install gulp babel
npm install --save-dev babel-cli babel-preset-es2017

gulp watch
```
