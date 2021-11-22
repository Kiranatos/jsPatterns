package net.kiranatos.b2command.h01.command;

import net.kiranatos.b2command.h01.recivers.Product;

public class PrintingBook extends PrintingProcess {

    public PrintingBook(Product prod) {
        super(prod);
    }

    @Override
    public void print() {
        System.out.println("Printing book");
    }
}
