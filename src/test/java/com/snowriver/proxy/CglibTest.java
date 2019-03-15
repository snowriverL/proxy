package com.snowriver.proxy;

import com.snowriver.proxy.cglib.CglibMeiPo;
import com.snowriver.proxy.cglib.Customer;
import org.junit.Test;

public class CglibTest {

    @Test
    public void TestJDK() throws Exception {
        Customer instance = (Customer)new CglibMeiPo().getInstance(Customer.class);
        instance.findLove();
    }

}