/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Partner Name:    Ada Lovelace
 *  Partner NetID:   alovelace
 *  Partner Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

public class ArrayCopy {
    public static void main(String[] args) {
        int[] arrayFrom = {1,2,3,4,5,6,7,8,9};
        int[] arrayTo =  new int[5];
        System.arraycopy(arrayFrom, 2, arrayTo, 0, 5);
        System.out.println(new String(arrayTo));

    }
}
