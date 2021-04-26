package de.schifi.cahcardgen.generator;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestMessages extends TestWatcher {

    @Override
    protected void succeeded(Description description) {
        System.out.println("passed");
    }

    @Override
    protected void failed(Throwable e, Description description) {
        System.out.println("FAILED!");
    }

    @Override
    protected void starting(Description description) {
        System.out.print(description.getMethodName() + " - ");
    }

    @Override
    protected void finished(Description description) {

    }

}
