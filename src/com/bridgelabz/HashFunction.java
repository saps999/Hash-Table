package com.bridgelabz;

public class HashFunction {
    MyMapNode[] table;
    String[] strArray;
    int hashSize;

    public HashFunction(String strArray, int hashSize) {

        this.table = new MyMapNode[hashSize];
        this.hashSize = hashSize;
        this.strArray = strArray.split(" ");
        hashTable();
    }

    private boolean isEmpty() {
        for (MyMapNode element : table) {
            if (element != null) {
                return false;
            }
        }
        return true;
    }

    private void hashTable() {
        for (int i = 0; i < strArray.length; i++) {
            int hashIndex = Math.abs(strArray[i].hashCode() % hashSize);
            if (table[hashIndex] == null) {
                table[hashIndex] = new MyMapNode(strArray[i]);
            } else {
                MyMapNode currNode = table[hashIndex];
                while (currNode != null) {
                    if (currNode.data.equals(strArray[i])) {
                        currNode.frequency++;
                        break;
                    }
                    if (currNode.next == null) {
                        currNode.next = new MyMapNode(strArray[i]);
                        break;
                    }
                    currNode = currNode.next;
                }

            }
        }
    }
    public void deleteData(String data) {
        int hashIndex = Math.abs(data.hashCode() % hashSize);
        if (isEmpty()) {
            return;
        }
        MyMapNode currNode = table[hashIndex];
        while (currNode != null) {
            if (currNode.data.equals(data)) {
                MyMapNode temp = currNode.next;
                table[hashIndex] = temp;
                break;
            }
            currNode = currNode.next;
        }
    }

    public void showTable() {
        if (isEmpty()) {
            return;
        } else {
            for (MyMapNode element : table) {
                MyMapNode currNode = element;
                while (currNode != null) {
                    System.out.println(currNode.data + " " + currNode.frequency);
                    currNode = currNode.next;
                }
            }
        }
    }


}
