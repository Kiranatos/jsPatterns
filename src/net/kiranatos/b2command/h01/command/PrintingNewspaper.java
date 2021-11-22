package net.kiranatos.b2command.h01.command;

import net.kiranatos.b2command.h01.recivers.Product;

public class PrintingNewspaper extends PrintingProcess {

    public PrintingNewspaper(Product prod) {
        super(prod);
    }

    @Override
    public void print() {
        System.out.println("Printing newspaper");
    }
}
