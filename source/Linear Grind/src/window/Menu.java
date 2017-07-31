//************************************************************
/**
*	Menu 		Defines layout for Menu scene.
*	
*	@author		pxldrm
*	@since		7/24/2017
* 	@update 	7/28/2017
*/
//************************************************************
package window;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import display.Message;
import display.Vocab;
import game.Party;
@SuppressWarnings("serial")
public class Menu extends JPanel {
//************************************************************
/**
*	Variables
*/
//************************************************************
	//button names
	private final String[] 		NAV_MENU 		= {	"Status",
													"Inventory",
													"Options",
													"Save",
													"Load",
													"Exit"};
	private final String[] 		NAV_INV 		= {	"Items",
													"Weapons",
													"Armor",
													"Back"};
	//main menu
	private final JButton[] 	BTN_MENU 		= new JButton[NAV_MENU.length];
	private JLabel 				INFO_MENU;
	private JLabel[] 			PARTY_MENU;
	//status menu
	private JButton[] 			BTN_STAT 		= new JButton[Party.memberCount() + 1];
	private JLabel 				STAT_MENU;
	private JLabel 				EQUIPPED_MENU;
	private String[] 			s;
	private String[] 			e;
	//inventory menu
	private final JButton[] 	BTN_INV 		= new JButton[NAV_INV.length];
	//button dimensions
	private final int 			btnWidth 		= (Base.width() - Base.borderWidth() * 2) / NAV_MENU.length;
	private final int 			btnHeight 		= (Base.height() - Base.borderHeight() * 2) / 10;
	//info box dimensions
	private final int 			infoWidth 		= btnWidth * NAV_MENU.length;
	private final int 			infoHeight 		= btnHeight;
	//party descriptions dimensions
	private final int 			partyWidth 		= (infoWidth  - Base.border()) / 2;
	private final int 			partyHeight 	= ((Base.height() - Base.borderHeight() * 2) / 2) - (btnHeight * 2);
	//status menu dimensions
	private final int 			statWidth 		= partyWidth;
	private final int 			statHeight 		= (int) (partyHeight * 2.5);
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 						Menu() {
		setLayout(null);
		//build navigation pane
		buildMain();
		//build status pane
		buildStat();
		//build navigation pane
		buildInv();
		//set up main menu
		clear();
		setMain();
	}
	private void 				buildMain(){
		//navigation buttons
		for(int i = 0; i < BTN_MENU.length; i++){
			BTN_MENU[i] = new JButton(NAV_MENU[i]);
			BTN_MENU[i].setFont(display.Base.menuFont());
			BTN_MENU[i].setBounds(Base.borderWidth() + (i * btnWidth), Base.borderHeight(), btnWidth, btnHeight);
			add(BTN_MENU[i]);
		}
		BTN_MENU[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
				setStat();
			}
		});
		BTN_MENU[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
				setInv();
			}
		});
		BTN_MENU[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(Base.cards.getLayout());
		        cl.show(Base.cards, Base.TITLE_CARD);
			}
		});
		//info menu
		INFO_MENU = new JLabel();
		INFO_MENU.setBorder(BorderFactory.createLineBorder(Color.black));
		INFO_MENU.setVerticalAlignment(SwingConstants.CENTER);
		INFO_MENU.setFont(display.Base.menuFont());
		INFO_MENU.setBounds(Base.borderWidth(), Base.borderHeight() + btnHeight + 5, infoWidth, infoHeight);
		INFO_MENU.setText(	Message.open +
							display.Base.htmlSpace(2) + Vocab.gold.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.gold.length()) + Party.gold() +
							Message.close);
		add(INFO_MENU);
		//party menu
		PARTY_MENU = new JLabel[Party.memberCount()];
		for(int i = 0; i < PARTY_MENU.length; i++){
			PARTY_MENU[i] = new JLabel();
			PARTY_MENU[i].setBorder(BorderFactory.createLineBorder(Color.black));
			PARTY_MENU[i].setVerticalAlignment(SwingConstants.CENTER);
			PARTY_MENU[i].setFont(display.Base.menuFont());
			PARTY_MENU[i].setText(	Message.open +
									display.Base.htmlSpace(2) + Party.members()[i].name() + Message.brk +
									display.Base.htmlSpace(2) + Vocab.lv.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.lv.length()) + Party.members()[i].lv() + Message.brk +
									display.Base.htmlSpace(2) + Vocab.hp.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.hp.length()) + Party.members()[i].hp() + "/" + Party.members()[i].mhp() + Message.brk +
									display.Base.htmlSpace(2) + Vocab.mp.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.mp.length()) + Party.members()[i].mp() + "/" + Party.members()[i].mmp() + Message.brk +
									display.Base.htmlSpace(2) + Vocab.exp.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.exp.length()) + Party.members()[i].exp() + Message.brk +
									display.Base.htmlSpace(2) + Vocab.next.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.next.length()) + Party.members()[i].next() + Message.brk +
									Message.close);
			if (i == 0)
				PARTY_MENU[i].setBounds(Base.borderWidth(), Base.borderHeight() + (btnHeight * 2) + (Base.border() * 2), partyWidth, partyHeight);
			if (i == 1)
				PARTY_MENU[i].setBounds(Base.borderWidth() + partyWidth + Base.border(), Base.borderHeight() + (btnHeight * 2) + (Base.border() * 2), partyWidth, partyHeight);
			if (i == 2)
				PARTY_MENU[i].setBounds(Base.borderWidth(), Base.borderHeight() + partyHeight + (btnHeight * 2) + (Base.border() * 3), partyWidth, partyHeight);
			if (i == 3)
				PARTY_MENU[i].setBounds(Base.borderWidth() + partyWidth + Base.border(), Base.borderHeight() + partyHeight + (btnHeight * 2) + (Base.border() * 3), partyWidth, partyHeight);
			add(PARTY_MENU[i]);
		}
	}
	private void 				buildStat(){
		//navigation buttons
		s = new String[Party.memberCount()];
		e = new String[Party.memberCount()];
		for(int i = 0; i < BTN_STAT.length; i++){
			if (i == BTN_STAT.length - 1)
				BTN_STAT[i] = new JButton("Back");
			else {
				BTN_STAT[i] = new JButton(Party.members()[i].name());
				//text for actor stats
				s[i] = 	Message.open +
						display.Base.htmlSpace(2) + Party.members()[i].name() + Message.brk +
						display.Base.htmlSpace(2) + Vocab.lv.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.lv.length()) + Party.members()[i].lv() + Message.brk +
						display.Base.htmlSpace(2) + Vocab.hp.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.hp.length()) + Party.members()[i].hp() + "/" + Party.members()[i].mhp() + Message.brk +
						display.Base.htmlSpace(2) + Vocab.mp.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.mp.length()) + Party.members()[i].mp() + "/" + Party.members()[i].mmp() + Message.brk +
						display.Base.htmlSpace(2) + Vocab.atk.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.atk.length()) + Party.members()[i].atk() + Message.brk +
						display.Base.htmlSpace(2) + Vocab.def.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.def.length()) + Party.members()[i].def() + Message.brk +
						display.Base.htmlSpace(2) + Vocab.mat.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.mat.length()) + Party.members()[i].mat() + Message.brk +
						display.Base.htmlSpace(2) + Vocab.mdf.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.mdf.length()) + Party.members()[i].mdf() + Message.brk +
						display.Base.htmlSpace(2) + Vocab.agi.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.agi.length()) + Party.members()[i].agi() + Message.brk +
						display.Base.htmlSpace(2) + Vocab.luk.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.luk.length()) + Party.members()[i].luk() + Message.brk +
						display.Base.htmlSpace(2) + Vocab.exp.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.exp.length()) + Party.members()[i].exp() + Message.brk +
						display.Base.htmlSpace(2) + Vocab.next.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.next.length()) + Party.members()[i].next() + Message.brk +
						Message.close;
				//text for actor equipment
				e[i] = 	Message.open +
						display.Base.htmlSpace(2) + Vocab.equipment.toUpperCase() + Message.brk;
				for (int j = 0; j < Party.members()[i].equipmentList().length; j++){
					e[i] += display.Base.htmlSpace(2) + Vocab.equipmentList[j].toUpperCase() + ":" + display.Base.htmlSpace(11 - Vocab.equipmentList[j].length());
					if (Party.members()[i].equipmentList()[j] != null)
						e[i] += Party.members()[i].equipmentList()[j].name() + Message.brk;
					else
						e[i] += Vocab.empty.toUpperCase() + Message.brk;
				}
				e[i] += Message.close;
				//navigation buttons
				BTN_STAT[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						STAT_MENU.setVisible(true);
						for (int i = 0; i < Party.memberCount(); i++){
							if (Party.memberCount() > i){
								if (arg0.getActionCommand().contains(BTN_STAT[i].getActionCommand())){
									STAT_MENU.setText(s[i]);
									EQUIPPED_MENU.setText(e[i]);
								}
							}
						}
					}
				});
			}
			BTN_STAT[i].setFont(display.Base.menuFont());
			BTN_STAT[i].setBounds(Base.borderWidth() + (i * btnWidth), Base.borderHeight(), btnWidth, btnHeight);
			add(BTN_STAT[i]);
		}
		BTN_STAT[BTN_STAT.length - 1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
				setMain();
			}
		});
		//status menu
		STAT_MENU = new JLabel();
		STAT_MENU.setBorder(BorderFactory.createLineBorder(Color.black));
		STAT_MENU.setVerticalAlignment(SwingConstants.CENTER);
		STAT_MENU.setFont(display.Base.menuFont());
		STAT_MENU.setBounds(Base.borderWidth(), Base.borderHeight() + btnHeight + Base.border(), statWidth, statHeight);
		add(STAT_MENU);
		//status equipped menu
		EQUIPPED_MENU = new JLabel();
		EQUIPPED_MENU.setBorder(BorderFactory.createLineBorder(Color.black));
		EQUIPPED_MENU.setVerticalAlignment(SwingConstants.CENTER);
		EQUIPPED_MENU.setFont(display.Base.menuFont());
		EQUIPPED_MENU.setBounds(Base.borderWidth() + statWidth + Base.border(), Base.borderHeight() + btnHeight + Base.border(), statWidth, statHeight);
		add(EQUIPPED_MENU);
	}
	private void 				buildInv(){
		//navigation buttons
		for(int i = 0; i < BTN_INV.length; i++){
			BTN_INV[i] = new JButton(NAV_INV[i]);
			BTN_INV[i].setFont(display.Base.menuFont());
			BTN_INV[i].setBounds(Base.borderWidth() + (i * btnWidth), Base.borderHeight(), btnWidth, btnHeight);
			add(BTN_INV[i]);
		}
		BTN_INV[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
				setMain();
			}
		});
	}
//************************************************************
/**
*	Methods
*/
//************************************************************
	private void 				setMain(){
		for(JButton b: BTN_MENU)
			b.setVisible(true);
		INFO_MENU.setVisible(true);
		for(JLabel l: PARTY_MENU)
			l.setVisible(true);
	}
	private void 				setStat(){
		for(JButton b: BTN_STAT)
			b.setVisible(true);
		STAT_MENU.setText(s[0]);
		STAT_MENU.setVisible(true);
		EQUIPPED_MENU.setText(e[0]);
		EQUIPPED_MENU.setVisible(true);
	}
	private void 				setInv(){
		for(JButton b: BTN_INV)
			b.setVisible(true);
	}
	private void 				clear(){
		//main menu
		for(JButton b: BTN_MENU)
			b.setVisible(false);
		INFO_MENU.setVisible(false);
		for(JLabel l: PARTY_MENU)
			l.setVisible(false);
		//status menu
		for(JButton b: BTN_STAT)
			b.setVisible(false);
		STAT_MENU.setVisible(false);
		EQUIPPED_MENU.setVisible(false);
		//inventory menu
		for(JButton b: BTN_INV)
			b.setVisible(false);
	}
}
