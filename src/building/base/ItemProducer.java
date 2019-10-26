package building.base;

import item.Item;

public interface ItemProducer {
	public boolean canProduceItem();
	public Item getProducedItem();
}
