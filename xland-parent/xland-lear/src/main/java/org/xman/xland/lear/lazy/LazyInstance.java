package org.xman.xland.lear.lazy;

/**
 * Lazy instantiation.
 *
 * Created by xianjy on 2017/4/6.
 */
public class LazyInstance {
    private LazyInstance() {
        System.out.println(this.getClass().getName() + " instantiated.");
    }
    private static class InstanceHolder {
        private static LazyInstance instance = new LazyInstance();
    }

    public static LazyInstance getInstance() {
        return LazyInstance.InstanceHolder.instance;
    }

    public static void main(String[] args) {
        System.out.println("Program Start.");
        LazyInstance.getInstance();
        System.out.println("Program End.");
    }
}
