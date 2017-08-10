//************************************************************
/**
*	Title 		Defines layout for Title scene.
*	
*	@author		pxldrm
*	@since		7/22/2017
* 	@update 	
*/
//************************************************************
package window;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import data.Global;
@SuppressWarnings("serial")
public class Title extends JPanel {
//************************************************************
/**
*	Variables
*/
//************************************************************
	private String[] actors = new String[Global.actors.length];

//************************************************************
/**
*	Constructor
*/
//************************************************************
	public Title() {
		setLayout(null);

		//Title
		JLabel lblTitle = new JLabel("LINEAR GRIND");
		lblTitle.setBounds(380, 100, 200, 50);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Courier New", Font.BOLD, 20));
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(280, 300, 100, 50);
		btnNewGame.setFont(new Font("Courier New", Font.PLAIN, 12));
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setFont(new Font("Courier New", Font.PLAIN, 12));
		btnContinue.setBounds(580, 300, 100, 50);
		
		//Character Select
		JLabel lblSelectCharacter = new JLabel("Select Character: ");
		lblSelectCharacter.setBounds(280, 195, 120, 14);
		
		
		for (int i = 0; i < actors.length; i++)
			actors[i] = Global.actors[i].name();
		JComboBox<Object> characterSelect = new JComboBox<Object>(actors);
		characterSelect.setBounds(420, 192, 160, 20);
		
		
		
		


		
		
		
		
		
		
		
		
		
		
		
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblTitle.setVisible(false);
				btnNewGame.setVisible(false);
				btnContinue.setVisible(false);
				
				lblSelectCharacter.setVisible(true);
				characterSelect.setVisible(true);
				



				
//				CardLayout cl = (CardLayout)(Base.cards.getLayout());
//		        cl.show(Base.cards, Base.gameOverCard);
			}
		});
		
		

		//Title
		add(lblTitle);
		add(btnNewGame);
		add(btnContinue);
		//Character Select
		add(characterSelect);
		add(lblSelectCharacter);

		lblSelectCharacter.setVisible(false);
		characterSelect.setVisible(false);
	}
}
