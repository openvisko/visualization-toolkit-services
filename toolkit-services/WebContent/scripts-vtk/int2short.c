#include <stdio.h>

int main(int argc, char **argv) {
  int col;
  short scol;
  FILE *fileIn;
  FILE *fileOut;
  char fnIn[1024], fnOut[1024];

  printf("Name of input file: ");
  scanf("%s",fnIn);
  printf("Name of output file: ");
  scanf("%s",fnOut);
  //read integer file
  if((fileIn = fopen(fnIn, "r")) == NULL) {
    printf("Input file could not be opened");
    return 0;
  } 

  if((fileOut = fopen(fnOut, "w")) == NULL) {
    printf("Output file could not be opened");
    close(fileIn);
    return 0;
  } 

  while(!feof(fileIn)) {
      fread(&col, sizeof(int), 1, fileIn);
      scol = (short) col; 
      fwrite(&scol,sizeof(short),1, fileOut);
      /* printf("%d, sh = %d\n", col, scol); */
  }
  close(fileIn);
  close(fileOut);
  return 0;
}
