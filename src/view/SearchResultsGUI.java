package view;
import model.Property;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class SearchResultsGUI {

    // private member variables to hold GUI components
    private JFrame frame = new JFrame();
    private JTable table;

    /**
    * Constructor for the SearchResultsGUI. Creates the GUI and displays it to the user.
    * @param PropertyList : an ArrayList of type Property that holds all properties that fall within search criteria
    */
    public SearchResultsGUI(ArrayList<Property> PropertyList){

        // initializing the GUI components and displaying them on screen

        JPanel panel = new JPanel();

        BoxLayout bLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(bLayout);    

        Object[][] data = new Object[PropertyList.size()][7];

        for(int i = 0; i < PropertyList.size(); i++){
          int j = 0;
          data[i][j] = PropertyList.get(i).getAddress();
          j++;
          data[i][j] = PropertyList.get(i).getType();
          j++;
          data[i][j] = PropertyList.get(i).getBed();
          j++;
          data[i][j] = PropertyList.get(i).getBath();
          j++;
          data[i][j] = PropertyList.get(i).getFurnished();
          j++;
          data[i][j] = PropertyList.get(i).getQuadrant();
          j++;
          data[i][j] = PropertyList.get(i).getRentPrice();
        }

        String[] cNames = {"Address", "Property Type", "Beds", "Baths", "Funished?", "Quadrant", "Rent Price ($)"};
          
        table = new JTable(data, cNames);
        table.setBounds(30, 40, 200, 300);

        JScrollPane scrollPane = new JScrollPane(table);

        JButton backButton1 = new JButton("Back to menu");
        backButton1.setBounds(30, 400, 150, 25);
        backButton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Driver.backToUnregisteredRenterMenu();
                frame.dispose();
            }
        });
        panel.add(backButton1);             

        // adding elements to the frame and configuring the display
        frame.add(panel);
        panel.add(scrollPane);
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);            
    }
}
