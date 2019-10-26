package building;

import building.base.Building;
import building.base.ItemProducer;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import ui.BuildingIcon;
import ui.ItemIcon;

public class Sawmill extends Building implements ItemProducer {

	private static final int HARVEST_INTERVAL = 3;
	private int cycles=0;
	public void operate() {
		if(cycles==3) {
			return;
		}
		cycles++;
	}
	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/sawmill.png");
		target.getChildren().add(icon);
		
		// TODO: fill this boolean
		
		if(canProduceItem()) {
			ItemIcon itemIcon = ItemType.WOOD.toItemIcon();
			StackPane.setAlignment(itemIcon, Pos.TOP_CENTER);
			target.getChildren().add(itemIcon);
		}
	}
	public boolean canProduceItem() {
		if(cycles==3) return true;
		return false;
	}
	public Item getProducedItem() {
		cycles=0;
		return Item.wood();
	}
}
