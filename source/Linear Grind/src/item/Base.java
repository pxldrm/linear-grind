//************************************************************
/**
*	Base 		Superclass for all item classes.
*	
*	@author		pxldrm
*	@since		7/11/2017
* 	@update 	8/10/2017
*/
//************************************************************
package item;
import data.Global;
import game.Type;
public class Base {
//************************************************************
/**
*	Variables
*/
//************************************************************
	protected int 		id;
	protected String 	name;
	protected int 		cost;
	protected Type[] 	effectType;
	protected Type 		damageType;
	protected int[] 	attributeList;
	protected int[] 	elementList;
	protected String 	description;
//************************************************************
/**
*	Constructor
*/
//************************************************************
	public 				Base(int id, String name, int cost, int[] effectType, int damageType, int[] attributeList, int[] elementList, String description){
		this.id 			= id;
		this.name 			= name;
		this.cost 			= cost;
		this.effectType 	= new Type[effectType.length];
		for (int i = 0; i < effectType.length; i++){
			this.effectType[i] 	= Global.effectTypes[effectType[i]];
		}
		this.damageType 	= Global.damageTypes[damageType];
		this.attributeList 	= attributeList;
		this.elementList 	= elementList;
		this.description 	= description;
	}
//************************************************************
/**
*	Accessors
*/
//************************************************************
	public int 			id(){
		return id;
	}
	public String 		name (){
		return name;
	}
	public int 			cost(){
		return cost;
	}
	public Type[] 		effectType(){
		return effectType;
	}
	public Type 		damageType(){
		return damageType;
	}
	public int[] 		attributeList(){
		return attributeList;
	}
	public int[] 		elementList(){
		return elementList;
	}
	public String 		description(){
		return description;
	}
//************************************************************
/**
*	Booleans
*/
//************************************************************
	public boolean 		isArmor()
	{
		if (this.getClass().equals(Armor.class))
			return true;
		else
			return false;
	}
	public boolean 		isItem()
	{
		if (this.getClass().equals(Item.class))
			return true;
		else
			return false;
	}
	public boolean 		isSkill()
	{
		if (this.getClass().equals(Skill.class))
			return true;
		else
			return false;
	}
	public boolean 		isWeapon()
	{
		if (this.getClass().equals(Weapon.class))
			return true;
		else
			return false;
	}
//************************************************************
/**
*	Effects
*/
//************************************************************
	public void 		applyEffects(battler.Base user, battler.Base target){
		for (Type effect: effectType)
		{
			switch (effect.id())
			{
			//none
			case 0:
				break;
			//hp damage
			case 1:
				//none
				if (this.damageType().id() == 0){
					if (this.isItem())
						target.modHp(((Item) this).damageValue());
					if (this.isSkill()){
						user.modMp(- ((Skill) this).cost());
						target.modHp(((Skill) this).damageValue() * user.mat());
					}
				}
//				
//				//physical
//				if (this.damageType().id() == 1)
//					
//				//magical
//				if (this.damageType().id() == 2)
				
				

					
//				if (damageType.id() == 0)
//				{
//					dmg = recoverHp(user, target);
//					target.gain_hp(dmg);
//				}
//				Messages.itemEffectMsg(target.name(), dmg, Vocab.hp_s);
//				if (target.isDead()) Messages.deadMsg(target.name());
//				else Messages.statusMsg(target.name(), target.hp(), target.mhp());
				break;
			//hp recovery
			case 2:
				if (this.isItem())
					target.modHp(((Item) this).damageValue());
				if (this.isSkill()){
					user.modMp(- ((Skill) this).cost());
					target.modHp(((Skill) this).damageValue() * user.mat());
				}
					
				break;
			//mp damage
			case 3:
				break;
			//mp recovery
			case 4:
				break;
			//defend
			case 5:
				break;
			//escape
			case 6:
				break;
			//paralyze
			case 7:
				break;
			//revive
			case 8:
				if (this.isItem())
					target.modHp((int)((((Item) this).damageValue() * 0.01) * target.mhp()));
				if (this.isSkill())
					target.modHp((int)((((Item) this).damageValue() * 0.01) * target.mhp()));
				break;
			}
		}
	}
}
