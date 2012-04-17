#include <stdio.h>

int main(int argc, char **argv) {
  float factor, val, bias;
  float maxUInt;
  unsigned short scol;
  FILE *fileIn;
  FILE *fileOut;
  char fnIn[1024], fnOut[1024];

  printf("Name of input file: ");
  scanf("%s", fnIn);
  printf("Name of output file: ");
  scanf("%s", fnOut);
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

  printf("Scaling factor: ");
  scanf("%f", &factor);

  printf("Bias: ");
  scanf("%f", &bias);

  /* find maximum value for rescaling file values * /
  max = 0.0;
  while(!feof(fileIn)) {
      fread(&val, sizeof(float), 1, fileIn);
      if (val > max )
         max = val;
  }
  rewind(fileIn);

  maxUInt = 65535.0;
  scol = (unsigned short) (val * maxUInt / max); 
 */

  while(!feof(fileIn)) {
      fread(&val, sizeof(float), 1, fileIn);
      scol = (unsigned short) (val * factor + bias); 
      fwrite(&scol,sizeof(short),1, fileOut);
      /* printf("%f, sh = %d\n", val, scol); */
  }
  close(fileIn);
  close(fileOut);
  return 0;
}
