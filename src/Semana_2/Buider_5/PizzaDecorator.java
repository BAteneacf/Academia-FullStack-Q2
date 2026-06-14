package Semana_2.Buider_5;

// ===== Decorator =====
public abstract class PizzaDecorator implements PizzaOrder {

    protected final PizzaOrder wrapped;

    PizzaDecorator(PizzaOrder wrapped) {
        this.wrapped = wrapped;
    }
}
