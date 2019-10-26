package building;

import java.util.HashMap;
import java.util.Map;
import building.base.Building;
import building.base.ItemReceiver;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import ui.BuildingIcon;

public class Chest extends Building implements ItemReceiver {
	private Map<ItemType,Integer> Inventory=new HashMap<ItemType,Integer>();
	public void operate() {
		
	}

	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/chest.png");
		target.getChildren().add(icon);
		
		Label numberOfItemsLabel = new Label();
		String numberOfItemsText = Integer.toString(this.getInventory().values().stream().reduce(0, (a, b) -> a+b));
		numberOfItemsLabel.setText(numberOfItemsText);
		StackPane.setAlignment(numberOfItemsLabel, Pos.TOP_CENTER);

		target.getChildren().add(numberOfItemsLabel);
	}
	
	/* getters & setters */
	public boolean canReceiveItem(ItemType ofType) {
		return true;
	}
	public void receiveItem(Item item) {
		Inventory.putIfAbsent(item.getType(), 0); 
		Inventory.put(item.getType(),Inventory.get(item.getType())+1);
	}
	public Map<ItemType, Integer> getInventory() {
		return Inventory;
	}

}