package apcs.frq;

public class Sound {

        int[] samples = {0, 0, 0, 0, -14, 0, -35, -39, 0, -7, 16, 32, 37, 29, 0, 0};

        public int limitAmplitude(int limit) {

                int changes = 0;
                /*
                 This code segment counts the changes made to samples with the variable
                 changes, adding to changes when a variable exceeds the permitted amplitude, e.g.
                 samples[indexOfVarToBeChecked] cannot be greater than, or less than, limit or -limit.
                 */
                for(int indexOfVarToBeChecked = 0; indexOfVarToBeChecked < this.samples.length; indexOfVarToBeChecked++) {
                        if (this.samples[indexOfVarToBeChecked] > limit || this.samples[indexOfVarToBeChecked] < -limit) {

                                changes++;

                                if (this.samples[indexOfVarToBeChecked] > limit) {
                                        this.samples[indexOfVarToBeChecked] = limit;
                                } else if (this.samples[indexOfVarToBeChecked] < -limit) {
                                        this.samples[indexOfVarToBeChecked] = -limit;
                                }
                        }
                }

                return changes;
        }

        public void trimSilenceFromBeginning() {
                /*
                  This code segment sets the variable zeroIndex equal to the index of the first non-zero integer.
                 */
                int zeroIndex = 0;
                for (int i = 0; i < this.samples.length; i++) {
                        if (this.samples[i] != 0) {
                                zeroIndex = i;
                                break;
                        }
                }

                int[] newArray = new int[this.samples.length - (zeroIndex + 1)];
                /*
                  This code segment sets the entirety of newArray to the values of sample beginning at zeroIndex, e.g.
                  samples[zeroIndex], newArray is then looped through beginning at 0, e.g. newArray[newArrayIndex] or
                  more simply newArray[0].
                 */
                int newArrayIndex = 0;
                for (int i = zeroIndex; i < this.samples.length - zeroIndex + 1; i++) {
                        newArray[newArrayIndex] = this.samples[i];
                        newArrayIndex++;
                }

                this.samples = newArray;
        }
}
