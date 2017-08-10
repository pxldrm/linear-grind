//************************************************************
/**
*	Menu 		Defines layout for Menu scene.
*	
*	@author		pxldrm
*	@since		7/24/2017
* 	@update 	8/10/2017
*/
//************************************************************
package window;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import display.Message;
import display.Vocab;
import game.Party;
import game.Type;
import item.Armor;
import item.Item;
import item.Weapon;
@SuppressWarnings("serial")
public class Menu extends JPanel {
//************************************************************
/**
*	Variables
*/
//************************************************************
	//section dimensions
	private final int 		smallWidth 					= (Base.width() 	- (Base.borderWidth()  * 2)) / Base.horizontalSections();
	private final int 		smallHeight 				= (Base.height() 	- (Base.borderHeight() * 2)) / Base.verticalSections();
	private final int 		medWidth 					= ((smallWidth * Base.horizontalSections()) - Base.sectionBorder()) / 2;
	private final int 		medHeight 					= (int) (smallHeight * 3.5);
	private final int 		longWidth 					= (medWidth  * 2) + Base.sectionBorder();
	private final int 		longHeight 					= (medHeight * 2) + Base.sectionBorder();
	//selection box
	private JComboBox<Object> 				inventorySelectBox 	= new JComboBox<Object>();
	private DefaultComboBoxModel<Object> 	invModel 			= (DefaultComboBoxModel<Object>) inventorySelectBox.getModel();
	private JComboBox<Object> 				characterSelectBox 	= new JComboBox<Object>();
	private DefaultComboBoxModel<Object> 	charModel 			= (DefaultComboBoxModel<Object>) characterSelectBox.getModel();
	//navigation buttons
	private final JButton[] mainNavButtons 						= new JButton[Vocab.MAIN_NAV_NAMES.length];
	private JButton[] 		statusNavButtons 					= new JButton[Party.memberCount() + 1];
	private JButton[] 		skillsNavButtons 					= new JButton[Party.memberCount() + 1];
	private final JButton[] inventoryNavButtons 				= new JButton[Vocab.INV_NAV_NAMES.length];
	//action buttons
	private JButton 		okButton;
	private JButton 		cancelButton;
	private JButton 		useButton;
	private JButton 		equipButton;
	private JButton 		discardButton;
	//section labels
	private JLabel 			popupBox;
	private JLabel 			infoBox;
	private JLabel[] 		partyBox;
	private JLabel 			leftBox;
	private JLabel 			rightBox;
	//information format
	private String[] 		characterInfo;
	private String[] 		equipmentInfo;
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 					Menu() {
		//initialize menu
		initLayout();
		initNavigation();
		initSelection();
		//display main panel
		clear();
		displayMainMenu();
	}
//************************************************************
/**
*	Initialize Menu
*/
//************************************************************
	private void 			initLayout(){
		//menu theme
		setLayout(null);
		this.setBackground(Color.black);
		//information format
		characterInfo = new String[Party.memberCount()];
		equipmentInfo = new String[Party.memberCount()];
		//section layout
		initButtons();
		initLabels();
		initComboBox();
	}
	private void 			initButtons(){
		//main menu navigation buttons
		for(int i = 0; i < mainNavButtons.length; i++)
			add(mainNavButtons[i] 	= Base.menuButton(Vocab.MAIN_NAV_NAMES[i].toUpperCase(), Base.borderWidth() + (i * smallWidth), Base.borderHeight(), smallWidth, smallHeight));
		//status menu navigation buttons
		for(int i = 0; i < statusNavButtons.length; i++){
			if (i == statusNavButtons.length - 1)
				add(statusNavButtons[i] 	= Base.menuButton(Vocab.back.toUpperCase(), Base.borderWidth() + (i * smallWidth), Base.borderHeight(), smallWidth, smallHeight));
			else
				add(statusNavButtons[i] 	= Base.menuButton(Party.members()[i].name().toUpperCase(), Base.borderWidth() + (i * smallWidth), Base.borderHeight(), smallWidth, smallHeight));
		}
		//skill menu navigation buttons
		for(int i = 0; i < skillsNavButtons.length; i++){
			if (i == skillsNavButtons.length - 1)
				add(skillsNavButtons[i] 	= Base.menuButton(Vocab.back.toUpperCase(), Base.borderWidth() + (i * smallWidth), Base.borderHeight(), smallWidth, smallHeight));
			else
				add(skillsNavButtons[i] 	= Base.menuButton(Party.members()[i].name().toUpperCase(), Base.borderWidth() + (i * smallWidth), Base.borderHeight(), smallWidth, smallHeight));
		}
		//inventory menu navigation buttons
		for(int i = 0; i < inventoryNavButtons.length; i++)
			add(inventoryNavButtons[i] 	= Base.menuButton(Vocab.INV_NAV_NAMES[i].toUpperCase(), Base.borderWidth() + (i * smallWidth), Base.borderHeight(), smallWidth, smallHeight));
		//action buttons
		add(okButton 		= Base.menuButton("ok".toUpperCase(), ((Base.width() - medWidth) / 2) + (smallWidth * 2) - Base.borderWidth() - Base.sectionBorder(), ((Base.height() - medHeight) / 2) + (smallHeight * 2), smallWidth, smallHeight));
		add(cancelButton 	= Base.menuButton("cancel".toUpperCase(), ((Base.width() - medWidth) / 2) + Base.borderWidth(), ((Base.height() - medHeight) / 2) + (smallHeight * 2), smallWidth, smallHeight));
		add(useButton 		= Base.menuButton(Vocab.use.toUpperCase(), Base.borderWidth() + ((medWidth - smallWidth) / 2), ((longHeight - smallHeight / 2) / 2) + (smallHeight * 4), smallWidth, smallHeight));
		add(equipButton 	= Base.menuButton(Vocab.equip.toUpperCase(), Base.borderWidth() + ((medWidth - smallWidth) / 2), ((longHeight - smallHeight / 2) / 2) + (smallHeight * 4), smallWidth, smallHeight));
		add(discardButton 	= Base.menuButton(Vocab.discard.toUpperCase(), Base.borderWidth() + ((medWidth - smallWidth) / 2), ((longHeight - smallHeight / 2) / 2) + (smallHeight * 5), smallWidth, smallHeight));
		//set z-axis
		setComponentZOrder(okButton, 0);
		setComponentZOrder(cancelButton, 0);
		setComponentZOrder(useButton, 4);
		setComponentZOrder(equipButton, 4);
		setComponentZOrder(discardButton, 4);
	}
	private void 			initLabels(){
		add(popupBox 		= Base.menuLabel("", SwingConstants.CENTER, SwingConstants.TOP, (Base.width() - medWidth) / 2, (Base.height() - medHeight) / 2, medWidth, medHeight));
		popupBox.setOpaque(true);
		popupBox.setBackground(Color.black);
		add(infoBox 		= Base.menuLabel("", SwingConstants.LEFT, SwingConstants.CENTER, Base.borderWidth(), Base.borderHeight() + smallHeight + 5, longWidth, smallHeight));
		add(leftBox 		= Base.menuLabel("", SwingConstants.LEFT, SwingConstants.TOP, Base.borderWidth(), Base.borderHeight() + smallHeight * 2+ Base.sectionBorder() * 2, medWidth, longHeight));
		add(rightBox 		= Base.menuLabel("", SwingConstants.LEFT, SwingConstants.TOP, Base.borderWidth() + medWidth + Base.sectionBorder(), Base.borderHeight() + smallHeight * 2+ Base.sectionBorder() * 2, medWidth, longHeight));
		partyBox = new JLabel[Party.memberCount()];
		for(int i = 0; i < partyBox.length; i++){
			if (i == 0)
				add(partyBox[i] = Base.menuLabel("", SwingConstants.LEFT, SwingConstants.CENTER, Base.borderWidth(), Base.borderHeight() + (smallHeight * 2) + (Base.sectionBorder() * 2), medWidth, medHeight));
			if (i == 1)
				add(partyBox[i] = Base.menuLabel("", SwingConstants.LEFT, SwingConstants.CENTER, Base.borderWidth() + medWidth + Base.sectionBorder(), Base.borderHeight() + (smallHeight * 2) + (Base.sectionBorder() * 2), medWidth, medHeight));
			if (i == 2)
				add(partyBox[i] = Base.menuLabel("", SwingConstants.LEFT, SwingConstants.CENTER, Base.borderWidth(), Base.borderHeight() + medHeight + (smallHeight * 2) + (Base.sectionBorder() * 3), medWidth, medHeight));
			if (i == 3)
				add(partyBox[i] = Base.menuLabel("", SwingConstants.LEFT, SwingConstants.CENTER, Base.borderWidth() + medWidth + Base.sectionBorder(), Base.borderHeight() + medHeight + (smallHeight * 2) + (Base.sectionBorder() * 3), medWidth, medHeight));
			setComponentZOrder(partyBox[i], 3);
		}
		setComponentZOrder(popupBox, 2);
		setComponentZOrder(infoBox, 5);
		setComponentZOrder(leftBox, 5);
		setComponentZOrder(rightBox, 5);

	}
	private void 			initComboBox(){
		add(inventorySelectBox = Base.menuComboBox(invModel, Base.borderWidth() + ((medWidth - (smallWidth * 2)) / 2), (longHeight - smallHeight / 2) / 2, smallWidth * 2, smallHeight));
		add(characterSelectBox = Base.menuComboBox(charModel, ((Base.width() - medWidth) / 2) + ((medWidth - smallWidth * 2) / 2), (((Base.height() - medHeight) / 2) + smallHeight) - Base.sectionBorder(), smallWidth * 2, smallHeight));
		setComponentZOrder(inventorySelectBox, 4);
		setComponentZOrder(characterSelectBox, 0);
	}
	private void 			initNavigation(){
		mainNavigation();
		statusNavigation();
		skillNavigation();
		inventoryNavigation();
	}
	private void 			initSelection(){
		skillSelection();
		inventorySelection();
		popupSelection();
	}
//************************************************************
/**
*	Navigation Actions
*/
//************************************************************
	private void 			mainNavigation(){
		//go to status menu
		mainNavButtons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
				displayStatusMenu();
			}
		});
		//go to skill menu
		mainNavButtons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
				displaySkillMenu();
			}
		});
		//go to item menu
		mainNavButtons[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
				displayInventoryMenu();
			}
		});
		//exit menu
		mainNavButtons[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(Base.cards.getLayout());
		        cl.show(Base.cards, Base.TITLE_CARD);
			}
		});
	}
	private void 			statusNavigation(){
		for(int i = 0; i < statusNavButtons.length; i++){
			if (i != statusNavButtons.length - 1)
				//go to character[i] menu
				statusNavButtons[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						for (int i = 0; i < Party.memberCount(); i++){
							if (Party.memberCount() > i){
								if (arg0.getActionCommand().contains(statusNavButtons[i].getActionCommand())){
									infoBox.setText(Party.members()[i].roleType().name());
									leftBox.setText(characterInfo[i]);
									rightBox.setText(equipmentInfo[i]);
								}
							}
						}
					}
				});
		}
		//go to main menu
		statusNavButtons[statusNavButtons.length - 1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
				displayMainMenu();
			}
		});
	}
	private void 			skillNavigation(){
		for(int i = 0; i < skillsNavButtons.length; i++){
			if (i != skillsNavButtons.length - 1)
				//go to character[i] skills
				skillsNavButtons[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						for (int i = 0; i < Party.memberCount(); i++){
							if (Party.memberCount() > i){
								if (arg0.getActionCommand().contains(skillsNavButtons[i].getActionCommand())){
									//set initial text
									leftBox.setText(Party.members()[i].name().toUpperCase());
									if (Party.members()[i].skillList()[0] != null){
										infoBox.setText(inventoryInfoBox(Party.members()[i].skillList()[0].description()));
										rightBox.setText(inventoryAttributes(Party.members()[i].skillList()[0]));
									}
									else{
										infoBox.setText("");
										rightBox.setText("");
									}
									//fill combo box
									updateInventory(Party.members()[i].skillCount(), Party.members()[i].skillList());
								}
							}
						}
					}
				});
		}
		//go to main menu
		skillsNavButtons[skillsNavButtons.length - 1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
				displayMainMenu();
			}
		});
	}
	private void 			inventoryNavigation(){
		//go to item selection
		inventoryNavButtons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//set initial text
				leftBox.setText(Vocab.items.toUpperCase());
				if (Party.items()[0] != null){
					infoBox.setText(inventoryInfoBox(Party.items()[0].description()));
					rightBox.setText(inventoryAttributes(Party.items()[0]));
				}
				else{
					infoBox.setText("");
					rightBox.setText("");
				}
				//set visibility
				useButton.setVisible(true);
				equipButton.setVisible(false);
				//fill combo box
				updateInventory(Party.itemCount(), Party.items());
			}
		});
		//go to weapon selection
		inventoryNavButtons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//set initial text
				leftBox.setText(Vocab.weapons.toUpperCase());
				if (Party.weapons()[0] != null){
					infoBox.setText(inventoryInfoBox(Party.weapons()[0].description()));
					rightBox.setText(inventoryAttributes(Party.weapons()[0]));
				}
				else{
					infoBox.setText("");
					rightBox.setText("");
				}
				//set visibility
				useButton.setVisible(false);
				equipButton.setVisible(true);
				//fill combo box
				updateInventory(Party.weaponCount(), Party.weapons());
			}
		});
		//go to armor selection
		inventoryNavButtons[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//set initial text
				leftBox.setText(Vocab.armors.toUpperCase());
				if (Party.armors()[0] != null){
					infoBox.setText(inventoryInfoBox(Party.armors()[0].description()));
					rightBox.setText(inventoryAttributes(Party.armors()[0]));
				}
				else{
					infoBox.setText("");
					rightBox.setText("");
				}
				//set visibility
				useButton.setVisible(false);
				equipButton.setVisible(true);
				//fill combo box
				updateInventory(Party.armorCount(), Party.armors());
			}
		});
		//go to main menu
		inventoryNavButtons[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
				displayMainMenu();
			}
		});
	}
