package net.zoungrana.services;

import net.zoungrana.aspects.Log;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    @Override
    @Log
    public void process() {
        System.out.println("Business Process....");
    }

    @Override
    @Log
    public double compute() {
        double data=78;
        System.out.println("Business Computing and returning...");
        return data;
    }
}
