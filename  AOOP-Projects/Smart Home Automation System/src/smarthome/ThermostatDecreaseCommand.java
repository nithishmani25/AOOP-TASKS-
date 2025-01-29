package smarthome;

public class ThermostatDecreaseCommand implements Command {
    private Thermostat thermostat;

    public ThermostatDecreaseCommand(Thermostat thermostat) {
        this.thermostat = thermostat;
    }

    @Override
    public void execute() {
        thermostat.decreaseTemperature();
    }

    @Override
    public void undo() {
        thermostat.increaseTemperature();
    }
}
