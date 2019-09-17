package com.gmail.stefan.backend;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class StaticData {

    private static final String MINERAL_WATER = "Mineral Water";
    private static final String SOFT_DRINK = "Soft Drink";
    private static final String COFFEE = "Coffee";
    private static final String TEA = "Tea";
    private static final String DAIRY = "Dairy";
    private static final String CIDER = "Cider";
    private static final String BEER = "Beer";
    private static final String WINE = "Wine";
    private static final String OTHER = "Other";
    private static final String WHISKEY = "Whiskey";
    
    static final List<String> ALC = new ArrayList<String>();
    static {
    	Stream.of(	"Non-alcoholic",
    				"1%",
	    			"2%",
	    			"3%",
	    			"4%",
	    			"4,5%",
	    			"5%",
	    			"7%",
	    			"8,3%",
	    			"10%",
	    			"20%",
	    			"23%").forEach(e -> ALC.add(e));
    }
    
    static final List<String> EMAILS = new ArrayList<String>();
    static {
    	Stream.of("m235@hotmail.com",
    			"evaS2@gmail.com",
    			"random5@yahoo.com",
    			"d2easd@hotmail.com",
    			"johnyway@yahoo.com",
    			"aihjta2@gmail.com",
    			"ssaaw@gmail.com",
    			"foo2d@hotmail.com",
    			"stevo@hotmail.com",
    			"danyd@gmail.com",
    			"g2yd@yahoo.com",
    			"user12@hotmail.com").forEach(e -> EMAILS.add(e));
    }
    
    static final List<String> FNAMES = new ArrayList<String>();
    static {
    	Stream.of("Michael",
    			"Eva",
    			"Suzie",
    			"Delilah",
    			"John",
    			"Maria",
    			"Eduard",
    			"Dan",
    			"Stephen",
    			"Anna",
    			"Alex",
    			"Michell").forEach(f -> FNAMES.add(f));
    }
    
    
    static final List<String> LNAMES = new ArrayList<String>();
    static { 
    	Stream.of("Robbinson",
    			"Simpson",
    			"Jackson",
    			"Piper",
    			"Savage",
    			"Schneider",
    			"Reynolds",
    			"Hubbard",
    			"Wagner",
    			"Ramsey",
    			"Olsen",
    			"James").forEach(l -> LNAMES.add(l));
    }
    
    static final List<String> BEVERAGE = new ArrayList<String>();
    static {
    	Stream.of("Evian",
                "Voss",
                "Veen",
                "San Pellegrino",
                "Perrier",
                "Coca-Cola",
                "Fanta",
                "Sprite",
                "Maxwell Ready-to-Drink Coffee",
                "Nescafé Gold",
                "Starbucks East Timor Tatamailau",
                "Prince Of Peace Organic White Tea",
                "Pai Mu Tan White Peony Tea",
                "Tazo Zen Green Tea",
                "Dilmah Sencha Green Tea",
                "Twinings Earl Grey",
                "Twinings Lady Grey",
                "Classic Indian Chai",
                "Cow's Milk",
                "Goat's Milk",
                "Unicorn's Milk",
                "Salt Lassi",
                "Mango Lassi",
                "Airag",
                "Crowmoor Extra Dry Apple",
                "Golden Cap Perry",
                "Somersby Blueberry",
                "Kopparbergs Naked Apple Cider",
                "Kopparbergs Raspberry",
                "Kingstone Press Wild Berry Flavoured Cider",
                "Crumpton Oaks Apple",
                "Frosty Jack's",
                "Ciderboys Mad Bark",
                "Angry Orchard Stone Dry",
                "Walden Hollow",
                "Fox Barrel Wit Pear",
                "Budweiser",
                "Miller",
                "Heineken",
                "Holsten Pilsener",
                "Krombacher",
                "Weihenstephaner Hefeweissbier",
                "Ayinger Kellerbier",
                "Guinness Draught",
                "Kilkenny Irish Cream Ale",
                "Hoegaarden White",
                "Barbar",
                "Corsendonk Agnus Dei",
                "Leffe Blonde",
                "Chimay Tripel",
                "Duvel",
                "Pilsner Urquell",
                "Kozel",
                "Staropramen",
                "Lapin Kulta IVA",
                "Kukko Pils III",
                "Finlandia Sahti",
                "Johnny Walker",
        		"Jameson", 
        		"Jack Daniel's",
        		"Gentleman Jack",
        		"The Dead Rabbit",
        		"Chivas Regal",
        		"Jim Beam",
        		"Bad Dog",
        		"Old Crow",
        		"Diver",
        		"Jacob's Creek Classic Shiraz",
                "Chateau d’Yquem Sauternes",
                "Oremus Tokaji Aszú 5 Puttonyos").forEach(b -> BEVERAGE.add(b));
    }
     
    
    public static final String UNDEFINED = "Undefined";
    
    static final Map<String, String> BEVERAGES = new LinkedHashMap<>();

    static {
        Stream.of("Evian",
                "Voss",
                "Veen",
                "San Pellegrino",
                "Perrier")
                .forEach(name -> BEVERAGES.put(name, MINERAL_WATER));

        Stream.of("Coca-Cola",
                "Fanta",
                "Sprite")
                .forEach(name -> BEVERAGES.put(name, SOFT_DRINK));

        Stream.of("Maxwell Ready-to-Drink Coffee",
                "Nescafé Gold",
                "Starbucks East Timor Tatamailau")
                .forEach(name -> BEVERAGES.put(name, COFFEE));

        Stream.of("Prince Of Peace Organic White Tea",
                "Pai Mu Tan White Peony Tea",
                "Tazo Zen Green Tea",
                "Dilmah Sencha Green Tea",
                "Twinings Earl Grey",
                "Twinings Lady Grey",
                "Classic Indian Chai")
                .forEach(name -> BEVERAGES.put(name, TEA));

        Stream.of("Cow's Milk",
                "Goat's Milk",
                "Unicorn's Milk",
                "Salt Lassi",
                "Mango Lassi",
                "Airag")
                .forEach(name -> BEVERAGES.put(name, DAIRY));

        Stream.of("Crowmoor Extra Dry Apple",
                "Golden Cap Perry",
                "Somersby Blueberry",
                "Kopparbergs Naked Apple Cider",
                "Kopparbergs Raspberry",
                "Kingstone Press Wild Berry Flavoured Cider",
                "Crumpton Oaks Apple",
                "Frosty Jack's",
                "Ciderboys Mad Bark",
                "Angry Orchard Stone Dry",
                "Walden Hollow",
                "Fox Barrel Wit Pear")
                .forEach(name -> BEVERAGES.put(name, CIDER));

        Stream.of("Budweiser",
                "Miller",
                "Heineken",
                "Holsten Pilsener",
                "Krombacher",
                "Weihenstephaner Hefeweissbier",
                "Ayinger Kellerbier",
                "Guinness Draught",
                "Kilkenny Irish Cream Ale",
                "Hoegaarden White",
                "Barbar",
                "Corsendonk Agnus Dei",
                "Leffe Blonde",
                "Chimay Tripel",
                "Duvel",
                "Pilsner Urquell",
                "Kozel",
                "Staropramen",
                "Lapin Kulta IVA",
                "Kukko Pils III",
                "Finlandia Sahti")
                .forEach(name -> BEVERAGES.put(name, BEER));
        
        Stream.of("Johnny Walker",
        		"Jameson", 
        		"Jack Daniel's",
        		"Gentleman Jack",
        		"The Dead Rabbit",
        		"Chivas Regal",
        		"Jim Beam",
        		"Bad Dog",
        		"Old Crow",
        		"Diver")
        		.forEach(name -> BEVERAGES.put(name, WHISKEY));
        

        Stream.of("Jacob's Creek Classic Shiraz",
                "Chateau d’Yquem Sauternes",
                "Oremus Tokaji Aszú 5 Puttonyos")
                .forEach(name -> BEVERAGES.put(name, WINE));

        Stream.of("Pan Galactic Gargle Blaster",
                "Mead",
                "Soma")
                .forEach(name -> BEVERAGES.put(name, OTHER));

        BEVERAGES.put("", UNDEFINED);
    }

    /** This class is not meant to be instantiated. */
    private StaticData() {
    }
}
