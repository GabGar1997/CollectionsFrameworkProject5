//Gabriel Garcia
//COP-3330C-23598
//3-1-26
//Demonstrate the use of Collections framework and the Collection interface.
//Create a list, print the list, sort the list, custom sort the list,
//perform the static method shuffle, search, and 2 other methods.

//The user supplies inputs to the list of words, note: duplicate words don't get submitted.
//The user is also asked for a word to search the list for.

/*Collection is an interface used to determine basic operations
* while Collections is a utility class full of static methods
* A class is a blueprint for creating objects that can be instantiated
* An interface is more of a set of rules a class can implement but can't be instantiated*/

import java.util.*; //import all java utils

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  //Start scanner
        List<String> words = new ArrayList<>();  //Create list
        int listCount = 0;   //Keep a count of words
        String longestEntry = "";  // keeps track of longest entry
        String shortestEntry = "";  // keeps track of shortest entry

        for (int i = 0; i < 8; i++) {  //for loop
            System.out.println("Type a word: ");
            String newWord = scanner.nextLine();
            if (words.contains(newWord)) {  //Check for word in word list
                i--;   //if it's a duplicate word, restart the current iteration
                continue; // Skip the rest of the loop
            }
            if (i == 0) {  //define the 1st entry
                longestEntry = newWord;
                shortestEntry = newWord;
            }
            if(newWord.length() > longestEntry.length()){
                longestEntry = newWord;
            }
            if(newWord.length() < shortestEntry.length()) {
                shortestEntry = newWord;
            }
            words.add(newWord);  //If no duplicates, add to the list
            listCount++;  //Add to our list count if the word is added
        }

        for(String w: words) {  //enhanced for loop
            System.out.println(w);
        }
        System.out.println("Number of entries: " + listCount);
        System.out.println("The longest entry was: " + longestEntry);
        System.out.println("The shortest entry was: " + shortestEntry);

        Collections.sort(words);  //Sort the list
        System.out.println("Here is a sorted list of words: " + words);


        Collections.sort(words, new Comparator<String>() {  //Custom sort the list
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length(); //determine which word comes first
            }
        });
        System.out.println("Here is a sorted list from longest to shortest: " + words);

        Collections.shuffle(words);  //shuffle the words using the static method
        System.out.println("Here is a shuffled list of words: " + words);
        System.out.println("Enter a word to search: ");
        String search = scanner.nextLine();
        boolean found = false;  //keep track if we found the word
        for (int i = 0; i < words.size(); i++) {
            if(words.get(i).equalsIgnoreCase(search)) { //ignoring the case sens
                System.out.println("Word found at index " + i);
                found = true;
                break;  //break out of the loop, we found our word
            }
        }
        if(!found) { //if not found
            System.out.println("Word not found...");
        }

        Collections.reverse(words); //Static method reverse
        System.out.println("Here is the most recent list in reverse order: " + words);

        Collections.fill(words, "Finished"); //static method fill to fill the list with a word of our choice
        System.out.println("Here is a list of the same words: " + words);

        String[] wordsArray = words.toArray(new String[0]); //move the list to an array
        System.out.println("This is a List converted into an Array");
        for (String a: wordsArray) {
            System.out.println(a);
        }

        List<String> newList = new ArrayList<>(Arrays.asList(wordsArray));//move the array back to a list that's mutable
        System.out.println("This is the Array converted back into a List");
        for(String n: newList) {  //enhanced for loop
            System.out.println(n);
        }
    }
}