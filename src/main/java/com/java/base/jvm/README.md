 #JVM
 * -verbose:gc -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 * -verbose:gc //打印详细信息
 * -Xms20M //初始堆大小
 * -Xmx20M //最大堆大小
 * -Xmn10M //年轻代大小
 * -XX:+PrintGCDetails //打印详细信息
 * -XX:SurvivorRatio=8 //eden和survior大小比例


 java探针技术
 http://blog.csdn.net/conquer0715/article/details/51774746

 JAVA_OPTS="
 -server
 -Xms2048m
 -Xmx2048m
 -XX:NewRatio=2 //新生代和老年代的默认值
 -XX:SurvivorRatio=8 //Eden区与Survivor区的大小比值，默认值
 -XX:MaxTenuringThreshold=15 //控制对象能经历多少次Minor GC才晋升到旧生代，默认值是15
 -XX:+HeapDumpOnOutOfMemoryError
 -XX:HeapDumpPath=/tmp/oom.log
 -XX:+UseConcMarkSweepGC //设置新生代收集器
 -XX:+UseParNewGC //设置年轻代为并行收集
 -XX:+CMSParallelRemarkEnabled //降低标记停顿
 -XX:CMSInitiatingOccupancyFraction=70 //cms作为垃圾回收使用70％后开始CMS收集
 -XX:+HeapDumpOnOutOfMemoryError //内存溢出存文件
 -XX:PretenureSizeThreshold //对象超过多大是直接在旧生代分配
 -XX:MaxTenuringThreshold //
 -XX:-PrintGCDetails
 -Xloggc:/var/logs/gc/gc.log
 -XX:-PrintGCDateStamps
 -XX:PrintGCApplicationStoppedTime
 -XX:-UseBiasedLocking
 -XX:+PrintSafepointStatistics
 -XX:PrintSafepointStatisticsCount=1"