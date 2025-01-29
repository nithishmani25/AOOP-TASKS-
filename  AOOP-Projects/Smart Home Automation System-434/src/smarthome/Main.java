package smarthome;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Thermostat thermostat = new Thermostat();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command tempUp = new ThermostatIncreaseCommand(thermostat);
        Command tempDown = new ThermostatDecreaseCommand(thermostat);

        RemoteControl remote = new RemoteControl();

        System.out.println("Testing Light Commands:");
        remote.setCommand(lightOn);
        remote.pressButton();
        remote.pressUndo();

        remote.setCommand(lightOff);
        remote.pressButton();
        remote.pressUndo();

        System.out.println("\nTesting Thermostat Commands:");
        remote.setCommand(tempUp);
        remote.pressButton();
        remote.pressUndo();

        remote.setCommand(tempDown);
        remote.pressButton();
        remote.pressUndo();
    }
}
