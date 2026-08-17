package QuadraticEquation.typesOfEquation.root;

import QuadraticEquation.typesOfEquation.parametr.RealParameter;

public class ComplexRoot<T> extends Root<>{
    private RealParameter realPart;
    private RealParameter imaginaryPart;

    public ComplexRoot(RealParameter realPart, RealParameter imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public RealParameter getRealPart() {
        return realPart;
    }

    public RealParameter getImaginaryPart() {
        return imaginaryPart;
    }

    @Override
    public String toString() {
        return realPart + " + " + imaginaryPart + "i";
    }
//     if (realPart == 0) {
//        roots.add(imaginaryPart + "i");
//        roots.add("-" + imaginaryPart + "i");
//    } else if (imaginaryPart > 0) {
//        roots.add(realPart + " + " + imaginaryPart + "i");
//        roots.add(realPart + " - " + imaginaryPart + "i");
//    } else {
//        roots.add(realPart + " + " + Math.abs(imaginaryPart) + "i");
//        roots.add(realPart + " - " + Math.abs(imaginaryPart) + "i");
//    }
}
