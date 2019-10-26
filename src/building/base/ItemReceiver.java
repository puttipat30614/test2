package building.base;

import item.Item;
import item.ItemType;

public interface ItemReceiver {
	public boolean canReceiveItem(ItemType ofType);
	public void receiveItem(Item Item);
}