package com.java.trafficcontrolsystem;

import java.util.Scanner;

public class TrafficService extends Thread {

//	/* its a 2 lane traffic so, the number of signals will be 4
//	 * If light_0 is Green then light_3 will also be green
//	 * If any light green is false then it is red
//	 * I will give each signals 90 seconds
//	 * When East to West will be open and north to south will be closed
//	 * Similarly vice-versa
//	 * If anything is Green = false then it is red
//     */

	static Scanner sc = new Scanner(System.in);

	public boolean east;
	public boolean west;
	public boolean north;
	public boolean south;
	public String laneNameOfEast = "east";
	public String laneNameOfWest = "west";
	public String laneNameOfNorth = "north";
	public String laneNameOfSouth = "south";
	boolean result;
	int choice;
	int choice2;
	int choose_lane;

	public static void main(String[] args) throws InterruptedException {

		new TrafficService().dashBoard();

	}

	public void dashBoard() throws InterruptedException {

		choice = 0;

		System.out.println();
		System.out.println("---!! DASHBOARD !!---");
		System.out.println();
		System.out.println("Press '1' for Automated or '2' for VIPMode and 3 to reName the lane:");
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out
					.println("Enter 1 to stop after several loops else press any other num key to continue forever..");
			choice2 = sc.nextInt();
			automatedTraffic(choice, choice2);
			break;
		case 2:

			System.out.println("Select signal from which VIP are Coming, Choose any 1 : ");
			System.out.println("'0' For Signal_0");
			System.out.println("'1' For Signal_1");
			System.out.println("'2' For Signal_2");
			System.out.println("'3' For Signal_3");
			choose_lane = sc.nextInt();

			manualMode(choice, choose_lane);

			break;

		case 3:
			System.out.println("Select the lane you want to rename");
			System.out.println("'0' For east");
			System.out.println("'1' For west");
			System.out.println("'2' For north");
			System.out.println("'3' For south");
			int chooseLane = sc.nextInt();

			System.out.println("Enter the new name of the lane :");
			String newName = sc.next();

			reName(chooseLane, newName);
			break;

		default:
			System.out.println("Enter 1 to return dashBoard..!!");
			int a = sc.nextInt();
			if (a == 1) {
				dashBoard();
			} else {
				System.out.println("Invalid input..!!");
			}

		}
	}

	/*
	 * This method is mimic of how automatically traffic light works //
	 * 
	 * Giving boolean return type for junit to get something. The Lights gets
	 * changed every 5 seconds for demo.
	 */
	public boolean automatedTraffic(long choice, int choice2) throws InterruptedException {

		if (choice == 1) {
			east = true;
			result = false;
//			choice2 = 0;
		}

		if (east) {
			north = true;
			System.out.println("----!! AUTO MODE !!----");
			System.out.println("Light_0 Green : " + east);
			System.out.println("Light_1 Green : " + west);
			System.out.println("Light_2 Green : " + north);
			System.out.println("Light_3 Green : " + south);

			System.out.println("Note : Any light green : 'false' is Red...");
			System.out.println("---!! WAIT FOR 90 SECONDS..!!---");
			Thread.sleep(5000);

			west = true;
			if (west) {

				east = false;
				north = false;
				south = true;
				System.out.println("Light_0 Green : " + east);
				System.out.println("Light_1 Green : " + west);
				System.out.println("Light_2 Green : " + north);
				System.out.println("Light_3 Green : " + south);

				System.out.println("Note : Any light green : 'false' is Red...");

				System.out.println("---!! WAIT FOR 90 SECONDS..!!---");

				if (choice2 != 1) {

					Thread.sleep(5000);
					east = false;
					west = false;
					north = false;
					south = false;

					result = true;

					automatedTraffic(choice, choice2);
				} else if (choice == 1) {

					System.out.println("Thanks..");
					result = true;
				}
			}
		}
		return result;
	}

	// In this methods traffic can be handle manually for VIP traffic
	// Giving boolean return type for junit to get something.

	public boolean manualMode(long choice, int choose_lane) throws InterruptedException {

		result = false;
		switch (choose_lane) {
		case 0:
			east = true;
			break;
		case 1:
			west = true;
			break;
		case 2:
			north = true;
			break;
		case 3:
			south = true;
			break;
		}

		System.out.println("---!! Manual Mode !!---");
		System.out.println("Light_0 Green : " + east);
		System.out.println("Light_1 Green : " + west);
		System.out.println("Light_2 Green : " + north);
		System.out.println("Light_3 Green : " + south);

		System.out.println("----!! BE PTIENT : VIP MODE IS ON !!----");
//		System.out.println("Press 1 to return to Auto Mode of operation :");
//		int b = sc.nextInt();
//
//		if (b == 1) {
//
//			automatedTraffic(choice, choice2);
//		}
		result = true;
		// Just to return something for junit testing

		return result;
	}

	/*
	 * This method is used to rename the roads.
	 * 
	 * Returning something to do junit test.
	 */

	public String reName(int chooseLane, String newName) throws InterruptedException {

		String oldName = "";

		switch (chooseLane) {
		case 0:
			// To change the name of east lane

			oldName = laneNameOfEast;
			laneNameOfEast = newName;
			System.out.println("Congratulation, you have successfully Changed the name of the lane from " + oldName
					+ " to " + laneNameOfEast);

			break;
		case 1:
			// To change the name of West lane

			oldName = laneNameOfWest;
			laneNameOfEast = newName;
			System.out.println("Congratulation, you have successfully Changed the name of the lane from " + oldName
					+ " to " + laneNameOfWest);
			break;

		case 2:
			// To change the name of North lane

			oldName = laneNameOfNorth;
			laneNameOfNorth = newName;
			System.out.println("Congratulation, you have successfully Changed the name of the lane from " + oldName
					+ " to " + laneNameOfNorth);

			break;
		case 3:
			// To change the name of South lane

			oldName = laneNameOfSouth;
			laneNameOfSouth = newName;
			System.out.println("Congratulation, you have successfully Changed the name of the lane from " + oldName
					+ " to " + laneNameOfSouth);

			break;
		default:
			System.out.println("please select correct option..!!");
			reName(chooseLane, oldName);
			break;
		}
		return newName;
	}

}
