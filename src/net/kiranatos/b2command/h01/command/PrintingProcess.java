package net.kiranatos.b2command.h01.command;

import net.kiranatos.b2command.h01.recivers.Product;

public abstract class PrintingProcess {    
    Product product;

    public PrintingProcess(Product prod) {
        this.product = prod;
    }
    
    public abstract void print();
}
