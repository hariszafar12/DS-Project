import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class Welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 602);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(166, 220, 247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Welcome To SpellChecker");
		lblNewLabel.setBounds(155, 32, 419, 146);
		lblNewLabel.setToolTipText("To SpellChecker");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setBounds(0, 232, 175, 58);
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SpellCheckerApp a=new SpellCheckerApp();
				a.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnAboutUs = new JButton("About Us");
		btnAboutUs.setBounds(0, 301, 175, 58);
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUs a=new AboutUs();
				a.setVisible(true);
				dispose();
			}
		});
		btnAboutUs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		contentPane.add(btnAboutUs);
		
		JButton btnNewButton_1_1 = new JButton("Exit");
		btnNewButton_1_1.setBounds(0, 369, 175, 58);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exiting e1=new Exiting();
				e1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblMadeBymsagheer = new JLabel("Made By:M.Sagheer & Haris Zafar");
		lblMadeBymsagheer.setBounds(10, 415, 551, 146);
		lblMadeBymsagheer.setToolTipText("To SpellChecker");
		lblMadeBymsagheer.setHorizontalAlignment(SwingConstants.CENTER);
		lblMadeBymsagheer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		contentPane.add(lblMadeBymsagheer);
	}
}
