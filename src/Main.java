public class Main {

    public static void main(String[] args) {
        Clothes[] clothes = {
                new Tshirt(Size.S, 25, "Red"),
                new Pants(Size.M, 40, "Blue"),
                new Skirt(Size.XS, 30, "Black"),
                new Tie(Size.L, 15, "Green")
        };

        Atelier atelier = new Atelier();
        atelier.dressWoman(clothes);
        atelier.dressMan(clothes);
    }
}
enum Size {
    XXS(32) {
        @Override
        String getDescription() {
            return "Kid size";
        }
    },
    XS(34), S(36), M(38), L(40);

    int euroSize;

    //конструктор
   Size(int euroSize) {
        this.euroSize = euroSize;
    }

    int getEuroSize() {
        return euroSize;
    }

    String getDescription() {
        return "Adult size";
    }
}

interface MaleClothes {
    void dressMan();
}

interface FemaleClothes {
    void dressWoman();
}

abstract class Clothes {
    Size size;
    double cost;
    String color;

    Clothes(Size size, double cost, String color) {
        this.size = size;
        this.cost = cost;
        this.color = color;
    }
}

class Tshirt extends Clothes implements MaleClothes, FemaleClothes {
    public Tshirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужская футболка: размер " + size + " (EU " + size.getEuroSize() +
                "), цена " + cost + ", цвет " + color);
    }

    @Override
    public void dressWoman() {
        System.out.println("Женская футболка: размер " + size + " (EU " + size.getEuroSize() +
                "), цена " + cost + ", цвет " + color);
    }
}

class Pants extends Clothes implements MaleClothes, FemaleClothes {
    public Pants(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужские штаны: размер " + size + " (EU " + size.getEuroSize() +
                "), цена " + cost + ", цвет " + color);
    }

    @Override
    public void dressWoman() {
        System.out.println("Женские штаны: размер " + size + " (EU " + size.getEuroSize() +
                "), цена " + cost + ", цвет " + color);
    }
}

class Skirt extends Clothes implements FemaleClothes {
    public Skirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressWoman() {
        System.out.println("Юбка: размер " + size + " (EU " + size.getEuroSize() +
                "), цена " + cost + ", цвет " + color);
    }
}

class Tie extends Clothes implements MaleClothes {
    public Tie(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Галстук: размер " + size + " (EU " + size.getEuroSize() +
                "), цена " + cost + ", цвет " + color);
    }
}

class Atelier {
    public void dressWoman(Clothes[] clothes) {
        System.out.println("Женская одежда в ателье:");
        for (Clothes i : clothes) {
            if (i instanceof FemaleClothes) {
                ((FemaleClothes) i).dressWoman();
            }
        }
    }

    public void dressMan(Clothes[] clothes) {
        System.out.println("Мужская одежда в ателье:");
        for (Clothes i : clothes) {
            if (i instanceof MaleClothes) {
                ((MaleClothes) i).dressMan();
            }
        }
    }
}