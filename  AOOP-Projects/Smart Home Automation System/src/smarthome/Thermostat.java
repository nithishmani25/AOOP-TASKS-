package smarthome;

public class Thermostat {
    private int temperature = 22; // Default temperature

    public void increaseTemperature() {
        temperature++;
        System.out.println("Thermostat increased to " + temperature + "°C");
    }

    public void decreaseTemperature() {
        temperature--;
        System.out.println("Thermostat decreased to " + temperature + "°C");
    }

    public int getTemperature() {
        return temperature;
    }
}
