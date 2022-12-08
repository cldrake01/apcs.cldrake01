package frq;

public class Sound {

        int[] samples = {0, 0, 0, 0, -14, 0, -35, -39, 0, -7, 16, 32, 37, 29, 0, 0};

        public int limitAmplitude(int limit) {

                int changes = 0;

                for(int amplitude = 0; amplitude < this.samples.length; amplitude++) {

                        if (this.samples[amplitude] > limit || this.samples[amplitude] < -limit) {

                                changes++;

                                if (this.samples[amplitude] > limit) {
                                        this.samples[amplitude] = limit;
                                } else if (this.samples[amplitude] < -limit) {
                                        this.samples[amplitude] = -limit;
                                }
                        }
                }

                return changes;
        }

        public void trimSilenceFromBeginning() {
                int index = 0;
                for (int i = 0; i < this.samples.length; i++) {
                        if (this.samples[i] != 0) {
                                index = i;
                                break;
                        }
                }

                int[] newArray = new int[this.samples.length - (index + 1)];

                int newArrayIndex = 0;
                for (int i = index; i < this.samples.length - index + 1; i++) {
                        newArray[newArrayIndex] = this.samples[i];
                        newArrayIndex++;
                }

                this.samples = newArray;
        }
}
