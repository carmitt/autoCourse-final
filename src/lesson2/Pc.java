package lesson2;

public class Pc {
	
	String cpuType;
	
	int cpuSpeed;

	public Pc(String cpuType, int cpuSpeed) {
		this.cpuType = cpuType;
		this.cpuSpeed = cpuSpeed;
	}

	public String getCpuType() {
		return cpuType;
	}

	public void setCpuType(String cpuType) {
		this.cpuType = cpuType;
	}

	public int getCpuSpeed() {
		return cpuSpeed;
	}

	public void setCpuSpeed(int cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}
	
	

}
