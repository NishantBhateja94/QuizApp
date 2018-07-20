package Register;

import java.util.ArrayList;

public class RegisterOperations {
	public RegisterOperations() {
	}
	private ArrayList<Register> registerList= new ArrayList<>();
	private static RegisterOperations registerOperations= null;
	public String addItem(Register register) {
		this.registerList.add(register);
		return "User Registered successfully";
	}
	public static RegisterOperations getInstance() {
		if(registerOperations==null)
			registerOperations = new RegisterOperations();
		return registerOperations;
	}

	public int search(String name, String password) {
		Register register = new Register();
		register.setName(name);
		register.setPassword(password);
		return registerList.indexOf(register);

	}
}
