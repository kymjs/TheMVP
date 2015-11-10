怎样从架构级别去搭建一个APP，怎样让他应对日益更改的界面与业务逻辑？        
越小的类，bug越不容易出现，越容易调试，更容易测试，我相信这一点大家是都赞同的。在MVP模式下，View和Model是完全分离没有任何直接关联的(比如你在View层中完全不需要导Model的包，也不应该去关联它们)。      
使用MVP模式能够更方便的帮助Activity(或Fragment)职责分离，减小类体积，使项目结构更加清晰。       

##TheMVP原理介绍
TheMVP使用Activity作为Presenter层来处理代码逻辑，通过让Activity包含一个ViewDelegate对象来间接操作View层对外提供的方法，从而做到完全解耦视图层。如下图：    
![TheMVP架构图](http://kymjs.com/images/blog_image/20151029_1.png)     

##TheMVP代码说明
要将Activity作为Presenter来写，需要让View变得可复用，必须解决的一个问题就是setContentView()如何调用，因为它是Activity(Fragment有类似)的方法。      
我们需要把视图抽离出来独立实现。可以定义一个接口，来限定View层必须实现的方法(这个接口定义，也就是View层的代理对象)，例如：

```java
public interface IDelegate {
    void create(LayoutInflater i, ViewGroup v, Bundle b);
    View getRootView();
}
```

首先通过inflater一个布局，将这个布局转换成View，再用getRootView()方法把这个View返回给Presenter层，让setContentView(view)去调用，这样就实现了rootView的独立。    
所以，在Presenter层，我们的实现应该是：

```java
protected void onCreate(Bundle savedInstanceState) {
    //获取到视图层对象
    IDelegate viewDelegate = xxx;
    //让视图层初始化(如果是Fragment，就需要传递onCreateView方法中的三个参数)
    viewDelegate.create(getLayoutInflater(), null, savedInstanceState);
    //拿到初始化以后的rootview，并设置content
    setContentView(viewDelegate.getRootView());
}
```

##让MVP变得好用

####使用泛型解耦
现在我们是实现了View与Presenter的解耦，在onCreate中包含了一个接口对象来实现我们固定的一些必须方法。但是又引入了问题：一些特定方法没办法引用了。比如某个界面的设值、控件的修改显示逻辑对Presenter层的接口，接口对象必须强转成具体子类才能调用。     
解决办法：可以通过泛型来解决直接引用具体对象的问题。比如我们可以在子类定义以后确定一个Presenter中所引用的Delegate的具体类型。例如： 

```java
public abstract class ActivityPresenter<T extends IDelegate> extends Activity {
    protected T viewDelegate;

    protected void onCreate(Bundle savedInstanceState) {
        viewDelegate = getDelegateClass().newInstance();
    }

    protected abstract Class<T> getDelegateClass();
}
```

这样我们在ActivityPresenter的继承类中就可以通过动态设置getDelegateClass()的返回值来确定Delegate的具体类型了。        

####利用变长数组构建View集合
由于Presenter在使用访问View的时候并不是直接调用，而是通过代理对象间接调用，如果我们在实现View层代码的时候有太多的控件需要被引用，可能就必须定义一大堆控件声明，会造成记忆负担。    
这时候显然通过id去记忆更方便一些。我们可以使用```SparseArray```它是由两个数组来替代Map操作的类(如果你还是不知道他是干嘛的，可以简单的当成HashMap)。    


##Sample
完整的Demo源码已经提交在了项目中，你可以运行名为demo的module。    
这里仅取一个简单的示例。首先是View层的实现    

```java
public class SimpleDelegate extends AppDelegate {
    @Override
    public int getRootLayoutId() {
        return R.layout.delegate_simple;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        TextView textView = get(R.id.text);
        textView.setText("在视图代理层创建布局");
    }

    public void setText(String text) {
        //get(id)等同于bindview(id)，从上文就可以看到了，get方法调用了bindview方法
        TextView textView = get(R.id.text);
        textView.setText(text);
    }
}
```

接着是Presenter层的实现

```java
/**
 * 在这里做业务逻辑操作，通过viewDelegate操作View层控件
 */
public class SimpleActivity extends ActivityPresenter<SimpleDelegate> implements OnClickListener {

    @Override
    protected Class<SimpleDelegate> getDelegateClass() {
        return SimpleDelegate.class;
    }

    /**
     * 在这里写绑定事件监听相关方法
     */
    protected void bindEvenListener() {
        viewDelegate.get(R.id.button1).setOnClickListener(this);
    }

    public void onClick(View v) {
        viewDelegate.setText("你点击了button");
    }
}
```