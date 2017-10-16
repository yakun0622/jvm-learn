/*
* Copyright (c) 2017 Hinew. All Rights Reserved.
 * ============================================================================
 * 版权所有 海牛(上海)电子商务有限公司，并保留所有权利。
 * ----------------------------------------------------------------------------
 * ----------------------------------------------------------------------------
 * 官方网站：http://www.hinew.com.cn
 * ============================================================================
*/

/**
 *  创建线程导致内存溢出异常
 *  VM Args: -Xss2M
 * @author wangyakun
 * @email yakun0622@gmail.com
 * @date 2017/10/17 00:17
 */
public class JavaVMStackOOM {
    private void dontStop(){
        while (true){

        }
    }
    private void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
