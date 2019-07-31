package lc.cds.ui.components;

import com.vaadin.ui.Label;

public class TagLabel extends Label {
	
	private int fontSize;
	
	public TagLabel(String text, int fontSize) {
			super(text);
			this.fontSize = fontSize;
			setSizeUndefined();
		}
	
}
