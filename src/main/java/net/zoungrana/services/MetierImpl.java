package net.zoungrana.services;

import net.zoungrana.aspects.Log;
import net.zoungrana.aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    @Override
    @Log
    @SecuredByAspect(roles={"ADMIN","USER"})
    public void process() {
        System.out.println("Business Process....");
    }

    @Override
    @Log
    @SecuredByAspect(roles={"ADMIN"})
    public double compute() {
        double data=78;
        System.out.println("Business Computing and returning...");
        return data;
    }
}