//************************************************************
/**
*	Item Selection
*/
//************************************************************
	private void 			skillSelection(){
		//select skill
		inventorySelectBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inventorySelectBox.getSelectedIndex() != -1){
					for (int i = 0; i < Party.memberCount(); i++){
						if (Party.memberCount() > i){
							if (leftBox.getText().contains(Party.members()[i].name().toUpperCase())){
								infoBox.setText(inventoryInfoBox(Party.members()[i].skillList()[inventorySelectBox.getSelectedIndex()].description()));
								rightBox.setText(inventoryAttributes(Party.members()[i].skillList()[inventorySelectBox.getSelectedIndex()]));
							}
						}
					}
				}
			}
		});
		//use skill
		
	}
	private void 			inventorySelection(){
		//select item
		inventorySelectBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inventorySelectBox.getSelectedIndex() != -1){
					if (leftBox.getText().contains(Vocab.armors.toUpperCase())){
						infoBox.setText(inventoryInfoBox(Party.armors()[inventorySelectBox.getSelectedIndex()].description()));
						rightBox.setText(inventoryAttributes(Party.armors()[inventorySelectBox.getSelectedIndex()]));
					}
					if (leftBox.getText().contains(Vocab.items.toUpperCase())){
						infoBox.setText(inventoryInfoBox(Party.items()[inventorySelectBox.getSelectedIndex()].description()));
						rightBox.setText(inventoryAttributes(Party.items()[inventorySelectBox.getSelectedIndex()]));
					}
					if (leftBox.getText().contains(Vocab.weapons.toUpperCase())){
						infoBox.setText(inventoryInfoBox(Party.weapons()[inventorySelectBox.getSelectedIndex()].description()));
						rightBox.setText(inventoryAttributes(Party.weapons()[inventorySelectBox.getSelectedIndex()]));
					}
				}
			}
		});
		//use item
		useButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (inventorySelectBox.getSelectedIndex() != -1){
					popupBox.setText(Message.charSelect);
					displayCharSelect();
				}
			}
		});
		//discard item
		discardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (inventorySelectBox.getSelectedIndex() != -1){
					popupBox.setText(Message.confirm);
					displayPopupBox();
				}
			}
		});
	}
	private void 			popupSelection(){
		//select character
		characterSelectBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (characterSelectBox.getSelectedIndex() != -1){
					//skills
					for (int i = 0; i < Party.memberCount(); i++){
						if (Party.memberCount() > i){
							if (leftBox.getText().contains(Party.members()[i].name().toUpperCase())){
								for (Type effect: Party.members()[i].skillList()[inventorySelectBox.getSelectedIndex()].effectType()){
									//target is dead
									if (effect.id() != 8 && Party.members()[characterSelectBox.getSelectedIndex()].isDead())
										okButton.setEnabled(false);
									//revive character, target is not dead
									else if (effect.id() == 8 && !Party.members()[characterSelectBox.getSelectedIndex()].isDead())
										okButton.setEnabled(false);
									//heal hp character, hp is full
									else if (effect.id() == 2 && Party.members()[characterSelectBox.getSelectedIndex()].hp() == Party.members()[characterSelectBox.getSelectedIndex()].mhp())
										okButton.setEnabled(false);
									//not enough mp
									else if (Party.members()[i].mp() < Party.members()[i].skillList()[inventorySelectBox.getSelectedIndex()].cost())
										okButton.setEnabled(false);
									//not usable in menu
									else if (effect.id() != 8 && effect.id() != 2)
										okButton.setEnabled(false);
									else
										okButton.setEnabled(true);
								}
							}
						}
					}
					//items
					if (leftBox.getText().contains(Vocab.items.toUpperCase())){
						for (Type effect: Party.items()[inventorySelectBox.getSelectedIndex()].effectType()){
							if (effect.id() != 8 && Party.members()[characterSelectBox.getSelectedIndex()].isDead())
								okButton.setEnabled(false);
							else if (effect.id() == 8 && !Party.members()[characterSelectBox.getSelectedIndex()].isDead())
								okButton.setEnabled(false);
							else if (effect.id() == 2 && Party.members()[characterSelectBox.getSelectedIndex()].hp() == Party.members()[characterSelectBox.getSelectedIndex()].mhp())
								okButton.setEnabled(false);
							else
								okButton.setEnabled(true);
						}
					}
				}
			}
		});
		//okay button
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//skills
				for (int i = 0; i < Party.memberCount(); i++){
					if (Party.memberCount() > i){
						if (leftBox.getText().contains(Party.members()[i].name().toUpperCase())){
							Party.members()[i].skillList()[inventorySelectBox.getSelectedIndex()].applyEffects(Party.members()[i], Party.members()[characterSelectBox.getSelectedIndex()]);
						}
					}
				}
				//inventory
				if (leftBox.getText().contains(Vocab.armors.toUpperCase())){
					Party.removeArmor(inventorySelectBox.getSelectedIndex());
					updateInventory(Party.armorCount(), Party.armors());
				}
				if (leftBox.getText().contains(Vocab.items.toUpperCase())){
					Party.items()[inventorySelectBox.getSelectedIndex()].applyEffects(Party.members()[characterSelectBox.getSelectedIndex()], Party.members()[characterSelectBox.getSelectedIndex()]);
					Party.removeItem(inventorySelectBox.getSelectedIndex());
					updateInventory(Party.itemCount(), Party.items());
				}
				if (leftBox.getText().contains(Vocab.weapons.toUpperCase())){
					Party.removeWeapon(inventorySelectBox.getSelectedIndex());
					updateInventory(Party.weaponCount(), Party.weapons());
				}
				clearPopupBox();
			}
		});
		//cancel button
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearPopupBox();
			}
		});
	}
