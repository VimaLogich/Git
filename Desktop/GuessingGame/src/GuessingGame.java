import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuessANumber;
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber) {
				message = guess + " is too low. Try again.";
			} else if (guess > theNumber) {
				message = guess + " is too high. Try again.";
			} else {
				message = guess + " is correct. you win! Let's play again!";
				newGame();
			}
		}	catch (Exception e) {
			message = "Enter a whole number between 1 and 100.";
		}	finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}

	} 
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
		System.out.println(theNumber);
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		setTitle("Hi-Lo Guessing Game");                                                         
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 0, 628, 31);
		getContentPane().add(lblNewLabel);

		txtGuessANumber = new JTextField();
		txtGuessANumber.setText("Guess a number between 1 and 100:");
		txtGuessANumber.setBounds(112, 120, 247, 26);
		getContentPane().add(txtGuessANumber);
		txtGuessANumber.setColumns(10);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(471, 120, 56, 26);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnNewButton = new JButton("Guess!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnNewButton.setBounds(285, 266, 117, 29);
		getContentPane().add(btnNewButton);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(204, 415, 278, 16);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(650,550));
		theGame.setVisible(true);
	}
}
