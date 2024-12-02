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

public class AboutUs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUs frame = new AboutUs();
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
	public AboutUs() {
		setTitle("AboutUs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 602);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(166, 220, 247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("University: KHPIBA\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setToolTipText("To SpellChecker");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(0, 87, 227, 99);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1_1 = new JButton("Back");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome w=new Welcome();
				w.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		btnNewButton_1_1.setBounds(264, 495, 175, 58);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblSemesteriii = new JLabel("Semester: III");
		lblSemesteriii.setToolTipText("To SpellChecker");
		lblSemesteriii.setHorizontalAlignment(SwingConstants.LEFT);
		lblSemesteriii.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblSemesteriii.setBounds(0, 208, 227, 99);
		contentPane.add(lblSemesteriii);
		
		JLabel lblNewLabel_1_1 = new JLabel("Languages Learned: Java and C++");
		lblNewLabel_1_1.setToolTipText("To SpellChecker");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(0, 268, 352, 99);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblMajorbscs = new JLabel("Major: BS-CS");
		lblMajorbscs.setToolTipText("To SpellChecker");
		lblMajorbscs.setHorizontalAlignment(SwingConstants.LEFT);
		lblMajorbscs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblMajorbscs.setBounds(0, 149, 227, 99);
		contentPane.add(lblMajorbscs);
		
		JLabel lblStudentNamesmsagheer = new JLabel("Project Creators: M.Sagheer & Haris Zafar");
		lblStudentNamesmsagheer.setToolTipText("To SpellChecker");
		lblStudentNamesmsagheer.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudentNamesmsagheer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblStudentNamesmsagheer.setBounds(0, 29, 430, 99);
		contentPane.add(lblStudentNamesmsagheer);
	}
}
