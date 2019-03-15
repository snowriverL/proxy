package com.snowriver.proxy.jxjdk;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class JXClassLoader extends ClassLoader {

    private File classPath;

    public JXClassLoader() {
        String path = JXClassLoader.class.getResource("").getPath();
        this.classPath = new File(path);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> clazz = null;
        String className = JXClassLoader.class.getPackage().getName() + "." + name;

        if (classPath == null) {
            return null;
        }

        File classFile = new File(classPath, name.replace("\\", "/") + ".class");
        if (!classFile.exists()) {
            return null;
        }
        FileInputStream in = null;
        ByteArrayOutputStream out = null;

        try {
            in = new FileInputStream(classFile);
            out = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) != -1){
                out.write(bytes, 0 ,len);
            }
            clazz = defineClass(className, out.toByteArray(), 0, out.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null != in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return clazz;

    }

}