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
                }else {
                    //there is no next so insert at end of list
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            }else if (comparison > 0) {
                //new item is less, insert before
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                }else {
                    // node with previous is the root.
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            }else {
                //equal
                System.out.println(newItem.getValue()+ " is already present, not added");
                return false;
            }

        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {

        if (root == null) {
            System.out.println("List is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
