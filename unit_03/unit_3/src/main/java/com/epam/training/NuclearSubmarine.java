package com.epam.training;

/**
 * Created by Ilya Kulakov on 24.02.17.
 */
@SubmarineCard(chiefDesigner = "Kulakov Ilya", laidDownDate = "24/02/2017",portOfRegestry = "SPb",yardNumber = 456)
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
            if (this.getNumberOfTorpedo() <= 0) {
                System.out.println("Can`t fight without weapons");
                return;
            }
            System.out.println("Piu-Piu");
            setNumberOfTorpedo(getNumberOfTorpedo() - 1);
        }
    }

    /**
     *
     * @param distance
     */
    public void swimmDistance(int distance) {
        class NuclearEngine {
            public void startEngene() {
                if(nuclearFuel <=0){
                    System.out.println("Fuel tank is empty");
                    return;
                }
                nuclearFuel = nuclearFuel - distance * 0.01;
                System.out.println(nuclearFuel);
            }
        }
        NuclearEngine engine = new NuclearEngine();
        engine.startEngene();
    }
}
