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
public class UserService {

    private Map<Long, User> users = new HashMap<>();
	
    /**
     * Helper class to initialize the singleton Service in a thread-safe way and
     * to keep the initialization ordering clear between the two services. See
     * also: https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
     */
    private static class SingletonHolder {
        static final UserService INSTANCE = createDemoUserService();

        /** This class is not meant to be instantiated. */
        private SingletonHolder() {
        }

        private static UserService createDemoUserService() {                          // list fill for email, fname, lname 
            final UserService userService = new UserService();							

            for (int i = 0; i < 49; i++) {
				String email = StaticData.EMAILS.get(new Random().nextInt(StaticData.EMAILS.size()-1)) ;
				String fn = StaticData.FNAMES.get(new Random().nextInt(StaticData.FNAMES.size()-1)) ;
				String ln = StaticData.LNAMES.get(new Random().nextInt(StaticData.LNAMES.size()-1)) ;
            	
				userService.doSaveUser(new User(email,fn,ln));
			}
            
            return userService;
        }
    }
    
    private Map<Long, User> user = new HashMap<>();
    private AtomicLong nextId = new AtomicLong(0);
    /**
     * Declared private to ensure uniqueness of this Singleton.
     */
    private UserService() {	
    }

//    public User doSaveUser(User users2) {														//save user
//    	User entity = users.get(users2.getId());
//    	
//    	if(entity == null) {
////    		entity = new User (users2.getEmail(),users2.getFname(),users2.getLname());
////    		entity = new User (users2);
//    		if (users2.getId() == null) {
////    			entity.setId(nextId.incrementAndGet());
//    		}
//    		users.put(entity.getId(), entity);
//    	}
//    	users.put(entity.getId(), entity);	
//    	entity.setFname(users2.getFname());
//    	entity.setLname(users2.getLname());
//    	entity.setEmail(users2.getEmail());
//		return entity;
//		
//	}
    public void saveUser(User users2) {												// save v2
    	doSaveUser(users2);
    }
    public User doSaveUser(User users2) {
    	User entity = users.get(users2.getId());
    	
    	if (entity == null) {
//    		entity = new User(users2);
    		entity = new User (users2.getEmail(),users2.getFname(),users2.getLname());
    		if (users2.getId()==null) {
    			entity.setId(nextId.incrementAndGet());
    		}
    		users.put(entity.getId(), entity);
    		
    	} else {
    		entity.setFname(users2.getFname());
    		entity.setLname(users2.getLname());
    		entity.setEmail(users2.getEmail());
    	}
    	return entity;
    }
    
    
    
    
    public static UserService getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    
    // delete user method 
    public boolean deleteUser (User user) {
        return users.remove(user.getId()) != null;
    }
    
    
    //find users by fname, lname, email method
    
