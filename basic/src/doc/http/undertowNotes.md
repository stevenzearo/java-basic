# Undertow Notes
> [java IO、NIO、AIO详解](https://www.cnblogs.com/sxkgeek/p/9488703.html)
## 阻塞与同步
### 1.阻塞(Block)和非租塞(NonBlock)
#### 1)阻塞(Block)
进程在访问数据的时候，数据没有准备时，一直等待
#### 2)非租塞(NonBlock)
进程在访问数据的时候，无论数据是否准备好都直接返回结果
### 同步(Synchronization)和异步(Async)
#### 同步
是应用程序要直接参与IO读写的操作。
#### 异步
所有的IO读写交给搡作系统去处理，应用程序只需要等待通知。
## BIO NIO AIO
1. 传统的 java.io包，它基于流模型实现，提供了我们最熟知的一些 IO 功能，比如 File 抽象、输入输出流等。交互方式是同步、阻塞的方式，也就是说，在读取输入流或者写入输出流时，在读、写动作完成之前，线程会一直阻塞在那里，它们之间的调用是可靠的线性顺序。
2. java.net下面提供的部分网络 API，比如 Socket、ServerSocket、HttpURLConnection 也归类到同步阻塞 IO 类库，因为网络通信同样是 IO 行为。

### IO
IO流简单来说就是input和output流，IO流主要是用来处理设备之间的数据传输，Java IO对于数据的操作都是通过流实现的，而java用于操作流的对象都在IO包中。
#### 分类
1. 字节流（Reader、Writer）
2. 字符流（InputStream、OutputStream）

![alt text](https://images2018.cnblogs.com/blog/1302135/201808/1302135-20180816173529402-760533731.png "Title")

3. Java Scanner类

### NIO
> [NIO原理详解](https://blog.csdn.net/charjay_lin/article/details/81810922)  
> [Java NIO vs. IO](http://tutorials.jenkov.com/java-nio/nio-vs-io.html)  
> [ NIO的Buffer&Channel&Selector](https://www.cnblogs.com/wade-luffy/p/8448655.html)