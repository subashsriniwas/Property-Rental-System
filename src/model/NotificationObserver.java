package model;



import java.util.ArrayList;

public class NotificationObserver implements Observer {
    ArrayList<Property> prop;

    public void update(ArrayList<Property> p){
        this.prop = p;
    }

}
