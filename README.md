[![OSL](https://kymjs.com/qiniu/image/logo3.png)](https://kymjs.com/works/)
=================

## TheMVP简介
越小的类，bug越不容易出现，越容易调试，更容易测试，我相信这一点大家是都赞同的。在MVP模式下，View和Model是完全分离没有任何直接关联的(比如你在View层中完全不需要导Model的包，也不应该去关联它们)。      
使用 MVP 模式能够更方便的帮助 Activity (或 Fragment )职责分离，减小类体积，使项目结构更加清晰。         

或者查看开源实验室中详细介绍：  
[https://kymjs.com/code/2015/11/09/01/](https://kymjs.com/code/2015/11/09/01/)

## 谁在使用

本项目已被`支付宝`使用，可查看设置->关于->版权信息。    

你也可以提交`Pull Request`告诉我你的 APP 使用了`TheMVP`

## 使用方式  

当前最新版本为：
[![](https://jitpack.io/v/kymjs/TheMVP.svg)](https://jitpack.io/#kymjs/TheMVP)

```
// root build.gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}

// module build.gradle
dependencies {
    implementation 'com.github.kymjs:themvp:2.0.0'
}
```  

## 开源协议
```
 Copyright (C) 2015, 张涛
 
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 ```
