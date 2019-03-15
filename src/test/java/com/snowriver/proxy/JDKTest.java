package com.snowriver.proxy;

import com.snowriver.proxy.jdk.Customer;
import com.snowriver.proxy.jdk.JDKMeiPo;
import com.snowriver.proxy.jdk.Person;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class JDKTest {

    @Test
    public void TestJDK() throws IOException {
        Person person = (Person) new JDKMeiPo().getInstance(new Customer());
        person.findLove();

        //通过反编译工具可以查看源代码
        byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
        FileOutputStream os = new FileOutputStream("D://$Proxy0.class");
        os.write(bytes);
        os.close();
    }

}