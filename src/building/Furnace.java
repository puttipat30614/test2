package building;

import building.base.Building;
import building.base.ItemProducer;
import building.base.ItemReceiver;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import logic.GameState;
import ui.BuildingIcon;
import ui.ItemIcon;

public class Furnace extends Building implements ItemProducer, ItemReceiver {

	private static final int CRAFT_DELAY = 3;
	private static final int ENERGY_CONSUMPTION = 10;
	private boolean hasIron=false;
	private boolean hasProduct=false;
	private int cycles=0;
	public void operate() {
		if(hasIron) {
			if(!hasProduct && cycles!=3 && GameState.instance.consumeElectricity(ENERGY_CONSUMPTION)) {
				cycles++;
			}
			if(cycles==3) {
				cycles=0;
				hasProduct=true;
				hasIron=false;
			}
			//TODO:: If receive Iron when it has a product but has not receive what will we do
		}
	}
	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/furnace.png");
		target.getChildren().add(icon);
		
		// TODO: fill these booleans
		boolean readyToProduceIronPlate;		// is this furnace ready to produce an iron plate?
					// does this furnace has iron in it?
		
		ItemIcon itemIcon = null;
		if (canProduceItem()) {
			itemIcon = ItemType.IRON_PLATE.toItemIcon();
		} else if(hasIron) {
			itemIcon = ItemType.IRON.toItemIcon();
		}
		
		if(itemIcon != null) {
			StackPane.setAlignment(itemIcon, Pos.TOP_CENTER);
			target.getChildren().add(itemIcon);
		}
	}
	public boolean canReceiveItem(ItemType ofType) {
		if(ofType==ItemType.IRON) {
			if(!hasIron && !hasProduct) return true;
		}
		return false;
	}
	public void receiveItem(Item item) {
		hasIron=true;
	}
	public boolean canProduceItem() {
		return hasProduct;
	}
	public Item getProducedItem() {
		hasProduct=false;
		return Item.ironPlate();
	}

}
