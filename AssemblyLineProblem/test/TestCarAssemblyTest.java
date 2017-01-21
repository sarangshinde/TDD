import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCarAssemblyTest {

	CarAssemble carAssemble;
	@Before
	public void setUp() throws Exception {
		carAssemble= new CarAssemble();
	}

	/*	@Test
	public void shouldReturn_AssemblyLine1Time_whenNoStation() {	
		AssembleLine line1 = new AssembleLine("Line1",10,20,null);
		int assembleTime = carAssemble.assemble(line1);
		assertEquals(30, assembleTime);
	}

	@Test
	public void shouldReturn_AssemblyLine2Time_whenNoStation() {
		AssembleLine line2 = new AssembleLine("Line2",15,25,null);
		int assembleTime = carAssemble.assemble(line2);
		assertEquals(40, assembleTime);
	}

	@Test
	public void shouldReturn_AssemblyLineTime_whenOneStation() {
		Station station [] = {new Station(1,20,0)};
		AssembleLine line1= new AssembleLine("Line1",10,20,station);
		int assembleTime = carAssemble.assemble(line1);
		assertEquals(50, assembleTime);
	}

	@Test
	public void shouldReturn_AssemblyLineTime_whenTwoOrMoreStations() {
		Station stations [] = {new Station(1,20,0),new Station(2,30,9)};
		AssembleLine line2 = new AssembleLine("Line2",15,25,stations);
		int assembleTime = carAssemble.assemble(line2);
		assertEquals(90, assembleTime);
	}

	@Test
	public void shouldReturn_TimeSpentWhenCarChaseMoveFromPreviousToNextStation_onSameAsemblyLine() {
		boolean changeLineFlag=false;
		int assembleTime = carAssemble.timeSpentBetweenTwoStations(new Station(3,20,5),new Station(4,30,7),changeLineFlag);
		assertEquals(50, assembleTime);
	}

	@Test
	public void shouldReturn_TimeSpentWhenCarChaseMoveFromPreviousToNextStation_onOtherAsemblyLine() {
		boolean changeLineFlag=true;
		int assembleTime = carAssemble.timeSpentBetweenTwoStations(new Station(3,20,15),new Station(4,30,7),changeLineFlag);
		assertEquals(57, assembleTime);
	}*/

	@Test
	public void shouldReturn_MinimumTimeSpentInCarChassisBuild_whenNoStationsOnBothAsemblyLine() {
		Station line1Stations [] = null;
		Station line2Stations [] = null;
		AssembleLine line1 = new AssembleLine("Line1",15,25,line1Stations);
		AssembleLine line2= new AssembleLine("Line2",10,20,line2Stations);
		int assembleTime = carAssemble.buildCarChassis(line1,line2);
		assertEquals(30, assembleTime);
	}


	@Test
	public void shouldReturn_MinimumTimeSpentInCarChassisBuild_whenOneStationOnAsemblyLine1() {
		Station line2Stations [] = {new Station(1,10,5)};
		Station line1Stations [] = null;
		AssembleLine line1 = new AssembleLine("Line1",25,25,line1Stations);
		AssembleLine line2= new AssembleLine("Line2",10,20,line2Stations);
		int assembleTime = carAssemble.buildCarChassis(line1,line2);
		assertEquals(40, assembleTime);
	}


	@Test
	public void shouldReturn_MinimumTimeSpentInCarChassisBuild_whenOneStationOnBothAsemblyLine() {
		Station line2Stations [] = {new Station(1,50,5)};
		Station line1Stations [] = {new Station(1,10,5)};
		AssembleLine line1 = new AssembleLine("Line1",25,25,line1Stations);
		AssembleLine line2= new AssembleLine("Line2",10,20,line2Stations);
		int assembleTime = carAssemble.buildCarChassis(line1,line2);
		assertEquals(60, assembleTime);
	}	

	@Test
	public void shouldReturn_MinimumTimeSpentInCarChassisBuild_whenTwoStationsOnAsemblyLine2() {
		Station line2Stations [] = {new Station(1,30,5),new Station(2,20,5)};
		Station line1Stations [] = {new Station(1,10,5)};
		AssembleLine line1 = new AssembleLine("Line1",10,20,line1Stations);
		AssembleLine line2= new AssembleLine("Line2",10,20,line2Stations);
		int assembleTime = carAssemble.buildCarChassis(line1,line2);
		assertEquals(40, assembleTime);
	}


	@Test
	public void shouldReturn_MinimumTimeSpentInCarChassisBuild_whenTwoStationsOnBothAsemblyLine() {
		Station line2Stations [] = {new Station(1,30,5),new Station(2,10,-10)};
		Station line1Stations [] = {new Station(1,45,5),new Station(2,5,2)};
		AssembleLine line1 = new AssembleLine("Line1",10,20,line1Stations);
		AssembleLine line2= new AssembleLine("Line2",10,20,line2Stations);
		int assembleTime = carAssemble.buildCarChassis(line1,line2);
		assertEquals(60, assembleTime);
	}


}
