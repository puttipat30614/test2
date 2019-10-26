package building;

import building.base.Building;
import building.base.ItemProducer;
import building.base.ItemReceiver;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import logic.Direction;
import logic.Field;
import ui.BuildingIcon;
import ui.ItemIcon;

public class ConveyorBelt extends Building implements ItemReceiver, ItemProducer {	
	private Direction Direction;
	private Item ItemOnBelt;
	private int action;
	public ConveyorBelt(Direction direction) {
		Direction=direction;
	}

	public void operate() {
		if(canReceiveItem(ItemType.IRON) && Field.instance.getBuildingInBack(Direction)!=null) {
			if(Field.instance.getBuildingInBack(Direction) instanceof ItemProducer) {
				if(((ItemProducer) Field.instance.getBuildingInBack(Direction)).canProduceItem()) {
					receiveItem((((ItemProducer) Field.instance.getBuildingInBack(Direction)).getProducedItem()));
				}
			}
		}
		if(canProduceItem() && Field.instance.getBuildingInFront(Direction)!=null) {
			if(Field.instance.getBuildingInFront(Direction) instanceof ItemReceiver) {
				if(((ItemReceiver) Field.instance.getBuildingInFront(Direction)).canReceiveItem(getItemOnBelt().getType())) {
					((ItemReceiver) Field.instance.getBuildingInFront(Direction)).receiveItem(getProducedItem());
				}
			}
		}
	}
	@Override
	public void beforeCycle() {
		action=0;
	}
	
	public boolean canReceiveItem(ItemType ofType) {
		if(ItemOnBelt==null) {
			if(action==0) return true;
		}
		return false;
	}
	public void receiveItem(Item item) {
		ItemOnBelt=item;
		action=1;
	}
	public boolean canProduceItem() {
		if(action==1) return false;
		if(ItemOnBelt!=null) return true;
		return false;
	}
	public Item getProducedItem() {
		Item Itemout=new Item(ItemOnBelt.getType());
		ItemOnBelt=null;
		action=1;
		return Itemout;
	}
	/* getters & setters */
	public Item getItemOnBelt() {
		return ItemOnBelt;
	}
	
	public Direction getDirection() {
		return Direction;
	}


	@Override
	public void render(StackPane target) {
		
		BuildingIcon icon = new BuildingIcon("file:res/belt.png");
		
		switch(this.getDirection()) {
		case RIGHT:
			icon.setRotate(90);
			break;
		case LEFT:
			icon.setRotate(270);
			break;
		case DOWN:
			icon.setRotate(180);
			break;
		default:
			break;
		}
		
		target.getChildren().add(icon);
		
		Item itemOnBelt = this.getItemOnBelt();
		
		if(itemOnBelt != null) {
			ItemIcon itemIcon = itemOnBelt.getType().toItemIcon();
			StackPane.setAlignment(itemIcon, Pos.TOP_CENTER);
			target.getChildren().add(itemIcon);
		}
	}
}
