package org.mcteam.ancientgates.commands;

import org.mcteam.ancientgates.Gate;

public class CommandSetMessage extends BaseCommand {
	
	public CommandSetMessage() {
		aliases.add("setmessage");
		aliases.add("setmsg");
		
		requiredParameters.add("id");
		requiredPermission = "ancientgates.setmessage";
		
		optionalParameters.add("msg");
		
		senderMustBePlayer = false;
		
		helpDescription = "Set teleport \"msg\" for the gate.";
	}
	
	public void perform() {	
		String msg = "";
		parameters.remove(0);
		for(String parameter : parameters) {
			msg += " " + parameter;
		}
            
		gate.setMessage(msg.trim());
		
		if (!msg.trim().isEmpty()) {
			sendMessage("Teleport msg for gate \""+gate.getId()+"\" is \""+msg.trim()+"\".");
		} else {
			sendMessage("Teleport msg for gate \""+gate.getId()+"\" removed.");
		}
		
		Gate.save();
	}
        
}