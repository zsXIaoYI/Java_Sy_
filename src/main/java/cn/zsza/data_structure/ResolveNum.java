package cn.zsza.data_structure;

/**
 * Created By zhangsong
 * 20:20 2018/8/30
 * 整数的因数分解
 *   思想：先以最小的质数开始，进行相除，然后取模，等于0继续，不等于则++
 */
public class ResolveNum {
	public static void main(String[] args) {
		int k = 2;
		int num = 90;   // 要分解的数
		System.out.print(num + "=");

		while (num > k){
			if (num % k == 0){
				System.out.print(k + "*");
				num = num / k;
			}else {
				k++;
			}
		}
		System.out.println(k);
	}
}
