package building;

import java.util.*;

import building.base.Building;
import building.base.ItemProducer;
import building.base.ItemReceiver;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import logic.GameState;
import ui.BuildingIcon;

public class Anvil extends Building implements ItemProducer, ItemReceiver {
	private static final int CRAFT_DELAY = 5;
	private static final int ENERGY_CONSUMPTION = 15;
	private int cycles=0;
	private Map<ItemType,Integer> inven=new HashMap<ItemType,Integer>();
	@Override
	public void operate() {
		if(canProduceItem()) {
			return;
		}
		else {
			if(inven.getOrDefault(ItemType.WOOD,0)==1 && inven.getOrDefault(ItemType.IRON_PLATE,0)==1 && GameState.instance.consumeElectricity(ENERGY_CONSUMPTION)) {
				cycles++;
			}
		}
	}
	
	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/anvil.png");
		target.getChildren().add(icon);
		
		
		HBox status = new HBox();
		StackPane.setAlignment(status, Pos.TOP_CENTER);
		
		// TODO: fill this booleans
		boolean ready;			// is this anvil ready (finished crafting iron sword)?
		boolean hasWood;		// does this anvil has wood on it?
		boolean hasIronPlate;	// does this anvil has an iron plate on it?
		
		if(canProduceItem()) {
			status.getChildren().add(ItemType.IRON_SWORD.toItemIcon());
		} else {
			if(inven.get(ItemType.WOOD)!=null) {
				status.getChildren().add(ItemType.WOOD.toItemIcon());
			}
			if(inven.get(ItemType.IRON_PLATE)!=null) {
				status.getChildren().add(ItemType.IRON_PLATE.toItemIcon());
			}
		}
		target.getChildren().add(status);
	}
	public boolean canReceiveItem(ItemType ofType) {
		if(ofType==ItemType.WOOD || ofType==ItemType.IRON_PLATE) {
			if(ofType==ItemType.WOOD) {
				if(inven.getOrDefault(ItemType.WOOD,0)==0) return true;
			}
			else if(ofType==ItemType.IRON_PLATE) {
				if(inven.getOrDefault(ItemType.IRON_PLATE,0)==0) return true;
			}
		}
		return false;
	}
	public void receiveItem(Item item) {
		if(item.getType()==ItemType.WOOD) inven.put(ItemType.WOOD, 1);
		if(item.getType()==ItemType.IRON_PLATE) inven.put(ItemType.IRON_PLATE, 1);
	}
	public boolean canProduceItem() {
		if(cycles==5) return true;
		else return false;
	}
	public Item getProducedItem() {
		inven.put(ItemType.WOOD, 0);
		inven.put(ItemType.IRON_PLATE, 0);
		cycles=0;
		return Item.ironSword();
	}
}
