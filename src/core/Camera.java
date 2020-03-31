package core;

public class Camera
{
    public static Car getNextCar()
    {
        //создаётся строка randomNumber
        String randomNumber = Double.toString(Math.random()).substring(2, 5);
        //создаётся целое число randomHeight
        int randomHeight = (int) (1000 + 3500. * Math.random());
        //создаётся число с плавающей запятой randomWeight
        double randomWeight = 600 + 10000 * Math.random();

        //создаётся объект car класса Сar
        Car car = new Car();
        car.number = randomNumber;
        car.height = randomHeight;
        car.weight = randomWeight;
        car.hasVehicle = Math.random() > 0.5;
        car.isSpecial = Math.random() < 0.15;

        return car;
    }
}