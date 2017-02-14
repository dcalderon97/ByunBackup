#include <iostream>
#include <cstdlib>
#include <fstream>
using namespace std;

int main(){
    //****** Opening the files ******
    ifstream inputFile;
    string fileName;

    cout << "Enter a file name: ";
	cin >> fileName;
	inputFile.open(fileName);

	//****** if the files fails ******
	if(inputFile.fail()){
	    cout << "Error could not open file." << endl;
	}


	//****** Declaring Variables ******
	int num, numVecOf1, numVecOf2;
	int numOfVertices;
	int numOfEdges;

	//****** Num getting file numbes ******
	//***** vertices & edges = to num *****
	inputFile >> num;
	numOfVertices = num;
	inputFile >> num;
	numOfEdges = num;

	int ara[numOfVertices][numOfVertices];
	cout << "Number of vertices: " << numOfVertices << endl;
	cout << "Number of edges: " << numOfEdges << endl;

	for(int i = 0 ; i < numOfVertices;i++){
		for(int j = 0; j < numOfVertices;j++){
			ara[i][j] = 0;
		}
	}

	while ( inputFile >> numVecOf1 >> numVecOf2){
		ara[numVecOf1][numVecOf2] = 1;
	}
	for(int i = 0 ; i < numOfVertices;i++){
		for(int j = 0; j < numOfVertices;j++){
			cout << ara[i][j] << " ";
		}
		cout << endl;
	}

    return EXIT_SUCCESS;
}
