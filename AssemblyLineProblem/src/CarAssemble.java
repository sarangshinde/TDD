import java.util.Arrays;
import java.util.stream.IntStream;

public class CarAssemble {

	private int buildCarChassisTime(AssembleLine line) {
		Station[] stations = line.getStations();
		int assembleTime= line.getEntryTime() + line.getExitTime();
		if(stations==null || stations.length==0)
			return assembleTime;
		else if( stations.length==1)
		{
			return assembleTime+Arrays.stream(stations)
									  .mapToInt(station -> station.getTimeSpentAtStation())
									  .sum();
		}
		else {
				int timeSpentAtAllStations = IntStream.range(1, stations.length)
					 .map(station -> CarAssemble.min(CarAssemble.timeSpentBetweenTwoStations(stations[station-1],stations[station],false),
							 CarAssemble.timeSpentBetweenTwoStations(stations[station-1],stations[station],true)))
					 .sum();
			return assembleTime+timeSpentAtAllStations;
		}

	}


	private static int timeSpentBetweenTwoStations(Station prevStation, Station nextStation, boolean changeLineFlag) {
	 	return changeLineFlag ?
	 		   prevStation.getTimeSpentAtStation()+nextStation.getLineChangeCost()+nextStation.getTimeSpentAtStation():
	 		   prevStation.getTimeSpentAtStation()+nextStation.getTimeSpentAtStation();	
	}


	public int buildCarChassis(AssembleLine line1, AssembleLine line2) {
		return min(buildCarChassisTime(line1),buildCarChassisTime(line2));
		
	}


	private static int min(int assembleLine1Time, int assembleLine2Time) {
		return assembleLine1Time < assembleLine2Time ? assembleLine1Time : assembleLine2Time;
	}

}
