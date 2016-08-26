package com.jack.design_pattern;

import com.jack.design_pattern.provider.MySqlProvider;
import com.jack.design_pattern.staticfactory.Service;
import com.jack.design_pattern.staticfactory.Services;

public class App 
{
    public static void main( String[] args )
    {
        Services.registerProvider("MySql", new MySqlProvider());
        
        Service serv = Services.newInstance("MySql");
        System.out.println(serv.service());
    }
}
