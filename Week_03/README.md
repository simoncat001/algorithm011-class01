学习笔记
这一周主要在记忆递归的模板，
递归，分治，回溯基本是一个道理。
递归代码套路是,
1.terminator终止条件
2.process logic in current level处理当前层
3.drill down 下探
4.reverse the current level status if needed 清理当前影响。



分治模板,
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 终止条件
  if problem is None: 
	print_result 
	return 
  # prepare data 准备数据
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 
  # conquer subproblems 下探解决子问题
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …
  # process and generate the final result 合并结果
  result = process_result(subresult1, subresult2, subresult3, …)
  # revert the current level states 清理当前影响
  
差别很小
看到分治当我想起了归并排序。
顺便回忆了一下归并排序代码：

public static void mergeSort(int[] array, int left, int right) {
    # recursion terminator 终止条件
    if (right <= left) {
        return;
    }
    # prepare data 准备数据
    int mid = (left + right) >> 1; // (left + right) / 2
    # conquer subproblems 下探解决子问题
    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    # process and generate the final result 合并结果
    merge(array, left, mid, right);
}

public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 中间数组
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }  
        while (j <= right){
            temp[k++] = arr[j++];
        } 
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }
』