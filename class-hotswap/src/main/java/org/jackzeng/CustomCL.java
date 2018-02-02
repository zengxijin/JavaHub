package org.jackzeng;

import java.io.*;
import java.util.HashSet;
import java.util.stream.Stream;

/**
 * @author zengxj
 * @create 2018/2/2
 */
public class CustomCL extends ClassLoader {

    private String baseDir;
    private HashSet<String> dynamicClass;

    public CustomCL(String baseDir, String[] classes) {
        super(null); // set the parent ClassLoader to null

        this.baseDir = baseDir;
        this.dynamicClass = new HashSet<>();
        this.loadAll(classes);
    }

    private void loadAll(String[] classes) {
        Stream.of(classes)
                .forEach(name -> {
                    try {
                        loadDirectly(name);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    dynamicClass.add(name);
                });
    }

    private Class loadDirectly(String name) throws IOException {
        StringBuilder sb = new StringBuilder(baseDir);
        String classname = name.replace('.', File.separatorChar) + ".class";
        sb.append(File.separatorChar + classname);
        File classFile = new File(sb.toString());

        return this.instantiateClass(name, new FileInputStream(classFile), (int)classFile.length());
    }

    private Class instantiateClass(String name, InputStream in, int len) throws IOException {
        byte[] raw = new byte[len];
        in.read(raw);
        in.close();

        // load the class from .class file bytes
        return this.defineClass(name, raw, 0, raw.length);
    }

    protected Class loadClass(String name, boolean isResolve) throws ClassNotFoundException {
        // check if the class have been loaded before
        Class cls = this.findLoadedClass(name);

        if (cls == null && !this.dynamicClass.contains(name)) {
            cls = getSystemClassLoader().loadClass(name);
        }

        if (cls == null) {
            throw new ClassNotFoundException(name);
        }

        if (isResolve) {
            this.resolveClass(cls);
        }

        return cls;
    }


}
