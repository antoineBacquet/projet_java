package iut_lens.dut_info.monopoly.core.element;

import iut_lens.dut_info.monopoly.core.Content;

public abstract class Element implements ElementI {
	
	protected Content content;
	protected boolean isDisabled = false;
	protected ActionListener actionListener;
	
	public Element(Content content) {
		this.content = content;
		this.actionListener = content;
	}
	
	public void setActionListener(ActionListener actionListener){
		this.actionListener = actionListener;
	}
	
	public abstract void disabled();
	public abstract void enable();
	


}
