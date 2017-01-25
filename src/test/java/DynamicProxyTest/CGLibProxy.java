package DynamicProxyTest;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibProxy implements MethodInterceptor{
	
	public <T> T getInstance(Class<T> cls){
		return (T) Enhancer.create(cls, this);
	}

	@Override
	public Object intercept(Object obj, Method arg1, Object[] args, MethodProxy methodproxy) throws Throwable {
		before();
		Object result = methodproxy.invokeSuper(obj, args);
		after();
		return result ;
	}
	public void before(){
		System.out.println("CGLibProxy proxy before method executed.");
	}
	public void after(){
		System.out.println("CGLibProxy proxy after method executed.");
	}
	public <T> T getProxy(Class<T> cls){
		return (T) Enhancer.create(cls, this);
	}

}
