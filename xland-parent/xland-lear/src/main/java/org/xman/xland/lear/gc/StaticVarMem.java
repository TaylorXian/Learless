package org.xman.xland.lear.gc;

public class StaticVarMem {

	public static int i = 0;
	public static SomeObj so = new SomeObj();

	public static void main(String[] args) {
		System.out.println("static i = " + i);
		System.out.println("static so.i = " + so.i);
		System.out.println("exit.");
		try {
			Thread.sleep(10 * 60 * 1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class SomeObj {
	public int i = 1;
}