//************************************************************
/**
*	Information Format
*/
//************************************************************
	private void 			updateCharacterInfo(){
		for(int i = 0; i < Party.memberCount(); i++){
			characterInfo[i] = characterInfo(i);
			equipmentInfo[i] = equipmentInfo(i);
		}
	}
	private void 			updateInventory(int itemCount, item.Base[] items){
		invModel.removeAllElements();
		for (int i = 0; i < itemCount; i++){
			if (items[i] != null)
				invModel.addElement(items[i].name());
		}
		inventorySelectBox.setModel(invModel);
		if (itemCount > 0)
			inventorySelectBox.setSelectedIndex(0);
		else{
			rightBox.setText("");
			infoBox.setText("");
		}
	}
	private void 			updateCharacterSelect(){
		charModel.removeAllElements();
		for (int i = 0; i < Party.memberCount(); i++){
			if (Party.members()[i] != null)
				charModel.addElement(Party.members()[i].name());
		}
		characterSelectBox.setModel(charModel);
		if (Party.memberCount() > 0)
			characterSelectBox.setSelectedIndex(0);
	}
	private String 			characterInfo(int i){
		return 	Message.open +
				Party.members()[i].name() + Message.brk + Message.brk +
				Vocab.lv.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.lv.length()) + Party.members()[i].lv() + Message.brk +
				Vocab.hp.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.hp.length()) + Party.members()[i].hp() + "/" + Party.members()[i].mhp() + Message.brk +
				Vocab.mp.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.mp.length()) + Party.members()[i].mp() + "/" + Party.members()[i].mmp() + Message.brk +
				Vocab.atk.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.atk.length()) + Party.members()[i].atk() + Message.brk +
				Vocab.def.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.def.length()) + Party.members()[i].def() + Message.brk +
				Vocab.mat.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.mat.length()) + Party.members()[i].mat() + Message.brk +
				Vocab.mdf.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.mdf.length()) + Party.members()[i].mdf() + Message.brk +
				Vocab.agi.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.agi.length()) + Party.members()[i].agi() + Message.brk +
				Vocab.luk.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.luk.length()) + Party.members()[i].luk() + Message.brk +
				Vocab.exp.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.exp.length()) + Party.members()[i].exp() + Message.brk +
				Vocab.next.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.next.length()) + Party.members()[i].next() + Message.brk +
				Message.close;
	}
	private String 			equipmentInfo(int i){
		String s = 	Message.open +
					Vocab.equipment.toUpperCase() + Message.brk + Message.brk;
		
		for (int j = 0; j < Party.members()[i].equipmentList().length; j++){
			s += Vocab.equipmentList[j].toUpperCase() + ":" + display.Base.htmlSpace(10 - Vocab.equipmentList[j].length());
			if (Party.members()[i].equipmentList()[j] != null)
				s += Party.members()[i].equipmentList()[j].name() + Message.brk;
			else
				s += Vocab.empty.toUpperCase() + Message.brk;
		}
		s += Message.close;
		return s;
	}
	private String 			mainInfo(){
		return 	Message.open +
				Vocab.gold.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.gold.length()) + Party.gold() +
				Message.close;
	}
	private String 			partyInfo(int i){
		return 	Message.open +
				Party.members()[i].name() + Message.brk +
				Vocab.lv.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.lv.length()) + Party.members()[i].lv() + Message.brk +
				Vocab.hp.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.hp.length()) + Party.members()[i].hp() + "/" + Party.members()[i].mhp() + Message.brk +
				Vocab.mp.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.mp.length()) + Party.members()[i].mp() + "/" + Party.members()[i].mmp() + Message.brk +
				Vocab.exp.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.exp.length()) + Party.members()[i].exp() + Message.brk +
				Vocab.next.toUpperCase() + ":" + display.Base.htmlSpace(5 - Vocab.next.length()) + Party.members()[i].next() + Message.brk +
				Message.close;
	}
	private String 			inventoryInfoBox(String s){
		return 	Message.open + 
				s +
				Message.close;
	}
	private String 			inventoryAttributes(item.Base item){
		String s = Message.open;
		//item type
		if (item.isItem()){
			for (Type t: ((Item)item).effectType())
				s += t.name() + Message.brk;
			s+= Message.brk;
		}
		if (item.isArmor())
			s += ((Armor)item).weightType().name() + Message.brk + Message.brk;
		if (item.isWeapon())
			s += ((Weapon)item).weaponType().name() + Message.brk + Message.brk;
		//attributes
		if (!item.isItem()){
			for(int i = 0; i < item.elementList().length - 1; i++){
				if (i < item.attributeList().length){
					s += Vocab.attributeList[i + 2].toUpperCase() + ":" + display.Base.htmlSpace(4 - Vocab.attributeList[i + 2].length());
					if (item.attributeList()[i] >= 0)
						s += "+" + item.attributeList()[i];
					else
						s += item.attributeList()[i] + " ";
					s += display.Base.htmlSpace(12 - String.valueOf(item.attributeList()[i]).length());
				}
				else
					s += display.Base.htmlSpace(18);
				//elements
				s += Vocab.elementList[i + 1].toUpperCase() + ":" + display.Base.htmlSpace(6 - Vocab.elementList[i + 1].length());
				if (item.elementList()[i + 1] >= 0)
					s += "+";
				s += item.elementList()[i + 1];
				s += Message.brk;
			}
		}
		s += Message.close;
		return 	s;
	}
