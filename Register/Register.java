package Register;

public class Register {
private String name;
private  String password;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Register() {
	}
public Register(String name,String password) {
	this.name=name;
	this.password=password;
}
@Override
public String toString() {
	return "Register[name=" + name + ", Password=" + password + "]";
}

@Override
public boolean equals(Object obj) {
	if(obj instanceof Register) {
		if(this==obj)
			return true;
		Register register = (Register)obj;
		if(this.name.equals(register.name)&& this.password.equals(register.password)) 
			return true;
		
}
	
return false;
}
}
