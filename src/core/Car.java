package core;

public class Car
{
    //создаётся строка number
    public String number;
    //создаётся целое число height
    public int height;
    //создаётся число с плавающей запятой weight
    public double weight;
    //создаётся логичаеская переменная hasVehicle
    public boolean hasVehicle;
    //создаётся логическая переменная isSpecial
    public boolean isSpecial;

    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public boolean hasVehicle()
    {
        return hasVehicle;
    }

    public void setVehicle(boolean hasVehicle)
    {
        this.hasVehicle = hasVehicle;
    }

    public boolean isSpecial()
    {
        return isSpecial;
    }

    public void setSpecial(boolean special)
    {
        isSpecial = special;
    }
}