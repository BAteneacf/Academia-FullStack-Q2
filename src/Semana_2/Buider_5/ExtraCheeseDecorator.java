package Semana_2.Buider_5;

public class ExtraCheeseDecorator extends PizzaDecorator {

    ExtraCheeseDecorator(PizzaOrder wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + Extra Queso";
    }

    @Override
    public double getPrice() {
        return wrapped.getPrice() + 2.50;
    }
}