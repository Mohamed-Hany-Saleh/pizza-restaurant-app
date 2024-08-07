/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.pizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.invoke.MethodHandles.loop;

        
@SuppressWarnings("serial")
public class Main extends JPanel{
JLabel picLabel, title;
	JButton button;
	private Panel panel_1;
	private Panel panel_2;
	static JFrame frame;

	public void createAndShowGUI() throws IOException {
            
		JPanel panel = new JPanel(new BorderLayout());
		Image image = ImageIO.read(this.getClass().getResource("pizza italiano.jpg"));
		Image imageScaled = image.getScaledInstance(350, 300, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(imageScaled);
		picLabel = new JLabel(imageIcon);
		Box right = Box.createVerticalBox();
		panel_1 = new Panel();
		title = new JLabel(" Pizza Italiano ");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setAlignmentY(0.0f);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Hassan", Font.ITALIC + Font.BOLD, 18));
		title.setForeground(Color.BLUE);

		// Button, with filler
		button = new JButton("Order Food Now >>");
		panel_1.add(button);
		button.setAlignmentX(Component.LEFT_ALIGNMENT);

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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
        ImageIcon icon= new ImageIcon(getClass().getResource("4490229.jpg"));
Image img= icon.getImage();

	public static void main(String args[]) throws IOException {
		Main main = new Main();
		main.createAndShowGUI();
		 frame = new JFrame();
		frame.setTitle("Pizza Italiano Food Ordering System");
		frame.getContentPane().add(main);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
                
                
                AudioPlayer a =new AudioPlayer();
                a.mp3player.play();
                
                
	}
        
}



 
   


    

