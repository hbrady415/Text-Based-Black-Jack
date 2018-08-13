public class MergeSort{
  public static void main(String [] args){
    int [] a = {1, 5, 10};
    int [] b = {2, 7};
    int length1 = a.length;
    int length2 = b.length;
    int [] result = sort(a, b, length1, length2);
    for(int z = 0; z<result.length; z++){
        System.out.println(result[z]);
    }
  }
  public static int[] sort(int[] a, int[] b, int length1, int length2){
    int [] result = new int[length1+length2];
    int indexArr1 =0;
    int indexArr2 = 0;
    int resultIndex = 0;
      while( resultIndex < length1 + length2 ){
        if(indexArr2 >= length2 ){
          result[resultIndex]= a[indexArr1];
          resultIndex++;
          indexArr1++;
          System.out.println( "Iteration: " + resultIndex + " a" );
        }else if(indexArr1 >= length1){
          result[resultIndex]=b[indexArr2];
          resultIndex++;
          indexArr2++;
          System.out.println( "Iteration: " + resultIndex + " b");
        }else if(a[indexArr1] < b[indexArr2]){
          result[resultIndex]= a[indexArr1];
          resultIndex++;
          indexArr1++;
          System.out.println( "Iteration: " + resultIndex + " a" );
        }else{
          result[resultIndex]=b[indexArr2];
          resultIndex++;
          indexArr2++;
          System.out.println( "Iteration: " + resultIndex + " b");
        }
  }
  return result;
}
}
