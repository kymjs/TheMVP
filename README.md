[![OSL](http://cdn.kymjs.com/image/logo_s.png)](http://www.kymjs.com/works/)
=================

## TheMVP简介
An Android MVP Architecture Diagram Framwork.      
怎样从架构级别去搭建一个APP，怎样让他应对日益更改的界面与业务逻辑？        
越小的类，bug越不容易出现，越容易调试，更容易测试，我相信这一点大家是都赞同的。在MVP模式下，View和Model是完全分离没有任何直接关联的(比如你在View层中完全不需要导Model的包，也不应该去关联它们)。      
使用MVP模式能够更方便的帮助Activity(或Fragment)职责分离，减小类体积，使项目结构更加清晰。         

若您的项目使用了```databinding```，请使用```1.0.7```版本(代码见```databind```分支)。
   
或者查看我博客中详细介绍：[http://www.kymjs.com/code/2015/11/09/01/](http://www.kymjs.com/code/2015/11/09/01/)     

除了本仓库中的简单demo，你还可以看看在实际项目中的使用 [https://github.com/kymjs/CodeCafe](https://github.com/kymjs/CodeCafe)  

## 使用 

#### Android Studio
请使用```1.0.5```版本：  
  
```
dependencies {
    compile 'com.kymjs.core:themvp:1.0.5'
}
```  

#### 若使用 Databinding
build.gradle中添加：
  
```
dependencies {
    compile 'com.kymjs.core:themvp:1.0.7'
}
```  

##开源协议
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
