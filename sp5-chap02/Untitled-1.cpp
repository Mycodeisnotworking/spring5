#include <iostream>
#include <vector>
#include <string>

using namespace std;

/*
    arr : [java | cpp | python] [ backend | frontend ] [ junior | senior ] [ pizza | chicken ] [100]
            [0]                     [1]                     [2]                 [3]              [4]
    arr : [java | cpp | python] and [ backend | frontend ] and [ junior | senior ] and [ pizza | chicken ] [100]
            [0]                 [1] [2]                     [3]     [4]             [5] [6]                 [7]
*/

vector<string> stringSplit(string arr){
    vector<string> result;
    int start=0;
    for(int i=0;i<arr.length;i++){
        if(arr[i]==' '){
            string substring=arr.substr(start, i-start);
            result.push_back(substring);
            start=i;
        }
    }
    return result;
}
void solution(vector<string> arr, vector<string> query)
{

}

int main(){

}