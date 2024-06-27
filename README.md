# Project Documentation: Pizza Italiano Food Ordering System
1. Project Overview
The Pizza Italiano Food Ordering System is a Java application that allows users to order food through a graphical user interface (GUI). The system includes several main components such as an audio player, Dijkstra's algorithm for route optimization, the GUI, and a menu system.

2. Technologies Used
Programming Language: Java

Description: Java is a powerful and stable programming language widely used in various applications, from desktop applications to web and mobile applications.
Benefit: Using Java provides a unified development environment across multiple operating systems, making the application platform-independent.
Swing Library

Description: Swing is a graphics library in Java used to build graphical user interfaces (GUIs).
Benefit: Swing makes it easy to create attractive and interactive user interfaces, enhancing user experience.
JACO MP3 Player Library

Description: A library for playing MP3 audio files in Java applications.
Benefit: Allows playing background music to improve user experience.
3. Algorithms Used
Dijkstra's Algorithm
Description: Dijkstra's algorithm is used to find the shortest path between two points in a graph.
Benefit: This algorithm is used to optimize and route order processing within the system based on distances, enhancing delivery efficiency.
4. Explanation of Main Project Files
4.1. AudioPlayer.java

package online.pizza;

import jaco.mp3.player.MP3Player;
import java.io.File;

public class AudioPlayer {
    public final String SONG="C:\\Users\\ponja\\Documents\\NetBeansProjects\\Online_Pizza\\OnlinePizza\\Tarantella Napoletana.mp3";
    MP3Player mp3player = new MP3Player(new File(SONG));
}
Description: This file contains a class that plays an MP3 audio file when the application starts.
Benefit: Plays background music to enhance user experience.
Detailed Explanation:
Attributes:
SONG: A string that stores the path to the MP3 file.
mp3player: An instance of MP3Player initialized with the MP3 file.
Methods:
The constructor initializes the MP3Player with the specified MP3 file.
4.2. createAndShowGUI.java

package online.pizza;

interface createAndShowGUI {
    // Interface definition for createAndShowGUI
}
Description: This file contains an undefined interface. It can be extended later to define methods for creating and displaying GUIs.
Benefit: Facilitates future expansion and development of the application’s user interfaces.
Detailed Explanation:
Interface: This interface serves as a contract for classes that will implement methods related to GUI creation and display.
4.3. Dijkstra.java

package online.pizza;

import java.util.ArrayList;
import java.util.PriorityQueue;
import static online.pizza.OrderMenu.jComboBox1;

public class Dijkstra {
    static class ListNode {
        int vertex, weight;
        ListNode(int v, int w) {
            vertex = v;
            weight = w;
        }
        int getVertex() {
            return vertex;
        }
        int getWeight() {
            return weight;
        }
    }

    public static int[] dijkstra(ArrayList<ArrayList<ListNode>> graph) {
        int V = 9;
        int src = 0;
        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.getWeight() - v2.getWeight());
        pq.add(new ListNode(src, 0));

        while (pq.size() > 0) {
            ListNode current = pq.poll();
            for (ListNode n : graph.get(current.getVertex())) {
                if (distance[current.getVertex()] + n.getWeight() < distance[n.getVertex()]) {
                    distance[n.getVertex()] = distance[current.getVertex()] + n.getWeight();
                    pq.add(new ListNode(n.getVertex(), distance[n.getVertex()]));
                }
            }
        }
        return distance;
    }
}
Description: This file contains the implementation of Dijkstra's algorithm used to find the shortest path in a graph.
Benefit: Optimizes routing of orders within the system based on distances, improving delivery efficiency.
Detailed Explanation:
Class ListNode:
Attributes:
vertex: An integer representing the vertex.
weight: An integer representing the weight of the edge.
Methods:
getVertex(): Returns the vertex.
getWeight(): Returns the weight.
Method dijkstra():
Parameters:
graph: An adjacency list representation of the graph.
Returns:
An array of shortest distances from the source vertex to all other vertices.
Algorithm:
Initializes the distance array.
Uses a priority queue to process vertices based on their distance.
Updates the distance of adjacent vertices if a shorter path is found.
4.4. Linkedlist.java
java
Copy code
package online.pizza;

import java.util.LinkedList;

public class Linkedlist {
    LinkedList<String> list = new LinkedList<>();
}
Description: This file contains a class that defines a linked list to store text data.
Benefit: Uses linked lists to store data in an organized and efficient manner.
Detailed Explanation:
Attributes:
list: A linked list of strings.
Methods:
The class encapsulates the linked list and can be extended to include more functionalities.
4.5. Main.java

