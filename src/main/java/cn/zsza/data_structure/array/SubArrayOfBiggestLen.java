package cn.zsza.data_structure.array;

/**
 * Created By zhangsong
 * 17:05 2018/8/31
 * 求一个有序数组中最长连续子数组
 */
public class SubArrayOfBiggestLen {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 5, 6, 9, 10};
		int count = 1, max =1;
		for (int i = 1; i< arr.length; i++){
			if (arr[i] - arr[i-1] == 1){
				count++;
			}else if (arr[i] - arr[i-1] == 0){
				continue;
			}else {
				count = 1;       // 重新计数
			}
			if (count > max) max = count;
		}
		System.out.println(max);
		for (int k=0; k < arr.length - 1; k++){
			if (k + max <= arr.length && arr[k] + max - 1 == arr[k + max -1]){
				System.out.println(k);
			}
		}
	}
}