//************************************************************
/**
*	Set Visibility
*/
//************************************************************
	private void 			displayMainMenu(){
		updateCharacterInfo();
		//fill in text
		infoBox.setText(mainInfo());
		for(int i = 0; i < partyBox.length; i++)
			partyBox[i].setText(partyInfo(i));
		//set visibility
		for(JButton b: mainNavButtons)
			b.setVisible(true);
		infoBox.setVisible(true);
		for(JLabel l: partyBox)
			l.setVisible(true);
	}
	private void 			displayStatusMenu(){
		updateCharacterInfo();
		//fill in text
		infoBox.setText(Party.members()[0].roleType().name());
		leftBox.setText(characterInfo[0]);
		rightBox.setText(equipmentInfo[0]);
		//set visibility
		for(JButton b: statusNavButtons)
			b.setVisible(true);
		infoBox.setVisible(true);
		leftBox.setVisible(true);
		rightBox.setVisible(true);
	}
	private void 			displaySkillMenu(){
		updateCharacterInfo();
		//fill in text
		leftBox.setText(Party.members()[0].name().toUpperCase());
		if (Party.members()[0].skillList()[0] != null){
			infoBox.setText(inventoryInfoBox(Party.members()[0].skillList()[0].description()));
			rightBox.setText(inventoryAttributes(Party.members()[0].skillList()[0]));
		}
		else{
			infoBox.setText("");
			rightBox.setText("");
		}
		//fill combo box
		updateInventory(Party.members()[0].skillCount(), Party.members()[0].skillList());
		//set visibility
		for(JButton b: skillsNavButtons)
			b.setVisible(true);
		useButton.setVisible(true);
		infoBox.setVisible(true);
		leftBox.setVisible(true);
		rightBox.setVisible(true);
		inventorySelectBox.setVisible(true);
	}
	private void 			displayInventoryMenu(){
		updateCharacterInfo();
		//fill in text
		leftBox.setText(Vocab.items.toUpperCase());
		if (Party.items()[0] != null){
			infoBox.setText(inventoryInfoBox(Party.items()[0].description()));
			rightBox.setText(inventoryAttributes(Party.items()[0]));
		}
		else{
			infoBox.setText("");
			rightBox.setText("");
		}
		//fill combo box
		updateInventory(Party.itemCount(), Party.items());
		//set visibility
		for(JButton b: inventoryNavButtons)
			b.setVisible(true);
		useButton.setVisible(true);
		discardButton.setVisible(true);
		infoBox.setVisible(true);
		leftBox.setVisible(true);
		rightBox.setVisible(true);
		inventorySelectBox.setVisible(true);
	}
	private void 			displayPopupBox(){
		setEnabledBackground(false);
		popupBox.setVisible(true);
		okButton.setVisible(true);
		cancelButton.setVisible(true);
	}
	private void 			displayCharSelect(){
		setEnabledBackground(false);
		updateCharacterSelect();
		popupBox.setVisible(true);
		characterSelectBox.setVisible(true);
		okButton.setVisible(true);
		cancelButton.setVisible(true);
	}
	private void 			clearPopupBox(){
		setEnabledBackground(true);
		okButton.setEnabled(true);
		popupBox.setVisible(false);
		okButton.setVisible(false);
		cancelButton.setVisible(false);
		characterSelectBox.setVisible(false);
	}
	private void 			setEnabledBackground(boolean bool){
		//navigation
		for(JButton b: mainNavButtons)
			b.setEnabled(bool);
		for(JButton b: skillsNavButtons)
			b.setEnabled(bool);
		for(JButton b: statusNavButtons)
			b.setEnabled(bool);
		for(JButton b: inventoryNavButtons)
			b.setEnabled(bool);
		//action buttons
		useButton.setEnabled(bool);
		equipButton.setEnabled(bool);
		discardButton.setEnabled(bool);
		//combo box
		inventorySelectBox.setEnabled(bool);
	}
	private void 			clear(){
		//navigation
		for(JButton b: mainNavButtons)
			b.setVisible(false);
		for(JButton b: skillsNavButtons)
			b.setVisible(false);
		for(JButton b: statusNavButtons)
			b.setVisible(false);
		for(JButton b: inventoryNavButtons)
			b.setVisible(false);
		//buttons
		okButton.setVisible(false);
		cancelButton.setVisible(false);
		useButton.setVisible(false);
		equipButton.setVisible(false);
		discardButton.setVisible(false);
		//labels
		popupBox.setVisible(false);
		infoBox.setVisible(false);
		for(JLabel l: partyBox)
			l.setVisible(false);
		leftBox.setVisible(false);
		rightBox.setVisible(false);
		//combo box
		inventorySelectBox.setVisible(false);
		characterSelectBox.setVisible(false);
	}
}
