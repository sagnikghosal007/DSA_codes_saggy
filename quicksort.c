#include <stdio.h>

void swap(int* a, int* b)
{
    int temp;
    temp=*a;
    *a=*b;
    *b=temp;
}
int pivotelement(int arr[],int lb, int ub){
    //choose thge pivot
    int pivot=arr[ub];
    int i=(lb-1);
    
    for(int j=lb;j<=ub;j++){
        if(arr[j]<pivot){
            i++;
            swap(&arr[i],&arr[j]);
        }
    }
    
    swap(&arr[i+1],&arr[ub]);
    return i+1;
}
void quicksort(int arr[], int lb , int ub){
    if(lb<ub)
    {
     int p=pivotelement(arr,lb,ub);
     quicksort(arr,lb,p-1);
     quicksort(arr,p+1,ub);
    }
}
int main() {
	//code
	int arr[]={10,7,8,1,4,2,9};
	int n=sizeof(arr)/sizeof(arr[0]);
	 quicksort(arr,0,n-1);
	 
	 printf("Sorted Array\n");
	 
	 for(int i=0;i<n;i++){
	     printf("%d",arr[i]);
	 }
	return 0;
}
