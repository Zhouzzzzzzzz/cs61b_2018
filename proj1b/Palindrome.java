import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Palindrome {

    public Deque<Character> wordToDeque(String word){

        Deque d = new LinkedListDeque();

        for(int i = 0; i < word.length(); i++){
            d.addLast(word.charAt(i));
        }

        return d;
    }

    /* 判断字符串是否回文 **/
    public boolean isPalindrome(String word){
        Deque<Character> d = wordToDeque(word);
        while(d.Size() > 1) {
            if (d.removeFirst() != d.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> d = wordToDeque(word);
        while(d.Size() > 1){
            if(!cc.equalChars(d.removeFirst(), d.removeLast())){
                return false;
            }
        }
        return true;
    }

    /* 递归判断字符串是否回文 **/
    public boolean isPalindromeRecursive(String word){
        Deque<Character> d = wordToDeque(word);
        return isPalindromeRecursive(d);
    }

    private boolean isPalindromeRecursive(Deque<Character> d){
        if(d.Size() <= 1){
            return true;
        }
        if(d.removeLast() != d.removeFirst()){
            return false;
        }
        return isPalindromeRecursive(d);
    }

    }



