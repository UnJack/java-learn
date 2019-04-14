package com.java.base.jvm;

/**
 * Created by jian.jie on 2016/11/16.
 * http://ifeve.com/a-simple-example-demo-jvm-allocation-and-gc/
 */
public class test_Gc {

    public static void main(String[] args) {
        demo();
    }

    public static void demo() {
        final int tenMB = 10 * 1024 * 1024;
        byte[] alloc1, alloc2, alloc3;
        alloc1 = new byte[tenMB / 5];
        alloc2 = new byte[5 * tenMB];
        alloc3 = new byte[4 * tenMB];
        alloc3 = null;
        alloc3 = new byte[6 * tenMB];
    }
    //MaxTenuringThreshold 默认15
    //-verbose:gc -Xms200M -Xmx200M -Xmn100M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+PrintTenuringDistribution
    //-verbose:gc -Xms200M -Xmx200M -Xmn100M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
}
/*
[GC (Allocation Failure)
Desired survivor size 10485760 bytes, new threshold 7 (max 15)
[PSYoungGen: 59801K->3326K(92160K)] 100761K->95494K(194560K), 0.0326683 secs] [Times: user=0.06 sys=0.00, real=0.03 secs]
[Full GC (Ergonomics) [PSYoungGen: 3326K->0K(92160K)] [ParOldGen: 92168K->54323K(102400K)] 95494K->54323K(194560K), [Metaspace: 3238K->3238K(1056768K)], 0.0149041 secs] [Times: user=0.05 sys=0.00, real=0.02 secs]
Heap
 PSYoungGen      total 92160K, used 62259K [0x00000000f9c00000, 0x0000000100000000, 0x0000000100000000)
  eden space 81920K, 76% used [0x00000000f9c00000,0x00000000fd8cce50,0x00000000fec00000)
  from space 10240K, 0% used [0x00000000fec00000,0x00000000fec00000,0x00000000ff600000)
  to   space 10240K, 0% used [0x00000000ff600000,0x00000000ff600000,0x0000000100000000)
 ParOldGen       total 102400K, used 54323K [0x00000000f3800000, 0x00000000f9c00000, 0x00000000f9c00000)
  object space 102400K, 53% used [0x00000000f3800000,0x00000000f6d0cdf0,0x00000000f9c00000)
 Metaspace       used 3246K, capacity 4494K, committed 4864K, reserved 1056768K
  class space    used 350K, capacity 386K, committed 512K, reserved 1048576K
* */