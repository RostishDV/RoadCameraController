import core.*;
import core.Camera;

import java.util.Scanner;

public class RoadController
{
    //passengerCarMaxWeight число с плавающей запятой
    private static double passengerCarMaxWeight = 3500.0; // kg
    //passengerCarMaxHeight целое число
    private static int passengerCarMaxHeight = 2000; // mm
    //controllerMaxHeight целое число
    private static int controllerMaxHeight = 3500; // mm

    //passengerCarPrice целое число
    private static int passengerCarPrice = 100; // RUB
    //cargoCarPrice целое число
    private static int cargoCarPrice = 250; // RUB
    //vehicleAdditionalPrice целое число
    private static int vehicleAdditionalPrice = 200; // RUB

    public static void main(String[] args)
    {
        System.out.println("Сколько автомобилей сгенерировать?");

        //Объект scanner класса Scanner
        Scanner scanner = new Scanner(System.in);
        //carsCount целое число
        int carsCount = scanner.nextInt();

        for(int i = 0; i < carsCount; i++)
        {
            //Создаётся объект car класса Car
            Car car = Camera.getNextCar();
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial) {
                openWay();
                continue;
            }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            //создаётся целое число price
            int price = calculatePrice(car);
            if(price == -1) {
                continue;
            }

            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car)
    {
        //создаётся целое число carHeight
        int carHeight = car.height;
        //создаётся целое число price
        int price = 0;
        if (carHeight > controllerMaxHeight)
        {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
        }
        else if (carHeight > passengerCarMaxHeight)
        {
            //создаётся число c плавающей запятой weight
            double weight = car.weight;
            //Грузовой автомобиль
            if (weight > passengerCarMaxWeight)
            {
                price = cargoCarPrice;
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice;
                }
            }
            //Легковой автомобиль
            else {
                price = passengerCarPrice;
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice;
                }
            }
        }
        else {
            price = passengerCarPrice;
        }
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay()
    {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason)
    {
        System.out.println("Проезд невозможен: " + reason);
    }
}