package com.company;

/**
 * Created by PLPK on 03.08.2017.
 */
public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null ) {
            //list was empty
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem!=null) {
            int comparison = currentItem.compareTo(newItem);

            if(comparison < 0 ) {
                //newItem greater, move right if possible
                if(currentItem.next()!= null) {
                    currentItem = currentItem.next();
                }
            }
        }
    }

    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {

    }
}
