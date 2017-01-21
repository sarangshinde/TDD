
public class Station {

	public int getStationNumber() {
		return stationNumber;
	}
	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
	}
	public int getTimeSpentAtStation() {
		return timeSpentAtStation;
	}
	public void setTimeSpentAtStation(int timeSpentAtStation) {
		this.timeSpentAtStation = timeSpentAtStation;
	}
	private int stationNumber;
	private int lineChangeCost;
	public int getLineChangeCost() {
		return lineChangeCost;
	}
	public void setLineChangeCost(int lineChangeCost) {
		this.lineChangeCost = lineChangeCost;
	}
	public Station(int stationNumber, int timeSpentAtStation,int lineChangeCost) {
		super();
		this.stationNumber = stationNumber;
		this.timeSpentAtStation = timeSpentAtStation;
		this.lineChangeCost=lineChangeCost;
	}
	private int timeSpentAtStation;
}
