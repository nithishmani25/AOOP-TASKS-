package smarthome;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RemoteControlTest {

    @Test
    void testLightCommands() {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();
        assertTrue(light.isOn());

        remote.pressUndo();
        assertFalse(light.isOn());

        remote.setCommand(lightOff);
        remote.pressButton();
        assertFalse(light.isOn());

        remote.pressUndo();
        assertTrue(light.isOn());
    }

    @Test
    void testThermostatCommands() {
        Thermostat thermostat = new Thermostat();
        Command tempUp = new ThermostatIncreaseCommand(thermostat);
        Command tempDown = new ThermostatDecreaseCommand(thermostat);
        RemoteControl remote = new RemoteControl();

        int initialTemp = thermostat.getTemperature();

        remote.setCommand(tempUp);
        remote.pressButton();
        assertEquals(initialTemp + 1, thermostat.getTemperature());

        remote.pressUndo();
        assertEquals(initialTemp, thermostat.getTemperature());

        remote.setCommand(tempDown);
        remote.pressButton();
        assertEquals(initialTemp - 1, thermostat.getTemperature());

        remote.pressUndo();
        assertEquals(initialTemp, thermostat.getTemperature());
    }
}
