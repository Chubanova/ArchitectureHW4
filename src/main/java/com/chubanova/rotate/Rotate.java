package com.chubanova.rotate;

public class Rotate {
    Rotatable r;
    public Rotate(Rotatable r) {
        this.r = r;
    }
    public void execute() {
        r.setDirection(
                (r.getDirection()+r.getAngularVelocity())%r.getDirectionsNumber());
    }

}
