
public class MainClass {
	public static void main(String []args){

		CarAssemble carAssemble= new CarAssemble();
		Station line2Stations [] = {new Station(1,30,5),new Station(2,10,-10),new Station(3,5,5)};
		Station line1Stations [] = {new Station(1,45,5),new Station(2,5,2)};
		AssembleLine line1 = new AssembleLine("Line1",10,20,line1Stations);
		AssembleLine line2= new AssembleLine("Line2",10,20,line2Stations);
		int carChassisBuilTime = carAssemble.buildCarChassis(line1,line2);
		System.out.println("Minimum Time To Buil Car Chassis Is :" + carChassisBuilTime);
	}
}
