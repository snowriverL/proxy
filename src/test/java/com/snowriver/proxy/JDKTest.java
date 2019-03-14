package com.snowriver.proxy;

import com.snowriver.proxy.jdk.Customer;
import com.snowriver.proxy.jdk.JDKMeiPo;
import com.snowriver.proxy.jdk.Person;
import org.junit.Test;

public class JDKTest {

    @Test
    public void TestJDK() {
        Person person = (Person) new JDKMeiPo().getInstance(new Customer());
        person.findLove();
    }

}