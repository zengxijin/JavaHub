package com.jack.design.pattern;

import com.jack.design.pattern.provider.MySqlProvider;
import com.jack.design.pattern.staticfactory.Service;
import com.jack.design.pattern.staticfactory.Services;

public class App 
{
    public static void main( String[] args )
    {
        Services.registerProvider("MySql", new MySqlProvider());
        
        Service serv = Services.newInstance("MySql");
        System.out.println(serv.service());
    }
}
