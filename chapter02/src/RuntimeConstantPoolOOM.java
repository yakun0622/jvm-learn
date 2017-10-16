/*
* Copyright (c) 2017 Hinew. All Rights Reserved.
 * ============================================================================
 * 版权所有 海牛(上海)电子商务有限公司，并保留所有权利。
 * ----------------------------------------------------------------------------
 * ----------------------------------------------------------------------------
 * 官方网站：http://www.hinew.com.cn
 * ============================================================================
*/

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致的内存溢出异常
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author wangyakun
 * @email yakun0622@gmail.com
 * @date 2017/10/17 00:27
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        // 使用List保持着常量池引用,避免Full GC回收常量池行为
        List<String> list = new ArrayList<>();
        // 10MB的PerSize 在 Integer 范围内足够产生OOM了
        int i = 0;
        while (true) {
            System.out.println("add......");
            list.add(String.valueOf(i++).intern());
        }
    }
}
