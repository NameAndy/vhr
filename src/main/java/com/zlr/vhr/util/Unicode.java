package com.zlr.vhr.util;

public class Unicode {
	
	public static void main(String[] args) {
		
		String niString="热门";
		byte[] bytes = niString.getBytes();
		for (int i = 0; i < bytes.length; i++) {
			System.out.println(bytes[i]);
		}
	}

}
