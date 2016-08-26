package com.jack.design_pattern.staticfactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Services {
	
	/**can't instantiation*/
	private Services(){}
	
	/**buffer to store providers */
	private static final Map<String,Provider> providers = new ConcurrentHashMap<String,Provider>();
	
	/**the default provider*/
	public static final String DEFAULT_PROVIDER_NAME = "<def_prdr_name>";
	
	public static void registerDefaultProvider(Provider provider){
		registerProvider(DEFAULT_PROVIDER_NAME,provider);
	}
	
	public static void registerProvider(String name,Provider provider){
		providers.put(name, provider);
	}
	
	/**return the default instance*/
	public static Service newInstance(){
		return newInstance(DEFAULT_PROVIDER_NAME);
	}
	
	/**return the specific provider */
	public static Service newInstance(String name){
		Provider p = providers.get(name);
		if( p == null ){
			throw new IllegalArgumentException(
					"no provider registered with name " + name);
		}
		
		return p.newService();
	}

}
