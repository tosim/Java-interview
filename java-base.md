# Java 基础

## Java内部类
### 1.静态内部类
1.静态内部类可以访问外部类的所有静态属性和静态方法，包括私有的  

### 2.成员内部类
1.不能声明静态属性和静态方法，static只能用在final的静态属性的声明上  
2.成员内部类可以访问外部类的所有方法和属性  
3.实例化内部类的时候必须用一个外部类的实例去实例化 *

## Java调用过程
1.调用父类的静态部分(静态代码块或者声明时实例化的属性，按照定义顺序执行)  
2.调用子类的静态部分(同上)  
3.调用父类的普通代码块  
4.调用父类构造方法  
5.调用子类普通代码块  
6.调用子类构造方法  


## Java单例模式（静态内部类实现）
```
public class Singleton {
    private static class LazyHolder {
        private static final Singleton INSTENCE = new Singleton();
    }

    private Singleton (){
    }

    public static final Singleton getInstance() {
        return LazyHolder.INSTENCE;
    }
}
```

## final
1. 数据  
  基本类型：值不变  
  引用类型：不能指向其他对象，但对象本身能够改变

2. 方法
  final方法不能被覆盖，只能被重载

3. 类  
  声明类不能被继承
  
## static
父类的static变量和static方法能被子类继承，但不能被覆盖，即无法实现父类的引用调用子类对象的静态方法（多态），子类中与父类同名的静态方法将隐藏父类的静态方法。

1. 静态变量  
  内存中只存在一份，加载改类时初始化一次，所有实例共享

2. 静态方法  
  静态方法不能被子类覆盖，即不能实现静态方法的多态。

3. 静态语句块  
  类加载时执行一次
  
4. 静态内部类  
  不依赖外部类，且不能访问外部类的非static方法和变量

5. 静态导包  
  import static xxx，避免重复写某个静态方法或静态类的前缀
  
6. 变量赋值的顺序  
1.父类静态变量和静态代码块（按照定义顺序执行）  
2.子类静态变量和静态代码块（按照定义顺序执行）  
3.父类实例变量和普通代码块（按照定义顺序）  
4.父类构造器  
5.子类实例变量和普通代码块（按照定义顺序）  
6.子类构造器  

## Object 方法
1. getClass  
  获得对象的Class类型

2. hashCode  
  在没有重写时由内存地址确定  
  相同的两个对象hash值一定相同（引用类型相同，指向同一个对象）  
  hash值相同的实例不一定等价（引用类型不一样，指向同一个对象，父层的引用无法调用子类的特有方法）

3. equals  
  1.基本数据类型用==比较，基本类型没有equals方法  
  2.对于引用类型用==判断两个引用是否指向同一个对象，用equals判断引用的对象是否等价。  

4. clone  
  在调用clone方法时必须实现Cloneable接口，否则会抛出CloneNotSupportException异常  
  实现Cloneable时调用的clone方法已经是深拷贝，（直接在开辟新的内存，并将内容拷贝过去）
 
5. finalize  
  GC在回收对象之前调用该方法，用于确保*内存资源*的清理工作，不建议做非内存资源的清理  
  
## 抽象类和接口
1. 抽象类可以包含非抽象方法，接口只能包含抽象方法
2. 抽象类可以包含任意的成员变量，接口只能包含public static final类型的成员变量
3. 抽象类中的方法的访问权限没有限制，接口的方法只能是public的
4. 抽象类可以有静态方法，接口不能有
5. 抽象类可以有构造方法，但是不能实例化
6. 抽象类中的抽象方法不能用static，sychronized，native修饰

## super和this
1. super可以用来访问父类的构造方法和被子类覆盖的父类方法
2. this指向本对象


## String、StringBuffr、StringBuilder
1. String 是不可变类，底层为final的char数组
2. StringBuffer、StringBuilder是可变类
3. StringBuffer内部通过sychronized实现同步
4. String,intern方法返回指向同一字符串的常量池中的对象

## 基本类型与包装类型
1. 集合类型Collection时就一定要使用包装类型而非基本类型
2. 基本类型是直接将变量值存储在堆栈中，而包装类型是将对象放在堆中，然后通过引用来使用
3. 基本类型的初始值如int为0，boolean为false，而包装类型的初始值为null
4. 当使用new创建时与其他类一样，在堆中创建一个新对象，各种比较也是按照引用类型的比较规则
5. 除了Float和Double，其他包装类本身都维护了-128～127之间的一个常量池，对于这个范围的值，都指向常量池中同一个对象
6. Integer.valueOf会首先判断值是否在常量池范围，在范围中直接返回指向常量池对象的引用，超范围的再用new创建;
7. Integer a = 1,自动装箱，会调用Integer.valueOf方法

