package com.twu.biblioteca;

        import com.twu.biblioteca.model.IItem;
        import com.twu.biblioteca.model.Movie;

        import java.util.HashMap;
        import java.util.Map;

public class Instruction<T extends IItem> { //set any class name that itself implements item, eg book and movie

    final String NEWLINE = System.getProperty("line.separator");
    private T[] items;
    private final Map<String, T> itemByTitle;
    private Map<T, User> itemUserMap;

    public Instruction(T[] items) {
        this.items = items;
        itemByTitle = new HashMap<String, T>(); //map with the string title and book object
        for (int i = 0; i < items.length; i++) {
            T item = items[i];
            itemByTitle.put(item.getTitle(), item); // put books into hash map
        }
        this.itemUserMap = new HashMap<T, User>();
    }

    public void checkOut(String title, User user) {
        T item = itemByTitle.get(title);
        if (item == null) {
            notAvailable();
        } else if (!item.isAvailable()) {
            alreadyCheckedOut();
        } else {
            item.setAvailable(false);
            successfulCheckout(title);
            itemUserMap.put(item, user);
        }
    }

    public void returnABook(String title) {
        T item = itemByTitle.get(title);
        if (item == null) {
            notAvailable();
        } else if (item.isAvailable()) {
            itemNotCheckedOutToReturn(title);
        } else {
            item.setAvailable(true);
            successfulReturn(title);
        }
    }

    public void notAvailable() {
        System.out.println("Sorry, that item is not available");
    }

    public void alreadyCheckedOut() {
        System.out.println("you have already checked this item out"+ NEWLINE +
                           "Please select the menu option again and choose an item we have available");
    }

    public void itemNotCheckedOutToReturn(String title) {
        System.out.println(title + " has not been checked out to return");
    }

    public void successfulCheckout(String title) {
        System.out.println("you have checked out " + title + NEWLINE +
                           "Thank you, enjoy!");
    }
    

    public void successfulReturn(String title) {
        System.out.println("Thank you, you have returned " + title);
    }

    public T[] getItems() {
        return items;
    }
}