    public List<User> findUser (String searchtext) {
    	List<User> usersMatching = users.values().stream()
    			.filter(users -> 	users.getFname().toLowerCase().contains(searchtext.toLowerCase()) ||
    								users.getLname().toLowerCase().contains(searchtext.toLowerCase()) ||
    								users.getEmail().toLowerCase().contains(searchtext.toLowerCase()))
    			.collect(Collectors.toList());
    	
    			if (usersMatching.isEmpty()) {
    	            return usersMatching;
    	        }else 
    			return (usersMatching);
    }
    
    
    
    
    
//    
//    // find user by first name method 															//contains!
//    public List<User> findUserByfName(String fname) {													
//        List<User> usersMatching = users.values().stream()
//                .filter(users -> users.getFname().toLowerCase().contains(fname.toLowerCase()))
//                .collect(Collectors.toList());
//
//        if (usersMatching.isEmpty()) {
//            return usersMatching;
//        }
////        if (usersMatching.size() > 1) {
////            throw new IllegalStateException(
////                    "User: " + users);
////        }
//        return (usersMatching);
//    }

//    // find user by last name method 
//    public List<User> findUserBylName(String lname) {													
//        List<User> usersMatching = users.values().stream()
//                .filter(users -> users.getLname().toLowerCase().contains(lname.toLowerCase()))
//                .collect(Collectors.toList());
//
//        if (usersMatching.isEmpty()) {
//            return usersMatching;
//        }
////        
//        return (usersMatching);
    

//	/**
//     * Gets the unique instance of this Singleton.
//     *
//     * @return the unique instance of this Singleton
//     */
//    public static UserService getInstance() {
//        return SingletonHolder.INSTANCE;
//    }
//
//   
//
//    /**
//     * Fetches the categories whose name matches the given filter text.
//     *
//     * The matching is case insensitive. When passed an empty filter text, the
//     * method returns all categories. The returned list is ordered by name.
//     *
//     * @param filter
//     *            the filter text
//     * @return the list of matching categories
//     */
//    public List<Category> findCategories(String filter) {
//        String normalizedFilter = filter.toLowerCase();
//
//        // Make a copy of each matching item to keep entities and DTOs separated
//        return categories.values().stream()
//                .filter(c -> c
//                        .getName().toLowerCase().contains(normalizedFilter))
//                .map(Category::new)
//                .sorted((c1, c2) -> c1.getName()
//                        .compareToIgnoreCase(c2.getName()))
//                .collect(Collectors.toList());
//    }
//
//    /**
//     * Fetches the category with the given name.
//     * <p>
//     * The matching is case insensitive.
//     *
//     * @param name
//     *            the category name to look for
//     * @return an {@link Optional} containing the category if found, or
//     *         {@link Optional#empty()}
//     * @throws IllegalStateException
//     *             if the result is ambiguous
//     */
//    public Optional<Category> findCategoryByName(String name) {
//        List<Category> categoriesMatching = categories.values().stream()
//                .filter(category -> name.equals(category.getName()))
//                .collect(Collectors.toList());
//
//        if (categoriesMatching.isEmpty()) {
//            return Optional.empty();
//        }
//        if (categoriesMatching.size() > 1) {
//            throw new IllegalStateException(
//                    "Category " + name + " is ambiguous");
//        }
//        return Optional.of(categoriesMatching.get(0));
//    }
//
//    /**
//     * Fetches the category with the given name.
//     * <p>
//     * Behaves like {@link #findCategoryByName(String)}, except that returns a
//     * {@link Category} instead of an {@link Optional}. If the category can't be
//     * identified, an exception is thrown.
//     *
//     * @param name
//     *            the category name to look for
//     * @return the category, if found
//     * @throws IllegalStateException
//     *             if not exactly one category matches the given name
//     */
//    public Category findCategoryOrThrow(String name) {
//        return findCategoryByName(name)
//                .orElseThrow(() -> new IllegalStateException(
//                        "Category " + name + " does not exist"));
//    }
//
//    /**
//     * Searches for the exact category with the given id.
//     *
//     * @param id
//     *            the category id
//     * @return an {@link Optional} containing the category if found, or
//     *         {@link Optional#empty()}
//     */
//    public Optional<Category> findCategoryById(Long id) {
//        Category category = categories.get(id);
//        return Optional.ofNullable(category);
//    }
//
//    /**
//     * Deletes the given category from the category store.
//     *
//     * @param category
//     *            the category to delete
//     * @return true if the operation was successful, otherwise false
//     */
//    public boolean deleteCategory(Category category) {
//        if (category.getId() != null
//                && undefinedCategoryId.get() == category.getId().longValue()) {
//            throw new IllegalArgumentException(
//                    "Undefined category may not be removed");
//        }
//        return categories.remove(category.getId()) != null;
//    }
//
//    /**
//     * Persists the given category into the category store.
//     *
//     * If the category is already persistent, the saved category will get
//     * updated with the name of the given category object. If the category is
//     * new (i.e. its id is null), it will get a new unique id before being
//     * saved.
//     *
//     * @param dto
//     *            the category to save
//     */
//    public void saveCategory(Category dto) {
//        doSaveCategory(dto);
//    }
//
//    private Category doSaveCategory(Category dto) { 												// do save Category example
//        Category entity = categories.get(dto.getId());
//
//        if (entity == null) {
//            // Make a copy to keep entities and DTOs separated
//            entity = new Category(dto);
//            if (dto.getId() == null) {
//                entity.setId(nextId.incrementAndGet());
//            }
//            categories.put(entity.getId(), entity); 
//        } else if (undefinedCategoryId.get() == dto.getId().longValue()
//                && !Objects.equals(entity.getName(), dto.getName())) {
//            throw new IllegalArgumentException(
//                    "Undefined category may not be renamed");
//        } else {
//            entity.setName(dto.getName());
//        }
//        return entity;
//    }

}