## try、catch、finally中的return
1. finaly中的return会覆盖try和catch中的return
2. 在try或者catch中return时，会先保存好要return的结果，再执行finaly的代码（如果finaly中没有return），最后返回刚刚保存的结果
3. System.exit(code)和thread.setDaemon(true);(作为守护进程的线程在没有其他用户线程时，JVM会kill掉守护进程)

## 异常
Throwable分为Error（JVM无法处理的错误）和Exception（受检异常和非受检异常（RuntimeException））



## 泛型
1. Java 的泛型在编译之后是去泛型化的
2. Java中集合的泛型是防止错误输入的，只在编译阶段有效
3. 可以通过反射方法添加不同类型的元素

## 反射
>**这里假设c是某个类的类类型**

### Class
1. 类是java.lang.Class的实例对象,可以用类名.class 或对象.getClass()方法获取Class类型或者Class.forName("类的全限定名")
2. 可以通过c.newInstance()创建该类的实例
3. new 是静态加载类，如果可能用到的某个类不存在，就会编译报错。Class.forName()是动态加载类，运行时加载类，编译时不报错。

### 反射api
#### 类类型api
1. String cName = c.getName();
2. Method[] methods = c.getMethods();	//获取所有public的方法，包括父类中继承来的
3. Method[] methods = c.getDeclaredMethods();	//获取所有该类的方法，不问访问权限

#### Method的api
1. Class returnType = method.getReturnType();	//获取方法的返回类型的类类型
2. Class[] paramClasses = method.getParameterTypes();	//获取方法参数列表类型的类类型
3. method.invoke(instance,param1,param2,...);		//方法反射，调用instance的method方法

#### Field的api
1. Field[] fields = c.getFields();		//获取所有public的成员变量
2. Field[] fields = c.getDeclaredFields();	//获取该类所有的成员变量，不问访问权限
3. Class fieldType = field.getType();		//获取成员变量的类类型
4. String fieldName = field.getFieldName(); //获取成员变量的名字

#### Constructor的api
1. Constructor[] cons = c.getConstructors();	//获取所有public的构造方法
2. Constructor[] cons = c.getDeclaredConstructs();	//获取该类所有的构造方法，不问访问权限
3. Class[] paramTypes = consructor.getParameterTypes();	//获取构造函数的参数列表的类类型

## 注解
用处：  
1. 生成文档(@param，@return)
2. 代替配置文件(@Configuration)
3. 编译时检查（@Override）

原理：
1. Java使用Annotation接口来代表程序元素前面的注解，该接口是所有Annotation类型的父接口
2. AnnotatedElement接口，该接口代表程序中可以接受注解的程序元素，该接口主要有如下几个实现类：  
　　Class：类定义  
　　Constructor：构造器定义  
　　Field：累的成员变量定义  
　　Method：类的方法定义  
　　Package：类的包定义  
3. 通过反射获取程序元素，再通过程序元素获取注解时，返回的是注解的动态代理对象$Proxy1。通过注解的代理对象获取注解的信息时，会最终调用AnnotationInvicationHandler的invoke方法，从memberValuesMap中索引出对应的值，该map来源于Java常量池（引用位于方法区）。

使用：
1. @Target说明了Annotation所修饰的对象范围
2. @Retention定义了该Annotation被保留的时间长短
3. @Inherited作用是，使用此注解声明出来的自定义注解，在使用此自定义注解时，如果注解在类上面时，子类会自动继承此注解，否则的话，子类不会继承此注解。这里要注意，使用@Inherited声明出来的注解，只有在类上使用时才会有效，在方法，属性等其他程序元素上注解无效
4. @Documented用于生成注解的文档


### Collection和Collections
1. Collection 是集合的接口，提供了集合的基本操作的接口
2. Collections 是一个工具类，包装了许多操作集合的静态方法。


### 解决hash冲突
1. 开放地址法：  
  线性探测再散列：每次向后移动一个位置  
  二次探测再散列：每次移动k * k或-k * k个位置  
  伪随机探测再散列：每次移动伪随机数个位置   
2. 再hash法：  
  有多个hash函数，第二次调用不同的hash函数  
3. 链地址法：  
  将hash值有冲突的元素挂在同一个链表上（考虑将链表优化成树结构）
4. 建立公共溢出区：  
  新建一张溢出表，查找时若未在原表上找到，则在溢出表上顺序查找
  
### 排序算法
排序算法|时间复杂度|空间复杂度|稳定性
-|-|-|-
冒泡排序|O(n^2)|O(n)|稳定
选择排序|O(n^2)|O(n)|不稳定
插入排序|O(n^2)|O(n)|不稳定
希尔排序|O(nlogn)|O(n)|不稳定
堆排序|O(nlogn)|O(n)|不稳定
归并排序|O(nlogn)|O(nlogn)|稳定


























