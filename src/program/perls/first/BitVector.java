package program.perls.first;

/**
 * Created by jerry on 2018/5/19.
 * 编程珠玑上，用位向量来进行排序，
 * 下面给出的是位向量的操作类BitVector
 */
public class BitVector {
    private int bitLength = 32; // 每个整数代表的位数，一个整数最多32位
    private int n = 10000000;  // 待排序的数的个数
    private int[] bits = null; // 位向量的储存数组，长度为 N / 32 + 1

    /**
     * 给定排序数的个数
     * @param n 待排序的数的个数
     */
    public BitVector(int n) {
        this.bits = new int[n / 32 + 1];
        this.n = n;
    }

    public BitVector() {
        this.bits = new int[n / 32 + 1];
    }

    /**
     * 将value添加到bit vector中，
     * 比如数字33，那么在位向量中的第33位为1，
     * 如果一个整数代表32位，那么第2个数的1
     * @param value 待排序的value
     */
    public void add(int value) {
        int quotient = value / bitLength; // 商， 判断是处于哪个位子
        int remainder = value % bitLength; // 余数， 判断具体的位子
        bits[quotient] |= 1 << remainder;
    }

    /**
     * 把元素从排序数组中移除
     * @param value  待移除的数
     */
    public void remove(int value) {
        int quotient = value / bitLength;
        int remainder = value % bitLength;
        bits[quotient] &= ~(1 << remainder);
    }

    /**
     * 判断位向量是否有value这个值
     * @param value
     * @return
     */
    public boolean isExist(int value) {
        int quotient = value / bitLength;
        int remainder = value % bitLength;
        return (bits[quotient] & 1 << remainder) > 0;
    }

    /**
     * 从小到大输出所有位向量中所有元素
     */
    public void print() {
        for (int i = 0; i < n; i++) {
            if(isExist(i)){
                System.out.printf("%d ", i);
            }
        }
    }

    /**
     * 清除所有元素
     */
    public void clear() {
        for (int i = 0; i < n; i++) {
            remove(i);
        }
    }

    public static void main(String[] args) {
        BitVector bitVector = new BitVector();
        for (int i = 0; i < 10; i++) {
            int t = (int)(Math.random()*1000);
            System.out.printf("%d ", t);
            bitVector.add(t);
        }
        System.out.println();
        bitVector.print();
    }
}
