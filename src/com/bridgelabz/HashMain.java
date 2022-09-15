package com.bridgelabz;

public class HashMain {
    public static void main(String[] args) {
        HashFunction func = new HashFunction("Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations",4);
        func.deleteData("avoidable");
        func.showTable();
    }
}
