package iut_lens.dut_info.monopoly.core.element;


public abstract class Element implements ElementI {
	
	//protected Content content;
	protected boolean isDisabled = false;
	protected ActionListener actionListener;
	
	public Element(ActionListener actionListener) {
		//this.content = content;
		this.actionListener = actionListener;
	}
	
	public void setActionListener(ActionListener actionListener){
		this.actionListener = actionListener;
	}
	
	public abstract void disabled();
	public abstract void enable();
	


}