package online.pizza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main extends JPanel {
    static JFrame frame;
    JButton button;
    JLabel picLabel;
    JLabel title;
    Panel panel_1;

    public Main() throws IOException {
        super(new BorderLayout());
        JPanel panel = new JPanel(new BorderLayout());
        BufferedImage image = ImageIO.read(this.getClass().getResource("pizza italiano.jpg"));
        Image imageScaled = image.getScaledInstance(350, 300, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(imageScaled);
        picLabel = new JLabel(imageIcon);
        Box right = Box.createVerticalBox();
        panel_1 = new Panel();
        title = new JLabel(" Pizza Italiano ");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Hassan", Font.ITALIC + Font.BOLD, 18));
        title.setForeground(Color.BLUE);

        button = new JButton("Order Food Now >>");
        panel_1.add(button);

        panel.add(picLabel, BorderLayout.CENTER);
        panel.add(right, BorderLayout.SOUTH);
        right.add(title);
        right.add(panel_1);
        add(panel);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FoodMenu food;
                try {
                    food = new FoodMenu();
                    food.createAndShowGUI();
                    food.setVisible(true);
                    setVisible(false);
                    frame.dispose();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String args[]) throws IOException {
        Main main = new Main();
        main.createAndShowGUI();
        frame = new JFrame();
        frame.setTitle("Pizza Italiano Food Ordering System");
        frame.getContentPane().add(main);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        AudioPlayer a = new AudioPlayer();
        a.mp3player.play();
    }
}
Description: This file contains the main application that launches the system's GUI and plays the audio file upon startup.
Benefit: Provides an attractive and interactive user interface for easy food ordering, enhancing user experience.
Detailed Explanation:
Attributes:
frame: A JFrame that serves as the main window.
button, picLabel, title, panel_1: GUI components for displaying the main interface.
Methods:
Main(): Constructor that sets up the GUI components and event listeners.
main(): Entry point of the application that initializes the GUI and plays background music.
createAndShowGUI(): Method to create and display the main GUI.
4.6. Confirmation.java

package online.pizza;

import javax.swing.*;
import java.awt.*;

public class Confirmation extends JPanel {
    public Confirmation(String orderDetails) {
        super(new BorderLayout());
        JLabel label = new JLabel("Order Confirmation");
        JTextArea textArea = new JTextArea(orderDetails);
        textArea.setEditable(false);
        add(label, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public static void createAndShowGUI(String orderDetails) {
        JFrame frame = new JFrame("Order Confirmation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Confirmation(orderDetails));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
Description: This file contains a class that displays the order confirmation details.
Benefit: Provides a visual confirmation of the user's order.
Detailed Explanation:
Attributes:
label: A JLabel for displaying the confirmation title.
textArea: A JTextArea for displaying the order details.
Methods:
Confirmation(String orderDetails): Constructor that sets up the confirmation panel.
createAndShowGUI(String orderDetails): Method to create and display the confirmation window.
4.7. cooo.java

package online.pizza;

import java.util.HashMap;

public class cooo {
    HashMap<String, Integer> priceList = new HashMap<>();

    public cooo() {
        priceList.put("Pizza", 8);
        priceList.put("Pasta", 6);
        priceList.put("Salad", 5);
    }

    public int getPrice(String item) {
        return priceList.getOrDefault(item, -1);
    }
}
Description: This file contains a class that manages a list of menu items and their prices.
Benefit: Provides functionality to get the price of a specific menu item.
Detailed Explanation:
Attributes:
priceList: A HashMap that stores menu items and their prices.
Methods:
cooo(): Constructor that initializes the price list.
getPrice(String item): Method to get the price of a specified item.
4.8. OrderMenu.java

package online.pizza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderMenu extends JPanel implements createAndShowGUI {
    static JComboBox<String> jComboBox1;

    public OrderMenu() {
        super(new BorderLayout());
        jComboBox1 = new JComboBox<>(new String[]{"Pizza", "Pasta", "Salad"});
        add(jComboBox1, BorderLayout.NORTH);

        JButton button = new JButton("Confirm Order");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) jComboBox1.getSelectedItem();
                Confirmation.createAndShowGUI("You ordered: " + selectedItem);
            }
        });
        add(button, BorderLayout.SOUTH);
    }

    @Override
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Order Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new OrderMenu());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
Description: This file contains a class that defines the order menu interface.
Benefit: Provides users with options to select and place orders efficiently.
Detailed Explanation:
Attributes:
jComboBox1: A JComboBox that provides menu items for selection.
Methods:
OrderMenu(): Constructor that sets up the order menu panel.
createAndShowGUI(): Method to create and display the order menu window.
