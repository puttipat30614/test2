package building.base;

import java.util.Map;

import item.Item;
import javafx.scene.layout.StackPane;
import logic.GameState;

public abstract class Building {
	public abstract void operate();
	public abstract void render(StackPane target);
	public void beforeCycle() {}
}
