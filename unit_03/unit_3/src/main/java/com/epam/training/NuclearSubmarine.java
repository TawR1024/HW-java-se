package com.epam.training;

/**
 * Created by Ilya Kulakov on 24.02.17.
 */
public class NuclearSubmarine {
    private String vesselName;
    private int numberOfTorpedo;
    private double nuclearFuel = 10.;

    public NuclearSubmarine() {
    }

    public NuclearSubmarine(String Name, int numberOfTorpedo) {
        setVesselName(Name);
        setNumberOfTorpedo(numberOfTorpedo);
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public int getNumberOfTorpedo() {
        return numberOfTorpedo;
    }

    public void setNumberOfTorpedo(int numberOfTorpedo) {
        this.numberOfTorpedo = numberOfTorpedo;
    }

    public void fight(int shots) {
        for (int i = 0; i <= shots; i++) {
            if (this.getNumberOfTorpedo() <= 0){
                System.out.println("Can`t fight without weapons");
            return;
        }
            System.out.println("Piu-Piu");
            setNumberOfTorpedo(getNumberOfTorpedo() - 1);
        }
    }

    public void swimmDistance(int distance){
        class NuclearEngine {
            public void startEngene(){
                nuclearFuel = nuclearFuel - distance * 0.01;
                System.out.println(nuclearFuel);
            }
        }
        NuclearEngine engine = new NuclearEngine();
        engine.startEngene();

    }
}
