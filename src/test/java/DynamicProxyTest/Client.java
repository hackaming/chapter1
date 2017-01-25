package DynamicProxyTest;

public class Client {
	public static void main(String[] argv){
		CGLibProxy cgLibProxy = new CGLibProxy();
		
		ISayGood saygood = cgLibProxy.getInstance(new SayGoodImpl().getClass());
		ISayGood ss = new CGLibProxy().getInstance(new SayGoodImpl().getClass());
		ss.sayGood();
		saygood.sayGood();
	}
}
