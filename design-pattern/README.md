# design-pattern
## 代理模式

静态代理模式UML

![avatar](./pics/proxy.png)

相比于动态模式，比如JDK的InvocationHandler或者CGLIB的MethodInterceptor，区别就在于Proxy的这个代理类
的生成是在运行时动态生成的，而不像是静态代理模式时在编译器就绑定的。因此动态代理模式可以非常灵活的实现拦截
方法调用，并进行增强。
