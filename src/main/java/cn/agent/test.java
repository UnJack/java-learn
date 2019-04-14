package cn.agent;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by jian.jie on 2017/4/7.
 */
public class test {
    public static void main(String[] args) {
        File file = new File("d:/");
        File[] jars = file.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jar");
            }
        });
        final URL[] urls = new URL[jars.length];
        for (int i = 0; i < jars.length; i++) {
            try {
                urls[i] = jars[i].toURI().toURL();
            } catch (MalformedURLException e) {
                throw new RuntimeException("Fail to load plugin jars", e);
            }
        }
        List<TraceMetadataProvider> list = PluginLoader.load(TraceMetadataProvider.class, urls);
        System.out.println(list);
    }
}