package iut_lens.dut_info.monopoly.core.element;

import iut_lens.dut_info.monopoly.core.Content;

public abstract class Element implements ElementI {
	
	protected Content content;
	
	
	public Element(Content content) {
		this.content = content;
	}

}
