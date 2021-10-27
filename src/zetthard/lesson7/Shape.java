package zetthard.lesson7;

public abstract class Shape {
    protected double volume;

    public abstract double getVolume();
}

class Pyramid extends Shape {
    private double area;
    private double height;

    public double getArea() {
        return area;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getVolume() {
        return 1/3.0 * Math.pow(area, 2) * height;
    }
}

abstract class SolidOfRevolution extends Shape {
    protected double radius;

    public abstract double getRadius();
}

class Cylinder extends SolidOfRevolution {
    private double height;

    public double getHeight() {
        return height;
    }

    @Override
    public double getRadius() {
        return this.radius;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}

class Sphere extends SolidOfRevolution {

    @Override
    public double getRadius() {
        return this.radius;
    }

    @Override
    public double getVolume() {
        return 4/3.0 * Math.PI * Math.pow(radius, 3);
    }
}

class Box extends Shape {
    private double usedVolume = 0;
    public double availableVolume = this.volume - usedVolume;

    public double getUsedVolume() {
        return usedVolume;
    }

    public double getAvailableVolume() {
        return availableVolume;
    }

    public void Boxify (double v) {
        usedVolume += v;
    }

    public boolean add (Shape shape) {
        if (availableVolume > shape.volume) {
            Boxify(shape.volume);
            return true;
        } else { return false; }
    }

    @Override
    public double getVolume() {
        return volume;
    }
}