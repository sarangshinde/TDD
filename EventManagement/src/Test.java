import java.io.FileNotFoundException;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Date;
public class Test {

	public Test() {
	
	}

	public static void main(String []args) throws ParseException
	{
		//throw new FileReadException("test",new FileNotFoundException());
		
	




		    Date date = new Date();
		    Date date1 = new Date();
		    String dates= "08:38 PM";
		    String dates1 ="09:38 PM";
		    String strDateFormat = "hh:mm a";
		    SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		    date = sdf.parse(dates);
		    date1 =sdf.parse(dates1);
			
			long diff = Math.abs(date.getTime() - date1.getTime());
			long diffSeconds = diff / 1000;         
			long diffMinutes = diff / (60 * 1000);         
			long diffHours = diff / (60 * 60 * 1000);
		
	}
	/*	
		ArrayList<String> test = new ArrayList<String>();
		test.add("abc");
		System.out.println(test.get(0));

		    


		        int[] values = {10,20,50,100,200};
		        int[] ammounts = {10,10,10,10,10};
		        List<Integer[]> results = solutions(values, ammounts, new int[5], 180, 0);
		        for (Integer[] result : results){
		            System.out.println(Arrays.toString(result));
		        }

		    }

		   		
	 public static List<Integer[]> solutions(int[] values, int[] ammounts, int[] variation, int price, int position){
	        List<Integer[]> list = new ArrayList<>();
	        int value = compute(values, variation);
	        if (value < price){
	            for (int i = position; i < values.length; i++) {
	                if (ammounts[i] > variation[i]){
	                    int[] newvariation = variation.clone();
	                    newvariation[i]++;
	                    List<Integer[]> newList = solutions(values, ammounts, newvariation, price, i);
	                    if (newList != null){
	                        list.addAll(newList);
	                    }
	                }
	            }
	        } else if (value == price) {
	            list.add(myCopy(variation));
	        }
	        return list;
	    }    

	    public static int compute(int[] values, int[] variation){
	        int ret = 0;
	        for (int i = 0; i < variation.length; i++) {
	            ret += values[i] * variation[i];
	        }
	        return ret;
	    }    

	    public static Integer[] myCopy(int[] ar){
	        Integer[] ret = new Integer[ar.length];
	        for (int i = 0; i < ar.length; i++) {
	            ret[i] = ar[i];
	        }
	        return ret;
	    }
*/
}
