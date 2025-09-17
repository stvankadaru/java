package com.example.threadclass;


class UserA extends Thread {
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("User A uploading file");
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("UserA uploaded file");
	}
}
class UserB extends Thread {
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("User B uploading file");
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("UserB uploaded file");
	}
}

public class ThreadActivity {
	
	public static void main(String[] args) throws InterruptedException {
		UserA t1=new UserA();
		UserB t2=new UserB();
		t1.start();
		t1.join();
		t2.start();
		t2.join();

	}

}





//package threadUtilization;
//
//class UploadFile extends Thread{
//	String username;
//	
//	public UploadFile(String username) {
//		this.username = username;
//	}
//	
//	public void run() {
//		System.out.println(username + " upload file");
//		try {
//			Thread.sleep(1000);
//		}
//		catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(username + " uploaded file");
//	}
//}

//public class Task1 {
//	public static void main(String[] args) throws InterruptedException {
//		UploadFile threadA = new UploadFile("Veena");
//		UploadFile threadB = new UploadFile("Sourav");
//		
//		threadA.start();
//		threadA.join();
//		threadB.start();
//		threadB.join();
//		
////		try {
////			threadA.join();
////			threadB.join();
////		}
////		catch(InterruptedException e) {
////			e.printStackTrace();
////		}
//		System.out.println("Task completed");
//	}
//}
//
