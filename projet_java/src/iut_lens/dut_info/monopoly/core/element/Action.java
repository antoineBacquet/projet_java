package iut_lens.dut_info.monopoly.core.element;

public class Action {
	
	
	public static enum ActionType{CONFIRM,CANCEL,SELECTOR}
	
	private Object source;
	private ActionType actionType;

	public Action(Object source){
		this(source,null);
	}
	
	public Action(Object source,ActionType actionType){
		this.source = source;
		this.actionType = actionType;
	}
	

	public Object getSource() {
		return source;
	}
	
	public ActionType getActionType() {
		return actionType;
	}
	
	

}



