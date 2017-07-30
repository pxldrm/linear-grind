//************************************************************
/**
*	GameOver 	Defines layout for Game Over scene.
*	
*	@author		pxldrm
*	@since		7/22/2017
* 	@update 	
*/
//************************************************************
package window;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import display.Vocab;
import javax.swing.SwingConstants;
import java.awt.Font;
@SuppressWarnings("serial")
public class GameOver extends JPanel {
//************************************************************
/**
*	Variables
*/
//************************************************************
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public GameOver() {
		setLayout(null);
		JLabel lblGameOver = new JLabel(Vocab.gameOver);
		lblGameOver.setBounds(179, 9, 54, 14);
		add(lblGameOver);
		
		JButton btnNewButton = new JButton("Go To Title");
		btnNewButton.setBounds(238, 5, 83, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(Base.cards.getLayout());
		        cl.show(Base.cards, Base.TITLE_CARD);
			}
		});
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(130, 149, 203, 102);
		add(lblNewLabel);
	}
}
