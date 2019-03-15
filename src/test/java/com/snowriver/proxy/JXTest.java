package com.snowriver.proxy;

import com.snowriver.proxy.jdk.Customer;
import com.snowriver.proxy.jdk.JDKMeiPo;
import com.snowriver.proxy.jdk.Person;
import com.snowriver.proxy.jxjdk.JXMeiPo;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class JXTest {

    @Test
    public void TestJDK() throws IOException {
        Person person = (Person) new JXMeiPo().getInstance(new Customer());
        person.findLove();

    }

}