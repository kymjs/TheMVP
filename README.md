[![OSL](http://www.kymjs.com/image/logo_s.png)](http://www.kymjs.com/works/)
=================

## TheMVP简介
An Android MVP Architecture Diagram Framwork.      
怎样从架构级别去搭建一个APP，怎样让他应对日益更改的界面与业务逻辑？        
越小的类，bug越不容易出现，越容易调试，更容易测试，我相信这一点大家是都赞同的。在MVP模式下，View和Model是完全分离没有任何直接关联的(比如你在View层中完全不需要导Model的包，也不应该去关联它们)。      
使用MVP模式能够更方便的帮助Activity(或Fragment)职责分离，减小类体积，使项目结构更加清晰。           
你可以查看wiki中的简介：[https://github.com/kymjs/TheMVP/wiki/TheMVP-cn](https://github.com/kymjs/TheMVP/wiki/TheMVP-cn)    
或者查看我博客中详细介绍：[http://www.kymjs.com/code/2015/11/09/01/](http://www.kymjs.com/code/2015/11/09/01/)     

## 使用 

####AndroidStudio
build.gradle中添加：
  
```
dependencies {
    compile 'com.kymjs.frame:framework:1.0.2'
}
```

####eclipse
复制jar包 [TheMVPxxx.jar](https://github.com/kymjs/TheMVP/tree/master/binrary) 到你工程的/libs目录中.   

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
