package demo;

import java.util.Date;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;





public class Connections {

	static String xStrPath;
	static String[][] myArray1;
	static String[][] myArray2;
	//friends is our relational hashmap (key= name in dummy2.csv, value = list of friends from dummy.csv)
	HashMap friends = new HashMap();
	

	static void SetUpMyCsvArray1()
	{
		myArray1 = new String[6][5];

		Scanner scanIn = null;

		String InputLine = "";
		String fileLocation;
		double xnum = 0;

		int rowC = 0;

		fileLocation = "c:\\Users\\Rrishab\\workspaceforeclipse\\mapDemo\\src\\data\\dummy.csv";
		//System.out.println("\n Setup arrayyyyy1\n");

		try{
			//parser
			scanIn = new Scanner(new BufferedReader(new FileReader(fileLocation)));

			while(scanIn.hasNextLine())
			{
				//read a line
				InputLine = scanIn.nextLine();
				//separate line on commas
				String[] inArray = InputLine.split(",");

				for(int x = 0; x<inArray.length; x++)
				{
					myArray1[rowC][x] = inArray[x];

				}
				rowC++;
			}

		}catch(Exception e){
			System.out.println(e);
		}			
	}

	static void SetUpMyCsvArray2()
	{
		myArray2 = new String[6][5];

		Scanner scanIn = null;

		String InputLine = "";
		String fileLocation;
		double xnum = 0;

		int rowC = 0;

		fileLocation = "c:\\Users\\Rrishab\\workspaceforeclipse\\mapDemo\\src\\data\\dummy2.csv";
		//System.out.println("\n Setup arrayyyyy2\n");

		try{
			//parser
			scanIn = new Scanner(new BufferedReader(new FileReader(fileLocation)));

			while(scanIn.hasNextLine())
			{
				//read a line
				InputLine = scanIn.nextLine();
				//separate line on commas
				String[] inArray = InputLine.split(",");

				for(int x = 0; x<inArray.length; x++)
				{
					myArray2[rowC][x] = inArray[x];

				}
				rowC++;
			}

		}catch(Exception e){
			System.out.println(e);

		}	

	}

	public static void main(String[] args) {
		try{
			SetUpMyCsvArray1();
			SetUpMyCsvArray2();

			
			//change single elements to rows
			String aone[] = new String[]{myArray1[1][1],myArray1[1][2], myArray1[1][3], myArray1[1][4]};
			String atwo[] = new String[]{myArray1[2][1],myArray1[2][2], myArray1[2][3], myArray1[2][4]};
			String athree[] = new String[]{myArray1[3][1],myArray1[3][2], myArray1[3][3], myArray1[3][4]};
			String afour[] = new String[]{myArray1[4][1],myArray1[4][2], myArray1[4][3], myArray1[4][4]};
			String afive[] = new String[]{myArray1[5][1],myArray1[5][2], myArray1[5][3], myArray1[5][4]};
			
			List alist1 = Arrays.asList(aone);
			List alist2 = Arrays.asList(atwo);
			List alist3 = Arrays.asList(athree);
			List alist4 = Arrays.asList(afour);
			List alist5 = Arrays.asList(afive);
			
			//System.out.println(list5);
			
			//setup hash table
			//System.out.println(myArray1[3][4]);
			//System.out.println(myArray2[1][0]);
			
			int j = 1;
			
			for(int i = 1; i < 5; i++)
			{
				if(myArray2[i][0] .equals(myArray1[j][4]))
				{
					System.out.println(i);
					System.out.println(myArray2[i][1] + " is friends with " + myArray1[j][1]);
				}
				else{
					System.out.print("no friends found for " + i + "\n");
				}
			}
			

		} catch(Exception e){
			System.out.println(e.getMessage());			
		}
	}




}
