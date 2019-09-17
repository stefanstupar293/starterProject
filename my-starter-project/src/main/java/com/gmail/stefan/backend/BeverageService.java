package com.gmail.stefan.backend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;


/**
 * Simple backend service to store and retrieve {@link Category} instances.
 */
public class BeverageService {

    private Map<Long, Beverage> beverages = new HashMap<>();
	
    /**
     * Helper class to initialize the singleton Service in a thread-safe way and
     * to keep the initialization ordering clear between the two services. See
     * also: https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
     */
    private static class SingletonHolder {
        static final BeverageService INSTANCE = createDemoBeverageService();

        /** This class is not meant to be instantiated. */
        private SingletonHolder() {
        }

        private static BeverageService createDemoBeverageService() {                          // list fill for email, fname, lname 
            final BeverageService beverageService = new BeverageService();							

            for (int i = 0; i < 49; i++) {
				String beverage = StaticData.BEVERAGE.get(new Random().nextInt(StaticData.BEVERAGE.size()-1));
				String alc = StaticData.ALC.get(new Random().nextInt(StaticData.ALC.size()-1)) ;
            	
				beverageService.doSaveBeverage(new Beverage(beverage, alc));
			}
            
            return beverageService;
        }
    }
    
    private Map<Long, Beverage> beverage = new HashMap<>();
    private AtomicLong nextId = new AtomicLong(0);
    /**
     * Declared private to ensure uniqueness of this Singleton.
     */




    public void saveBeverage(Beverage beverage2) {												// save v2
    	doSaveBeverage(beverage2);
    }
    public Beverage doSaveBeverage(Beverage beverage2) {
    	Beverage entity = beverages.get(beverage2.getId());
    	
    	if (entity == null) {
//    		entity = new User(users2);
    		entity = new Beverage (beverage2.getBeverage(),beverage2.getAlc());
    		if (beverage2.getId()==null) {
    			entity.setId(nextId.incrementAndGet());
    		}
    		beverage.put(entity.getId(), entity);
    		
    	} else {
    		entity.setBeverage(beverage2.getBeverage());
    		entity.setAlc(beverage2.getAlc());
    		
    	}
    	return entity;
    }
    
    public static BeverageService getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    
//////////////////////////////////////////DELETE////////////////////////////////////
    public boolean deleteBeverage (Beverage beverage) {
        return beverages.remove(beverage.getId()) != null;
    }
    
    
    //find beverage by name and alcohol content								~ check here
    
    public List<Beverage> findBeverage (String searchtext) {
    	List<Beverage> beveragesMatching = beverage.values().stream()
    			.filter(beverages -> 	beverages.getBeverage().toLowerCase().contains(searchtext.toLowerCase()) ||
    					beverages.getAlc().contains(searchtext))
    			.collect(Collectors.toList());
    	
    			if (beveragesMatching.isEmpty()) {
    	            return beveragesMatching;
    	        }else 
    			return (beveragesMatching);
    }
    

}
