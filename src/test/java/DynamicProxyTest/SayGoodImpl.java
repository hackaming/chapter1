package DynamicProxyTest;

public class SayGoodImpl implements ISayGood{
	@Override
	public void sayGood() {
		System.out.println("Good morning, in SayGoodImpl");
	}
}
