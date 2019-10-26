package building;

import building.base.Building;
import building.base.ItemProducer;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import logic.GameState;
import ui.BuildingIcon;
import ui.ItemIcon;

public class Drill extends Building implements ItemProducer {

	private static final int HARVEST_INTERVAL = 4;
	private static final int ENERGY_CONSUMPTION = 5;
	private int cycles=0;
	
	public void operate() {
		if(GameState.instance.consumeElectricity(5)) {
			if(cycles!=3) cycles++;
		}
	}
	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/drill.png");
		target.getChildren().add(icon);
		
		// TODO: fill this boolean
			if(canProduceItem()) {
			ItemIcon itemIcon = ItemType.IRON.toItemIcon();
			StackPane.setAlignment(itemIcon, Pos.TOP_CENTER);
			target.getChildren().add(itemIcon);
		}
	}
	public boolean canProduceItem() {
		if(cycles==3) {
			return true;
		}
		return false;
	}
	public Item getProducedItem() {
		cycles=0;
		return Item.iron();
	}
}
