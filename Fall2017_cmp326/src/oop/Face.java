package oop;

public class Face {

	private int numEyes;
	private double mouthWidth;
	private double noseLength;
	private String eyeColor;
	
	public Face(){//default constructor
		numEyes = 2;
		mouthWidth = 0;
		noseLength = 10; //pinocchio
		eyeColor = "Brown";
	}
	
	public String toString() {
		String s = "\n\t\t\tNumber of Eyes: " + numEyes +
				   "\n\t\t\tMouth Width: " + mouthWidth +
				   "\n\t\t\tNose length: " + noseLength +
				   "\n\t\t\tEye Color: " + eyeColor;
		return s;
		
		
	}

	public int getNumEyes() {
		return numEyes;
	}

	public void setNumEyes(int numEyes) {
		this.numEyes = numEyes;
	}

	public double getMouthWidth() {
		return mouthWidth;
	}

	public void setMouthWidth(double mouthWidth) {
		this.mouthWidth = mouthWidth;
	}

	public double getNoseLength() {
		return noseLength;
	}

	public void setNoseLength(double noseLength) {
		this.noseLength = noseLength;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	
}