import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Exiting extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exiting frame = new Exiting();
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
	public Exiting() {
		setTitle("Exiting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 602);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(166, 220, 247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Are You Sure?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setToolTipText("To SpellChecker");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(0, 36, 800, 87);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1_1 = new JButton("Exit");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		btnNewButton_1_1.setBounds(314, 117, 175, 58);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Back");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome w=new Welcome();
				w.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		btnNewButton_1_1_1.setBounds(314, 198, 175, 58);
		contentPane.add(btnNewButton_1_1_1);
	}
}
