package net.kiranatos.b2command.h01.command;

import net.kiranatos.b2command.h01.recivers.Product;

public class PrintingPostcard extends PrintingProcess {

    public PrintingPostcard(Product prod) {
        super(prod);
    }

    @Override
    public void print() {
        System.out.println("Printing booklet");
    }
}
