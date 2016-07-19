public class J015_canReliveObj {
	public static J015_canReliveObj obj;
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("J015_canReliveObj finalize called");
		obj = this;
	}
	public static void main(String[] args) throws InterruptedException{
		obj = new J015_canReliveObj();
		obj = null;
		System.gc();
		Thread.sleep(1000);
		System.out.println(obj == null ? "is null" : "not null");
		System.out.println("second gc");
		obj = null;
		System.gc();
		Thread.sleep(1000);
		System.out.println(obj == null ? "is null" : "not null");
	}
}
