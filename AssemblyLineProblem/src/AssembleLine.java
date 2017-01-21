
public class AssembleLine {
	public Station[] getStations() {
		return stations;
	}
	public void setStations(Station[] stations) {
		this.stations = stations;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Station stations [];
	private String name;
	private int entryTime;
	public AssembleLine(String name,int entryTime, int exitTime,Station [] stations) {
		this.name=name;
		this.entryTime = entryTime;
		this.exitTime = exitTime;
		this.stations=stations;
	}
	private int exitTime;
	public int getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(int entryTime) {
		this.entryTime = entryTime;
	}
	public int getExitTime() {
		return exitTime;
	}
	public void setExitTime(int exitTime) {
		this.exitTime = exitTime;
	}



}
